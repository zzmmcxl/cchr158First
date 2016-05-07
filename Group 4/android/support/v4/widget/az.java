/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.ba;
import android.support.v4.widget.bb;
import android.support.v4.widget.bc;
import android.support.v4.widget.bd;
import android.support.v4.widget.be;
import android.support.v4.widget.bf;
import android.widget.TextView;

public final class az {
    static final bf a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 23) {
            a = new ba();
            return;
        }
        if (n2 >= 18) {
            a = new bd();
            return;
        }
        if (n2 >= 17) {
            a = new bc();
            return;
        }
        if (n2 >= 16) {
            a = new be();
            return;
        }
        a = new bb();
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        a.a(textView, drawable, drawable2, drawable3, drawable4);
    }
}

