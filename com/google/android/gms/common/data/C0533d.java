package com.google.android.gms.common.data;

import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.data.d */
public abstract class C0533d<T> extends DataBuffer<T> {
    private boolean Ap;
    private ArrayList<Integer> Aq;

    protected C0533d(DataHolder dataHolder) {
        super(dataHolder);
        this.Ap = false;
    }

    private int m1557K(int i) {
        return (i < 0 || i == this.Aq.size()) ? 0 : i == this.Aq.size() + -1 ? this.zU.getCount() - ((Integer) this.Aq.get(i)).intValue() : ((Integer) this.Aq.get(i + 1)).intValue() - ((Integer) this.Aq.get(i)).intValue();
    }

    private void dK() {
        synchronized (this) {
            if (!this.Ap) {
                int count = this.zU.getCount();
                this.Aq = new ArrayList();
                if (count > 0) {
                    this.Aq.add(Integer.valueOf(0));
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.zU.getString(primaryDataMarkerColumn, 0, this.zU.m1554I(0));
                    int i = 1;
                    while (i < count) {
                        String string2 = this.zU.getString(primaryDataMarkerColumn, i, this.zU.m1554I(i));
                        if (string2.equals(string)) {
                            string2 = string;
                        } else {
                            this.Aq.add(Integer.valueOf(i));
                        }
                        i++;
                        string = string2;
                    }
                }
                this.Ap = true;
            }
        }
    }

    int m1558J(int i) {
        if (i >= 0 && i < this.Aq.size()) {
            return ((Integer) this.Aq.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected abstract T m1559c(int i, int i2);

    public final T get(int position) {
        dK();
        return m1559c(m1558J(position), m1557K(position));
    }

    public int getCount() {
        dK();
        return this.Aq.size();
    }

    protected abstract String getPrimaryDataMarkerColumn();
}
