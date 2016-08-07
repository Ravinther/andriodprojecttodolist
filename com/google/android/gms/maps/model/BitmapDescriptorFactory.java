package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.model.internal.C0339a;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static C0339a PE;

    private BitmapDescriptorFactory() {
    }

    public static void m1140a(C0339a c0339a) {
        if (PE == null) {
            PE = (C0339a) er.m721f(c0339a);
        }
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(hd().hi());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor defaultMarker(float hue) {
        try {
            return new BitmapDescriptor(hd().m1163c(hue));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromAsset(String assetName) {
        try {
            return new BitmapDescriptor(hd().aL(assetName));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap image) {
        try {
            return new BitmapDescriptor(hd().m1162b(image));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromFile(String fileName) {
        try {
            return new BitmapDescriptor(hd().aM(fileName));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromPath(String absolutePath) {
        try {
            return new BitmapDescriptor(hd().aN(absolutePath));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromResource(int resourceId) {
        try {
            return new BitmapDescriptor(hd().bz(resourceId));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static C0339a hd() {
        return (C0339a) er.m719b(PE, (Object) "IBitmapDescriptorFactory is not initialized");
    }
}
