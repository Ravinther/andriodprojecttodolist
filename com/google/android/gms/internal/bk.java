package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.ads.C0085a;
import java.util.Date;
import java.util.HashSet;

public final class bk {

    /* renamed from: com.google.android.gms.internal.bk.1 */
    static /* synthetic */ class C02261 {
        static final /* synthetic */ int[] mW;
        static final /* synthetic */ int[] mX;

        static {
            mX = new int[ErrorCode.values().length];
            try {
                mX[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mX[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mX[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mX[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            mW = new int[Gender.values().length];
            try {
                mW[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                mW[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                mW[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m440a(ErrorCode errorCode) {
        switch (C02261.mX[errorCode.ordinal()]) {
            case Value.STRING_FIELD_NUMBER /*2*/:
                return 1;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return 2;
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static int m441a(Gender gender) {
        switch (C02261.mW[gender.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return 2;
            case Value.STRING_FIELD_NUMBER /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    public static AdSize m442b(ab abVar) {
        return new AdSize(C0085a.m17a(abVar.width, abVar.height, abVar.ln));
    }

    public static MediationAdRequest m443e(C0673z c0673z) {
        return new MediationAdRequest(new Date(c0673z.le), m444g(c0673z.lf), c0673z.lg != null ? new HashSet(c0673z.lg) : null, c0673z.lh);
    }

    public static Gender m444g(int i) {
        switch (i) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return Gender.MALE;
            case Value.STRING_FIELD_NUMBER /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static final ErrorCode m445h(int i) {
        switch (i) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return ErrorCode.INVALID_REQUEST;
            case Value.STRING_FIELD_NUMBER /*2*/:
                return ErrorCode.NETWORK_ERROR;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return ErrorCode.NO_FILL;
            default:
                return ErrorCode.INTERNAL_ERROR;
        }
    }
}
