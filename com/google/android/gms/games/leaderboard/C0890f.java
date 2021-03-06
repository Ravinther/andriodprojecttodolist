package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gu;

/* renamed from: com.google.android.gms.games.leaderboard.f */
public final class C0890f implements LeaderboardVariant {
    private final int Jd;
    private final int Je;
    private final boolean Jf;
    private final long Jg;
    private final String Jh;
    private final long Ji;
    private final String Jj;
    private final String Jk;
    private final long Jl;
    private final String Jm;
    private final String Jn;
    private final String Jo;

    public C0890f(LeaderboardVariant leaderboardVariant) {
        this.Jd = leaderboardVariant.getTimeSpan();
        this.Je = leaderboardVariant.getCollection();
        this.Jf = leaderboardVariant.hasPlayerInfo();
        this.Jg = leaderboardVariant.getRawPlayerScore();
        this.Jh = leaderboardVariant.getDisplayPlayerScore();
        this.Ji = leaderboardVariant.getPlayerRank();
        this.Jj = leaderboardVariant.getDisplayPlayerRank();
        this.Jk = leaderboardVariant.getPlayerScoreTag();
        this.Jl = leaderboardVariant.getNumScores();
        this.Jm = leaderboardVariant.ga();
        this.Jn = leaderboardVariant.gb();
        this.Jo = leaderboardVariant.gc();
    }

    static int m2454a(LeaderboardVariant leaderboardVariant) {
        return ep.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.ga(), leaderboardVariant.gc(), leaderboardVariant.gb());
    }

    static boolean m2455a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return ep.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && ep.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && ep.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && ep.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && ep.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && ep.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && ep.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && ep.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && ep.equal(leaderboardVariant2.ga(), leaderboardVariant.ga()) && ep.equal(leaderboardVariant2.gc(), leaderboardVariant.gc()) && ep.equal(leaderboardVariant2.gb(), leaderboardVariant.gb());
    }

    static String m2456b(LeaderboardVariant leaderboardVariant) {
        return ep.m713e(leaderboardVariant).m712a("TimeSpan", gu.aW(leaderboardVariant.getTimeSpan())).m712a("Collection", gq.aW(leaderboardVariant.getCollection())).m712a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").m712a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").m712a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").m712a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").m712a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).m712a("TopPageNextToken", leaderboardVariant.ga()).m712a("WindowPageNextToken", leaderboardVariant.gc()).m712a("WindowPagePrevToken", leaderboardVariant.gb()).toString();
    }

    public boolean equals(Object obj) {
        return C0890f.m2455a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return gd();
    }

    public String ga() {
        return this.Jm;
    }

    public String gb() {
        return this.Jn;
    }

    public String gc() {
        return this.Jo;
    }

    public LeaderboardVariant gd() {
        return this;
    }

    public int getCollection() {
        return this.Je;
    }

    public String getDisplayPlayerRank() {
        return this.Jj;
    }

    public String getDisplayPlayerScore() {
        return this.Jh;
    }

    public long getNumScores() {
        return this.Jl;
    }

    public long getPlayerRank() {
        return this.Ji;
    }

    public String getPlayerScoreTag() {
        return this.Jk;
    }

    public long getRawPlayerScore() {
        return this.Jg;
    }

    public int getTimeSpan() {
        return this.Jd;
    }

    public boolean hasPlayerInfo() {
        return this.Jf;
    }

    public int hashCode() {
        return C0890f.m2454a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C0890f.m2456b(this);
    }
}
