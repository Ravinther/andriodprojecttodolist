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
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class gj implements Leaderboards {

    /* renamed from: com.google.android.gms.internal.gj.a */
    private static abstract class C1042a extends C0883a<LeaderboardMetadataResult> {

        /* renamed from: com.google.android.gms.internal.gj.a.1 */
        class C09271 implements LeaderboardMetadataResult {
            final /* synthetic */ C1042a Ib;
            final /* synthetic */ Status vb;

            C09271(C1042a c1042a, Status status) {
                this.Ib = c1042a;
                this.vb = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1042a() {
        }

        public /* synthetic */ Result m3081d(Status status) {
            return m3082w(status);
        }

        public LeaderboardMetadataResult m3082w(Status status) {
            return new C09271(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.b */
    private static abstract class C1043b extends C0883a<LoadPlayerScoreResult> {

        /* renamed from: com.google.android.gms.internal.gj.b.1 */
        class C09281 implements LoadPlayerScoreResult {
            final /* synthetic */ C1043b Ic;
            final /* synthetic */ Status vb;

            C09281(C1043b c1043b, Status status) {
                this.Ic = c1043b;
                this.vb = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1043b() {
        }

        public /* synthetic */ Result m3083d(Status status) {
            return m3084x(status);
        }

        public LoadPlayerScoreResult m3084x(Status status) {
            return new C09281(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.c */
    private static abstract class C1044c extends C0883a<LoadScoresResult> {

        /* renamed from: com.google.android.gms.internal.gj.c.1 */
        class C09291 implements LoadScoresResult {
            final /* synthetic */ C1044c Id;
            final /* synthetic */ Status vb;

            C09291(C1044c c1044c, Status status) {
                this.Id = c1044c;
                this.vb = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1044c() {
        }

        public /* synthetic */ Result m3085d(Status status) {
            return m3086y(status);
        }

        public LoadScoresResult m3086y(Status status) {
            return new C09291(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.d */
    protected static abstract class C1045d extends C0883a<SubmitScoreResult> {

        /* renamed from: com.google.android.gms.internal.gj.d.1 */
        class C09301 implements SubmitScoreResult {
            final /* synthetic */ C1045d Ie;
            final /* synthetic */ Status vb;

            C09301(C1045d c1045d, Status status) {
                this.Ie = c1045d;
                this.vb = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        protected C1045d() {
        }

        public /* synthetic */ Result m3087d(Status status) {
            return m3088z(status);
        }

        public SubmitScoreResult m3088z(Status status) {
            return new C09301(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.1 */
    class C11251 extends C1042a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;

        C11251(gj gjVar, boolean z) {
            this.HS = gjVar;
            this.HH = z;
            super();
        }

        protected void m3265a(fx fxVar) {
            fxVar.m2731b((C0135c) this, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.2 */
    class C11262 extends C1042a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;

        C11262(gj gjVar, String str, boolean z) {
            this.HS = gjVar;
            this.HT = str;
            this.HH = z;
            super();
        }

        protected void m3267a(fx fxVar) {
            fxVar.m2715a((C0135c) this, this.HT, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.3 */
    class C11273 extends C1043b {
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ int HU;
        final /* synthetic */ int HV;

        C11273(gj gjVar, String str, int i, int i2) {
            this.HS = gjVar;
            this.HT = str;
            this.HU = i;
            this.HV = i2;
            super();
        }

        protected void m3269a(fx fxVar) {
            fxVar.m2714a((C0135c) this, null, this.HT, this.HU, this.HV);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.4 */
    class C11284 extends C1044c {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ int HU;
        final /* synthetic */ int HV;
        final /* synthetic */ int HW;

        C11284(gj gjVar, String str, int i, int i2, int i3, boolean z) {
            this.HS = gjVar;
            this.HT = str;
            this.HU = i;
            this.HV = i2;
            this.HW = i3;
            this.HH = z;
            super();
        }

        protected void m3271a(fx fxVar) {
            fxVar.m2710a(this, this.HT, this.HU, this.HV, this.HW, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.5 */
    class C11295 extends C1044c {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ int HU;
        final /* synthetic */ int HV;
        final /* synthetic */ int HW;

        C11295(gj gjVar, String str, int i, int i2, int i3, boolean z) {
            this.HS = gjVar;
            this.HT = str;
            this.HU = i;
            this.HV = i2;
            this.HW = i3;
            this.HH = z;
            super();
        }

        protected void m3273a(fx fxVar) {
            fxVar.m2730b(this, this.HT, this.HU, this.HV, this.HW, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.6 */
    class C11306 extends C1044c {
        final /* synthetic */ gj HS;
        final /* synthetic */ int HW;
        final /* synthetic */ LeaderboardScoreBuffer HX;
        final /* synthetic */ int HY;

        C11306(gj gjVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.HS = gjVar;
            this.HX = leaderboardScoreBuffer;
            this.HW = i;
            this.HY = i2;
            super();
        }

        protected void m3275a(fx fxVar) {
            fxVar.m2706a((C0135c) this, this.HX, this.HW, this.HY);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.7 */
    class C11317 extends C1045d {
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ long HZ;
        final /* synthetic */ String Ia;

        C11317(gj gjVar, String str, long j, String str2) {
            this.HS = gjVar;
            this.HT = str;
            this.HZ = j;
            this.Ia = str2;
        }

        protected void m3277a(fx fxVar) {
            fxVar.m2712a((C0135c) this, this.HT, this.HZ, this.Ia);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fr();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m360c(apiClient).au(leaderboardId);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        return apiClient.m136a(new C11273(this, leaderboardId, span, leaderboardCollection));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, String leaderboardId, boolean forceReload) {
        return apiClient.m136a(new C11262(this, leaderboardId, forceReload));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m136a(new C11251(this, forceReload));
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        return apiClient.m136a(new C11306(this, buffer, maxResults, pageDirection));
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m136a(new C11295(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m136a(new C11284(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m360c(apiClient).m2712a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        return apiClient.m137b(new C11317(this, leaderboardId, score, scoreTag));
    }
}
