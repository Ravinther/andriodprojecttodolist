package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0192b.C0557a;

/* renamed from: com.google.android.gms.plus.internal.c */
public interface C0352c extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.c.a */
    public static abstract class C0760a extends Binder implements C0352c {

        /* renamed from: com.google.android.gms.plus.internal.c.a.a */
        private static class C0759a implements C0352c {
            private IBinder ky;

            C0759a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public C0192b m2224a(C0192b c0192b, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0192b m2225a(C0192b c0192b, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0192b != null ? c0192b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0192b G = C0557a.m1641G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public static C0352c az(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0352c)) ? new C0759a(iBinder) : (C0352c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0192b a;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = m1187a(C0557a.m1641G(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = m1188a(C0557a.m1641G(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0192b m1187a(C0192b c0192b, int i, int i2, String str, int i3) throws RemoteException;

    C0192b m1188a(C0192b c0192b, int i, int i2, String str, String str2) throws RemoteException;
}
