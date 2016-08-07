package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0195e;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.ag.C0569a;
import com.google.android.gms.internal.ah.C0571a;

/* renamed from: com.google.android.gms.internal.y */
public final class C0672y extends C0195e<ah> {
    private static final C0672y ld;

    static {
        ld = new C0672y();
    }

    private C0672y() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ag m2139a(Context context, ab abVar, String str, be beVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ag b = ld.m2140b(context, abVar, str, beVar);
            if (b != null) {
                return b;
            }
        }
        da.m562s("Using AdManager from the client jar.");
        return new C0959v(context, abVar, str, beVar, new db(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private ag m2140b(Context context, ab abVar, String str, be beVar) {
        try {
            return C0569a.m1657f(((ah) m359z(context)).m393a(C0882c.m2446h(context), abVar, str, beVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            da.m560b("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            da.m560b("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected ah m2141c(IBinder iBinder) {
        return C0571a.m1659g(iBinder);
    }

    protected /* synthetic */ Object m2142d(IBinder iBinder) {
        return m2141c(iBinder);
    }
}
