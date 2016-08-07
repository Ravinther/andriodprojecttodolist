package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0130a implements ServiceConnection {
    boolean yG;
    private final BlockingQueue<IBinder> yH;

    public C0130a() {
        this.yG = false;
        this.yH = new LinkedBlockingQueue();
    }

    public IBinder dm() throws InterruptedException {
        if (this.yG) {
            throw new IllegalStateException();
        }
        this.yG = true;
        return (IBinder) this.yH.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.yH.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
