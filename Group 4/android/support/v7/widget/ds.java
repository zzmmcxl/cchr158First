/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.a;
import android.support.v7.widget.dt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ds
extends ListView {
    private static final int[] g = new int[]{0};
    final Rect a = new Rect();
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    protected int f;
    private Field h;
    private dt i;

    public ds(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        try {
            this.h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h.setAccessible(true);
            return;
        }
        catch (NoSuchFieldException var4_4) {
            var4_4.printStackTrace();
            return;
        }
    }

    public int a(int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.getListPaddingTop();
        int n8 = this.getListPaddingBottom();
        this.getListPaddingLeft();
        this.getListPaddingRight();
        int n9 = this.getDividerHeight();
        Drawable drawable = this.getDivider();
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter == null) {
            return n7 + n8;
        }
        int n10 = n8 + n7;
        if (n9 <= 0 || drawable == null) {
            n9 = 0;
        }
        int n11 = 0;
        View view = null;
        int n12 = 0;
        int n13 = listAdapter.getCount();
        int n14 = 0;
        while (n14 < n13) {
            View view2;
            ViewGroup.LayoutParams layoutParams;
            int n15 = listAdapter.getItemViewType(n14);
            if (n15 != n12) {
                view2 = null;
                n12 = n15;
            } else {
                view2 = view;
            }
            if ((layoutParams = (view = listAdapter.getView(n14, view2, (ViewGroup)this)).getLayoutParams()) == null) {
                layoutParams = this.generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int n16 = layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec((int)layoutParams.height, (int)1073741824) : View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            view.measure(n2, n16);
            view.forceLayout();
            int n17 = n14 > 0 ? n10 + n9 : n10;
            int n18 = n17 + view.getMeasuredHeight();
            if (n18 >= n5) {
                if (n6 < 0) return n5;
                if (n14 <= n6) return n5;
                if (n11 <= 0) return n5;
                if (n18 == n5) return n5;
                return n11;
            }
            if (n6 >= 0 && n14 >= n6) {
                n11 = n18;
            }
            ++n14;
            n10 = n18;
        }
        return n10;
    }

    protected void a(int n2, View view) {
        boolean bl2 = true;
        Drawable drawable = this.getSelector();
        boolean bl3 = drawable != null && n2 != -1 ? bl2 : false;
        if (bl3) {
            drawable.setVisible(false, false);
        }
        this.b(n2, view);
        if (!bl3) return;
        Rect rect = this.a;
        float f2 = rect.exactCenterX();
        float f3 = rect.exactCenterY();
        if (this.getVisibility() != 0) {
            bl2 = false;
        }
        drawable.setVisible(bl2, false);
        a.a(drawable, f2, f3);
    }

    protected void a(int n2, View view, float f2, float f3) {
        this.a(n2, view);
        Drawable drawable = this.getSelector();
        if (drawable == null) return;
        if (n2 == -1) return;
        a.a(drawable, f2, f3);
    }

    protected void a(Canvas canvas) {
        if (this.a.isEmpty()) return;
        Drawable drawable = this.getSelector();
        if (drawable == null) return;
        drawable.setBounds(this.a);
        drawable.draw(canvas);
    }

    protected boolean a() {
        return false;
    }

    protected void b() {
        Drawable drawable = this.getSelector();
        if (drawable == null) return;
        if (!this.c()) return;
        drawable.setState(this.getDrawableState());
    }

    protected void b(int n2, View view) {
        Rect rect = this.a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.b;
        rect.top -= this.c;
        rect.right += this.d;
        rect.bottom += this.e;
        try {
            boolean bl2 = this.h.getBoolean((Object)this);
            if (view.isEnabled() == bl2) return;
            Field field = this.h;
            boolean bl3 = !bl2;
            field.set((Object)this, bl3);
            if (n2 == -1) return;
            this.refreshDrawableState();
            return;
        }
        catch (IllegalAccessException var4_7) {
            var4_7.printStackTrace();
            return;
        }
    }

    protected boolean c() {
        if (!this.a()) return false;
        if (!this.isPressed()) return false;
        return true;
    }

    protected void dispatchDraw(Canvas canvas) {
        this.a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            default: {
                return super.onTouchEvent(motionEvent);
            }
            case 0: 
        }
        this.f = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        dt dt2 = drawable != null ? new dt(drawable) : null;
        this.i = dt2;
        super.setSelector((Drawable)this.i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.b = rect.left;
        this.c = rect.top;
        this.d = rect.right;
        this.e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean bl2) {
        if (this.i == null) return;
        this.i.a(bl2);
    }
}

