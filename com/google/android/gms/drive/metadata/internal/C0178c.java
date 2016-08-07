package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.ft;
import com.google.android.gms.internal.fv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public final class C0178c {
    private static Map<String, MetadataField<?>> Ej;

    static {
        Ej = new HashMap();
        C0178c.m336b(fs.El);
        C0178c.m336b(fs.TITLE);
        C0178c.m336b(fs.MIME_TYPE);
        C0178c.m336b(fs.STARRED);
        C0178c.m336b(fs.TRASHED);
        C0178c.m336b(fs.Em);
        C0178c.m336b(fs.IS_PINNED);
        C0178c.m336b(fs.En);
        C0178c.m336b(fs.Eo);
        C0178c.m336b(fs.PARENTS);
        C0178c.m336b(fs.Ep);
        C0178c.m336b(fs.Eq);
        C0178c.m336b(fs.Er);
        C0178c.m336b(fs.Es);
        C0178c.m336b(fs.Et);
        C0178c.m336b(fs.Eu);
        C0178c.m336b(fs.Ev);
        C0178c.m336b(fs.Ew);
        C0178c.m336b(fs.Ex);
        C0178c.m336b(fs.Ey);
        C0178c.m336b(fs.Ez);
        C0178c.m336b(fs.EA);
        C0178c.m336b(fs.EB);
        C0178c.m336b(fs.EC);
        C0178c.m336b(fs.ED);
        C0178c.m336b(ft.EG);
        C0178c.m336b(ft.EE);
        C0178c.m336b(ft.EF);
        C0178c.m336b(ft.EH);
        C0178c.m336b(ft.LAST_VIEWED_BY_ME);
        C0178c.m336b(fv.EJ);
        C0178c.m336b(fv.EK);
    }

    public static MetadataField<?> ar(String str) {
        return (MetadataField) Ej.get(str);
    }

    private static void m336b(MetadataField<?> metadataField) {
        if (Ej.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        Ej.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> fg() {
        return Collections.unmodifiableCollection(Ej.values());
    }
}
