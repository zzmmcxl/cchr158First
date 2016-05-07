/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class bg {
    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean bl2 = textView.getLayoutDirection() == 1;
        Drawable drawable5 = bl2 ? drawable3 : drawable;
        if (!bl2) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }
}

