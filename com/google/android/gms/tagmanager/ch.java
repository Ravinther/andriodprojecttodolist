package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends aj {
    private static final String ID;
    private static final String Wc;
    private static final String Wd;
    private static final String We;
    private static final String Wf;

    static {
        ID = C0211a.REGEX_GROUP.toString();
        Wc = C0214b.ARG0.toString();
        Wd = C0214b.ARG1.toString();
        We = C0214b.IGNORE_CASE.toString();
        Wf = C0214b.GROUP.toString();
    }

    public ch() {
        super(ID, Wc, Wd);
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2307u(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(Wc);
        C0911a c0911a2 = (C0911a) map.get(Wd);
        if (c0911a == null || c0911a == di.ku() || c0911a2 == null || c0911a2 == di.ku()) {
            return di.ku();
        }
        int intValue;
        int i = 64;
        if (di.m1351n((C0911a) map.get(We)).booleanValue()) {
            i = 66;
        }
        C0911a c0911a3 = (C0911a) map.get(Wf);
        if (c0911a3 != null) {
            Long l = di.m1347l(c0911a3);
            if (l == di.kp()) {
                return di.ku();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return di.ku();
            }
        }
        intValue = 1;
        try {
            CharSequence j = di.m1345j(c0911a);
            Object obj = null;
            Matcher matcher = Pattern.compile(di.m1345j(c0911a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? di.ku() : di.m1356r(obj);
        } catch (PatternSyntaxException e) {
            return di.ku();
        }
    }
}
