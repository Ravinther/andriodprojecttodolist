package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class di implements Parcelable {
    @Deprecated
    public static final Creator<di> CREATOR;
    private String mValue;
    private String uS;
    private String uT;

    /* renamed from: com.google.android.gms.internal.di.1 */
    static class C02581 implements Creator<di> {
        C02581() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m593i(x0);
        }

        @Deprecated
        public di m593i(Parcel parcel) {
            return new di(parcel);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m594u(x0);
        }

        @Deprecated
        public di[] m594u(int i) {
            return new di[i];
        }
    }

    static {
        CREATOR = new C02581();
    }

    @Deprecated
    di(Parcel parcel) {
        readFromParcel(parcel);
    }

    public di(String str, String str2, String str3) {
        this.uS = str;
        this.uT = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.uS = in.readString();
        this.uT = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.uS;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.uS);
        out.writeString(this.uT);
        out.writeString(this.mValue);
    }
}
