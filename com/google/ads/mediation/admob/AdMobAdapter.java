package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.cz;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {
    private AdView f62h;
    private InterstitialAd f63i;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C0484a extends AdListener {
        private final AdMobAdapter f54j;
        private final MediationBannerListener f55k;

        public C0484a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f54j = adMobAdapter;
            this.f55k = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f55k.onDismissScreen(this.f54j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f55k.onFailedToReceiveAd(this.f54j, bk.m445h(errorCode));
        }

        public void onAdLeftApplication() {
            this.f55k.onLeaveApplication(this.f54j);
        }

        public void onAdLoaded() {
            this.f55k.onReceivedAd(this.f54j);
        }

        public void onAdOpened() {
            this.f55k.onClick(this.f54j);
            this.f55k.onPresentScreen(this.f54j);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C0485b extends AdListener {
        private final AdMobAdapter f56j;
        private final MediationInterstitialListener f57l;

        public C0485b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f56j = adMobAdapter;
            this.f57l = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f57l.onDismissScreen(this.f56j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f57l.onFailedToReceiveAd(this.f56j, bk.m445h(errorCode));
        }

        public void onAdLeftApplication() {
            this.f57l.onLeaveApplication(this.f56j);
        }

        public void onAdLoaded() {
            this.f57l.onReceivedAd(this.f56j);
        }

        public void onAdOpened() {
            this.f57l.onPresentScreen(this.f56j);
        }
    }

    private static AdRequest m2402a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        NetworkExtras adMobExtras2;
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        Gender gender = mediationAdRequest.getGender();
        if (gender != null) {
            builder.setGender(bk.m441a(gender));
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(cz.m557l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            builder.tagForChildDirectedTreatment(adMobServerParameters.tagForChildDirectedTreatment == 1);
        }
        if (adMobExtras == null) {
            adMobExtras2 = new AdMobExtras(new Bundle());
        }
        Bundle extras = adMobExtras2.getExtras();
        extras.putInt("gw", 1);
        extras.putString("mad_hac", adMobServerParameters.allowHouseAds);
        if (!TextUtils.isEmpty(adMobServerParameters.adJson)) {
            extras.putString("_ad", adMobServerParameters.adJson);
        }
        extras.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras2);
        return builder.build();
    }

    public void destroy() {
        if (this.f62h != null) {
            this.f62h.destroy();
            this.f62h = null;
        }
        if (this.f63i != null) {
            this.f63i = null;
        }
    }

    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    public View getBannerView() {
        return this.f62h;
    }

    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener bannerListener, Activity activity, AdMobServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f62h = new AdView(activity);
        this.f62h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f62h.setAdUnitId(serverParameters.adUnitId);
        this.f62h.setAdListener(new C0484a(this, bannerListener));
        this.f62h.loadAd(m2402a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(MediationInterstitialListener interstitialListener, Activity activity, AdMobServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f63i = new InterstitialAd(activity);
        this.f63i.setAdUnitId(serverParameters.adUnitId);
        this.f63i.setAdListener(new C0485b(this, interstitialListener));
        this.f63i.loadAd(m2402a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f63i.show();
    }
}
