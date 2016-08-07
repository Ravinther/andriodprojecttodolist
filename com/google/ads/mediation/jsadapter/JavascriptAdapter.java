package com.google.ads.mediation.jsadapter;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.EmptyNetworkExtras;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.da;

public final class JavascriptAdapter implements MediationBannerAdapter<EmptyNetworkExtras, JavascriptServerParameters> {
    private WebView f72C;
    private FrameLayout f73D;
    private boolean f74E;
    private MediationBannerListener f75k;
    private int f76v;
    private int f77w;

    public void destroy() {
        this.f74E = true;
    }

    public Class<EmptyNetworkExtras> getAdditionalParametersType() {
        return EmptyNetworkExtras.class;
    }

    public View getBannerView() {
        return this.f73D;
    }

    public Class<JavascriptServerParameters> getServerParametersType() {
        return JavascriptServerParameters.class;
    }

    public WebView getWebView() {
        return this.f72C;
    }

    public int getWebViewHeight() {
        return this.f76v;
    }

    public int getWebViewWidth() {
        return this.f77w;
    }

    public void passbackReceived() {
        da.m562s("Passback received");
        sendAdNotReceivedUpdate();
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, JavascriptServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, EmptyNetworkExtras extras) {
        this.f75k = listener;
        this.f76v = serverParameters.height != null ? serverParameters.height.intValue() : adSize.getHeightInPixels(activity);
        this.f77w = serverParameters.width != null ? serverParameters.width.intValue() : adSize.getWidthInPixels(activity);
        this.f74E = false;
        this.f72C = new WebView(activity);
        this.f72C.getSettings().setJavaScriptEnabled(true);
        this.f72C.setWebViewClient(new BannerWebViewClient(this, serverParameters.passBackUrl));
        this.f72C.setBackgroundColor(0);
        this.f73D = new FrameLayout(activity);
        this.f73D.addView(this.f72C, new LayoutParams(this.f77w, this.f76v, 17));
        this.f72C.loadDataWithBaseURL(null, serverParameters.htmlScript, "text/html", "utf-8", null);
    }

    public void sendAdNotReceivedUpdate() {
        if (!this.f74E) {
            this.f74E = true;
            this.f75k.onFailedToReceiveAd(this, ErrorCode.NO_FILL);
        }
    }

    public void sendAdReceivedUpdate() {
        if (!this.f74E) {
            this.f74E = true;
            this.f75k.onReceivedAd(this);
        }
    }

    public boolean shouldStopAdCheck() {
        return this.f74E;
    }

    public void startCheckingForAd() {
        new AdViewCheckTask(this, 200, 100).start();
    }
}
