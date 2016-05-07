/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.common.internal.g;
import java.util.regex.Pattern;

public class kp {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String string) {
        if (string == null) return true;
        if (!g.a.b(string)) return false;
        return true;
    }
}

