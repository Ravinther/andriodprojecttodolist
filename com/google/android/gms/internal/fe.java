package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0630a;
import java.util.ArrayList;
import java.util.HashMap;

public class fe implements SafeParcelable {
    public static final ff CREATOR;
    private final HashMap<String, HashMap<String, C0630a<?, ?>>> CE;
    private final ArrayList<C0631a> CF;
    private final String CG;
    private final int wj;

    /* renamed from: com.google.android.gms.internal.fe.a */
    public static class C0631a implements SafeParcelable {
        public static final fg CREATOR;
        final ArrayList<C0632b> CH;
        final String className;
        final int versionCode;

        static {
            CREATOR = new fg();
        }

        C0631a(int i, String str, ArrayList<C0632b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.CH = arrayList;
        }

        C0631a(String str, HashMap<String, C0630a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.CH = C0631a.m1857b(hashMap);
        }

        private static ArrayList<C0632b> m1857b(HashMap<String, C0630a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0632b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C0632b(str, (C0630a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            fg fgVar = CREATOR;
            return 0;
        }

        HashMap<String, C0630a<?, ?>> eE() {
            HashMap<String, C0630a<?, ?>> hashMap = new HashMap();
            int size = this.CH.size();
            for (int i = 0; i < size; i++) {
                C0632b c0632b = (C0632b) this.CH.get(i);
                hashMap.put(c0632b.eX, c0632b.CI);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            fg fgVar = CREATOR;
            fg.m757a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fe.b */
    public static class C0632b implements SafeParcelable {
        public static final fd CREATOR;
        final C0630a<?, ?> CI;
        final String eX;
        final int versionCode;

        static {
            CREATOR = new fd();
        }

        C0632b(int i, String str, C0630a<?, ?> c0630a) {
            this.versionCode = i;
            this.eX = str;
            this.CI = c0630a;
        }

        C0632b(String str, C0630a<?, ?> c0630a) {
            this.versionCode = 1;
            this.eX = str;
            this.CI = c0630a;
        }

        public int describeContents() {
            fd fdVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            fd fdVar = CREATOR;
            fd.m751a(this, out, flags);
        }
    }

    static {
        CREATOR = new ff();
    }

    fe(int i, ArrayList<C0631a> arrayList, String str) {
        this.wj = i;
        this.CF = null;
        this.CE = m1858b((ArrayList) arrayList);
        this.CG = (String) er.m721f(str);
        eA();
    }

    public fe(Class<? extends fb> cls) {
        this.wj = 1;
        this.CF = null;
        this.CE = new HashMap();
        this.CG = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, C0630a<?, ?>>> m1858b(ArrayList<C0631a> arrayList) {
        HashMap<String, HashMap<String, C0630a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0631a c0631a = (C0631a) arrayList.get(i);
            hashMap.put(c0631a.className, c0631a.eE());
        }
        return hashMap;
    }

    public void m1859a(Class<? extends fb> cls, HashMap<String, C0630a<?, ?>> hashMap) {
        this.CE.put(cls.getCanonicalName(), hashMap);
    }

    public HashMap<String, C0630a<?, ?>> ao(String str) {
        return (HashMap) this.CE.get(str);
    }

    public boolean m1860b(Class<? extends fb> cls) {
        return this.CE.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        ff ffVar = CREATOR;
        return 0;
    }

    public void eA() {
        for (String str : this.CE.keySet()) {
            HashMap hashMap = (HashMap) this.CE.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0630a) hashMap.get(str2)).m1855a(this);
            }
        }
    }

    public void eB() {
        for (String str : this.CE.keySet()) {
            HashMap hashMap = (HashMap) this.CE.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C0630a) hashMap.get(str2)).eq());
            }
            this.CE.put(str, hashMap2);
        }
    }

    ArrayList<C0631a> eC() {
        ArrayList<C0631a> arrayList = new ArrayList();
        for (String str : this.CE.keySet()) {
            arrayList.add(new C0631a(str, (HashMap) this.CE.get(str)));
        }
        return arrayList;
    }

    public String eD() {
        return this.CG;
    }

    int getVersionCode() {
        return this.wj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.CE.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.CE.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ff ffVar = CREATOR;
        ff.m754a(this, out, flags);
    }
}
