package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.af.C0567a;

/* renamed from: com.google.android.gms.internal.x */
public final class C0960x extends C0567a {
    private final AdListener lc;

    public C0960x(AdListener adListener) {
        this.lc = adListener;
    }

    public void onAdClosed() {
        this.lc.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.lc.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.lc.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.lc.onAdLoaded();
    }

    public void onAdOpened() {
        this.lc.onAdOpened();
    }
}
