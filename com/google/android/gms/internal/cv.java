package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.cast.Cast;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cv {
    private static final Object op;
    private static boolean pO;
    private static String pP;
    private static boolean pQ;

    /* renamed from: com.google.android.gms.internal.cv.1 */
    static class C02451 implements Runnable {
        final /* synthetic */ Context os;

        C02451(Context context) {
            this.os = context;
        }

        public void run() {
            synchronized (cv.op) {
                cv.pP = cv.m539j(this.os);
                cv.op.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cv.a */
    private static final class C0246a extends BroadcastReceiver {
        private C0246a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                cv.pO = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                cv.pO = false;
            }
        }
    }

    static {
        op = new Object();
        pO = true;
        pQ = false;
    }

    public static String m523a(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    private static JSONArray m524a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m531a(jSONArray, a);
        }
        return jSONArray;
    }

    static JSONArray m525a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m531a(jSONArray, a);
        }
        return jSONArray;
    }

    private static JSONObject m526a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m532a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m527a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m535b(context, str));
    }

    public static void m528a(Context context, String str, List<String> list) {
        for (String cyVar : list) {
            new cy(context, str, cyVar).start();
        }
    }

    public static void m529a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m535b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static void m530a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            cw.m547a(webView);
        }
    }

    private static void m531a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m526a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m541m((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m524a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m525a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private static void m532a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m526a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m541m((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m524a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m524a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean m533a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static boolean m534a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public static boolean aS() {
        return pO;
    }

    public static int aT() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    public static int aU() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    private static String m535b(Context context, String str) {
        String str2;
        synchronized (op) {
            if (pP != null) {
                str2 = pP;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    pP = cx.getDefaultUserAgent(context);
                } else if (cz.aX()) {
                    pP = m539j(context);
                } else {
                    cz.pT.post(new C02451(context));
                    while (pP == null) {
                        try {
                            op.wait();
                        } catch (InterruptedException e) {
                            str2 = pP;
                        }
                    }
                }
                pP += " (Mobile; " + str + ")";
                str2 = pP;
            }
        }
        return str2;
    }

    public static void m536b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            cw.m548b(webView);
        }
    }

    public static boolean m537h(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, Cast.MAX_MESSAGE_LENGTH);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            da.m566w("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            da.m566w(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            da.m566w(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
            da.m566w(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) == 0) {
            da.m566w(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) == 0) {
            da.m566w(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) == 0) {
            da.m566w(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) != 0) {
            return z;
        }
        da.m566w(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public static void m538i(Context context) {
        if (!pQ) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C0246a(), intentFilter);
            pQ = true;
        }
    }

    private static String m539j(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public static JSONObject m541m(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m532a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public static String m543p(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }
}
