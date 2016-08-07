package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class df {
    private GoogleAnalytics XE;
    private Context mContext;
    private Tracker re;

    /* renamed from: com.google.android.gms.tagmanager.df.a */
    static class C0785a implements Logger {
        C0785a() {
        }

        private static int bX(int i) {
            switch (i) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return 0;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    return 1;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.m1264c("", exception);
        }

        public void error(String message) {
            bh.m1266t(message);
        }

        public int getLogLevel() {
            return C0785a.bX(bh.getLogLevel());
        }

        public void info(String message) {
            bh.m1267u(message);
        }

        public void setLogLevel(int logLevel) {
            bh.m1269w("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            bh.m1268v(message);
        }

        public void warn(String message) {
            bh.m1269w(message);
        }
    }

    df(Context context) {
        this.mContext = context;
    }

    private synchronized void bG(String str) {
        if (this.XE == null) {
            this.XE = GoogleAnalytics.getInstance(this.mContext);
            this.XE.setLogger(new C0785a());
            this.re = this.XE.newTracker(str);
        }
    }

    public Tracker bF(String str) {
        bG(str);
        return this.re;
    }
}
