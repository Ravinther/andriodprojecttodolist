package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C0532c<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] zY;
    private final Creator<T> zZ;

    static {
        zY = new String[]{"data"};
    }

    public C0532c(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zZ = creator;
    }

    public T m1556H(int i) {
        byte[] byteArray = this.zU.getByteArray("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zZ.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public /* synthetic */ Object get(int x0) {
        return m1556H(x0);
    }
}
