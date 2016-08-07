package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ds.C0604a;
import com.google.android.gms.internal.dt.C0605a;
import com.google.android.gms.internal.eh.C0917e;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class dq extends eh<ds> {
    private static final du xE;
    private static final Object xU;
    private static final Object xV;
    private final Handler mHandler;
    private final Listener wz;
    private ApplicationMetadata xF;
    private final CastDevice xG;
    private final dt xH;
    private final Map<String, MessageReceivedCallback> xI;
    private final long xJ;
    private String xK;
    private boolean xL;
    private boolean xM;
    private final AtomicLong xN;
    private String xO;
    private String xP;
    private Bundle xQ;
    private Map<Long, C0135c<Status>> xR;
    private C0135c<ApplicationConnectionResult> xS;
    private C0135c<Status> xT;
    private double xe;
    private boolean xf;

    /* renamed from: com.google.android.gms.internal.dq.1 */
    class C09151 extends C0605a {
        final /* synthetic */ dq xW;

        /* renamed from: com.google.android.gms.internal.dq.1.1 */
        class C02601 implements Runnable {
            final /* synthetic */ int xX;
            final /* synthetic */ C09151 xY;

            C02601(C09151 c09151, int i) {
                this.xY = c09151;
                this.xX = i;
            }

            public void run() {
                if (this.xY.xW.wz != null) {
                    this.xY.xW.wz.onApplicationDisconnected(this.xX);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.dq.1.2 */
        class C02612 implements Runnable {
            final /* synthetic */ C09151 xY;
            final /* synthetic */ String xZ;
            final /* synthetic */ double xs;
            final /* synthetic */ boolean xt;

            C02612(C09151 c09151, String str, double d, boolean z) {
                this.xY = c09151;
                this.xZ = str;
                this.xs = d;
                this.xt = z;
            }

            public void run() {
                this.xY.xW.m2601a(this.xZ, this.xs, this.xt);
            }
        }

        /* renamed from: com.google.android.gms.internal.dq.1.3 */
        class C02623 implements Runnable {
            final /* synthetic */ String wp;
            final /* synthetic */ C09151 xY;
            final /* synthetic */ String ya;

            C02623(C09151 c09151, String str, String str2) {
                this.xY = c09151;
                this.wp = str;
                this.ya = str2;
            }

            public void run() {
                synchronized (this.xY.xW.xI) {
                    MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.xY.xW.xI.get(this.wp);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(this.xY.xW.xG, this.wp, this.ya);
                    return;
                }
                dq.xE.m637b("Discarded message for unknown namespace '%s'", this.wp);
            }
        }

        C09151(dq dqVar) {
            this.xW = dqVar;
        }

        private boolean m2585D(int i) {
            synchronized (dq.xV) {
                if (this.xW.xT != null) {
                    this.xW.xT.m143b(new Status(i));
                    this.xW.xT = null;
                    return true;
                }
                return false;
            }
        }

        private void m2586b(long j, int i) {
            synchronized (this.xW.xR) {
                C0135c c0135c = (C0135c) this.xW.xR.remove(Long.valueOf(j));
            }
            if (c0135c != null) {
                c0135c.m143b(new Status(i));
            }
        }

        public void m2587A(int i) {
            synchronized (dq.xU) {
                if (this.xW.xS != null) {
                    this.xW.xS.m143b(new C0916a(new Status(i)));
                    this.xW.xS = null;
                }
            }
        }

        public void m2588B(int i) {
            m2585D(i);
        }

        public void m2589C(int i) {
            m2585D(i);
        }

        public void m2590a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.xW.xF = applicationMetadata;
            this.xW.xO = applicationMetadata.getApplicationId();
            this.xW.xP = str2;
            synchronized (dq.xU) {
                if (this.xW.xS != null) {
                    this.xW.xS.m143b(new C0916a(new Status(0), applicationMetadata, str, str2, z));
                    this.xW.xS = null;
                }
            }
        }

        public void m2591a(String str, long j) {
            m2586b(j, 0);
        }

        public void m2592a(String str, long j, int i) {
            m2586b(j, i);
        }

        public void m2593b(String str, double d, boolean z) {
            this.xW.mHandler.post(new C02612(this, str, d, z));
        }

        public void m2594b(String str, byte[] bArr) {
            dq.xE.m637b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        public void m2595d(String str, String str2) {
            dq.xE.m637b("Receive (type=text, ns=%s) %s", str, str2);
            this.xW.mHandler.post(new C02623(this, str, str2));
        }

        public void onApplicationDisconnected(int statusCode) {
            this.xW.xO = null;
            this.xW.xP = null;
            if (!m2585D(statusCode) && this.xW.wz != null) {
                this.xW.mHandler.post(new C02601(this, statusCode));
            }
        }

        public void m2596z(int i) {
            dq.xE.m637b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            this.xW.xM = false;
            this.xW.xF = null;
            if (i != 0) {
                this.xW.m1789O(2);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dq.a */
    private static final class C0916a implements ApplicationConnectionResult {
        private final String pz;
        private final Status vl;
        private final ApplicationMetadata yb;
        private final String yc;
        private final boolean yd;

        public C0916a(Status status) {
            this(status, null, null, null, false);
        }

        public C0916a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.vl = status;
            this.yb = applicationMetadata;
            this.yc = str;
            this.pz = str2;
            this.yd = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.yb;
        }

        public String getApplicationStatus() {
            return this.yc;
        }

        public String getSessionId() {
            return this.pz;
        }

        public Status getStatus() {
            return this.vl;
        }

        public boolean getWasLaunched() {
            return this.yd;
        }
    }

    static {
        xE = new du("CastClientImpl");
        xU = new Object();
        xV = new Object();
    }

    public dq(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.xG = castDevice;
        this.wz = listener;
        this.xJ = j;
        this.mHandler = new Handler(looper);
        this.xI = new HashMap();
        this.xM = false;
        this.xF = null;
        this.xK = null;
        this.xe = 0.0d;
        this.xf = false;
        this.xN = new AtomicLong(0);
        this.xR = new HashMap();
        this.xH = new C09151(this);
    }

    private void m2601a(String str, double d, boolean z) {
        boolean z2;
        if (dr.m611a(str, this.xK)) {
            z2 = false;
        } else {
            this.xK = str;
            int i = 1;
        }
        if (this.wz != null && (r0 != 0 || this.xL)) {
            this.wz.onApplicationStatusChanged();
        }
        if (d != this.xe) {
            this.xe = d;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != this.xf) {
            this.xf = z;
            z2 = true;
        }
        xE.m637b("hasChange=%b, mFirstStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.xL));
        if (this.wz != null && (z2 || this.xL)) {
            this.wz.onVolumeChanged();
        }
        this.xL = false;
    }

    private void m2608d(C0135c<ApplicationConnectionResult> c0135c) {
        synchronized (xU) {
            if (this.xS != null) {
                this.xS.m143b(new C0916a(new Status(CastStatusCodes.CANCELED)));
            }
            this.xS = c0135c;
        }
    }

    private void db() throws IllegalStateException {
        if (!this.xM) {
            throw new IllegalStateException("not connected to a device");
        }
    }

    private void m2611f(C0135c<Status> c0135c) {
        synchronized (xV) {
            if (this.xT != null) {
                c0135c.m143b(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE));
                return;
            }
            this.xT = c0135c;
        }
    }

    public void m2614Q(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.xI) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.xI.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((ds) eb()).m616T(str);
            } catch (Throwable e) {
                xE.m636a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void m2615a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((ds) eb()).m617a(d, this.xe, this.xf);
    }

    protected void m2616a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 || i == GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.xM = true;
            this.xL = true;
        } else {
            this.xM = false;
        }
        if (i == GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.xQ = new Bundle();
            this.xQ.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.m1790a(i, iBinder, bundle);
    }

    protected void m2617a(en enVar, C0917e c0917e) throws RemoteException {
        Bundle bundle = new Bundle();
        xE.m637b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.xO, this.xP);
        this.xG.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.xJ);
        if (this.xO != null) {
            bundle.putString("last_application_id", this.xO);
            if (this.xP != null) {
                bundle.putString("last_session_id", this.xP);
            }
        }
        enVar.m690a((em) c0917e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.xH.asBinder(), bundle);
    }

    public void m2618a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        m2614Q(str);
        if (messageReceivedCallback != null) {
            synchronized (this.xI) {
                this.xI.put(str, messageReceivedCallback);
            }
            ((ds) eb()).m615S(str);
        }
    }

    public void m2619a(String str, C0135c<Status> c0135c) throws IllegalStateException, RemoteException {
        m2611f((C0135c) c0135c);
        ((ds) eb()).m614R(str);
    }

    public void m2620a(String str, String str2, C0135c<Status> c0135c) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str == null || str.length() > TransportMediator.FLAG_KEY_MEDIA_NEXT) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (str2.length() > Cast.MAX_MESSAGE_LENGTH) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            db();
            long incrementAndGet = this.xN.incrementAndGet();
            ((ds) eb()).m618a(str, str2, incrementAndGet);
            this.xR.put(Long.valueOf(incrementAndGet), c0135c);
        }
    }

    public void m2621a(String str, boolean z, C0135c<ApplicationConnectionResult> c0135c) throws IllegalStateException, RemoteException {
        m2608d((C0135c) c0135c);
        ((ds) eb()).m622e(str, z);
    }

    protected String aF() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String aG() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void m2622b(String str, String str2, C0135c<ApplicationConnectionResult> c0135c) throws IllegalStateException, RemoteException {
        m2608d((C0135c) c0135c);
        ((ds) eb()).m621e(str, str2);
    }

    public Bundle cY() {
        if (this.xQ == null) {
            return super.cY();
        }
        Bundle bundle = this.xQ;
        this.xQ = null;
        return bundle;
    }

    public void cZ() throws IllegalStateException, RemoteException {
        ((ds) eb()).cZ();
    }

    public double da() throws IllegalStateException {
        db();
        return this.xe;
    }

    public void disconnect() {
        try {
            if (isConnected()) {
                synchronized (this.xI) {
                    this.xI.clear();
                }
                ((ds) eb()).disconnect();
            }
        } catch (RemoteException e) {
            try {
                xE.m637b("Error while disconnecting the controller interface: %s", e.getMessage());
            } catch (Throwable th) {
                super.disconnect();
            }
        }
        super.disconnect();
    }

    public void m2623e(C0135c<Status> c0135c) throws IllegalStateException, RemoteException {
        m2611f((C0135c) c0135c);
        ((ds) eb()).df();
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        db();
        return this.xF;
    }

    public String getApplicationStatus() throws IllegalStateException {
        db();
        return this.xK;
    }

    public boolean isMute() throws IllegalStateException {
        db();
        return this.xf;
    }

    protected /* synthetic */ IInterface m2624p(IBinder iBinder) {
        return m2626v(iBinder);
    }

    public void m2625t(boolean z) throws IllegalStateException, RemoteException {
        ((ds) eb()).m620a(z, this.xe, this.xf);
    }

    protected ds m2626v(IBinder iBinder) {
        return C0604a.m1751w(iBinder);
    }
}
