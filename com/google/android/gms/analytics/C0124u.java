package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.u */
class C0124u {
    private static final C0124u sk;
    private SortedSet<C0123a> sh;
    private StringBuilder si;
    private boolean sj;

    /* renamed from: com.google.android.gms.analytics.u.a */
    public enum C0123a {
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        GET,
        SET,
        SEND,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        BLANK_37,
        BLANK_38,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        GET_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_46,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        BLANK_52,
        BLANK_53,
        SET_DRY_RUN,
        GET_DRY_RUN,
        SET_LOGGER,
        SET_FORCE_LOCAL_DISPATCH,
        GET_TRACKER_NAME,
        CLOSE_TRACKER,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        CONSTRUCT_APP_VIEW
    }

    static {
        sk = new C0124u();
    }

    private C0124u() {
        this.sh = new TreeSet();
        this.si = new StringBuilder();
        this.sj = false;
    }

    public static C0124u bR() {
        return sk;
    }

    public synchronized void m80a(C0123a c0123a) {
        if (!this.sj) {
            this.sh.add(c0123a);
            this.si.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(c0123a.ordinal()));
        }
    }

    public synchronized String bS() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.sh.size() > 0) {
            C0123a c0123a = (C0123a) this.sh.first();
            this.sh.remove(c0123a);
            int ordinal = c0123a.ordinal();
            while (ordinal >= i) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (c0123a.ordinal() % 6);
        }
        if (i2 > 0 || stringBuilder.length() == 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.sh.clear();
        return stringBuilder.toString();
    }

    public synchronized String bT() {
        String stringBuilder;
        if (this.si.length() > 0) {
            this.si.insert(0, ".");
        }
        stringBuilder = this.si.toString();
        this.si = new StringBuilder();
        return stringBuilder;
    }

    public synchronized void m81r(boolean z) {
        this.sj = z;
    }
}
