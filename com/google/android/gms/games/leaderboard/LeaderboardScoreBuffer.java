package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final C0199c IO;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.IO = new C0199c(dataHolder.getMetadata());
    }

    public C0199c fX() {
        return this.IO;
    }

    public LeaderboardScore get(int position) {
        return new C0889e(this.zU, position);
    }
}
