package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.tracking.android.Fields;

/* renamed from: com.google.android.gms.analytics.g */
class C0508g implements C0106m {
    private static Object qI;
    private static C0508g qV;
    protected String qR;
    protected String qS;
    protected String qT;
    protected String qU;

    static {
        qI = new Object();
    }

    protected C0508g() {
    }

    private C0508g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.qT = context.getPackageName();
        this.qU = packageManager.getInstallerPackageName(this.qT);
        String str = this.qT;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            aa.m44t("Error retrieving package info: appName set to " + str);
        }
        this.qR = str;
        this.qS = str2;
    }

    public static C0508g bt() {
        return qV;
    }

    public static void m1456n(Context context) {
        synchronized (qI) {
            if (qV == null) {
                qV = new C0508g(context);
            }
        }
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals(Fields.APP_NAME)) {
            return this.qR;
        }
        if (field.equals(Fields.APP_VERSION)) {
            return this.qS;
        }
        if (field.equals(Fields.APP_ID)) {
            return this.qT;
        }
        return field.equals(Fields.APP_INSTALLER_ID) ? this.qU : null;
    }

    public boolean m1457x(String str) {
        return Fields.APP_NAME.equals(str) || Fields.APP_VERSION.equals(str) || Fields.APP_ID.equals(str) || Fields.APP_INSTALLER_ID.equals(str);
    }
}
