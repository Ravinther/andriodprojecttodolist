package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0195e;
import com.google.android.gms.dynamic.C0195e.C0194a;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.eo.C0616a;

public final class es extends C0195e<eo> {
    private static final es Cg;

    static {
        Cg = new es();
    }

    private es() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m1825d(Context context, int i, int i2) throws C0194a {
        return Cg.m1826e(context, i, i2);
    }

    private View m1826e(Context context, int i, int i2) throws C0194a {
        try {
            return (View) C0882c.m2445b(((eo) m359z(context)).m711a(C0882c.m2446h(context), i, i2));
        } catch (Throwable e) {
            throw new C0194a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public eo m1827B(IBinder iBinder) {
        return C0616a.m1824A(iBinder);
    }

    public /* synthetic */ Object m1828d(IBinder iBinder) {
        return m1827B(iBinder);
    }
}
