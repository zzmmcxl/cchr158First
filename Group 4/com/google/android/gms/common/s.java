/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.l;
import com.google.android.gms.common.m;
import com.google.android.gms.common.o;
import com.google.android.gms.common.r;

public class s {
    private static final s a = new s();

    private s() {
    }

    public static s a() {
        return a;
    }

    /* varargs */ l a(PackageInfo packageInfo, l ... arrl) {
        if (packageInfo.signatures.length != 1) {
            Log.w((String)"GoogleSignatureVerifier", (String)"Package has more than one signature.");
            return null;
        }
        m m2 = new m(packageInfo.signatures[0].toByteArray());
        int n2 = 0;
        do {
            if (n2 >= arrl.length) {
                if (!Log.isLoggable((String)"GoogleSignatureVerifier", (int)2)) return null;
                Log.v((String)"GoogleSignatureVerifier", (String)("Signature not valid.  Found: \n" + Base64.encodeToString((byte[])m2.a(), (int)0)));
                return null;
            }
            if (arrl[n2].equals(m2)) {
                return arrl[n2];
            }
            ++n2;
        } while (true);
    }

    public boolean a(PackageInfo packageInfo, boolean bl2) {
        l l2;
        if (packageInfo == null) return false;
        if (packageInfo.signatures == null) return false;
        if (bl2) {
            l2 = this.a(packageInfo, o.a);
        } else {
            l[] arrl = new l[]{o.a[0]};
            l2 = this.a(packageInfo, arrl);
        }
        if (l2 == null) return false;
        return true;
    }

    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean bl2 = false;
        if (packageInfo == null) {
            return bl2;
        }
        if (r.b(packageManager)) {
            return this.a(packageInfo, true);
        }
        bl2 = this.a(packageInfo, false);
        if (bl2) return bl2;
        if (!this.a(packageInfo, true)) return bl2;
        Log.w((String)"GoogleSignatureVerifier", (String)"Test-keys aren't accepted on this build.");
        return bl2;
    }
}

