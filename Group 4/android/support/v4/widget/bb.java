/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.bf;
import android.widget.TextView;

class bb
implements bf {
    bb() {
    }

    @Override
    public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }
}

