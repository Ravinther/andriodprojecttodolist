package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C0805y implements aq {
    private static C0805y UO;
    private static final Object qI;
    private String UP;
    private String UQ;
    private ar UR;
    private cg Uc;

    static {
        qI = new Object();
    }

    private C0805y(Context context) {
        this(as.m2257H(context), new cw());
    }

    C0805y(ar arVar, cg cgVar) {
        this.UR = arVar;
        this.Uc = cgVar;
    }

    public static aq m2377F(Context context) {
        aq aqVar;
        synchronized (qI) {
            if (UO == null) {
                UO = new C0805y(context);
            }
            aqVar = UO;
        }
        return aqVar;
    }

    public boolean bk(String str) {
        if (this.Uc.cl()) {
            if (!(this.UP == null || this.UQ == null)) {
                try {
                    str = this.UP + "?" + this.UQ + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.m1268v("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.m1263b("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.UR.bn(str);
            return true;
        }
        bh.m1269w("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
