/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.bi;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class k {
    private static Field a;
    private static boolean b;

    static Drawable a(CompoundButton compoundButton) {
        if (!b) {
            try {
                a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException var4_2) {
                Log.i((String)"CompoundButtonCompatDonut", (String)"Failed to retrieve mButtonDrawable field", (Throwable)var4_2);
            }
            b = true;
        }
        if (a == null) return null;
        try {
            return (Drawable)a.get((Object)compoundButton);
        }
        catch (IllegalAccessException var1_3) {
            Log.i((String)"CompoundButtonCompatDonut", (String)"Failed to get button drawable via reflection", (Throwable)var1_3);
            a = null;
        }
        return null;
    }

    static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (!(compoundButton instanceof bi)) return;
        ((bi)compoundButton).setSupportButtonTintList(colorStateList);
    }

    static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (!(compoundButton instanceof bi)) return;
        ((bi)compoundButton).setSupportButtonTintMode(mode);
    }
}

