/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.support.v7.f.a;
import android.support.v7.widget.ar;
import android.support.v7.widget.br;
import android.support.v7.widget.gi;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class bq {
    private static final int[] b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] c;
    final TextView a;
    private gi d;
    private gi e;
    private gi f;
    private gi g;

    static {
        int[] arrn = new int[]{b.textAllCaps};
        c = arrn;
    }

    bq(TextView textView) {
        this.a = textView;
    }

    static bq a(TextView textView) {
        if (Build.VERSION.SDK_INT < 17) return new bq(textView);
        return new br(textView);
    }

    protected static gi a(Context context, ar ar2, int n2) {
        ColorStateList colorStateList = ar2.b(context, n2);
        if (colorStateList == null) return null;
        gi gi2 = new gi();
        gi2.d = true;
        gi2.a = colorStateList;
        return gi2;
    }

    void a() {
        if (this.d == null && this.e == null && this.f == null) {
            if (this.g == null) return;
        }
        Drawable[] arrdrawable = this.a.getCompoundDrawables();
        this.a(arrdrawable[0], this.d);
        this.a(arrdrawable[1], this.e);
        this.a(arrdrawable[2], this.f);
        this.a(arrdrawable[3], this.g);
    }

    void a(Context context, int n2) {
        TypedArray typedArray = context.obtainStyledAttributes(n2, c);
        if (typedArray.getBoolean(0, false)) {
            this.a(true);
        }
        typedArray.recycle();
    }

    final void a(Drawable drawable, gi gi2) {
        if (drawable == null) return;
        if (gi2 == null) return;
        ar.a(drawable, gi2, this.a.getDrawableState());
    }

    void a(AttributeSet attributeSet, int n2) {
        TypedArray typedArray;
        boolean bl2;
        Context context = this.a.getContext();
        ar ar2 = ar.a();
        TypedArray typedArray2 = context.obtainStyledAttributes(attributeSet, b, n2, 0);
        int n3 = typedArray2.getResourceId(0, -1);
        if (typedArray2.hasValue(1)) {
            this.d = bq.a(context, ar2, typedArray2.getResourceId(1, 0));
        }
        if (typedArray2.hasValue(2)) {
            this.e = bq.a(context, ar2, typedArray2.getResourceId(2, 0));
        }
        if (typedArray2.hasValue(3)) {
            this.f = bq.a(context, ar2, typedArray2.getResourceId(3, 0));
        }
        if (typedArray2.hasValue(4)) {
            this.g = bq.a(context, ar2, typedArray2.getResourceId(4, 0));
        }
        typedArray2.recycle();
        if (this.a.getTransformationMethod() instanceof PasswordTransformationMethod) return;
        if (n3 != -1) {
            TypedArray typedArray3 = context.obtainStyledAttributes(n3, l.TextAppearance);
            bl2 = typedArray3.hasValue(l.TextAppearance_textAllCaps) ? typedArray3.getBoolean(l.TextAppearance_textAllCaps, false) : false;
            typedArray3.recycle();
        } else {
            bl2 = false;
        }
        if ((typedArray = context.obtainStyledAttributes(attributeSet, c, n2, 0)).hasValue(0)) {
            bl2 = typedArray.getBoolean(0, false);
        }
        typedArray.recycle();
        if (!bl2) return;
        this.a(true);
    }

    void a(boolean bl2) {
        TextView textView = this.a;
        a a2 = bl2 ? new a(this.a.getContext()) : null;
        textView.setTransformationMethod((TransformationMethod)a2);
    }
}

