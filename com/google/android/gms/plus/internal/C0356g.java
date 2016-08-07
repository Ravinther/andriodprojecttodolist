package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.er;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C0352c.C0760a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C0356g {
    private static Context PB;
    private static C0352c Rl;

    /* renamed from: com.google.android.gms.plus.internal.g.a */
    public static class C0355a extends Exception {
        public C0355a(String str) {
            super(str);
        }
    }

    private static C0352c m1204D(Context context) throws C0355a {
        er.m721f(context);
        if (Rl == null) {
            if (PB == null) {
                PB = GooglePlayServicesUtil.getRemoteContext(context);
                if (PB == null) {
                    throw new C0355a("Could not get remote context.");
                }
            }
            try {
                Rl = C0760a.az((IBinder) PB.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0355a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0355a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0355a("Could not access creator.");
            }
        }
        return Rl;
    }

    public static View m1205a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0882c.m2445b(C0356g.m1204D(context).m1187a(C0882c.m2446h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
