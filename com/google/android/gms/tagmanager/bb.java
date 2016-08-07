package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C0401l.C0400a;

class bb<K, V> implements C0399k<K, V> {
    private LruCache<K, V> Vw;

    /* renamed from: com.google.android.gms.tagmanager.bb.1 */
    class C03731 extends LruCache<K, V> {
        final /* synthetic */ C0400a Vx;
        final /* synthetic */ bb Vy;

        C03731(bb bbVar, int i, C0400a c0400a) {
            this.Vy = bbVar;
            this.Vx = c0400a;
            super(i);
        }

        protected int sizeOf(K key, V value) {
            return this.Vx.sizeOf(key, value);
        }
    }

    bb(int i, C0400a<K, V> c0400a) {
        this.Vw = new C03731(this, i, c0400a);
    }

    public void m2274e(K k, V v) {
        this.Vw.put(k, v);
    }

    public V get(K key) {
        return this.Vw.get(key);
    }
}
