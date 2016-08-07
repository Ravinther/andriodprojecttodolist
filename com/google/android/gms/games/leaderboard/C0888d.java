package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.fm;

/* renamed from: com.google.android.gms.games.leaderboard.d */
public final class C0888d implements LeaderboardScore {
    private final long IQ;
    private final String IR;
    private final String IS;
    private final long IT;
    private final long IU;
    private final String IV;
    private final Uri IW;
    private final Uri IX;
    private final PlayerEntity IY;
    private final String IZ;
    private final String Ja;
    private final String Jb;

    public C0888d(LeaderboardScore leaderboardScore) {
        this.IQ = leaderboardScore.getRank();
        this.IR = (String) er.m721f(leaderboardScore.getDisplayRank());
        this.IS = (String) er.m721f(leaderboardScore.getDisplayScore());
        this.IT = leaderboardScore.getRawScore();
        this.IU = leaderboardScore.getTimestampMillis();
        this.IV = leaderboardScore.getScoreHolderDisplayName();
        this.IW = leaderboardScore.getScoreHolderIconImageUri();
        this.IX = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.IY = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.IZ = leaderboardScore.getScoreTag();
        this.Ja = leaderboardScore.getScoreHolderIconImageUrl();
        this.Jb = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int m2451a(LeaderboardScore leaderboardScore) {
        return ep.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean m2452a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return ep.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && ep.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && ep.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && ep.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && ep.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && ep.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && ep.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && ep.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && ep.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && ep.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String m2453b(LeaderboardScore leaderboardScore) {
        return ep.m713e(leaderboardScore).m712a("Rank", Long.valueOf(leaderboardScore.getRank())).m712a("DisplayRank", leaderboardScore.getDisplayRank()).m712a("Score", Long.valueOf(leaderboardScore.getRawScore())).m712a("DisplayScore", leaderboardScore.getDisplayScore()).m712a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).m712a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).m712a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).m712a("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).m712a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).m712a("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).m712a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).m712a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return C0888d.m2452a(this, obj);
    }

    public LeaderboardScore fZ() {
        return this;
    }

    public /* synthetic */ Object freeze() {
        return fZ();
    }

    public String getDisplayRank() {
        return this.IR;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        fm.m771b(this.IR, dataOut);
    }

    public String getDisplayScore() {
        return this.IS;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        fm.m771b(this.IS, dataOut);
    }

    public long getRank() {
        return this.IQ;
    }

    public long getRawScore() {
        return this.IT;
    }

    public Player getScoreHolder() {
        return this.IY;
    }

    public String getScoreHolderDisplayName() {
        return this.IY == null ? this.IV : this.IY.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.IY == null) {
            fm.m771b(this.IV, dataOut);
        } else {
            this.IY.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.IY == null ? this.IX : this.IY.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.IY == null ? this.Jb : this.IY.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.IY == null ? this.IW : this.IY.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.IY == null ? this.Ja : this.IY.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.IZ;
    }

    public long getTimestampMillis() {
        return this.IU;
    }

    public int hashCode() {
        return C0888d.m2451a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C0888d.m2453b(this);
    }
}
