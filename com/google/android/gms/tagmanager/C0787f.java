package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C0787f extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0211a.APP_ID.toString();
    }

    public C0787f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2337u(Map<String, C0911a> map) {
        return di.m1356r(this.mContext.getPackageName());
    }
}
