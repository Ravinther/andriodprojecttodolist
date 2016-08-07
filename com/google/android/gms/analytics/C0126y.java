package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.y */
class C0126y {
    static String m84a(C0125x c0125x, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0125x.ch());
        if (c0125x.cj() > 0) {
            long cj = j - c0125x.cj();
            if (cj >= 0) {
                stringBuilder.append("&qt").append("=").append(cj);
            }
        }
        stringBuilder.append("&z").append("=").append(c0125x.ci());
        return stringBuilder.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    static Map<String, String> m85s(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
