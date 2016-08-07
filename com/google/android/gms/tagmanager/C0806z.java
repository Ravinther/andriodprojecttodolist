package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C0806z extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0211a.DEVICE_ID.toString();
    }

    public C0806z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    protected String m2378G(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2379u(Map<String, C0911a> map) {
        String G = m2378G(this.mContext);
        return G == null ? di.ku() : di.m1356r(G);
    }
}
