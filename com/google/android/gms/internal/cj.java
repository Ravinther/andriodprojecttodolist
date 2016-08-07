package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.plus.PlusShare;
import com.mobeta.android.dslv.DragSortController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cj {
    private static final SimpleDateFormat ow;

    static {
        ow = new SimpleDateFormat("yyyyMMdd");
    }

    public static cf m479a(Context context, cd cdVar, String str) {
        try {
            cf cfVar;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString5 = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString5)) {
                i = cv.aU();
            } else if ("landscape".equals(optString5)) {
                i = cv.aT();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    da.m566w("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new cf(0);
                }
                cf a = ci.m2555a(context, cdVar.kN.pU, optString2);
                optString = a.nw;
                optString4 = a.oi;
                j = a.oo;
                cfVar = a;
            } else if (TextUtils.isEmpty(optString)) {
                da.m566w("Could not parse the mediation config: Missing required ad_base_url field");
                return new cf(0);
            } else {
                cfVar = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = cfVar == null ? null : cfVar.mt;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    list4.add(optJSONArray.getString(i2));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = cfVar == null ? null : cfVar.mu;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    list4.add(optJSONArray2.getString(i3));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            optJSONArray2 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = cfVar == null ? null : cfVar.om;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    list4.add(optJSONArray2.getString(i4));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (cfVar != null) {
                if (cfVar.orientation != -1) {
                    i = cfVar.orientation;
                }
                if (cfVar.oj > 0) {
                    j2 = cfVar.oj;
                }
            }
            return new cf(optString, optString4, list, list2, j2, false, -1, list3, -1, i, optString3, j);
        } catch (JSONException e) {
            da.m566w("Could not parse the mediation config: " + e.getMessage());
            return new cf(0);
        }
    }

    public static String m480a(cd cdVar, cm cmVar, Location location) {
        try {
            Map hashMap = new HashMap();
            if (cdVar.ob != null) {
                hashMap.put("ad_pos", cdVar.ob);
            }
            m484a((HashMap) hashMap, cdVar.oc);
            hashMap.put("format", cdVar.kQ.ln);
            if (cdVar.kQ.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (cdVar.kQ.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (cdVar.kQ.lp != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (ab abVar : cdVar.kQ.lp) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(abVar.width == -1 ? (int) (((float) abVar.widthPixels) / cmVar.pc) : abVar.width);
                    stringBuilder.append("x");
                    stringBuilder.append(abVar.height == -2 ? (int) (((float) abVar.heightPixels) / cmVar.pc) : abVar.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            hashMap.put("slotname", cdVar.adUnitId);
            hashMap.put("pn", cdVar.applicationInfo.packageName);
            if (cdVar.od != null) {
                hashMap.put("vc", Integer.valueOf(cdVar.od.versionCode));
            }
            hashMap.put("ms", cdVar.oe);
            hashMap.put("seq_num", cdVar.of);
            hashMap.put("session_id", cdVar.og);
            hashMap.put("js", cdVar.kN.pU);
            m483a((HashMap) hashMap, cmVar);
            if (cdVar.oc.versionCode >= 2 && cdVar.oc.ll != null) {
                m481a((HashMap) hashMap, cdVar.oc.ll);
            }
            if (cdVar.versionCode >= 2) {
                hashMap.put("quality_signals", cdVar.oh);
            }
            if (da.m561n(2)) {
                da.m565v("Ad Request JSON: " + cv.m541m(hashMap).toString(2));
            }
            return cv.m541m(hashMap).toString();
        } catch (JSONException e) {
            da.m566w("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    private static void m481a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m482a(HashMap<String, Object> hashMap, am amVar) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(amVar.lI) != 0) {
            hashMap.put("acolor", m486m(amVar.lI));
        }
        if (Color.alpha(amVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", m486m(amVar.backgroundColor));
        }
        if (!(Color.alpha(amVar.lJ) == 0 || Color.alpha(amVar.lK) == 0)) {
            hashMap.put("gradientto", m486m(amVar.lJ));
            hashMap.put("gradientfrom", m486m(amVar.lK));
        }
        if (Color.alpha(amVar.lL) != 0) {
            hashMap.put("bcolor", m486m(amVar.lL));
        }
        hashMap.put("bthick", Integer.toString(amVar.lM));
        switch (amVar.lN) {
            case DragSortController.ON_DOWN /*0*/:
                obj = "none";
                break;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                obj = "dashed";
                break;
            case Value.STRING_FIELD_NUMBER /*2*/:
                obj = "dotted";
                break;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (amVar.lO) {
            case DragSortController.ON_DOWN /*0*/:
                obj2 = "light";
                break;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                obj2 = "medium";
                break;
            case Value.STRING_FIELD_NUMBER /*2*/:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (amVar.lP != null) {
            hashMap.put("channel", amVar.lP);
        }
        if (Color.alpha(amVar.lQ) != 0) {
            hashMap.put("dcolor", m486m(amVar.lQ));
        }
        if (amVar.lR != null) {
            hashMap.put("font", amVar.lR);
        }
        if (Color.alpha(amVar.lS) != 0) {
            hashMap.put("hcolor", m486m(amVar.lS));
        }
        hashMap.put("headersize", Integer.toString(amVar.lT));
        if (amVar.lU != null) {
            hashMap.put("q", amVar.lU);
        }
    }

    private static void m483a(HashMap<String, Object> hashMap, cm cmVar) {
        hashMap.put("am", Integer.valueOf(cmVar.oM));
        hashMap.put("cog", m485j(cmVar.oN));
        hashMap.put("coh", m485j(cmVar.oO));
        if (!TextUtils.isEmpty(cmVar.oP)) {
            hashMap.put("carrier", cmVar.oP);
        }
        hashMap.put("gl", cmVar.oQ);
        if (cmVar.oR) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", m485j(cmVar.oS));
        hashMap.put("sp", m485j(cmVar.oT));
        hashMap.put("hl", cmVar.oU);
        if (!TextUtils.isEmpty(cmVar.oV)) {
            hashMap.put("mv", cmVar.oV);
        }
        hashMap.put("muv", Integer.valueOf(cmVar.oW));
        if (cmVar.oX != -2) {
            hashMap.put("cnt", Integer.valueOf(cmVar.oX));
        }
        hashMap.put("gnt", Integer.valueOf(cmVar.oY));
        hashMap.put("pt", Integer.valueOf(cmVar.oZ));
        hashMap.put("rm", Integer.valueOf(cmVar.pa));
        hashMap.put("riv", Integer.valueOf(cmVar.pb));
        hashMap.put("u_sd", Float.valueOf(cmVar.pc));
        hashMap.put("sh", Integer.valueOf(cmVar.pe));
        hashMap.put("sw", Integer.valueOf(cmVar.pd));
    }

    private static void m484a(HashMap<String, Object> hashMap, C0673z c0673z) {
        String aR = cs.aR();
        if (aR != null) {
            hashMap.put("abf", aR);
        }
        if (c0673z.le != -1) {
            hashMap.put("cust_age", ow.format(new Date(c0673z.le)));
        }
        if (c0673z.extras != null) {
            hashMap.put("extras", c0673z.extras);
        }
        if (c0673z.lf != -1) {
            hashMap.put("cust_gender", Integer.valueOf(c0673z.lf));
        }
        if (c0673z.lg != null) {
            hashMap.put("kw", c0673z.lg);
        }
        if (c0673z.tagForChildDirectedTreatment != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(c0673z.tagForChildDirectedTreatment));
        }
        if (c0673z.lh) {
            hashMap.put("adtest", "on");
        }
        if (c0673z.versionCode >= 2) {
            if (c0673z.li) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(c0673z.lj)) {
                hashMap.put("ppid", c0673z.lj);
            }
            if (c0673z.lk != null) {
                m482a((HashMap) hashMap, c0673z.lk);
            }
        }
        if (c0673z.versionCode >= 3 && c0673z.lm != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, c0673z.lm);
        }
    }

    private static Integer m485j(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m486m(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }
}
