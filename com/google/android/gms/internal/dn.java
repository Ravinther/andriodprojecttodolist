package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.dm.C0600a;

public interface dn extends IInterface {

    /* renamed from: com.google.android.gms.internal.dn.a */
    public static abstract class C0602a extends Binder implements dn {

        /* renamed from: com.google.android.gms.internal.dn.a.a */
        private static class C0601a implements dn {
            private IBinder ky;

            C0601a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m1734a(dm dmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    this.ky.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1735a(dm dmVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.ky.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1736a(dm dmVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.ky.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1737a(dm dmVar, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.ky.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m1738b(dm dmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    this.ky.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1739b(dm dmVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.ky.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1740c(dm dmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(dmVar != null ? dmVar.asBinder() : null);
                    this.ky.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int cN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.ky.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int cO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.ky.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static dn m1741u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dn)) ? new C0601a(iBinder) : (dn) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int cN;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    cN = cN();
                    reply.writeNoException();
                    reply.writeInt(cN);
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    cN = cO();
                    reply.writeNoException();
                    reply.writeInt(cN);
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m603a(C0600a.m1733t(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m601a(C0600a.m1733t(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m600a(C0600a.m1733t(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m602a(C0600a.m1733t(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m605b(C0600a.m1733t(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5008:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m604b(C0600a.m1733t(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5009:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m606c(C0600a.m1733t(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m600a(dm dmVar) throws RemoteException;

    void m601a(dm dmVar, int i) throws RemoteException;

    void m602a(dm dmVar, int i, String str, byte[] bArr) throws RemoteException;

    void m603a(dm dmVar, int i, byte[] bArr) throws RemoteException;

    void m604b(dm dmVar) throws RemoteException;

    void m605b(dm dmVar, int i) throws RemoteException;

    void m606c(dm dmVar) throws RemoteException;

    int cN() throws RemoteException;

    int cO() throws RemoteException;
}
