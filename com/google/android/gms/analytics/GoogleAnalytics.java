package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.analytics.tracking.android.Fields;
import com.google.android.gms.analytics.C0124u.C0123a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean tB;
    private static GoogleAnalytics tI;
    private Context mContext;
    private String qR;
    private String qS;
    private C0099f rk;
    private boolean tC;
    private af tD;
    private volatile Boolean tE;
    private Logger tF;
    private Set<C0088a> tG;
    private boolean tH;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.a */
    interface C0088a {
        void m38f(Activity activity);

        void m39g(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.b */
    class C0089b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics tJ;

        C0089b(GoogleAnalytics googleAnalytics) {
            this.tJ = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.tJ.m1411d(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.tJ.m1412e(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0515t.m1500q(context), C0512r.bB());
    }

    private GoogleAnalytics(Context context, C0099f thread, af serviceManager) {
        this.tE = Boolean.valueOf(false);
        this.tH = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.rk = thread;
        this.tD = serviceManager;
        C0508g.m1456n(this.mContext);
        ae.m1434n(this.mContext);
        C0509h.m1461n(this.mContext);
        this.tF = new C0510l();
        this.tG = new HashSet();
        cg();
    }

    private int m1407D(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    private Tracker m1408a(Tracker tracker) {
        if (this.qR != null) {
            tracker.set(Fields.APP_NAME, this.qR);
        }
        if (this.qS != null) {
            tracker.set(Fields.APP_VERSION, this.qS);
        }
        return tracker;
    }

    static GoogleAnalytics cf() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = tI;
        }
        return googleAnalytics;
    }

    private void cg() {
        if (!tB) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                aa.m46v("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aa.m47w("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    C0518w c0518w = (C0518w) new C0517v(this.mContext).m71p(i);
                    if (c0518w != null) {
                        m1414a(c0518w);
                    }
                }
            }
        }
    }

    private void m1411d(Activity activity) {
        for (C0088a f : this.tG) {
            f.m38f(activity);
        }
    }

    private void m1412e(Activity activity) {
        for (C0088a g : this.tG) {
            g.m39g(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (tI == null) {
                tI = new GoogleAnalytics(context);
            }
            googleAnalytics = tI;
        }
        return googleAnalytics;
    }

    void m1413a(C0088a c0088a) {
        this.tG.add(c0088a);
    }

    void m1414a(C0518w c0518w) {
        aa.m46v("Loading global config values.");
        if (c0518w.bV()) {
            this.qR = c0518w.bW();
            aa.m46v("app name loaded: " + this.qR);
        }
        if (c0518w.bX()) {
            this.qS = c0518w.bY();
            aa.m46v("app version loaded: " + this.qS);
        }
        if (c0518w.bZ()) {
            int D = m1407D(c0518w.ca());
            if (D >= 0) {
                aa.m46v("log level loaded: " + D);
                getLogger().setLogLevel(D);
            }
        }
        if (c0518w.cb()) {
            this.tD.setLocalDispatchPeriod(c0518w.cc());
        }
        if (c0518w.cd()) {
            setDryRun(c0518w.ce());
        }
    }

    void m1415b(C0088a c0088a) {
        this.tG.remove(c0088a);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.tD.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.tH) {
            application.registerActivityLifecycleCallbacks(new C0089b(this));
            this.tH = true;
        }
    }

    public boolean getAppOptOut() {
        C0124u.bR().m80a(C0123a.GET_APP_OPT_OUT);
        return this.tE.booleanValue();
    }

    public Logger getLogger() {
        return this.tF;
    }

    public boolean isDryRunEnabled() {
        C0124u.bR().m80a(C0123a.GET_DRY_RUN);
        return this.tC;
    }

    void m1416n(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ak.m57a(map, Fields.LANGUAGE, ak.m56a(Locale.getDefault()));
            ak.m57a(map, Fields.SCREEN_RESOLUTION, ae.cs().getValue(Fields.SCREEN_RESOLUTION));
            map.put("&_u", C0124u.bR().bT());
            C0124u.bR().bS();
            this.rk.m65n(map);
        }
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C0124u.bR().m80a(C0123a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this);
            if (configResId > 0) {
                aj ajVar = (aj) new ai(this.mContext).m71p(configResId);
                if (ajVar != null) {
                    tracker.m42a(this.mContext, ajVar);
                }
            }
            a = m1408a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0124u.bR().m80a(C0123a.GET_TRACKER);
            a = m1408a(new Tracker(trackingId, this));
        }
        return a;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.tH) {
            m1411d(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.tH) {
            m1412e(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0124u.bR().m80a(C0123a.SET_APP_OPT_OUT);
        this.tE = Boolean.valueOf(optOut);
        if (this.tE.booleanValue()) {
            this.rk.bk();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0124u.bR().m80a(C0123a.SET_DRY_RUN);
        this.tC = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.tD.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0124u.bR().m80a(C0123a.SET_LOGGER);
        this.tF = logger;
    }
}
