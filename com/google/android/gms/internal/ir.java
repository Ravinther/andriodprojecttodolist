package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0630a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ir extends fb implements SafeParcelable, Person {
    public static final is CREATOR;
    private static final HashMap<String, C0630a<?, ?>> RL;
    private String FE;
    private final Set<Integer> RM;
    private String SK;
    private C0947a SL;
    private String SM;
    private String SN;
    private int SO;
    private C0950b SP;
    private String SQ;
    private C0951c SR;
    private boolean SS;
    private String ST;
    private C0952d SU;
    private String SV;
    private int SW;
    private List<C0953f> SX;
    private List<C0954g> SY;
    private int SZ;
    private int Ta;
    private String Tb;
    private List<C0955h> Tc;
    private boolean Td;
    private int lu;
    private String pS;
    private String uS;
    private final int wj;

    /* renamed from: com.google.android.gms.internal.ir.e */
    public static class C0292e {
        public static int aT(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.a */
    public static final class C0947a extends fb implements SafeParcelable, AgeRange {
        public static final it CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private final Set<Integer> RM;
        private int Te;
        private int Tf;
        private final int wj;

        static {
            CREATOR = new it();
            RL = new HashMap();
            RL.put("max", C0630a.m1850g("max", 2));
            RL.put("min", C0630a.m1850g("min", 3));
        }

        public C0947a() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0947a(Set<Integer> set, int i, int i2, int i3) {
            this.RM = set;
            this.wj = i;
            this.Te = i2;
            this.Tf = i3;
        }

        protected boolean m2773a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2774b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return Integer.valueOf(this.Te);
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    return Integer.valueOf(this.Tf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            it itVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0947a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0947a c0947a = (C0947a) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2773a(c0630a)) {
                    if (!c0947a.m2773a(c0630a)) {
                        return false;
                    }
                    if (!m2774b(c0630a).equals(c0947a.m2774b(c0630a))) {
                        return false;
                    }
                } else if (c0947a.m2773a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ie();
        }

        public int getMax() {
            return this.Te;
        }

        public int getMin() {
            return this.Tf;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasMax() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2773a(c0630a)) {
                    hashCode = m2774b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0947a ie() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            it itVar = CREATOR;
            it.m989a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.b */
    public static final class C0950b extends fb implements SafeParcelable, Cover {
        public static final iu CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private final Set<Integer> RM;
        private C0948a Tg;
        private C0949b Th;
        private int Ti;
        private final int wj;

        /* renamed from: com.google.android.gms.internal.ir.b.a */
        public static final class C0948a extends fb implements SafeParcelable, CoverInfo {
            public static final iv CREATOR;
            private static final HashMap<String, C0630a<?, ?>> RL;
            private final Set<Integer> RM;
            private int Tj;
            private int Tk;
            private final int wj;

            static {
                CREATOR = new iv();
                RL = new HashMap();
                RL.put("leftImageOffset", C0630a.m1850g("leftImageOffset", 2));
                RL.put("topImageOffset", C0630a.m1850g("topImageOffset", 3));
            }

            public C0948a() {
                this.wj = 1;
                this.RM = new HashSet();
            }

            C0948a(Set<Integer> set, int i, int i2, int i3) {
                this.RM = set;
                this.wj = i;
                this.Tj = i2;
                this.Tk = i3;
            }

            protected boolean m2775a(C0630a c0630a) {
                return this.RM.contains(Integer.valueOf(c0630a.eu()));
            }

            protected Object ak(String str) {
                return null;
            }

            protected boolean al(String str) {
                return false;
            }

            protected Object m2776b(C0630a c0630a) {
                switch (c0630a.eu()) {
                    case Value.STRING_FIELD_NUMBER /*2*/:
                        return Integer.valueOf(this.Tj);
                    case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                        return Integer.valueOf(this.Tk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
                }
            }

            public int describeContents() {
                iv ivVar = CREATOR;
                return 0;
            }

            public HashMap<String, C0630a<?, ?>> en() {
                return RL;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0948a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0948a c0948a = (C0948a) obj;
                for (C0630a c0630a : RL.values()) {
                    if (m2775a(c0630a)) {
                        if (!c0948a.m2775a(c0630a)) {
                            return false;
                        }
                        if (!m2776b(c0630a).equals(c0948a.m2776b(c0630a))) {
                            return false;
                        }
                    } else if (c0948a.m2775a(c0630a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return ii();
            }

            public int getLeftImageOffset() {
                return this.Tj;
            }

            public int getTopImageOffset() {
                return this.Tk;
            }

            int getVersionCode() {
                return this.wj;
            }

            Set<Integer> hB() {
                return this.RM;
            }

            public boolean hasLeftImageOffset() {
                return this.RM.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.RM.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C0630a c0630a : RL.values()) {
                    int hashCode;
                    if (m2775a(c0630a)) {
                        hashCode = m2776b(c0630a).hashCode() + (i + c0630a.eu());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public C0948a ii() {
                return this;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                iv ivVar = CREATOR;
                iv.m991a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ir.b.b */
        public static final class C0949b extends fb implements SafeParcelable, CoverPhoto {
            public static final iw CREATOR;
            private static final HashMap<String, C0630a<?, ?>> RL;
            private final Set<Integer> RM;
            private String pS;
            private int f78v;
            private int f79w;
            private final int wj;

            static {
                CREATOR = new iw();
                RL = new HashMap();
                RL.put("height", C0630a.m1850g("height", 2));
                RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0630a.m1853j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                RL.put("width", C0630a.m1850g("width", 4));
            }

            public C0949b() {
                this.wj = 1;
                this.RM = new HashSet();
            }

            C0949b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.RM = set;
                this.wj = i;
                this.f78v = i2;
                this.pS = str;
                this.f79w = i3;
            }

            protected boolean m2777a(C0630a c0630a) {
                return this.RM.contains(Integer.valueOf(c0630a.eu()));
            }

            protected Object ak(String str) {
                return null;
            }

            protected boolean al(String str) {
                return false;
            }

            protected Object m2778b(C0630a c0630a) {
                switch (c0630a.eu()) {
                    case Value.STRING_FIELD_NUMBER /*2*/:
                        return Integer.valueOf(this.f78v);
                    case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                        return this.pS;
                    case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                        return Integer.valueOf(this.f79w);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
                }
            }

            public int describeContents() {
                iw iwVar = CREATOR;
                return 0;
            }

            public HashMap<String, C0630a<?, ?>> en() {
                return RL;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0949b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0949b c0949b = (C0949b) obj;
                for (C0630a c0630a : RL.values()) {
                    if (m2777a(c0630a)) {
                        if (!c0949b.m2777a(c0630a)) {
                            return false;
                        }
                        if (!m2778b(c0630a).equals(c0949b.m2778b(c0630a))) {
                            return false;
                        }
                    } else if (c0949b.m2777a(c0630a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return ij();
            }

            public int getHeight() {
                return this.f78v;
            }

            public String getUrl() {
                return this.pS;
            }

            int getVersionCode() {
                return this.wj;
            }

            public int getWidth() {
                return this.f79w;
            }

            Set<Integer> hB() {
                return this.RM;
            }

            public boolean hasHeight() {
                return this.RM.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.RM.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.RM.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C0630a c0630a : RL.values()) {
                    int hashCode;
                    if (m2777a(c0630a)) {
                        hashCode = m2778b(c0630a).hashCode() + (i + c0630a.eu());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public C0949b ij() {
                return this;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                iw iwVar = CREATOR;
                iw.m992a(this, out, flags);
            }
        }

        static {
            CREATOR = new iu();
            RL = new HashMap();
            RL.put("coverInfo", C0630a.m1847a("coverInfo", 2, C0948a.class));
            RL.put("coverPhoto", C0630a.m1847a("coverPhoto", 3, C0949b.class));
            RL.put("layout", C0630a.m1846a("layout", 4, new ey().m1832f("banner", 0), false));
        }

        public C0950b() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0950b(Set<Integer> set, int i, C0948a c0948a, C0949b c0949b, int i2) {
            this.RM = set;
            this.wj = i;
            this.Tg = c0948a;
            this.Th = c0949b;
            this.Ti = i2;
        }

        protected boolean m2779a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2780b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return this.Tg;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    return this.Th;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    return Integer.valueOf(this.Ti);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            iu iuVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0950b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0950b c0950b = (C0950b) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2779a(c0630a)) {
                    if (!c0950b.m2779a(c0630a)) {
                        return false;
                    }
                    if (!m2780b(c0630a).equals(c0950b.m2780b(c0630a))) {
                        return false;
                    }
                } else if (c0950b.m2779a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ih();
        }

        public CoverInfo getCoverInfo() {
            return this.Tg;
        }

        public CoverPhoto getCoverPhoto() {
            return this.Th;
        }

        public int getLayout() {
            return this.Ti;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasCoverInfo() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2779a(c0630a)) {
                    hashCode = m2780b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        C0948a m2781if() {
            return this.Tg;
        }

        C0949b ig() {
            return this.Th;
        }

        public C0950b ih() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            iu iuVar = CREATOR;
            iu.m990a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.c */
    public static final class C0951c extends fb implements SafeParcelable, Image {
        public static final ix CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private final Set<Integer> RM;
        private String pS;
        private final int wj;

        static {
            CREATOR = new ix();
            RL = new HashMap();
            RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0630a.m1853j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C0951c() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        public C0951c(String str) {
            this.RM = new HashSet();
            this.wj = 1;
            this.pS = str;
            this.RM.add(Integer.valueOf(2));
        }

        C0951c(Set<Integer> set, int i, String str) {
            this.RM = set;
            this.wj = i;
            this.pS = str;
        }

        protected boolean m2782a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2783b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return this.pS;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            ix ixVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0951c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0951c c0951c = (C0951c) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2782a(c0630a)) {
                    if (!c0951c.m2782a(c0630a)) {
                        return false;
                    }
                    if (!m2783b(c0630a).equals(c0951c.m2783b(c0630a))) {
                        return false;
                    }
                } else if (c0951c.m2782a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ik();
        }

        public String getUrl() {
            return this.pS;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasUrl() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2782a(c0630a)) {
                    hashCode = m2783b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0951c ik() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            ix ixVar = CREATOR;
            ix.m993a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.d */
    public static final class C0952d extends fb implements SafeParcelable, Name {
        public static final iy CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private final Set<Integer> RM;
        private String Sk;
        private String Sn;
        private String Tl;
        private String Tm;
        private String Tn;
        private String To;
        private final int wj;

        static {
            CREATOR = new iy();
            RL = new HashMap();
            RL.put("familyName", C0630a.m1853j("familyName", 2));
            RL.put("formatted", C0630a.m1853j("formatted", 3));
            RL.put("givenName", C0630a.m1853j("givenName", 4));
            RL.put("honorificPrefix", C0630a.m1853j("honorificPrefix", 5));
            RL.put("honorificSuffix", C0630a.m1853j("honorificSuffix", 6));
            RL.put("middleName", C0630a.m1853j("middleName", 7));
        }

        public C0952d() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0952d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.RM = set;
            this.wj = i;
            this.Sk = str;
            this.Tl = str2;
            this.Sn = str3;
            this.Tm = str4;
            this.Tn = str5;
            this.To = str6;
        }

        protected boolean m2784a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2785b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return this.Sk;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    return this.Tl;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    return this.Sn;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    return this.Tm;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    return this.Tn;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    return this.To;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            iy iyVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0952d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0952d c0952d = (C0952d) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2784a(c0630a)) {
                    if (!c0952d.m2784a(c0630a)) {
                        return false;
                    }
                    if (!m2785b(c0630a).equals(c0952d.m2785b(c0630a))) {
                        return false;
                    }
                } else if (c0952d.m2784a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return il();
        }

        public String getFamilyName() {
            return this.Sk;
        }

        public String getFormatted() {
            return this.Tl;
        }

        public String getGivenName() {
            return this.Sn;
        }

        public String getHonorificPrefix() {
            return this.Tm;
        }

        public String getHonorificSuffix() {
            return this.Tn;
        }

        public String getMiddleName() {
            return this.To;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasFamilyName() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.RM.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.RM.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.RM.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2784a(c0630a)) {
                    hashCode = m2785b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0952d il() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            iy iyVar = CREATOR;
            iy.m994a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.f */
    public static final class C0953f extends fb implements SafeParcelable, Organizations {
        public static final iz CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private int AI;
        private String CX;
        private String FH;
        private final Set<Integer> RM;
        private String Sj;
        private String Sz;
        private String Tp;
        private String Tq;
        private boolean Tr;
        private String mName;
        private final int wj;

        static {
            CREATOR = new iz();
            RL = new HashMap();
            RL.put("department", C0630a.m1853j("department", 2));
            RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0630a.m1853j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            RL.put("endDate", C0630a.m1853j("endDate", 4));
            RL.put("location", C0630a.m1853j("location", 5));
            RL.put("name", C0630a.m1853j("name", 6));
            RL.put("primary", C0630a.m1852i("primary", 7));
            RL.put("startDate", C0630a.m1853j("startDate", 8));
            RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0630a.m1853j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            RL.put("type", C0630a.m1846a("type", 10, new ey().m1832f("work", 0).m1832f("school", 1), false));
        }

        public C0953f() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0953f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.RM = set;
            this.wj = i;
            this.Tp = str;
            this.FH = str2;
            this.Sj = str3;
            this.Tq = str4;
            this.mName = str5;
            this.Tr = z;
            this.Sz = str6;
            this.CX = str7;
            this.AI = i2;
        }

        protected boolean m2786a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2787b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return this.Tp;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    return this.FH;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    return this.Sj;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    return this.Tq;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    return this.mName;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    return Boolean.valueOf(this.Tr);
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    return this.Sz;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    return this.CX;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    return Integer.valueOf(this.AI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            iz izVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0953f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0953f c0953f = (C0953f) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2786a(c0630a)) {
                    if (!c0953f.m2786a(c0630a)) {
                        return false;
                    }
                    if (!m2787b(c0630a).equals(c0953f.m2787b(c0630a))) {
                        return false;
                    }
                } else if (c0953f.m2786a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return im();
        }

        public String getDepartment() {
            return this.Tp;
        }

        public String getDescription() {
            return this.FH;
        }

        public String getEndDate() {
            return this.Sj;
        }

        public String getLocation() {
            return this.Tq;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.Sz;
        }

        public String getTitle() {
            return this.CX;
        }

        public int getType() {
            return this.AI;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasDepartment() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.RM.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.RM.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.RM.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.RM.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.RM.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.RM.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2786a(c0630a)) {
                    hashCode = m2787b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0953f im() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Tr;
        }

        public void writeToParcel(Parcel out, int flags) {
            iz izVar = CREATOR;
            iz.m995a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.g */
    public static final class C0954g extends fb implements SafeParcelable, PlacesLived {
        public static final ja CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private final Set<Integer> RM;
        private boolean Tr;
        private String mValue;
        private final int wj;

        static {
            CREATOR = new ja();
            RL = new HashMap();
            RL.put("primary", C0630a.m1852i("primary", 2));
            RL.put("value", C0630a.m1853j("value", 3));
        }

        public C0954g() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0954g(Set<Integer> set, int i, boolean z, String str) {
            this.RM = set;
            this.wj = i;
            this.Tr = z;
            this.mValue = str;
        }

        protected boolean m2788a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2789b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.STRING_FIELD_NUMBER /*2*/:
                    return Boolean.valueOf(this.Tr);
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            ja jaVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0954g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0954g c0954g = (C0954g) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2788a(c0630a)) {
                    if (!c0954g.m2788a(c0630a)) {
                        return false;
                    }
                    if (!m2789b(c0630a).equals(c0954g.m2789b(c0630a))) {
                        return false;
                    }
                } else if (c0954g.m2788a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return in();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasPrimary() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2788a(c0630a)) {
                    hashCode = m2789b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0954g in() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Tr;
        }

        public void writeToParcel(Parcel out, int flags) {
            ja jaVar = CREATOR;
            ja.m996a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.h */
    public static final class C0955h extends fb implements SafeParcelable, Urls {
        public static final jb CREATOR;
        private static final HashMap<String, C0630a<?, ?>> RL;
        private int AI;
        private final Set<Integer> RM;
        private String Ts;
        private final int Tt;
        private String mValue;
        private final int wj;

        static {
            CREATOR = new jb();
            RL = new HashMap();
            RL.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0630a.m1853j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            RL.put("type", C0630a.m1846a("type", 6, new ey().m1832f("home", 0).m1832f("work", 1).m1832f("blog", 2).m1832f(Scopes.PROFILE, 3).m1832f("other", 4).m1832f("otherProfile", 5).m1832f("contributor", 6).m1832f("website", 7), false));
            RL.put("value", C0630a.m1853j("value", 4));
        }

        public C0955h() {
            this.Tt = 4;
            this.wj = 2;
            this.RM = new HashSet();
        }

        C0955h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.Tt = 4;
            this.RM = set;
            this.wj = i;
            this.Ts = str;
            this.AI = i2;
            this.mValue = str2;
        }

        protected boolean m2790a(C0630a c0630a) {
            return this.RM.contains(Integer.valueOf(c0630a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2791b(C0630a c0630a) {
            switch (c0630a.eu()) {
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    return this.mValue;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    return this.Ts;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    return Integer.valueOf(this.AI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
            }
        }

        public int describeContents() {
            jb jbVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0630a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0955h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0955h c0955h = (C0955h) obj;
            for (C0630a c0630a : RL.values()) {
                if (m2790a(c0630a)) {
                    if (!c0955h.m2790a(c0630a)) {
                        return false;
                    }
                    if (!m2791b(c0630a).equals(c0955h.m2791b(c0630a))) {
                        return false;
                    }
                } else if (c0955h.m2790a(c0630a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ip();
        }

        public String getLabel() {
            return this.Ts;
        }

        public int getType() {
            return this.AI;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasLabel() {
            return this.RM.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.RM.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0630a c0630a : RL.values()) {
                int hashCode;
                if (m2790a(c0630a)) {
                    hashCode = m2791b(c0630a).hashCode() + (i + c0630a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        @Deprecated
        public int io() {
            return 4;
        }

        public C0955h ip() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            jb jbVar = CREATOR;
            jb.m997a(this, out, flags);
        }
    }

    static {
        CREATOR = new is();
        RL = new HashMap();
        RL.put("aboutMe", C0630a.m1853j("aboutMe", 2));
        RL.put("ageRange", C0630a.m1847a("ageRange", 3, C0947a.class));
        RL.put("birthday", C0630a.m1853j("birthday", 4));
        RL.put("braggingRights", C0630a.m1853j("braggingRights", 5));
        RL.put("circledByCount", C0630a.m1850g("circledByCount", 6));
        RL.put("cover", C0630a.m1847a("cover", 7, C0950b.class));
        RL.put("currentLocation", C0630a.m1853j("currentLocation", 8));
        RL.put("displayName", C0630a.m1853j("displayName", 9));
        RL.put("gender", C0630a.m1846a("gender", 12, new ey().m1832f("male", 0).m1832f("female", 1).m1832f("other", 2), false));
        RL.put("id", C0630a.m1853j("id", 14));
        RL.put("image", C0630a.m1847a("image", 15, C0951c.class));
        RL.put("isPlusUser", C0630a.m1852i("isPlusUser", 16));
        RL.put("language", C0630a.m1853j("language", 18));
        RL.put("name", C0630a.m1847a("name", 19, C0952d.class));
        RL.put("nickname", C0630a.m1853j("nickname", 20));
        RL.put("objectType", C0630a.m1846a("objectType", 21, new ey().m1832f("person", 0).m1832f("page", 1), false));
        RL.put("organizations", C0630a.m1848b("organizations", 22, C0953f.class));
        RL.put("placesLived", C0630a.m1848b("placesLived", 23, C0954g.class));
        RL.put("plusOneCount", C0630a.m1850g("plusOneCount", 24));
        RL.put("relationshipStatus", C0630a.m1846a("relationshipStatus", 25, new ey().m1832f("single", 0).m1832f("in_a_relationship", 1).m1832f("engaged", 2).m1832f("married", 3).m1832f("its_complicated", 4).m1832f("open_relationship", 5).m1832f("widowed", 6).m1832f("in_domestic_partnership", 7).m1832f("in_civil_union", 8), false));
        RL.put("tagline", C0630a.m1853j("tagline", 26));
        RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0630a.m1853j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        RL.put("urls", C0630a.m1848b("urls", 28, C0955h.class));
        RL.put("verified", C0630a.m1852i("verified", 29));
    }

    public ir() {
        this.wj = 2;
        this.RM = new HashSet();
    }

    public ir(String str, String str2, C0951c c0951c, int i, String str3) {
        this.wj = 2;
        this.RM = new HashSet();
        this.FE = str;
        this.RM.add(Integer.valueOf(9));
        this.uS = str2;
        this.RM.add(Integer.valueOf(14));
        this.SR = c0951c;
        this.RM.add(Integer.valueOf(15));
        this.SW = i;
        this.RM.add(Integer.valueOf(21));
        this.pS = str3;
        this.RM.add(Integer.valueOf(27));
    }

    ir(Set<Integer> set, int i, String str, C0947a c0947a, String str2, String str3, int i2, C0950b c0950b, String str4, String str5, int i3, String str6, C0951c c0951c, boolean z, String str7, C0952d c0952d, String str8, int i4, List<C0953f> list, List<C0954g> list2, int i5, int i6, String str9, String str10, List<C0955h> list3, boolean z2) {
        this.RM = set;
        this.wj = i;
        this.SK = str;
        this.SL = c0947a;
        this.SM = str2;
        this.SN = str3;
        this.SO = i2;
        this.SP = c0950b;
        this.SQ = str4;
        this.FE = str5;
        this.lu = i3;
        this.uS = str6;
        this.SR = c0951c;
        this.SS = z;
        this.ST = str7;
        this.SU = c0952d;
        this.SV = str8;
        this.SW = i4;
        this.SX = list;
        this.SY = list2;
        this.SZ = i5;
        this.Ta = i6;
        this.Tb = str9;
        this.pS = str10;
        this.Tc = list3;
        this.Td = z2;
    }

    public static ir m2792i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ir aI = CREATOR.aI(obtain);
        obtain.recycle();
        return aI;
    }

    protected boolean m2793a(C0630a c0630a) {
        return this.RM.contains(Integer.valueOf(c0630a.eu()));
    }

    protected Object ak(String str) {
        return null;
    }

    protected boolean al(String str) {
        return false;
    }

    protected Object m2794b(C0630a c0630a) {
        switch (c0630a.eu()) {
            case Value.STRING_FIELD_NUMBER /*2*/:
                return this.SK;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return this.SL;
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                return this.SM;
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                return this.SN;
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return Integer.valueOf(this.SO);
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                return this.SP;
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                return this.SQ;
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                return this.FE;
            case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                return Integer.valueOf(this.lu);
            case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                return this.uS;
            case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                return this.SR;
            case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                return Boolean.valueOf(this.SS);
            case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                return this.ST;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.SU;
            case 20:
                return this.SV;
            case 21:
                return Integer.valueOf(this.SW);
            case 22:
                return this.SX;
            case 23:
                return this.SY;
            case 24:
                return Integer.valueOf(this.SZ);
            case 25:
                return Integer.valueOf(this.Ta);
            case 26:
                return this.Tb;
            case 27:
                return this.pS;
            case 28:
                return this.Tc;
            case 29:
                return Boolean.valueOf(this.Td);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0630a.eu());
        }
    }

    public int describeContents() {
        is isVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0630a<?, ?>> en() {
        return RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ir)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ir irVar = (ir) obj;
        for (C0630a c0630a : RL.values()) {
            if (m2793a(c0630a)) {
                if (!irVar.m2793a(c0630a)) {
                    return false;
                }
                if (!m2794b(c0630a).equals(irVar.m2794b(c0630a))) {
                    return false;
                }
            } else if (irVar.m2793a(c0630a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return id();
    }

    public String getAboutMe() {
        return this.SK;
    }

    public AgeRange getAgeRange() {
        return this.SL;
    }

    public String getBirthday() {
        return this.SM;
    }

    public String getBraggingRights() {
        return this.SN;
    }

    public int getCircledByCount() {
        return this.SO;
    }

    public Cover getCover() {
        return this.SP;
    }

    public String getCurrentLocation() {
        return this.SQ;
    }

    public String getDisplayName() {
        return this.FE;
    }

    public int getGender() {
        return this.lu;
    }

    public String getId() {
        return this.uS;
    }

    public Image getImage() {
        return this.SR;
    }

    public String getLanguage() {
        return this.ST;
    }

    public Name getName() {
        return this.SU;
    }

    public String getNickname() {
        return this.SV;
    }

    public int getObjectType() {
        return this.SW;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.SX;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.SY;
    }

    public int getPlusOneCount() {
        return this.SZ;
    }

    public int getRelationshipStatus() {
        return this.Ta;
    }

    public String getTagline() {
        return this.Tb;
    }

    public String getUrl() {
        return this.pS;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.Tc;
    }

    int getVersionCode() {
        return this.wj;
    }

    Set<Integer> hB() {
        return this.RM;
    }

    C0947a hW() {
        return this.SL;
    }

    C0950b hX() {
        return this.SP;
    }

    C0951c hY() {
        return this.SR;
    }

    C0952d hZ() {
        return this.SU;
    }

    public boolean hasAboutMe() {
        return this.RM.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.RM.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.RM.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.RM.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.RM.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.RM.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.RM.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.RM.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.RM.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.RM.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.RM.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.RM.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.RM.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.RM.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.RM.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.RM.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.RM.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.RM.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.RM.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.RM.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.RM.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.RM.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.RM.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.RM.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C0630a c0630a : RL.values()) {
            int hashCode;
            if (m2793a(c0630a)) {
                hashCode = m2794b(c0630a).hashCode() + (i + c0630a.eu());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    List<C0953f> ia() {
        return this.SX;
    }

    List<C0954g> ib() {
        return this.SY;
    }

    List<C0955h> ic() {
        return this.Tc;
    }

    public ir id() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.SS;
    }

    public boolean isVerified() {
        return this.Td;
    }

    public void writeToParcel(Parcel out, int flags) {
        is isVar = CREATOR;
        is.m988a(this, out, flags);
    }
}
