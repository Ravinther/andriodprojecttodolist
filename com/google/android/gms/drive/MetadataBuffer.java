package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0178c;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;
import java.util.List;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private static final String[] Dg;
    private final String Dh;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer.a */
    private static class C0864a extends Metadata {
        private final int Di;
        private final DataHolder zU;
        private final int zX;

        public C0864a(DataHolder dataHolder, int i) {
            this.zU = dataHolder;
            this.Di = i;
            this.zX = dataHolder.m1554I(i);
        }

        protected <T> T m2412a(MetadataField<T> metadataField) {
            return metadataField.m333c(this.zU, this.Di, this.zX);
        }

        public Metadata eQ() {
            MetadataBundle fh = MetadataBundle.fh();
            for (MetadataField a : C0178c.fg()) {
                a.m330a(this.zU, fh, this.Di, this.zX);
            }
            return new C0865b(fh);
        }

        public /* synthetic */ Object freeze() {
            return eQ();
        }

        public boolean isDataValid() {
            return !this.zU.isClosed();
        }
    }

    static {
        List arrayList = new ArrayList();
        for (MetadataField ff : C0178c.fg()) {
            arrayList.addAll(ff.ff());
        }
        Dg = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.Dh = nextPageToken;
    }

    public Metadata get(int row) {
        return new C0864a(this.zU, row);
    }

    public String getNextPageToken() {
        return this.Dh;
    }
}
