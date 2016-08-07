package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0247d.C0911a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> UW;
    private final String UX;

    public aj(String str, String... strArr) {
        this.UX = str;
        this.UW = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.UW.add(add);
        }
    }

    boolean m1247a(Set<String> set) {
        return set.containsAll(this.UW);
    }

    public abstract boolean iy();

    public String jc() {
        return this.UX;
    }

    public Set<String> jd() {
        return this.UW;
    }

    public abstract C0911a m1248u(Map<String, C0911a> map);
}
