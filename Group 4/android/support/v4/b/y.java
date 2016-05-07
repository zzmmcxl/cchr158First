/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.support.v4.app.i;

public final class y {
    public static int a(Context context, String string) {
        return y.a(context, string, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int a(Context context, String string, int n2, int n3, String string2) {
        if (context.checkPermission(string, n2, n3) == -1) {
            return -1;
        }
        String string3 = i.a(string);
        if (string3 == null) {
            return 0;
        }
        if (string2 == null) {
            String[] arrstring = context.getPackageManager().getPackagesForUid(n3);
            if (arrstring == null) return -1;
            if (arrstring.length <= 0) return -1;
            string2 = arrstring[0];
        }
        if (i.a(context, string3, string2) == 0) return 0;
        return -2;
    }
}

