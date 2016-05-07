/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.dc;
import android.support.v7.b.g;
import android.support.v7.b.i;
import android.support.v7.b.l;
import android.support.v7.view.b;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.z;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.a;
import android.support.v7.widget.e;
import android.support.v7.widget.gk;
import android.support.v7.widget.gz;
import android.support.v7.widget.k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.b.b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        gk gk2 = gk.a(context, attributeSet, l.ActionMode, n2, 0);
        this.setBackgroundDrawable(gk2.a(l.ActionMode_background));
        this.n = gk2.g(l.ActionMode_titleTextStyle, 0);
        this.o = gk2.g(l.ActionMode_subtitleTextStyle, 0);
        this.e = gk2.f(l.ActionMode_height, 0);
        this.q = gk2.g(l.ActionMode_closeItemLayout, i.abc_action_mode_close_item_material);
        gk2.a();
    }

    private void e() {
        int n2 = 8;
        boolean bl2 = true;
        if (this.k == null) {
            LayoutInflater.from((Context)this.getContext()).inflate(i.abc_action_bar_title_item, (ViewGroup)this);
            this.k = (LinearLayout)this.getChildAt(-1 + this.getChildCount());
            this.l = (TextView)this.k.findViewById(g.action_bar_title);
            this.m = (TextView)this.k.findViewById(g.action_bar_subtitle);
            if (this.n != 0) {
                this.l.setTextAppearance(this.getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(this.getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        boolean bl3 = !TextUtils.isEmpty((CharSequence)this.g) ? bl2 : false;
        if (TextUtils.isEmpty((CharSequence)this.h)) {
            bl2 = false;
        }
        TextView textView = this.m;
        int n3 = bl2 ? 0 : n2;
        textView.setVisibility(n3);
        LinearLayout linearLayout = this.k;
        if (bl3 || bl2) {
            n2 = 0;
        }
        linearLayout.setVisibility(n2);
        if (this.k.getParent() != null) return;
        this.addView((View)this.k);
    }

    public void a(b b2) {
        if (this.i == null) {
            this.i = LayoutInflater.from((Context)this.getContext()).inflate(this.q, (ViewGroup)this, false);
            this.addView(this.i);
        } else if (this.i.getParent() == null) {
            this.addView(this.i);
        }
        this.i.findViewById(g.action_mode_close_button).setOnClickListener((View.OnClickListener)new e(this, b2));
        android.support.v7.view.menu.i i2 = (android.support.v7.view.menu.i)b2.b();
        if (this.d != null) {
            this.d.f();
        }
        this.d = new k(this.getContext());
        this.d.c(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        i2.a(this.d, this.b);
        this.c = (ActionMenuView)this.d.a(this);
        this.c.setBackgroundDrawable(null);
        this.addView((View)this.c, layoutParams);
    }

    @Override
    public boolean a() {
        if (this.d == null) return false;
        return this.d.d();
    }

    public void b() {
        if (this.i != null) return;
        this.c();
    }

    public void c() {
        this.removeAllViews();
        this.j = null;
        this.c = null;
    }

    public boolean d() {
        return this.p;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet);
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d == null) return;
        this.d.e();
        this.d.g();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT < 14) return;
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource((View)this);
            accessibilityEvent.setClassName((CharSequence)this.getClass().getName());
            accessibilityEvent.setPackageName((CharSequence)this.getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6;
        boolean bl3 = gz.a((View)this);
        int n7 = bl3 ? n4 - n2 - this.getPaddingRight() : this.getPaddingLeft();
        int n8 = this.getPaddingTop();
        int n9 = n5 - n3 - this.getPaddingTop() - this.getPaddingBottom();
        if (this.i != null && this.i.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
            int n10 = bl3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int n11 = bl3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int n12 = ActionBarContextView.a(n7, n10, bl3);
            n6 = ActionBarContextView.a(n12 + this.a(this.i, n12, n8, n9, bl3), n11, bl3);
        } else {
            n6 = n7;
        }
        if (this.k != null && this.j == null && this.k.getVisibility() != 8) {
            n6 += this.a((View)this.k, n6, n8, n9, bl3);
        }
        if (this.j != null) {
            n6 + this.a(this.j, n6, n8, n9, bl3);
        }
        int n13 = bl3 ? this.getPaddingLeft() : n4 - n2 - this.getPaddingRight();
        if (this.c == null) return;
        ActionMenuView actionMenuView = this.c;
        boolean bl4 = !bl3;
        n13 + this.a((View)actionMenuView, n13, n8, n9, bl4);
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = 1073741824;
        int n5 = 0;
        if (View.MeasureSpec.getMode((int)n2) != n4) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode((int)n3) == 0) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        }
        int n6 = View.MeasureSpec.getSize((int)n2);
        int n7 = this.e > 0 ? this.e : View.MeasureSpec.getSize((int)n3);
        int n8 = this.getPaddingTop() + this.getPaddingBottom();
        int n9 = n6 - this.getPaddingLeft() - this.getPaddingRight();
        int n10 = n7 - n8;
        int n11 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)Integer.MIN_VALUE);
        if (this.i != null) {
            int n12 = this.a(this.i, n9, n11, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
            n9 = n12 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.c != null && this.c.getParent() == this) {
            n9 = this.a((View)this.c, n9, n11, 0);
        }
        if (this.k != null && this.j == null) {
            if (this.p) {
                int n13 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                this.k.measure(n13, n11);
                int n14 = this.k.getMeasuredWidth();
                boolean bl2 = n14 <= n9;
                if (bl2) {
                    n9 -= n14;
                }
                LinearLayout linearLayout = this.k;
                int n15 = bl2 ? 0 : 8;
                linearLayout.setVisibility(n15);
            } else {
                n9 = this.a((View)this.k, n9, n11, 0);
            }
        }
        if (this.j != null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            int n16 = layoutParams.width != -2 ? n4 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                n9 = Math.min(layoutParams.width, n9);
            }
            if (layoutParams.height == -2) {
                n4 = Integer.MIN_VALUE;
            }
            int n17 = layoutParams.height >= 0 ? Math.min(layoutParams.height, n10) : n10;
            this.j.measure(View.MeasureSpec.makeMeasureSpec((int)n9, (int)n16), View.MeasureSpec.makeMeasureSpec((int)n17, (int)n4));
        }
        if (this.e > 0) {
            this.setMeasuredDimension(n6, n7);
            return;
        }
        int n18 = this.getChildCount();
        int n19 = 0;
        do {
            if (n5 >= n18) {
                this.setMeasuredDimension(n6, n19);
                return;
            }
            int n20 = n8 + this.getChildAt(n5).getMeasuredHeight();
            if (n20 <= n19) {
                n20 = n19;
            }
            ++n5;
            n19 = n20;
        } while (true);
    }

    @Override
    public void setContentHeight(int n2) {
        this.e = n2;
    }

    public void setCustomView(View view) {
        if (this.j != null) {
            this.removeView(this.j);
        }
        this.j = view;
        if (view != null && this.k != null) {
            this.removeView((View)this.k);
            this.k = null;
        }
        if (view != null) {
            this.addView(view);
        }
        this.requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        this.e();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        this.e();
    }

    public void setTitleOptional(boolean bl2) {
        if (bl2 != this.p) {
            this.requestLayout();
        }
        this.p = bl2;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

