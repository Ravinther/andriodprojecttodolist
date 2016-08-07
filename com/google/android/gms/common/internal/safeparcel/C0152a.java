package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.games.request.GameRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C0152a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a.a */
    public static class C0151a extends RuntimeException {
        public C0151a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Parcel[] m184A(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    public static int m185S(int i) {
        return GameRequest.TYPE_ALL & i;
    }

    public static int m186a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != SupportMenu.CATEGORY_MASK ? (i >> 16) & GameRequest.TYPE_ALL : parcel.readInt();
    }

    public static <T extends Parcelable> T m187a(Parcel parcel, int i, Creator<T> creator) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m188a(Parcel parcel, int i, int i2) {
        int a = C0152a.m186a(parcel, i);
        if (a != i2) {
            throw new C0151a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    private static void m189a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0151a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static void m190a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static void m191b(Parcel parcel, int i) {
        parcel.setDataPosition(C0152a.m186a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m192b(Parcel parcel, int i, Creator<T> creator) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m193c(Parcel parcel, int i, Creator<T> creator) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m194c(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m195d(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0152a.m189a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte m196e(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short m197f(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m198g(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long m199h(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 8);
        return parcel.readLong();
    }

    public static BigInteger m200i(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m201j(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m202k(Parcel parcel, int i) {
        C0152a.m188a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m203l(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m204m(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static int m205n(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder m206n(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static int m207o(Parcel parcel) {
        int n = C0152a.m205n(parcel);
        int a = C0152a.m186a(parcel, n);
        int dataPosition = parcel.dataPosition();
        if (C0152a.m185S(n) != 20293) {
            throw new C0151a("Expected object header. Got 0x" + Integer.toHexString(n), parcel);
        }
        n = dataPosition + a;
        if (n >= dataPosition && n <= parcel.dataSize()) {
            return n;
        }
        throw new C0151a("Size read is invalid start=" + dataPosition + " end=" + n, parcel);
    }

    public static Bundle m208o(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m209p(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static boolean[] m210q(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m211r(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m212s(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m213t(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    public static float[] m214u(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static double[] m215v(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m216w(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    public static String[] m217x(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> m218y(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m219z(Parcel parcel, int i) {
        int a = C0152a.m186a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }
}
