package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
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
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;

public final class AppStateManager {
    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final C0132b<dl> va;

    /* renamed from: com.google.android.gms.appstate.AppStateManager.1 */
    static class C05201 implements C0132b<dl> {
        C05201() {
        }

        public dl m1510a(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new dl(context, looper, connectionCallbacks, onConnectionFailedListener, eeVar.dR(), (String[]) eeVar.dT().toArray(new String[0]));
        }

        public /* synthetic */ C0131a m1511b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1510a(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.2 */
    static class C08512 implements StateResult {
        final /* synthetic */ Status vb;

        C08512(Status status) {
            this.vb = status;
        }

        public StateConflictResult getConflictResult() {
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            return null;
        }

        public Status getStatus() {
            return this.vb;
        }

        public void release() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.a */
    public static abstract class C0853a<R extends Result> extends C0526a<R, dl> implements PendingResult<R> {
        public C0853a() {
            super(AppStateManager.va);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.b */
    private static abstract class C0987b extends C0853a<StateDeletedResult> {
        private C0987b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.c */
    private static abstract class C0988c extends C0853a<StateListResult> {

        /* renamed from: com.google.android.gms.appstate.AppStateManager.c.1 */
        class C08541 implements StateListResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C0988c vh;

            C08541(C0988c c0988c, Status status) {
                this.vh = c0988c;
                this.vb = status;
            }

            public AppStateBuffer getStateBuffer() {
                return new AppStateBuffer(null);
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C0988c() {
        }

        public /* synthetic */ Result m2921d(Status status) {
            return m2922e(status);
        }

        public StateListResult m2922e(Status status) {
            return new C08541(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.d */
    private static abstract class C0989d extends C0853a<Status> {
        private C0989d() {
        }

        public /* synthetic */ Result m2923d(Status status) {
            return m2924f(status);
        }

        public Status m2924f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.e */
    private static abstract class C0990e extends C0853a<StateResult> {
        private C0990e() {
        }

        public /* synthetic */ Result m2925d(Status status) {
            return m2926g(status);
        }

        public StateResult m2926g(Status status) {
            return AppStateManager.m86a(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.3 */
    static class C10743 extends C0990e {
        final /* synthetic */ int vc;
        final /* synthetic */ byte[] vd;

        C10743(int i, byte[] bArr) {
            this.vc = i;
            this.vd = bArr;
            super();
        }

        protected void m3151a(dl dlVar) {
            dlVar.m2578a(null, this.vc, this.vd);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.4 */
    static class C10754 extends C0990e {
        final /* synthetic */ int vc;
        final /* synthetic */ byte[] vd;

        C10754(int i, byte[] bArr) {
            this.vc = i;
            this.vd = bArr;
            super();
        }

        protected void m3153a(dl dlVar) {
            dlVar.m2578a(this, this.vc, this.vd);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.5 */
    static class C10765 extends C0987b {
        final /* synthetic */ int vc;

        /* renamed from: com.google.android.gms.appstate.AppStateManager.5.1 */
        class C08521 implements StateDeletedResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C10765 ve;

            C08521(C10765 c10765, Status status) {
                this.ve = c10765;
                this.vb = status;
            }

            public int getStateKey() {
                return this.ve.vc;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        C10765(int i) {
            this.vc = i;
            super();
        }

        protected void m3155a(dl dlVar) {
            dlVar.m2576a((C0135c) this, this.vc);
        }

        public StateDeletedResult m3156c(Status status) {
            return new C08521(this, status);
        }

        public /* synthetic */ Result m3157d(Status status) {
            return m3156c(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.6 */
    static class C10776 extends C0990e {
        final /* synthetic */ int vc;

        C10776(int i) {
            this.vc = i;
            super();
        }

        protected void m3159a(dl dlVar) {
            dlVar.m2581b(this, this.vc);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.7 */
    static class C10787 extends C0988c {
        C10787() {
            super();
        }

        protected void m3161a(dl dlVar) {
            dlVar.m2575a(this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.8 */
    static class C10798 extends C0990e {
        final /* synthetic */ int vc;
        final /* synthetic */ String vf;
        final /* synthetic */ byte[] vg;

        C10798(int i, String str, byte[] bArr) {
            this.vc = i;
            this.vf = str;
            this.vg = bArr;
            super();
        }

        protected void m3163a(dl dlVar) {
            dlVar.m2577a(this, this.vc, this.vf, this.vg);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.9 */
    static class C10809 extends C0989d {
        C10809() {
            super();
        }

        protected void m3165a(dl dlVar) {
            dlVar.m2580b((C0135c) this);
        }
    }

    static {
        va = new C05201();
        SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
        API = new Api(va, SCOPE_APP_STATE);
    }

    private AppStateManager() {
    }

    private static StateResult m86a(Status status) {
        return new C08512(status);
    }

    public static dl m87a(GoogleApiClient googleApiClient) {
        boolean z = true;
        er.m720b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        er.m717a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        dl dlVar = (dl) googleApiClient.m135a(va);
        if (dlVar == null) {
            z = false;
        }
        er.m717a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return dlVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m137b(new C10765(stateKey));
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m87a(googleApiClient).cO();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m87a(googleApiClient).cN();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.m136a(new C10787());
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m136a(new C10776(stateKey));
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, int stateKey, String resolvedVersion, byte[] resolvedData) {
        return googleApiClient.m137b(new C10798(stateKey, resolvedVersion, resolvedData));
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.m137b(new C10809());
    }

    public static void update(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        googleApiClient.m137b(new C10743(stateKey, data));
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        return googleApiClient.m137b(new C10754(stateKey, data));
    }
}
