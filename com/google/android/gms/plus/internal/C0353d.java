package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.fh;
import com.google.android.gms.plus.internal.C0351b.C0758a;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C0353d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d.a */
    public static abstract class C0762a extends Binder implements C0353d {

        /* renamed from: com.google.android.gms.plus.internal.d.a.a */
        private static class C0761a implements C0353d {
            private IBinder ky;

            C0761a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2226a(fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2227a(C0351b c0351b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2228a(C0351b c0351b, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2229a(C0351b c0351b, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2230a(C0351b c0351b, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void m2231a(C0351b c0351b, fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2232a(C0351b c0351b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2233a(C0351b c0351b, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2234a(C0351b c0351b, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeStringList(list);
                    this.ky.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2235b(C0351b c0351b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    this.ky.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2236b(C0351b c0351b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2237c(C0351b c0351b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2238d(C0351b c0351b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2239e(C0351b c0351b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0351b != null ? c0351b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String hl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hm() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String hn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0353d aA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0353d)) ? new C0761a(iBinder) : (C0353d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            fh fhVar = null;
            String accountName;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1195a(C0758a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1196a(C0758a.ay(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1199b(C0758a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1189a(data.readInt() != 0 ? fh.CREATOR.m761x(data) : null);
                    reply.writeNoException();
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1190a(C0758a.ay(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1193a(C0758a.ay(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    Uri uri;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0351b ay = C0758a.ay(data.readStrongBinder());
                    int readInt = data.readInt();
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    m1192a(ay, readInt, readString, uri, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1191a(C0758a.ay(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1200c(C0758a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1198b(C0758a.ay(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1197a(C0758a.ay(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1201d(C0758a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = hl();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean hm = hm();
                    reply.writeNoException();
                    reply.writeInt(hm ? 1 : 0);
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = hn();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1202e(C0758a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 45:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0351b ay2 = C0758a.ay(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        fhVar = fh.CREATOR.m761x(data);
                    }
                    m1194a(ay2, fhVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1189a(fh fhVar) throws RemoteException;

    void m1190a(C0351b c0351b) throws RemoteException;

    void m1191a(C0351b c0351b, int i, int i2, int i3, String str) throws RemoteException;

    void m1192a(C0351b c0351b, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void m1193a(C0351b c0351b, Uri uri, Bundle bundle) throws RemoteException;

    void m1194a(C0351b c0351b, fh fhVar) throws RemoteException;

    void m1195a(C0351b c0351b, String str) throws RemoteException;

    void m1196a(C0351b c0351b, String str, String str2) throws RemoteException;

    void m1197a(C0351b c0351b, List<String> list) throws RemoteException;

    void m1198b(C0351b c0351b) throws RemoteException;

    void m1199b(C0351b c0351b, String str) throws RemoteException;

    void m1200c(C0351b c0351b, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    void m1201d(C0351b c0351b, String str) throws RemoteException;

    void m1202e(C0351b c0351b, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    String hl() throws RemoteException;

    boolean hm() throws RemoteException;

    String hn() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
