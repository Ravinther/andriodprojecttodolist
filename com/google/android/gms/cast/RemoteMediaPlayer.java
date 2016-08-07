package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C0857a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final Object mg;
    private final dv xg;
    private final C0524a xh;
    private OnMetadataUpdatedListener xi;
    private OnStatusUpdatedListener xj;

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a */
    private class C0524a implements dw {
        final /* synthetic */ RemoteMediaPlayer xk;
        private GoogleApiClient xu;
        private long xv;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a.a */
        private final class C0523a implements ResultCallback<Status> {
            private final long xw;
            final /* synthetic */ C0524a xx;

            C0523a(C0524a c0524a, long j) {
                this.xx = c0524a;
                this.xw = j;
            }

            public void m1515i(Status status) {
                if (!status.isSuccess()) {
                    this.xx.xk.xg.m1771a(this.xw, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m1515i((Status) x0);
            }
        }

        public C0524a(RemoteMediaPlayer remoteMediaPlayer) {
            this.xk = remoteMediaPlayer;
            this.xv = 0;
        }

        public void m1516a(String str, String str2, long j, String str3) throws IOException {
            if (this.xu == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.xu, str, str2).setResultCallback(new C0523a(this, j));
        }

        public void m1517b(GoogleApiClient googleApiClient) {
            this.xu = googleApiClient;
        }

        public long cV() {
            long j = this.xv + 1;
            this.xv = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C08591 extends dv {
        final /* synthetic */ RemoteMediaPlayer xk;

        C08591(RemoteMediaPlayer remoteMediaPlayer) {
            this.xk = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.xk.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.xk.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.c */
    private static final class C0861c implements MediaChannelResult {
        private final Status vl;
        private final JSONObject wP;

        C0861c(Status status, JSONObject jSONObject) {
            this.vl = status;
            this.wP = jSONObject;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b */
    private static abstract class C0993b extends C0857a<MediaChannelResult> {
        dx xy;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.1 */
        class C05251 implements dx {
            final /* synthetic */ C0993b xz;

            C05251(C0993b c0993b) {
                this.xz = c0993b;
            }

            public void m1518a(long j, int i, JSONObject jSONObject) {
                this.xz.m1527a(new C0861c(new Status(i), jSONObject));
            }

            public void m1519k(long j) {
                this.xz.m1527a(this.xz.m2932j(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.2 */
        class C08602 implements MediaChannelResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C0993b xz;

            C08602(C0993b c0993b, Status status) {
                this.xz = c0993b;
                this.vb = status;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        C0993b() {
            this.xy = new C05251(this);
        }

        public /* synthetic */ Result m2931d(Status status) {
            return m2932j(status);
        }

        public MediaChannelResult m2932j(Status status) {
            return new C08602(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C10902 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ MediaInfo xm;
        final /* synthetic */ boolean xn;
        final /* synthetic */ long xo;
        final /* synthetic */ JSONObject xp;

        C10902(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xm = mediaInfo;
            this.xn = z;
            this.xo = j;
            this.xp = jSONObject;
        }

        protected void m3185a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1768a(this.xy, this.xm, this.xn, this.xo, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IOException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C10913 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;

        C10913(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xp = jSONObject;
        }

        protected void m3187a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1769a(this.xy, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IOException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C10924 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;

        C10924(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xp = jSONObject;
        }

        protected void m3189a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1772b(this.xy, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IOException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C10935 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;

        C10935(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xp = jSONObject;
        }

        protected void m3191a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1773c(this.xy, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IOException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C10946 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;
        final /* synthetic */ long xq;
        final /* synthetic */ int xr;

        C10946(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xq = j;
            this.xr = i;
            this.xp = jSONObject;
        }

        protected void m3193a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1767a(this.xy, this.xq, this.xr, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IOException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C10957 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;
        final /* synthetic */ double xs;

        C10957(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xs = d;
            this.xp = jSONObject;
        }

        protected void m3195a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1766a(this.xy, this.xs, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IllegalStateException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (IllegalArgumentException e2) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (IOException e3) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C10968 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;
        final /* synthetic */ boolean xt;

        C10968(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xt = z;
            this.xp = jSONObject;
        }

        protected void m3197a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1770a(this.xy, this.xt, this.xp);
                    this.xk.xh.m1517b(null);
                } catch (IllegalStateException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (IOException e2) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C10979 extends C0993b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;

        C10979(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
        }

        protected void m3199a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1517b(this.xl);
                try {
                    this.xk.xg.m1765a(this.xy);
                    this.xk.xh.m1517b(null);
                } catch (IOException e) {
                    m1527a(m2932j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1517b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1517b(null);
                }
            }
        }
    }

    public RemoteMediaPlayer() {
        this.mg = new Object();
        this.xh = new C0524a(this);
        this.xg = new C08591(this);
        this.xg.m609a(this.xh);
    }

    private void onMetadataUpdated() {
        if (this.xi != null) {
            this.xi.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.xj != null) {
            this.xj.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.mg) {
            approximateStreamPosition = this.xg.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.mg) {
            mediaInfo = this.xg.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.mg) {
            mediaStatus = this.xg.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.xg.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.mg) {
            streamDuration = this.xg.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return apiClient.m137b(new C10902(this, apiClient, mediaInfo, autoplay, playPosition, customData));
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.xg.m1764P(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m137b(new C10913(this, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m137b(new C10935(this, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient apiClient) {
        return apiClient.m137b(new C10979(this, apiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        return apiClient.m137b(new C10946(this, apiClient, position, resumeState, customData));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.xi = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.xj = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        return apiClient.m137b(new C10968(this, apiClient, muteState, customData));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.m137b(new C10957(this, apiClient, volume, customData));
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m137b(new C10924(this, apiClient, customData));
    }
}
