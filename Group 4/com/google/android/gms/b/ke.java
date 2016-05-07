/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.google.android.gms.b.je;
import com.google.android.gms.common.internal.f;

public class ke {
    public static boolean a() {
        if (!f.a) return false;
        if (!je.b()) return false;
        if (je.a() != Process.myUid()) return false;
        return true;
    }

    public static boolean a(Context context, String string) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int n2 = packageManager.getApplicationInfo((String)string, (int)0).flags;
            int n3 = n2 & 2097152;
            boolean bl2 = false;
            if (n3 == 0) return bl2;
            return true;
        }
        catch (PackageManager.NameNotFoundException var3_6) {
            return false;
        }
    }
}

