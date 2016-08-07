package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Fields;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.di;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ac implements C0097d {
    private static final String ua;
    private final Context mContext;
    private C0101i rJ;
    private final C0098e rr;
    private final C0092a ub;
    private volatile C0107n uc;
    private final String ud;
    private ab ue;
    private long uf;
    private final int ug;

    /* renamed from: com.google.android.gms.analytics.ac.a */
    class C0092a extends SQLiteOpenHelper {
        final /* synthetic */ ac uh;
        private boolean ui;
        private long uj;

        C0092a(ac acVar, Context context, String str) {
            this.uh = acVar;
            super(context, str, null, 1);
            this.uj = 0;
        }

        private void m49a(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery.close();
            }
        }

        private boolean m50a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        aa.m47w("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                aa.m47w("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.ui || this.uj + 3600000 <= this.uh.rJ.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.ui = true;
                this.uj = this.uh.rJ.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.uh.mContext.getDatabasePath(this.uh.ud).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.ui = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C0109p.m77B(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m50a("hits2", db)) {
                m49a(db);
            } else {
                db.execSQL(ac.ua);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.analytics.ac.1 */
    class C05051 implements C0101i {
        final /* synthetic */ ac uh;

        C05051(ac acVar) {
            this.uh = acVar;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    static {
        ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    }

    ac(C0098e c0098e, Context context) {
        this(c0098e, context, "google_analytics_v4.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
    }

    ac(C0098e c0098e, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.ud = str;
        this.rr = c0098e;
        this.rJ = new C05051(this);
        this.ub = new C0092a(this, this.mContext, this.ud);
        this.uc = new ah(new DefaultHttpClient(), this.mContext);
        this.uf = 0;
        this.ug = i;
    }

    private SQLiteDatabase m1421G(String str) {
        try {
            return this.ub.getWritableDatabase();
        } catch (SQLiteException e) {
            aa.m47w(str);
            return null;
        }
    }

    private void m1423a(Map<String, String> map, long j, String str) {
        SQLiteDatabase G = m1421G("Error opening database for putHit");
        if (G != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m1427t((Map) map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey(Fields.ANDROID_APP_UID)) {
                try {
                    parseLong = Long.parseLong((String) map.get(Fields.ANDROID_APP_UID));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                aa.m47w("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                G.insert("hits2", null, contentValues);
                this.rr.m64p(false);
            } catch (SQLiteException e2) {
                aa.m47w("Error storing hit");
            }
        }
    }

    private void m1424a(Map<String, String> map, Collection<di> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (di diVar : collection) {
                if (Command.APPEND_VERSION.equals(diVar.getId())) {
                    map.put(substring, diVar.getValue());
                    return;
                }
            }
        }
    }

    private void co() {
        int cq = (cq() - this.ug) + 1;
        if (cq > 0) {
            List s = m1432s(cq);
            aa.m46v("Store full, deleting " + s.size() + " hits to make room.");
            m1429a((String[]) s.toArray(new String[0]));
        }
    }

    static String m1427t(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(C0126y.encode((String) entry.getKey()) + "=" + C0126y.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    public void m1428a(Map<String, String> map, long j, String str, Collection<di> collection) {
        cp();
        co();
        m1424a(map, collection);
        m1423a(map, j, str);
    }

    void m1429a(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            aa.m47w("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase G = m1421G("Error opening database for deleteHits.");
        if (G != null) {
            try {
                G.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C0098e c0098e = this.rr;
                if (cq() != 0) {
                    z = false;
                }
                c0098e.m64p(z);
            } catch (SQLiteException e) {
                aa.m47w("Error deleting hits " + strArr);
            }
        }
    }

    @Deprecated
    void m1430b(Collection<C0125x> collection) {
        if (collection == null || collection.isEmpty()) {
            aa.m47w("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (C0125x ci : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(ci.ci());
            i = i2;
        }
        m1429a(strArr);
    }

    public void bp() {
        boolean z = true;
        aa.m46v("Dispatch running...");
        if (this.uc.bA()) {
            List t = m1433t(40);
            if (t.isEmpty()) {
                aa.m46v("...nothing to dispatch");
                this.rr.m64p(true);
                return;
            }
            if (this.ue == null) {
                this.ue = new ab("_t=dispatch&_v=ma4.0.0", true);
            }
            if (cq() > t.size()) {
                z = false;
            }
            int a = this.uc.m73a(t, this.ue, z);
            aa.m46v("sent " + a + " of " + t.size() + " hits");
            m1430b(t.subList(0, Math.min(a, t.size())));
            if (a != t.size() || cq() <= 0) {
                this.ue = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    public C0107n bq() {
        return this.uc;
    }

    int cp() {
        boolean z = true;
        long currentTimeMillis = this.rJ.currentTimeMillis();
        if (currentTimeMillis <= this.uf + 86400000) {
            return 0;
        }
        this.uf = currentTimeMillis;
        SQLiteDatabase G = m1421G("Error opening database for deleteStaleHits.");
        if (G == null) {
            return 0;
        }
        int delete = G.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.rJ.currentTimeMillis() - 2592000000L)});
        C0098e c0098e = this.rr;
        if (cq() != 0) {
            z = false;
        }
        c0098e.m64p(z);
        return delete;
    }

    int cq() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m1421G("Error opening database for getNumStoredHits.");
        if (G != null) {
            try {
                cursor = G.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                aa.m47w("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public void m1431i(long j) {
        boolean z = true;
        SQLiteDatabase G = m1421G("Error opening database for clearHits");
        if (G != null) {
            if (j == 0) {
                G.delete("hits2", null, null);
            } else {
                G.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C0098e c0098e = this.rr;
            if (cq() != 0) {
                z = false;
            }
            c0098e.m64p(z);
        }
    }

    List<String> m1432s(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            aa.m47w("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase G = m1421G("Error opening database for peekHitIds.");
        if (G == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = G.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    aa.m47w("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            aa.m47w("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.C0125x> m1433t(int r16) {
        /*
        r15 = this;
        r10 = new java.util.ArrayList;
        r10.<init>();
        r1 = "Error opening database for peekHits";
        r1 = r15.m1421G(r1);
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        r1 = r10;
    L_0x000e:
        return r1;
    L_0x000f:
        r11 = 0;
        r2 = "hits2";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r4 = 1;
        r5 = "hit_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r12 = 0;
        r13 = "hit_id";
        r9[r12] = r13;	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
        r2 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        if (r2 == 0) goto L_0x005d;
    L_0x0044:
        r2 = new com.google.android.gms.analytics.x;	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r3 = 0;
        r4 = 0;
        r4 = r12.getLong(r4);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r6 = 1;
        r6 = r12.getLong(r6);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r2.<init>(r3, r4, r6);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r11.add(r2);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r2 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        if (r2 != 0) goto L_0x0044;
    L_0x005d:
        if (r12 == 0) goto L_0x0062;
    L_0x005f:
        r12.close();
    L_0x0062:
        r10 = 0;
        r2 = "hits2";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 1;
        r5 = "hit_string";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 2;
        r5 = "hit_url";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x0171 }
        r13 = 0;
        r14 = "hit_id";
        r9[r13] = r14;	 Catch:{ SQLiteException -> 0x0171 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x0171 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x0171 }
        r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0171 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        if (r1 == 0) goto L_0x00ca;
    L_0x0097:
        r3 = r10;
    L_0x0098:
        r0 = r2;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = r0;
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        if (r1 <= 0) goto L_0x00fe;
    L_0x00a6:
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = (com.google.android.gms.analytics.C0125x) r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r4 = 1;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1.m82E(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = (com.google.android.gms.analytics.C0125x) r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r4 = 2;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1.m83F(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
    L_0x00c2:
        r1 = r3 + 1;
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        if (r3 != 0) goto L_0x0185;
    L_0x00ca:
        if (r2 == 0) goto L_0x00cf;
    L_0x00cc:
        r2.close();
    L_0x00cf:
        r1 = r11;
        goto L_0x000e;
    L_0x00d2:
        r1 = move-exception;
        r2 = r1;
        r3 = r11;
        r1 = r10;
    L_0x00d6:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0176 }
        r4.<init>();	 Catch:{ all -> 0x0176 }
        r5 = "Error in peekHits fetching hitIds: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0176 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0176 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0176 }
        r2 = r2.toString();	 Catch:{ all -> 0x0176 }
        com.google.android.gms.analytics.aa.m47w(r2);	 Catch:{ all -> 0x0176 }
        if (r3 == 0) goto L_0x000e;
    L_0x00f2:
        r3.close();
        goto L_0x000e;
    L_0x00f7:
        r1 = move-exception;
    L_0x00f8:
        if (r11 == 0) goto L_0x00fd;
    L_0x00fa:
        r11.close();
    L_0x00fd:
        throw r1;
    L_0x00fe:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r1 = 1;
        r5 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r6 = 0;
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = (com.google.android.gms.analytics.C0125x) r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r7 = r1.ci();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r5[r6] = r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        com.google.android.gms.analytics.aa.m47w(r1);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        goto L_0x00c2;
    L_0x011c:
        r1 = move-exception;
        r12 = r2;
    L_0x011e:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
        r2.<init>();	 Catch:{ all -> 0x0167 }
        r3 = "Error in peekHits fetching hitString: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0167 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0167 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0167 }
        r1 = r1.toString();	 Catch:{ all -> 0x0167 }
        com.google.android.gms.analytics.aa.m47w(r1);	 Catch:{ all -> 0x0167 }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0167 }
        r2.<init>();	 Catch:{ all -> 0x0167 }
        r3 = 0;
        r4 = r11.iterator();	 Catch:{ all -> 0x0167 }
    L_0x0142:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0167 }
        if (r1 == 0) goto L_0x015a;
    L_0x0148:
        r1 = r4.next();	 Catch:{ all -> 0x0167 }
        r1 = (com.google.android.gms.analytics.C0125x) r1;	 Catch:{ all -> 0x0167 }
        r5 = r1.ch();	 Catch:{ all -> 0x0167 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0167 }
        if (r5 == 0) goto L_0x0163;
    L_0x0158:
        if (r3 == 0) goto L_0x0162;
    L_0x015a:
        if (r12 == 0) goto L_0x015f;
    L_0x015c:
        r12.close();
    L_0x015f:
        r1 = r2;
        goto L_0x000e;
    L_0x0162:
        r3 = 1;
    L_0x0163:
        r2.add(r1);	 Catch:{ all -> 0x0167 }
        goto L_0x0142;
    L_0x0167:
        r1 = move-exception;
    L_0x0168:
        if (r12 == 0) goto L_0x016d;
    L_0x016a:
        r12.close();
    L_0x016d:
        throw r1;
    L_0x016e:
        r1 = move-exception;
        r12 = r2;
        goto L_0x0168;
    L_0x0171:
        r1 = move-exception;
        goto L_0x011e;
    L_0x0173:
        r1 = move-exception;
        r11 = r12;
        goto L_0x00f8;
    L_0x0176:
        r1 = move-exception;
        r11 = r3;
        goto L_0x00f8;
    L_0x0179:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r10;
        goto L_0x00d6;
    L_0x017f:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r11;
        goto L_0x00d6;
    L_0x0185:
        r3 = r1;
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ac.t(int):java.util.List<com.google.android.gms.analytics.x>");
    }
}
