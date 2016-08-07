package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class bl {
    public static boolean m446a(Context context, bn bnVar, bu buVar) {
        if (bnVar == null) {
            da.m566w("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(bnVar.mZ)) {
            da.m566w("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(bnVar.mimeType)) {
            intent.setData(Uri.parse(bnVar.mZ));
        } else {
            intent.setDataAndType(Uri.parse(bnVar.mZ), bnVar.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(bnVar.packageName)) {
            intent.setPackage(bnVar.packageName);
        }
        if (!TextUtils.isEmpty(bnVar.na)) {
            String[] split = bnVar.na.split("/", 2);
            if (split.length < 2) {
                da.m566w("Could not parse component name from open GMSG: " + bnVar.na);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            da.m565v("Launching an intent: " + intent);
            context.startActivity(intent);
            buVar.m464R();
            return true;
        } catch (ActivityNotFoundException e) {
            da.m566w(e.getMessage());
            return false;
        }
    }
}
