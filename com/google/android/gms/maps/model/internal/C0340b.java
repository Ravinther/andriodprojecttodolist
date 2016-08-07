package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.model.internal.b */
public interface C0340b extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.b.a */
    public static abstract class C0732a extends Binder implements C0340b {

        /* renamed from: com.google.android.gms.maps.model.internal.b.a.a */
        private static class C0731a implements C0340b {
            private IBinder ky;

            C0731a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public boolean m2185a(C0340b c0340b) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    obtain.writeStrongBinder(c0340b != null ? c0340b.asBinder() : null);
                    this.ky.transact(17, obtain, obtain2, 0);
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

            public IBinder asBinder() {
                return this.ky;
            }

            public LatLng getCenter() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    LatLng createFromParcel = obtain2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getFillColor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public double getRadius() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    double readDouble = obtain2.readDouble();
                    return readDouble;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getStrokeColor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getStrokeWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getZIndex() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hashCodeRemote() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isVisible() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(16, obtain, obtain2, 0);
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

            public void remove() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCenter(LatLng center) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    if (center != null) {
                        obtain.writeInt(1);
                        center.writeToParcel(obtain, 0);
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

            public void setFillColor(int color) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    obtain.writeInt(color);
                    this.ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRadius(double radius) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    obtain.writeDouble(radius);
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setStrokeColor(int color) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    obtain.writeInt(color);
                    this.ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setStrokeWidth(float width) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    obtain.writeFloat(width);
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVisible(boolean visible) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    if (visible) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setZIndex(float zIndex) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    obtain.writeFloat(zIndex);
                    this.ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0340b ao(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0340b)) ? new C0731a(iBinder) : (C0340b) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            float strokeWidth;
            boolean isVisible;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    remove();
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    String id = getId();
                    reply.writeNoException();
                    reply.writeString(id);
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    setCenter(data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    LatLng center = getCenter();
                    reply.writeNoException();
                    if (center != null) {
                        reply.writeInt(1);
                        center.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    setRadius(data.readDouble());
                    reply.writeNoException();
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    double radius = getRadius();
                    reply.writeNoException();
                    reply.writeDouble(radius);
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    setStrokeWidth(data.readFloat());
                    reply.writeNoException();
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    strokeWidth = getStrokeWidth();
                    reply.writeNoException();
                    reply.writeFloat(strokeWidth);
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    setStrokeColor(data.readInt());
                    reply.writeNoException();
                    return true;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    i = getStrokeColor();
                    reply.writeNoException();
                    reply.writeInt(i);
                    return true;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    setFillColor(data.readInt());
                    reply.writeNoException();
                    return true;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    i = getFillColor();
                    reply.writeNoException();
                    reply.writeInt(i);
                    return true;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    setZIndex(data.readFloat());
                    reply.writeNoException();
                    return true;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    strokeWidth = getZIndex();
                    reply.writeNoException();
                    reply.writeFloat(strokeWidth);
                    return true;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    boolean z;
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setVisible(z);
                    reply.writeNoException();
                    return true;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    isVisible = isVisible();
                    reply.writeNoException();
                    if (isVisible) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    isVisible = m1164a(C0732a.ao(data.readStrongBinder()));
                    reply.writeNoException();
                    if (isVisible) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    i = hashCodeRemote();
                    reply.writeNoException();
                    reply.writeInt(i);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean m1164a(C0340b c0340b) throws RemoteException;

    LatLng getCenter() throws RemoteException;

    int getFillColor() throws RemoteException;

    String getId() throws RemoteException;

    double getRadius() throws RemoteException;

    int getStrokeColor() throws RemoteException;

    float getStrokeWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setCenter(LatLng latLng) throws RemoteException;

    void setFillColor(int i) throws RemoteException;

    void setRadius(double d) throws RemoteException;

    void setStrokeColor(int i) throws RemoteException;

    void setStrokeWidth(float f) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    void setZIndex(float f) throws RemoteException;
}
