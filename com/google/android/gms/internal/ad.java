package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ai.C0573a;

public final class ad extends C0573a {
    private final AppEventListener lq;

    public ad(AppEventListener appEventListener) {
        this.lq = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.lq.onAppEvent(name, info);
    }
}
