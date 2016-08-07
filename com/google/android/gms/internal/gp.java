package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0883a;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class gp implements TurnBasedMultiplayer {

    /* renamed from: com.google.android.gms.internal.gp.a */
    private static abstract class C1049a extends C0883a<CancelMatchResult> {
        private final String uS;

        /* renamed from: com.google.android.gms.internal.gp.a.1 */
        class C09341 implements CancelMatchResult {
            final /* synthetic */ C1049a Iy;
            final /* synthetic */ Status vb;

            C09341(C1049a c1049a, Status status) {
                this.Iy = c1049a;
                this.vb = status;
            }

            public String getMatchId() {
                return this.Iy.uS;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        public C1049a(String str) {
            this.uS = str;
        }

        public CancelMatchResult m3096D(Status status) {
            return new C09341(this, status);
        }

        public /* synthetic */ Result m3097d(Status status) {
            return m3096D(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.b */
    private static abstract class C1050b extends C0883a<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.b.1 */
        class C09351 implements InitiateMatchResult {
            final /* synthetic */ C1050b Iz;
            final /* synthetic */ Status vb;

            C09351(C1050b c1050b, Status status) {
                this.Iz = c1050b;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1050b() {
        }

        public InitiateMatchResult m3098E(Status status) {
            return new C09351(this, status);
        }

        public /* synthetic */ Result m3099d(Status status) {
            return m3098E(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.c */
    private static abstract class C1051c extends C0883a<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.c.1 */
        class C09361 implements LeaveMatchResult {
            final /* synthetic */ C1051c IA;
            final /* synthetic */ Status vb;

            C09361(C1051c c1051c, Status status) {
                this.IA = c1051c;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1051c() {
        }

        public LeaveMatchResult m3100F(Status status) {
            return new C09361(this, status);
        }

        public /* synthetic */ Result m3101d(Status status) {
            return m3100F(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.d */
    private static abstract class C1052d extends C0883a<LoadMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.d.1 */
        class C09371 implements LoadMatchResult {
            final /* synthetic */ C1052d IB;
            final /* synthetic */ Status vb;

            C09371(C1052d c1052d, Status status) {
                this.IB = c1052d;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1052d() {
        }

        public LoadMatchResult m3102G(Status status) {
            return new C09371(this, status);
        }

        public /* synthetic */ Result m3103d(Status status) {
            return m3102G(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.e */
    private static abstract class C1053e extends C0883a<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.internal.gp.e.1 */
        class C09381 implements LoadMatchesResult {
            final /* synthetic */ C1053e IC;
            final /* synthetic */ Status vb;

            C09381(C1053e c1053e, Status status) {
                this.IC = c1053e;
                this.vb = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1053e() {
        }

        public LoadMatchesResult m3104H(Status status) {
            return new C09381(this, status);
        }

        public /* synthetic */ Result m3105d(Status status) {
            return m3104H(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.f */
    private static abstract class C1054f extends C0883a<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.f.1 */
        class C09391 implements UpdateMatchResult {
            final /* synthetic */ C1054f IE;
            final /* synthetic */ Status vb;

            C09391(C1054f c1054f, Status status) {
                this.IE = c1054f;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1054f() {
        }

        public UpdateMatchResult m3106I(Status status) {
            return new C09391(this, status);
        }

        public /* synthetic */ Result m3107d(Status status) {
            return m3106I(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.10 */
    class AnonymousClass10 extends C1053e {
        final /* synthetic */ gp Iq;
        final /* synthetic */ int Iw;
        final /* synthetic */ int[] Ix;

        AnonymousClass10(gp gpVar, int i, int[] iArr) {
            this.Iq = gpVar;
            this.Iw = i;
            this.Ix = iArr;
            super();
        }

        protected void m3297a(fx fxVar) {
            fxVar.m2705a((C0135c) this, this.Iw, this.Ix);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.1 */
    class C11411 extends C1050b {
        final /* synthetic */ TurnBasedMatchConfig Ip;
        final /* synthetic */ gp Iq;

        C11411(gp gpVar, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.Iq = gpVar;
            this.Ip = turnBasedMatchConfig;
            super();
        }

        protected void m3299a(fx fxVar) {
            fxVar.m2707a((C0135c) this, this.Ip);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.2 */
    class C11422 extends C1052d {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11422(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Ir = str;
            super();
        }

        protected void m3301a(fx fxVar) {
            fxVar.m2745h(this, this.Ir);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.3 */
    class C11433 extends C1050b {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11433(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Ir = str;
            super();
        }

        protected void m3303a(fx fxVar) {
            fxVar.m2739d((C0135c) this, this.Ir);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.4 */
    class C11444 extends C1050b {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Is;

        C11444(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Is = str;
            super();
        }

        protected void m3305a(fx fxVar) {
            fxVar.m2741e(this, this.Is);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.5 */
    class C11455 extends C1054f {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;
        final /* synthetic */ byte[] It;
        final /* synthetic */ String Iu;
        final /* synthetic */ ParticipantResult[] Iv;

        C11455(gp gpVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.Iq = gpVar;
            this.Ir = str;
            this.It = bArr;
            this.Iu = str2;
            this.Iv = participantResultArr;
            super();
        }

        protected void m3307a(fx fxVar) {
            fxVar.m2716a((C0135c) this, this.Ir, this.It, this.Iu, this.Iv);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.6 */
    class C11466 extends C1054f {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;
        final /* synthetic */ byte[] It;
        final /* synthetic */ ParticipantResult[] Iv;

        C11466(gp gpVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.Iq = gpVar;
            this.Ir = str;
            this.It = bArr;
            this.Iv = participantResultArr;
            super();
        }

        protected void m3309a(fx fxVar) {
            fxVar.m2717a((C0135c) this, this.Ir, this.It, this.Iv);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.7 */
    class C11477 extends C1051c {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11477(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Ir = str;
            super();
        }

        protected void m3311a(fx fxVar) {
            fxVar.m2742f(this, this.Ir);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.8 */
    class C11488 extends C1051c {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;
        final /* synthetic */ String Iu;

        C11488(gp gpVar, String str, String str2) {
            this.Iq = gpVar;
            this.Ir = str;
            this.Iu = str2;
            super();
        }

        protected void m3313a(fx fxVar) {
            fxVar.m2713a((C0135c) this, this.Ir, this.Iu);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.9 */
    class C11499 extends C1049a {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11499(gp gpVar, String str, String str2) {
            this.Iq = gpVar;
            this.Ir = str2;
            super(str);
        }

        protected void m3315a(fx fxVar) {
            fxVar.m2744g(this, this.Ir);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, String invitationId) {
        return apiClient.m137b(new C11444(this, invitationId));
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m137b(new C11499(this, matchId, matchId));
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, TurnBasedMatchConfig config) {
        return apiClient.m137b(new C11411(this, config));
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m360c(apiClient).m2748m(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m360c(apiClient).m2747l(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m360c(apiClient).av(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        return apiClient.m137b(new C11466(this, matchId, matchData, results));
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).ft();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fC();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m360c(apiClient).m2698a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m360c(apiClient).m2698a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m137b(new C11477(this, matchId));
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, String matchId, String pendingParticipantId) {
        return apiClient.m137b(new C11488(this, matchId, pendingParticipantId));
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m136a(new C11422(this, matchId));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int invitationSortOrder, int[] matchTurnStatuses) {
        return apiClient.m136a(new AnonymousClass10(this, invitationSortOrder, matchTurnStatuses));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m360c(apiClient).m2723a(listener);
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m137b(new C11433(this, matchId));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        return apiClient.m137b(new C11455(this, matchId, matchData, pendingParticipantId, results));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m360c(apiClient).fw();
    }
}
