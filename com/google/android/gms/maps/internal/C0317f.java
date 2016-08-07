package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.maps.model.internal.C0342d;
import com.google.android.gms.maps.model.internal.C0342d.C0736a;

/* renamed from: com.google.android.gms.maps.internal.f */
public interface C0317f extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.f.a */
    public static abstract class C0707a extends Binder implements C0317f {

        /* renamed from: com.google.android.gms.maps.internal.f.a.a */
        private static class C0706a implements C0317f {
            private IBinder ky;

            C0706a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2165e(C0342d c0342d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0707a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        }

        public static C0317f ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0317f)) ? new C0706a(iBinder) : (C0317f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    m1126e(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1126e(C0342d c0342d) throws RemoteException;
}
