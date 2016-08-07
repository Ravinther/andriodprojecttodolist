package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;

/* renamed from: com.google.android.gms.maps.internal.g */
public interface C0318g extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.g.a */
    public static abstract class C0709a extends Binder implements C0318g {

        /* renamed from: com.google.android.gms.maps.internal.g.a.a */
        private static class C0708a implements C0318g {
            private IBinder ky;

            C0708a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2166g(C0192b c0192b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0318g ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0318g)) ? new C0708a(iBinder) : (C0318g) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    m1127g(C0557a.m1641G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1127g(C0192b c0192b) throws RemoteException;
}
