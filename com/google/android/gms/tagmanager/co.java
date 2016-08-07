package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0237c.C0908j;
import com.google.android.gms.tagmanager.bg.C0374a;
import com.google.android.gms.tagmanager.ce.C0377a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class co implements Runnable {
    private final String TM;
    private volatile String Ui;
    private final bm Wg;
    private final String Wh;
    private bg<C0908j> Wi;
    private volatile C0405r Wj;
    private volatile String Wk;
    private final Context mContext;

    co(Context context, String str, bm bmVar, C0405r c0405r) {
        this.mContext = context;
        this.Wg = bmVar;
        this.TM = str;
        this.Wj = c0405r;
        this.Wh = "/r?id=" + str;
        this.Ui = this.Wh;
        this.Wk = null;
    }

    public co(Context context, String str, C0405r c0405r) {
        this(context, str, new bm(), c0405r);
    }

    private boolean jx() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1268v("...no network connectivity");
        return false;
    }

    private void jy() {
        if (jx()) {
            bh.m1268v("Start loading resource from network ...");
            String jz = jz();
            bl ji = this.Wg.ji();
            try {
                InputStream bo = ji.bo(jz);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cr.m1308b(bo, byteArrayOutputStream);
                    C0908j b = C0908j.m2545b(byteArrayOutputStream.toByteArray());
                    bh.m1268v("Successfully loaded supplemented resource: " + b);
                    if (b.fV == null && b.fU.length == 0) {
                        bh.m1268v("No change for container: " + this.TM);
                    }
                    this.Wi.m1262i(b);
                    bh.m1268v("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m1263b("Error when parsing downloaded resources from url: " + jz + " " + e.getMessage(), e);
                    this.Wi.m1261a(C0374a.SERVER_ERROR);
                    ji.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m1269w("No data is retrieved from the given url: " + jz + ". Make sure container_id: " + this.TM + " is correct.");
                this.Wi.m1261a(C0374a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m1263b("Error when loading resources from url: " + jz + " " + e3.getMessage(), e3);
                this.Wi.m1261a(C0374a.IO_ERROR);
            } finally {
                ji.close();
            }
        } else {
            this.Wi.m1261a(C0374a.NOT_AVAILABLE);
        }
    }

    void m1290a(bg<C0908j> bgVar) {
        this.Wi = bgVar;
    }

    void bf(String str) {
        if (str == null) {
            this.Ui = this.Wh;
            return;
        }
        bh.m1265s("Setting CTFE URL path: " + str);
        this.Ui = str;
    }

    void bu(String str) {
        bh.m1265s("Setting previous container version: " + str);
        this.Wk = str;
    }

    String jz() {
        String str = this.Wj.iO() + this.Ui + "&v=a59512756";
        if (!(this.Wk == null || this.Wk.trim().equals(""))) {
            str = str + "&pv=" + this.Wk;
        }
        return ce.ju().jv().equals(C0377a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.Wi == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.Wi.iM();
        jy();
    }
}
