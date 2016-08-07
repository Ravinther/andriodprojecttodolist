package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0124u.C0123a;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.analytics.r */
class C0512r extends af {
    private static final Object ri;
    private static C0512r ru;
    private Context mContext;
    private Handler mHandler;
    private C0097d rj;
    private volatile C0099f rk;
    private int rl;
    private boolean rm;
    private boolean rn;
    private String ro;
    private boolean rp;
    private boolean rq;
    private C0098e rr;
    private C0110q rs;
    private boolean rt;

    /* renamed from: com.google.android.gms.analytics.r.2 */
    class C01112 implements Callback {
        final /* synthetic */ C0512r rv;

        C01112(C0512r c0512r) {
            this.rv = c0512r;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C0512r.ri.equals(msg.obj)) {
                C0124u.bR().m81r(true);
                this.rv.dispatchLocalHits();
                C0124u.bR().m81r(false);
                if (this.rv.rl > 0 && !this.rv.rt) {
                    this.rv.mHandler.sendMessageDelayed(this.rv.mHandler.obtainMessage(1, C0512r.ri), (long) (this.rv.rl * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.analytics.r.1 */
    class C05111 implements C0098e {
        final /* synthetic */ C0512r rv;

        C05111(C0512r c0512r) {
            this.rv = c0512r;
        }

        public void m1465p(boolean z) {
            this.rv.m1471a(z, this.rv.rp);
        }
    }

    static {
        ri = new Object();
    }

    private C0512r() {
        this.rl = 1800;
        this.rm = true;
        this.rp = true;
        this.rq = true;
        this.rr = new C05111(this);
        this.rt = false;
    }

    public static C0512r bB() {
        if (ru == null) {
            ru = new C0512r();
        }
        return ru;
    }

    private void bC() {
        this.rs = new C0110q(this);
        this.rs.m79o(this.mContext);
    }

    private void bD() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C01112(this));
        if (this.rl > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, ri), (long) (this.rl * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
        }
    }

    synchronized void m1470a(Context context, C0099f c0099f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.rk == null) {
                this.rk = c0099f;
                if (this.rm) {
                    dispatchLocalHits();
                    this.rm = false;
                }
                if (this.rn) {
                    br();
                    this.rn = false;
                }
            }
        }
    }

    synchronized void m1471a(boolean z, boolean z2) {
        if (!(this.rt == z && this.rp == z2)) {
            if (z || !z2) {
                if (this.rl > 0) {
                    this.mHandler.removeMessages(1, ri);
                }
            }
            if (!z && z2 && this.rl > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, ri), (long) (this.rl * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.m46v(append.append(str).toString());
            this.rt = z;
            this.rp = z2;
        }
    }

    synchronized C0097d bE() {
        if (this.rj == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.rj = new ac(this.rr, this.mContext);
            if (this.ro != null) {
                this.rj.bq().m72A(this.ro);
                this.ro = null;
            }
        }
        if (this.mHandler == null) {
            bD();
        }
        if (this.rs == null && this.rq) {
            bC();
        }
        return this.rj;
    }

    synchronized void bF() {
        if (!this.rt && this.rp && this.rl > 0) {
            this.mHandler.removeMessages(1, ri);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, ri));
        }
    }

    void br() {
        if (this.rk == null) {
            aa.m46v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.rn = true;
            return;
        }
        C0124u.bR().m80a(C0123a.SET_FORCE_LOCAL_DISPATCH);
        this.rk.br();
    }

    synchronized void dispatchLocalHits() {
        if (this.rk == null) {
            aa.m46v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.rm = true;
        } else {
            C0124u.bR().m80a(C0123a.DISPATCH);
            this.rk.bp();
        }
    }

    synchronized void m1472q(boolean z) {
        m1471a(this.rt, z);
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.m46v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.rl = dispatchPeriodInSeconds;
        } else {
            C0124u.bR().m80a(C0123a.SET_DISPATCH_PERIOD);
            if (!this.rt && this.rp && this.rl > 0) {
                this.mHandler.removeMessages(1, ri);
            }
            this.rl = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.rt && this.rp) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, ri), (long) (dispatchPeriodInSeconds * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
        }
    }
}
