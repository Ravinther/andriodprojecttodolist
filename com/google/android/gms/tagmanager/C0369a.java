package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C0369a {
    private static C0369a TA;
    private static Object qI;
    private volatile long Tv;
    private volatile long Tw;
    private volatile long Tx;
    private final fl Ty;
    private C0368a Tz;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread pI;
    private volatile Info qK;

    /* renamed from: com.google.android.gms.tagmanager.a.2 */
    class C03672 implements Runnable {
        final /* synthetic */ C0369a TB;

        C03672(C0369a c0369a) {
            this.TB = c0369a;
        }

        public void run() {
            this.TB.iv();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a.a */
    public interface C0368a {
        Info ix();
    }

    /* renamed from: com.google.android.gms.tagmanager.a.1 */
    class C07721 implements C0368a {
        final /* synthetic */ C0369a TB;

        C07721(C0369a c0369a) {
            this.TB = c0369a;
        }

        public Info ix() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.TB.mContext);
            } catch (IllegalStateException e) {
                bh.m1269w("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m1269w("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m1269w("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m1269w("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m1269w("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    static {
        qI = new Object();
    }

    private C0369a(Context context) {
        this(context, null, fn.eI());
    }

    C0369a(Context context, C0368a c0368a, fl flVar) {
        this.Tv = 900000;
        this.Tw = 30000;
        this.mClosed = false;
        this.Tz = new C07721(this);
        this.Ty = flVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c0368a != null) {
            this.Tz = c0368a;
        }
        this.pI = new Thread(new C03672(this));
    }

    static C0369a m1238E(Context context) {
        if (TA == null) {
            synchronized (qI) {
                if (TA == null) {
                    TA = new C0369a(context);
                    TA.start();
                }
            }
        }
        return TA;
    }

    private void iv() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.qK = this.Tz.ix();
                Thread.sleep(this.Tv);
            } catch (InterruptedException e) {
                bh.m1267u("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void iw() {
        if (this.Ty.currentTimeMillis() - this.Tx >= this.Tw) {
            interrupt();
            this.Tx = this.Ty.currentTimeMillis();
        }
    }

    void interrupt() {
        this.pI.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        iw();
        return this.qK == null ? true : this.qK.isLimitAdTrackingEnabled();
    }

    public String iu() {
        iw();
        return this.qK == null ? null : this.qK.getId();
    }

    void start() {
        this.pI.start();
    }
}
