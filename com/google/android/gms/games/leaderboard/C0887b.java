package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0142b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0884b;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.leaderboard.b */
public final class C0887b extends C0142b implements Leaderboard {
    private final Game IM;
    private final int IN;

    C0887b(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.IN = i2;
        this.IM = new C0884b(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0886a.m2449a(this, obj);
    }

    public Leaderboard fW() {
        return new C0886a(this);
    }

    public /* synthetic */ Object freeze() {
        return fW();
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        m152a("name", dataOut);
    }

    public Game getGame() {
        return this.IM;
    }

    public Uri getIconImageUri() {
        return aa("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.IN);
        for (int i = 0; i < this.IN; i++) {
            arrayList.add(new C0891g(this.zU, this.zW + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return C0886a.m2448a(this);
    }

    public String toString() {
        return C0886a.m2450b(this);
    }
}
