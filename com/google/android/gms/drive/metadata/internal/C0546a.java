package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0546a extends MetadataField<Boolean> {
    public C0546a(String str, int i) {
        super(str, i);
    }

    protected void m1608a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object m1610b(DataHolder dataHolder, int i, int i2) {
        return m1611d(dataHolder, i, i2);
    }

    protected Boolean m1611d(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getBoolean(getName(), i, i2));
    }

    protected /* synthetic */ Object m1612e(Bundle bundle) {
        return m1613f(bundle);
    }

    protected Boolean m1613f(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
