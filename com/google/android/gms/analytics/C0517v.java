package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0105k.C0104a;

/* renamed from: com.google.android.gms.analytics.v */
class C0517v extends C0105k<C0518w> {

    /* renamed from: com.google.android.gms.analytics.v.a */
    private static class C0516a implements C0104a<C0518w> {
        private final C0518w tx;

        public C0516a() {
            this.tx = new C0518w();
        }

        public void m1506a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.tx.tz = i;
            } else {
                aa.m47w("int configuration name not recognized:  " + str);
            }
        }

        public void m1507a(String str, String str2) {
        }

        public void m1508b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.tx.qR = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.tx.qS = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.tx.ty = str2;
            } else {
                aa.m47w("string configuration name not recognized:  " + str);
            }
        }

        public C0518w bU() {
            return this.tx;
        }

        public /* synthetic */ C0103j bz() {
            return bU();
        }

        public void m1509c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.tx.tA = z ? 1 : 0;
                return;
            }
            aa.m47w("bool configuration name not recognized:  " + str);
        }
    }

    public C0517v(Context context) {
        super(context, new C0516a());
    }
}
