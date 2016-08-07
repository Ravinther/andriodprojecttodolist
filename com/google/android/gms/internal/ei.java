package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;

public final class ei {
    private final C0273b BJ;
    private ArrayList<ConnectionCallbacks> BK;
    final ArrayList<ConnectionCallbacks> BL;
    private boolean BM;
    private ArrayList<OnConnectionFailedListener> BN;
    private boolean BO;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.ei.a */
    final class C0272a extends Handler {
        final /* synthetic */ ei BP;

        public C0272a(ei eiVar, Looper looper) {
            this.BP = eiVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (this.BP.BK) {
                    if (this.BP.BJ.dC() && this.BP.BJ.isConnected() && this.BP.BK.contains(msg.obj)) {
                        ((ConnectionCallbacks) msg.obj).onConnected(this.BP.BJ.cY());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.b */
    public interface C0273b {
        Bundle cY();

        boolean dC();

        boolean isConnected();
    }

    public ei(Context context, Looper looper, C0273b c0273b) {
        this.BL = new ArrayList();
        this.BM = false;
        this.BO = false;
        this.BK = new ArrayList();
        this.BN = new ArrayList();
        this.BJ = c0273b;
        this.mHandler = new C0272a(this, looper);
    }

    public void m666P(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.BK) {
            this.BM = true;
            ArrayList arrayList = this.BK;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size && this.BJ.dC(); i2++) {
                if (this.BK.contains(arrayList.get(i2))) {
                    ((ConnectionCallbacks) arrayList.get(i2)).onConnectionSuspended(i);
                }
            }
            this.BM = false;
        }
    }

    public void m667a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.BN) {
            this.BO = true;
            ArrayList arrayList = this.BN;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.BJ.dC()) {
                    if (this.BN.contains(arrayList.get(i))) {
                        ((OnConnectionFailedListener) arrayList.get(i)).onConnectionFailed(connectionResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.BO = false;
        }
    }

    public void m668b(Bundle bundle) {
        boolean z = true;
        synchronized (this.BK) {
            er.m722v(!this.BM);
            this.mHandler.removeMessages(1);
            this.BM = true;
            if (this.BL.size() != 0) {
                z = false;
            }
            er.m722v(z);
            ArrayList arrayList = this.BK;
            int size = arrayList.size();
            for (int i = 0; i < size && this.BJ.dC() && this.BJ.isConnected(); i++) {
                this.BL.size();
                if (!this.BL.contains(arrayList.get(i))) {
                    ((ConnectionCallbacks) arrayList.get(i)).onConnected(bundle);
                }
            }
            this.BL.clear();
            this.BM = false;
        }
    }

    protected void bo() {
        synchronized (this.BK) {
            m668b(this.BJ.cY());
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        er.m721f(listener);
        synchronized (this.BK) {
            contains = this.BK.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        er.m721f(listener);
        synchronized (this.BN) {
            contains = this.BN.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        er.m721f(listener);
        synchronized (this.BK) {
            if (this.BK.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                if (this.BM) {
                    this.BK = new ArrayList(this.BK);
                }
                this.BK.add(listener);
            }
        }
        if (this.BJ.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        er.m721f(listener);
        synchronized (this.BN) {
            if (this.BN.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                if (this.BO) {
                    this.BN = new ArrayList(this.BN);
                }
                this.BN.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        er.m721f(listener);
        synchronized (this.BK) {
            if (this.BK != null) {
                if (this.BM) {
                    this.BK = new ArrayList(this.BK);
                }
                if (!this.BK.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.BM && !this.BL.contains(listener)) {
                    this.BL.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        er.m721f(listener);
        synchronized (this.BN) {
            if (this.BN != null) {
                if (this.BO) {
                    this.BN = new ArrayList(this.BN);
                }
                if (!this.BN.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
                }
            }
        }
    }
}
