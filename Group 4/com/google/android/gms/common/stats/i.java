/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

public class i {
    public static String a(PowerManager.WakeLock wakeLock, String string) {
        StringBuilder stringBuilder = new StringBuilder().append(String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode((Object)wakeLock)));
        if (!TextUtils.isEmpty((CharSequence)string)) return stringBuilder.append(string).toString();
        string = "";
        return stringBuilder.append(string).toString();
    }
}

