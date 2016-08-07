package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class TileCreator implements Creator<Tile> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1150a(Tile tile, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, tile.getVersionCode());
        C0153b.m242c(parcel, 2, tile.width);
        C0153b.m242c(parcel, 3, tile.height);
        C0153b.m236a(parcel, 4, tile.data, false);
        C0153b.m222D(parcel, p);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0152a.m207o(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    bArr = C0152a.m209p(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
