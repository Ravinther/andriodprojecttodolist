package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class al {
    private final be lF;
    private ag lG;
    private AdListener lc;
    private AppEventListener lq;
    private String ls;
    private final Context mContext;

    public al(Context context) {
        this.lF = new be();
        this.mContext = context;
    }

    private void m416k(String str) throws RemoteException {
        if (this.ls == null) {
            m417l(str);
        }
        this.lG = C0672y.m2139a(this.mContext, new ab(), this.ls, this.lF);
        if (this.lc != null) {
            this.lG.m390a(new C0960x(this.lc));
        }
        if (this.lq != null) {
            this.lG.m391a(new ad(this.lq));
        }
    }

    private void m417l(String str) {
        if (this.lG == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void m418a(aj ajVar) {
        try {
            if (this.lG == null) {
                m416k("loadAd");
            }
            if (this.lG.m392a(new C0673z(this.mContext, ajVar))) {
                this.lF.m2479c(ajVar.ak());
            }
        } catch (Throwable e) {
            da.m560b("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lc;
    }

    public String getAdUnitId() {
        return this.ls;
    }

    public AppEventListener getAppEventListener() {
        return this.lq;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.lG != null) {
                z = this.lG.isReady();
            }
        } catch (Throwable e) {
            da.m560b("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.lc = adListener;
            if (this.lG != null) {
                this.lG.m390a(adListener != null ? new C0960x(adListener) : null);
            }
        } catch (Throwable e) {
            da.m560b("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.ls != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.ls = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.lq = appEventListener;
            if (this.lG != null) {
                this.lG.m391a(appEventListener != null ? new ad(appEventListener) : null);
            }
        } catch (Throwable e) {
            da.m560b("Failed to set the AppEventListener.", e);
        }
    }

    public void show() {
        try {
            m417l("show");
            this.lG.showInterstitial();
        } catch (Throwable e) {
            da.m560b("Failed to show interstitial.", e);
        }
    }
}
