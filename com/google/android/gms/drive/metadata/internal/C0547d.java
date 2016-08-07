package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C0547d extends MetadataField<Integer> {
    public C0547d(String str, int i) {
        super(str, i);
    }

    protected void m1614a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object m1616b(DataHolder dataHolder, int i, int i2) {
        return m1618f(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m1617e(Bundle bundle) {
        return m1619h(bundle);
    }

    protected Integer m1618f(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }

    protected Integer m1619h(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
