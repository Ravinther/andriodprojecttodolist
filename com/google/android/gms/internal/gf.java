package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0883a;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

public final class gf implements Achievements {

    /* renamed from: com.google.android.gms.internal.gf.a */
    private static abstract class C1038a extends C0883a<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.internal.gf.a.1 */
        class C09231 implements LoadAchievementsResult {
            final /* synthetic */ C1038a HL;
            final /* synthetic */ Status vb;

            C09231(C1038a c1038a, Status status) {
                this.HL = c1038a;
                this.vb = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1038a() {
        }

        public /* synthetic */ Result m3072d(Status status) {
            return m3073s(status);
        }

        public LoadAchievementsResult m3073s(Status status) {
            return new C09231(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.b */
    private static abstract class C1039b extends C0883a<UpdateAchievementResult> {
        private final String uS;

        /* renamed from: com.google.android.gms.internal.gf.b.1 */
        class C09241 implements UpdateAchievementResult {
            final /* synthetic */ C1039b HM;
            final /* synthetic */ Status vb;

            C09241(C1039b c1039b, Status status) {
                this.HM = c1039b;
                this.vb = status;
            }

            public String getAchievementId() {
                return this.HM.uS;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        public C1039b(String str) {
            this.uS = str;
        }

        public /* synthetic */ Result m3075d(Status status) {
            return m3076t(status);
        }

        public UpdateAchievementResult m3076t(Status status) {
            return new C09241(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.1 */
    class C11141 extends C1038a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gf HI;

        C11141(gf gfVar, boolean z) {
            this.HI = gfVar;
            this.HH = z;
            super();
        }

        public void m3243a(fx fxVar) {
            fxVar.m2737c((C0135c) this, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.2 */
    class C11152 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11152(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3245a(fx fxVar) {
            fxVar.m2728b(null, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.3 */
    class C11163 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11163(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3247a(fx fxVar) {
            fxVar.m2728b((C0135c) this, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.4 */
    class C11174 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11174(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3249a(fx fxVar) {
            fxVar.m2736c(null, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.5 */
    class C11185 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11185(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3251a(fx fxVar) {
            fxVar.m2736c((C0135c) this, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.6 */
    class C11196 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11196(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3253a(fx fxVar) {
            fxVar.m2709a(null, this.HJ, this.HK);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.7 */
    class C11207 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11207(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3255a(fx fxVar) {
            fxVar.m2709a((C0135c) this, this.HJ, this.HK);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.8 */
    class C11218 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11218(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3257a(fx fxVar) {
            fxVar.m2729b(null, this.HJ, this.HK);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.9 */
    class C11229 extends C1039b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11229(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3259a(fx fxVar) {
            fxVar.m2729b((C0135c) this, this.HJ, this.HK);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fs();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m137b(new C11196(this, id, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m137b(new C11207(this, id, id, numSteps));
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m136a(new C11141(this, forceReload));
    }

    public void reveal(GoogleApiClient apiClient, String id) {
        apiClient.m137b(new C11152(this, id, id));
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m137b(new C11163(this, id, id));
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m137b(new C11218(this, id, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m137b(new C11229(this, id, id, numSteps));
    }

    public void unlock(GoogleApiClient apiClient, String id) {
        apiClient.m137b(new C11174(this, id, id));
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m137b(new C11185(this, id, id));
    }
}
