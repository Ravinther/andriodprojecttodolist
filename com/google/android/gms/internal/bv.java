package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0195e;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.bw.C0589a;
import com.google.android.gms.internal.bx.C0591a;

public final class bv extends C0195e<bx> {
    private static final bv nL;

    /* renamed from: com.google.android.gms.internal.bv.a */
    private static final class C0231a extends Exception {
        public C0231a(String str) {
            super(str);
        }
    }

    static {
        nL = new bv();
    }

    private bv() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bw m1699a(Activity activity) {
        try {
            if (!m1700b(activity)) {
                return nL.m1701c(activity);
            }
            da.m562s("Using AdOverlay from the client jar.");
            return new bo(activity);
        } catch (C0231a e) {
            da.m566w(e.getMessage());
            return null;
        }
    }

    private static boolean m1700b(Activity activity) throws C0231a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0231a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private bw m1701c(Activity activity) {
        try {
            return C0589a.m1704m(((bx) m359z(activity)).m465a(C0882c.m2446h(activity)));
        } catch (Throwable e) {
            da.m560b("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            da.m560b("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m1702d(IBinder iBinder) {
        return m1703l(iBinder);
    }

    protected bx m1703l(IBinder iBinder) {
        return C0591a.m1706n(iBinder);
    }
}
