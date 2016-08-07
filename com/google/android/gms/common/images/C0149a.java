package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fr;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public final class C0149a {
    final C0148a AF;
    private int AG;
    private int AH;
    int AI;
    private int AJ;
    private WeakReference<OnImageLoadedListener> AK;
    private WeakReference<ImageView> AL;
    private WeakReference<TextView> AM;
    private int AN;
    private boolean AO;
    private boolean AP;
    private int AQ;

    /* renamed from: com.google.android.gms.common.images.a.a */
    public static final class C0148a {
        public final Uri uri;

        public C0148a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0148a) {
                return this == obj || ((C0148a) obj).hashCode() == hashCode();
            } else {
                return false;
            }
        }

        public int hashCode() {
            return ep.hashCode(this.uri);
        }
    }

    public C0149a(int i) {
        this.AG = 0;
        this.AH = 0;
        this.AN = -1;
        this.AO = true;
        this.AP = false;
        this.AF = new C0148a(null);
        this.AH = i;
    }

    public C0149a(Uri uri) {
        this.AG = 0;
        this.AH = 0;
        this.AN = -1;
        this.AO = true;
        this.AP = false;
        this.AF = new C0148a(uri);
        this.AH = 0;
    }

    private ea m170a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof ea) {
            drawable = ((ea) drawable).dO();
        }
        return new ea(drawable, drawable2);
    }

    private void m171a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        switch (this.AI) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                if (!z2) {
                    OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.AK.get();
                    if (onImageLoadedListener != null) {
                        onImageLoadedListener.onImageLoaded(this.AF.uri, drawable, z3);
                    }
                }
            case Value.STRING_FIELD_NUMBER /*2*/:
                ImageView imageView = (ImageView) this.AL.get();
                if (imageView != null) {
                    m172a(imageView, drawable, z, z2, z3);
                }
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                TextView textView = (TextView) this.AM.get();
                if (textView != null) {
                    m173a(textView, this.AN, drawable, z, z2);
                }
            default:
        }
    }

    private void m172a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
        Object obj = (z2 || z3) ? null : 1;
        if (obj != null && (imageView instanceof ec)) {
            int dQ = ((ec) imageView).dQ();
            if (this.AH != 0 && dQ == this.AH) {
                return;
            }
        }
        boolean b = m174b(z, z2);
        Drawable a = b ? m170a(imageView.getDrawable(), drawable) : drawable;
        imageView.setImageDrawable(a);
        if (imageView instanceof ec) {
            ec ecVar = (ec) imageView;
            ecVar.m659d(z3 ? this.AF.uri : null);
            ecVar.m658N(obj != null ? this.AH : 0);
        }
        if (b) {
            ((ea) a).startTransition(250);
        }
    }

    private void m173a(TextView textView, int i, Drawable drawable, boolean z, boolean z2) {
        boolean b = m174b(z, z2);
        Drawable[] compoundDrawablesRelative = fr.eO() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
        Drawable a = b ? m170a(compoundDrawablesRelative[i], drawable) : drawable;
        Drawable drawable2 = i == 0 ? a : compoundDrawablesRelative[0];
        Drawable drawable3 = i == 1 ? a : compoundDrawablesRelative[1];
        Drawable drawable4 = i == 2 ? a : compoundDrawablesRelative[2];
        Drawable drawable5 = i == 3 ? a : compoundDrawablesRelative[3];
        if (fr.eO()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        }
        if (b) {
            ((ea) a).startTransition(250);
        }
    }

    private boolean m174b(boolean z, boolean z2) {
        return this.AO && !z2 && (!z || this.AP);
    }

    public void m175L(int i) {
        this.AH = i;
    }

    void m176a(Context context, Bitmap bitmap, boolean z) {
        ed.m661d(bitmap);
        if ((this.AQ & 1) != 0) {
            bitmap = eb.m655a(bitmap);
        }
        m171a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    public void m177a(ImageView imageView) {
        ed.m661d(imageView);
        this.AK = null;
        this.AL = new WeakReference(imageView);
        this.AM = null;
        this.AN = -1;
        this.AI = 2;
        this.AJ = imageView.hashCode();
    }

    public void m178a(OnImageLoadedListener onImageLoadedListener) {
        ed.m661d(onImageLoadedListener);
        this.AK = new WeakReference(onImageLoadedListener);
        this.AL = null;
        this.AM = null;
        this.AN = -1;
        this.AI = 1;
        this.AJ = ep.hashCode(onImageLoadedListener, this.AF);
    }

    void m179b(Context context, boolean z) {
        Drawable drawable = null;
        if (this.AH != 0) {
            Resources resources = context.getResources();
            drawable = resources.getDrawable(this.AH);
            if ((this.AQ & 1) != 0) {
                drawable = eb.m657a(resources, drawable);
            }
        }
        m171a(drawable, z, false, false);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0149a) {
            return this == obj || ((C0149a) obj).hashCode() == hashCode();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.AJ;
    }

    void m180x(Context context) {
        Drawable drawable = null;
        if (this.AG != 0) {
            Resources resources = context.getResources();
            drawable = resources.getDrawable(this.AG);
            if ((this.AQ & 1) != 0) {
                drawable = eb.m657a(resources, drawable);
            }
        }
        m171a(drawable, false, true, false);
    }
}
