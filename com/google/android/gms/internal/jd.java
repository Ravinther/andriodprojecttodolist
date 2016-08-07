package com.google.android.gms.internal;

import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0237c.C0904f;
import com.google.android.gms.internal.C0237c.C0908j;
import com.mobeta.android.dslv.DragSortController;
import java.io.IOException;

public interface jd {

    /* renamed from: com.google.android.gms.internal.jd.a */
    public static final class C0957a extends ka<C0957a> {
        public long Yb;
        public C0908j Yc;
        public C0904f fV;

        public C0957a() {
            kw();
        }

        public static C0957a m2807l(byte[] bArr) throws kd {
            return (C0957a) ke.m1060a(new C0957a(), bArr);
        }

        public void m2808a(jz jzVar) throws IOException {
            jzVar.m1045b(1, this.Yb);
            if (this.fV != null) {
                jzVar.m1042a(2, this.fV);
            }
            if (this.Yc != null) {
                jzVar.m1042a(3, this.Yc);
            }
            super.m2126a(jzVar);
        }

        public /* synthetic */ ke m2809b(jy jyVar) throws IOException {
            return m2811n(jyVar);
        }

        public int m2810c() {
            int c = super.m2128c() + jz.m1032d(1, this.Yb);
            if (this.fV != null) {
                c += jz.m1028b(2, this.fV);
            }
            if (this.Yc != null) {
                c += jz.m1028b(3, this.Yc);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0957a)) {
                return false;
            }
            C0957a c0957a = (C0957a) o;
            if (this.Yb != c0957a.Yb) {
                return false;
            }
            if (this.fV == null) {
                if (c0957a.fV != null) {
                    return false;
                }
            } else if (!this.fV.equals(c0957a.fV)) {
                return false;
            }
            if (this.Yc == null) {
                if (c0957a.Yc != null) {
                    return false;
                }
            } else if (!this.Yc.equals(c0957a.Yc)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0957a.aae == null || c0957a.aae.isEmpty();
            } else {
                return this.aae.equals(c0957a.aae);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.Yc == null ? 0 : this.Yc.hashCode()) + (((this.fV == null ? 0 : this.fV.hashCode()) + ((((int) (this.Yb ^ (this.Yb >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        public C0957a kw() {
            this.Yb = 0;
            this.fV = null;
            this.Yc = null;
            this.aae = null;
            this.DY = -1;
            return this;
        }

        public C0957a m2811n(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case DragSortController.ON_DOWN /*0*/:
                        break;
                    case Value.INTEGER_FIELD_NUMBER /*8*/:
                        this.Yb = jyVar.kA();
                        continue;
                    case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                        if (this.fV == null) {
                            this.fV = new C0904f();
                        }
                        jyVar.m1020a(this.fV);
                        continue;
                    case 26:
                        if (this.Yc == null) {
                            this.Yc = new C0908j();
                        }
                        jyVar.m1020a(this.Yc);
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
    }
}
