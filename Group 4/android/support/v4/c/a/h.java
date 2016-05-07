/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.g;
import android.support.v4.c.a.p;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class h
extends g {
    h() {
    }

    @Override
    public void a(Drawable drawable, float f2, float f3) {
        p.a(drawable, f2, f3);
    }

    @Override
    public void a(Drawable drawable, int n2) {
        p.a(drawable, n2);
    }

    @Override
    public void a(Drawable drawable, int n2, int n3, int n4, int n5) {
        p.a(drawable, n2, n3, n4, n5);
    }

    @Override
    public void a(Drawable drawable, ColorStateList colorStateList) {
        p.a(drawable, colorStateList);
    }

    @Override
    public void a(Drawable drawable, Resources.Theme theme) {
        p.a(drawable, theme);
    }

    @Override
    public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        p.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    @Override
    public void a(Drawable drawable, PorterDuff.Mode mode) {
        p.a(drawable, mode);
    }

    @Override
    public Drawable c(Drawable drawable) {
        return p.a(drawable);
    }

    @Override
    public boolean f(Drawable drawable) {
        return p.b(drawable);
    }

    @Override
    public ColorFilter g(Drawable drawable) {
        return p.c(drawable);
    }
}

