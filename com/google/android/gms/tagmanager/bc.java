package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID;

    static {
        ID = C0211a.LANGUAGE.toString();
    }

    public bc() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2275u(Map<String, C0911a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return di.ku();
        }
        String language = locale.getLanguage();
        return language == null ? di.ku() : di.m1356r(language.toLowerCase());
    }
}
