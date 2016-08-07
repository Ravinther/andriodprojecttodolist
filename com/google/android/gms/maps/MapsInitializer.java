package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.C0314c;
import com.google.android.gms.maps.internal.C0328q;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        er.m721f(context);
        try {
            C0314c A = C0328q.m1135A(context);
            try {
                CameraUpdateFactory.m1115a(A.gY());
                BitmapDescriptorFactory.m1140a(A.gZ());
                return 0;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
            return e2.errorCode;
        }
    }
}
