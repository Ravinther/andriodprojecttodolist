package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

class AdwordsClickReferrerListener implements Listener {
    private final Context context;

    public AdwordsClickReferrerListener(Context context) {
        this.context = context;
    }

    public void changed(Map<Object, Object> update) {
        Object url = update.get("gtm.url");
        if (url == null) {
            Object gtm = update.get("gtm");
            if (gtm != null && (gtm instanceof Map)) {
                url = ((Map) gtm).get(PlusShare.KEY_CALL_TO_ACTION_URL);
            }
        }
        if (url != null && (url instanceof String)) {
            String referrer = Uri.parse((String) url).getQueryParameter("referrer");
            if (referrer != null) {
                InstallReferrerUtil.addClickReferrer(this.context, referrer);
            }
        }
    }
}
