/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.g;
import android.support.v7.b.l;
import android.support.v7.widget.c;
import android.support.v7.widget.d;
import android.support.v7.widget.fn;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ActionBarContainer
extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c c2 = Build.VERSION.SDK_INT >= 21 ? new d(this) : new c(this);
        this.setBackgroundDrawable((Drawable)c2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.ActionBar);
        this.a = typedArray.getDrawable(l.ActionBar_background);
        this.b = typedArray.getDrawable(l.ActionBar_backgroundStacked);
        this.j = typedArray.getDimensionPixelSize(l.ActionBar_height, -1);
        if (this.getId() == g.split_action_bar) {
            this.d = true;
            this.c = typedArray.getDrawable(l.ActionBar_backgroundSplit);
        }
        typedArray.recycle();
        boolean bl2 = this.d ? this.c == null : this.a == null && this.b == null;
        this.setWillNotDraw(bl2);
    }

    private boolean a(View view) {
        if (view == null) return true;
        if (view.getVisibility() == 8) return true;
        if (view.getMeasuredHeight() != 0) return false;
        return true;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null && this.a.isStateful()) {
            this.a.setState(this.getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(this.getDrawableState());
        }
        if (this.c == null) return;
        if (!this.c.isStateful()) return;
        this.c.setState(this.getDrawableState());
    }

    public View getTabContainer() {
        return this.g;
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT < 11) return;
        super.jumpDrawablesToCurrentState();
        if (this.a != null) {
            this.a.jumpToCurrentState();
        }
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
        if (this.c == null) return;
        this.c.jumpToCurrentState();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = this.findViewById(g.action_bar);
        this.i = this.findViewById(g.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f) return true;
        if (!super.onInterceptTouchEvent(motionEvent)) return false;
        return true;
    }

    public void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        boolean bl3 = true;
        super.onLayout(bl2, n2, n3, n4, n5);
        View view = this.g;
        boolean bl4 = view != null && view.getVisibility() != 8 ? bl3 : false;
        if (view != null && view.getVisibility() != 8) {
            int n6 = this.getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            view.layout(n2, n6 - view.getMeasuredHeight() - layoutParams.bottomMargin, n4, n6 - layoutParams.bottomMargin);
        }
        if (this.d) {
            if (this.c == null) return;
            this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
        } else {
            boolean bl5;
            if (this.a != null) {
                if (this.h.getVisibility() == 0) {
                    this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else if (this.i != null && this.i.getVisibility() == 0) {
                    this.a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                } else {
                    this.a.setBounds(0, 0, 0, 0);
                }
                bl5 = bl3;
            } else {
                bl5 = false;
            }
            this.e = bl4;
            if (bl4 && this.b != null) {
                this.b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                bl3 = bl5;
            }
        }
        if (!bl3) return;
        this.invalidate();
    }

    public void onMeasure(int n2, int n3) {
        if (this.h == null && View.MeasureSpec.getMode((int)n3) == Integer.MIN_VALUE && this.j >= 0) {
            n3 = View.MeasureSpec.makeMeasureSpec((int)Math.min(this.j, View.MeasureSpec.getSize((int)n3)), (int)Integer.MIN_VALUE);
        }
        super.onMeasure(n2, n3);
        if (this.h == null) {
            return;
        }
        int n4 = View.MeasureSpec.getMode((int)n3);
        if (this.g == null) return;
        if (this.g.getVisibility() == 8) return;
        if (n4 == 1073741824) return;
        int n5 = !this.a(this.h) ? this.b(this.h) : (!this.a(this.i) ? this.b(this.i) : 0);
        int n6 = n4 == Integer.MIN_VALUE ? View.MeasureSpec.getSize((int)n3) : Integer.MAX_VALUE;
        this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(n5 + this.b(this.g), n6));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean bl2 = true;
        if (this.a != null) {
            this.a.setCallback(null);
            this.unscheduleDrawable(this.a);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
            if (this.h != null) {
                this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        if (this.d) {
            if (this.c != null) {
                bl2 = false;
            }
        } else if (this.a != null || this.b != null) {
            bl2 = false;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean bl2 = true;
        if (this.c != null) {
            this.c.setCallback(null);
            this.unscheduleDrawable(this.c);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
            if (this.d && this.c != null) {
                this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            }
        }
        if (this.d) {
            if (this.c != null) {
                bl2 = false;
            }
        } else if (this.a != null || this.b != null) {
            bl2 = false;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean bl2 = true;
        if (this.b != null) {
            this.b.setCallback(null);
            this.unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
            if (this.e && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        if (this.d) {
            if (this.c != null) {
                bl2 = false;
            }
        } else if (this.a != null || this.b != null) {
            bl2 = false;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    public void setTabContainer(fn fn2) {
        if (this.g != null) {
            this.removeView(this.g);
        }
        this.g = fn2;
        if (fn2 == null) return;
        this.addView((View)fn2);
        ViewGroup.LayoutParams layoutParams = fn2.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        fn2.setAllowCollapse(false);
    }

    public void setTransitioning(boolean bl2) {
        this.f = bl2;
        int n2 = bl2 ? 393216 : 262144;
        this.setDescendantFocusability(n2);
    }

    public void setVisibility(int n2) {
        super.setVisibility(n2);
        boolean bl2 = n2 == 0;
        if (this.a != null) {
            this.a.setVisible(bl2, false);
        }
        if (this.b != null) {
            this.b.setVisible(bl2, false);
        }
        if (this.c == null) return;
        this.c.setVisible(bl2, false);
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.a) {
            if (!this.d) return true;
        }
        if (drawable == this.b) {
            if (this.e) return true;
        }
        if (drawable == this.c) {
            if (this.d) return true;
        }
        if (!super.verifyDrawable(drawable)) return false;
        return true;
    }
}

