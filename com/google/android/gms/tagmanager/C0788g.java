package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C0788g extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0211a.APP_NAME.toString();
    }

    public C0788g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2338u(Map<String, C0911a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return di.m1356r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m1264c("App name is not found.", e);
            return di.ku();
        }
    }
}
