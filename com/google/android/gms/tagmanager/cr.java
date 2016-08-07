package com.google.android.gms.tagmanager;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0237c.C0900b;
import com.google.android.gms.internal.C0237c.C0903e;
import com.google.android.gms.internal.C0237c.C0904f;
import com.google.android.gms.internal.C0237c.C0905g;
import com.google.android.gms.internal.C0237c.C0906h;
import com.google.android.gms.internal.C0247d.C0911a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr {

    /* renamed from: com.google.android.gms.tagmanager.cr.a */
    public static class C0383a {
        private final Map<String, C0911a> Ws;
        private final C0911a Wt;

        private C0383a(Map<String, C0911a> map, C0911a c0911a) {
            this.Ws = map;
            this.Wt = c0911a;
        }

        public static C0384b jE() {
            return new C0384b();
        }

        public void m1292a(String str, C0911a c0911a) {
            this.Ws.put(str, c0911a);
        }

        public Map<String, C0911a> jF() {
            return Collections.unmodifiableMap(this.Ws);
        }

        public C0911a jG() {
            return this.Wt;
        }

        public String toString() {
            return "Properties: " + jF() + " pushAfterEvaluate: " + this.Wt;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.b */
    public static class C0384b {
        private final Map<String, C0911a> Ws;
        private C0911a Wt;

        private C0384b() {
            this.Ws = new HashMap();
        }

        public C0384b m1293b(String str, C0911a c0911a) {
            this.Ws.put(str, c0911a);
            return this;
        }

        public C0384b m1294i(C0911a c0911a) {
            this.Wt = c0911a;
            return this;
        }

        public C0383a jH() {
            return new C0383a(this.Wt, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.c */
    public static class C0385c {
        private final String Un;
        private final List<C0387e> Wu;
        private final Map<String, List<C0383a>> Wv;
        private final int Ww;

        private C0385c(List<C0387e> list, Map<String, List<C0383a>> map, String str, int i) {
            this.Wu = Collections.unmodifiableList(list);
            this.Wv = Collections.unmodifiableMap(map);
            this.Un = str;
            this.Ww = i;
        }

        public static C0386d jI() {
            return new C0386d();
        }

        public String getVersion() {
            return this.Un;
        }

        public List<C0387e> jJ() {
            return this.Wu;
        }

        public Map<String, List<C0383a>> jK() {
            return this.Wv;
        }

        public String toString() {
            return "Rules: " + jJ() + "  Macros: " + this.Wv;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.d */
    public static class C0386d {
        private String Un;
        private final List<C0387e> Wu;
        private final Map<String, List<C0383a>> Wv;
        private int Ww;

        private C0386d() {
            this.Wu = new ArrayList();
            this.Wv = new HashMap();
            this.Un = "";
            this.Ww = 0;
        }

        public C0386d m1295a(C0383a c0383a) {
            String j = di.m1345j((C0911a) c0383a.jF().get(C0214b.INSTANCE_NAME.toString()));
            List list = (List) this.Wv.get(j);
            if (list == null) {
                list = new ArrayList();
                this.Wv.put(j, list);
            }
            list.add(c0383a);
            return this;
        }

        public C0386d m1296a(C0387e c0387e) {
            this.Wu.add(c0387e);
            return this;
        }

        public C0386d bW(int i) {
            this.Ww = i;
            return this;
        }

        public C0386d bx(String str) {
            this.Un = str;
            return this;
        }

        public C0385c jL() {
            return new C0385c(this.Wv, this.Un, this.Ww, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.e */
    public static class C0387e {
        private final List<C0383a> WA;
        private final List<C0383a> WB;
        private final List<C0383a> WC;
        private final List<String> WD;
        private final List<String> WE;
        private final List<String> WF;
        private final List<String> WG;
        private final List<C0383a> Wx;
        private final List<C0383a> Wy;
        private final List<C0383a> Wz;

        private C0387e(List<C0383a> list, List<C0383a> list2, List<C0383a> list3, List<C0383a> list4, List<C0383a> list5, List<C0383a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.Wx = Collections.unmodifiableList(list);
            this.Wy = Collections.unmodifiableList(list2);
            this.Wz = Collections.unmodifiableList(list3);
            this.WA = Collections.unmodifiableList(list4);
            this.WB = Collections.unmodifiableList(list5);
            this.WC = Collections.unmodifiableList(list6);
            this.WD = Collections.unmodifiableList(list7);
            this.WE = Collections.unmodifiableList(list8);
            this.WF = Collections.unmodifiableList(list9);
            this.WG = Collections.unmodifiableList(list10);
        }

        public static C0388f jM() {
            return new C0388f();
        }

        public List<C0383a> jN() {
            return this.Wx;
        }

        public List<C0383a> jO() {
            return this.Wy;
        }

        public List<C0383a> jP() {
            return this.Wz;
        }

        public List<C0383a> jQ() {
            return this.WA;
        }

        public List<C0383a> jR() {
            return this.WB;
        }

        public List<String> jS() {
            return this.WD;
        }

        public List<String> jT() {
            return this.WE;
        }

        public List<String> jU() {
            return this.WF;
        }

        public List<String> jV() {
            return this.WG;
        }

        public List<C0383a> jW() {
            return this.WC;
        }

        public String toString() {
            return "Positive predicates: " + jN() + "  Negative predicates: " + jO() + "  Add tags: " + jP() + "  Remove tags: " + jQ() + "  Add macros: " + jR() + "  Remove macros: " + jW();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.f */
    public static class C0388f {
        private final List<C0383a> WA;
        private final List<C0383a> WB;
        private final List<C0383a> WC;
        private final List<String> WD;
        private final List<String> WE;
        private final List<String> WF;
        private final List<String> WG;
        private final List<C0383a> Wx;
        private final List<C0383a> Wy;
        private final List<C0383a> Wz;

        private C0388f() {
            this.Wx = new ArrayList();
            this.Wy = new ArrayList();
            this.Wz = new ArrayList();
            this.WA = new ArrayList();
            this.WB = new ArrayList();
            this.WC = new ArrayList();
            this.WD = new ArrayList();
            this.WE = new ArrayList();
            this.WF = new ArrayList();
            this.WG = new ArrayList();
        }

        public C0388f m1297b(C0383a c0383a) {
            this.Wx.add(c0383a);
            return this;
        }

        public C0388f bA(String str) {
            this.WD.add(str);
            return this;
        }

        public C0388f bB(String str) {
            this.WE.add(str);
            return this;
        }

        public C0388f by(String str) {
            this.WF.add(str);
            return this;
        }

        public C0388f bz(String str) {
            this.WG.add(str);
            return this;
        }

        public C0388f m1298c(C0383a c0383a) {
            this.Wy.add(c0383a);
            return this;
        }

        public C0388f m1299d(C0383a c0383a) {
            this.Wz.add(c0383a);
            return this;
        }

        public C0388f m1300e(C0383a c0383a) {
            this.WA.add(c0383a);
            return this;
        }

        public C0388f m1301f(C0383a c0383a) {
            this.WB.add(c0383a);
            return this;
        }

        public C0388f m1302g(C0383a c0383a) {
            this.WC.add(c0383a);
            return this;
        }

        public C0387e jX() {
            return new C0387e(this.Wy, this.Wz, this.WA, this.WB, this.WC, this.WD, this.WE, this.WF, this.WG, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.g */
    public static class C0389g extends Exception {
        public C0389g(String str) {
            super(str);
        }
    }

    private static C0911a m1303a(int i, C0904f c0904f, C0911a[] c0911aArr, Set<Integer> set) throws C0389g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            bw("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C0911a c0911a = (C0911a) m1306a(c0904f.fi, i, "values");
        if (c0911aArr[i] != null) {
            return c0911aArr[i];
        }
        C0911a c0911a2 = null;
        set.add(Integer.valueOf(i));
        C0906h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c0911a.type) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                c0911a2 = c0911a;
                break;
            case Value.STRING_FIELD_NUMBER /*2*/:
                h = m1310h(c0911a);
                c0911a2 = m1309g(c0911a);
                c0911a2.fZ = new C0911a[h.fK.length];
                iArr = h.fK;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0911a2.fZ[i3] = m1303a(iArr[i2], c0904f, c0911aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                c0911a2 = m1309g(c0911a);
                C0906h h2 = m1310h(c0911a);
                if (h2.fL.length != h2.fM.length) {
                    bw("Uneven map keys (" + h2.fL.length + ") and map values (" + h2.fM.length + ")");
                }
                c0911a2.ga = new C0911a[h2.fL.length];
                c0911a2.gb = new C0911a[h2.fL.length];
                int[] iArr2 = h2.fL;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c0911a2.ga[i4] = m1303a(iArr2[i3], c0904f, c0911aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fM;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0911a2.gb[i3] = m1303a(iArr[i2], c0904f, c0911aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                c0911a2 = m1309g(c0911a);
                c0911a2.gc = di.m1345j(m1303a(m1310h(c0911a).fP, c0904f, c0911aArr, (Set) set));
                break;
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                c0911a2 = m1309g(c0911a);
                h = m1310h(c0911a);
                c0911a2.gg = new C0911a[h.fO.length];
                iArr = h.fO;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0911a2.gg[i3] = m1303a(iArr[i2], c0904f, c0911aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c0911a2 == null) {
            bw("Invalid value: " + c0911a);
        }
        c0911aArr[i] = c0911a2;
        set.remove(Integer.valueOf(i));
        return c0911a2;
    }

    private static C0383a m1304a(C0900b c0900b, C0904f c0904f, C0911a[] c0911aArr, int i) throws C0389g {
        C0384b jE = C0383a.jE();
        for (int valueOf : c0900b.eS) {
            C0903e c0903e = (C0903e) m1306a(c0904f.fj, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m1306a(c0904f.fh, c0903e.key, "keys");
            C0911a c0911a = (C0911a) m1306a(c0911aArr, c0903e.value, "values");
            if (C0214b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                jE.m1294i(c0911a);
            } else {
                jE.m1293b(str, c0911a);
            }
        }
        return jE.jH();
    }

    private static C0387e m1305a(C0905g c0905g, List<C0383a> list, List<C0383a> list2, List<C0383a> list3, C0904f c0904f) {
        C0388f jM = C0387e.jM();
        for (int valueOf : c0905g.fy) {
            jM.m1297b((C0383a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c0905g.fz) {
            jM.m1298c((C0383a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c0905g.fA) {
            jM.m1299d((C0383a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c0905g.fC) {
            jM.by(c0904f.fi[Integer.valueOf(valueOf3).intValue()].fY);
        }
        for (int valueOf222 : c0905g.fB) {
            jM.m1300e((C0383a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c0905g.fD) {
            jM.bz(c0904f.fi[Integer.valueOf(valueOf32).intValue()].fY);
        }
        for (int valueOf2222 : c0905g.fE) {
            jM.m1301f((C0383a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c0905g.fG) {
            jM.bA(c0904f.fi[Integer.valueOf(valueOf322).intValue()].fY);
        }
        for (int valueOf22222 : c0905g.fF) {
            jM.m1302g((C0383a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c0905g.fH) {
            jM.bB(c0904f.fi[Integer.valueOf(valueOf4).intValue()].fY);
        }
        return jM.jX();
    }

    private static <T> T m1306a(T[] tArr, int i, String str) throws C0389g {
        if (i < 0 || i >= tArr.length) {
            bw("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static C0385c m1307b(C0904f c0904f) throws C0389g {
        int i;
        int i2 = 0;
        C0911a[] c0911aArr = new C0911a[c0904f.fi.length];
        for (i = 0; i < c0904f.fi.length; i++) {
            m1303a(i, c0904f, c0911aArr, new HashSet(0));
        }
        C0386d jI = C0385c.jI();
        List arrayList = new ArrayList();
        for (i = 0; i < c0904f.fl.length; i++) {
            arrayList.add(m1304a(c0904f.fl[i], c0904f, c0911aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c0904f.fm.length; i++) {
            arrayList2.add(m1304a(c0904f.fm[i], c0904f, c0911aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c0904f.fk.length; i++) {
            C0383a a = m1304a(c0904f.fk[i], c0904f, c0911aArr, i);
            jI.m1295a(a);
            arrayList3.add(a);
        }
        C0905g[] c0905gArr = c0904f.fn;
        int length = c0905gArr.length;
        while (i2 < length) {
            jI.m1296a(m1305a(c0905gArr[i2], arrayList, arrayList3, arrayList2, c0904f));
            i2++;
        }
        jI.bx(c0904f.fr);
        jI.bW(c0904f.fw);
        return jI.jL();
    }

    public static void m1308b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void bw(String str) throws C0389g {
        bh.m1266t(str);
        throw new C0389g(str);
    }

    public static C0911a m1309g(C0911a c0911a) {
        C0911a c0911a2 = new C0911a();
        c0911a2.type = c0911a.type;
        c0911a2.gh = (int[]) c0911a.gh.clone();
        if (c0911a.gi) {
            c0911a2.gi = c0911a.gi;
        }
        return c0911a2;
    }

    private static C0906h m1310h(C0911a c0911a) throws C0389g {
        if (((C0906h) c0911a.m2125a(C0906h.fI)) == null) {
            bw("Expected a ServingValue and didn't get one. Value is: " + c0911a);
        }
        return (C0906h) c0911a.m2125a(C0906h.fI);
    }
}
