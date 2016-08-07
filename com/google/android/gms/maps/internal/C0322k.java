package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.maps.model.internal.C0342d;
import com.google.android.gms.maps.model.internal.C0342d.C0736a;

/* renamed from: com.google.android.gms.maps.internal.k */
public interface C0322k extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.k.a */
    public static abstract class C0717a extends Binder implements C0322k {

        /* renamed from: com.google.android.gms.maps.internal.k.a.a */
        private static class C0716a implements C0322k {
            private IBinder ky;

            C0716a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public boolean m2167a(C0342d c0342d) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public C0717a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        public static C0322k ag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0322k)) ? new C0716a(iBinder) : (C0322k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean a = m1128a(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(a ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean m1128a(C0342d c0342d) throws RemoteException;
}
