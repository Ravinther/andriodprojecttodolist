package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

public final class ed {
    public static void m660a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void ac(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(str);
        }
    }

    public static void ad(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(str);
        }
    }

    public static void m661d(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void m662v(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
