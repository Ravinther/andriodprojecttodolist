package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.cast.ApplicationMetadata;

public interface dt extends IInterface {

    /* renamed from: com.google.android.gms.internal.dt.a */
    public static abstract class C0605a extends Binder implements dt {
        public C0605a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m632z(data.readInt());
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ApplicationMetadata applicationMetadata = data.readInt() != 0 ? (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data) : null;
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m626a(applicationMetadata, readString, readString2, z);
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m623A(data.readInt());
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m629b(readString3, readDouble, z);
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m631d(data.readString(), data.readString());
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m630b(data.readString(), data.createByteArray());
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m625C(data.readInt());
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m624B(data.readInt());
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m628a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m627a(data.readString(), data.readLong());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m623A(int i) throws RemoteException;

    void m624B(int i) throws RemoteException;

    void m625C(int i) throws RemoteException;

    void m626a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void m627a(String str, long j) throws RemoteException;

    void m628a(String str, long j, int i) throws RemoteException;

    void m629b(String str, double d, boolean z) throws RemoteException;

    void m630b(String str, byte[] bArr) throws RemoteException;

    void m631d(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;

    void m632z(int i) throws RemoteException;
}
