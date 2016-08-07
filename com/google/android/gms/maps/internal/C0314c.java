package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C0685a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C0691a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C0693a;
import com.google.android.gms.maps.model.internal.C0339a;
import com.google.android.gms.maps.model.internal.C0339a.C0730a;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C0314c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c.a */
    public static abstract class C0701a extends Binder implements C0314c {

        /* renamed from: com.google.android.gms.maps.internal.c.a.a */
        private static class C0700a implements C0314c {
            private IBinder ky;

            C0700a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IMapViewDelegate m2157a(C0192b c0192b, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate Z = C0693a.m2155Z(obtain2.readStrongBinder());
                    return Z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2158a(C0192b c0192b, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    obtain.writeInt(i);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2159e(C0192b c0192b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate m2160f(C0192b c0192b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate Y = C0691a.m2154Y(obtain2.readStrongBinder());
                    return Y;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate gY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate S = C0685a.m2151S(obtain2.readStrongBinder());
                    return S;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0339a gZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0339a an = C0730a.an(obtain2.readStrongBinder());
                    return an;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0314c m2161U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0314c)) ? new C0700a(iBinder) : (C0314c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m1122e(C0557a.m1641G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate f = m1123f(C0557a.m1641G(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = m1120a(C0557a.m1641G(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate gY = gY();
                    reply.writeNoException();
                    if (gY != null) {
                        iBinder = gY.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0339a gZ = gZ();
                    reply.writeNoException();
                    if (gZ != null) {
                        iBinder = gZ.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m1121a(C0557a.m1641G(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate m1120a(C0192b c0192b, GoogleMapOptions googleMapOptions) throws RemoteException;

    void m1121a(C0192b c0192b, int i) throws RemoteException;

    void m1122e(C0192b c0192b) throws RemoteException;

    IMapFragmentDelegate m1123f(C0192b c0192b) throws RemoteException;

    ICameraUpdateFactoryDelegate gY() throws RemoteException;

    C0339a gZ() throws RemoteException;
}
