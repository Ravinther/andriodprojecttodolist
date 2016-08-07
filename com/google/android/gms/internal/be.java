package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bf.C0582a;
import java.util.Map;

public final class be extends C0582a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> mQ;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bg m2478n(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, be.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new bi(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.mQ.get(mediationAdapter.getAdditionalParametersType()));
            }
            da.m566w("Could not instantiate mediation adapter: " + str + ".");
            throw new RemoteException();
        } catch (Throwable th) {
            da.m566w("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m2479c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.mQ = map;
    }

    public bg m2480m(String str) throws RemoteException {
        return m2478n(str);
    }
}
