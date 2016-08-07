package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0130a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0304t;
import com.google.android.gms.internal.C0304t.C0671a;
import com.google.android.gms.internal.er;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String kF;
        private final boolean kG;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.kF = advertisingId;
            this.kG = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.kF;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kG;
        }
    }

    static Info m20a(Context context, C0130a c0130a) throws IOException {
        try {
            C0304t b = C0671a.m2138b(c0130a.dm());
            Info info = new Info(b.getId(), b.m1102a(true));
            try {
                context.unbindService(c0130a);
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (Throwable e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(c0130a);
            } catch (Throwable e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
        }
    }

    private static C0130a m21g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m129s(context);
                Object c0130a = new C0130a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0130a, 1)) {
                    return c0130a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        er.ad("Calling this from your main thread can lead to deadlock");
        return m20a(context, m21g(context));
    }
}
