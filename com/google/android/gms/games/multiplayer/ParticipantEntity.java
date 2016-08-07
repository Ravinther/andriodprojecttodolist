package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;

public final class ParticipantEntity extends fy implements Participant {
    public static final Creator<ParticipantEntity> CREATOR;
    private final String FE;
    private final Uri FJ;
    private final Uri FK;
    private final String FU;
    private final String FV;
    private final String GZ;
    private final boolean JA;
    private final PlayerEntity JB;
    private final int JC;
    private final ParticipantResult JD;
    private final int Jy;
    private final String Jz;
    private final int wj;

    /* renamed from: com.google.android.gms.games.multiplayer.ParticipantEntity.a */
    static final class C0563a extends C0201c {
        C0563a() {
        }

        public ParticipantEntity ao(Parcel parcel) {
            Object obj = 1;
            if (fy.m2750c(eg.dY()) || eg.ae(ParticipantEntity.class.getCanonicalName())) {
                return super.ao(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return ao(x0);
        }
    }

    static {
        CREATOR = new C0563a();
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.wj = versionCode;
        this.GZ = participantId;
        this.FE = displayName;
        this.FJ = iconImageUri;
        this.FK = hiResImageUri;
        this.Jy = status;
        this.Jz = clientAddress;
        this.JA = connectedToRoom;
        this.JB = player;
        this.JC = capabilities;
        this.JD = result;
        this.FU = iconImageUrl;
        this.FV = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.wj = 3;
        this.GZ = participant.getParticipantId();
        this.FE = participant.getDisplayName();
        this.FJ = participant.getIconImageUri();
        this.FK = participant.getHiResImageUri();
        this.Jy = participant.getStatus();
        this.Jz = participant.ge();
        this.JA = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.JB = player == null ? null : new PlayerEntity(player);
        this.JC = participant.getCapabilities();
        this.JD = participant.getResult();
        this.FU = participant.getIconImageUrl();
        this.FV = participant.getHiResImageUrl();
    }

    static int m2993a(Participant participant) {
        return ep.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.ge(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult());
    }

    static boolean m2994a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return ep.equal(participant2.getPlayer(), participant.getPlayer()) && ep.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && ep.equal(participant2.ge(), participant.ge()) && ep.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && ep.equal(participant2.getDisplayName(), participant.getDisplayName()) && ep.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && ep.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && ep.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && ep.equal(participant2.getResult(), participant.getResult());
    }

    static String m2995b(Participant participant) {
        return ep.m713e(participant).m712a("Player", participant.getPlayer()).m712a("Status", Integer.valueOf(participant.getStatus())).m712a("ClientAddress", participant.ge()).m712a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).m712a("DisplayName", participant.getDisplayName()).m712a("IconImage", participant.getIconImageUri()).m712a("IconImageUrl", participant.getIconImageUrl()).m712a("HiResImage", participant.getHiResImageUri()).m712a("HiResImageUrl", participant.getHiResImageUrl()).m712a("Capabilities", Integer.valueOf(participant.getCapabilities())).m712a("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2994a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public String ge() {
        return this.Jz;
    }

    public int getCapabilities() {
        return this.JC;
    }

    public String getDisplayName() {
        return this.JB == null ? this.FE : this.JB.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.JB == null) {
            fm.m771b(this.FE, dataOut);
        } else {
            this.JB.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.JB == null ? this.FK : this.JB.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.JB == null ? this.FV : this.JB.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.JB == null ? this.FJ : this.JB.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.JB == null ? this.FU : this.JB.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.GZ;
    }

    public Player getPlayer() {
        return this.JB;
    }

    public ParticipantResult getResult() {
        return this.JD;
    }

    public int getStatus() {
        return this.Jy;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return m2993a(this);
    }

    public boolean isConnectedToRoom() {
        return this.JA;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m2995b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (dZ()) {
            dest.writeString(this.GZ);
            dest.writeString(this.FE);
            dest.writeString(this.FJ == null ? null : this.FJ.toString());
            if (this.FK != null) {
                str = this.FK.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.Jy);
            dest.writeString(this.Jz);
            dest.writeInt(this.JA ? 1 : 0);
            if (this.JB != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.JB != null) {
                this.JB.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        C0201c.m366a(this, dest, flags);
    }
}
