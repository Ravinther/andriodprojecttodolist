package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as Vc;
    private final LinkedBlockingQueue<Runnable> Vb;
    private volatile at Vd;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean sa;

    /* renamed from: com.google.android.gms.tagmanager.as.1 */
    class C03701 implements Runnable {
        final /* synthetic */ ar Ve;
        final /* synthetic */ long Vf;
        final /* synthetic */ String Vg;
        final /* synthetic */ as Vh;

        C03701(as asVar, ar arVar, long j, String str) {
            this.Vh = asVar;
            this.Ve = arVar;
            this.Vf = j;
            this.Vg = str;
        }

        public void run() {
            if (this.Vh.Vd == null) {
                cy kh = cy.kh();
                kh.m2322a(this.Vh.mContext, this.Ve);
                this.Vh.Vd = kh.ki();
            }
            this.Vh.Vd.m1252e(this.Vf, this.Vg);
        }
    }

    private as(Context context) {
        super("GAThread");
        this.Vb = new LinkedBlockingQueue();
        this.sa = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static as m2257H(Context context) {
        if (Vc == null) {
            Vc = new as(context);
        }
        return Vc;
    }

    private String m2260a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void m2262a(Runnable runnable) {
        this.Vb.add(runnable);
    }

    void m2263b(String str, long j) {
        m2262a(new C03701(this, this, j, str));
    }

    public void bn(String str) {
        m2263b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.Vb.take();
                if (!this.sa) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.m1267u(e.toString());
            } catch (Throwable th) {
                bh.m1266t("Error on GAThread: " + m2260a(th));
                bh.m1266t("Google Analytics is shutting down.");
                this.sa = true;
            }
        }
    }
}
