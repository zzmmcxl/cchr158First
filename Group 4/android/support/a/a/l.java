/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.a.a.a;
import android.support.a.a.j;
import android.support.a.a.k;
import android.support.a.a.m;
import android.support.a.a.n;
import android.support.a.a.o;
import android.support.a.a.p;
import android.support.a.a.r;
import android.support.a.a.s;
import android.support.a.a.t;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(value=21)
public class l
extends k {
    static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    private s c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g = true;
    private Drawable.ConstantState h;
    private final float[] i = new float[9];
    private final Matrix j = new Matrix();
    private final Rect k = new Rect();

    private l() {
        this.c = new s();
    }

    /* synthetic */ l(m m2) {
        this();
    }

    private l(s s2) {
        this.c = s2;
        this.d = this.a(this.d, s2.c, s2.d);
    }

    /* synthetic */ l(s s2, m m2) {
        this(s2);
    }

    static /* synthetic */ int a(int n2, float f2) {
        return l.b(n2, f2);
    }

    private static PorterDuff.Mode a(int n2, PorterDuff.Mode mode) {
        switch (n2) {
            default: {
                return mode;
            }
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 16: 
        }
        return PorterDuff.Mode.ADD;
    }

    public static l a(Resources resources, int n2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            l l2 = new l();
            l2.a = android.support.v4.b.a.a.a(resources, n2, theme);
            l2.h = new t(l2.a.getConstantState());
            return l2;
        }
        try {
            int n3;
            XmlResourceParser xmlResourceParser = resources.getXml(n2);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
            }
            if (n3 == 2) return l.a(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme);
            throw new XmlPullParserException("No start tag found");
        }
        catch (XmlPullParserException var6_7) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)var6_7);
            return null;
        }
        catch (IOException var4_9) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)var4_9);
            return null;
        }
    }

    public static l a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        l l2 = new l();
        l2.inflate(resources, xmlPullParser, attributeSet, theme);
        return l2;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        s s2 = this.c;
        r r2 = s2.b;
        s2.d = l.a(j.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            s2.c = colorStateList;
        }
        s2.e = j.a(typedArray, xmlPullParser, "autoMirrored", 5, s2.e);
        r2.c = j.a(typedArray, xmlPullParser, "viewportWidth", 7, r2.c);
        r2.d = j.a(typedArray, xmlPullParser, "viewportHeight", 8, r2.d);
        if (r2.c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (r2.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        r2.a = typedArray.getDimension(3, r2.a);
        r2.b = typedArray.getDimension(2, r2.b);
        if (r2.a <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (r2.b <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        r2.a(j.a(typedArray, xmlPullParser, "alpha", 4, r2.b()));
        String string = typedArray.getString(0);
        if (string == null) return;
        r2.f = string;
        r2.g.put(string, r2);
    }

    private boolean a() {
        return false;
    }

    private static int b(int n2, float f2) {
        int n3 = Color.alpha((int)n2);
        return 16777215 & n2 | (int)(f2 * (float)n3) << 24;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        s s2 = this.c;
        r r2 = s2.b;
        Stack<p> stack = new Stack<p>();
        stack.push(r.a(r2));
        int n2 = xmlPullParser.getEventType();
        boolean bl2 = true;
        while (n2 != 1) {
            if (n2 == 2) {
                boolean bl3;
                String string = xmlPullParser.getName();
                p p2 = (p)stack.peek();
                if ("path".equals(string)) {
                    o o2 = new o();
                    o2.a(resources, attributeSet, theme, xmlPullParser);
                    p2.a.add(o2);
                    if (o2.b() != null) {
                        r2.g.put(o2.b(), o2);
                    }
                    bl3 = false;
                    s2.a |= o2.o;
                } else if ("clip-path".equals(string)) {
                    n n3 = new n();
                    n3.a(resources, attributeSet, theme, xmlPullParser);
                    p2.a.add(n3);
                    if (n3.b() != null) {
                        r2.g.put(n3.b(), n3);
                    }
                    s2.a |= n3.o;
                    bl3 = bl2;
                } else {
                    if ("group".equals(string)) {
                        p p3 = new p();
                        p3.a(resources, attributeSet, theme, xmlPullParser);
                        p2.a.add(p3);
                        stack.push(p3);
                        if (p3.a() != null) {
                            r2.g.put(p3.a(), p3);
                        }
                        s2.a |= p.a(p3);
                    }
                    bl3 = bl2;
                }
                bl2 = bl3;
            } else if (n2 == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            n2 = xmlPullParser.next();
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (stringBuffer.length() > 0) {
            stringBuffer.append(" or ");
        }
        stringBuffer.append("path");
        throw new XmlPullParserException("no " + stringBuffer + " defined");
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null) return null;
        if (mode != null) return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        return null;
    }

    Object a(String string) {
        return this.c.b.g.get(string);
    }

    void a(boolean bl2) {
        this.g = bl2;
    }

    public boolean canApplyTheme() {
        if (this.a == null) return false;
        android.support.v4.c.a.a.d(this.a);
        return false;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.copyBounds(this.k);
        if (this.k.width() <= 0) return;
        if (this.k.height() <= 0) return;
        PorterDuffColorFilter porterDuffColorFilter = this.e == null ? this.d : this.e;
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float f2 = Math.abs(this.i[0]);
        float f3 = Math.abs(this.i[4]);
        float f4 = Math.abs(this.i[1]);
        float f5 = Math.abs(this.i[3]);
        if (f4 != 0.0f || f5 != 0.0f) {
            f3 = 1.0f;
            f2 = 1.0f;
        }
        int n2 = (int)(f2 * (float)this.k.width());
        int n3 = (int)(f3 * (float)this.k.height());
        int n4 = Math.min(2048, n2);
        int n5 = Math.min(2048, n3);
        if (n4 <= 0) return;
        if (n5 <= 0) return;
        int n6 = canvas.save();
        canvas.translate((float)this.k.left, (float)this.k.top);
        if (this.a()) {
            canvas.translate((float)this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.c.b(n4, n5);
        if (!this.g) {
            this.c.a(n4, n5);
        } else if (!this.c.b()) {
            this.c.a(n4, n5);
            this.c.c();
        }
        this.c.a(canvas, (ColorFilter)porterDuffColorFilter, this.k);
        canvas.restoreToCount(n6);
    }

    public int getAlpha() {
        if (this.a == null) return this.c.b.a();
        return android.support.v4.c.a.a.c(this.a);
    }

    public int getChangingConfigurations() {
        if (this.a == null) return super.getChangingConfigurations() | this.c.getChangingConfigurations();
        return this.a.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            return new t(this.a.getConstantState());
        }
        this.c.a = this.getChangingConfigurations();
        return this.c;
    }

    public int getIntrinsicHeight() {
        if (this.a == null) return (int)this.c.b.b;
        return this.a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.a == null) return (int)this.c.b.a;
        return this.a.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.a == null) return -3;
        return this.a.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        s s2 = this.c;
        s2.b = new r();
        TypedArray typedArray = l.b(resources, theme, attributeSet, a.a);
        this.a(typedArray, xmlPullParser);
        typedArray.recycle();
        s2.a = this.getChangingConfigurations();
        s2.k = true;
        this.b(resources, xmlPullParser, attributeSet, theme);
        this.d = this.a(this.d, s2.c, s2.d);
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        if (super.isStateful()) return true;
        if (this.c == null) return false;
        if (this.c.c == null) return false;
        if (!this.c.c.isStateful()) return false;
        return true;
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        if (this.f) return this;
        if (super.mutate() != this) return this;
        this.c = new s(this.c);
        this.f = true;
        return this;
    }

    protected boolean onStateChange(int[] arrn) {
        if (this.a != null) {
            return this.a.setState(arrn);
        }
        s s2 = this.c;
        if (s2.c == null) return false;
        if (s2.d == null) return false;
        this.d = this.a(this.d, s2.c, s2.d);
        this.invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long l2) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, l2);
            return;
        }
        super.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        if (this.a != null) {
            this.a.setAlpha(n2);
            return;
        }
        if (this.c.b.a() == n2) return;
        this.c.b.a(n2);
        this.invalidateSelf();
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        if (this.a != null) {
            this.a.setBounds(n2, n3, n4, n5);
            return;
        }
        super.setBounds(n2, n3, n4, n5);
    }

    public void setBounds(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
            return;
        }
        super.setBounds(rect);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        this.invalidateSelf();
    }

    public void setTint(int n2) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, n2);
            return;
        }
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, colorStateList);
            return;
        }
        s s2 = this.c;
        if (s2.c == colorStateList) return;
        s2.c = colorStateList;
        this.d = this.a(this.d, colorStateList, s2.d);
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, mode);
            return;
        }
        s s2 = this.c;
        if (s2.d == mode) return;
        s2.d = mode;
        this.d = this.a(this.d, s2.c, mode);
        this.invalidateSelf();
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (this.a == null) return super.setVisible(bl2, bl3);
        return this.a.setVisible(bl2, bl3);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }
}

