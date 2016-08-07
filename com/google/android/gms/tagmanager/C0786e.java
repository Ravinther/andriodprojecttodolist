package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C0786e extends aj {
    private static final String ID;
    private static final String TD;
    private static final String TE;
    private final Context kL;

    static {
        ID = C0211a.ADWORDS_CLICK_REFERRER.toString();
        TD = C0214b.COMPONENT.toString();
        TE = C0214b.CONVERSION_ID.toString();
    }

    public C0786e(Context context) {
        super(ID, TE);
        this.kL = context;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2336u(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(TE);
        if (c0911a == null) {
            return di.ku();
        }
        String j = di.m1345j(c0911a);
        c0911a = (C0911a) map.get(TD);
        String e = ay.m1256e(this.kL, j, c0911a != null ? di.m1345j(c0911a) : null);
        return e != null ? di.m1356r(e) : di.ku();
    }
}
