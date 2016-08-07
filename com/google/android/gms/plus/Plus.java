package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0526a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.il;
import com.google.android.gms.plus.internal.C0765h;
import com.google.android.gms.plus.internal.C0979e;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api API;
    public static final Account AccountApi;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final C0350a QK;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    static final C0132b<C0979e> va;

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    static class C07461 implements C0132b<C0979e> {
        C07461() {
        }

        public /* synthetic */ C0131a m2199b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2200h(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return 2;
        }

        public C0979e m2200h(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            PlusOptions plusOptions;
            PlusOptions plusOptions2 = new PlusOptions();
            if (apiOptions != null) {
                er.m720b(apiOptions instanceof PlusOptions, (Object) "Must provide valid PlusOptions!");
                plusOptions = (PlusOptions) apiOptions;
            } else {
                plusOptions = plusOptions2;
            }
            return new C0979e(context, looper, connectionCallbacks, onConnectionFailedListener, new C0765h(eeVar.dR(), eeVar.dU(), (String[]) plusOptions.QM.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }
    }

    public static final class PlusOptions implements ApiOptions {
        final String QL;
        final Set<String> QM;

        public static final class Builder {
            String QL;
            final Set<String> QM;

            public Builder() {
                this.QM = new HashSet();
            }

            public Builder addActivityTypes(String... activityTypes) {
                er.m719b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.QM.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.QL = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.QL = null;
            this.QM = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.QL = builder.QL;
            this.QM = builder.QM;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus.a */
    public static abstract class C0975a<R extends Result> extends C0526a<R, C0979e> {
        public C0975a(C0132b<C0979e> c0132b) {
            super(c0132b);
        }
    }

    static {
        va = new C07461();
        API = new Api(va, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        MomentsApi = new ik(va);
        PeopleApi = new il(va);
        AccountApi = new ii(va);
        QK = new ij(va);
    }

    private Plus() {
    }

    public static C0979e m1174a(GoogleApiClient googleApiClient, C0132b<C0979e> c0132b) {
        boolean z = true;
        er.m720b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        er.m717a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C0979e c0979e = (C0979e) googleApiClient.m135a((C0132b) c0132b);
        if (c0979e == null) {
            z = false;
        }
        er.m717a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c0979e;
    }
}
