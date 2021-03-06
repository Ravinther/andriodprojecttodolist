package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cz {

    /* renamed from: com.google.android.gms.tagmanager.cz.1 */
    static class C03951 implements Runnable {
        final /* synthetic */ Editor Xr;

        C03951(Editor editor) {
            this.Xr = editor;
        }

        public void run() {
            this.Xr.commit();
        }
    }

    static void m1337a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m1338a(edit);
    }

    static void m1338a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C03951(editor)).start();
        }
    }
}
