package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C0980i extends dg {
    private static final String ID;
    private static final String TF;
    private static final String TG;
    static final String TH;
    private static final Set<String> TI;
    private static final String URL;
    private final C0397a TJ;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i.a */
    public interface C0397a {
        aq iz();
    }

    /* renamed from: com.google.android.gms.tagmanager.i.1 */
    class C07901 implements C0397a {
        final /* synthetic */ Context os;

        C07901(Context context) {
            this.os = context;
        }

        public aq iz() {
            return C0805y.m2377F(this.os);
        }
    }

    static {
        ID = C0211a.ARBITRARY_PIXEL.toString();
        URL = C0214b.URL.toString();
        TF = C0214b.ADDITIONAL_PARAMS.toString();
        TG = C0214b.UNREPEATABLE.toString();
        TH = "gtm_" + ID + "_unrepeatable";
        TI = new HashSet();
    }

    public C0980i(Context context) {
        this(context, new C07901(context));
    }

    C0980i(Context context, C0397a c0397a) {
        super(ID, URL);
        this.TJ = c0397a;
        this.mContext = context;
    }

    private synchronized boolean aU(String str) {
        boolean z = true;
        synchronized (this) {
            if (!aW(str)) {
                if (aV(str)) {
                    TI.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean aV(String str) {
        return this.mContext.getSharedPreferences(TH, 0).contains(str);
    }

    boolean aW(String str) {
        return TI.contains(str);
    }

    public void m2898w(Map<String, C0911a> map) {
        String j = map.get(TG) != null ? di.m1345j((C0911a) map.get(TG)) : null;
        if (j == null || !aU(j)) {
            Builder buildUpon = Uri.parse(di.m1345j((C0911a) map.get(URL))).buildUpon();
            C0911a c0911a = (C0911a) map.get(TF);
            if (c0911a != null) {
                Object o = di.m1353o(c0911a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m1266t("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m1266t("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.TJ.iz().bk(uri);
            bh.m1268v("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C0980i.class) {
                    TI.add(j);
                    cz.m1337a(this.mContext, TH, j, "true");
                }
            }
        }
    }
}
