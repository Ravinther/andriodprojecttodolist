package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class jx {
    private final byte[] ZR;
    private int ZS;
    private int ZT;

    public jx(byte[] bArr) {
        int i;
        this.ZR = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            this.ZR[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i2++) {
            i = ((i + this.ZR[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.ZR[i2];
            this.ZR[i2] = this.ZR[i];
            this.ZR[i] = b;
        }
        this.ZS = 0;
        this.ZT = 0;
    }

    public void m1016m(byte[] bArr) {
        int i = this.ZS;
        int i2 = this.ZT;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.ZR[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.ZR[i];
            this.ZR[i] = this.ZR[i2];
            this.ZR[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.ZR[(this.ZR[i] + this.ZR[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.ZS = i;
        this.ZT = i2;
    }
}
