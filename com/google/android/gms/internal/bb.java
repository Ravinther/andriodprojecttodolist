package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.bc.C0216a;

public final class bb implements C0216a {
    private final bf kH;
    private final C0673z kX;
    private final String mC;
    private final Context mContext;
    private final long mD;
    private final ax mE;
    private final ab mF;
    private final db mG;
    private bg mH;
    private int mI;
    private final Object mg;

    /* renamed from: com.google.android.gms.internal.bb.1 */
    class C02151 implements Runnable {
        final /* synthetic */ ba mJ;
        final /* synthetic */ bb mK;

        C02151(bb bbVar, ba baVar) {
            this.mK = bbVar;
            this.mJ = baVar;
        }

        public void run() {
            synchronized (this.mK.mg) {
                if (this.mK.mI != -2) {
                    return;
                }
                this.mK.mH = this.mK.ao();
                if (this.mK.mH == null) {
                    this.mK.m1685f(4);
                    return;
                }
                this.mJ.m2477a(this.mK);
                this.mK.m1678a(this.mJ);
            }
        }
    }

    public bb(Context context, String str, bf bfVar, ay ayVar, ax axVar, C0673z c0673z, ab abVar, db dbVar) {
        this.mg = new Object();
        this.mI = -2;
        this.mContext = context;
        this.mC = str;
        this.kH = bfVar;
        this.mD = ayVar.ms != -1 ? ayVar.ms : 10000;
        this.mE = axVar;
        this.kX = c0673z;
        this.mF = abVar;
        this.mG = dbVar;
    }

    private void m1677a(long j, long j2, long j3, long j4) {
        while (this.mI == -2) {
            m1681b(j, j2, j3, j4);
        }
    }

    private void m1678a(ba baVar) {
        try {
            if (this.mG.pW < 4100000) {
                if (this.mF.lo) {
                    this.mH.m437a(C0882c.m2446h(this.mContext), this.kX, this.mE.mq, baVar);
                } else {
                    this.mH.m435a(C0882c.m2446h(this.mContext), this.mF, this.kX, this.mE.mq, (bh) baVar);
                }
            } else if (this.mF.lo) {
                this.mH.m438a(C0882c.m2446h(this.mContext), this.kX, this.mE.mq, this.mE.adJson, (bh) baVar);
            } else {
                this.mH.m436a(C0882c.m2446h(this.mContext), this.mF, this.kX, this.mE.mq, this.mE.adJson, baVar);
            }
        } catch (Throwable e) {
            da.m560b("Could not request ad from mediation adapter.", e);
            m1685f(5);
        }
    }

    private bg ao() {
        da.m564u("Instantiating mediation adapter: " + this.mC);
        try {
            return this.kH.m434m(this.mC);
        } catch (Throwable e) {
            da.m559a("Could not instantiate mediation adapter: " + this.mC, e);
            return null;
        }
    }

    private void m1681b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            da.m564u("Timed out waiting for adapter.");
            this.mI = 3;
            return;
        }
        try {
            this.mg.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.mI = -1;
        }
    }

    public bc m1684b(long j, long j2) {
        bc bcVar;
        synchronized (this.mg) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ba baVar = new ba();
            cz.pT.post(new C02151(this, baVar));
            m1677a(elapsedRealtime, this.mD, j, j2);
            bcVar = new bc(this.mE, this.mH, this.mC, baVar, this.mI);
        }
        return bcVar;
    }

    public void cancel() {
        synchronized (this.mg) {
            try {
                if (this.mH != null) {
                    this.mH.destroy();
                }
            } catch (Throwable e) {
                da.m560b("Could not destroy mediation adapter.", e);
            }
            this.mI = -1;
            this.mg.notify();
        }
    }

    public void m1685f(int i) {
        synchronized (this.mg) {
            this.mI = i;
            this.mg.notify();
        }
    }
}
