package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0149a.C0148a;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ev;
import com.google.android.gms.internal.fr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object Ar;
    private static HashSet<Uri> As;
    private static ImageManager At;
    private static ImageManager Au;
    private final ExecutorService Av;
    private final C0534b Aw;
    private final Map<C0149a, ImageReceiver> Ax;
    private final Map<Uri, ImageReceiver> Ay;
    private final Context mContext;
    private final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        boolean AA;
        final /* synthetic */ ImageManager AB;
        private final ArrayList<C0149a> Az;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.AB = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.AA = false;
            this.mUri = uri;
            this.Az = new ArrayList();
        }

        public void m154c(C0149a c0149a) {
            ed.m660a(!this.AA, "Cannot add an ImageRequest when mHandlingRequests is true");
            ed.ac("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Az.add(c0149a);
        }

        public void m155d(C0149a c0149a) {
            ed.m660a(!this.AA, "Cannot remove an ImageRequest when mHandlingRequests is true");
            ed.ac("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Az.remove(c0149a);
        }

        public void dN() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.AB.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.AB.Av.execute(new C0144c(this.AB, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.a */
    private static final class C0143a {
        static int m156a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.c */
    private final class C0144c implements Runnable {
        final /* synthetic */ ImageManager AB;
        private final ParcelFileDescriptor AC;
        private final Uri mUri;

        public C0144c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.AB = imageManager;
            this.mUri = uri;
            this.AC = parcelFileDescriptor;
        }

        public void run() {
            ed.ad("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.AC != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.AC.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.AC.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.AB.mHandler.post(new C0147f(this.AB, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.d */
    private final class C0145d implements Runnable {
        final /* synthetic */ ImageManager AB;
        private final C0149a AD;

        public C0145d(ImageManager imageManager, C0149a c0149a) {
            this.AB = imageManager;
            this.AD = c0149a;
        }

        public void run() {
            ed.ac("LoadImageRunnable must be executed on the main thread");
            this.AB.m164b(this.AD);
            C0148a c0148a = this.AD.AF;
            if (c0148a.uri == null) {
                this.AD.m179b(this.AB.mContext, true);
                return;
            }
            Bitmap a = this.AB.m160a(c0148a);
            if (a != null) {
                this.AD.m176a(this.AB.mContext, a, true);
                return;
            }
            this.AD.m180x(this.AB.mContext);
            ImageReceiver imageReceiver = (ImageReceiver) this.AB.Ay.get(c0148a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.AB, c0148a.uri);
                this.AB.Ay.put(c0148a.uri, imageReceiver);
            }
            imageReceiver.m154c(this.AD);
            if (this.AD.AI != 1) {
                this.AB.Ax.put(this.AD, imageReceiver);
            }
            synchronized (ImageManager.Ar) {
                if (!ImageManager.As.contains(c0148a.uri)) {
                    ImageManager.As.add(c0148a.uri);
                    imageReceiver.dN();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.e */
    private static final class C0146e implements ComponentCallbacks2 {
        private final C0534b Aw;

        public C0146e(C0534b c0534b) {
            this.Aw = c0534b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Aw.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Aw.evictAll();
            } else if (level >= 20) {
                this.Aw.trimToSize(this.Aw.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.f */
    private final class C0147f implements Runnable {
        final /* synthetic */ ImageManager AB;
        private boolean AE;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zf;

        public C0147f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.AB = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.AE = z;
            this.zf = countDownLatch;
        }

        private void m157a(ImageReceiver imageReceiver, boolean z) {
            imageReceiver.AA = true;
            ArrayList a = imageReceiver.Az;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0149a c0149a = (C0149a) a.get(i);
                if (z) {
                    c0149a.m176a(this.AB.mContext, this.mBitmap, false);
                } else {
                    c0149a.m179b(this.AB.mContext, false);
                }
                if (c0149a.AI != 1) {
                    this.AB.Ax.remove(c0149a);
                }
            }
            imageReceiver.AA = false;
        }

        public void run() {
            ed.ac("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.AB.Aw != null) {
                if (this.AE) {
                    this.AB.Aw.evictAll();
                    System.gc();
                    this.AE = false;
                    this.AB.mHandler.post(this);
                    return;
                } else if (z) {
                    this.AB.Aw.put(new C0148a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.AB.Ay.remove(this.mUri);
            if (imageReceiver != null) {
                m157a(imageReceiver, z);
            }
            this.zf.countDown();
            synchronized (ImageManager.Ar) {
                ImageManager.As.remove(this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.b */
    private static final class C0534b extends ev<C0148a, Bitmap> {
        public C0534b(Context context) {
            super(C0534b.m1560w(context));
        }

        private static int m1560w(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !fr.eJ()) ? activityManager.getMemoryClass() : C0143a.m156a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected int m1561a(C0148a c0148a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void m1562a(boolean z, C0148a c0148a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0148a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m1562a(x0, (C0148a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m1561a((C0148a) x0, (Bitmap) x1);
        }
    }

    static {
        Ar = new Object();
        As = new HashSet();
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Av = Executors.newFixedThreadPool(4);
        if (withMemoryCache) {
            this.Aw = new C0534b(this.mContext);
            if (fr.eM()) {
                dL();
            }
        } else {
            this.Aw = null;
        }
        this.Ax = new HashMap();
        this.Ay = new HashMap();
    }

    private Bitmap m160a(C0148a c0148a) {
        return this.Aw == null ? null : (Bitmap) this.Aw.get(c0148a);
    }

    public static ImageManager m161a(Context context, boolean z) {
        if (z) {
            if (Au == null) {
                Au = new ImageManager(context, true);
            }
            return Au;
        }
        if (At == null) {
            At = new ImageManager(context, false);
        }
        return At;
    }

    private boolean m164b(C0149a c0149a) {
        ed.ac("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (c0149a.AI == 1) {
            return true;
        }
        ImageReceiver imageReceiver = (ImageReceiver) this.Ax.get(c0149a);
        if (imageReceiver == null) {
            return true;
        }
        if (imageReceiver.AA) {
            return false;
        }
        this.Ax.remove(c0149a);
        imageReceiver.m155d(c0149a);
        return true;
    }

    public static ImageManager create(Context context) {
        return m161a(context, false);
    }

    private void dL() {
        this.mContext.registerComponentCallbacks(new C0146e(this.Aw));
    }

    public void m169a(C0149a c0149a) {
        ed.ac("ImageManager.loadImage() must be called in the main thread");
        boolean b = m164b(c0149a);
        Runnable c0145d = new C0145d(this, c0149a);
        if (b) {
            c0145d.run();
        } else {
            this.mHandler.post(c0145d);
        }
    }

    public void loadImage(ImageView imageView, int resId) {
        C0149a c0149a = new C0149a(resId);
        c0149a.m177a(imageView);
        m169a(c0149a);
    }

    public void loadImage(ImageView imageView, Uri uri) {
        C0149a c0149a = new C0149a(uri);
        c0149a.m177a(imageView);
        m169a(c0149a);
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0149a c0149a = new C0149a(uri);
        c0149a.m175L(defaultResId);
        c0149a.m177a(imageView);
        m169a(c0149a);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        C0149a c0149a = new C0149a(uri);
        c0149a.m178a(listener);
        m169a(c0149a);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0149a c0149a = new C0149a(uri);
        c0149a.m175L(defaultResId);
        c0149a.m178a(listener);
        m169a(c0149a);
    }
}
