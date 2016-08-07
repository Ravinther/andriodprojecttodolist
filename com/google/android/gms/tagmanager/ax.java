package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class ax extends aj {
    private static final String ID;
    private static final String TD;
    private final Context kL;

    static {
        ID = C0211a.INSTALL_REFERRER.toString();
        TD = C0214b.COMPONENT.toString();
    }

    public ax(Context context) {
        super(ID, new String[0]);
        this.kL = context;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2268u(Map<String, C0911a> map) {
        String d = ay.m1255d(this.kL, ((C0911a) map.get(TD)) != null ? di.m1345j((C0911a) map.get(TD)) : null);
        return d != null ? di.m1356r(d) : di.ku();
    }
}
