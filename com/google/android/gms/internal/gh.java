package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0883a;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

public final class gh implements GamesMetadata {

    /* renamed from: com.google.android.gms.internal.gh.a */
    private static abstract class C1040a extends C0883a<LoadGamesResult> {

        /* renamed from: com.google.android.gms.internal.gh.a.1 */
        class C09251 implements LoadGamesResult {
            final /* synthetic */ C1040a HO;
            final /* synthetic */ Status vb;

            C09251(C1040a c1040a, Status status) {
                this.HO = c1040a;
                this.vb = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1040a() {
        }

        public /* synthetic */ Result m3077d(Status status) {
            return m3078u(status);
        }

        public LoadGamesResult m3078u(Status status) {
            return new C09251(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gh.1 */
    class C11231 extends C1040a {
        final /* synthetic */ gh HN;

        C11231(gh ghVar) {
            this.HN = ghVar;
            super();
        }

        protected void m3261a(fx fxVar) {
            fxVar.m2743g(this);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fq();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.m136a(new C11231(this));
    }
}
