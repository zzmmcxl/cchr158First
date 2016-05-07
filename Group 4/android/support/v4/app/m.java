/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

class m {
    public static int a(Context context, String string, String string2) {
        return ((AppOpsManager)context.getSystemService((Class)AppOpsManager.class)).noteProxyOp(string, string2);
    }

    public static String a(String string) {
        return AppOpsManager.permissionToOp((String)string);
    }
}

