package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C0237c.C0904f;
import com.google.android.gms.internal.jd.C0957a;
import com.google.android.gms.internal.kd;
import com.google.android.gms.tagmanager.C0982o.C0799f;
import com.google.android.gms.tagmanager.cr.C0385c;
import com.google.android.gms.tagmanager.cr.C0389g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cq implements C0799f {
    private final String TM;
    private bg<C0957a> Wi;
    private final ExecutorService Wp;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cq.1 */
    class C03801 implements Runnable {
        final /* synthetic */ cq Wq;

        C03801(cq cqVar) {
            this.Wq = cqVar;
        }

        public void run() {
            this.Wq.jC();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.2 */
    class C03812 implements Runnable {
        final /* synthetic */ cq Wq;
        final /* synthetic */ C0957a Wr;

        C03812(cq cqVar, C0957a c0957a) {
            this.Wq = cqVar;
            this.Wr = c0957a;
        }

        public void run() {
            this.Wq.m2887c(this.Wr);
        }
    }

    cq(Context context, String str) {
        this.mContext = context;
        this.TM = str;
        this.Wp = Executors.newSingleThreadExecutor();
    }

    private C0385c m2883a(ByteArrayOutputStream byteArrayOutputStream) {
        C0385c c0385c = null;
        try {
            c0385c = ba.br(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.m1265s("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
        } catch (JSONException e2) {
            bh.m1269w("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return c0385c;
    }

    private C0385c m2884k(byte[] bArr) {
        C0385c c0385c = null;
        try {
            c0385c = cr.m1307b(C0904f.m2522a(bArr));
        } catch (kd e) {
            bh.m1269w("Resource doesn't contain a binary container");
        } catch (C0389g e2) {
            bh.m1269w("Resource doesn't contain a binary container");
        }
        return c0385c;
    }

    public void m2885a(bg<C0957a> bgVar) {
        this.Wi = bgVar;
    }

    public void m2886b(C0957a c0957a) {
        this.Wp.execute(new C03812(this, c0957a));
    }

    public C0385c bP(int i) {
        bh.m1268v("Atttempting to load container from resource ID " + i);
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            cr.m1308b(openRawResource, byteArrayOutputStream);
            C0385c a = m2883a(byteArrayOutputStream);
            return a != null ? a : m2884k(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            bh.m1269w("Error reading default container resource with ID " + i);
            return null;
        } catch (NotFoundException e2) {
            bh.m1269w("No default container resource found.");
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m2887c(com.google.android.gms.internal.jd.C0957a r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.jD();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.ke.m1063d(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r0 = 1;
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.bh.m1266t(r1);
        goto L_0x0015;
    L_0x001d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1269w(r1);
        goto L_0x0015;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.bh.m1269w(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1269w(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1269w(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cq.c(com.google.android.gms.internal.jd$a):boolean");
    }

    public void iN() {
        this.Wp.execute(new C03801(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void jC() {
        /*
        r3 = this;
        r0 = r3.Wi;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.Wi;
        r0.iM();
        r0 = "Start loading resource from disk ...";
        com.google.android.gms.tagmanager.bh.m1268v(r0);
        r0 = com.google.android.gms.tagmanager.ce.ju();
        r0 = r0.jv();
        r1 = com.google.android.gms.tagmanager.ce.C0377a.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.ce.ju();
        r0 = r0.jv();
        r1 = com.google.android.gms.tagmanager.ce.C0377a.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.TM;
        r1 = com.google.android.gms.tagmanager.ce.ju();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.Wi;
        r1 = com.google.android.gms.tagmanager.bg.C0374a.NOT_AVAILABLE;
        r0.m1261a(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x006d }
        r0 = r3.jD();	 Catch:{ FileNotFoundException -> 0x006d }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x006d }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0082 }
        r0.<init>();	 Catch:{ IOException -> 0x0082 }
        com.google.android.gms.tagmanager.cr.m1308b(r1, r0);	 Catch:{ IOException -> 0x0082 }
        r2 = r3.Wi;	 Catch:{ IOException -> 0x0082 }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0082 }
        r0 = com.google.android.gms.internal.jd.C0957a.m2807l(r0);	 Catch:{ IOException -> 0x0082 }
        r2.m1262i(r0);	 Catch:{ IOException -> 0x0082 }
        r1.close();	 Catch:{ IOException -> 0x007b }
    L_0x0067:
        r0 = "Load resource from disk finished.";
        com.google.android.gms.tagmanager.bh.m1268v(r0);
        goto L_0x0045;
    L_0x006d:
        r0 = move-exception;
        r0 = "resource not on disk";
        com.google.android.gms.tagmanager.bh.m1265s(r0);
        r0 = r3.Wi;
        r1 = com.google.android.gms.tagmanager.bg.C0374a.NOT_AVAILABLE;
        r0.m1261a(r1);
        goto L_0x0045;
    L_0x007b:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1269w(r0);
        goto L_0x0067;
    L_0x0082:
        r0 = move-exception;
        r0 = "error reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1269w(r0);	 Catch:{ all -> 0x009a }
        r0 = r3.Wi;	 Catch:{ all -> 0x009a }
        r2 = com.google.android.gms.tagmanager.bg.C0374a.IO_ERROR;	 Catch:{ all -> 0x009a }
        r0.m1261a(r2);	 Catch:{ all -> 0x009a }
        r1.close();	 Catch:{ IOException -> 0x0093 }
        goto L_0x0067;
    L_0x0093:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1269w(r0);
        goto L_0x0067;
    L_0x009a:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x009f }
    L_0x009e:
        throw r0;
    L_0x009f:
        r1 = move-exception;
        r1 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1269w(r1);
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cq.jC():void");
    }

    File jD() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.TM);
    }

    public synchronized void release() {
        this.Wp.shutdown();
    }
}
