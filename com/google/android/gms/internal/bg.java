package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;
import com.google.android.gms.internal.bh.C0586a;

public interface bg extends IInterface {

    /* renamed from: com.google.android.gms.internal.bg.a */
    public static abstract class C0584a extends Binder implements bg {

        /* renamed from: com.google.android.gms.internal.bg.a.a */
        private static class C0583a implements bg {
            private IBinder ky;

            C0583a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m1688a(C0192b c0192b, ab abVar, C0673z c0673z, String str, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0673z != null) {
                        obtain.writeInt(1);
                        c0673z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1689a(C0192b c0192b, ab abVar, C0673z c0673z, String str, String str2, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0673z != null) {
                        obtain.writeInt(1);
                        c0673z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1690a(C0192b c0192b, C0673z c0673z, String str, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    if (c0673z != null) {
                        obtain.writeInt(1);
                        c0673z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1691a(C0192b c0192b, C0673z c0673z, String str, String str2, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    if (c0673z != null) {
                        obtain.writeInt(1);
                        c0673z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0584a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static bg m1692j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bg)) ? new C0583a(iBinder) : (bg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            C0673z c0673z = null;
            C0192b view;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m435a(C0557a.m1641G(data.readStrongBinder()), data.readInt() != 0 ? ab.CREATOR.m382b(data) : null, data.readInt() != 0 ? C0673z.CREATOR.m379a(data) : null, data.readString(), C0586a.m1694k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = C0557a.m1641G(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c0673z = C0673z.CREATOR.m379a(data);
                    }
                    m437a(view, c0673z, data.readString(), C0586a.m1694k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    reply.writeNoException();
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m436a(C0557a.m1641G(data.readStrongBinder()), data.readInt() != 0 ? ab.CREATOR.m382b(data) : null, data.readInt() != 0 ? C0673z.CREATOR.m379a(data) : null, data.readString(), data.readString(), C0586a.m1694k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m438a(C0557a.m1641G(data.readStrongBinder()), data.readInt() != 0 ? C0673z.CREATOR.m379a(data) : null, data.readString(), data.readString(), C0586a.m1694k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m435a(C0192b c0192b, ab abVar, C0673z c0673z, String str, bh bhVar) throws RemoteException;

    void m436a(C0192b c0192b, ab abVar, C0673z c0673z, String str, String str2, bh bhVar) throws RemoteException;

    void m437a(C0192b c0192b, C0673z c0673z, String str, bh bhVar) throws RemoteException;

    void m438a(C0192b c0192b, C0673z c0673z, String str, String str2, bh bhVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0192b getView() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
