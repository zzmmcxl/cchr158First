/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

interface c {
    public void a(Drawable var1);

    public void a(Drawable var1, float var2, float var3);

    public void a(Drawable var1, int var2);

    public void a(Drawable var1, int var2, int var3, int var4, int var5);

    public void a(Drawable var1, ColorStateList var2);

    public void a(Drawable var1, Resources.Theme var2);

    public void a(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Resources.Theme var5);

    public void a(Drawable var1, PorterDuff.Mode var2);

    public void a(Drawable var1, boolean var2);

    public void b(Drawable var1, int var2);

    public boolean b(Drawable var1);

    public Drawable c(Drawable var1);

    public int d(Drawable var1);

    public int e(Drawable var1);

    public boolean f(Drawable var1);

    public ColorFilter g(Drawable var1);
}

