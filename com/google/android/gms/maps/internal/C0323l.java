package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.maps.model.internal.C0342d;
import com.google.android.gms.maps.model.internal.C0342d.C0736a;

/* renamed from: com.google.android.gms.maps.internal.l */
public interface C0323l extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.l.a */
    public static abstract class C0719a extends Binder implements C0323l {

        /* renamed from: com.google.android.gms.maps.internal.l.a.a */
        private static class C0718a implements C0323l {
            private IBinder ky;

            C0718a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2168b(C0342d c0342d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2169c(C0342d c0342d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2170d(C0342d c0342d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(c0342d != null ? c0342d.asBinder() : null);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0719a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }

        public static C0323l ah(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0323l)) ? new C0718a(iBinder) : (C0323l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    m1129b(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    m1131d(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    m1130c(C0736a.aq(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1129b(C0342d c0342d) throws RemoteException;

    void m1130c(C0342d c0342d) throws RemoteException;

    void m1131d(C0342d c0342d) throws RemoteException;
}
