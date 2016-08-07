package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.ads.AdSize;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C0247d {

    /* renamed from: com.google.android.gms.internal.d.a */
    public static final class C0911a extends ka<C0911a> {
        private static volatile C0911a[] fX;
        public String fY;
        public C0911a[] fZ;
        public C0911a[] ga;
        public C0911a[] gb;
        public String gc;
        public String gd;
        public long ge;
        public boolean gf;
        public C0911a[] gg;
        public int[] gh;
        public boolean gi;
        public int type;

        public C0911a() {
            m2564s();
        }

        public static C0911a[] m2559r() {
            if (fX == null) {
                synchronized (kc.aah) {
                    if (fX == null) {
                        fX = new C0911a[0];
                    }
                }
            }
            return fX;
        }

        public void m2560a(jz jzVar) throws IOException {
            int i = 0;
            jzVar.m1051f(1, this.type);
            if (!this.fY.equals("")) {
                jzVar.m1046b(2, this.fY);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                for (ke keVar : this.fZ) {
                    if (keVar != null) {
                        jzVar.m1042a(3, keVar);
                    }
                }
            }
            if (this.ga != null && this.ga.length > 0) {
                for (ke keVar2 : this.ga) {
                    if (keVar2 != null) {
                        jzVar.m1042a(4, keVar2);
                    }
                }
            }
            if (this.gb != null && this.gb.length > 0) {
                for (ke keVar22 : this.gb) {
                    if (keVar22 != null) {
                        jzVar.m1042a(5, keVar22);
                    }
                }
            }
            if (!this.gc.equals("")) {
                jzVar.m1046b(6, this.gc);
            }
            if (!this.gd.equals("")) {
                jzVar.m1046b(7, this.gd);
            }
            if (this.ge != 0) {
                jzVar.m1045b(8, this.ge);
            }
            if (this.gi) {
                jzVar.m1043a(9, this.gi);
            }
            if (this.gh != null && this.gh.length > 0) {
                for (int f : this.gh) {
                    jzVar.m1051f(10, f);
                }
            }
            if (this.gg != null && this.gg.length > 0) {
                while (i < this.gg.length) {
                    ke keVar3 = this.gg[i];
                    if (keVar3 != null) {
                        jzVar.m1042a(11, keVar3);
                    }
                    i++;
                }
            }
            if (this.gf) {
                jzVar.m1043a(12, this.gf);
            }
            super.m2126a(jzVar);
        }

        public /* synthetic */ ke m2561b(jy jyVar) throws IOException {
            return m2563l(jyVar);
        }

        public int m2562c() {
            int i;
            int i2 = 0;
            int c = super.m2128c() + jz.m1035g(1, this.type);
            if (!this.fY.equals("")) {
                c += jz.m1036g(2, this.fY);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                i = c;
                for (ke keVar : this.fZ) {
                    if (keVar != null) {
                        i += jz.m1028b(3, keVar);
                    }
                }
                c = i;
            }
            if (this.ga != null && this.ga.length > 0) {
                i = c;
                for (ke keVar2 : this.ga) {
                    if (keVar2 != null) {
                        i += jz.m1028b(4, keVar2);
                    }
                }
                c = i;
            }
            if (this.gb != null && this.gb.length > 0) {
                i = c;
                for (ke keVar22 : this.gb) {
                    if (keVar22 != null) {
                        i += jz.m1028b(5, keVar22);
                    }
                }
                c = i;
            }
            if (!this.gc.equals("")) {
                c += jz.m1036g(6, this.gc);
            }
            if (!this.gd.equals("")) {
                c += jz.m1036g(7, this.gd);
            }
            if (this.ge != 0) {
                c += jz.m1032d(8, this.ge);
            }
            if (this.gi) {
                c += jz.m1029b(9, this.gi);
            }
            if (this.gh != null && this.gh.length > 0) {
                int i3 = 0;
                for (int cC : this.gh) {
                    i3 += jz.cC(cC);
                }
                c = (c + i3) + (this.gh.length * 1);
            }
            if (this.gg != null && this.gg.length > 0) {
                while (i2 < this.gg.length) {
                    ke keVar3 = this.gg[i2];
                    if (keVar3 != null) {
                        c += jz.m1028b(11, keVar3);
                    }
                    i2++;
                }
            }
            if (this.gf) {
                c += jz.m1029b(12, this.gf);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0911a)) {
                return false;
            }
            C0911a c0911a = (C0911a) o;
            if (this.type != c0911a.type) {
                return false;
            }
            if (this.fY == null) {
                if (c0911a.fY != null) {
                    return false;
                }
            } else if (!this.fY.equals(c0911a.fY)) {
                return false;
            }
            if (!kc.equals(this.fZ, c0911a.fZ) || !kc.equals(this.ga, c0911a.ga) || !kc.equals(this.gb, c0911a.gb)) {
                return false;
            }
            if (this.gc == null) {
                if (c0911a.gc != null) {
                    return false;
                }
            } else if (!this.gc.equals(c0911a.gc)) {
                return false;
            }
            if (this.gd == null) {
                if (c0911a.gd != null) {
                    return false;
                }
            } else if (!this.gd.equals(c0911a.gd)) {
                return false;
            }
            if (this.ge != c0911a.ge || this.gf != c0911a.gf || !kc.equals(this.gg, c0911a.gg) || !kc.equals(this.gh, c0911a.gh) || this.gi != c0911a.gi) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0911a.aae == null || c0911a.aae.isEmpty();
            } else {
                return this.aae.equals(c0911a.aae);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.gf ? 1231 : 1237) + (((((this.gd == null ? 0 : this.gd.hashCode()) + (((this.gc == null ? 0 : this.gc.hashCode()) + (((((((((this.fY == null ? 0 : this.fY.hashCode()) + ((this.type + 527) * 31)) * 31) + kc.hashCode(this.fZ)) * 31) + kc.hashCode(this.ga)) * 31) + kc.hashCode(this.gb)) * 31)) * 31)) * 31) + ((int) (this.ge ^ (this.ge >>> 32)))) * 31)) * 31) + kc.hashCode(this.gg)) * 31) + kc.hashCode(this.gh)) * 31;
            if (!this.gi) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i2 = this.aae.hashCode();
            }
            return hashCode + i2;
        }

        public C0911a m2563l(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                Object obj;
                int i;
                switch (ky) {
                    case DragSortController.ON_DOWN /*0*/:
                        break;
                    case Value.INTEGER_FIELD_NUMBER /*8*/:
                        ky = jyVar.kB();
                        switch (ky) {
                            case Value.TYPE_FIELD_NUMBER /*1*/:
                            case Value.STRING_FIELD_NUMBER /*2*/:
                            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                            case Value.INTEGER_FIELD_NUMBER /*8*/:
                                this.type = ky;
                                break;
                            default:
                                continue;
                        }
                    case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                        this.fY = jyVar.readString();
                        continue;
                    case 26:
                        c = kh.m1071c(jyVar, 26);
                        ky = this.fZ == null ? 0 : this.fZ.length;
                        obj = new C0911a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fZ, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0911a();
                            jyVar.m1020a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0911a();
                        jyVar.m1020a(obj[ky]);
                        this.fZ = obj;
                        continue;
                    case 34:
                        c = kh.m1071c(jyVar, 34);
                        ky = this.ga == null ? 0 : this.ga.length;
                        obj = new C0911a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.ga, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0911a();
                            jyVar.m1020a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0911a();
                        jyVar.m1020a(obj[ky]);
                        this.ga = obj;
                        continue;
                    case 42:
                        c = kh.m1071c(jyVar, 42);
                        ky = this.gb == null ? 0 : this.gb.length;
                        obj = new C0911a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.gb, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0911a();
                            jyVar.m1020a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0911a();
                        jyVar.m1020a(obj[ky]);
                        this.gb = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.gc = jyVar.readString();
                        continue;
                    case 58:
                        this.gd = jyVar.readString();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        this.ge = jyVar.kA();
                        continue;
                    case 72:
                        this.gi = jyVar.kC();
                        continue;
                    case 80:
                        int c2 = kh.m1071c(jyVar, 80);
                        Object obj2 = new int[c2];
                        i = 0;
                        c = 0;
                        while (i < c2) {
                            if (i != 0) {
                                jyVar.ky();
                            }
                            int kB = jyVar.kB();
                            switch (kB) {
                                case Value.TYPE_FIELD_NUMBER /*1*/:
                                case Value.STRING_FIELD_NUMBER /*2*/:
                                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                                case Value.INTEGER_FIELD_NUMBER /*8*/:
                                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                                case Resource.VERSION_FIELD_NUMBER /*13*/:
                                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                                    ky = c + 1;
                                    obj2[c] = kB;
                                    break;
                                default:
                                    ky = c;
                                    break;
                            }
                            i++;
                            c = ky;
                        }
                        if (c != 0) {
                            ky = this.gh == null ? 0 : this.gh.length;
                            if (ky != 0 || c != obj2.length) {
                                Object obj3 = new int[(ky + c)];
                                if (ky != 0) {
                                    System.arraycopy(this.gh, 0, obj3, 0, ky);
                                }
                                System.arraycopy(obj2, 0, obj3, ky, c);
                                this.gh = obj3;
                                break;
                            }
                            this.gh = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            switch (jyVar.kB()) {
                                case Value.TYPE_FIELD_NUMBER /*1*/:
                                case Value.STRING_FIELD_NUMBER /*2*/:
                                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                                case Value.INTEGER_FIELD_NUMBER /*8*/:
                                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                                case Resource.VERSION_FIELD_NUMBER /*13*/:
                                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                                    ky++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (ky != 0) {
                            jyVar.cy(c);
                            c = this.gh == null ? 0 : this.gh.length;
                            Object obj4 = new int[(ky + c)];
                            if (c != 0) {
                                System.arraycopy(this.gh, 0, obj4, 0, c);
                            }
                            while (jyVar.kJ() > 0) {
                                int kB2 = jyVar.kB();
                                switch (kB2) {
                                    case Value.TYPE_FIELD_NUMBER /*1*/:
                                    case Value.STRING_FIELD_NUMBER /*2*/:
                                    case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                                    case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                                    case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                                    case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                                    case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                                    case Value.INTEGER_FIELD_NUMBER /*8*/:
                                    case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                                    case Value.ESCAPING_FIELD_NUMBER /*10*/:
                                    case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                                    case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                                    case Resource.VERSION_FIELD_NUMBER /*13*/:
                                    case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                                    case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                                    case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                                    case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                                        ky = c + 1;
                                        obj4[c] = kB2;
                                        c = ky;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.gh = obj4;
                        }
                        jyVar.cx(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        c = kh.m1071c(jyVar, 90);
                        ky = this.gg == null ? 0 : this.gg.length;
                        obj = new C0911a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.gg, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0911a();
                            jyVar.m1020a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0911a();
                        jyVar.m1020a(obj[ky]);
                        this.gg = obj;
                        continue;
                    case 96:
                        this.gf = jyVar.kC();
                        continue;
                    default:
                        if (!m2127a(jyVar, ky)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public C0911a m2564s() {
            this.type = 1;
            this.fY = "";
            this.fZ = C0911a.m2559r();
            this.ga = C0911a.m2559r();
            this.gb = C0911a.m2559r();
            this.gc = "";
            this.gd = "";
            this.ge = 0;
            this.gf = false;
            this.gg = C0911a.m2559r();
            this.gh = kh.aaj;
            this.gi = false;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }
}
