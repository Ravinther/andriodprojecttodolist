package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0883a;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class gi implements Invitations {

    /* renamed from: com.google.android.gms.internal.gi.a */
    private static abstract class C1041a extends C0883a<LoadInvitationsResult> {

        /* renamed from: com.google.android.gms.internal.gi.a.1 */
        class C09261 implements LoadInvitationsResult {
            final /* synthetic */ C1041a HR;
            final /* synthetic */ Status vb;

            C09261(C1041a c1041a, Status status) {
                this.HR = c1041a;
                this.vb = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1041a() {
        }

        public /* synthetic */ Result m3079d(Status status) {
            return m3080v(status);
        }

        public LoadInvitationsResult m3080v(Status status) {
            return new C09261(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gi.1 */
    class C11241 extends C1041a {
        final /* synthetic */ int HP;
        final /* synthetic */ gi HQ;

        C11241(gi giVar, int i) {
            this.HQ = giVar;
            this.HP = i;
            super();
        }

        protected void m3263a(fx fxVar) {
            fxVar.m2735c((C0135c) this, this.HP);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fu();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, int sortOrder) {
        return apiClient.m136a(new C11241(this, sortOrder));
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m360c(apiClient).m2720a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m360c(apiClient).fv();
    }
}
