package com.google.android.gms.analytics;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import com.google.analytics.tracking.android.Fields;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C0509h implements C0106m {
    private static final Object qI;
    private static C0509h qW;
    private final Context mContext;
    private String qX;
    private boolean qY;
    private final Object qZ;

    /* renamed from: com.google.android.gms.analytics.h.1 */
    class C01001 extends Thread {
        final /* synthetic */ C0509h ra;

        C01001(C0509h c0509h, String str) {
            this.ra = c0509h;
            super(str);
        }

        public void run() {
            synchronized (this.ra.qZ) {
                this.ra.qX = this.ra.by();
                this.ra.qY = true;
                this.ra.qZ.notifyAll();
            }
        }
    }

    static {
        qI = new Object();
    }

    protected C0509h(Context context) {
        this.qY = false;
        this.qZ = new Object();
        this.mContext = context;
        bx();
    }

    public static C0509h bu() {
        C0509h c0509h;
        synchronized (qI) {
            c0509h = qW;
        }
        return c0509h;
    }

    private String bv() {
        if (!this.qY) {
            synchronized (this.qZ) {
                if (!this.qY) {
                    aa.m46v("Waiting for clientId to load");
                    do {
                        try {
                            this.qZ.wait();
                        } catch (InterruptedException e) {
                            aa.m44t("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.qY);
                }
            }
        }
        aa.m46v("Loaded clientId");
        return this.qX;
    }

    private void bx() {
        new C01001(this, "client_id_fetcher").start();
    }

    public static void m1461n(Context context) {
        synchronized (qI) {
            if (qW == null) {
                qW = new C0509h(context);
            }
        }
    }

    private boolean m1462y(String str) {
        try {
            aa.m46v("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.m44t("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.m44t("Error writing to clientId file.");
            return false;
        }
    }

    protected String bw() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m1462y(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    String by() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[TransportMediator.FLAG_KEY_MEDIA_NEXT];
            int read = openFileInput.read(bArr, 0, TransportMediator.FLAG_KEY_MEDIA_NEXT);
            if (openFileInput.available() > 0) {
                aa.m44t("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.m44t("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m44t("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.m44t("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? bw() : str;
    }

    public String getValue(String field) {
        return Fields.CLIENT_ID.equals(field) ? bv() : null;
    }

    public boolean m1463x(String str) {
        return Fields.CLIENT_ID.equals(str);
    }
}
