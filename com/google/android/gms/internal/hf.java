package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;

public interface hf extends IInterface {

    /* renamed from: com.google.android.gms.internal.hf.a */
    public static abstract class C0649a extends Binder implements hf {

        /* renamed from: com.google.android.gms.internal.hf.a.a */
        private static class C0648a implements hf {
            private IBinder ky;

            C0648a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeStringArray(geofenceRequestIds);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(statusCode);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeStringArray(geofenceRequestIds);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0649a() {
            attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
        }

        public static hf m2068O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hf)) ? new C0648a(iBinder) : (hf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    onAddGeofencesResult(data.readInt(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    onRemoveGeofencesByRequestIdsResult(data.readInt(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    onRemoveGeofencesByPendingIntentResult(data.readInt(), data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onAddGeofencesResult(int i, String[] strArr) throws RemoteException;

    void onRemoveGeofencesByPendingIntentResult(int i, PendingIntent pendingIntent) throws RemoteException;

    void onRemoveGeofencesByRequestIdsResult(int i, String[] strArr) throws RemoteException;
}
