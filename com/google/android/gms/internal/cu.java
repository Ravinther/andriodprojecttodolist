package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class cu {
    private static final ThreadFactory pK;
    private static final ThreadPoolExecutor pL;

    /* renamed from: com.google.android.gms.internal.cu.1 */
    static class C02431 implements Runnable {
        final /* synthetic */ Runnable pM;

        C02431(Runnable runnable) {
            this.pM = runnable;
        }

        public void run() {
            Process.setThreadPriority(10);
            this.pM.run();
        }
    }

    /* renamed from: com.google.android.gms.internal.cu.2 */
    static class C02442 implements ThreadFactory {
        private final AtomicInteger pN;

        C02442() {
            this.pN = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.pN.getAndIncrement());
        }
    }

    static {
        pK = new C02442();
        pL = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), pK);
    }

    public static void execute(Runnable task) {
        try {
            pL.execute(new C02431(task));
        } catch (Throwable e) {
            da.m560b("Too many background threads already running. Aborting task.", e);
        }
    }
}
