package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR;
    final Contents CW;
    final int wj;

    static {
        CREATOR = new C0177z();
    }

    OnContentsResponse(int versionCode, Contents contents) {
        this.wj = versionCode;
        this.CW = contents;
    }

    public int describeContents() {
        return 0;
    }

    public Contents eX() {
        return this.CW;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0177z.m327a(this, dest, flags);
    }
}
