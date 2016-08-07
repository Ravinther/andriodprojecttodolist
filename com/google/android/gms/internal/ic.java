package com.google.android.gms.internal;

import com.google.android.gms.internal.hx.C0657a;
import com.google.android.gms.internal.hx.C0657a.C0290a;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ic {
    private static int OB;
    private static int OC;
    private final hl<hg> Lk;
    private final String OD;
    private final BlockingQueue<C0657a> OE;
    private int OF;
    private final int Ou;
    private final Object mg;

    static {
        OB = 10000;
        OC = GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
    }

    public ic(hl<hg> hlVar, String str, int i) {
        this.mg = new Object();
        this.Lk = hlVar;
        this.OD = str;
        this.Ou = i;
        this.OE = new LinkedBlockingQueue(OB);
        this.OF = OC;
    }

    public void m982a(C0290a c0290a) {
        c0290a.aK(this.OD);
        c0290a.bv(this.Ou);
        this.OE.offer(c0290a.gJ());
    }
}
