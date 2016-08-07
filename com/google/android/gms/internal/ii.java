package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus.C0975a;
import com.google.android.gms.plus.internal.C0979e;

public final class ii implements Account {
    private final C0132b<C0979e> Rw;

    /* renamed from: com.google.android.gms.internal.ii.a */
    private static abstract class C1056a extends C0975a<Status> {
        C1056a(C0132b<C0979e> c0132b) {
            super(c0132b);
        }

        public /* synthetic */ Result m3110d(Status status) {
            return m3111f(status);
        }

        public Status m3111f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ii.1 */
    class C11501 extends C1056a {
        final /* synthetic */ ii Rx;

        C11501(ii iiVar, C0132b c0132b) {
            this.Rx = iiVar;
            super(c0132b);
        }

        protected void m3317a(C0979e c0979e) {
            c0979e.m2875k(this);
        }
    }

    public ii(C0132b<C0979e> c0132b) {
        this.Rw = c0132b;
    }

    private static C0979e m2114a(GoogleApiClient googleApiClient, C0132b<C0979e> c0132b) {
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

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m2114a(googleApiClient, this.Rw).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m2114a(googleApiClient, this.Rw).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.m137b(new C11501(this, this.Rw));
    }
}
