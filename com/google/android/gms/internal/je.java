package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.jf.C0666a;
import com.google.android.gms.wallet.C0808d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public interface je extends IInterface {

    /* renamed from: com.google.android.gms.internal.je.a */
    public static abstract class C0664a extends Binder implements je {

        /* renamed from: com.google.android.gms.internal.je.a.a */
        private static class C0663a implements je {
            private IBinder ky;

            C0663a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2115a(Bundle bundle, jf jfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jfVar != null) {
                        iBinder = jfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2116a(FullWalletRequest fullWalletRequest, Bundle bundle, jf jfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jfVar != null) {
                        iBinder = jfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2117a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, jf jfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jfVar != null) {
                        iBinder = jfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2118a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2119a(C0808d c0808d, Bundle bundle, jf jfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (c0808d != null) {
                        obtain.writeInt(1);
                        c0808d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jfVar != null) {
                        iBinder = jfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2120a(String str, String str2, Bundle bundle, jf jfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jfVar != null) {
                        iBinder = jfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public static je aC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof je)) ? new C0663a(iBinder) : (je) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1000a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0666a.aD(data.readStrongBinder()));
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m999a(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0666a.aD(data.readStrongBinder()));
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1003a(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0666a.aD(data.readStrongBinder()));
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1001a(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m998a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0666a.aD(data.readStrongBinder()));
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1002a(data.readInt() != 0 ? (C0808d) C0808d.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0666a.aD(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m998a(Bundle bundle, jf jfVar) throws RemoteException;

    void m999a(FullWalletRequest fullWalletRequest, Bundle bundle, jf jfVar) throws RemoteException;

    void m1000a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, jf jfVar) throws RemoteException;

    void m1001a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void m1002a(C0808d c0808d, Bundle bundle, jf jfVar) throws RemoteException;

    void m1003a(String str, String str2, Bundle bundle, jf jfVar) throws RemoteException;
}
