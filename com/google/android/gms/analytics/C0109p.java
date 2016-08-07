package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import java.io.File;

/* renamed from: com.google.android.gms.analytics.p */
class C0109p {
    static boolean m77B(String str) {
        if (C0109p.version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            aa.m44t("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}
