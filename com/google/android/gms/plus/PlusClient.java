package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0357i;
import com.google.android.gms.plus.internal.C0979e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C0979e QN;

    @Deprecated
    public static class Builder {
        private final ConnectionCallbacks QS;
        private final OnConnectionFailedListener QT;
        private final C0357i QU;
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.QS = connectionCallbacks;
            this.QT = connectionFailedListener;
            this.QU = new C0357i(this.mContext);
        }

        public PlusClient build() {
            return new PlusClient(new C0979e(this.mContext, this.QS, this.QT, this.QU.hA()));
        }

        public Builder clearScopes() {
            this.QU.hz();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.QU.aS(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.QU.m1207f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.QU.m1206e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.1 */
    class C07471 implements C0135c<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener QO;
        final /* synthetic */ PlusClient QP;

        C07471(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.QP = plusClient;
            this.QO = onMomentsLoadedListener;
        }

        public void m2201a(LoadMomentsResult loadMomentsResult) {
            this.QO.onMomentsLoaded(loadMomentsResult.getStatus().dG(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m2202b(Object obj) {
            m2201a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.2 */
    class C07482 implements C0135c<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener QO;
        final /* synthetic */ PlusClient QP;

        C07482(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.QP = plusClient;
            this.QO = onMomentsLoadedListener;
        }

        public void m2203a(LoadMomentsResult loadMomentsResult) {
            this.QO.onMomentsLoaded(loadMomentsResult.getStatus().dG(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m2204b(Object obj) {
            m2203a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.3 */
    class C07493 implements C0135c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C07493(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2205a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2206b(Object obj) {
            m2205a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.4 */
    class C07504 implements C0135c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C07504(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2207a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2208b(Object obj) {
            m2207a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.5 */
    class C07515 implements C0135c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C07515(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2209a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2210b(Object obj) {
            m2209a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.6 */
    class C07526 implements C0135c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C07526(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2211a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2212b(Object obj) {
            m2211a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.7 */
    class C07537 implements C0135c<Status> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnAccessRevokedListener QR;

        C07537(PlusClient plusClient, OnAccessRevokedListener onAccessRevokedListener) {
            this.QP = plusClient;
            this.QR = onAccessRevokedListener;
        }

        public void m2213K(Status status) {
            this.QR.onAccessRevoked(status.getStatus().dG());
        }

        public /* synthetic */ void m2214b(Object obj) {
            m2213K((Status) obj);
        }
    }

    PlusClient(C0979e plusClientImpl) {
        this.QN = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.QN.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.QN.connect();
    }

    @Deprecated
    public void disconnect() {
        this.QN.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.QN.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.QN.getCurrentPerson();
    }

    C0979e hj() {
        return this.QN;
    }

    @Deprecated
    public boolean isConnected() {
        return this.QN.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.QN.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.QN.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.QN.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener) {
        this.QN.m2872i(new C07471(this, listener));
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.QN.m2867a(new C07482(this, listener), maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.QN.m2869a(new C07515(this, listener), (Collection) personIds);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, String... personIds) {
        this.QN.m2871c(new C07526(this, listener), personIds);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.QN.m2866a(new C07493(this, listener), orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        this.QN.m2873i(new C07504(this, listener), pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.QN.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.QN.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.QN.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        this.QN.m2875k(new C07537(this, listener));
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.QN.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.QN.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.QN.m2868a(null, moment);
    }
}
