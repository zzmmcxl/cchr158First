/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.a.a.a;
import android.support.a.a.c;
import android.support.a.a.d;
import android.support.a.a.e;
import android.support.a.a.k;
import android.support.a.a.l;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(value=21)
public class b
extends k
implements Animatable {
    private d b;
    private Context c;
    private ArgbEvaluator d = null;
    private final Drawable.Callback e;

    private b() {
        this(null, null, null);
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, d d2, Resources resources) {
        this.e = new c(this);
        this.c = context;
        if (d2 != null) {
            this.b = d2;
            return;
        }
        this.b = new d(context, d2, this.e, resources);
    }

    /* synthetic */ b(c c2) {
        this();
    }

    static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme != null) return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
        return resources.obtainAttributes(attributeSet, arrn);
    }

    static /* synthetic */ Drawable.Callback a(b b2) {
        return b2.e;
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b b2 = new b(context);
        b2.inflate(resources, xmlPullParser, attributeSet, theme);
        return b2;
    }

    private void a(Animator animator) {
        ArrayList arrayList;
        if (animator instanceof AnimatorSet && (arrayList = ((AnimatorSet)animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                this.a((Animator)arrayList.get(i2));
            }
        }
        if (!(animator instanceof ObjectAnimator)) return;
        ObjectAnimator objectAnimator = (ObjectAnimator)animator;
        String string = objectAnimator.getPropertyName();
        if (!"fillColor".equals(string)) {
            if (!"strokeColor".equals(string)) return;
        }
        if (this.d == null) {
            this.d = new ArgbEvaluator();
        }
        objectAnimator.setEvaluator((TypeEvaluator)this.d);
    }

    private void a(String string, Animator animator) {
        animator.setTarget(this.b.b.a(string));
        if (Build.VERSION.SDK_INT < 21) {
            this.a(animator);
        }
        if (this.b.c == null) {
            this.b.c = new ArrayList();
            this.b.d = new android.support.v4.g.a();
        }
        this.b.c.add(animator);
        this.b.d.put((Object)animator, string);
    }

    private boolean a() {
        ArrayList arrayList = this.b.c;
        if (arrayList == null) {
            return false;
        }
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            if (((Animator)arrayList.get(n3)).isRunning()) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        if (this.a == null) return;
        android.support.v4.c.a.a.a(this.a, theme);
    }

    public boolean canApplyTheme() {
        if (this.a == null) return false;
        return android.support.v4.c.a.a.d(this.a);
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.b.b.draw(canvas);
        if (!this.a()) return;
        this.invalidateSelf();
    }

    public int getAlpha() {
        if (this.a == null) return this.b.b.getAlpha();
        return android.support.v4.c.a.a.c(this.a);
    }

    public int getChangingConfigurations() {
        if (this.a == null) return super.getChangingConfigurations() | this.b.a;
        return this.a.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.a == null) return null;
        return new e(this.a.getConstantState());
    }

    public int getIntrinsicHeight() {
        if (this.a == null) return this.b.b.getIntrinsicHeight();
        return this.a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.a == null) return this.b.b.getIntrinsicWidth();
        return this.a.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.a == null) return this.b.b.getOpacity();
        return this.a.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int n2 = xmlPullParser.getEventType();
        while (n2 != 1) {
            if (n2 == 2) {
                String string = xmlPullParser.getName();
                if ("animated-vector".equals(string)) {
                    TypedArray typedArray = b.a(resources, theme, attributeSet, a.e);
                    int n3 = typedArray.getResourceId(0, 0);
                    if (n3 != 0) {
                        l l2 = l.a(resources, n3, theme);
                        l2.a(false);
                        l2.setCallback(this.e);
                        if (this.b.b != null) {
                            this.b.b.setCallback(null);
                        }
                        this.b.b = l2;
                    }
                    typedArray.recycle();
                } else if ("target".equals(string)) {
                    TypedArray typedArray = resources.obtainAttributes(attributeSet, a.f);
                    String string2 = typedArray.getString(0);
                    int n4 = typedArray.getResourceId(1, 0);
                    if (n4 != 0) {
                        if (this.c == null) throw new IllegalStateException("Context can't be null when inflating animators");
                        this.a(string2, AnimatorInflater.loadAnimator((Context)this.c, (int)n4));
                    }
                    typedArray.recycle();
                }
            }
            n2 = xmlPullParser.next();
        }
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable)this.a).isRunning();
        }
        ArrayList arrayList = this.b.c;
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            if (((Animator)arrayList.get(n3)).isRunning()) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public boolean isStateful() {
        if (this.a == null) return this.b.b.isStateful();
        return this.a.isStateful();
    }

    public Drawable mutate() {
        if (this.a == null) throw new IllegalStateException("Mutate() is not supported for older platform");
        this.a.mutate();
        return this;
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
            return;
        }
        this.b.b.setBounds(rect);
    }

    @Override
    protected boolean onLevelChange(int n2) {
        if (this.a == null) return this.b.b.setLevel(n2);
        return this.a.setLevel(n2);
    }

    protected boolean onStateChange(int[] arrn) {
        if (this.a == null) return this.b.b.setState(arrn);
        return this.a.setState(arrn);
    }

    public void setAlpha(int n2) {
        if (this.a != null) {
            this.a.setAlpha(n2);
            return;
        }
        this.b.b.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.b.b.setColorFilter(colorFilter);
    }

    public void setTint(int n2) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, n2);
            return;
        }
        this.b.b.setTint(n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, colorStateList);
            return;
        }
        this.b.b.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, mode);
            return;
        }
        this.b.b.setTintMode(mode);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (this.a != null) {
            return this.a.setVisible(bl2, bl3);
        }
        this.b.b.setVisible(bl2, bl3);
        return super.setVisible(bl2, bl3);
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable)this.a).start();
            return;
        }
        if (this.a()) return;
        ArrayList arrayList = this.b.c;
        int n2 = arrayList.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.invalidateSelf();
                return;
            }
            ((Animator)arrayList.get(n3)).start();
            ++n3;
        } while (true);
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable)this.a).stop();
            return;
        }
        ArrayList arrayList = this.b.c;
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            ((Animator)arrayList.get(n3)).end();
            ++n3;
        }
    }
}

