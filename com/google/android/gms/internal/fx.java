package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.leaderboard.C0886a;
import com.google.android.gms.games.leaderboard.C0888d;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.C0894a;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.eh.C0270b;
import com.google.android.gms.internal.eh.C0609d;
import com.google.android.gms.internal.eh.C0917e;
import com.google.android.gms.internal.gb.C0642a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class fx extends eh<gb> implements ConnectionCallbacks, OnConnectionFailedListener {
    private boolean GA;
    private boolean GB;
    private int GC;
    private final Binder GD;
    private final long GE;
    private final boolean GF;
    private final int GG;
    private final boolean GH;
    private final String Gv;
    private final Map<String, RealTimeSocket> Gw;
    private PlayerEntity Gx;
    private GameEntity Gy;
    private final gd Gz;
    private final String vi;

    final class aa extends C0270b<RoomStatusUpdateListener> {
        final /* synthetic */ fx GJ;
        private final String GZ;

        aa(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener);
            this.GZ = str;
        }

        public void m1873a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.GZ);
            }
        }

        protected void cP() {
        }
    }

    final class ab extends C0270b<RoomStatusUpdateListener> {
        final /* synthetic */ fx GJ;
        private final String GZ;

        ab(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener);
            this.GZ = str;
        }

        public void m1875a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.GZ);
            }
        }

        protected void cP() {
        }
    }

    final class am extends C0270b<ReliableMessageSentCallback> {
        final /* synthetic */ fx GJ;
        private final String Hc;
        private final int Hd;
        private final int yJ;

        am(fx fxVar, ReliableMessageSentCallback reliableMessageSentCallback, int i, int i2, String str) {
            this.GJ = fxVar;
            super(fxVar, reliableMessageSentCallback);
            this.yJ = i;
            this.Hd = i2;
            this.Hc = str;
        }

        public void m1877a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.yJ, this.Hd, this.Hc);
            }
        }

        protected void cP() {
        }
    }

    final class ap extends C0270b<OnRequestReceivedListener> {
        final /* synthetic */ fx GJ;
        private final GameRequest Hg;

        ap(fx fxVar, OnRequestReceivedListener onRequestReceivedListener, GameRequest gameRequest) {
            this.GJ = fxVar;
            super(fxVar, onRequestReceivedListener);
            this.Hg = gameRequest;
        }

        protected /* synthetic */ void m1879a(Object obj) {
            m1880b((OnRequestReceivedListener) obj);
        }

        protected void m1880b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Hg);
        }

        protected void cP() {
        }
    }

    final class aq extends C0270b<OnRequestReceivedListener> {
        final /* synthetic */ fx GJ;
        private final String Hh;

        aq(fx fxVar, OnRequestReceivedListener onRequestReceivedListener, String str) {
            this.GJ = fxVar;
            super(fxVar, onRequestReceivedListener);
            this.Hh = str;
        }

        protected /* synthetic */ void m1881a(Object obj) {
            m1882b((OnRequestReceivedListener) obj);
        }

        protected void m1882b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Hh);
        }

        protected void cP() {
        }
    }

    final class bc extends C0270b<C0135c<Status>> {
        final /* synthetic */ fx GJ;
        private final Status vl;

        public bc(fx fxVar, C0135c<Status> c0135c, Status status) {
            this.GJ = fxVar;
            super(fxVar, c0135c);
            this.vl = status;
        }

        public /* synthetic */ void m1883a(Object obj) {
            m1884c((C0135c) obj);
        }

        public void m1884c(C0135c<Status> c0135c) {
            c0135c.m143b(this.vl);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.m */
    final class C0633m extends C0270b<OnInvitationReceivedListener> {
        final /* synthetic */ fx GJ;
        private final Invitation GO;

        C0633m(fx fxVar, OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            this.GJ = fxVar;
            super(fxVar, onInvitationReceivedListener);
            this.GO = invitation;
        }

        protected /* synthetic */ void m1885a(Object obj) {
            m1886b((OnInvitationReceivedListener) obj);
        }

        protected void m1886b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.GO);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.n */
    final class C0634n extends C0270b<OnInvitationReceivedListener> {
        final /* synthetic */ fx GJ;
        private final String GP;

        C0634n(fx fxVar, OnInvitationReceivedListener onInvitationReceivedListener, String str) {
            this.GJ = fxVar;
            super(fxVar, onInvitationReceivedListener);
            this.GP = str;
        }

        protected /* synthetic */ void m1887a(Object obj) {
            m1888b((OnInvitationReceivedListener) obj);
        }

        protected void m1888b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.GP);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.v */
    final class C0635v extends C0270b<RoomUpdateListener> {
        final /* synthetic */ fx GJ;
        private final String GU;
        private final int yJ;

        C0635v(fx fxVar, RoomUpdateListener roomUpdateListener, int i, String str) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener);
            this.yJ = i;
            this.GU = str;
        }

        public void m1889a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.yJ, this.GU);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.w */
    final class C0636w extends C0270b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ fx GJ;
        private final String GV;

        C0636w(fx fxVar, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, String str) {
            this.GJ = fxVar;
            super(fxVar, onTurnBasedMatchUpdateReceivedListener);
            this.GV = str;
        }

        protected /* synthetic */ void m1891a(Object obj) {
            m1892b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void m1892b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.GV);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.y */
    final class C0637y extends C0270b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ fx GJ;
        private final TurnBasedMatch GX;

        C0637y(fx fxVar, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, TurnBasedMatch turnBasedMatch) {
            this.GJ = fxVar;
            super(fxVar, onTurnBasedMatchUpdateReceivedListener);
            this.GX = turnBasedMatch;
        }

        protected /* synthetic */ void m1893a(Object obj) {
            m1894b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void m1894b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.GX);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.z */
    final class C0638z extends C0270b<RealTimeMessageReceivedListener> {
        final /* synthetic */ fx GJ;
        private final RealTimeMessage GY;

        C0638z(fx fxVar, RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            this.GJ = fxVar;
            super(fxVar, realTimeMessageReceivedListener);
            this.GY = realTimeMessage;
        }

        public void m1895a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.GY);
            }
        }

        protected void cP() {
        }
    }

    final class aj extends C0609d<C0135c<LoadPlayerScoreResult>> implements LoadPlayerScoreResult {
        final /* synthetic */ fx GJ;
        private final C0888d Ha;
        private final Status vl;

        aj(fx fxVar, C0135c<LoadPlayerScoreResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.vl = new Status(dataHolder.getStatusCode());
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.Ha = (C0888d) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.Ha = null;
                }
                leaderboardScoreBuffer.close();
            } catch (Throwable th) {
                leaderboardScoreBuffer.close();
            }
        }

        protected void m2677a(C0135c<LoadPlayerScoreResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public LeaderboardScore getScore() {
            return this.Ha;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    final class as extends C0270b<C0135c<LoadRequestsResult>> implements LoadRequestsResult {
        final /* synthetic */ fx GJ;
        private final Bundle Hj;
        private final Status vl;

        as(fx fxVar, C0135c<LoadRequestsResult> c0135c, Status status, Bundle bundle) {
            this.GJ = fxVar;
            super(fxVar, c0135c);
            this.vl = status;
            this.Hj = bundle;
        }

        protected /* synthetic */ void m2679a(Object obj) {
            m2680c((C0135c) obj);
        }

        protected void m2680c(C0135c<LoadRequestsResult> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
            release();
        }

        public GameRequestBuffer getRequests(int requestType) {
            String aW = gs.aW(requestType);
            return !this.Hj.containsKey(aW) ? null : new GameRequestBuffer((DataHolder) this.Hj.get(aW));
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            for (String parcelable : this.Hj.keySet()) {
                DataHolder dataHolder = (DataHolder) this.Hj.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    abstract class av<R extends C0135c<?>> extends C0609d<R> implements Releasable, Result {
        final /* synthetic */ fx GJ;
        final Status vl;
        final DataHolder zU;

        public av(fx fxVar, R r, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, r, dataHolder);
            this.vl = new Status(dataHolder.getStatusCode());
            this.zU = dataHolder;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            if (this.zU != null) {
                this.zU.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.b */
    abstract class C0920b extends C0609d<RoomUpdateListener> {
        final /* synthetic */ fx GJ;

        C0920b(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        protected void m2681a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            m2682a(roomUpdateListener, this.GJ.m2693G(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void m2682a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    final class bh extends C0270b<C0135c<CancelMatchResult>> implements CancelMatchResult {
        final /* synthetic */ fx GJ;
        private final String Hr;
        private final Status vl;

        bh(fx fxVar, C0135c<CancelMatchResult> c0135c, Status status, String str) {
            this.GJ = fxVar;
            super(fxVar, c0135c);
            this.vl = status;
            this.Hr = str;
        }

        public /* synthetic */ void m2684a(Object obj) {
            m2685c((C0135c) obj);
        }

        public void m2685c(C0135c<CancelMatchResult> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
        }

        public String getMatchId() {
            return this.Hr;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    final class br extends C0270b<C0135c<LoadMatchesResult>> implements LoadMatchesResult {
        final /* synthetic */ fx GJ;
        private final LoadMatchesResponse Hx;
        private final Status vl;

        br(fx fxVar, C0135c<LoadMatchesResult> c0135c, Status status, Bundle bundle) {
            this.GJ = fxVar;
            super(fxVar, c0135c);
            this.vl = status;
            this.Hx = new LoadMatchesResponse(bundle);
        }

        protected /* synthetic */ void m2686a(Object obj) {
            m2687c((C0135c) obj);
        }

        protected void m2687c(C0135c<LoadMatchesResult> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
        }

        public LoadMatchesResponse getMatches() {
            return this.Hx;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            this.Hx.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.c */
    abstract class C0921c extends C0609d<RoomStatusUpdateListener> {
        final /* synthetic */ fx GJ;

        C0921c(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        protected void m2688a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            m2689a(roomStatusUpdateListener, this.GJ.m2693G(dataHolder));
        }

        protected abstract void m2689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* renamed from: com.google.android.gms.internal.fx.e */
    final class C0922e extends C0270b<C0135c<UpdateAchievementResult>> implements UpdateAchievementResult {
        final /* synthetic */ fx GJ;
        private final String GK;
        private final Status vl;

        C0922e(fx fxVar, C0135c<UpdateAchievementResult> c0135c, int i, String str) {
            this.GJ = fxVar;
            super(fxVar, c0135c);
            this.vl = new Status(i);
            this.GK = str;
        }

        protected /* synthetic */ void m2691a(Object obj) {
            m2692c((C0135c) obj);
        }

        protected void m2692c(C0135c<UpdateAchievementResult> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
        }

        public String getAchievementId() {
            return this.GK;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.a */
    abstract class C1021a extends C0921c {
        private final ArrayList<String> GI;
        final /* synthetic */ fx GJ;

        C1021a(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
            this.GI = new ArrayList();
            for (Object add : strArr) {
                this.GI.add(add);
            }
        }

        protected void m3010a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            m3011a(roomStatusUpdateListener, room, this.GI);
        }

        protected abstract void m3011a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    final class ai extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadPlayerScoreResult> vj;

        ai(fx fxVar, C0135c<LoadPlayerScoreResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3012C(DataHolder dataHolder) {
            this.GJ.m1791a(new aj(this.GJ, this.vj, dataHolder));
        }
    }

    final class ak extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadPlayersResult> vj;

        ak(fx fxVar, C0135c<LoadPlayersResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3013e(DataHolder dataHolder) {
            this.GJ.m1791a(new al(this.GJ, this.vj, dataHolder));
        }
    }

    final class al extends av<C0135c<LoadPlayersResult>> implements LoadPlayersResult {
        final /* synthetic */ fx GJ;
        private final PlayerBuffer Hb;

        al(fx fxVar, C0135c<LoadPlayersResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.Hb = new PlayerBuffer(dataHolder);
        }

        protected void m3014a(C0135c<LoadPlayersResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public PlayerBuffer getPlayers() {
            return this.Hb;
        }
    }

    final class an extends fw {
        final /* synthetic */ fx GJ;
        final ReliableMessageSentCallback He;

        public an(fx fxVar, ReliableMessageSentCallback reliableMessageSentCallback) {
            this.GJ = fxVar;
            this.He = reliableMessageSentCallback;
        }

        public void m3016b(int i, int i2, String str) {
            this.GJ.m1791a(new am(this.GJ, this.He, i, i2, str));
        }
    }

    final class ao extends fw {
        final /* synthetic */ fx GJ;
        private final OnRequestReceivedListener Hf;

        ao(fx fxVar, OnRequestReceivedListener onRequestReceivedListener) {
            this.GJ = fxVar;
            this.Hf = onRequestReceivedListener;
        }

        public void m3017m(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.close();
                if (gameRequest != null) {
                    this.GJ.m1791a(new ap(this.GJ, this.Hf, gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.GJ.m1791a(new aq(this.GJ, this.Hf, requestId));
        }
    }

    final class ar extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadRequestsResult> Hi;

        public ar(fx fxVar, C0135c<LoadRequestsResult> c0135c) {
            this.GJ = fxVar;
            this.Hi = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3018b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.GJ.m1791a(new as(this.GJ, this.Hi, new Status(i), bundle));
        }
    }

    final class at extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<UpdateRequestsResult> Hk;

        public at(fx fxVar, C0135c<UpdateRequestsResult> c0135c) {
            this.GJ = fxVar;
            this.Hk = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3019D(DataHolder dataHolder) {
            this.GJ.m1791a(new au(this.GJ, this.Hk, dataHolder));
        }
    }

    final class au extends av<C0135c<UpdateRequestsResult>> implements UpdateRequestsResult {
        final /* synthetic */ fx GJ;
        private final hb Hl;

        au(fx fxVar, C0135c<UpdateRequestsResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.Hl = hb.m950H(dataHolder);
        }

        protected void m3020a(C0135c<UpdateRequestsResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public Set<String> getRequestIds() {
            return this.Hl.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.Hl.getRequestOutcome(requestId);
        }
    }

    final class aw extends C0921c {
        final /* synthetic */ fx GJ;

        aw(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3022a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class ax extends fw {
        final /* synthetic */ fx GJ;
        private final RoomUpdateListener Hm;
        private final RoomStatusUpdateListener Hn;
        private final RealTimeMessageReceivedListener Ho;

        public ax(fx fxVar, RoomUpdateListener roomUpdateListener) {
            this.GJ = fxVar;
            this.Hm = (RoomUpdateListener) er.m719b((Object) roomUpdateListener, (Object) "Callbacks must not be null");
            this.Hn = null;
            this.Ho = null;
        }

        public ax(fx fxVar, RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.GJ = fxVar;
            this.Hm = (RoomUpdateListener) er.m719b((Object) roomUpdateListener, (Object) "Callbacks must not be null");
            this.Hn = roomStatusUpdateListener;
            this.Ho = realTimeMessageReceivedListener;
        }

        public void m3023a(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1791a(new af(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m3024b(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1791a(new ag(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m3025c(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1791a(new ah(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m3026d(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1791a(new ad(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m3027e(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1791a(new ac(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m3028f(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1791a(new ae(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.GJ.m1791a(new C0635v(this.GJ, this.Hm, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.GJ.m1791a(new aa(this.GJ, this.Hn, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.GJ.m1791a(new ab(this.GJ, this.Hn, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            this.GJ.m1791a(new C0638z(this.GJ, this.Ho, message));
        }

        public void m3029s(DataHolder dataHolder) {
            this.GJ.m1791a(new ba(this.GJ, this.Hm, dataHolder));
        }

        public void m3030t(DataHolder dataHolder) {
            this.GJ.m1791a(new C1032q(this.GJ, this.Hm, dataHolder));
        }

        public void m3031u(DataHolder dataHolder) {
            this.GJ.m1791a(new az(this.GJ, this.Hn, dataHolder));
        }

        public void m3032v(DataHolder dataHolder) {
            this.GJ.m1791a(new aw(this.GJ, this.Hn, dataHolder));
        }

        public void m3033w(DataHolder dataHolder) {
            this.GJ.m1791a(new ay(this.GJ, this.Hm, dataHolder));
        }

        public void m3034x(DataHolder dataHolder) {
            this.GJ.m1791a(new C1025h(this.GJ, this.Hn, dataHolder));
        }

        public void m3035y(DataHolder dataHolder) {
            this.GJ.m1791a(new C1026i(this.GJ, this.Hn, dataHolder));
        }
    }

    final class ay extends C0920b {
        final /* synthetic */ fx GJ;

        ay(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        public void m3036a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class az extends C0921c {
        final /* synthetic */ fx GJ;

        az(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3037a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class ba extends C0920b {
        final /* synthetic */ fx GJ;

        public ba(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        public void m3038a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class bb extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<Status> vj;

        public bb(fx fxVar, C0135c<Status> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void cM() {
            this.GJ.m1791a(new bc(this.GJ, this.vj, new Status(0)));
        }
    }

    final class bd extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<SubmitScoreResult> vj;

        public bd(fx fxVar, C0135c<SubmitScoreResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3039d(DataHolder dataHolder) {
            this.GJ.m1791a(new be(this.GJ, this.vj, dataHolder));
        }
    }

    final class be extends av<C0135c<SubmitScoreResult>> implements SubmitScoreResult {
        final /* synthetic */ fx GJ;
        private final ScoreSubmissionData Hp;

        public be(fx fxVar, C0135c<SubmitScoreResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            try {
                this.Hp = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public void m3040a(C0135c<SubmitScoreResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public ScoreSubmissionData getScoreData() {
            return this.Hp;
        }
    }

    abstract class bf<T extends C0135c<?>> extends av<T> {
        final /* synthetic */ fx GJ;
        final TurnBasedMatch GX;

        bf(fx fxVar, T t, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, t, dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.GX = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.GX = null;
                }
                turnBasedMatchBuffer.close();
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }

        protected void m3042a(T t, DataHolder dataHolder) {
            m3044h(t);
        }

        public TurnBasedMatch getMatch() {
            return this.GX;
        }

        abstract void m3044h(T t);
    }

    final class bg extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<CancelMatchResult> Hq;

        public bg(fx fxVar, C0135c<CancelMatchResult> c0135c) {
            this.GJ = fxVar;
            this.Hq = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3045f(int i, String str) {
            this.GJ.m1791a(new bh(this.GJ, this.Hq, new Status(i), str));
        }
    }

    final class bi extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<InitiateMatchResult> Hs;

        public bi(fx fxVar, C0135c<InitiateMatchResult> c0135c) {
            this.GJ = fxVar;
            this.Hs = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3046o(DataHolder dataHolder) {
            this.GJ.m1791a(new bj(this.GJ, this.Hs, dataHolder));
        }
    }

    final class bk extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LeaveMatchResult> Ht;

        public bk(fx fxVar, C0135c<LeaveMatchResult> c0135c) {
            this.GJ = fxVar;
            this.Ht = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3047q(DataHolder dataHolder) {
            this.GJ.m1791a(new bl(this.GJ, this.Ht, dataHolder));
        }
    }

    final class bm extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadMatchResult> Hu;

        public bm(fx fxVar, C0135c<LoadMatchResult> c0135c) {
            this.GJ = fxVar;
            this.Hu = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3048n(DataHolder dataHolder) {
            this.GJ.m1791a(new bn(this.GJ, this.Hu, dataHolder));
        }
    }

    final class bo extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<UpdateMatchResult> Hv;

        public bo(fx fxVar, C0135c<UpdateMatchResult> c0135c) {
            this.GJ = fxVar;
            this.Hv = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3049p(DataHolder dataHolder) {
            this.GJ.m1791a(new bp(this.GJ, this.Hv, dataHolder));
        }
    }

    final class bq extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadMatchesResult> Hw;

        public bq(fx fxVar, C0135c<LoadMatchesResult> c0135c) {
            this.GJ = fxVar;
            this.Hw = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3050a(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.GJ.m1791a(new br(this.GJ, this.Hw, new Status(i), bundle));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.d */
    final class C1022d extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<UpdateAchievementResult> vj;

        C1022d(fx fxVar, C0135c<UpdateAchievementResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3051e(int i, String str) {
            this.GJ.m1791a(new C0922e(this.GJ, this.vj, i, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.f */
    final class C1023f extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadAchievementsResult> vj;

        C1023f(fx fxVar, C0135c<LoadAchievementsResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3052b(DataHolder dataHolder) {
            this.GJ.m1791a(new C1024g(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.g */
    final class C1024g extends av<C0135c<LoadAchievementsResult>> implements LoadAchievementsResult {
        final /* synthetic */ fx GJ;
        private final AchievementBuffer GL;

        C1024g(fx fxVar, C0135c<LoadAchievementsResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.GL = new AchievementBuffer(dataHolder);
        }

        protected void m3053a(C0135c<LoadAchievementsResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public AchievementBuffer getAchievements() {
            return this.GL;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.h */
    final class C1025h extends C0921c {
        final /* synthetic */ fx GJ;

        C1025h(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3055a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.i */
    final class C1026i extends C0921c {
        final /* synthetic */ fx GJ;

        C1026i(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3056a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.j */
    final class C1027j extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadGamesResult> vj;

        C1027j(fx fxVar, C0135c<LoadGamesResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3057g(DataHolder dataHolder) {
            this.GJ.m1791a(new C1028k(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.k */
    final class C1028k extends av<C0135c<LoadGamesResult>> implements LoadGamesResult {
        final /* synthetic */ fx GJ;
        private final GameBuffer GM;

        C1028k(fx fxVar, C0135c<LoadGamesResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.GM = new GameBuffer(dataHolder);
        }

        protected void m3058a(C0135c<LoadGamesResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public GameBuffer getGames() {
            return this.GM;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.l */
    final class C1029l extends fw {
        final /* synthetic */ fx GJ;
        private final OnInvitationReceivedListener GN;

        C1029l(fx fxVar, OnInvitationReceivedListener onInvitationReceivedListener) {
            this.GJ = fxVar;
            this.GN = onInvitationReceivedListener;
        }

        public void m3060l(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.GJ.m1791a(new C0633m(this.GJ, this.GN, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.GJ.m1791a(new C0634n(this.GJ, this.GN, invitationId));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.o */
    final class C1030o extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadInvitationsResult> vj;

        C1030o(fx fxVar, C0135c<LoadInvitationsResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3061k(DataHolder dataHolder) {
            this.GJ.m1791a(new C1031p(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.p */
    final class C1031p extends av<C0135c<LoadInvitationsResult>> implements LoadInvitationsResult {
        final /* synthetic */ fx GJ;
        private final InvitationBuffer GQ;

        C1031p(fx fxVar, C0135c<LoadInvitationsResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.GQ = new InvitationBuffer(dataHolder);
        }

        protected void m3062a(C0135c<LoadInvitationsResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public InvitationBuffer getInvitations() {
            return this.GQ;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.q */
    final class C1032q extends C0920b {
        final /* synthetic */ fx GJ;

        public C1032q(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        public void m3064a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.r */
    final class C1033r extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LoadScoresResult> vj;

        C1033r(fx fxVar, C0135c<LoadScoresResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3065a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.GJ.m1791a(new C1034s(this.GJ, this.vj, dataHolder, dataHolder2));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.s */
    final class C1034s extends av<C0135c<LoadScoresResult>> implements LoadScoresResult {
        final /* synthetic */ fx GJ;
        private final C0886a GR;
        private final LeaderboardScoreBuffer GS;

        C1034s(fx fxVar, C0135c<LoadScoresResult> c0135c, DataHolder dataHolder, DataHolder dataHolder2) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.GR = (C0886a) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.GR = null;
                }
                leaderboardBuffer.close();
                this.GS = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.close();
            }
        }

        protected void m3066a(C0135c<LoadScoresResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public Leaderboard getLeaderboard() {
            return this.GR;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.GS;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.t */
    final class C1035t extends fw {
        final /* synthetic */ fx GJ;
        private final C0135c<LeaderboardMetadataResult> vj;

        C1035t(fx fxVar, C0135c<LeaderboardMetadataResult> c0135c) {
            this.GJ = fxVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void m3068c(DataHolder dataHolder) {
            this.GJ.m1791a(new C1036u(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.u */
    final class C1036u extends av<C0135c<LeaderboardMetadataResult>> implements LeaderboardMetadataResult {
        final /* synthetic */ fx GJ;
        private final LeaderboardBuffer GT;

        C1036u(fx fxVar, C0135c<LeaderboardMetadataResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
            this.GT = new LeaderboardBuffer(dataHolder);
        }

        protected void m3069a(C0135c<LeaderboardMetadataResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.GT;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.x */
    final class C1037x extends fw {
        final /* synthetic */ fx GJ;
        private final OnTurnBasedMatchUpdateReceivedListener GW;

        C1037x(fx fxVar, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            this.GJ = fxVar;
            this.GW = onTurnBasedMatchUpdateReceivedListener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.GJ.m1791a(new C0636w(this.GJ, this.GW, matchId));
        }

        public void m3071r(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.close();
                if (turnBasedMatch != null) {
                    this.GJ.m1791a(new C0637y(this.GJ, this.GW, turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }
    }

    final class ac extends C1021a {
        final /* synthetic */ fx GJ;

        ac(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3232a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class ad extends C1021a {
        final /* synthetic */ fx GJ;

        ad(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3233a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class ae extends C1021a {
        final /* synthetic */ fx GJ;

        ae(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3234a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class af extends C1021a {
        final /* synthetic */ fx GJ;

        af(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3235a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class ag extends C1021a {
        final /* synthetic */ fx GJ;

        ag(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3236a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class ah extends C1021a {
        final /* synthetic */ fx GJ;

        ah(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3237a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class bj extends bf<C0135c<InitiateMatchResult>> implements InitiateMatchResult {
        final /* synthetic */ fx GJ;

        bj(fx fxVar, C0135c<InitiateMatchResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
        }

        protected void m3238h(C0135c<InitiateMatchResult> c0135c) {
            c0135c.m143b(this);
        }
    }

    final class bl extends bf<C0135c<LeaveMatchResult>> implements LeaveMatchResult {
        final /* synthetic */ fx GJ;

        bl(fx fxVar, C0135c<LeaveMatchResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
        }

        protected void m3239h(C0135c<LeaveMatchResult> c0135c) {
            c0135c.m143b(this);
        }
    }

    final class bn extends bf<C0135c<LoadMatchResult>> implements LoadMatchResult {
        final /* synthetic */ fx GJ;

        bn(fx fxVar, C0135c<LoadMatchResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
        }

        protected void m3240h(C0135c<LoadMatchResult> c0135c) {
            c0135c.m143b(this);
        }
    }

    final class bp extends bf<C0135c<UpdateMatchResult>> implements UpdateMatchResult {
        final /* synthetic */ fx GJ;

        bp(fx fxVar, C0135c<UpdateMatchResult> c0135c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0135c, dataHolder);
        }

        protected void m3241h(C0135c<UpdateMatchResult> c0135c) {
            c0135c.m143b(this);
        }
    }

    public fx(Context context, Looper looper, String str, String str2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, boolean z, boolean z2, int i2, boolean z3, int i3) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.GA = false;
        this.GB = false;
        this.Gv = str;
        this.vi = (String) er.m721f(str2);
        this.GD = new Binder();
        this.Gw = new HashMap();
        this.Gz = gd.m941a(this, i);
        m2740e(view);
        this.GB = z2;
        this.GC = i2;
        this.GE = (long) hashCode();
        this.GF = z;
        this.GH = z3;
        this.GG = i3;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private Room m2693G(DataHolder dataHolder) {
        C0894a c0894a = new C0894a(dataHolder);
        Room room = null;
        try {
            if (c0894a.getCount() > 0) {
                room = (Room) ((Room) c0894a.get(0)).freeze();
            }
            c0894a.close();
            return room;
        } catch (Throwable th) {
            c0894a.close();
        }
    }

    private RealTimeSocket aw(String str) {
        try {
            ParcelFileDescriptor aD = ((gb) eb()).aD(str);
            RealTimeSocket gcVar;
            if (aD != null) {
                fz.m775f("GamesClientImpl", "Created native libjingle socket.");
                gcVar = new gc(aD);
                this.Gw.put(str, gcVar);
                return gcVar;
            }
            fz.m775f("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String ay = ((gb) eb()).ay(str);
            if (ay == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(ay));
                gcVar = new ge(localSocket, str);
                this.Gw.put(str, gcVar);
                return gcVar;
            } catch (IOException e) {
                fz.m777h("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            fz.m777h("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void fG() {
        for (RealTimeSocket close : this.Gw.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                fz.m774a("GamesClientImpl", "IOException:", e);
            }
        }
        this.Gw.clear();
    }

    private void fm() {
        this.Gx = null;
    }

    protected gb m2695H(IBinder iBinder) {
        return C0642a.m2061J(iBinder);
    }

    public int m2696a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((gb) eb()).m823a(new an(this, reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int m2697a(byte[] bArr, String str, String[] strArr) {
        er.m719b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((gb) eb()).m871b(bArr, str, strArr);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent m2698a(int i, int i2, boolean z) {
        try {
            return ((gb) eb()).m824a(i, i2, z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m2699a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((gb) eb()).m825a(i, bArr, i2, str);
            er.m719b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m2700a(Room room, int i) {
        try {
            return ((gb) eb()).m826a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void m2701a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.GA = bundle.getBoolean("show_welcome_popup");
        }
        super.m1790a(i, iBinder, bundle);
    }

    public void m2702a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((gb) eb()).m831a(iBinder, bundle);
            } catch (RemoteException e) {
                fz.m776g("GamesClientImpl", "service died");
            }
        }
    }

    public void m2703a(C0135c<LoadRequestsResult> c0135c, int i, int i2, int i3) {
        try {
            ((gb) eb()).m834a(new ar(this, c0135c), i, i2, i3);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2704a(C0135c<LoadPlayersResult> c0135c, int i, boolean z, boolean z2) {
        try {
            ((gb) eb()).m837a(new ak(this, c0135c), i, z, z2);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2705a(C0135c<LoadMatchesResult> c0135c, int i, int[] iArr) {
        try {
            ((gb) eb()).m838a(new bq(this, c0135c), i, iArr);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2706a(C0135c<LoadScoresResult> c0135c, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((gb) eb()).m841a(new C1033r(this, c0135c), leaderboardScoreBuffer.fX().fY(), i, i2);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2707a(C0135c<InitiateMatchResult> c0135c, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((gb) eb()).m836a(new bi(this, c0135c), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.getMinPlayers(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2708a(C0135c<LoadPlayersResult> c0135c, String str) {
        try {
            ((gb) eb()).m844a(new ak(this, c0135c), str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2709a(C0135c<UpdateAchievementResult> c0135c, String str, int i) {
        try {
            ((gb) eb()).m847a(c0135c == null ? null : new C1022d(this, c0135c), str, i, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2710a(C0135c<LoadScoresResult> c0135c, String str, int i, int i2, int i3, boolean z) {
        try {
            ((gb) eb()).m846a(new C1033r(this, c0135c), str, i, i2, i3, z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2711a(C0135c<LoadPlayersResult> c0135c, String str, int i, boolean z, boolean z2) {
        if (str.equals("playedWith")) {
            try {
                ((gb) eb()).m906d(new ak(this, c0135c), str, i, z, z2);
                return;
            } catch (RemoteException e) {
                fz.m776g("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m2712a(C0135c<SubmitScoreResult> c0135c, String str, long j, String str2) {
        try {
            ((gb) eb()).m853a(c0135c == null ? null : new bd(this, c0135c), str, j, str2);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2713a(C0135c<LeaveMatchResult> c0135c, String str, String str2) {
        try {
            ((gb) eb()).m898c(new bk(this, c0135c), str, str2);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2714a(C0135c<LoadPlayerScoreResult> c0135c, String str, String str2, int i, int i2) {
        try {
            ((gb) eb()).m856a(new ai(this, c0135c), str, str2, i, i2);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2715a(C0135c<LeaderboardMetadataResult> c0135c, String str, boolean z) {
        try {
            ((gb) eb()).m899c(new C1035t(this, c0135c), str, z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2716a(C0135c<UpdateMatchResult> c0135c, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((gb) eb()).m863a(new bo(this, c0135c), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2717a(C0135c<UpdateMatchResult> c0135c, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((gb) eb()).m864a(new bo(this, c0135c), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2718a(C0135c<LoadPlayersResult> c0135c, boolean z) {
        try {
            ((gb) eb()).m900c(new ak(this, c0135c), z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2719a(C0135c<UpdateRequestsResult> c0135c, String[] strArr) {
        try {
            ((gb) eb()).m870a(new at(this, c0135c), strArr);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2720a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((gb) eb()).m839a(new C1029l(this, onInvitationReceivedListener), this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2721a(RoomConfig roomConfig) {
        try {
            ((gb) eb()).m842a(new ax(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.GD, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2722a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((gb) eb()).m896c(new ax(this, roomUpdateListener), str);
            fG();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2723a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((gb) eb()).m876b(new C1037x(this, onTurnBasedMatchUpdateReceivedListener), this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2724a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((gb) eb()).m894c(new ao(this, onRequestReceivedListener), this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    protected void m2725a(en enVar, C0917e c0917e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.GF);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.GB);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.GC);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.GH);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.GG);
        enVar.m693a(c0917e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.vi, ea(), this.Gv, this.Gz.fP(), locale, bundle);
    }

    protected String aF() {
        return "com.google.android.gms.games.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void aT(int i) {
        this.Gz.setGravity(i);
    }

    public void aU(int i) {
        try {
            ((gb) eb()).aU(i);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public Intent au(String str) {
        try {
            return ((gb) eb()).au(str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void av(String str) {
        try {
            ((gb) eb()).aC(str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public Intent m2726b(int i, int i2, boolean z) {
        try {
            return ((gb) eb()).m872b(i, i2, z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m2727b(C0135c<Status> c0135c) {
        try {
            ((gb) eb()).m832a(new bb(this, c0135c));
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2728b(C0135c<UpdateAchievementResult> c0135c, String str) {
        if (c0135c == null) {
            ga gaVar = null;
        } else {
            Object c1022d = new C1022d(this, c0135c);
        }
        try {
            ((gb) eb()).m854a(gaVar, str, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2729b(C0135c<UpdateAchievementResult> c0135c, String str, int i) {
        try {
            ((gb) eb()).m880b(c0135c == null ? null : new C1022d(this, c0135c), str, i, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2730b(C0135c<LoadScoresResult> c0135c, String str, int i, int i2, int i3, boolean z) {
        try {
            ((gb) eb()).m879b(new C1033r(this, c0135c), str, i, i2, i3, z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2731b(C0135c<LeaderboardMetadataResult> c0135c, boolean z) {
        try {
            ((gb) eb()).m888b(new C1035t(this, c0135c), z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2732b(C0135c<UpdateRequestsResult> c0135c, String[] strArr) {
        try {
            ((gb) eb()).m889b(new at(this, c0135c), strArr);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2733b(RoomConfig roomConfig) {
        try {
            ((gb) eb()).m843a(new ax(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.GD, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    protected void m2734b(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            er.m717a(!z, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        er.m717a(z, String.format("Games APIs requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    public void m2735c(C0135c<LoadInvitationsResult> c0135c, int i) {
        try {
            ((gb) eb()).m833a(new C1030o(this, c0135c), i);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2736c(C0135c<UpdateAchievementResult> c0135c, String str) {
        if (c0135c == null) {
            ga gaVar = null;
        } else {
            Object c1022d = new C1022d(this, c0135c);
        }
        try {
            ((gb) eb()).m883b(gaVar, str, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2737c(C0135c<LoadAchievementsResult> c0135c, boolean z) {
        try {
            ((gb) eb()).m867a(new C1023f(this, c0135c), z);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public Bundle cY() {
        try {
            Bundle cY = ((gb) eb()).cY();
            if (cY == null) {
                return cY;
            }
            cY.setClassLoader(fx.class.getClassLoader());
            return cY;
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void connect() {
        fm();
        super.connect();
    }

    public int m2738d(byte[] bArr, String str) {
        try {
            return ((gb) eb()).m871b(bArr, str, null);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void m2739d(C0135c<InitiateMatchResult> c0135c, String str) {
        try {
            ((gb) eb()).m926l(new bi(this, c0135c), str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.GA = false;
        if (isConnected()) {
            try {
                gb gbVar = (gb) eb();
                gbVar.fH();
                gbVar.m930n(this.GE);
            } catch (RemoteException e) {
                fz.m776g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        fG();
        super.disconnect();
    }

    public void m2740e(View view) {
        this.Gz.m942f(view);
    }

    public void m2741e(C0135c<InitiateMatchResult> c0135c, String str) {
        try {
            ((gb) eb()).m928m(new bi(this, c0135c), str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2742f(C0135c<LeaveMatchResult> c0135c, String str) {
        try {
            ((gb) eb()).m934o(new bk(this, c0135c), str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public int fA() {
        try {
            return ((gb) eb()).fA();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String fB() {
        try {
            return ((gb) eb()).fB();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int fC() {
        try {
            return ((gb) eb()).fC();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public Intent fD() {
        try {
            return ((gb) eb()).fD();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int fE() {
        try {
            return ((gb) eb()).fE();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public int fF() {
        try {
            return ((gb) eb()).fF();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public void fH() {
        if (isConnected()) {
            try {
                ((gb) eb()).fH();
            } catch (RemoteException e) {
                fz.m776g("GamesClientImpl", "service died");
            }
        }
    }

    public String fn() {
        try {
            return ((gb) eb()).fn();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public String fo() {
        try {
            return ((gb) eb()).fo();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player fp() {
        PlayerBuffer playerBuffer;
        bm();
        synchronized (this) {
            if (this.Gx == null) {
                try {
                    playerBuffer = new PlayerBuffer(((gb) eb()).fI());
                    if (playerBuffer.getCount() > 0) {
                        this.Gx = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    fz.m776g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.Gx;
    }

    public Game fq() {
        bm();
        synchronized (this) {
            if (this.Gy == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((gb) eb()).fK());
                    if (gameBuffer.getCount() > 0) {
                        this.Gy = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    fz.m776g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.Gy;
    }

    public Intent fr() {
        try {
            return ((gb) eb()).fr();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent fs() {
        try {
            return ((gb) eb()).fs();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent ft() {
        try {
            return ((gb) eb()).ft();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent fu() {
        try {
            return ((gb) eb()).fu();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void fv() {
        try {
            ((gb) eb()).m933o(this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void fw() {
        try {
            ((gb) eb()).m936p(this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void fx() {
        try {
            ((gb) eb()).m938q(this.GE);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public Intent fy() {
        try {
            return ((gb) eb()).fy();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent fz() {
        try {
            return ((gb) eb()).fz();
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m2743g(C0135c<LoadGamesResult> c0135c) {
        try {
            ((gb) eb()).m903d(new C1027j(this, c0135c));
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2744g(C0135c<CancelMatchResult> c0135c, String str) {
        try {
            ((gb) eb()).m931n(new bg(this, c0135c), str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2745h(C0135c<LoadMatchResult> c0135c, String str) {
        try {
            ((gb) eb()).m937p(new bm(this, c0135c), str);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket m2746i(String str, String str2) {
        if (str2 == null || !ParticipantUtils.aE(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Gw.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? aw(str2) : realTimeSocket;
    }

    public void m2747l(String str, int i) {
        try {
            ((gb) eb()).m927l(str, i);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void m2748m(String str, int i) {
        try {
            ((gb) eb()).m929m(str, i);
        } catch (RemoteException e) {
            fz.m776g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.GA) {
            this.Gz.fN();
            this.GA = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.GA = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    protected /* synthetic */ IInterface m2749p(IBinder iBinder) {
        return m2695H(iBinder);
    }
}
