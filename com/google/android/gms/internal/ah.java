package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;
import com.google.android.gms.internal.bf.C0582a;

public interface ah extends IInterface {

    /* renamed from: com.google.android.gms.internal.ah.a */
    public static abstract class C0571a extends Binder implements ah {

        /* renamed from: com.google.android.gms.internal.ah.a.a */
        private static class C0570a implements ah {
            private IBinder ky;

            C0570a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder m1658a(C0192b c0192b, ab abVar, String str, bf bfVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bfVar != null) {
                        iBinder = bfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public static ah m1659g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ah)) ? new C0570a(iBinder) : (ah) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = m393a(C0557a.m1641G(data.readStrongBinder()), data.readInt() != 0 ? ab.CREATOR.m382b(data) : null, data.readString(), C0582a.m1687i(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IBinder m393a(C0192b c0192b, ab abVar, String str, bf bfVar, int i) throws RemoteException;
}
