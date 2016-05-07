/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.b.d;
import android.support.v4.b.e;
import android.support.v4.b.f;

public class c {
    public static int a(Context context, String string) {
        if (string != null) return context.checkPermission(string, Process.myPid(), Process.myUid());
        throw new IllegalArgumentException("permission is null");
    }

    public static final Drawable a(Context context, int n2) {
        if (Build.VERSION.SDK_INT < 21) return context.getResources().getDrawable(n2);
        return d.a(context, n2);
    }

    public static boolean a(Context context, Intent[] arrintent, Bundle bundle) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 16) {
            f.a(context, arrintent, bundle);
            return true;
        }
        if (n2 < 11) return false;
        e.a(context, arrintent);
        return true;
    }
}

