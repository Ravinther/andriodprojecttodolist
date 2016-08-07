package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay {
    private static String Vm;
    static Map<String, String> Vn;

    static {
        Vn = new HashMap();
    }

    ay() {
    }

    static void bq(String str) {
        synchronized (ay.class) {
            Vm = str;
        }
    }

    static void m1254c(Context context, String str) {
        cz.m1337a(context, "gtm_install_referrer", "referrer", str);
        m1257e(context, str);
    }

    static String m1255d(Context context, String str) {
        if (Vm == null) {
            synchronized (ay.class) {
                if (Vm == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        Vm = sharedPreferences.getString("referrer", "");
                    } else {
                        Vm = "";
                    }
                }
            }
        }
        return m1258l(Vm, str);
    }

    static String m1256e(Context context, String str, String str2) {
        String str3 = (String) Vn.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            Vn.put(str, str3);
        }
        return m1258l(str3, str2);
    }

    static void m1257e(Context context, String str) {
        String l = m1258l(str, "conv");
        if (l != null && l.length() > 0) {
            Vn.put(l, str);
            cz.m1337a(context, "gtm_click_referrers", l, str);
        }
    }

    static String m1258l(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }
}
