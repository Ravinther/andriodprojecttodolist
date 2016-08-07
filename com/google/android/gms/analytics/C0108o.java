package com.google.android.gms.analytics;

import com.google.analytics.tracking.android.Fields;

/* renamed from: com.google.android.gms.analytics.o */
final class C0108o {
    private static String m74b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        aa.m44t("index out of range for " + str + " (" + i + ")");
        return "";
    }

    static String m75q(int i) {
        return C0108o.m74b(Fields.SCREEN_NAME, i);
    }

    static String m76r(int i) {
        return C0108o.m74b(Fields.CAMPAIGN_MEDIUM, i);
    }
}
