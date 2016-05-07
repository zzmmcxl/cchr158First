/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.c.a.q;
import android.support.v7.widget.ar;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class be {
    private static final int[] b = new int[]{16843067, 16843068};
    final ar a;
    private final ProgressBar c;
    private Bitmap d;

    be(ProgressBar progressBar, ar ar2) {
        this.c = progressBar;
        this.a = ar2;
    }

    private Drawable a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) return drawable;
        AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
        int n2 = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        int n3 = 0;
        do {
            if (n3 >= n2) {
                animationDrawable2.setLevel(10000);
                return animationDrawable2;
            }
            Drawable drawable2 = this.a(animationDrawable.getFrame(n3), true);
            drawable2.setLevel(10000);
            animationDrawable2.addFrame(drawable2, animationDrawable.getDuration(n3));
            ++n3;
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    private Drawable a(Drawable var1_1, boolean var2_2) {
        var3_3 = 0;
        if (var1_1 instanceof q) ** GOTO lbl19
        if (var1_1 instanceof LayerDrawable) {
            var11_7 = (LayerDrawable)var1_1;
            var12_8 = var11_7.getNumberOfLayers();
            var13_9 = new Drawable[var12_8];
        } else {
            if (var1_1 instanceof BitmapDrawable == false) return var1_1;
            var4_14 = (BitmapDrawable)var1_1;
            var5_15 = var4_14.getBitmap();
            if (this.d == null) {
                this.d = var5_15;
            }
            var6_16 = new ShapeDrawable(this.b());
            var7_17 = new BitmapShader(var5_15, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            var6_16.getPaint().setShader((Shader)var7_17);
            var6_16.getPaint().setColorFilter(var4_14.getPaint().getColorFilter());
            if (var2_2 == false) return var6_16;
            return new ClipDrawable((Drawable)var6_16, 3, 1);
lbl19: // 1 sources:
            var18_4 = ((q)var1_1).a();
            if (var18_4 == null) return var1_1;
            var19_5 = this.a(var18_4, var2_2);
            ((q)var1_1).a(var19_5);
            return var1_1;
        }
        for (var14_10 = 0; var14_10 < var12_8; ++var14_10) {
            var15_13 = var11_7.getId(var14_10);
            var16_11 = var11_7.getDrawable(var14_10);
            var17_12 = var15_13 == 16908301 || var15_13 == 16908303;
            var13_9[var14_10] = this.a(var16_11, var17_12);
        }
        var10_6 = new LayerDrawable(var13_9);
        while (var3_3 < var12_8) {
            var10_6.setId(var3_3, var11_7.getId(var3_3));
            ++var3_3;
        }
        return var10_6;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap a() {
        return this.d;
    }

    void a(AttributeSet attributeSet, int n2) {
        Drawable drawable;
        gk gk2 = gk.a(this.c.getContext(), attributeSet, b, n2, 0);
        Drawable drawable2 = gk2.b(0);
        if (drawable2 != null) {
            this.c.setIndeterminateDrawable(this.a(drawable2));
        }
        if ((drawable = gk2.b(1)) != null) {
            this.c.setProgressDrawable(this.a(drawable, false));
        }
        gk2.a();
    }
}

