package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.dynamic.b */
public interface C0192b extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.b.a */
    public static abstract class C0557a extends Binder implements C0192b {

        /* renamed from: com.google.android.gms.dynamic.b.a.a */
        private static class C0556a implements C0192b {
            private IBinder ky;

            C0556a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public C0557a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C0192b m1641G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0192b)) ? new C0556a(iBinder) : (C0192b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
