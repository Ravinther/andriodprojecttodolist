package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0630a;
import com.mobeta.android.dslv.DragSortController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class fh extends fb implements SafeParcelable {
    public static final fi CREATOR;
    private final fe CC;
    private final Parcel CJ;
    private final int CK;
    private int CL;
    private int CM;
    private final String mClassName;
    private final int wj;

    static {
        CREATOR = new fi();
    }

    fh(int i, Parcel parcel, fe feVar) {
        this.wj = i;
        this.CJ = (Parcel) er.m721f(parcel);
        this.CK = 2;
        this.CC = feVar;
        if (this.CC == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.CC.eD();
        }
        this.CL = 2;
    }

    private fh(SafeParcelable safeParcelable, fe feVar, String str) {
        this.wj = 1;
        this.CJ = Parcel.obtain();
        safeParcelable.writeToParcel(this.CJ, 0);
        this.CK = 1;
        this.CC = (fe) er.m721f(feVar);
        this.mClassName = (String) er.m721f(str);
        this.CL = 2;
    }

    public static <T extends fb & SafeParcelable> fh m1861a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new fh((SafeParcelable) t, m1867b(t), canonicalName);
    }

    private static void m1862a(fe feVar, fb fbVar) {
        Class cls = fbVar.getClass();
        if (!feVar.m1860b(cls)) {
            HashMap en = fbVar.en();
            feVar.m1859a(cls, fbVar.en());
            for (String str : en.keySet()) {
                C0630a c0630a = (C0630a) en.get(str);
                Class ev = c0630a.ev();
                if (ev != null) {
                    try {
                        m1862a(feVar, (fb) ev.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c0630a.ev().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c0630a.ev().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m1863a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
            case Value.TYPE_FIELD_NUMBER /*1*/:
            case Value.STRING_FIELD_NUMBER /*2*/:
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                stringBuilder.append(obj);
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                stringBuilder.append("\"").append(fp.ap(obj.toString())).append("\"");
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                stringBuilder.append("\"").append(fk.m769d((byte[]) obj)).append("\"");
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                stringBuilder.append("\"").append(fk.m770e((byte[]) obj));
                stringBuilder.append("\"");
            case Value.ESCAPING_FIELD_NUMBER /*10*/:
                fq.m773a(stringBuilder, (HashMap) obj);
            case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m1864a(StringBuilder stringBuilder, C0630a<?, ?> c0630a, Parcel parcel, int i) {
        switch (c0630a.em()) {
            case DragSortController.ON_DOWN /*0*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, Integer.valueOf(C0152a.m198g(parcel, i))));
            case Value.TYPE_FIELD_NUMBER /*1*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, C0152a.m200i(parcel, i)));
            case Value.STRING_FIELD_NUMBER /*2*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, Long.valueOf(C0152a.m199h(parcel, i))));
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, Float.valueOf(C0152a.m201j(parcel, i))));
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, Double.valueOf(C0152a.m202k(parcel, i))));
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, C0152a.m203l(parcel, i)));
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, Boolean.valueOf(C0152a.m194c(parcel, i))));
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, C0152a.m204m(parcel, i)));
            case Value.INTEGER_FIELD_NUMBER /*8*/:
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, C0152a.m209p(parcel, i)));
            case Value.ESCAPING_FIELD_NUMBER /*10*/:
                m1869b(stringBuilder, (C0630a) c0630a, m745a(c0630a, m1871c(C0152a.m208o(parcel, i))));
            case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c0630a.em());
        }
    }

    private void m1865a(StringBuilder stringBuilder, String str, C0630a<?, ?> c0630a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c0630a.ex()) {
            m1864a(stringBuilder, c0630a, parcel, i);
        } else {
            m1868b(stringBuilder, c0630a, parcel, i);
        }
    }

    private void m1866a(StringBuilder stringBuilder, HashMap<String, C0630a<?, ?>> hashMap, Parcel parcel) {
        HashMap c = m1872c((HashMap) hashMap);
        stringBuilder.append('{');
        int o = C0152a.m207o(parcel);
        Object obj = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            Entry entry = (Entry) c.get(Integer.valueOf(C0152a.m185S(n)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m1865a(stringBuilder, (String) entry.getKey(), (C0630a) entry.getValue(), parcel, n);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0151a("Overread allowed size end=" + o, parcel);
        }
        stringBuilder.append('}');
    }

    private static fe m1867b(fb fbVar) {
        fe feVar = new fe(fbVar.getClass());
        m1862a(feVar, fbVar);
        feVar.eB();
        feVar.eA();
        return feVar;
    }

    private void m1868b(StringBuilder stringBuilder, C0630a<?, ?> c0630a, Parcel parcel, int i) {
        if (c0630a.es()) {
            stringBuilder.append("[");
            switch (c0630a.em()) {
                case DragSortController.ON_DOWN /*0*/:
                    fj.m764a(stringBuilder, C0152a.m211r(parcel, i));
                    break;
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    fj.m766a(stringBuilder, C0152a.m213t(parcel, i));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    fj.m765a(stringBuilder, C0152a.m212s(parcel, i));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    fj.m763a(stringBuilder, C0152a.m214u(parcel, i));
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    fj.m762a(stringBuilder, C0152a.m215v(parcel, i));
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    fj.m766a(stringBuilder, C0152a.m216w(parcel, i));
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    fj.m768a(stringBuilder, C0152a.m210q(parcel, i));
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    fj.m767a(stringBuilder, C0152a.m217x(parcel, i));
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    Parcel[] A = C0152a.m184A(parcel, i);
                    int length = A.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        A[i2].setDataPosition(0);
                        m1866a(stringBuilder, c0630a.ez(), A[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c0630a.em()) {
            case DragSortController.ON_DOWN /*0*/:
                stringBuilder.append(C0152a.m198g(parcel, i));
            case Value.TYPE_FIELD_NUMBER /*1*/:
                stringBuilder.append(C0152a.m200i(parcel, i));
            case Value.STRING_FIELD_NUMBER /*2*/:
                stringBuilder.append(C0152a.m199h(parcel, i));
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                stringBuilder.append(C0152a.m201j(parcel, i));
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                stringBuilder.append(C0152a.m202k(parcel, i));
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                stringBuilder.append(C0152a.m203l(parcel, i));
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                stringBuilder.append(C0152a.m194c(parcel, i));
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                stringBuilder.append("\"").append(fp.ap(C0152a.m204m(parcel, i))).append("\"");
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                stringBuilder.append("\"").append(fk.m769d(C0152a.m209p(parcel, i))).append("\"");
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                stringBuilder.append("\"").append(fk.m770e(C0152a.m209p(parcel, i)));
                stringBuilder.append("\"");
            case Value.ESCAPING_FIELD_NUMBER /*10*/:
                Bundle o = C0152a.m208o(parcel, i);
                Set<String> keySet = o.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(fp.ap(o.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                Parcel z = C0152a.m219z(parcel, i);
                z.setDataPosition(0);
                m1866a(stringBuilder, c0630a.ez(), z);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m1869b(StringBuilder stringBuilder, C0630a<?, ?> c0630a, Object obj) {
        if (c0630a.er()) {
            m1870b(stringBuilder, (C0630a) c0630a, (ArrayList) obj);
        } else {
            m1863a(stringBuilder, c0630a.el(), obj);
        }
    }

    private void m1870b(StringBuilder stringBuilder, C0630a<?, ?> c0630a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m1863a(stringBuilder, c0630a.el(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> m1871c(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap<Integer, Entry<String, C0630a<?, ?>>> m1872c(HashMap<String, C0630a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0630a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0630a) entry.getValue()).eu()), entry);
        }
        return hashMap2;
    }

    protected Object ak(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean al(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        fi fiVar = CREATOR;
        return 0;
    }

    public Parcel eF() {
        switch (this.CL) {
            case DragSortController.ON_DOWN /*0*/:
                this.CM = C0153b.m244p(this.CJ);
                C0153b.m222D(this.CJ, this.CM);
                this.CL = 2;
                break;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                C0153b.m222D(this.CJ, this.CM);
                this.CL = 2;
                break;
        }
        return this.CJ;
    }

    fe eG() {
        switch (this.CK) {
            case DragSortController.ON_DOWN /*0*/:
                return null;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return this.CC;
            case Value.STRING_FIELD_NUMBER /*2*/:
                return this.CC;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.CK);
        }
    }

    public HashMap<String, C0630a<?, ?>> en() {
        return this.CC == null ? null : this.CC.ao(this.mClassName);
    }

    public int getVersionCode() {
        return this.wj;
    }

    public String toString() {
        er.m719b(this.CC, (Object) "Cannot convert to JSON on client side.");
        Parcel eF = eF();
        eF.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m1866a(stringBuilder, this.CC.ao(this.mClassName), eF);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        fi fiVar = CREATOR;
        fi.m760a(this, out, flags);
    }
}
