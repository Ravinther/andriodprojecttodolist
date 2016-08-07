package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR;
    final DriveId CS;
    final int Dm;
    final int wj;

    static {
        CREATOR = new C0161a();
    }

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.wj = versionCode;
        this.CS = driveId;
        this.Dm = eventType;
    }

    public AddEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0161a.m254a(this, dest, flags);
    }
}
