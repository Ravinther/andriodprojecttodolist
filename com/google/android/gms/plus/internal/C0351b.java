package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.ir;

/* renamed from: com.google.android.gms.plus.internal.b */
public interface C0351b extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.b.a */
    public static abstract class C0758a extends Binder implements C0351b {

        /* renamed from: com.google.android.gms.plus.internal.b.a.a */
        private static class C0757a implements C0351b {
            private IBinder ky;

            C0757a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2216L(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2217a(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2218a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2219a(int i, Bundle bundle, fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
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

            public void m2220a(int i, ir irVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (irVar != null) {
                        obtain.writeInt(1);
                        irVar.writeToParcel(obtain, 0);
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

            public void m2221a(DataHolder dataHolder, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2222a(DataHolder dataHolder, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aP(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeString(str);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aQ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeString(str);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2223d(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0758a() {
            attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
        }

        public static C0351b ay(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0351b)) ? new C0757a(iBinder) : (C0351b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            DataHolder createFromParcel;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    m1180a(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    m1181a(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    aP(data.readString());
                    reply.writeNoException();
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = DataHolder.CREATOR.createFromParcel(data);
                    }
                    m1184a(createFromParcel, data.readString());
                    reply.writeNoException();
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    fh x;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    int readInt = data.readInt();
                    Bundle bundle = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        x = fh.CREATOR.m761x(data);
                    }
                    m1182a(readInt, bundle, x);
                    reply.writeNoException();
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = DataHolder.CREATOR.createFromParcel(data);
                    }
                    m1185a(createFromParcel, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    m1186d(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    aQ(data.readString());
                    reply.writeNoException();
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    ir aI;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    int readInt2 = data.readInt();
                    if (data.readInt() != 0) {
                        aI = ir.CREATOR.aI(data);
                    }
                    m1183a(readInt2, aI);
                    reply.writeNoException();
                    return true;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (data.readInt() != 0) {
                        status = Status.CREATOR.createFromParcel(data);
                    }
                    m1179L(status);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1179L(Status status) throws RemoteException;

    void m1180a(int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    void m1181a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void m1182a(int i, Bundle bundle, fh fhVar) throws RemoteException;

    void m1183a(int i, ir irVar) throws RemoteException;

    void m1184a(DataHolder dataHolder, String str) throws RemoteException;

    void m1185a(DataHolder dataHolder, String str, String str2) throws RemoteException;

    void aP(String str) throws RemoteException;

    void aQ(String str) throws RemoteException;

    void m1186d(int i, Bundle bundle) throws RemoteException;
}
