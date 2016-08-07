package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.p */
public class C0301p {
    private final C0298n ka;
    private final SecureRandom kt;

    /* renamed from: com.google.android.gms.internal.p.a */
    public class C0300a extends Exception {
        final /* synthetic */ C0301p ku;

        public C0300a(C0301p c0301p) {
            this.ku = c0301p;
        }

        public C0300a(C0301p c0301p, Throwable th) {
            this.ku = c0301p;
            super(th);
        }
    }

    public C0301p(C0298n c0298n, SecureRandom secureRandom) {
        this.ka = c0298n;
        this.kt = secureRandom;
    }

    static void m1084c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m1085c(byte[] bArr, String str) throws C0300a {
        if (bArr.length != 16) {
            throw new C0300a(this);
        }
        try {
            byte[] a = this.ka.m1080a(str, false);
            if (a.length <= 16) {
                throw new C0300a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0300a(this, e);
        } catch (Throwable e2) {
            throw new C0300a(this, e2);
        } catch (Throwable e22) {
            throw new C0300a(this, e22);
        } catch (Throwable e222) {
            throw new C0300a(this, e222);
        } catch (Throwable e2222) {
            throw new C0300a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0300a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0300a(this, e222222);
        }
    }

    public byte[] m1086d(String str) throws C0300a {
        try {
            byte[] a = this.ka.m1080a(str, false);
            if (a.length != 32) {
                throw new C0300a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0301p.m1084c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0300a(this, e);
        }
    }
}
