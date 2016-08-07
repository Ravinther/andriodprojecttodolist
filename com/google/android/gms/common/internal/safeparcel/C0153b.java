package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.games.request.GameRequest;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0153b {
    private static int m220B(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m221C(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void m222D(Parcel parcel, int i) {
        C0153b.m221C(parcel, i);
    }

    public static void m223a(Parcel parcel, int i, byte b) {
        C0153b.m240b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m224a(Parcel parcel, int i, double d) {
        C0153b.m240b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m225a(Parcel parcel, int i, float f) {
        C0153b.m240b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m226a(Parcel parcel, int i, long j) {
        C0153b.m240b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m227a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeBundle(bundle);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m228a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m229a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m230a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int B = C0153b.m220B(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m231a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            C0153b.m240b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m232a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeString(str);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m233a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeStringList(list);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m234a(Parcel parcel, int i, short s) {
        C0153b.m240b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m235a(Parcel parcel, int i, boolean z) {
        C0153b.m240b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m236a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeByteArray(bArr);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m237a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0153b.m239a(parcel, parcelable, i2);
                }
            }
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m238a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeStringArray(strArr);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m239a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void m240b(Parcel parcel, int i, int i2) {
        if (i2 >= GameRequest.TYPE_ALL) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m241b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int B = C0153b.m220B(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0153b.m239a(parcel, parcelable, 0);
                }
            }
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static void m242c(Parcel parcel, int i, int i2) {
        C0153b.m240b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m243c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int B = C0153b.m220B(parcel, i);
            parcel.writeList(list);
            C0153b.m221C(parcel, B);
        } else if (z) {
            C0153b.m240b(parcel, i, 0);
        }
    }

    public static int m244p(Parcel parcel) {
        return C0153b.m220B(parcel, 20293);
    }
}
