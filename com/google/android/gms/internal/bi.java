package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.bg.C0584a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bi<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0584a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mR;
    private final NETWORK_EXTRAS mS;

    public bi(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.mR = mediationAdapter;
        this.mS = network_extras;
    }

    private SERVER_PARAMETERS m2481a(String str, int i, String str2) throws RemoteException {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Map hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
                Map map = hashMap;
            } catch (Throwable th) {
                da.m560b("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            Object hashMap2 = new HashMap(0);
        }
        Class serverParametersType = this.mR.getServerParametersType();
        SERVER_PARAMETERS server_parameters = null;
        if (serverParametersType != null) {
            SERVER_PARAMETERS server_parameters2 = (MediationServerParameters) serverParametersType.newInstance();
            server_parameters2.load(map);
            server_parameters = server_parameters2;
        }
        if (server_parameters instanceof AdMobServerParameters) {
            AdMobServerParameters adMobServerParameters = (AdMobServerParameters) server_parameters;
            adMobServerParameters.adJson = str2;
            adMobServerParameters.tagForChildDirectedTreatment = i;
        }
        return server_parameters;
    }

    public void m2482a(C0192b c0192b, ab abVar, C0673z c0673z, String str, bh bhVar) throws RemoteException {
        m2483a(c0192b, abVar, c0673z, str, null, bhVar);
    }

    public void m2483a(C0192b c0192b, ab abVar, C0673z c0673z, String str, String str2, bh bhVar) throws RemoteException {
        if (this.mR instanceof MediationBannerAdapter) {
            da.m562s("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.mR).requestBannerAd(new bj(bhVar), (Activity) C0882c.m2445b(c0192b), m2481a(str, c0673z.tagForChildDirectedTreatment, str2), bk.m442b(abVar), bk.m443e(c0673z), this.mS);
            } catch (Throwable th) {
                da.m560b("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m566w("MediationAdapter is not a MediationBannerAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m2484a(C0192b c0192b, C0673z c0673z, String str, bh bhVar) throws RemoteException {
        m2485a(c0192b, c0673z, str, null, bhVar);
    }

    public void m2485a(C0192b c0192b, C0673z c0673z, String str, String str2, bh bhVar) throws RemoteException {
        if (this.mR instanceof MediationInterstitialAdapter) {
            da.m562s("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.mR).requestInterstitialAd(new bj(bhVar), (Activity) C0882c.m2445b(c0192b), m2481a(str, c0673z.tagForChildDirectedTreatment, str2), bk.m443e(c0673z), this.mS);
            } catch (Throwable th) {
                da.m560b("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m566w("MediationAdapter is not a MediationInterstitialAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.mR.destroy();
        } catch (Throwable th) {
            da.m560b("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0192b getView() throws RemoteException {
        if (this.mR instanceof MediationBannerAdapter) {
            try {
                return C0882c.m2446h(((MediationBannerAdapter) this.mR).getBannerView());
            } catch (Throwable th) {
                da.m560b("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m566w("MediationAdapter is not a MediationBannerAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.mR instanceof MediationInterstitialAdapter) {
            da.m562s("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.mR).showInterstitial();
            } catch (Throwable th) {
                da.m560b("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            da.m566w("MediationAdapter is not a MediationInterstitialAdapter: " + this.mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
