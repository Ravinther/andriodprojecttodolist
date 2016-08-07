package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.da;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f69m;
    private CustomEventBanner f70n;
    private CustomEventInterstitial f71o;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C0832a implements CustomEventBannerListener {
        private final MediationBannerListener f64k;
        private final CustomEventAdapter f65p;

        public C0832a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f65p = customEventAdapter;
            this.f64k = mediationBannerListener;
        }

        public void onClick() {
            da.m562s("Custom event adapter called onFailedToReceiveAd.");
            this.f64k.onClick(this.f65p);
        }

        public void onDismissScreen() {
            da.m562s("Custom event adapter called onFailedToReceiveAd.");
            this.f64k.onDismissScreen(this.f65p);
        }

        public void onFailedToReceiveAd() {
            da.m562s("Custom event adapter called onFailedToReceiveAd.");
            this.f64k.onFailedToReceiveAd(this.f65p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            da.m562s("Custom event adapter called onFailedToReceiveAd.");
            this.f64k.onLeaveApplication(this.f65p);
        }

        public void onPresentScreen() {
            da.m562s("Custom event adapter called onFailedToReceiveAd.");
            this.f64k.onPresentScreen(this.f65p);
        }

        public void onReceivedAd(View view) {
            da.m562s("Custom event adapter called onReceivedAd.");
            this.f65p.m2404a(view);
            this.f64k.onReceivedAd(this.f65p);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0833b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f66l;
        private final CustomEventAdapter f67p;
        final /* synthetic */ CustomEventAdapter f68q;

        public C0833b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f68q = customEventAdapter;
            this.f67p = customEventAdapter2;
            this.f66l = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            da.m562s("Custom event adapter called onDismissScreen.");
            this.f66l.onDismissScreen(this.f67p);
        }

        public void onFailedToReceiveAd() {
            da.m562s("Custom event adapter called onFailedToReceiveAd.");
            this.f66l.onFailedToReceiveAd(this.f67p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            da.m562s("Custom event adapter called onLeaveApplication.");
            this.f66l.onLeaveApplication(this.f67p);
        }

        public void onPresentScreen() {
            da.m562s("Custom event adapter called onPresentScreen.");
            this.f66l.onPresentScreen(this.f67p);
        }

        public void onReceivedAd() {
            da.m562s("Custom event adapter called onReceivedAd.");
            this.f66l.onReceivedAd(this.f68q);
        }
    }

    private static <T> T m2403a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            da.m566w("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m2404a(View view) {
        this.f69m = view;
    }

    public void destroy() {
        if (this.f70n != null) {
            this.f70n.destroy();
        }
        if (this.f71o != null) {
            this.f71o.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f69m;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f70n = (CustomEventBanner) m2403a(serverParameters.className);
        if (this.f70n == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f70n.requestBannerAd(new C0832a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f71o = (CustomEventInterstitial) m2403a(serverParameters.className);
        if (this.f71o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f71o.requestInterstitialAd(new C0833b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f71o.showInterstitial();
    }
}
