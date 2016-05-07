/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.b.c;
import android.support.v7.b.l;
import android.support.v7.widget.ar;
import android.support.v7.widget.cs;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.widget.ImageView;

class az {
    private final ImageView a;
    private final ar b;

    az(ImageView imageView, ar ar2) {
        this.a = imageView;
        this.b = ar2;
    }

    void a(int n2) {
        if (n2 == 0) {
            this.a.setImageDrawable(null);
            return;
        }
        Drawable drawable = this.b != null ? this.b.a(this.a.getContext(), n2) : c.a(this.a.getContext(), n2);
        if (drawable != null) {
            cs.a(drawable);
        }
        this.a.setImageDrawable(drawable);
    }

    void a(AttributeSet attributeSet, int n2) {
        gk gk2 = gk.a(this.a.getContext(), attributeSet, l.AppCompatImageView, n2, 0);
        try {
            int n3;
            Drawable drawable;
            Drawable drawable2;
            Drawable drawable3 = gk2.b(l.AppCompatImageView_android_src);
            if (drawable3 != null) {
                this.a.setImageDrawable(drawable3);
            }
            if ((n3 = gk2.g(l.AppCompatImageView_srcCompat, -1)) != -1 && (drawable2 = this.b.a(this.a.getContext(), n3)) != null) {
                this.a.setImageDrawable(drawable2);
            }
            if ((drawable = this.a.getDrawable()) == null) return;
            cs.a(drawable);
            return;
        }
        finally {
            gk2.a();
        }
    }
}

