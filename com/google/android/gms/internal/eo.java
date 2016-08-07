package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;

public interface eo extends IInterface {

    /* renamed from: com.google.android.gms.internal.eo.a */
    public static abstract class C0616a extends Binder implements eo {

        /* renamed from: com.google.android.gms.internal.eo.a.a */
        private static class C0615a implements eo {
            private IBinder ky;

            C0615a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public C0192b m1823a(C0192b c0192b, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.ky.transact(1, obtain, obtain2, 0);
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
        }

        public static eo m1824A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof eo)) ? new C0615a(iBinder) : (eo) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0192b a = m711a(C0557a.m1641G(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0192b m711a(C0192b c0192b, int i, int i2) throws RemoteException;
}
