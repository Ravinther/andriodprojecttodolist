package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class fb {

    /* renamed from: com.google.android.gms.internal.fb.b */
    public interface C0281b<I, O> {
        int el();

        int em();

        I m742g(O o);
    }

    /* renamed from: com.google.android.gms.internal.fb.a */
    public static class C0630a<I, O> implements SafeParcelable {
        public static final fc CREATOR;
        protected final Class<? extends fb> CA;
        protected final String CB;
        private fe CC;
        private C0281b<I, O> CD;
        protected final int Cu;
        protected final boolean Cv;
        protected final int Cw;
        protected final boolean Cx;
        protected final String Cy;
        protected final int Cz;
        private final int wj;

        static {
            CREATOR = new fc();
        }

        C0630a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ew ewVar) {
            this.wj = i;
            this.Cu = i2;
            this.Cv = z;
            this.Cw = i3;
            this.Cx = z2;
            this.Cy = str;
            this.Cz = i4;
            if (str2 == null) {
                this.CA = null;
                this.CB = null;
            } else {
                this.CA = fh.class;
                this.CB = str2;
            }
            if (ewVar == null) {
                this.CD = null;
            } else {
                this.CD = ewVar.ej();
            }
        }

        protected C0630a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends fb> cls, C0281b<I, O> c0281b) {
            this.wj = 1;
            this.Cu = i;
            this.Cv = z;
            this.Cw = i2;
            this.Cx = z2;
            this.Cy = str;
            this.Cz = i3;
            this.CA = cls;
            if (cls == null) {
                this.CB = null;
            } else {
                this.CB = cls.getCanonicalName();
            }
            this.CD = c0281b;
        }

        public static C0630a m1846a(String str, int i, C0281b<?, ?> c0281b, boolean z) {
            return new C0630a(c0281b.el(), z, c0281b.em(), false, str, i, null, c0281b);
        }

        public static <T extends fb> C0630a<T, T> m1847a(String str, int i, Class<T> cls) {
            return new C0630a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends fb> C0630a<ArrayList<T>, ArrayList<T>> m1848b(String str, int i, Class<T> cls) {
            return new C0630a(11, true, 11, true, str, i, cls, null);
        }

        public static C0630a<Integer, Integer> m1850g(String str, int i) {
            return new C0630a(0, false, 0, false, str, i, null, null);
        }

        public static C0630a<Double, Double> m1851h(String str, int i) {
            return new C0630a(4, false, 4, false, str, i, null, null);
        }

        public static C0630a<Boolean, Boolean> m1852i(String str, int i) {
            return new C0630a(6, false, 6, false, str, i, null, null);
        }

        public static C0630a<String, String> m1853j(String str, int i) {
            return new C0630a(7, false, 7, false, str, i, null, null);
        }

        public static C0630a<ArrayList<String>, ArrayList<String>> m1854k(String str, int i) {
            return new C0630a(7, true, 7, true, str, i, null, null);
        }

        public void m1855a(fe feVar) {
            this.CC = feVar;
        }

        public int describeContents() {
            fc fcVar = CREATOR;
            return 0;
        }

        public int el() {
            return this.Cu;
        }

        public int em() {
            return this.Cw;
        }

        public C0630a<I, O> eq() {
            return new C0630a(this.wj, this.Cu, this.Cv, this.Cw, this.Cx, this.Cy, this.Cz, this.CB, ey());
        }

        public boolean er() {
            return this.Cv;
        }

        public boolean es() {
            return this.Cx;
        }

        public String et() {
            return this.Cy;
        }

        public int eu() {
            return this.Cz;
        }

        public Class<? extends fb> ev() {
            return this.CA;
        }

        String ew() {
            return this.CB == null ? null : this.CB;
        }

        public boolean ex() {
            return this.CD != null;
        }

        ew ey() {
            return this.CD == null ? null : ew.m1829a(this.CD);
        }

        public HashMap<String, C0630a<?, ?>> ez() {
            er.m721f(this.CB);
            er.m721f(this.CC);
            return this.CC.ao(this.CB);
        }

        public I m1856g(O o) {
            return this.CD.m742g(o);
        }

        public int getVersionCode() {
            return this.wj;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.wj).append('\n');
            stringBuilder.append("                 typeIn=").append(this.Cu).append('\n');
            stringBuilder.append("            typeInArray=").append(this.Cv).append('\n');
            stringBuilder.append("                typeOut=").append(this.Cw).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.Cx).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.Cy).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.Cz).append('\n');
            stringBuilder.append("       concreteTypeName=").append(ew()).append('\n');
            if (ev() != null) {
                stringBuilder.append("     concreteType.class=").append(ev().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.CD == null ? "null" : this.CD.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            fc fcVar = CREATOR;
            fc.m748a(this, out, flags);
        }
    }

    private void m743a(StringBuilder stringBuilder, C0630a c0630a, Object obj) {
        if (c0630a.el() == 11) {
            stringBuilder.append(((fb) c0630a.ev().cast(obj)).toString());
        } else if (c0630a.el() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(fp.ap((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m744a(StringBuilder stringBuilder, C0630a c0630a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m743a(stringBuilder, c0630a, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m745a(C0630a<I, O> c0630a, Object obj) {
        return c0630a.CD != null ? c0630a.m1856g(obj) : obj;
    }

    protected boolean m746a(C0630a c0630a) {
        return c0630a.em() == 11 ? c0630a.es() ? an(c0630a.et()) : am(c0630a.et()) : al(c0630a.et());
    }

    protected abstract Object ak(String str);

    protected abstract boolean al(String str);

    protected boolean am(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean an(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object m747b(C0630a c0630a) {
        boolean z = true;
        String et = c0630a.et();
        if (c0630a.ev() == null) {
            return ak(c0630a.et());
        }
        if (ak(c0630a.et()) != null) {
            z = false;
        }
        er.m717a(z, "Concrete field shouldn't be value object: " + c0630a.et());
        Map ep = c0630a.es() ? ep() : eo();
        if (ep != null) {
            return ep.get(et);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(et.charAt(0)) + et.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap<String, C0630a<?, ?>> en();

    public HashMap<String, Object> eo() {
        return null;
    }

    public HashMap<String, Object> ep() {
        return null;
    }

    public String toString() {
        HashMap en = en();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : en.keySet()) {
            C0630a c0630a = (C0630a) en.get(str);
            if (m746a(c0630a)) {
                Object a = m745a(c0630a, m747b(c0630a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c0630a.em()) {
                        case Value.INTEGER_FIELD_NUMBER /*8*/:
                            stringBuilder.append("\"").append(fk.m769d((byte[]) a)).append("\"");
                            break;
                        case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                            stringBuilder.append("\"").append(fk.m770e((byte[]) a)).append("\"");
                            break;
                        case Value.ESCAPING_FIELD_NUMBER /*10*/:
                            fq.m773a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c0630a.er()) {
                                m743a(stringBuilder, c0630a, a);
                                break;
                            }
                            m744a(stringBuilder, c0630a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
