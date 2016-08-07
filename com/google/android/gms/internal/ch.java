package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;

public interface ch extends IInterface {

    /* renamed from: com.google.android.gms.internal.ch.a */
    public static abstract class C0593a extends Binder implements ch {

        /* renamed from: com.google.android.gms.internal.ch.a.a */
        private static class C0592a implements ch {
            private IBinder ky;

            C0592a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public cf m1720b(cd cdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (cdVar != null) {
                        obtain.writeInt(1);
                        cdVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    cf g = obtain2.readInt() != 0 ? cf.CREATOR.m476g(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return g;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0593a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static ch m1721q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ch)) ? new C0592a(iBinder) : (ch) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    cf b = m478b(data.readInt() != 0 ? cd.CREATOR.m473f(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    cf m478b(cd cdVar) throws RemoteException;
}
