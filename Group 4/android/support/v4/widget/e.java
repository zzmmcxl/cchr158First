/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.f;
import android.support.v4.widget.g;
import android.support.v4.widget.h;
import android.support.v4.widget.i;
import android.widget.CompoundButton;

public final class e {
    private static final h a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 23) {
            a = new f();
            return;
        }
        if (n2 >= 21) {
            a = new i();
            return;
        }
        a = new g();
    }

    public static Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        a.a(compoundButton, mode);
    }
}

