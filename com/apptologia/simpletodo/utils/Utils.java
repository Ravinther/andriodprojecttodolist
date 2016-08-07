package com.apptologia.simpletodo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

public class Utils {
    private static SharedPreferences prefs;
    public static Boolean situation;

    static {
        situation = Boolean.valueOf(false);
    }

    public static void savePrefs(Context ctx, String key, String value) {
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPrefValue(Context ctx, String key, String defValue) {
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(key, defValue);
    }

    public static boolean adManagement(Context ctx, String adType, int count) {
        int ad;
        boolean result = false;
        if (adType.equals("banner")) {
            ad = 0;
        } else {
            ad = 1;
        }
        switch (ad) {
            case DragSortController.ON_DOWN /*0*/:
                int counter = Integer.valueOf(getPrefValue(ctx, "adcounter_banner", "0")).intValue();
                if (counter < count) {
                    result = false;
                } else {
                    result = true;
                }
                savePrefs(ctx, "adcounter_banner", String.valueOf(counter + 1));
                break;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                int counter_ = Integer.valueOf(getPrefValue(ctx, "adcounter_interstital", "0")).intValue();
                if (counter_ == 0 || counter_ % count != 0) {
                    result = false;
                } else {
                    result = true;
                }
                savePrefs(ctx, "adcounter_interstital", String.valueOf(counter_ + 1));
                break;
        }
        return result;
    }

    public static boolean adCounter(Context ctx, String adType, int count) {
        int ad;
        if (adType.equals("banner")) {
            ad = 0;
        } else {
            ad = 1;
        }
        switch (ad) {
            case DragSortController.ON_DOWN /*0*/:
                if (Integer.valueOf(getPrefValue(ctx, "adcounter_banner", "0")).intValue() < count) {
                    return false;
                }
                return true;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                int counter_ = Integer.valueOf(getPrefValue(ctx, "adcounter_interstital", "0")).intValue();
                if (counter_ == 0 || counter_ % count != 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public static void rateMeCounter(Context ctx, int first, int second, int third) {
        int counter = Integer.valueOf(getPrefValue(ctx, "rateme_counter", "0")).intValue();
        if (counter == first) {
            UiUtils.ratemeDialog(ctx, 1, third).show();
        } else if (counter == second) {
            UiUtils.ratemeDialog(ctx, 2, third).show();
        } else if (counter == second) {
            UiUtils.ratemeDialog(ctx, 3, third).show();
        }
        savePrefs(ctx, "rateme_counter", String.valueOf(counter + 1));
    }
}
