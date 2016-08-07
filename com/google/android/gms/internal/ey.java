package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0281b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ey implements SafeParcelable, C0281b<String, Integer> {
    public static final ez CREATOR;
    private final HashMap<String, Integer> Cp;
    private final HashMap<Integer, String> Cq;
    private final ArrayList<C0617a> Cr;
    private final int wj;

    /* renamed from: com.google.android.gms.internal.ey.a */
    public static final class C0617a implements SafeParcelable {
        public static final fa CREATOR;
        final String Cs;
        final int Ct;
        final int versionCode;

        static {
            CREATOR = new fa();
        }

        C0617a(int i, String str, int i2) {
            this.versionCode = i;
            this.Cs = str;
            this.Ct = i2;
        }

        C0617a(String str, int i) {
            this.versionCode = 1;
            this.Cs = str;
            this.Ct = i;
        }

        public int describeContents() {
            fa faVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            fa faVar = CREATOR;
            fa.m739a(this, out, flags);
        }
    }

    static {
        CREATOR = new ez();
    }

    public ey() {
        this.wj = 1;
        this.Cp = new HashMap();
        this.Cq = new HashMap();
        this.Cr = null;
    }

    ey(int i, ArrayList<C0617a> arrayList) {
        this.wj = i;
        this.Cp = new HashMap();
        this.Cq = new HashMap();
        this.Cr = null;
        m1830a((ArrayList) arrayList);
    }

    private void m1830a(ArrayList<C0617a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0617a c0617a = (C0617a) it.next();
            m1832f(c0617a.Cs, c0617a.Ct);
        }
    }

    public String m1831a(Integer num) {
        String str = (String) this.Cq.get(num);
        return (str == null && this.Cp.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public int describeContents() {
        ez ezVar = CREATOR;
        return 0;
    }

    ArrayList<C0617a> ek() {
        ArrayList<C0617a> arrayList = new ArrayList();
        for (String str : this.Cp.keySet()) {
            arrayList.add(new C0617a(str, ((Integer) this.Cp.get(str)).intValue()));
        }
        return arrayList;
    }

    public int el() {
        return 7;
    }

    public int em() {
        return 0;
    }

    public ey m1832f(String str, int i) {
        this.Cp.put(str, Integer.valueOf(i));
        this.Cq.put(Integer.valueOf(i), str);
        return this;
    }

    public /* synthetic */ Object m1833g(Object obj) {
        return m1831a((Integer) obj);
    }

    int getVersionCode() {
        return this.wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        ez ezVar = CREATOR;
        ez.m734a(this, out, flags);
    }
}
