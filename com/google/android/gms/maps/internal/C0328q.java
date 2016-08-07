package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.C0314c.C0701a;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.mobeta.android.dslv.DragSortController;

/* renamed from: com.google.android.gms.maps.internal.q */
public class C0328q {
    private static Context PB;
    private static C0314c PC;

    public static C0314c m1135A(Context context) throws GooglePlayServicesNotAvailableException {
        er.m721f(context);
        if (PC != null) {
            return PC;
        }
        C0328q.m1136B(context);
        PC = C0328q.m1137C(context);
        try {
            PC.m1121a(C0882c.m2446h(C0328q.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return PC;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void m1136B(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case DragSortController.ON_DOWN /*0*/:
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static C0314c m1137C(Context context) {
        if (!C0328q.ha()) {
            return C0701a.m2161U((IBinder) C0328q.m1138a(C0328q.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
        Log.i(C0328q.class.getSimpleName(), "Making Creator statically");
        return (C0314c) C0328q.m1139c(C0328q.hb());
    }

    private static <T> T m1138a(ClassLoader classLoader, String str) {
        try {
            return C0328q.m1139c(((ClassLoader) er.m721f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static <T> T m1139c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (PB == null) {
            if (C0328q.ha()) {
                PB = context;
            } else {
                PB = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return PB;
    }

    private static boolean ha() {
        return false;
    }

    private static Class<?> hb() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
