package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class aj {
    public static final String DEVICE_ID_EMULATOR;
    private final Date f45d;
    private final Set<String> f46f;
    private final int lA;
    private final Set<String> lB;
    private final String lt;
    private final int lu;
    private final Location lv;
    private final boolean lw;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> lx;
    private final String ly;
    private final SearchAdRequest lz;

    /* renamed from: com.google.android.gms.internal.aj.a */
    public static final class C0212a {
        private Date f44d;
        private int lA;
        private final HashSet<String> lC;
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> lD;
        private final HashSet<String> lE;
        private String lt;
        private int lu;
        private Location lv;
        private boolean lw;
        private String ly;

        public C0212a() {
            this.lC = new HashSet();
            this.lD = new HashMap();
            this.lE = new HashSet();
            this.lu = -1;
            this.lw = false;
            this.lA = -1;
        }

        public void m404a(Location location) {
            this.lv = location;
        }

        public void m405a(NetworkExtras networkExtras) {
            this.lD.put(networkExtras.getClass(), networkExtras);
        }

        public void m406a(Date date) {
            this.f44d = date;
        }

        public void m407d(int i) {
            this.lu = i;
        }

        public void m408d(boolean z) {
            this.lw = z;
        }

        public void m409e(boolean z) {
            this.lA = z ? 1 : 0;
        }

        public void m410g(String str) {
            this.lC.add(str);
        }

        public void m411h(String str) {
            this.lE.add(str);
        }

        public void m412i(String str) {
            this.lt = str;
        }

        public void m413j(String str) {
            this.ly = str;
        }
    }

    static {
        DEVICE_ID_EMULATOR = cz.m558r("emulator");
    }

    public aj(C0212a c0212a) {
        this(c0212a, null);
    }

    public aj(C0212a c0212a, SearchAdRequest searchAdRequest) {
        this.f45d = c0212a.f44d;
        this.lt = c0212a.lt;
        this.lu = c0212a.lu;
        this.f46f = Collections.unmodifiableSet(c0212a.lC);
        this.lv = c0212a.lv;
        this.lw = c0212a.lw;
        this.lx = Collections.unmodifiableMap(c0212a.lD);
        this.ly = c0212a.ly;
        this.lz = searchAdRequest;
        this.lA = c0212a.lA;
        this.lB = Collections.unmodifiableSet(c0212a.lE);
    }

    public SearchAdRequest aj() {
        return this.lz;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> ak() {
        return this.lx;
    }

    public int al() {
        return this.lA;
    }

    public Date getBirthday() {
        return this.f45d;
    }

    public String getContentUrl() {
        return this.lt;
    }

    public int getGender() {
        return this.lu;
    }

    public Set<String> getKeywords() {
        return this.f46f;
    }

    public Location getLocation() {
        return this.lv;
    }

    public boolean getManualImpressionsEnabled() {
        return this.lw;
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.lx.get(networkExtrasClass);
    }

    public String getPublisherProvidedId() {
        return this.ly;
    }

    public boolean isTestDevice(Context context) {
        return this.lB.contains(cz.m557l(context));
    }
}
