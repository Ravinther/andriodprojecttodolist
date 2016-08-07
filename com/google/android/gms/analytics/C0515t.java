package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Fields;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.internal.di;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.t */
class C0515t extends Thread implements C0099f {
    private static C0515t sd;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile String qX;
    private final LinkedBlockingQueue<Runnable> rZ;
    private volatile boolean sa;
    private volatile List<di> sb;
    private volatile String sc;
    private volatile ag se;

    /* renamed from: com.google.android.gms.analytics.t.1 */
    class C01191 implements Runnable {
        final /* synthetic */ Map sf;
        final /* synthetic */ C0515t sg;

        C01191(C0515t c0515t, Map map) {
            this.sg = c0515t;
            this.sf = map;
        }

        public void run() {
            if (TextUtils.isEmpty((CharSequence) this.sf.get(Fields.CLIENT_ID))) {
                this.sf.put(Fields.CLIENT_ID, this.sg.qX);
            }
            if (!GoogleAnalytics.getInstance(this.sg.mContext).getAppOptOut() && !this.sg.m1499p(this.sf)) {
                if (!TextUtils.isEmpty(this.sg.sc)) {
                    C0124u.bR().m81r(true);
                    this.sf.putAll(new HitBuilder().setCampaignParamsFromUrl(this.sg.sc).build());
                    C0124u.bR().m81r(false);
                    this.sg.sc = null;
                }
                this.sg.m1503r(this.sf);
                this.sg.m1501q(this.sf);
                this.sg.se.m52b(C0126y.m85s(this.sf), Long.valueOf((String) this.sf.get("&ht")).longValue(), this.sg.m1498o(this.sf), this.sg.sb);
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.2 */
    class C01202 implements Runnable {
        final /* synthetic */ C0515t sg;

        C01202(C0515t c0515t) {
            this.sg = c0515t;
        }

        public void run() {
            this.sg.se.bp();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.3 */
    class C01213 implements Runnable {
        final /* synthetic */ C0515t sg;

        C01213(C0515t c0515t) {
            this.sg = c0515t;
        }

        public void run() {
            this.sg.se.bk();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.4 */
    class C01224 implements Runnable {
        final /* synthetic */ C0515t sg;

        C01224(C0515t c0515t) {
            this.sg = c0515t;
        }

        public void run() {
            this.sg.se.br();
        }
    }

    private C0515t(Context context) {
        super("GAThread");
        this.rZ = new LinkedBlockingQueue();
        this.sa = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static int m1486C(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private String m1489a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private String m1498o(Map<String, String> map) {
        return map.containsKey(Fields.USE_SECURE) ? ak.m58d((String) map.get(Fields.USE_SECURE), true) ? "https:" : "http:" : "https:";
    }

    private boolean m1499p(Map<String, String> map) {
        if (map.get(Fields.SAMPLE_RATE) == null) {
            return false;
        }
        double a = ak.m55a((String) map.get(Fields.SAMPLE_RATE), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (C0515t.m1486C((String) map.get(Fields.CLIENT_ID)) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get(Fields.HIT_TYPE) == null ? EnvironmentCompat.MEDIA_UNKNOWN : (String) map.get(Fields.HIT_TYPE);
        aa.m46v(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    static C0515t m1500q(Context context) {
        if (sd == null) {
            sd = new C0515t(context);
        }
        return sd;
    }

    private void m1501q(Map<String, String> map) {
        C0106m m = C0504a.m1420m(this.mContext);
        ak.m57a(map, "&adid", m.getValue("&adid"));
        ak.m57a(map, "&ate", m.getValue("&ate"));
    }

    static String m1502r(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            int read = openFileInput.read(bArr, 0, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
            if (openFileInput.available() > 0) {
                aa.m44t("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.m47w("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.m45u("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.m45u("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.m44t("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private void m1503r(Map<String, String> map) {
        C0106m bt = C0508g.bt();
        ak.m57a(map, Fields.APP_NAME, bt.getValue(Fields.APP_NAME));
        ak.m57a(map, Fields.APP_VERSION, bt.getValue(Fields.APP_VERSION));
        ak.m57a(map, Fields.APP_ID, bt.getValue(Fields.APP_ID));
        ak.m57a(map, Fields.APP_INSTALLER_ID, bt.getValue(Fields.APP_INSTALLER_ID));
        map.put("&v", "1");
    }

    void m1504a(Runnable runnable) {
        this.rZ.add(runnable);
    }

    public void bk() {
        m1504a(new C01213(this));
    }

    public void bp() {
        m1504a(new C01202(this));
    }

    public void br() {
        m1504a(new C01224(this));
    }

    public LinkedBlockingQueue<Runnable> bs() {
        return this.rZ;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.se.bI();
        this.sb = new ArrayList();
        this.sb.add(new di(Command.APPEND_VERSION, "&_v".substring(1), "ma4.0.0"));
        this.sb.add(new di(Command.APPEND_QUEUE_TIME, "&qt".substring(1), null));
        this.sb.add(new di(Command.APPEND_CACHE_BUSTER, "&z".substring(1), null));
    }

    public void m1505n(Map<String, String> map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m1504a(new C01191(this, hashMap));
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.m47w("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.se == null) {
                this.se = new C0514s(this.mContext, this);
            }
            init();
            this.qX = C0509h.bu().getValue(Fields.CLIENT_ID);
            if (this.qX == null) {
                this.sa = true;
            }
            this.sc = C0515t.m1502r(this.mContext);
            aa.m46v("Initialized GA Thread");
        } catch (Throwable th) {
            aa.m44t("Error initializing the GAThread: " + m1489a(th));
            aa.m44t("Google Analytics will not start up.");
            this.sa = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.rZ.take();
                if (!this.sa) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.m45u(e2.toString());
            } catch (Throwable th2) {
                aa.m44t("Error on GAThread: " + m1489a(th2));
                aa.m44t("Google Analytics is shutting down.");
                this.sa = true;
            }
        }
    }
}
