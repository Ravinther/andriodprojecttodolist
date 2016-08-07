package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0630a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class io extends fb implements SafeParcelable, Moment {
    public static final ip CREATOR;
    private static final HashMap<String, C0630a<?, ?>> RL;
    private String Oc;
    private final Set<Integer> RM;
    private im SH;
    private im SI;
    private String Sz;
    private String uS;
    private final int wj;

    static {
        CREATOR = new ip();
        RL = new HashMap();
        RL.put("id", C0630a.m1853j("id", 2));
        RL.put("result", C0630a.m1847a("result", 4, im.class));
        RL.put("startDate", C0630a.m1853j("startDate", 5));
        RL.put("target", C0630a.m1847a("target", 6, im.class));
        RL.put("type", C0630a.m1853j("type", 7));
    }

    public io() {
        this.wj = 1;
        this.RM = new HashSet();
    }

    io(Set<Integer> set, int i, String str, im imVar, String str2, im imVar2, String str3) {
        this.RM = set;
        this.wj = i;
        this.uS = str;
        this.SH = imVar;
        this.Sz = str2;
        this.SI = imVar2;
        this.Oc = str3;
    }

    public io(Set<Integer> set, String str, im imVar, String str2, im imVar2, String str3) {
        this.RM = set;
        this.wj = 1;
        this.uS = str;
        this.SH = imVar;
        this.Sz = str2;
        this.SI = imVar2;
        this.Oc = str3;
    }

    protected boolean m2771a(C0630a c0630a) {
        return this.RM.contains(Integer.valueOf(c0630a.eu()));
    }

    protected Object ak(String str) {
        return null;
    }

    protected boolean al(String str) {
        return false;
    }

    protected Object m2772b(C0630a c0630a) {
        switch (c0630a.eu()) {
            case Value.STRING_FIELD_NUMBER /*2*/:
                return this.uS;
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                return this.SH;
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                return this.Sz;
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return this.SI;
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                return this.Oc;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
        }
    }

    public int describeContents() {
        ip ipVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0630a<?, ?>> en() {
        return RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof io)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        io ioVar = (io) obj;
        for (C0630a c0630a : RL.values()) {
            if (m2771a(c0630a)) {
                if (!ioVar.m2771a(c0630a)) {
                    return false;
                }
                if (!m2772b(c0630a).equals(ioVar.m2772b(c0630a))) {
                    return false;
                }
            } else if (ioVar.m2771a(c0630a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return hU();
    }

    public String getId() {
        return this.uS;
    }

    public ItemScope getResult() {
        return this.SH;
    }

    public String getStartDate() {
        return this.Sz;
    }

    public ItemScope getTarget() {
        return this.SI;
    }

    public String getType() {
        return this.Oc;
    }

    int getVersionCode() {
        return this.wj;
    }

    Set<Integer> hB() {
        return this.RM;
    }

    im hS() {
        return this.SH;
    }

    im hT() {
        return this.SI;
    }

    public io hU() {
        return this;
    }

    public boolean hasId() {
        return this.RM.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.RM.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.RM.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.RM.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.RM.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C0630a c0630a : RL.values()) {
            int hashCode;
            if (m2771a(c0630a)) {
                hashCode = m2772b(c0630a).hashCode() + (i + c0630a.eu());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        ip ipVar = CREATOR;
        ip.m987a(this, out, flags);
    }
}
