package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;

/* renamed from: com.google.android.gms.location.a */
public interface C0309a extends IInterface {

    /* renamed from: com.google.android.gms.location.a.a */
    public static abstract class C0675a extends Binder implements C0309a {

        /* renamed from: com.google.android.gms.location.a.a.a */
        private static class C0674a implements C0309a {
            private IBinder ky;

            C0674a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void onLocationChanged(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0675a() {
            attachInterface(this, "com.google.android.gms.location.ILocationListener");
        }

        public static C0309a m2145N(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0309a)) ? new C0674a(iBinder) : (C0309a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.location.ILocationListener");
                    onLocationChanged(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.ILocationListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onLocationChanged(Location location) throws RemoteException;
}
