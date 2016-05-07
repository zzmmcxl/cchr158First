/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.c;
import android.support.v4.c.a.k;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class b
implements c {
    b() {
    }

    @Override
    public void a(Drawable drawable) {
    }

    @Override
    public void a(Drawable drawable, float f2, float f3) {
    }

    @Override
    public void a(Drawable drawable, int n2) {
        k.a(drawable, n2);
    }

    @Override
    public void a(Drawable drawable, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void a(Drawable drawable, ColorStateList colorStateList) {
        k.a(drawable, colorStateList);
    }

    @Override
    public void a(Drawable drawable, Resources.Theme theme) {
    }

    @Override
    public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        k.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    @Override
    public void a(Drawable drawable, PorterDuff.Mode mode) {
        k.a(drawable, mode);
    }

    @Override
    public void a(Drawable drawable, boolean bl2) {
    }

    @Override
    public void b(Drawable drawable, int n2) {
    }

    @Override
    public boolean b(Drawable drawable) {
        return false;
    }

    @Override
    public Drawable c(Drawable drawable) {
        return k.a(drawable);
    }

    @Override
    public int d(Drawable drawable) {
        return 0;
    }

    @Override
    public int e(Drawable drawable) {
        return 0;
    }

    @Override
    public boolean f(Drawable drawable) {
        return false;
    }

    @Override
    public ColorFilter g(Drawable drawable) {
        return null;
    }
}

