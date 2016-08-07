package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0526a;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.ei.C0273b;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.b */
final class C0530b implements GoogleApiClient {
    private int zA;
    private int zB;
    private int zC;
    private boolean zD;
    private int zE;
    private long zF;
    final Handler zG;
    private final Bundle zH;
    private final Map<C0132b<?>, C0131a> zI;
    private boolean zJ;
    final Set<C0139c> zK;
    final ConnectionCallbacks zL;
    private final C0273b zM;
    private final C0137a zm;
    private final Lock zv;
    private final Condition zw;
    private final ei zx;
    final Queue<C0139c<?>> zy;
    private ConnectionResult zz;

    /* renamed from: com.google.android.gms.common.api.b.a */
    interface C0137a {
        void m144b(C0139c c0139c);
    }

    /* renamed from: com.google.android.gms.common.api.b.b */
    class C0138b extends Handler {
        final /* synthetic */ C0530b zN;

        C0138b(C0530b c0530b, Looper looper) {
            this.zN = c0530b;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                this.zN.zv.lock();
                try {
                    if (!(this.zN.isConnected() || this.zN.isConnecting())) {
                        this.zN.connect();
                    }
                    this.zN.zv.unlock();
                } catch (Throwable th) {
                    this.zN.zv.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.c */
    interface C0139c<A extends C0131a> {
        void m145a(C0137a c0137a);

        void m146b(A a) throws DeadObjectException;

        C0132b<A> dp();

        int dr();

        void du();
    }

    /* renamed from: com.google.android.gms.common.api.b.1 */
    class C05271 implements C0137a {
        final /* synthetic */ C0530b zN;

        C05271(C0530b c0530b) {
            this.zN = c0530b;
        }

        public void m1532b(C0139c c0139c) {
            this.zN.zv.lock();
            try {
                this.zN.zK.remove(c0139c);
            } finally {
                this.zN.zv.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.2 */
    class C05282 implements ConnectionCallbacks {
        final /* synthetic */ C0530b zN;

        C05282(C0530b c0530b) {
            this.zN = c0530b;
        }

        public void onConnected(Bundle connectionHint) {
            this.zN.zv.lock();
            try {
                if (this.zN.zB == 1) {
                    if (connectionHint != null) {
                        this.zN.zH.putAll(connectionHint);
                    }
                    this.zN.dy();
                }
                this.zN.zv.unlock();
            } catch (Throwable th) {
                this.zN.zv.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.zN.zv.lock();
            try {
                this.zN.m1533G(cause);
                switch (cause) {
                    case Value.TYPE_FIELD_NUMBER /*1*/:
                        if (!this.zN.dA()) {
                            this.zN.zC = 2;
                            this.zN.zG.sendMessageDelayed(this.zN.zG.obtainMessage(1), this.zN.zF);
                            break;
                        }
                        this.zN.zv.unlock();
                        return;
                    case Value.STRING_FIELD_NUMBER /*2*/:
                        this.zN.connect();
                        break;
                }
                this.zN.zv.unlock();
            } catch (Throwable th) {
                this.zN.zv.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.3 */
    class C05293 implements C0273b {
        final /* synthetic */ C0530b zN;

        C05293(C0530b c0530b) {
            this.zN = c0530b;
        }

        public Bundle cY() {
            return null;
        }

        public boolean dC() {
            return this.zN.zJ;
        }

        public boolean isConnected() {
            return this.zN.isConnected();
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.4 */
    class C08624 implements OnConnectionFailedListener {
        final /* synthetic */ C0530b zN;
        final /* synthetic */ C0132b zO;

        C08624(C0530b c0530b, C0132b c0132b) {
            this.zN = c0530b;
            this.zO = c0132b;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zN.zv.lock();
            try {
                if (this.zN.zz == null || this.zO.getPriority() < this.zN.zA) {
                    this.zN.zz = result;
                    this.zN.zA = this.zO.getPriority();
                }
                this.zN.dy();
            } finally {
                this.zN.zv.unlock();
            }
        }
    }

    public C0530b(Context context, Looper looper, ee eeVar, Map<Api, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.zv = new ReentrantLock();
        this.zw = this.zv.newCondition();
        this.zy = new LinkedList();
        this.zB = 4;
        this.zC = 0;
        this.zD = false;
        this.zF = 5000;
        this.zH = new Bundle();
        this.zI = new HashMap();
        this.zK = new HashSet();
        this.zm = new C05271(this);
        this.zL = new C05282(this);
        this.zM = new C05293(this);
        this.zx = new ei(context, looper, this.zM);
        this.zG = new C0138b(this, looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.zx.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.zx.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            C0132b dp = api.dp();
            ApiOptions apiOptions = (ApiOptions) map.get(api);
            this.zI.put(dp, dp.m134b(context, looper, eeVar, apiOptions, this.zL, new C08624(this, dp)));
        }
    }

    private void m1533G(int i) {
        this.zv.lock();
        try {
            if (this.zB != 3) {
                if (i == -1) {
                    if (isConnecting()) {
                        Iterator it = this.zy.iterator();
                        while (it.hasNext()) {
                            if (((C0139c) it.next()).dr() != 1) {
                                it.remove();
                            }
                        }
                    } else {
                        this.zy.clear();
                    }
                    if (this.zz == null && !this.zy.isEmpty()) {
                        this.zD = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.zB = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.zz = null;
                    }
                    this.zw.signalAll();
                }
                for (C0139c du : this.zK) {
                    du.du();
                }
                this.zK.clear();
                this.zJ = false;
                for (C0131a c0131a : this.zI.values()) {
                    if (c0131a.isConnected()) {
                        c0131a.disconnect();
                    }
                }
                this.zJ = true;
                this.zB = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.zx.m666P(i);
                    }
                    this.zJ = false;
                }
            }
            this.zv.unlock();
        } finally {
            this.zv.unlock();
        }
    }

    private <A extends C0131a> void m1536a(C0139c<A> c0139c) throws DeadObjectException {
        this.zv.lock();
        try {
            er.m717a(isConnected(), "GoogleApiClient is not connected yet.");
            er.m717a(c0139c.dp() != null, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            if (c0139c instanceof Releasable) {
                this.zK.add(c0139c);
                c0139c.m145a(this.zm);
            }
            c0139c.m146b(m1548a(c0139c.dp()));
        } finally {
            this.zv.unlock();
        }
    }

    private boolean dA() {
        this.zv.lock();
        try {
            boolean z = this.zC != 0;
            this.zv.unlock();
            return z;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    private void dB() {
        this.zv.lock();
        try {
            this.zC = 0;
            this.zG.removeMessages(1);
        } finally {
            this.zv.unlock();
        }
    }

    private void dy() {
        this.zv.lock();
        try {
            this.zE--;
            if (this.zE == 0) {
                if (this.zz != null) {
                    this.zD = false;
                    m1533G(3);
                    if (dA()) {
                        this.zC--;
                    }
                    if (dA()) {
                        this.zG.sendMessageDelayed(this.zG.obtainMessage(1), this.zF);
                    } else {
                        this.zx.m667a(this.zz);
                    }
                    this.zJ = false;
                } else {
                    this.zB = 2;
                    dB();
                    this.zw.signalAll();
                    dz();
                    if (this.zD) {
                        this.zD = false;
                        m1533G(-1);
                    } else {
                        this.zx.m668b(this.zH.isEmpty() ? null : this.zH);
                    }
                }
            }
            this.zv.unlock();
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    private void dz() {
        er.m717a(isConnected(), "GoogleApiClient is not connected yet.");
        this.zv.lock();
        while (!this.zy.isEmpty()) {
            try {
                m1536a((C0139c) this.zy.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.zv.unlock();
            }
        }
        this.zv.unlock();
    }

    public <C extends C0131a> C m1548a(C0132b<C> c0132b) {
        Object obj = (C0131a) this.zI.get(c0132b);
        er.m719b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C0131a, T extends C0526a<? extends Result, A>> T m1549a(T t) {
        this.zv.lock();
        try {
            if (isConnected()) {
                m1550b((C0526a) t);
            } else {
                this.zy.add(t);
            }
            this.zv.unlock();
            return t;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public <A extends C0131a, T extends C0526a<? extends Result, A>> T m1550b(T t) {
        er.m717a(isConnected(), "GoogleApiClient is not connected yet.");
        dz();
        try {
            m1536a((C0139c) t);
        } catch (DeadObjectException e) {
            m1533G(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        er.m717a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zv.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.zw.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.yI;
                this.zv.unlock();
            } else if (this.zz != null) {
                connectionResult = this.zz;
                this.zv.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zv.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zv.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.zv.lock();
        try {
            this.zD = false;
            if (isConnected() || isConnecting()) {
                this.zv.unlock();
                return;
            }
            this.zJ = true;
            this.zz = null;
            this.zB = 1;
            this.zH.clear();
            this.zE = this.zI.size();
            for (C0131a connect : this.zI.values()) {
                connect.connect();
            }
            this.zv.unlock();
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public void disconnect() {
        dB();
        m1533G(-1);
    }

    public boolean isConnected() {
        this.zv.lock();
        try {
            boolean z = this.zB == 2;
            this.zv.unlock();
            return z;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.zv.lock();
        try {
            if (this.zB != 1) {
                z = false;
            }
            this.zv.unlock();
            return z;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zx.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zx.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zx.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zx.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zx.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zx.unregisterConnectionFailedListener(listener);
    }
}
