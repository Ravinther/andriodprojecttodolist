package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class bj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final bh mT;

    /* renamed from: com.google.android.gms.internal.bj.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ bj mU;
        final /* synthetic */ ErrorCode mV;

        AnonymousClass10(bj bjVar, ErrorCode errorCode) {
            this.mU = bjVar;
            this.mV = errorCode;
        }

        public void run() {
            try {
                this.mU.mT.onAdFailedToLoad(bk.m440a(this.mV));
            } catch (Throwable e) {
                da.m560b("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.1 */
    class C02171 implements Runnable {
        final /* synthetic */ bj mU;

        C02171(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.m439O();
            } catch (Throwable e) {
                da.m560b("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.2 */
    class C02182 implements Runnable {
        final /* synthetic */ bj mU;

        C02182(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdOpened();
            } catch (Throwable e) {
                da.m560b("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.3 */
    class C02193 implements Runnable {
        final /* synthetic */ bj mU;

        C02193(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdLoaded();
            } catch (Throwable e) {
                da.m560b("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.4 */
    class C02204 implements Runnable {
        final /* synthetic */ bj mU;

        C02204(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdClosed();
            } catch (Throwable e) {
                da.m560b("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.5 */
    class C02215 implements Runnable {
        final /* synthetic */ bj mU;
        final /* synthetic */ ErrorCode mV;

        C02215(bj bjVar, ErrorCode errorCode) {
            this.mU = bjVar;
            this.mV = errorCode;
        }

        public void run() {
            try {
                this.mU.mT.onAdFailedToLoad(bk.m440a(this.mV));
            } catch (Throwable e) {
                da.m560b("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.6 */
    class C02226 implements Runnable {
        final /* synthetic */ bj mU;

        C02226(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdLeftApplication();
            } catch (Throwable e) {
                da.m560b("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.7 */
    class C02237 implements Runnable {
        final /* synthetic */ bj mU;

        C02237(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdOpened();
            } catch (Throwable e) {
                da.m560b("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.8 */
    class C02248 implements Runnable {
        final /* synthetic */ bj mU;

        C02248(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdLoaded();
            } catch (Throwable e) {
                da.m560b("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.9 */
    class C02259 implements Runnable {
        final /* synthetic */ bj mU;

        C02259(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdClosed();
            } catch (Throwable e) {
                da.m560b("Could not call onAdClosed.", e);
            }
        }
    }

    public bj(bh bhVar) {
        this.mT = bhVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m562s("Adapter called onClick.");
        if (cz.aX()) {
            try {
                this.mT.m439O();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdClicked.", e);
                return;
            }
        }
        da.m566w("onClick must be called on the main UI thread.");
        cz.pT.post(new C02171(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m562s("Adapter called onDismissScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdClosed();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdClosed.", e);
                return;
            }
        }
        da.m566w("onDismissScreen must be called on the main UI thread.");
        cz.pT.post(new C02204(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m562s("Adapter called onDismissScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdClosed();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdClosed.", e);
                return;
            }
        }
        da.m566w("onDismissScreen must be called on the main UI thread.");
        cz.pT.post(new C02259(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        da.m562s("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (cz.aX()) {
            try {
                this.mT.onAdFailedToLoad(bk.m440a(errorCode));
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        da.m566w("onFailedToReceiveAd must be called on the main UI thread.");
        cz.pT.post(new C02215(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        da.m562s("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (cz.aX()) {
            try {
                this.mT.onAdFailedToLoad(bk.m440a(errorCode));
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        da.m566w("onFailedToReceiveAd must be called on the main UI thread.");
        cz.pT.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m562s("Adapter called onLeaveApplication.");
        if (cz.aX()) {
            try {
                this.mT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        da.m566w("onLeaveApplication must be called on the main UI thread.");
        cz.pT.post(new C02226(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m562s("Adapter called onLeaveApplication.");
        if (cz.aX()) {
            try {
                this.mT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        da.m566w("onLeaveApplication must be called on the main UI thread.");
        cz.pT.post(new Runnable() {
            final /* synthetic */ bj mU;

            {
                this.mU = r1;
            }

            public void run() {
                try {
                    this.mU.mT.onAdLeftApplication();
                } catch (Throwable e) {
                    da.m560b("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m562s("Adapter called onPresentScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdOpened();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdOpened.", e);
                return;
            }
        }
        da.m566w("onPresentScreen must be called on the main UI thread.");
        cz.pT.post(new C02237(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m562s("Adapter called onPresentScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdOpened();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdOpened.", e);
                return;
            }
        }
        da.m566w("onPresentScreen must be called on the main UI thread.");
        cz.pT.post(new C02182(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m562s("Adapter called onReceivedAd.");
        if (cz.aX()) {
            try {
                this.mT.onAdLoaded();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdLoaded.", e);
                return;
            }
        }
        da.m566w("onReceivedAd must be called on the main UI thread.");
        cz.pT.post(new C02248(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m562s("Adapter called onReceivedAd.");
        if (cz.aX()) {
            try {
                this.mT.onAdLoaded();
                return;
            } catch (Throwable e) {
                da.m560b("Could not call onAdLoaded.", e);
                return;
            }
        }
        da.m566w("onReceivedAd must be called on the main UI thread.");
        cz.pT.post(new C02193(this));
    }
}
