/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.f;

import android.support.v4.f.a;
import android.support.v4.f.h;
import android.support.v4.f.i;
import java.util.Locale;

class j {
    private j() {
    }

    /* synthetic */ j(i i2) {
        this();
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            default: {
                return 0;
            }
            case 1: 
            case 2: 
        }
        return 1;
    }

    public int a(Locale locale) {
        if (locale == null) return 0;
        if (locale.equals(h.a)) return 0;
        String string = a.a(locale);
        if (string == null) {
            return j.b(locale);
        }
        if (string.equalsIgnoreCase(h.a())) return 1;
        if (!string.equalsIgnoreCase(h.b())) return 0;
        return 1;
    }
}

