package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1116a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, googleMapOptions.getVersionCode());
        C0153b.m223a(parcel, 2, googleMapOptions.gN());
        C0153b.m223a(parcel, 3, googleMapOptions.gO());
        C0153b.m242c(parcel, 4, googleMapOptions.getMapType());
        C0153b.m230a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0153b.m223a(parcel, 6, googleMapOptions.gP());
        C0153b.m223a(parcel, 7, googleMapOptions.gQ());
        C0153b.m223a(parcel, 8, googleMapOptions.gR());
        C0153b.m223a(parcel, 9, googleMapOptions.gS());
        C0153b.m223a(parcel, 10, googleMapOptions.gT());
        C0153b.m223a(parcel, 11, googleMapOptions.gU());
        C0153b.m222D(parcel, p);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int o = C0152a.m207o(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    b8 = C0152a.m196e(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    b7 = C0152a.m196e(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    cameraPosition = (CameraPosition) C0152a.m187a(parcel, n, CameraPosition.CREATOR);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    b6 = C0152a.m196e(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    b5 = C0152a.m196e(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    b4 = C0152a.m196e(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    b3 = C0152a.m196e(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    b2 = C0152a.m196e(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    b = C0152a.m196e(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
