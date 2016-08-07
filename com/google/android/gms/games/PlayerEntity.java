package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;

public final class PlayerEntity extends fy implements Player {
    public static final Creator<PlayerEntity> CREATOR;
    private final String FE;
    private final Uri FJ;
    private final Uri FK;
    private final String FU;
    private final String FV;
    private final String Gh;
    private final long Gi;
    private final int Gj;
    private final long Gk;
    private final int wj;

    /* renamed from: com.google.android.gms.games.PlayerEntity.a */
    static final class C0560a extends C0197c {
        C0560a() {
        }

        public PlayerEntity ak(Parcel parcel) {
            if (fy.m2750c(eg.dY()) || eg.ae(PlayerEntity.class.getCanonicalName())) {
                return super.ak(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(4, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return ak(x0);
        }
    }

    static {
        CREATOR = new C0560a();
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl) {
        this.wj = versionCode;
        this.Gh = playerId;
        this.FE = displayName;
        this.FJ = iconImageUri;
        this.FU = iconImageUrl;
        this.FK = hiResImageUri;
        this.FV = hiResImageUrl;
        this.Gi = retrievedTimestamp;
        this.Gj = isInCircles;
        this.Gk = lastPlayedWithTimestamp;
    }

    public PlayerEntity(Player player) {
        this.wj = 4;
        this.Gh = player.getPlayerId();
        this.FE = player.getDisplayName();
        this.FJ = player.getIconImageUri();
        this.FU = player.getIconImageUrl();
        this.FK = player.getHiResImageUri();
        this.FV = player.getHiResImageUrl();
        this.Gi = player.getRetrievedTimestamp();
        this.Gj = player.fl();
        this.Gk = player.getLastPlayedWithTimestamp();
        ed.m661d(this.Gh);
        ed.m661d(this.FE);
        ed.m662v(this.Gi > 0);
    }

    static int m2985a(Player player) {
        return ep.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()));
    }

    static boolean m2986a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return ep.equal(player2.getPlayerId(), player.getPlayerId()) && ep.equal(player2.getDisplayName(), player.getDisplayName()) && ep.equal(player2.getIconImageUri(), player.getIconImageUri()) && ep.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && ep.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp()));
    }

    static String m2987b(Player player) {
        return ep.m713e(player).m712a("PlayerId", player.getPlayerId()).m712a("DisplayName", player.getDisplayName()).m712a("IconImageUri", player.getIconImageUri()).m712a("IconImageUrl", player.getIconImageUrl()).m712a("HiResImageUri", player.getHiResImageUri()).m712a("HiResImageUrl", player.getHiResImageUrl()).m712a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2986a(this, obj);
    }

    public int fl() {
        return this.Gj;
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.FE;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        fm.m771b(this.FE, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.FK;
    }

    public String getHiResImageUrl() {
        return this.FV;
    }

    public Uri getIconImageUri() {
        return this.FJ;
    }

    public String getIconImageUrl() {
        return this.FU;
    }

    public long getLastPlayedWithTimestamp() {
        return this.Gk;
    }

    public String getPlayerId() {
        return this.Gh;
    }

    public long getRetrievedTimestamp() {
        return this.Gi;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return m2985a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m2987b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (dZ()) {
            dest.writeString(this.Gh);
            dest.writeString(this.FE);
            dest.writeString(this.FJ == null ? null : this.FJ.toString());
            if (this.FK != null) {
                str = this.FK.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.Gi);
            return;
        }
        C0197c.m362a(this, dest, flags);
    }
}
