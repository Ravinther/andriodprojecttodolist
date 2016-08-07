package com.google.android.gms.tagmanager;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class aa extends aj {
    private static final String ID;

    static {
        ID = C0211a.DEVICE_NAME.toString();
    }

    public aa() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2251u(Map<String, C0911a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(EnvironmentCompat.MEDIA_UNKNOWN))) {
            obj = str + " " + obj;
        }
        return di.m1356r(obj);
    }
}
