package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;
import com.google.android.gms.maps.model.internal.C0342d;
import com.google.android.gms.maps.model.internal.C0342d.C0736a;

/* renamed from: com.google.android.gms.maps.internal.d */
public interface C0315d extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.d.a */
    public static abstract class C0703a extends Binder implements C0315d {

        /* renamed from: com.google.android.gms.maps.internal.d.a.a */
        private static class C0702a implements C0315d {
            private IBinder ky;

            C0702a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public C0192b m2162f(C0342d c0342d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b m2163g(C0342d c0342d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0703a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static C0315d m2164W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0315d)) ? new C0702a(iBinder) : (C0315d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0192b f;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = m1124f(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = m1125g(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0192b m1124f(C0342d c0342d) throws RemoteException;

    C0192b m1125g(C0342d c0342d) throws RemoteException;
}
