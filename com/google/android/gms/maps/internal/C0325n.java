package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;

/* renamed from: com.google.android.gms.maps.internal.n */
public interface C0325n extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.n.a */
    public static abstract class C0723a extends Binder implements C0325n {

        /* renamed from: com.google.android.gms.maps.internal.n.a.a */
        private static class C0722a implements C0325n {
            private IBinder ky;

            C0722a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2171d(C0192b c0192b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0723a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        }

        public static C0325n aj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0325n)) ? new C0722a(iBinder) : (C0325n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    m1132d(C0557a.m1641G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1132d(C0192b c0192b) throws RemoteException;
}
