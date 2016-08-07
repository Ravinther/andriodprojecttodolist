package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.hf.C0649a;
import com.google.android.gms.internal.hv.C0656a;
import com.google.android.gms.internal.hx.C0657a;
import com.google.android.gms.location.C0309a;
import com.google.android.gms.location.C0309a.C0675a;
import com.google.android.gms.location.C0676b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface hg extends IInterface {

    /* renamed from: com.google.android.gms.internal.hg.a */
    public static abstract class C0651a extends Binder implements hg {

        /* renamed from: com.google.android.gms.internal.hg.a.a */
        private static class C0650a implements hg {
            private IBinder ky;

            C0650a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2069a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2070a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2071a(PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2072a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.ky.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2073a(hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2074a(hn hnVar, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2075a(hp hpVar, id idVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hpVar != null) {
                        obtain.writeInt(1);
                        hpVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2076a(hr hrVar, id idVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hrVar != null) {
                        obtain.writeInt(1);
                        hrVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2077a(id idVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2078a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2079a(LocationRequest locationRequest, C0309a c0309a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0309a != null ? c0309a.asBinder() : null);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2080a(LocationRequest locationRequest, C0309a c0309a, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0309a != null ? c0309a.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2081a(C0309a c0309a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(c0309a != null ? c0309a.asBinder() : null);
                    this.ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2082a(LatLng latLng, hn hnVar, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2083a(LatLngBounds latLngBounds, int i, hn hnVar, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2084a(String str, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2085a(List<C0657a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    this.ky.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2086a(List<hj> list, PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2087a(String[] strArr, hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location aF(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.ky.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0676b aG(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.ky.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    C0676b au = obtain2.readInt() != 0 ? C0676b.CREATOR.au(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return au;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2088b(String str, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location gk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static hg m2089P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hg)) ? new C0650a(iBinder) : (hg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            Location location = null;
            PendingIntent pendingIntent;
            LocationRequest createFromParcel;
            String readString;
            id aD;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    List createTypedArrayList = data.createTypedArrayList(hj.CREATOR);
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m970a(createTypedArrayList, pendingIntent, C0649a.m2068O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m955a(pendingIntent, C0649a.m2068O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m971a(data.createStringArray(), C0649a.m2068O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m957a(C0649a.m2068O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    long readLong = data.readLong();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m953a(readLong, z, pendingIntent);
                    reply.writeNoException();
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    removeActivityUpdates(pendingIntent);
                    reply.writeNoException();
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    location = gk();
                    reply.writeNoException();
                    if (location != null) {
                        reply.writeInt(1);
                        location.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    m963a(createFromParcel, C0675a.m2145N(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationRequest createFromParcel2 = data.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m962a(createFromParcel2, pendingIntent);
                    reply.writeNoException();
                    return true;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m965a(C0675a.m2145N(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m954a(pendingIntent);
                    reply.writeNoException();
                    return true;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMockMode(z);
                    reply.writeNoException();
                    return true;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        location = (Location) Location.CREATOR.createFromParcel(data);
                    }
                    setMockLocation(location);
                    reply.writeNoException();
                    return true;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m967a(data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt() != 0 ? hn.CREATOR.aw(data) : null, data.readInt() != 0 ? id.CREATOR.aD(data) : null, C0656a.m2098R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m968a(readString, aD, C0656a.m2098R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLng createFromParcel3 = data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null;
                    hn aw = data.readInt() != 0 ? hn.CREATOR.aw(data) : null;
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m966a(createFromParcel3, aw, aD, C0656a.m2098R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hn aw2 = data.readInt() != 0 ? hn.CREATOR.aw(data) : null;
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m958a(aw2, aD, C0656a.m2098R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hr ay = data.readInt() != 0 ? hr.CREATOR.ay(data) : null;
                    id aD2 = data.readInt() != 0 ? id.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m960a(ay, aD2, pendingIntent);
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    id aD3 = data.readInt() != 0 ? id.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m961a(aD3, pendingIntent);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    m964a(createFromParcel, C0675a.m2145N(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    location = aF(data.readString());
                    reply.writeNoException();
                    if (location != null) {
                        reply.writeInt(1);
                        location.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m969a(data.createTypedArrayList(C0657a.CREATOR));
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hp ax = data.readInt() != 0 ? hp.CREATOR.ax(data) : null;
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m959a(ax, aD);
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        location = (Location) Location.CREATOR.createFromParcel(data);
                    }
                    m956a(location, data.readInt());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    C0676b aG = aG(data.readString());
                    reply.writeNoException();
                    if (aG != null) {
                        reply.writeInt(1);
                        aG.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m972b(readString, aD, C0656a.m2098R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m953a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void m954a(PendingIntent pendingIntent) throws RemoteException;

    void m955a(PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException;

    void m956a(Location location, int i) throws RemoteException;

    void m957a(hf hfVar, String str) throws RemoteException;

    void m958a(hn hnVar, id idVar, hv hvVar) throws RemoteException;

    void m959a(hp hpVar, id idVar) throws RemoteException;

    void m960a(hr hrVar, id idVar, PendingIntent pendingIntent) throws RemoteException;

    void m961a(id idVar, PendingIntent pendingIntent) throws RemoteException;

    void m962a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void m963a(LocationRequest locationRequest, C0309a c0309a) throws RemoteException;

    void m964a(LocationRequest locationRequest, C0309a c0309a, String str) throws RemoteException;

    void m965a(C0309a c0309a) throws RemoteException;

    void m966a(LatLng latLng, hn hnVar, id idVar, hv hvVar) throws RemoteException;

    void m967a(LatLngBounds latLngBounds, int i, hn hnVar, id idVar, hv hvVar) throws RemoteException;

    void m968a(String str, id idVar, hv hvVar) throws RemoteException;

    void m969a(List<C0657a> list) throws RemoteException;

    void m970a(List<hj> list, PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException;

    void m971a(String[] strArr, hf hfVar, String str) throws RemoteException;

    Location aF(String str) throws RemoteException;

    C0676b aG(String str) throws RemoteException;

    void m972b(String str, id idVar, hv hvVar) throws RemoteException;

    Location gk() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
