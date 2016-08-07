package com.google.tagmanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class ResourceStorageImpl implements ResourceStorage {
    private static final String SAVED_RESOURCE_FILENAME_PREFIX = "resource_";
    private static final String SAVED_RESOURCE_SUB_DIR = "google_tagmanager";
    private LoadCallback<ResourceWithMetadata> mCallback;
    private final String mContainerId;
    private final Context mContext;
    private final ExecutorService mExecutor;

    /* renamed from: com.google.tagmanager.ResourceStorageImpl.1 */
    class C04371 implements Runnable {
        C04371() {
        }

        public void run() {
            ResourceStorageImpl.this.loadResourceFromDisk();
        }
    }

    /* renamed from: com.google.tagmanager.ResourceStorageImpl.2 */
    class C04382 implements Runnable {
        final /* synthetic */ ResourceWithMetadata val$resource;

        C04382(ResourceWithMetadata resourceWithMetadata) {
            this.val$resource = resourceWithMetadata;
        }

        public void run() {
            ResourceStorageImpl.this.saveResourceToDisk(this.val$resource);
        }
    }

    ResourceStorageImpl(Context context, String containerId) {
        this.mContext = context;
        this.mContainerId = containerId;
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    public void setLoadCallback(LoadCallback<ResourceWithMetadata> callback) {
        this.mCallback = callback;
    }

    public void loadResourceFromDiskInBackground() {
        this.mExecutor.execute(new C04371());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.util.VisibleForTesting
    void loadResourceFromDisk() {
        /*
        r4 = this;
        r2 = r4.mCallback;
        if (r2 != 0) goto L_0x000c;
    L_0x0004:
        r2 = new java.lang.IllegalStateException;
        r3 = "callback must be set before execute";
        r2.<init>(r3);
        throw r2;
    L_0x000c:
        r2 = r4.mCallback;
        r2.startLoad();
        r2 = "Start loading resource from disk ...";
        com.google.tagmanager.Log.m1393v(r2);
        r2 = com.google.tagmanager.PreviewManager.getInstance();
        r2 = r2.getPreviewMode();
        r3 = com.google.tagmanager.PreviewManager.PreviewMode.CONTAINER;
        if (r2 == r3) goto L_0x002e;
    L_0x0022:
        r2 = com.google.tagmanager.PreviewManager.getInstance();
        r2 = r2.getPreviewMode();
        r3 = com.google.tagmanager.PreviewManager.PreviewMode.CONTAINER_DEBUG;
        if (r2 != r3) goto L_0x0046;
    L_0x002e:
        r2 = r4.mContainerId;
        r3 = com.google.tagmanager.PreviewManager.getInstance();
        r3 = r3.getContainerId();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0046;
    L_0x003e:
        r2 = r4.mCallback;
        r3 = com.google.tagmanager.LoadCallback.Failure.NOT_AVAILABLE;
        r2.onFailure(r3);
    L_0x0045:
        return;
    L_0x0046:
        r1 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0066 }
        r2 = r4.getResourceFile();	 Catch:{ FileNotFoundException -> 0x0066 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0066 }
        r2 = r4.mCallback;	 Catch:{ IOException -> 0x007b }
        r3 = com.google.tagmanager.ProtoExtensionRegistry.getRegistry();	 Catch:{ IOException -> 0x007b }
        r3 = com.google.tagmanager.proto.Resource.ResourceWithMetadata.parseFrom(r1, r3);	 Catch:{ IOException -> 0x007b }
        r2.onSuccess(r3);	 Catch:{ IOException -> 0x007b }
        r1.close();	 Catch:{ IOException -> 0x0074 }
    L_0x0060:
        r2 = "Load resource from disk finished.";
        com.google.tagmanager.Log.m1393v(r2);
        goto L_0x0045;
    L_0x0066:
        r0 = move-exception;
        r2 = "resource not on disk";
        com.google.tagmanager.Log.m1387d(r2);
        r2 = r4.mCallback;
        r3 = com.google.tagmanager.LoadCallback.Failure.NOT_AVAILABLE;
        r2.onFailure(r3);
        goto L_0x0045;
    L_0x0074:
        r0 = move-exception;
        r2 = "error closing stream for reading resource from disk";
        com.google.tagmanager.Log.m1395w(r2);
        goto L_0x0060;
    L_0x007b:
        r0 = move-exception;
        r2 = "error reading resource from disk";
        com.google.tagmanager.Log.m1395w(r2);	 Catch:{ all -> 0x0093 }
        r2 = r4.mCallback;	 Catch:{ all -> 0x0093 }
        r3 = com.google.tagmanager.LoadCallback.Failure.IO_ERROR;	 Catch:{ all -> 0x0093 }
        r2.onFailure(r3);	 Catch:{ all -> 0x0093 }
        r1.close();	 Catch:{ IOException -> 0x008c }
        goto L_0x0060;
    L_0x008c:
        r0 = move-exception;
        r2 = "error closing stream for reading resource from disk";
        com.google.tagmanager.Log.m1395w(r2);
        goto L_0x0060;
    L_0x0093:
        r2 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0098 }
    L_0x0097:
        throw r2;
    L_0x0098:
        r0 = move-exception;
        r3 = "error closing stream for reading resource from disk";
        com.google.tagmanager.Log.m1395w(r3);
        goto L_0x0097;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.ResourceStorageImpl.loadResourceFromDisk():void");
    }

    public void saveResourceToDiskInBackground(ResourceWithMetadata resource) {
        this.mExecutor.execute(new C04382(resource));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.analytics.containertag.proto.Serving.Resource loadResourceFromContainerAsset(java.lang.String r8) {
        /*
        r7 = this;
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Loading default container from ";
        r5 = r5.append(r6);
        r5 = r5.append(r8);
        r5 = r5.toString();
        com.google.tagmanager.Log.m1393v(r5);
        r5 = r7.mContext;
        r0 = r5.getAssets();
        if (r0 != 0) goto L_0x0026;
    L_0x001f:
        r5 = "No assets found in package";
        com.google.tagmanager.Log.m1389e(r5);
        r3 = r4;
    L_0x0025:
        return r3;
    L_0x0026:
        r2 = 0;
        r2 = r0.open(r8);	 Catch:{ IOException -> 0x004f }
        r5 = com.google.tagmanager.ProtoExtensionRegistry.getRegistry();	 Catch:{ IOException -> 0x006e }
        r3 = com.google.analytics.containertag.proto.Serving.Resource.parseFrom(r2, r5);	 Catch:{ IOException -> 0x006e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006e }
        r5.<init>();	 Catch:{ IOException -> 0x006e }
        r6 = "Parsed default container: ";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x006e }
        r5 = r5.append(r3);	 Catch:{ IOException -> 0x006e }
        r5 = r5.toString();	 Catch:{ IOException -> 0x006e }
        com.google.tagmanager.Log.m1393v(r5);	 Catch:{ IOException -> 0x006e }
        r2.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0025;
    L_0x004d:
        r4 = move-exception;
        goto L_0x0025;
    L_0x004f:
        r1 = move-exception;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "No asset file: ";
        r5 = r5.append(r6);
        r5 = r5.append(r8);
        r6 = " found.";
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.google.tagmanager.Log.m1395w(r5);
        r3 = r4;
        goto L_0x0025;
    L_0x006e:
        r1 = move-exception;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r5.<init>();	 Catch:{ all -> 0x008a }
        r6 = "Error when parsing: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x008a }
        r5 = r5.append(r8);	 Catch:{ all -> 0x008a }
        r5 = r5.toString();	 Catch:{ all -> 0x008a }
        com.google.tagmanager.Log.m1395w(r5);	 Catch:{ all -> 0x008a }
        r2.close();	 Catch:{ IOException -> 0x008f }
    L_0x0088:
        r3 = r4;
        goto L_0x0025;
    L_0x008a:
        r4 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0091 }
    L_0x008e:
        throw r4;
    L_0x008f:
        r5 = move-exception;
        goto L_0x0088;
    L_0x0091:
        r5 = move-exception;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.ResourceStorageImpl.loadResourceFromContainerAsset(java.lang.String):com.google.analytics.containertag.proto.Serving$Resource");
    }

    public ExpandedResource loadExpandedResourceFromJsonAsset(String assetFile) {
        ExpandedResource expandedResource = null;
        Log.m1393v("loading default container from " + assetFile);
        AssetManager assets = this.mContext.getAssets();
        if (assets == null) {
            Log.m1395w("Looking for default JSON container in package, but no assets were found.");
        } else {
            InputStream is = null;
            try {
                is = assets.open(assetFile);
                expandedResource = JsonUtils.expandedResourceFromJsonString(stringFromInputStream(is));
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                Log.m1395w("No asset file: " + assetFile + " found (or errors reading it).");
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (JSONException e4) {
                Log.m1395w("Error parsing JSON file" + assetFile + " : " + e4);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e6) {
                    }
                }
            }
        }
        return expandedResource;
    }

    public synchronized void close() {
        this.mExecutor.shutdown();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.util.VisibleForTesting
    boolean saveResourceToDisk(com.google.tagmanager.proto.Resource.ResourceWithMetadata r7) {
        /*
        r6 = this;
        r4 = 0;
        r2 = 0;
        r1 = r6.getResourceFile();
        r3 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0014 }
        r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0014 }
        r7.writeTo(r3);	 Catch:{ IOException -> 0x0022 }
        r4 = 1;
        r3.close();	 Catch:{ IOException -> 0x001b }
    L_0x0012:
        r2 = r3;
    L_0x0013:
        return r4;
    L_0x0014:
        r0 = move-exception;
        r5 = "Error opening resource file for writing";
        com.google.tagmanager.Log.m1389e(r5);
        goto L_0x0013;
    L_0x001b:
        r0 = move-exception;
        r5 = "error closing stream for writing resource to disk";
        com.google.tagmanager.Log.m1395w(r5);
        goto L_0x0012;
    L_0x0022:
        r0 = move-exception;
        r5 = "Error writing resource to disk. Removing resource from disk.";
        com.google.tagmanager.Log.m1395w(r5);	 Catch:{ all -> 0x0037 }
        r1.delete();	 Catch:{ all -> 0x0037 }
        r3.close();	 Catch:{ IOException -> 0x0030 }
    L_0x002e:
        r2 = r3;
        goto L_0x0013;
    L_0x0030:
        r0 = move-exception;
        r5 = "error closing stream for writing resource to disk";
        com.google.tagmanager.Log.m1395w(r5);
        goto L_0x002e;
    L_0x0037:
        r4 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x003c }
    L_0x003b:
        throw r4;
    L_0x003c:
        r0 = move-exception;
        r5 = "error closing stream for writing resource to disk";
        com.google.tagmanager.Log.m1395w(r5);
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.ResourceStorageImpl.saveResourceToDisk(com.google.tagmanager.proto.Resource$ResourceWithMetadata):boolean");
    }

    @VisibleForTesting
    File getResourceFile() {
        return new File(this.mContext.getDir(SAVED_RESOURCE_SUB_DIR, 0), SAVED_RESOURCE_FILENAME_PREFIX + this.mContainerId);
    }

    private String stringFromInputStream(InputStream is) throws IOException {
        Writer writer = new StringWriter();
        char[] buffer = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        while (true) {
            int n = reader.read(buffer);
            if (n == -1) {
                return writer.toString();
            }
            writer.write(buffer, 0, n);
        }
    }
}
