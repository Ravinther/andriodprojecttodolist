package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.w */
public final class C0308w {
    private final Runnable kW;
    private C0673z kX;
    private boolean kY;

    /* renamed from: com.google.android.gms.internal.w.1 */
    class C03071 implements Runnable {
        private final WeakReference<C0959v> kZ;
        final /* synthetic */ C0959v la;
        final /* synthetic */ C0308w lb;

        C03071(C0308w c0308w, C0959v c0959v) {
            this.lb = c0308w;
            this.la = c0959v;
            this.kZ = new WeakReference(this.la);
        }

        public void run() {
            this.lb.kY = false;
            C0959v c0959v = (C0959v) this.kZ.get();
            if (c0959v != null) {
                c0959v.m2841b(this.lb.kX);
            }
        }
    }

    public C0308w(C0959v c0959v) {
        this.kY = false;
        this.kW = new C03071(this, c0959v);
    }

    public void m1109a(C0673z c0673z, long j) {
        if (this.kY) {
            da.m566w("An ad refresh is already scheduled.");
            return;
        }
        da.m564u("Scheduling ad refresh " + j + " milliseconds from now.");
        this.kX = c0673z;
        this.kY = true;
        cz.pT.postDelayed(this.kW, j);
    }

    public void cancel() {
        cz.pT.removeCallbacks(this.kW);
    }

    public void m1110d(C0673z c0673z) {
        m1109a(c0673z, 60000);
    }
}
