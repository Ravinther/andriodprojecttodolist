package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0142b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0885d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.multiplayer.d */
public final class C0893d extends C0142b implements Participant {
    private final C0885d JE;

    public C0893d(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.JE = new C0885d(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m2994a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public String ge() {
        return getString("client_address");
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return ab("external_player_id") ? getString("default_display_name") : this.JE.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (ab("external_player_id")) {
            m152a("default_display_name", dataOut);
        } else {
            this.JE.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return ab("external_player_id") ? aa("default_display_hi_res_image_uri") : this.JE.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return ab("external_player_id") ? getString("default_display_hi_res_image_url") : this.JE.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return ab("external_player_id") ? aa("default_display_image_uri") : this.JE.getIconImageUri();
    }

    public String getIconImageUrl() {
        return ab("external_player_id") ? getString("default_display_image_url") : this.JE.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return ab("external_player_id") ? null : this.JE;
    }

    public ParticipantResult getResult() {
        if (ab("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m2993a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.m2995b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
