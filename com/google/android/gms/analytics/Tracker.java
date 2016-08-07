package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.HitTypes;
import com.google.android.gms.analytics.C0124u.C0123a;
import com.google.android.gms.analytics.GoogleAnalytics.C0088a;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Tracker {
    private final TrackerHandler up;
    private final Map<String, String> uq;
    private ad ur;
    private final C0509h us;
    private final ae ut;
    private final C0508g uu;
    private boolean uv;
    private C0503a uw;
    private aj ux;

    /* renamed from: com.google.android.gms.analytics.Tracker.a */
    private class C0503a implements C0088a {
        private C0101i rJ;
        private boolean uA;
        private boolean uB;
        private int uC;
        private long uD;
        private boolean uE;
        private long uF;
        final /* synthetic */ Tracker uG;
        private Timer uy;
        private TimerTask uz;

        /* renamed from: com.google.android.gms.analytics.Tracker.a.a */
        private class C0091a extends TimerTask {
            final /* synthetic */ C0503a uI;

            private C0091a(C0503a c0503a) {
                this.uI = c0503a;
            }

            public void run() {
                this.uI.uA = false;
            }
        }

        /* renamed from: com.google.android.gms.analytics.Tracker.a.1 */
        class C05021 implements C0101i {
            final /* synthetic */ Tracker uH;
            final /* synthetic */ C0503a uI;

            C05021(C0503a c0503a, Tracker tracker) {
                this.uI = c0503a;
                this.uH = tracker;
            }

            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        }

        public C0503a(Tracker tracker) {
            this.uG = tracker;
            this.uA = false;
            this.uB = false;
            this.uC = 0;
            this.uD = -1;
            this.uE = false;
            this.rJ = new C05021(this, tracker);
        }

        private void cx() {
            GoogleAnalytics cf = GoogleAnalytics.cf();
            if (cf == null) {
                aa.m44t("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.uD >= 0 || this.uB) {
                cf.m1413a(this.uG.uw);
            } else {
                cf.m1415b(this.uG.uw);
            }
        }

        private synchronized void cy() {
            if (this.uy != null) {
                this.uy.cancel();
                this.uy = null;
            }
        }

        public long cu() {
            return this.uD;
        }

        public boolean cv() {
            return this.uB;
        }

        public boolean cw() {
            boolean z = this.uE;
            this.uE = false;
            return z;
        }

        boolean cz() {
            return this.uD == 0 || (this.uD > 0 && this.rJ.currentTimeMillis() > this.uF + this.uD);
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.uB = enabled;
            cx();
        }

        public void m1418f(Activity activity) {
            C0124u.bR().m80a(C0123a.EASY_TRACKER_ACTIVITY_START);
            cy();
            if (!this.uA && this.uC == 0 && cz()) {
                this.uE = true;
            }
            this.uA = true;
            this.uC++;
            if (this.uB) {
                Map hashMap = new HashMap();
                hashMap.put(Fields.HIT_TYPE, HitTypes.APP_VIEW);
                C0124u.bR().m81r(true);
                this.uG.set(Fields.SCREEN_NAME, this.uG.ux != null ? this.uG.ux.m1448h(activity) : activity.getClass().getCanonicalName());
                this.uG.send(hashMap);
                C0124u.bR().m81r(false);
            }
        }

        public void m1419g(Activity activity) {
            C0124u.bR().m80a(C0123a.EASY_TRACKER_ACTIVITY_STOP);
            this.uC--;
            this.uC = Math.max(0, this.uC);
            this.uF = this.rJ.currentTimeMillis();
            if (this.uC == 0) {
                cy();
                this.uz = new C0091a();
                this.uy = new Timer("waitForActivityStart");
                this.uy.schedule(this.uz, 1000);
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.uD = sessionTimeout;
            cx();
        }
    }

    Tracker(String trackingId, TrackerHandler handler) {
        this(trackingId, handler, C0509h.bu(), ae.cs(), C0508g.bt(), new C0519z("tracking"));
    }

    Tracker(String trackingId, TrackerHandler handler, C0509h clientIdDefaultProvider, ae screenResolutionDefaultProvider, C0508g appFieldsDefaultProvider, ad rateLimiter) {
        this.uq = new HashMap();
        this.up = handler;
        if (trackingId != null) {
            this.uq.put(Fields.TRACKING_ID, trackingId);
        }
        this.uq.put(Fields.USE_SECURE, "1");
        this.us = clientIdDefaultProvider;
        this.ut = screenResolutionDefaultProvider;
        this.uu = appFieldsDefaultProvider;
        this.ur = rateLimiter;
        this.uw = new C0503a(this);
    }

    void m42a(Context context, aj ajVar) {
        aa.m46v("Loading Tracker config values.");
        this.ux = ajVar;
        if (this.ux.cB()) {
            String cC = this.ux.cC();
            set(Fields.TRACKING_ID, cC);
            aa.m46v("[Tracker] trackingId loaded: " + cC);
        }
        if (this.ux.cD()) {
            cC = Double.toString(this.ux.cE());
            set(Fields.SAMPLE_RATE, cC);
            aa.m46v("[Tracker] sample frequency loaded: " + cC);
        }
        if (this.ux.cF()) {
            setSessionTimeout((long) this.ux.getSessionTimeout());
            aa.m46v("[Tracker] session timeout loaded: " + cu());
        }
        if (this.ux.cG()) {
            enableAutoActivityTracking(this.ux.cH());
            aa.m46v("[Tracker] auto activity tracking loaded: " + cv());
        }
        if (this.ux.cI()) {
            if (this.ux.cJ()) {
                set(Fields.ANONYMIZE_IP, "1");
                aa.m46v("[Tracker] anonymize ip loaded: true");
            }
            aa.m46v("[Tracker] anonymize ip loaded: false");
        }
        this.uv = this.ux.cK();
        if (this.ux.cK()) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), context));
            aa.m46v("[Tracker] report uncaught exceptions loaded: " + this.uv);
        }
    }

    long cu() {
        return this.uw.cu();
    }

    boolean cv() {
        return this.uw.cv();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.uq.containsKey("&ate")) {
                this.uq.remove("&ate");
            }
            if (this.uq.containsKey("&adid")) {
                this.uq.remove("&adid");
                return;
            }
            return;
        }
        this.uq.put("&ate", null);
        this.uq.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.uw.enableAutoActivityTracking(enabled);
    }

    public String get(String key) {
        C0124u.bR().m80a(C0123a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.uq.containsKey(key)) {
            return (String) this.uq.get(key);
        }
        if (key.equals(Fields.LANGUAGE)) {
            return ak.m56a(Locale.getDefault());
        }
        if (this.us != null && this.us.m1463x(key)) {
            return this.us.getValue(key);
        }
        if (this.ut == null || !this.ut.m1435x(key)) {
            return (this.uu == null || !this.uu.m1457x(key)) ? null : this.uu.getValue(key);
        } else {
            return this.ut.getValue(key);
        }
    }

    public void send(Map<String, String> params) {
        C0124u.bR().m80a(C0123a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.uq);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get(Fields.TRACKING_ID))) {
            aa.m47w(String.format("Missing tracking id (%s) parameter.", new Object[]{Fields.TRACKING_ID}));
        }
        String str = (String) hashMap.get(Fields.HIT_TYPE);
        if (TextUtils.isEmpty(str)) {
            aa.m47w(String.format("Missing hit type (%s) parameter.", new Object[]{Fields.HIT_TYPE}));
            str = "";
        }
        if (this.uw.cw()) {
            hashMap.put(Fields.SESSION_CONTROL, "start");
        }
        if (str.equals(HitTypes.TRANSACTION) || str.equals(HitTypes.ITEM) || this.ur.cl()) {
            this.up.m43n(hashMap);
        } else {
            aa.m47w("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        er.m719b((Object) key, (Object) "Key should be non-null");
        C0124u.bR().m80a(C0123a.SET);
        this.uq.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set(Fields.ANONYMIZE_IP, ak.m59s(anonymize));
    }

    public void setAppId(String appId) {
        set(Fields.APP_ID, appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set(Fields.APP_INSTALLER_ID, appInstallerId);
    }

    public void setAppName(String appName) {
        set(Fields.APP_NAME, appName);
    }

    public void setAppVersion(String appVersion) {
        set(Fields.APP_VERSION, appVersion);
    }

    public void setClientId(String clientId) {
        set(Fields.CLIENT_ID, clientId);
    }

    public void setEncoding(String encoding) {
        set(Fields.ENCODING, encoding);
    }

    public void setHostname(String hostname) {
        set(Fields.HOSTNAME, hostname);
    }

    public void setLanguage(String language) {
        set(Fields.LANGUAGE, language);
    }

    public void setLocation(String location) {
        set(Fields.LOCATION, location);
    }

    public void setPage(String page) {
        set(Fields.PAGE, page);
    }

    public void setReferrer(String referrer) {
        set(Fields.REFERRER, referrer);
    }

    public void setSampleRate(double sampleRate) {
        set(Fields.SAMPLE_RATE, Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set(Fields.SCREEN_COLORS, screenColors);
    }

    public void setScreenName(String screenName) {
        set(Fields.SCREEN_NAME, screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set(Fields.SCREEN_RESOLUTION, width + "x" + height);
        } else {
            aa.m47w("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.uw.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set(Fields.TITLE, title);
    }

    public void setUseSecure(boolean useSecure) {
        set(Fields.USE_SECURE, ak.m59s(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set(Fields.VIEWPORT_SIZE, viewportSize);
    }
}
