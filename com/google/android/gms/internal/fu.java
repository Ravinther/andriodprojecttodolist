package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.C0549h;
import java.util.Arrays;

public class fu extends C0549h<DriveId> {
    public static final fu EI;

    static {
        EI = new fu();
    }

    private fu() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), 4100000);
    }

    protected /* synthetic */ Object m2630b(DataHolder dataHolder, int i, int i2) {
        return m2631i(dataHolder, i, i2);
    }

    protected DriveId m2631i(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.getMetadata().getLong("dbInstanceId");
        String string = dataHolder.getString("resourceId", i, i2);
        if (string != null && string.startsWith("generated-android-")) {
            string = null;
        }
        return new DriveId(string, Long.valueOf(dataHolder.getLong("sqlId", i, i2)).longValue(), j);
    }
}
