package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C0789h extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0211a.APP_VERSION.toString();
    }

    public C0789h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2339u(Map<String, C0911a> map) {
        try {
            return di.m1356r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m1266t("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return di.ku();
        }
    }
}
