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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;

public final class gm implements Players {

    /* renamed from: com.google.android.gms.internal.gm.a */
    private static abstract class C1046a extends C0883a<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.internal.gm.a.1 */
        class C09311 implements LoadPlayersResult {
            final /* synthetic */ C1046a Ii;
            final /* synthetic */ Status vb;

            C09311(C1046a c1046a, Status status) {
                this.Ii = c1046a;
                this.vb = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1046a() {
        }

        public LoadPlayersResult m3089A(Status status) {
            return new C09311(this, status);
        }

        public /* synthetic */ Result m3090d(Status status) {
            return m3089A(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.1 */
    class C11321 extends C1046a {
        final /* synthetic */ String If;
        final /* synthetic */ gm Ig;

        C11321(gm gmVar, String str) {
            this.Ig = gmVar;
            this.If = str;
            super();
        }

        protected void m3279a(fx fxVar) {
            fxVar.m2708a((C0135c) this, this.If);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.2 */
    class C11332 extends C1046a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11332(gm gmVar, int i, boolean z) {
            this.Ig = gmVar;
            this.Ih = i;
            this.HH = z;
            super();
        }

        protected void m3281a(fx fxVar) {
            fxVar.m2704a((C0135c) this, this.Ih, false, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.3 */
    class C11343 extends C1046a {
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11343(gm gmVar, int i) {
            this.Ig = gmVar;
            this.Ih = i;
            super();
        }

        protected void m3283a(fx fxVar) {
            fxVar.m2704a((C0135c) this, this.Ih, true, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.4 */
    class C11354 extends C1046a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11354(gm gmVar, int i, boolean z) {
            this.Ig = gmVar;
            this.Ih = i;
            this.HH = z;
            super();
        }

        protected void m3285a(fx fxVar) {
            fxVar.m2711a((C0135c) this, "playedWith", this.Ih, false, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.5 */
    class C11365 extends C1046a {
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11365(gm gmVar, int i) {
            this.Ig = gmVar;
            this.Ih = i;
            super();
        }

        protected void m3287a(fx fxVar) {
            fxVar.m2711a((C0135c) this, "playedWith", this.Ih, true, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.6 */
    class C11376 extends C1046a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gm Ig;

        C11376(gm gmVar, boolean z) {
            this.Ig = gmVar;
            this.HH = z;
            super();
        }

        protected void m3289a(fx fxVar) {
            fxVar.m2718a((C0135c) this, this.HH);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fp();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fo();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fy();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m136a(new C11376(this, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m136a(new C11332(this, pageSize, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m136a(new C11343(this, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m136a(new C11365(this, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId) {
        return apiClient.m136a(new C11321(this, playerId));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m136a(new C11354(this, pageSize, forceReload));
    }
}
