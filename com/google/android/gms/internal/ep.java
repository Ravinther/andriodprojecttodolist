package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ep {

    /* renamed from: com.google.android.gms.internal.ep.a */
    public static final class C0277a {
        private final List<String> Ce;
        private final Object Cf;

        private C0277a(Object obj) {
            this.Cf = er.m721f(obj);
            this.Ce = new ArrayList();
        }

        public C0277a m712a(String str, Object obj) {
            this.Ce.add(((String) er.m721f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.Cf.getClass().getSimpleName()).append('{');
            int size = this.Ce.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.Ce.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static C0277a m713e(Object obj) {
        return new C0277a(null);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
