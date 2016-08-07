package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.k */
public class C1061k extends C0956j {

    /* renamed from: com.google.android.gms.internal.k.a */
    class C0295a {
        private String kl;
        private boolean km;
        final /* synthetic */ C1061k kn;

        public C0295a(C1061k c1061k, String str, boolean z) {
            this.kn = c1061k;
            this.kl = str;
            this.km = z;
        }

        public String getId() {
            return this.kl;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.km;
        }
    }

    private C1061k(Context context, C0298n c0298n, C0299o c0299o) {
        super(context, c0298n, c0299o);
    }

    public static C1061k m3120a(String str, Context context) {
        C0298n c0606e = new C0606e();
        C0956j.m2797a(str, context, c0606e);
        return new C1061k(context, c0606e, new C0667q(239));
    }

    protected void m3121b(Context context) {
        long j = 1;
        super.m2805b(context);
        try {
            C0295a f = m3122f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m2106a(28, j);
                String id = f.getId();
                if (id != null) {
                    m2107a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            m2106a(28, 1);
        }
    }

    C0295a m3122f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.ka.m1079a(bArr, true);
            }
            return new C0295a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
