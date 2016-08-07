package com.google.android.gms.internal;

import com.google.android.gms.internal.bc.C0216a;
import com.google.android.gms.internal.bh.C0586a;

public final class ba extends C0586a {
    private C0216a mA;
    private az mB;
    private final Object mg;

    public ba() {
        this.mg = new Object();
    }

    public void m2475O() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m426U();
            }
        }
    }

    public void m2476a(az azVar) {
        synchronized (this.mg) {
            this.mB = azVar;
        }
    }

    public void m2477a(C0216a c0216a) {
        synchronized (this.mg) {
            this.mA = c0216a;
        }
    }

    public void onAdClosed() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m427V();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.mg) {
            if (this.mA != null) {
                this.mA.m431f(error == 3 ? 1 : 2);
                this.mA = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m428W();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.mg) {
            if (this.mA != null) {
                this.mA.m431f(0);
                this.mA = null;
                return;
            }
            if (this.mB != null) {
                this.mB.m430Y();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m429X();
            }
        }
    }
}
