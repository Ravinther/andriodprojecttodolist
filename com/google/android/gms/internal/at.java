package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class at implements ar {
    private static int m1672a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = cz.m553a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                da.m566w("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void m1673a(dd ddVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            da.m566w("Action missing from video GMSG.");
            return;
        }
        bo ba = ddVar.ba();
        if (ba == null) {
            da.m566w("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = ddVar.getContext().getResources().getDisplayMetrics();
            a = m1672a(displayMetrics, map, "x", 0);
            int a2 = m1672a(displayMetrics, map, "y", 0);
            int a3 = m1672a(displayMetrics, map, "w", -1);
            int a4 = m1672a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && ba.ap() == null) {
                ba.m2491c(a, a2, a3, a4);
                return;
            } else {
                ba.m2490b(a, a2, a3, a4);
                return;
            }
        }
        bs ap = ba.ap();
        if (ap == null) {
            bs.m457a(ddVar, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = ddVar.getContext().getResources().getDisplayMetrics();
            int a5 = m1672a(displayMetrics, map, "x", 0);
            a = m1672a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            ap.m460b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                da.m566w("Enabled parameter missing from controls video GMSG.");
            } else {
                ap.m461i(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                da.m566w("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                ap.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                da.m566w("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            ap.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            ap.ay();
        } else if ("pause".equalsIgnoreCase(str)) {
            ap.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            ap.play();
        } else if ("show".equalsIgnoreCase(str)) {
            ap.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            ap.m462o((String) map.get("src"));
        } else {
            da.m566w("Unknown video action: " + str);
        }
    }
}
