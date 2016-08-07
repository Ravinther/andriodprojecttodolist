package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ch.C0593a;
import com.google.android.gms.internal.eh.C0917e;

public class cc extends eh<ch> {
    private final int oa;

    public cc(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.oa = i;
    }

    protected void m2551a(en enVar, C0917e c0917e) throws RemoteException {
        enVar.m703g(c0917e, this.oa, getContext().getPackageName(), new Bundle());
    }

    protected String aF() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public ch aH() {
        return (ch) super.eb();
    }

    protected ch m2552o(IBinder iBinder) {
        return C0593a.m1721q(iBinder);
    }

    protected /* synthetic */ IInterface m2553p(IBinder iBinder) {
        return m2552o(iBinder);
    }
}
