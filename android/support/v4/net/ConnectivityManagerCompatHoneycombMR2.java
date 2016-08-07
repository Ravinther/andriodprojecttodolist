package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case DragSortController.ON_DOWN /*0*/:
            case Value.STRING_FIELD_NUMBER /*2*/:
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return true;
            case Value.TYPE_FIELD_NUMBER /*1*/:
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                return false;
            default:
                return true;
        }
    }
}
