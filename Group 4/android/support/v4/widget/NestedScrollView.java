/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.h.at;
import android.support.v4.h.bc;
import android.support.v4.h.bd;
import android.support.v4.h.be;
import android.support.v4.h.bf;
import android.support.v4.h.bh;
import android.support.v4.h.bo;
import android.support.v4.widget.NestedScrollView$SavedState;
import android.support.v4.widget.ad;
import android.support.v4.widget.ae;
import android.support.v4.widget.as;
import android.support.v4.widget.s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.ArrayList;

public class NestedScrollView
extends FrameLayout
implements bc,
be,
bh {
    private static final ad v = new ad();
    private static final int[] w = new int[]{16843130};
    private ae A;
    private long a;
    private final Rect b = new Rect();
    private as c;
    private s d;
    private s e;
    private int f;
    private boolean g = true;
    private boolean h = false;
    private View i = null;
    private boolean j = false;
    private VelocityTracker k;
    private boolean l;
    private boolean m = true;
    private int n;
    private int o;
    private int p;
    private int q = -1;
    private final int[] r = new int[2];
    private final int[] s = new int[2];
    private int t;
    private NestedScrollView$SavedState u;
    private final bf x;
    private final bd y;
    private float z;

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, w, n2, 0);
        this.setFillViewport(typedArray.getBoolean(0, false));
        typedArray.recycle();
        this.x = new bf((ViewGroup)this);
        this.y = new bd((View)this);
        this.setNestedScrollingEnabled(true);
        bo.a((View)this, v);
    }

    static /* synthetic */ int a(NestedScrollView nestedScrollView) {
        return nestedScrollView.getScrollRange();
    }

    /*
     * Unable to fully structure code
     */
    private View a(boolean var1_1, int var2_2, int var3_3) {
        var4_4 = this.getFocusables(2);
        var5_5 = null;
        var6_6 = false;
        var7_7 = var4_4.size();
        var8_8 = 0;
        while (var8_8 < var7_7) {
            var9_9 = (View)var4_4.get(var8_8);
            var10_10 = var9_9.getTop();
            var11_11 = var9_9.getBottom();
            if (var2_2 >= var11_11 || var10_10 >= var3_3) ** GOTO lbl-1000
            var14_14 = var2_2 < var10_10 && var11_11 < var3_3;
            if (var5_5 != null) ** GOTO lbl17
            var16_16 = var14_14;
            var13_13 = var9_9;
            var12_12 = var16_16;
            ** GOTO lbl33
lbl17: // 1 sources:
            var15_15 = var1_1 != false && var10_10 < var5_5.getTop() || var1_1 == false && var11_11 > var5_5.getBottom();
            if (!var6_6) ** GOTO lbl23
            if (!var14_14 || !var15_15) ** GOTO lbl-1000
            var13_13 = var9_9;
            var12_12 = var6_6;
            ** GOTO lbl33
lbl23: // 1 sources:
            if (var14_14) {
                var13_13 = var9_9;
                var12_12 = true;
            } else if (var15_15) {
                var13_13 = var9_9;
                var12_12 = var6_6;
            } else lbl-1000: // 3 sources:
            {
                var12_12 = var6_6;
                var13_13 = var5_5;
            }
lbl33: // 5 sources:
            ++var8_8;
            var5_5 = var13_13;
            var6_6 = var12_12;
        }
        return var5_5;
    }

    private void a() {
        this.c = as.a(this.getContext(), null);
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void a(MotionEvent motionEvent) {
        int n2 = (65280 & motionEvent.getAction()) >> 8;
        if (at.b(motionEvent, n2) != this.q) return;
        int n3 = n2 == 0 ? 1 : 0;
        this.f = (int)at.d(motionEvent, n3);
        this.q = at.b(motionEvent, n3);
        if (this.k == null) return;
        this.k.clear();
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(int var1_1, int var2_2, int var3_3) {
        var4_4 = this.getHeight();
        var5_5 = this.getScrollY();
        var6_6 = var5_5 + var4_4;
        var7_7 = var1_1 == 33;
        var8_8 = this.a(var7_7, var2_2, var3_3);
        if (var8_8 == null) {
            var8_8 = this;
        }
        if (var2_2 < var5_5) ** GOTO lbl-1000
        var9_9 = false;
        if (var3_3 > var6_6) lbl-1000: // 2 sources:
        {
            var10_10 = var7_7 != false ? var2_2 - var5_5 : var3_3 - var6_6;
            this.e(var10_10);
            var9_9 = true;
        }
        if (var8_8 == this.findFocus()) return var9_9;
        var8_8.requestFocus(var1_1);
        return var9_9;
    }

    private boolean a(Rect rect, boolean bl2) {
        int n2 = this.a(rect);
        boolean bl3 = n2 != 0;
        if (!bl3) return bl3;
        if (bl2) {
            this.scrollBy(0, n2);
            return bl3;
        }
        this.a(0, n2);
        return bl3;
    }

    private boolean a(View view) {
        boolean bl2 = this.a(view, 0, this.getHeight());
        boolean bl3 = false;
        if (bl2) return bl3;
        return true;
    }

    private boolean a(View view, int n2, int n3) {
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        if (n2 + this.b.bottom < this.getScrollY()) return false;
        if (this.b.top - n2 > n3 + this.getScrollY()) return false;
        return true;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent viewParent = view.getParent();
        if (!(viewParent instanceof ViewGroup)) return false;
        if (!NestedScrollView.a((View)viewParent, view2)) return false;
        return true;
    }

    private static int b(int n2, int n3, int n4) {
        if (n3 >= n4) return 0;
        if (n2 < 0) return 0;
        if (n3 + n2 <= n4) return n2;
        return n4 - n3;
    }

    private void b(View view) {
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        int n2 = this.a(this.b);
        if (n2 == 0) return;
        this.scrollBy(0, n2);
    }

    private boolean b() {
        View view = this.getChildAt(0);
        boolean bl2 = false;
        if (view == null) return bl2;
        int n2 = view.getHeight();
        int n3 = this.getHeight();
        int n4 = n2 + this.getPaddingTop() + this.getPaddingBottom();
        bl2 = false;
        if (n3 >= n4) return bl2;
        return true;
    }

    private void c() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
            return;
        }
        this.k.clear();
    }

    private boolean c(int n2, int n3) {
        int n4 = this.getChildCount();
        boolean bl2 = false;
        if (n4 <= 0) return bl2;
        int n5 = this.getScrollY();
        View view = this.getChildAt(0);
        int n6 = view.getTop() - n5;
        bl2 = false;
        if (n3 < n6) return bl2;
        int n7 = view.getBottom() - n5;
        bl2 = false;
        if (n3 >= n7) return bl2;
        int n8 = view.getLeft();
        bl2 = false;
        if (n2 < n8) return bl2;
        int n9 = view.getRight();
        bl2 = false;
        if (n2 >= n9) return bl2;
        return true;
    }

    private void d() {
        if (this.k != null) return;
        this.k = VelocityTracker.obtain();
    }

    private void e() {
        if (this.k == null) return;
        this.k.recycle();
        this.k = null;
    }

    private void e(int n2) {
        if (n2 == 0) return;
        if (this.m) {
            this.a(0, n2);
            return;
        }
        this.scrollBy(0, n2);
    }

    private void f() {
        this.j = false;
        this.e();
        this.stopNestedScroll();
        if (this.d == null) return;
        this.d.b();
        this.e.b();
    }

    private void f(int n2) {
        int n3 = this.getScrollY();
        boolean bl2 = !(n3 <= 0 && n2 <= 0 || n3 >= this.getScrollRange() && n2 >= 0);
        if (this.dispatchNestedPreFling(0.0f, n2)) return;
        this.dispatchNestedFling(0.0f, n2, bl2);
        if (!bl2) return;
        this.d(n2);
    }

    private void g() {
        if (bo.a((View)this) != 2) {
            if (this.d != null) return;
            Context context = this.getContext();
            this.d = new s(context);
            this.e = new s(context);
            return;
        }
        this.d = null;
        this.e = null;
    }

    private int getScrollRange() {
        int n2 = this.getChildCount();
        int n3 = 0;
        if (n2 <= 0) return n3;
        return Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
    }

    private float getVerticalScrollFactorCompat() {
        if (this.z != 0.0f) return this.z;
        TypedValue typedValue = new TypedValue();
        Context context = this.getContext();
        if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
        }
        this.z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        return this.z;
    }

    protected int a(Rect rect) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        int n2 = this.getHeight();
        int n3 = this.getScrollY();
        int n4 = n3 + n2;
        int n5 = this.getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            n3 += n5;
        }
        if (rect.bottom < this.getChildAt(0).getHeight()) {
            n4 -= n5;
        }
        if (rect.bottom > n4 && rect.top > n3) {
            int n6 = rect.height() > n2 ? 0 + (rect.top - n3) : 0 + (rect.bottom - n4);
            return Math.min(n6, this.getChildAt(0).getBottom() - n4);
        }
        if (rect.top >= n3) return 0;
        if (rect.bottom >= n4) return 0;
        int n7 = rect.height() > n2 ? 0 - (n4 - rect.bottom) : 0 - (n3 - rect.top);
        return Math.max(n7, - this.getScrollY());
    }

    public final void a(int n2, int n3) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250) {
            int n4 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
            int n5 = Math.max(0, this.getChildAt(0).getHeight() - n4);
            int n6 = this.getScrollY();
            int n7 = Math.max(0, Math.min(n6 + n3, n5)) - n6;
            this.c.a(this.getScrollX(), n6, 0, n7);
            bo.d((View)this);
        } else {
            if (!this.c.a()) {
                this.c.h();
            }
            this.scrollBy(n2, n3);
        }
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean a(int n2) {
        boolean bl2 = n2 == 130;
        int n3 = this.getHeight();
        if (bl2) {
            View view;
            this.b.top = n3 + this.getScrollY();
            int n4 = this.getChildCount();
            if (n4 > 0 && n3 + this.b.top > (view = this.getChildAt(n4 - 1)).getBottom()) {
                this.b.top = view.getBottom() - n3;
            }
        } else {
            this.b.top = this.getScrollY() - n3;
            if (this.b.top < 0) {
                this.b.top = 0;
            }
        }
        this.b.bottom = n3 + this.b.top;
        return this.a(n2, this.b.top, this.b.bottom);
    }

    boolean a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, boolean bl2) {
        boolean bl3;
        boolean bl4;
        int n10 = bo.a((View)this);
        boolean bl5 = this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent();
        boolean bl6 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent();
        boolean bl7 = n10 == 0 || n10 == 1 && bl5;
        boolean bl8 = n10 == 0 || n10 == 1 && bl6;
        int n11 = n4 + n2;
        if (!bl7) {
            n8 = 0;
        }
        int n12 = n5 + n3;
        if (!bl8) {
            n9 = 0;
        }
        int n13 = - n8;
        int n14 = n8 + n6;
        int n15 = - n9;
        int n16 = n9 + n7;
        if (n11 > n14) {
            bl3 = true;
        } else if (n11 < n13) {
            bl3 = true;
            n14 = n13;
        } else {
            n14 = n11;
            bl3 = false;
        }
        if (n12 > n16) {
            bl4 = true;
        } else if (n12 < n15) {
            bl4 = true;
            n16 = n15;
        } else {
            n16 = n12;
            bl4 = false;
        }
        if (bl4) {
            this.c.a(n14, n16, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(n14, n16, bl3, bl4);
        if (bl3) return true;
        if (!bl4) return false;
        return true;
    }

    public boolean a(KeyEvent keyEvent) {
        boolean bl2;
        int n2 = 33;
        this.b.setEmpty();
        if (!this.b()) {
            View view;
            boolean bl3 = this.isFocused();
            bl2 = false;
            if (!bl3) return bl2;
            int n3 = keyEvent.getKeyCode();
            bl2 = false;
            if (n3 == 4) return bl2;
            View view2 = this.findFocus();
            if (view2 == this) {
                view2 = null;
            }
            if ((view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view2, 130)) == null) return false;
            if (view == this) return false;
            if (!view.requestFocus(130)) return false;
            return true;
        }
        int n4 = keyEvent.getAction();
        bl2 = false;
        if (n4 != 0) return bl2;
        switch (keyEvent.getKeyCode()) {
            default: {
                return false;
            }
            case 19: {
                if (keyEvent.isAltPressed()) return this.b(n2);
                return this.c(n2);
            }
            case 20: {
                if (keyEvent.isAltPressed()) return this.b(130);
                return this.c(130);
            }
            case 62: 
        }
        if (!keyEvent.isShiftPressed()) {
            n2 = 130;
        }
        this.a(n2);
        return false;
    }

    public void addView(View view) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int n2) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, n2);
    }

    public void addView(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, n2, layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void b(int n2, int n3) {
        this.a(n2 - this.getScrollX(), n3 - this.getScrollY());
    }

    public boolean b(int n2) {
        boolean bl2 = n2 == 130;
        int n3 = this.getHeight();
        this.b.top = 0;
        this.b.bottom = n3;
        if (!bl2) return this.a(n2, this.b.top, this.b.bottom);
        int n4 = this.getChildCount();
        if (n4 <= 0) return this.a(n2, this.b.top, this.b.bottom);
        View view = this.getChildAt(n4 - 1);
        this.b.bottom = view.getBottom() + this.getPaddingBottom();
        this.b.top = this.b.bottom - n3;
        return this.a(n2, this.b.top, this.b.bottom);
    }

    public boolean c(int n2) {
        View view = this.findFocus();
        if (view == this) {
            view = null;
        }
        View view2 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view, n2);
        int n3 = this.getMaxScrollAmount();
        if (view2 != null && this.a(view2, n3, this.getHeight())) {
            view2.getDrawingRect(this.b);
            this.offsetDescendantRectToMyCoords(view2, this.b);
            this.e(this.a(this.b));
            view2.requestFocus(n2);
        } else {
            int n4;
            int n5;
            if (n2 == 33 && this.getScrollY() < n3) {
                n3 = this.getScrollY();
            } else if (n2 == 130 && this.getChildCount() > 0 && (n5 = this.getChildAt(0).getBottom()) - (n4 = this.getScrollY() + this.getHeight() - this.getPaddingBottom()) < n3) {
                n3 = n5 - n4;
            }
            if (n3 == 0) {
                return false;
            }
            if (n2 != 130) {
                n3 = - n3;
            }
            this.e(n3);
        }
        if (view == null) return true;
        if (!view.isFocused()) return true;
        if (!this.a(view)) return true;
        int n6 = this.getDescendantFocusability();
        this.setDescendantFocusability(131072);
        this.requestFocus();
        this.setDescendantFocusability(n6);
        return true;
    }

    @Override
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (!this.c.g()) return;
        int n2 = this.getScrollX();
        int n3 = this.getScrollY();
        int n4 = this.c.b();
        int n5 = this.c.c();
        if (n2 == n4) {
            if (n3 == n5) return;
        }
        int n6 = this.getScrollRange();
        int n7 = bo.a((View)this);
        boolean bl2 = n7 == 0 || n7 == 1 && n6 > 0;
        this.a(n4 - n2, n5 - n3, n2, n3, 0, n6, 0, 0, false);
        if (!bl2) return;
        this.g();
        if (n5 <= 0 && n3 > 0) {
            this.d.a((int)this.c.f());
            return;
        }
        if (n5 < n6) return;
        if (n3 >= n6) return;
        this.e.a((int)this.c.f());
    }

    @Override
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override
    public int computeVerticalScrollRange() {
        int n2 = this.getChildCount();
        int n3 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (n2 == 0) {
            return n3;
        }
        int n4 = this.getChildAt(0).getBottom();
        int n5 = this.getScrollY();
        int n6 = Math.max(0, n4 - n3);
        if (n5 < 0) {
            return n4 - n5;
        }
        if (n5 <= n6) return n4;
        return n4 + (n5 - n6);
    }

    public void d(int n2) {
        if (this.getChildCount() <= 0) return;
        int n3 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        int n4 = this.getChildAt(0).getHeight();
        this.c.a(this.getScrollX(), this.getScrollY(), 0, n2, 0, 0, 0, Math.max(0, n4 - n3), 0, n3 / 2);
        bo.d((View)this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) return true;
        if (!this.a(keyEvent)) return false;
        return true;
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean bl2) {
        return this.y.a(f2, f3, bl2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.y.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.y.a(n2, n3, arrn, arrn2);
    }

    public boolean dispatchNestedScroll(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.y.a(n2, n3, n4, n5, arrn);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.d == null) return;
        int n2 = this.getScrollY();
        if (!this.d.a()) {
            int n3 = canvas.save();
            int n4 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            canvas.translate((float)this.getPaddingLeft(), (float)Math.min(0, n2));
            this.d.a(n4, this.getHeight());
            if (this.d.a(canvas)) {
                bo.d((View)this);
            }
            canvas.restoreToCount(n3);
        }
        if (this.e.a()) return;
        int n5 = canvas.save();
        int n6 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
        int n7 = this.getHeight();
        canvas.translate((float)(- n6 + this.getPaddingLeft()), (float)(n7 + Math.max(this.getScrollRange(), n2)));
        canvas.rotate(180.0f, (float)n6, 0.0f);
        this.e.a(n6, n7);
        if (this.e.a(canvas)) {
            bo.d((View)this);
        }
        canvas.restoreToCount(n5);
    }

    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        int n2 = this.getVerticalFadingEdgeLength();
        int n3 = this.getHeight() - this.getPaddingBottom();
        int n4 = this.getChildAt(0).getBottom() - this.getScrollY() - n3;
        if (n4 >= n2) return 1.0f;
        return (float)n4 / (float)n2;
    }

    public int getMaxScrollAmount() {
        return (int)(0.5f * (float)this.getHeight());
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        int n2 = this.getVerticalFadingEdgeLength();
        int n3 = this.getScrollY();
        if (n3 >= n2) return 1.0f;
        return (float)n3 / (float)n2;
    }

    public boolean hasNestedScrollingParent() {
        return this.y.b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.y.a();
    }

    protected void measureChild(View view, int n2, int n3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
    }

    protected void measureChildWithMargins(View view, int n2, int n3, int n4, int n5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n2, (int)(n3 + (this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)), (int)marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec((int)(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin), (int)0));
    }

    public void onAttachedToWindow() {
        this.h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((2 & at.d(motionEvent)) == 0) return false;
        switch (motionEvent.getAction()) {
            default: {
                return false;
            }
            case 8: 
        }
        if (this.j) return false;
        float f2 = at.e(motionEvent, 9);
        if (f2 == 0.0f) return false;
        int n2 = (int)(f2 * this.getVerticalScrollFactorCompat());
        int n3 = this.getScrollRange();
        int n4 = this.getScrollY();
        int n5 = n4 - n2;
        if (n5 < 0) {
            n3 = 0;
        } else if (n5 <= n3) {
            n3 = n5;
        }
        if (n3 == n4) return false;
        super.scrollTo(this.getScrollX(), n3);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onInterceptTouchEvent(MotionEvent var1_1) {
        var2_2 = var1_1.getAction();
        if (var2_2 == 2 && this.j) {
            return true;
        }
        switch (var2_2 & 255) {
            case 2: {
                var8_3 = this.q;
                if (var8_3 == -1) return this.j;
                var9_4 = at.a(var1_1, var8_3);
                if (var9_4 == -1) {
                    Log.e((String)"NestedScrollView", (String)("Invalid pointerId=" + var8_3 + " in onInterceptTouchEvent"));
                    ** break;
                }
                var10_5 = (int)at.d(var1_1, var9_4);
                if (Math.abs(var10_5 - this.f) <= this.n) return this.j;
                if ((2 & this.getNestedScrollAxes()) != 0) return this.j;
                this.j = true;
                this.f = var10_5;
                this.d();
                this.k.addMovement(var1_1);
                this.t = 0;
                var11_6 = this.getParent();
                if (var11_6 == null) return this.j;
                var11_6.requestDisallowInterceptTouchEvent(true);
                ** break;
            }
            case 0: {
                var3_7 = (int)var1_1.getY();
                if (!this.c((int)var1_1.getX(), var3_7)) {
                    this.j = false;
                    this.e();
                    ** break;
                }
                this.f = var3_7;
                this.q = at.b(var1_1, 0);
                this.c();
                this.k.addMovement(var1_1);
                this.c.g();
                var5_8 = this.c.a();
                var6_9 = false;
                if (!var5_8) {
                    var6_9 = true;
                }
                this.j = var6_9;
                this.startNestedScroll(2);
                ** break;
            }
            case 1: 
            case 3: {
                this.j = false;
                this.q = -1;
                this.e();
                if (this.c.a(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    bo.d((View)this);
                }
                this.stopNestedScroll();
            }
lbl49: // 6 sources:
            default: {
                return this.j;
            }
            case 6: 
        }
        this.a(var1_1);
        return this.j;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.g = false;
        if (this.i != null && NestedScrollView.a(this.i, (View)this)) {
            this.b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.u != null) {
                this.scrollTo(this.getScrollX(), this.u.a);
                this.u = null;
            }
            int n6 = this.getChildCount() > 0 ? this.getChildAt(0).getMeasuredHeight() : 0;
            int n7 = Math.max(0, n6 - (n5 - n3 - this.getPaddingBottom() - this.getPaddingTop()));
            if (this.getScrollY() > n7) {
                this.scrollTo(this.getScrollX(), n7);
            } else if (this.getScrollY() < 0) {
                this.scrollTo(this.getScrollX(), 0);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.h = true;
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (!this.l) {
            return;
        }
        if (View.MeasureSpec.getMode((int)n3) == 0) return;
        if (this.getChildCount() <= 0) return;
        View view = this.getChildAt(0);
        int n4 = this.getMeasuredHeight();
        if (view.getMeasuredHeight() >= n4) return;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)(n4 - this.getPaddingTop() - this.getPaddingBottom()), (int)1073741824));
    }

    @Override
    public boolean onNestedFling(View view, float f2, float f3, boolean bl2) {
        if (bl2) return false;
        this.f((int)f3);
        return true;
    }

    @Override
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override
    public void onNestedPreScroll(View view, int n2, int n3, int[] arrn) {
    }

    @Override
    public void onNestedScroll(View view, int n2, int n3, int n4, int n5) {
        int n6 = this.getScrollY();
        this.scrollBy(0, n5);
        int n7 = this.getScrollY() - n6;
        this.dispatchNestedScroll(0, n7, 0, n5 - n7, null);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n2) {
        this.x.a(view, view2, n2);
        this.startNestedScroll(2);
    }

    protected void onOverScrolled(int n2, int n3, boolean bl2, boolean bl3) {
        super.scrollTo(n2, n3);
    }

    protected boolean onRequestFocusInDescendants(int n2, Rect rect) {
        if (n2 == 2) {
            n2 = 130;
        } else if (n2 == 1) {
            n2 = 33;
        }
        View view = rect == null ? FocusFinder.getInstance().findNextFocus((ViewGroup)this, null, n2) : FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n2);
        if (view == null) {
            return false;
        }
        if (this.a(view)) return false;
        return view.requestFocus(n2, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        NestedScrollView$SavedState nestedScrollView$SavedState = (NestedScrollView$SavedState)parcelable;
        super.onRestoreInstanceState(nestedScrollView$SavedState.getSuperState());
        this.u = nestedScrollView$SavedState;
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        NestedScrollView$SavedState nestedScrollView$SavedState = new NestedScrollView$SavedState(super.onSaveInstanceState());
        nestedScrollView$SavedState.a = this.getScrollY();
        return nestedScrollView$SavedState;
    }

    protected void onScrollChanged(int n2, int n3, int n4, int n5) {
        super.onScrollChanged(n2, n3, n4, n5);
        if (this.A == null) return;
        this.A.a(this, n2, n3, n4, n5);
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        View view = this.findFocus();
        if (view == null) return;
        if (this == view) {
            return;
        }
        if (!this.a(view, 0, n5)) return;
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        this.e(this.a(this.b));
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n2) {
        if ((n2 & 2) == 0) return false;
        return true;
    }

    @Override
    public void onStopNestedScroll(View view) {
        this.x.a(view);
        this.stopNestedScroll();
    }

    /*
     * Exception decompiling
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.rebuildSwitches(SwitchReplacer.java:334)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.g) {
            this.b(view2);
        } else {
            this.i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.a(rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        if (bl2) {
            this.e();
        }
        super.requestDisallowInterceptTouchEvent(bl2);
    }

    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    public void scrollTo(int n2, int n3) {
        if (this.getChildCount() <= 0) return;
        View view = this.getChildAt(0);
        int n4 = NestedScrollView.b(n2, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), view.getWidth());
        int n5 = NestedScrollView.b(n3, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), view.getHeight());
        if (n4 == this.getScrollX()) {
            if (n5 == this.getScrollY()) return;
        }
        super.scrollTo(n4, n5);
    }

    public void setFillViewport(boolean bl2) {
        if (bl2 == this.l) return;
        this.l = bl2;
        this.requestLayout();
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.y.a(bl2);
    }

    public void setOnScrollChangeListener(ae ae2) {
        this.A = ae2;
    }

    public void setSmoothScrollingEnabled(boolean bl2) {
        this.m = bl2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int n2) {
        return this.y.a(n2);
    }

    @Override
    public void stopNestedScroll() {
        this.y.c();
    }
}

