/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.b.ar;

final class au
extends ar {
    au() {
    }

    private String a(String string) {
        int n2;
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        int n3 = string.length();
        for (n2 = 0; n2 < string.length() && string.charAt(n2) == ','; ++n2) {
        }
        while (n3 > 0 && string.charAt(n3 - 1) == ',') {
            --n3;
        }
        if (n2 != 0) return string.substring(n2, n3);
        if (n3 == string.length()) return string;
        return string.substring(n2, n3);
    }

    @Override
    public String a(String string, String string2) {
        String string3 = this.a(string);
        String string4 = this.a(string2);
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return string4;
        }
        if (!TextUtils.isEmpty((CharSequence)string4)) return string3 + "," + string4;
        return string3;
    }
}

