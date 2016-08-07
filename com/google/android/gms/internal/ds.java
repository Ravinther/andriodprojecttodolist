package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;

public interface ds extends IInterface {

    /* renamed from: com.google.android.gms.internal.ds.a */
    public static abstract class C0604a extends Binder implements ds {

        /* renamed from: com.google.android.gms.internal.ds.a.a */
        private static class C0603a implements ds {
            private IBinder ky;

            C0603a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m1742R(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.ky.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1743S(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.ky.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1744T(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.ky.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1745a(double d, double d2, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1746a(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.ky.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1747a(String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.ky.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1748a(boolean z, double d, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeDouble(d);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void cZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.ky.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void df() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.ky.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.ky.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1749e(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.ky.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m1750e(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static ds m1751w(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ds)) ? new C0603a(iBinder) : (ds) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    disconnect();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m622e(readString, z);
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m621e(data.readString(), data.readString());
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    df();
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m614R(data.readString());
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    cZ();
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m617a(data.readDouble(), data.readDouble(), data.readInt() != 0);
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    boolean z2 = data.readInt() != 0;
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m620a(z2, readDouble, z);
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m618a(data.readString(), data.readString(), data.readLong());
                    return true;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m619a(data.readString(), data.createByteArray(), data.readLong());
                    return true;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m615S(data.readString());
                    return true;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m616T(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m614R(String str) throws RemoteException;

    void m615S(String str) throws RemoteException;

    void m616T(String str) throws RemoteException;

    void m617a(double d, double d2, boolean z) throws RemoteException;

    void m618a(String str, String str2, long j) throws RemoteException;

    void m619a(String str, byte[] bArr, long j) throws RemoteException;

    void m620a(boolean z, double d, boolean z2) throws RemoteException;

    void cZ() throws RemoteException;

    void df() throws RemoteException;

    void disconnect() throws RemoteException;

    void m621e(String str, String str2) throws RemoteException;

    void m622e(String str, boolean z) throws RemoteException;
}
