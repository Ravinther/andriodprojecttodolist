package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0237c.C0907i;
import com.google.android.gms.internal.C0247d.C0911a;
import com.google.android.gms.tagmanager.C0401l.C0400a;
import com.google.android.gms.tagmanager.C0801s.C0406a;
import com.google.android.gms.tagmanager.cr.C0383a;
import com.google.android.gms.tagmanager.cr.C0385c;
import com.google.android.gms.tagmanager.cr.C0387e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ct {
    private static final by<C0911a> WH;
    private final DataLayer TN;
    private final C0385c WI;
    private final ag WJ;
    private final Map<String, aj> WK;
    private final Map<String, aj> WL;
    private final Map<String, aj> WM;
    private final C0399k<C0383a, by<C0911a>> WN;
    private final C0399k<String, C0391b> WO;
    private final Set<C0387e> WP;
    private final Map<String, C0392c> WQ;
    private volatile String WR;
    private int WS;

    /* renamed from: com.google.android.gms.tagmanager.ct.a */
    interface C0390a {
        void m1312a(C0387e c0387e, Set<C0383a> set, Set<C0383a> set2, cn cnVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.b */
    private static class C0391b {
        private by<C0911a> WY;
        private C0911a Wt;

        public C0391b(by<C0911a> byVar, C0911a c0911a) {
            this.WY = byVar;
            this.Wt = c0911a;
        }

        public int getSize() {
            return (this.Wt == null ? 0 : this.Wt.eW()) + ((C0911a) this.WY.getObject()).eW();
        }

        public C0911a jG() {
            return this.Wt;
        }

        public by<C0911a> ka() {
            return this.WY;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.c */
    private static class C0392c {
        private final Set<C0387e> WP;
        private final Map<C0387e, List<C0383a>> WZ;
        private final Map<C0387e, List<C0383a>> Xa;
        private final Map<C0387e, List<String>> Xb;
        private final Map<C0387e, List<String>> Xc;
        private C0383a Xd;

        public C0392c() {
            this.WP = new HashSet();
            this.WZ = new HashMap();
            this.Xb = new HashMap();
            this.Xa = new HashMap();
            this.Xc = new HashMap();
        }

        public void m1313a(C0387e c0387e, C0383a c0383a) {
            List list = (List) this.WZ.get(c0387e);
            if (list == null) {
                list = new ArrayList();
                this.WZ.put(c0387e, list);
            }
            list.add(c0383a);
        }

        public void m1314a(C0387e c0387e, String str) {
            List list = (List) this.Xb.get(c0387e);
            if (list == null) {
                list = new ArrayList();
                this.Xb.put(c0387e, list);
            }
            list.add(str);
        }

        public void m1315b(C0387e c0387e) {
            this.WP.add(c0387e);
        }

        public void m1316b(C0387e c0387e, C0383a c0383a) {
            List list = (List) this.Xa.get(c0387e);
            if (list == null) {
                list = new ArrayList();
                this.Xa.put(c0387e, list);
            }
            list.add(c0383a);
        }

        public void m1317b(C0387e c0387e, String str) {
            List list = (List) this.Xc.get(c0387e);
            if (list == null) {
                list = new ArrayList();
                this.Xc.put(c0387e, list);
            }
            list.add(str);
        }

        public void m1318i(C0383a c0383a) {
            this.Xd = c0383a;
        }

        public Set<C0387e> kb() {
            return this.WP;
        }

        public Map<C0387e, List<C0383a>> kc() {
            return this.WZ;
        }

        public Map<C0387e, List<String>> kd() {
            return this.Xb;
        }

        public Map<C0387e, List<String>> ke() {
            return this.Xc;
        }

        public Map<C0387e, List<C0383a>> kf() {
            return this.Xa;
        }

        public C0383a kg() {
            return this.Xd;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.1 */
    class C07791 implements C0400a<C0383a, by<C0911a>> {
        final /* synthetic */ ct WT;

        C07791(ct ctVar) {
            this.WT = ctVar;
        }

        public int m2310a(C0383a c0383a, by<C0911a> byVar) {
            return ((C0911a) byVar.getObject()).eW();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2310a((C0383a) x0, (by) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.2 */
    class C07802 implements C0400a<String, C0391b> {
        final /* synthetic */ ct WT;

        C07802(ct ctVar) {
            this.WT = ctVar;
        }

        public int m2311a(String str, C0391b c0391b) {
            return str.length() + c0391b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2311a((String) x0, (C0391b) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.3 */
    class C07813 implements C0390a {
        final /* synthetic */ ct WT;
        final /* synthetic */ Map WU;
        final /* synthetic */ Map WV;
        final /* synthetic */ Map WW;
        final /* synthetic */ Map WX;

        C07813(ct ctVar, Map map, Map map2, Map map3, Map map4) {
            this.WT = ctVar;
            this.WU = map;
            this.WV = map2;
            this.WW = map3;
            this.WX = map4;
        }

        public void m2312a(C0387e c0387e, Set<C0383a> set, Set<C0383a> set2, cn cnVar) {
            List list = (List) this.WU.get(c0387e);
            List list2 = (List) this.WV.get(c0387e);
            if (list != null) {
                set.addAll(list);
                cnVar.jl().m1287b(list, list2);
            }
            list = (List) this.WW.get(c0387e);
            list2 = (List) this.WX.get(c0387e);
            if (list != null) {
                set2.addAll(list);
                cnVar.jm().m1287b(list, list2);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.4 */
    class C07824 implements C0390a {
        final /* synthetic */ ct WT;

        C07824(ct ctVar) {
            this.WT = ctVar;
        }

        public void m2313a(C0387e c0387e, Set<C0383a> set, Set<C0383a> set2, cn cnVar) {
            set.addAll(c0387e.jP());
            set2.addAll(c0387e.jQ());
            cnVar.jn().m1287b(c0387e.jP(), c0387e.jU());
            cnVar.jo().m1287b(c0387e.jQ(), c0387e.jV());
        }
    }

    static {
        WH = new by(di.ku(), true);
    }

    public ct(Context context, C0385c c0385c, DataLayer dataLayer, C0406a c0406a, C0406a c0406a2, ag agVar) {
        if (c0385c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.WI = c0385c;
        this.WP = new HashSet(c0385c.jJ());
        this.TN = dataLayer;
        this.WJ = agVar;
        this.WN = new C0401l().m1366a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C07791(this));
        this.WO = new C0401l().m1366a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C07802(this));
        this.WK = new HashMap();
        m1333b(new C0980i(context));
        m1333b(new C0801s(c0406a2));
        m1333b(new C0983w(dataLayer));
        m1333b(new dj(context, dataLayer));
        this.WL = new HashMap();
        m1334c(new C1068q());
        m1334c(new ad());
        m1334c(new ae());
        m1334c(new al());
        m1334c(new am());
        m1334c(new bd());
        m1334c(new be());
        m1334c(new ci());
        m1334c(new dc());
        this.WM = new HashMap();
        m1332a(new C0773b(context));
        m1332a(new C0775c(context));
        m1332a(new C0786e(context));
        m1332a(new C0787f(context));
        m1332a(new C0788g(context));
        m1332a(new C0789h(context));
        m1332a(new C0792m());
        m1332a(new C0800p(this.WI.getVersion()));
        m1332a(new C0801s(c0406a));
        m1332a(new C0802u(dataLayer));
        m1332a(new C0806z(context));
        m1332a(new aa());
        m1332a(new ac());
        m1332a(new ah(this));
        m1332a(new an());
        m1332a(new ao());
        m1332a(new ax(context));
        m1332a(new az());
        m1332a(new bc());
        m1332a(new bk(context));
        m1332a(new bz());
        m1332a(new cc());
        m1332a(new cf());
        m1332a(new ch());
        m1332a(new cj(context));
        m1332a(new cu());
        m1332a(new cv());
        m1332a(new de());
        this.WQ = new HashMap();
        for (C0387e c0387e : this.WP) {
            if (agVar.jb()) {
                m1324a(c0387e.jR(), c0387e.jS(), "add macro");
                m1324a(c0387e.jW(), c0387e.jT(), "remove macro");
                m1324a(c0387e.jP(), c0387e.jU(), "add tag");
                m1324a(c0387e.jQ(), c0387e.jV(), "remove tag");
            }
            int i = 0;
            while (i < c0387e.jR().size()) {
                C0383a c0383a = (C0383a) c0387e.jR().get(i);
                String str = "Unknown";
                if (agVar.jb() && i < c0387e.jS().size()) {
                    str = (String) c0387e.jS().get(i);
                }
                C0392c c = m1326c(this.WQ, m1327h(c0383a));
                c.m1315b(c0387e);
                c.m1313a(c0387e, c0383a);
                c.m1314a(c0387e, str);
                i++;
            }
            i = 0;
            while (i < c0387e.jW().size()) {
                c0383a = (C0383a) c0387e.jW().get(i);
                str = "Unknown";
                if (agVar.jb() && i < c0387e.jT().size()) {
                    str = (String) c0387e.jT().get(i);
                }
                c = m1326c(this.WQ, m1327h(c0383a));
                c.m1315b(c0387e);
                c.m1316b(c0387e, c0383a);
                c.m1317b(c0387e, str);
                i++;
            }
        }
        for (Entry entry : this.WI.jK().entrySet()) {
            for (C0383a c0383a2 : (List) entry.getValue()) {
                if (!di.m1351n((C0911a) c0383a2.jF().get(C0214b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m1326c(this.WQ, (String) entry.getKey()).m1318i(c0383a2);
                }
            }
        }
    }

    private by<C0911a> m1319a(C0911a c0911a, Set<String> set, dk dkVar) {
        if (!c0911a.gi) {
            return new by(c0911a, true);
        }
        C0911a g;
        int i;
        by a;
        switch (c0911a.type) {
            case Value.STRING_FIELD_NUMBER /*2*/:
                g = cr.m1309g(c0911a);
                g.fZ = new C0911a[c0911a.fZ.length];
                for (i = 0; i < c0911a.fZ.length; i++) {
                    a = m1319a(c0911a.fZ[i], (Set) set, dkVar.bS(i));
                    if (a == WH) {
                        return WH;
                    }
                    g.fZ[i] = (C0911a) a.getObject();
                }
                return new by(g, false);
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                g = cr.m1309g(c0911a);
                if (c0911a.ga.length != c0911a.gb.length) {
                    bh.m1266t("Invalid serving value: " + c0911a.toString());
                    return WH;
                }
                g.ga = new C0911a[c0911a.ga.length];
                g.gb = new C0911a[c0911a.ga.length];
                for (i = 0; i < c0911a.ga.length; i++) {
                    a = m1319a(c0911a.ga[i], (Set) set, dkVar.bT(i));
                    by a2 = m1319a(c0911a.gb[i], (Set) set, dkVar.bU(i));
                    if (a == WH || a2 == WH) {
                        return WH;
                    }
                    g.ga[i] = (C0911a) a.getObject();
                    g.gb[i] = (C0911a) a2.getObject();
                }
                return new by(g, false);
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                if (set.contains(c0911a.gc)) {
                    bh.m1266t("Macro cycle detected.  Current macro reference: " + c0911a.gc + "." + "  Previous macro references: " + set.toString() + ".");
                    return WH;
                }
                set.add(c0911a.gc);
                by<C0911a> a3 = dl.m1362a(m1320a(c0911a.gc, (Set) set, dkVar.jq()), c0911a.gh);
                set.remove(c0911a.gc);
                return a3;
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                g = cr.m1309g(c0911a);
                g.gg = new C0911a[c0911a.gg.length];
                for (i = 0; i < c0911a.gg.length; i++) {
                    a = m1319a(c0911a.gg[i], (Set) set, dkVar.bV(i));
                    if (a == WH) {
                        return WH;
                    }
                    g.gg[i] = (C0911a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.m1266t("Unknown type: " + c0911a.type);
                return WH;
        }
    }

    private by<C0911a> m1320a(String str, Set<String> set, bj bjVar) {
        this.WS++;
        C0391b c0391b = (C0391b) this.WO.get(str);
        if (c0391b == null || this.WJ.jb()) {
            C0392c c0392c = (C0392c) this.WQ.get(str);
            if (c0392c == null) {
                bh.m1266t(jZ() + "Invalid macro: " + str);
                this.WS--;
                return WH;
            }
            C0383a kg;
            by a = m1330a(str, c0392c.kb(), c0392c.kc(), c0392c.kd(), c0392c.kf(), c0392c.ke(), set, bjVar.iS());
            if (((Set) a.getObject()).isEmpty()) {
                kg = c0392c.kg();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m1269w(jZ() + "Multiple macros active for macroName " + str);
                }
                kg = (C0383a) ((Set) a.getObject()).iterator().next();
            }
            if (kg == null) {
                this.WS--;
                return WH;
            }
            by a2 = m1321a(this.WM, kg, (Set) set, bjVar.jh());
            boolean z = a.jr() && a2.jr();
            by<C0911a> byVar = a2 == WH ? WH : new by(a2.getObject(), z);
            C0911a jG = kg.jG();
            if (byVar.jr()) {
                this.WO.m1365e(str, new C0391b(byVar, jG));
            }
            m1323a(jG, (Set) set);
            this.WS--;
            return byVar;
        }
        m1323a(c0391b.jG(), (Set) set);
        this.WS--;
        return c0391b.ka();
    }

    private by<C0911a> m1321a(Map<String, aj> map, C0383a c0383a, Set<String> set, ck ckVar) {
        boolean z = true;
        C0911a c0911a = (C0911a) c0383a.jF().get(C0214b.FUNCTION.toString());
        if (c0911a == null) {
            bh.m1266t("No function id in properties");
            return WH;
        }
        String str = c0911a.gd;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m1266t(str + " has no backing implementation.");
            return WH;
        }
        by<C0911a> byVar = (by) this.WN.get(c0383a);
        if (byVar != null && !this.WJ.jb()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c0383a.jF().entrySet()) {
            by a = m1319a((C0911a) entry.getValue(), (Set) set, ckVar.bs((String) entry.getKey()).m1288e((C0911a) entry.getValue()));
            if (a == WH) {
                return WH;
            }
            boolean z3;
            if (a.jr()) {
                c0383a.m1292a((String) entry.getKey(), (C0911a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m1247a(hashMap.keySet())) {
            if (!(z2 && ajVar.iy())) {
                z = false;
            }
            byVar = new by(ajVar.m1248u(hashMap), z);
            if (z) {
                this.WN.m1365e(c0383a, byVar);
            }
            ckVar.m1286d((C0911a) byVar.getObject());
            return byVar;
        }
        bh.m1266t("Incorrect keys for function " + str + " required " + ajVar.jd() + " had " + hashMap.keySet());
        return WH;
    }

    private by<Set<C0383a>> m1322a(Set<C0387e> set, Set<String> set2, C0390a c0390a, cs csVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C0387e c0387e : set) {
            cn jp = csVar.jp();
            by a = m1329a(c0387e, (Set) set2, jp);
            if (((Boolean) a.getObject()).booleanValue()) {
                c0390a.m1312a(c0387e, hashSet, hashSet2, jp);
            }
            boolean z2 = z && a.jr();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        csVar.m1311b(hashSet);
        return new by(hashSet, z);
    }

    private void m1323a(C0911a c0911a, Set<String> set) {
        if (c0911a != null) {
            by a = m1319a(c0911a, (Set) set, new bw());
            if (a != WH) {
                Object o = di.m1353o((C0911a) a.getObject());
                if (o instanceof Map) {
                    this.TN.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.TN.push((Map) o2);
                        } else {
                            bh.m1269w("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m1269w("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m1324a(List<C0383a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m1267u("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m1325a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.jc())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.jc());
        }
        map.put(ajVar.jc(), ajVar);
    }

    private static C0392c m1326c(Map<String, C0392c> map, String str) {
        C0392c c0392c = (C0392c) map.get(str);
        if (c0392c != null) {
            return c0392c;
        }
        c0392c = new C0392c();
        map.put(str, c0392c);
        return c0392c;
    }

    private static String m1327h(C0383a c0383a) {
        return di.m1345j((C0911a) c0383a.jF().get(C0214b.INSTANCE_NAME.toString()));
    }

    private String jZ() {
        if (this.WS <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.WS));
        for (int i = 2; i < this.WS; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    by<Boolean> m1328a(C0383a c0383a, Set<String> set, ck ckVar) {
        by a = m1321a(this.WL, c0383a, (Set) set, ckVar);
        Boolean n = di.m1351n((C0911a) a.getObject());
        ckVar.m1286d(di.m1356r(n));
        return new by(n, a.jr());
    }

    by<Boolean> m1329a(C0387e c0387e, Set<String> set, cn cnVar) {
        boolean z = true;
        for (C0383a a : c0387e.jO()) {
            by a2 = m1328a(a, (Set) set, cnVar.jj());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cnVar.m1289f(di.m1356r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.jr());
            }
            boolean z2 = z && a2.jr();
            z = z2;
        }
        for (C0383a a3 : c0387e.jN()) {
            a2 = m1328a(a3, (Set) set, cnVar.jk());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.jr();
            } else {
                cnVar.m1289f(di.m1356r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.jr());
            }
        }
        cnVar.m1289f(di.m1356r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    by<Set<C0383a>> m1330a(String str, Set<C0387e> set, Map<C0387e, List<C0383a>> map, Map<C0387e, List<String>> map2, Map<C0387e, List<C0383a>> map3, Map<C0387e, List<String>> map4, Set<String> set2, cs csVar) {
        return m1322a((Set) set, (Set) set2, new C07813(this, map, map2, map3, map4), csVar);
    }

    by<Set<C0383a>> m1331a(Set<C0387e> set, cs csVar) {
        return m1322a((Set) set, new HashSet(), new C07824(this), csVar);
    }

    void m1332a(aj ajVar) {
        m1325a(this.WM, ajVar);
    }

    void m1333b(aj ajVar) {
        m1325a(this.WK, ajVar);
    }

    public by<C0911a> bC(String str) {
        this.WS = 0;
        af bl = this.WJ.bl(str);
        by<C0911a> a = m1320a(str, new HashSet(), bl.iY());
        bl.ja();
        return a;
    }

    synchronized void bD(String str) {
        this.WR = str;
    }

    public synchronized void ba(String str) {
        bD(str);
        af bm = this.WJ.bm(str);
        C0407t iZ = bm.iZ();
        for (C0383a a : (Set) m1331a(this.WP, iZ.iS()).getObject()) {
            m1321a(this.WK, a, new HashSet(), iZ.iR());
        }
        bm.ja();
        bD(null);
    }

    void m1334c(aj ajVar) {
        m1325a(this.WL, ajVar);
    }

    public synchronized void m1335f(List<C0907i> list) {
        for (C0907i c0907i : list) {
            if (c0907i.name == null || !c0907i.name.startsWith("gaExperiment:")) {
                bh.m1268v("Ignored supplemental: " + c0907i);
            } else {
                ai.m1243a(this.TN, c0907i);
            }
        }
    }

    synchronized String jY() {
        return this.WR;
    }
}
