package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class cj extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0211a.RESOLUTION.toString();
    }

    public cj(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2308u(Map<String, C0911a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return di.m1356r(i + "x" + displayMetrics.heightPixels);
    }
}
