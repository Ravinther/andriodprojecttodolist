package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;

/* renamed from: com.google.android.gms.maps.model.internal.a */
public interface C0339a extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.a.a */
    public static abstract class C0730a extends Binder implements C0339a {

        /* renamed from: com.google.android.gms.maps.model.internal.a.a.a */
        private static class C0729a implements C0339a {
            private IBinder ky;

            C0729a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public C0192b aL(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b aM(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b aN(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public C0192b m2183b(Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b bz(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b m2184c(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b hi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0339a an(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0339a)) ? new C0729a(iBinder) : (C0339a) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0192b bz;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = bz(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(bz != null ? bz.asBinder() : null);
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = aL(data.readString());
                    reply.writeNoException();
                    if (bz != null) {
                        iBinder = bz.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = aM(data.readString());
                    reply.writeNoException();
                    if (bz != null) {
                        iBinder = bz.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = hi();
                    reply.writeNoException();
                    if (bz != null) {
                        iBinder = bz.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = m1163c(data.readFloat());
                    reply.writeNoException();
                    if (bz != null) {
                        iBinder = bz.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = m1162b(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (bz != null) {
                        iBinder = bz.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bz = aN(data.readString());
                    reply.writeNoException();
                    if (bz != null) {
                        iBinder = bz.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0192b aL(String str) throws RemoteException;

    C0192b aM(String str) throws RemoteException;

    C0192b aN(String str) throws RemoteException;

    C0192b m1162b(Bitmap bitmap) throws RemoteException;

    C0192b bz(int i) throws RemoteException;

    C0192b m1163c(float f) throws RemoteException;

    C0192b hi() throws RemoteException;
}
