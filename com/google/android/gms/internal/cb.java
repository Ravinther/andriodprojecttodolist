package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ca.C0238a;

public abstract class cb extends ct {
    private final cd mf;
    private final C0238a nY;

    /* renamed from: com.google.android.gms.internal.cb.a */
    public static final class C0909a extends cb {
        private final Context mContext;

        public C0909a(Context context, cd cdVar, C0238a c0238a) {
            super(cdVar, c0238a);
            this.mContext = context;
        }

        public void aD() {
        }

        public ch aE() {
            return ci.m2556a(this.mContext, new av());
        }
    }

    /* renamed from: com.google.android.gms.internal.cb.b */
    public static final class C0910b extends cb implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mg;
        private final C0238a nY;
        private final cc nZ;

        public C0910b(Context context, cd cdVar, C0238a c0238a) {
            super(cdVar, c0238a);
            this.mg = new Object();
            this.nY = c0238a;
            this.nZ = new cc(context, this, this, cdVar.kN.pW);
            this.nZ.connect();
        }

        public void aD() {
            synchronized (this.mg) {
                if (this.nZ.isConnected() || this.nZ.isConnecting()) {
                    this.nZ.disconnect();
                }
            }
        }

        public ch aE() {
            ch aH;
            synchronized (this.mg) {
                try {
                    aH = this.nZ.aH();
                } catch (IllegalStateException e) {
                    aH = null;
                }
            }
            return aH;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.nY.m468a(new cf(0));
        }

        public void onDisconnected() {
            da.m562s("Disconnected from remote ad request service.");
        }
    }

    public cb(cd cdVar, C0238a c0238a) {
        this.mf = cdVar;
        this.nY = c0238a;
    }

    private static cf m1719a(ch chVar, cd cdVar) {
        try {
            return chVar.m478b(cdVar);
        } catch (Throwable e) {
            da.m560b("Could not fetch ad response from ad request service.", e);
            return null;
        }
    }

    public final void aB() {
        try {
            cf cfVar;
            ch aE = aE();
            if (aE == null) {
                cfVar = new cf(0);
            } else {
                cfVar = m1719a(aE, this.mf);
                if (cfVar == null) {
                    cfVar = new cf(0);
                }
            }
            aD();
            this.nY.m468a(cfVar);
        } catch (Throwable th) {
            aD();
        }
    }

    public abstract void aD();

    public abstract ch aE();

    public final void onStop() {
        aD();
    }
}
