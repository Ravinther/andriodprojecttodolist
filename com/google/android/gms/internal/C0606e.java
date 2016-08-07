package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.e */
class C0606e implements C0298n {
    C0606e() {
    }

    public String m1774a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] m1775a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
