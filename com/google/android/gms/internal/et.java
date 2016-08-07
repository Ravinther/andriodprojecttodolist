package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.C0083R;
import com.mobeta.android.dslv.DragSortController;

public final class et extends Button {
    public et(Context context) {
        this(context, null);
    }

    public et(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private int m724b(int i, int i2, int i3) {
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
                return i2;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void m725b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
            case Value.TYPE_FIELD_NUMBER /*1*/:
                b = m724b(i2, C0083R.drawable.common_signin_btn_text_dark, C0083R.drawable.common_signin_btn_text_light);
                break;
            case Value.STRING_FIELD_NUMBER /*2*/:
                b = m724b(i2, C0083R.drawable.common_signin_btn_icon_dark, C0083R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    private void m726c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void m727c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m724b(i2, C0083R.color.common_signin_btn_text_dark, C0083R.color.common_signin_btn_text_light)));
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
                setText(resources.getString(C0083R.string.common_signin_button_text));
            case Value.TYPE_FIELD_NUMBER /*1*/:
                setText(resources.getString(C0083R.string.common_signin_button_text_long));
            case Value.STRING_FIELD_NUMBER /*2*/:
                setText(null);
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void m728a(Resources resources, int i, int i2) {
        boolean z = true;
        boolean z2 = i >= 0 && i < 3;
        er.m717a(z2, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        er.m717a(z, "Unknown color scheme " + i2);
        m726c(resources);
        m725b(resources, i, i2);
        m727c(resources, i, i2);
    }
}
