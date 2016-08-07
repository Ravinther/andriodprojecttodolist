package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
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
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gw;

public final class Games {
    public static final Api API;
    public static final Achievements Achievements;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Scope FY;
    public static final Api FZ;
    public static final Multiplayer Ga;
    public static final GamesMetadata GamesMetadata;
    public static final gw Gb;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    static final C0132b<fx> va;

    /* renamed from: com.google.android.gms.games.Games.1 */
    static class C05591 implements C0132b<fx> {
        C05591() {
        }

        public /* synthetic */ C0131a m1642b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1643e(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public fx m1643e(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions;
            GamesOptions gamesOptions2 = new GamesOptions();
            if (apiOptions != null) {
                er.m720b(apiOptions instanceof GamesOptions, (Object) "Must provide valid GamesOptions!");
                gamesOptions = (GamesOptions) apiOptions;
            } else {
                gamesOptions = gamesOptions2;
            }
            return new fx(context, looper, eeVar.dV(), eeVar.dR(), connectionCallbacks, onConnectionFailedListener, eeVar.dU(), eeVar.dS(), eeVar.dW(), gamesOptions.Gc, gamesOptions.Gd, gamesOptions.Ge, gamesOptions.Gf, gamesOptions.Gg);
        }

        public int getPriority() {
            return 1;
        }
    }

    public static final class GamesOptions implements ApiOptions {
        final boolean Gc;
        final boolean Gd;
        final int Ge;
        final boolean Gf;
        final int Gg;

        public static final class Builder {
            boolean Gc;
            boolean Gd;
            int Ge;
            boolean Gf;
            int Gg;

            private Builder() {
                this.Gc = false;
                this.Gd = true;
                this.Ge = 17;
                this.Gf = false;
                this.Gg = 4368;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.Gg = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.Gd = showConnectingPopup;
                this.Ge = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.Gd = showConnectingPopup;
                this.Ge = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.Gc = false;
            this.Gd = true;
            this.Ge = 17;
            this.Gf = false;
            this.Gg = 4368;
        }

        private GamesOptions(Builder builder) {
            this.Gc = builder.Gc;
            this.Gd = builder.Gd;
            this.Ge = builder.Ge;
            this.Gf = builder.Gf;
            this.Gg = builder.Gg;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.games.Games.a */
    public static abstract class C0883a<R extends Result> extends C0526a<R, fx> implements PendingResult<R> {
        public C0883a() {
            super(Games.va);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.b */
    private static abstract class C1015b extends C0883a<Status> {
        private C1015b() {
        }

        public /* synthetic */ Result m2983d(Status status) {
            return m2984f(status);
        }

        public Status m2984f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    static class C11132 extends C1015b {
        C11132() {
            super();
        }

        protected void m3231a(fx fxVar) {
            fxVar.m2727b((C0135c) this);
        }
    }

    static {
        va = new C05591();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api(va, SCOPE_GAMES);
        FY = new Scope("https://www.googleapis.com/auth/games.firstparty");
        FZ = new Api(va, FY);
        GamesMetadata = new gh();
        Achievements = new gf();
        Leaderboards = new gj();
        Invitations = new gi();
        TurnBasedMultiplayer = new gp();
        RealTimeMultiplayer = new gn();
        Ga = new gk();
        Players = new gm();
        Notifications = new gl();
        Requests = new go();
        Gb = new gg();
    }

    private Games() {
    }

    public static fx m360c(GoogleApiClient googleApiClient) {
        boolean z = true;
        er.m720b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        er.m717a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        fx fxVar = (fx) googleApiClient.m135a(va);
        if (fxVar == null) {
            z = false;
        }
        er.m717a(z, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return fxVar;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m360c(apiClient).fB();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m360c(apiClient).fn();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m360c(apiClient).fA();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m360c(apiClient).fz();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m360c(apiClient).aT(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        er.m721f(gamesContentView);
        m360c(apiClient).m2740e(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.m137b(new C11132());
    }
}
