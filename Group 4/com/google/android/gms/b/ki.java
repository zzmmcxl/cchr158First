/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.google.android.gms.b.kn;

public final class ki {
    @TargetApi(value=20)
    public static boolean a(Context context) {
        if (!kn.g()) return false;
        if (!context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) return false;
        return true;
    }

    public static boolean a(Resources resources) {
        if (resources == null) {
            return false;
        }
        boolean bl2 = (15 & resources.getConfiguration().screenLayout) > 3;
        if (kn.a()) {
            if (bl2) return true;
        }
        if (!ki.b(resources)) return false;
        return true;
    }

    @TargetApi(value=13)
    private static boolean b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        boolean bl2 = kn.b();
        boolean bl3 = false;
        if (!bl2) return bl3;
        int n2 = 15 & configuration.screenLayout;
        bl3 = false;
        if (n2 > 3) return bl3;
        int n3 = configuration.smallestScreenWidthDp;
        bl3 = false;
        if (n3 < 600) return bl3;
        return true;
    }
}

