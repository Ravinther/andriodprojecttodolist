package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C0401l<K, V> {
    final C0400a<K, V> TK;

    /* renamed from: com.google.android.gms.tagmanager.l.a */
    public interface C0400a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.l.1 */
    class C07911 implements C0400a<K, V> {
        final /* synthetic */ C0401l TL;

        C07911(C0401l c0401l) {
            this.TL = c0401l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public C0401l() {
        this.TK = new C07911(this);
    }

    public C0399k<K, V> m1366a(int i, C0400a<K, V> c0400a) {
        if (i > 0) {
            return iA() < 12 ? new da(i, c0400a) : new bb(i, c0400a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int iA() {
        return VERSION.SDK_INT;
    }
}
