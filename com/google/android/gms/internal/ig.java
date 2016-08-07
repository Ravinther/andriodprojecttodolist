package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0291if.C0660a;

public interface ig extends IInterface {

    /* renamed from: com.google.android.gms.internal.ig.a */
    public static abstract class C0662a extends Binder implements ig {

        /* renamed from: com.google.android.gms.internal.ig.a.a */
        private static class C0661a implements ig {
            private IBinder ky;

            C0661a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2113a(C0291if c0291if, Uri uri, Bundle bundle, boolean z) throws RemoteException {
                IBinder iBinder = null;
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
                    if (c0291if != null) {
                        iBinder = c0291if.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
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
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public static ig aw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ig)) ? new C0661a(iBinder) : (ig) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
                    m985a(C0660a.av(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m985a(C0291if c0291if, Uri uri, Bundle bundle, boolean z) throws RemoteException;
}
