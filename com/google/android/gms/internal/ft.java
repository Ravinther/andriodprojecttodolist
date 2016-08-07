package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.C0879b;
import java.util.Date;

public class ft {
    public static final OrderedMetadataField<Date> EE;
    public static final OrderedMetadataField<Date> EF;
    public static final OrderedMetadataField<Date> EG;
    public static final OrderedMetadataField<Date> EH;
    public static final OrderedMetadataField<Date> LAST_VIEWED_BY_ME;

    static {
        EE = new C0879b("modified", 4100000);
        EF = new C0879b("modifiedByMe", 4100000);
        EG = new C0879b("created", 4100000);
        EH = new C0879b("sharedWithMe", 4100000);
        LAST_VIEWED_BY_ME = new C0879b("lastOpenedTime", 4300000);
    }
}
