package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C0880g<T extends Parcelable> extends CollectionMetadataField<T> {
    public C0880g(String str, int i) {
        super(str, i);
    }

    protected void m2436a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m2437e(Bundle bundle) {
        return m2438j(bundle);
    }

    protected Collection<T> m2438j(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
