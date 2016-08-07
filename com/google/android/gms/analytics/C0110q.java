package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.analytics.q */
class C0110q extends BroadcastReceiver {
    static final String rg;
    private final af rh;

    static {
        rg = C0110q.class.getName();
    }

    C0110q(af afVar) {
        this.rh = afVar;
    }

    public static void m78p(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(rg, true);
        context.sendBroadcast(intent);
    }

    public void m79o(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            af afVar = this.rh;
            if (!booleanExtra) {
                z = true;
            }
            afVar.m51q(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(rg)) {
            this.rh.bF();
        }
    }
}
