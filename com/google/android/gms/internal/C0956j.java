package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.j */
public abstract class C0956j extends C0658i {
    private static Method kc;
    private static Method kd;
    private static Method ke;
    private static Method kf;
    private static Method kg;
    private static Method kh;
    private static String ki;
    private static C0301p kj;
    static boolean kk;
    private static long startTime;

    /* renamed from: com.google.android.gms.internal.j.a */
    static class C0293a extends Exception {
        public C0293a(Throwable th) {
            super(th);
        }
    }

    static {
        startTime = 0;
        kk = false;
    }

    protected C0956j(Context context, C0298n c0298n, C0299o c0299o) {
        super(context, c0298n, c0299o);
    }

    static String m2795a(Context context, C0298n c0298n) throws C0293a {
        if (ke == null) {
            throw new C0293a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ke.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0298n.m1079a(byteBuffer.array(), true);
            }
            throw new C0293a();
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    static ArrayList<Long> m2796a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0293a {
        if (kf == null || motionEvent == null) {
            throw new C0293a();
        }
        try {
            return (ArrayList) kf.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    protected static synchronized void m2797a(String str, Context context, C0298n c0298n) {
        synchronized (C0956j.class) {
            if (!kk) {
                try {
                    kj = new C0301p(c0298n, null);
                    ki = str;
                    C0956j.m2801e(context);
                    startTime = C0956j.m2803w().longValue();
                    kk = true;
                } catch (C0293a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String m2798b(Context context, C0298n c0298n) throws C0293a {
        if (kh == null) {
            throw new C0293a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kh.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0298n.m1079a(byteBuffer.array(), true);
            }
            throw new C0293a();
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    private static String m2799b(byte[] bArr, String str) throws C0293a {
        try {
            return new String(kj.m1085c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    static String m2800d(Context context) throws C0293a {
        if (kg == null) {
            throw new C0293a();
        }
        try {
            String str = (String) kg.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0293a();
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    private static void m2801e(Context context) throws C0293a {
        try {
            byte[] d = kj.m1086d(C0302r.getKey());
            byte[] c = kj.m1085c(d, C0302r.m1087A());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C0293a();
                }
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C0956j.m2799b(d, C0302r.m1088B()));
            Class loadClass2 = dexClassLoader.loadClass(C0956j.m2799b(d, C0302r.m1094H()));
            Class loadClass3 = dexClassLoader.loadClass(C0956j.m2799b(d, C0302r.m1092F()));
            Class loadClass4 = dexClassLoader.loadClass(C0956j.m2799b(d, C0302r.m1098L()));
            Class loadClass5 = dexClassLoader.loadClass(C0956j.m2799b(d, C0302r.m1090D()));
            Class loadClass6 = dexClassLoader.loadClass(C0956j.m2799b(d, C0302r.m1096J()));
            kc = loadClass.getMethod(C0956j.m2799b(d, C0302r.m1089C()), new Class[0]);
            kd = loadClass2.getMethod(C0956j.m2799b(d, C0302r.m1095I()), new Class[0]);
            ke = loadClass3.getMethod(C0956j.m2799b(d, C0302r.m1093G()), new Class[]{Context.class});
            kf = loadClass4.getMethod(C0956j.m2799b(d, C0302r.m1099M()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            kg = loadClass5.getMethod(C0956j.m2799b(d, C0302r.m1091E()), new Class[]{Context.class});
            kh = loadClass6.getMethod(C0956j.m2799b(d, C0302r.m1097K()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        } catch (Throwable e22) {
            throw new C0293a(e22);
        } catch (Throwable e222) {
            throw new C0293a(e222);
        } catch (Throwable e2222) {
            throw new C0293a(e2222);
        } catch (Throwable e22222) {
            throw new C0293a(e22222);
        }
    }

    static String m2802v() throws C0293a {
        if (ki != null) {
            return ki;
        }
        throw new C0293a();
    }

    static Long m2803w() throws C0293a {
        if (kc == null) {
            throw new C0293a();
        }
        try {
            return (Long) kc.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    static String m2804x() throws C0293a {
        if (kd == null) {
            throw new C0293a();
        }
        try {
            return (String) kd.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0293a(e);
        } catch (Throwable e2) {
            throw new C0293a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m2805b(android.content.Context r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C0956j.m2804x();	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
        r3.m2107a(r0, r1);	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C0956j.m2802v();	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
        r3.m2107a(r0, r1);	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C0956j.m2803w();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r1 = r1.longValue();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r3.m2106a(r0, r1);	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
    L_0x001d:
        r0 = 24;
        r1 = com.google.android.gms.internal.C0956j.m2800d(r4);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
        r3.m2107a(r0, r1);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
    L_0x0026:
        return;
    L_0x0027:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0029:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002b:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002d:
        r0 = move-exception;
        goto L_0x0010;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m2806c(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C0956j.m2802v();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.m2107a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C0956j.m2804x();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.m2107a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = com.google.android.gms.internal.C0956j.m2803w();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.m2106a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r3 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r3;
        r6.m2106a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r1 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.m2106a(r0, r1);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.jY;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.jZ;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0956j.m2796a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2106a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2106a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2106a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.ka;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0956j.m2795a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.m2107a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.ka;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0956j.m2798b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.m2107a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.c(android.content.Context):void");
    }
}
