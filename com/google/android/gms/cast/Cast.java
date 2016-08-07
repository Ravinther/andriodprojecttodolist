package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.C0136a.C0526a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import java.io.IOException;

public final class Cast {
    public static final Api API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final C0132b<dq> va;

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast.CastApi.a */
        public static final class C0522a implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.1 */
            class C10811 extends C0991b {
                final /* synthetic */ String wp;
                final /* synthetic */ String wq;
                final /* synthetic */ C0522a wr;

                C10811(C0522a c0522a, String str, String str2) {
                    this.wr = c0522a;
                    this.wp = str;
                    this.wq = str2;
                    super();
                }

                protected void m3167a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2620a(this.wp, this.wq, (C0135c) this);
                    } catch (IllegalArgumentException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    } catch (IllegalStateException e2) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.2 */
            class C10822 extends C0992c {
                final /* synthetic */ C0522a wr;
                final /* synthetic */ String ws;

                C10822(C0522a c0522a, String str) {
                    this.wr = c0522a;
                    this.ws = str;
                    super();
                }

                protected void m3169a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2621a(this.ws, false, (C0135c) this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.3 */
            class C10833 extends C0992c {
                final /* synthetic */ C0522a wr;
                final /* synthetic */ String ws;
                final /* synthetic */ boolean wt;

                C10833(C0522a c0522a, String str, boolean z) {
                    this.wr = c0522a;
                    this.ws = str;
                    this.wt = z;
                    super();
                }

                protected void m3171a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2621a(this.ws, this.wt, (C0135c) this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.4 */
            class C10844 extends C0992c {
                final /* synthetic */ C0522a wr;
                final /* synthetic */ String ws;
                final /* synthetic */ String wu;

                C10844(C0522a c0522a, String str, String str2) {
                    this.wr = c0522a;
                    this.ws = str;
                    this.wu = str2;
                    super();
                }

                protected void m3173a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2622b(this.ws, this.wu, this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.5 */
            class C10855 extends C0992c {
                final /* synthetic */ C0522a wr;
                final /* synthetic */ String ws;

                C10855(C0522a c0522a, String str) {
                    this.wr = c0522a;
                    this.ws = str;
                    super();
                }

                protected void m3175a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2622b(this.ws, null, this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.6 */
            class C10866 extends C0992c {
                final /* synthetic */ C0522a wr;

                C10866(C0522a c0522a) {
                    this.wr = c0522a;
                    super();
                }

                protected void m3177a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2622b(null, null, this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.7 */
            class C10877 extends C0991b {
                final /* synthetic */ C0522a wr;

                C10877(C0522a c0522a) {
                    this.wr = c0522a;
                    super();
                }

                protected void m3179a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2623e((C0135c) this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.8 */
            class C10888 extends C0991b {
                final /* synthetic */ C0522a wr;

                C10888(C0522a c0522a) {
                    this.wr = c0522a;
                    super();
                }

                protected void m3181a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2619a("", (C0135c) this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.9 */
            class C10899 extends C0991b {
                final /* synthetic */ C0522a wr;
                final /* synthetic */ String wu;

                C10899(C0522a c0522a, String str) {
                    this.wr = c0522a;
                    this.wu = str;
                    super();
                }

                protected void m3183a(dq dqVar) throws RemoteException {
                    if (TextUtils.isEmpty(this.wu)) {
                        m2409c(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        dqVar.m2619a(this.wu, (C0135c) this);
                    } catch (IllegalStateException e) {
                        m2410x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m135a(Cast.va)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m135a(Cast.va)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m135a(Cast.va)).da();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m135a(Cast.va)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.m137b(new C10866(this));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId) {
                return client.m137b(new C10855(this, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return client.m137b(new C10844(this, applicationId, sessionId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId) {
                return client.m137b(new C10822(this, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return client.m137b(new C10833(this, applicationId, relaunchIfRunning));
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.m137b(new C10877(this));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((dq) client.m135a(Cast.va)).m2614Q(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((dq) client.m135a(Cast.va)).cZ();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, String namespace, String message) {
                return client.m137b(new C10811(this, namespace, message));
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((dq) client.m135a(Cast.va)).m2618a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((dq) client.m135a(Cast.va)).m2625t(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((dq) client.m135a(Cast.va)).m2615a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.m137b(new C10888(this));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, String sessionId) {
                return client.m137b(new C10899(this, sessionId));
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static abstract class Listener {
        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    static class C05211 implements C0132b<dq> {
        C05211() {
        }

        public /* synthetic */ C0131a m1512b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1513c(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public dq m1513c(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            er.m719b((Object) apiOptions, (Object) "Setting the API options is required.");
            er.m720b(apiOptions instanceof CastOptions, (Object) "Must provide valid CastOptions!");
            CastOptions castOptions = (CastOptions) apiOptions;
            return new dq(context, looper, castOptions.wv, (long) castOptions.wx, castOptions.ww, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements ApiOptions {
        final CastDevice wv;
        final Listener ww;
        private final int wx;

        public static final class Builder {
            private int wA;
            CastDevice wy;
            Listener wz;

            private Builder(CastDevice castDevice, Listener castListener) {
                er.m719b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                er.m719b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.wy = castDevice;
                this.wz = castListener;
                this.wA = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.wA |= 1;
                } else {
                    this.wA &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.wv = builder.wy;
            this.ww = builder.wz;
            this.wx = builder.wA;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castListener, null);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.a */
    protected static abstract class C0857a<R extends Result> extends C0526a<R, dq> implements PendingResult<R> {
        public C0857a() {
            super(Cast.va);
        }

        public void m2409c(int i, String str) {
            m1527a(m1531d(new Status(i, str, null)));
        }

        public void m2410x(int i) {
            m1527a(m1531d(new Status(i)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.b */
    private static abstract class C0991b extends C0857a<Status> {
        private C0991b() {
        }

        public /* synthetic */ Result m2927d(Status status) {
            return m2928f(status);
        }

        public Status m2928f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.c */
    private static abstract class C0992c extends C0857a<ApplicationConnectionResult> {

        /* renamed from: com.google.android.gms.cast.Cast.c.1 */
        class C08581 implements ApplicationConnectionResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C0992c wB;

            C08581(C0992c c0992c, Status status) {
                this.wB = c0992c;
                this.vb = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        private C0992c() {
        }

        public /* synthetic */ Result m2929d(Status status) {
            return m2930h(status);
        }

        public ApplicationConnectionResult m2930h(Status status) {
            return new C08581(this, status);
        }
    }

    static {
        va = new C05211();
        API = new Api(va, new Scope[0]);
        CastApi = new C0522a();
    }

    private Cast() {
    }
}
