package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public class C0548e extends MetadataField<Long> {
    public C0548e(String str, int i) {
        super(str, i);
    }

    protected void m1620a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object m1622b(DataHolder dataHolder, int i, int i2) {
        return m1624g(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m1623e(Bundle bundle) {
        return m1625i(bundle);
    }

    protected Long m1624g(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.getLong(getName(), i, i2));
    }

    protected Long m1625i(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
