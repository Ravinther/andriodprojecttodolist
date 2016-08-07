package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.b */
public final class C0865b extends Metadata {
    private final MetadataBundle CZ;

    public C0865b(MetadataBundle metadataBundle) {
        this.CZ = metadataBundle;
    }

    protected <T> T m2413a(MetadataField<T> metadataField) {
        return this.CZ.m1606a((MetadataField) metadataField);
    }

    public Metadata eQ() {
        return new C0865b(MetadataBundle.m1605a(this.CZ));
    }

    public /* synthetic */ Object freeze() {
        return eQ();
    }

    public boolean isDataValid() {
        return this.CZ != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.CZ + "]";
    }
}
