package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.bg.C0584a;

public interface bf extends IInterface {

    /* renamed from: com.google.android.gms.internal.bf.a */
    public static abstract class C0582a extends Binder implements bf {

        /* renamed from: com.google.android.gms.internal.bf.a.a */
        private static class C0581a implements bf {
            private IBinder ky;

            C0581a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public bg m1686m(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    bg j = C0584a.m1692j(obtain2.readStrongBinder());
                    return j;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0582a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static bf m1687i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bf)) ? new C0581a(iBinder) : (bf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    bg m = m434m(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(m != null ? m.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    bg m434m(String str) throws RemoteException;
}
