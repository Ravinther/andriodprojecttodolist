package com.google.android.gms.drive.internal;

import android.support.v4.media.TransportMediator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.jy;
import com.google.android.gms.internal.jz;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.ke;
import com.google.android.gms.internal.kh;
import com.mobeta.android.dslv.DragSortController;
import java.io.IOException;

/* renamed from: com.google.android.gms.drive.internal.y */
public final class C0545y extends ke {
    public static final C0545y[] DU;
    public String DV;
    public long DW;
    public long DX;
    private int DY;
    public int versionCode;

    static {
        DU = new C0545y[0];
    }

    public C0545y() {
        this.versionCode = 1;
        this.DV = "";
        this.DW = -1;
        this.DX = -1;
        this.DY = -1;
    }

    public static C0545y m1597g(byte[] bArr) throws kd {
        return (C0545y) ke.m1060a(new C0545y(), bArr);
    }

    public void m1598a(jz jzVar) throws IOException {
        jzVar.m1051f(1, this.versionCode);
        jzVar.m1046b(2, this.DV);
        jzVar.m1048c(3, this.DW);
        jzVar.m1048c(4, this.DX);
    }

    public /* synthetic */ ke m1599b(jy jyVar) throws IOException {
        return m1601m(jyVar);
    }

    public int m1600c() {
        int g = (((0 + jz.m1035g(1, this.versionCode)) + jz.m1036g(2, this.DV)) + jz.m1034e(3, this.DW)) + jz.m1034e(4, this.DX);
        this.DY = g;
        return g;
    }

    public int eW() {
        if (this.DY < 0) {
            m1600c();
        }
        return this.DY;
    }

    public C0545y m1601m(jy jyVar) throws IOException {
        while (true) {
            int ky = jyVar.ky();
            switch (ky) {
                case DragSortController.ON_DOWN /*0*/:
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    this.versionCode = jyVar.kB();
                    continue;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    this.DV = jyVar.readString();
                    continue;
                case 24:
                    this.DW = jyVar.kD();
                    continue;
                case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                    this.DX = jyVar.kD();
                    continue;
                default:
                    if (!kh.m1070b(jyVar, ky)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
