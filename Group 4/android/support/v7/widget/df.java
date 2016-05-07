/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.f.h;
import android.support.v4.widget.ag;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.support.v7.widget.bc;
import android.support.v7.widget.dg;
import android.support.v7.widget.dh;
import android.support.v7.widget.di;
import android.support.v7.widget.dj;
import android.support.v7.widget.dn;
import android.support.v7.widget.do;
import android.support.v7.widget.dp;
import android.support.v7.widget.dq;
import android.support.v7.widget.dr;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import java.util.Locale;

public class df {
    private static Method a;
    private static Method c;
    private final dn A;
    private Runnable B;
    private final Handler C;
    private Rect D;
    private boolean E;
    private int F;
    int b = Integer.MAX_VALUE;
    private Context d;
    private PopupWindow e;
    private ListAdapter f;
    private dj g;
    private int h = -2;
    private int i = -2;
    private int j;
    private int k;
    private int l = 1002;
    private boolean m;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private View q;
    private int r = 0;
    private DataSetObserver s;
    private View t;
    private Drawable u;
    private AdapterView.OnItemClickListener v;
    private AdapterView.OnItemSelectedListener w;
    private final dr x;
    private final dq y;
    private final dp z;

    static {
        try {
            Class[] arrclass = new Class[]{Boolean.TYPE};
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", arrclass);
        }
        catch (NoSuchMethodException var0_2) {
            Log.i((String)"ListPopupWindow", (String)"Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            Class[] arrclass = new Class[]{View.class, Integer.TYPE, Boolean.TYPE};
            c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", arrclass);
            return;
        }
        catch (NoSuchMethodException var2_3) {
            Log.i((String)"ListPopupWindow", (String)"Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            return;
        }
    }

    public df(Context context) {
        this(context, null, b.listPopupWindowStyle);
    }

    public df(Context context, AttributeSet attributeSet, int n2) {
        this(context, attributeSet, n2, 0);
    }

    public df(Context context, AttributeSet attributeSet, int n2, int n3) {
        this.x = new dr(this, null);
        this.y = new dq(this, null);
        this.z = new dp(this, null);
        this.A = new dn(this, null);
        this.D = new Rect();
        this.d = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.ListPopupWindow, n2, n3);
        this.j = typedArray.getDimensionPixelOffset(l.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.k = typedArray.getDimensionPixelOffset(l.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.k != 0) {
            this.m = true;
        }
        typedArray.recycle();
        this.e = new bc(context, attributeSet, n2);
        this.e.setInputMethodMode(1);
        this.F = h.a(this.d.getResources().getConfiguration().locale);
    }

    private int a(View view, int n2, boolean bl2) {
        if (c == null) return this.e.getMaxAvailableHeight(view, n2);
        try {
            Method method = c;
            PopupWindow popupWindow = this.e;
            Object[] arrobject = new Object[]{view, n2, bl2};
            return (Integer)method.invoke((Object)popupWindow, arrobject);
        }
        catch (Exception var4_8) {
            Log.i((String)"ListPopupWindow", (String)"Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
        }
        return this.e.getMaxAvailableHeight(view, n2);
    }

    static /* synthetic */ dj a(df df2) {
        return df2.g;
    }

    private void a() {
        if (this.q == null) return;
        ViewParent viewParent = this.q.getParent();
        if (!(viewParent instanceof ViewGroup)) return;
        ((ViewGroup)viewParent).removeView(this.q);
    }

    /*
     * Unable to fully structure code
     */
    private int b() {
        var1_1 = 1;
        if (this.g != null) ** GOTO lbl45
        var13_2 = this.d;
        this.B = new dh(this);
        var14_3 = this.E == false ? var1_1 : 0;
        this.g = new dj(var13_2, (boolean)var14_3);
        if (this.u != null) {
            this.g.setSelector(this.u);
        }
        this.g.setAdapter(this.f);
        this.g.setOnItemClickListener(this.v);
        this.g.setFocusable((boolean)var1_1);
        this.g.setFocusableInTouchMode((boolean)var1_1);
        this.g.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)new di(this));
        this.g.setOnScrollListener((AbsListView.OnScrollListener)this.z);
        if (this.w != null) {
            this.g.setOnItemSelectedListener(this.w);
        }
        var15_4 = this.g;
        var16_5 = this.q;
        if (var16_5 == null) ** GOTO lbl53
        var17_6 = new LinearLayout(var13_2);
        var17_6.setOrientation(var1_1);
        var18_7 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        switch (this.r) {
            default: {
                Log.e((String)"ListPopupWindow", (String)("Invalid hint position " + this.r));
                break;
            }
            case 1: {
                var17_6.addView((View)var15_4, (ViewGroup.LayoutParams)var18_7);
                var17_6.addView(var16_5);
                break;
            }
            case 0: {
                var17_6.addView(var16_5);
                var17_6.addView((View)var15_4, (ViewGroup.LayoutParams)var18_7);
            }
        }
        if (this.i >= 0) {
            var20_8 = this.i;
            var19_9 = Integer.MIN_VALUE;
        } else {
            var19_9 = 0;
            var20_8 = 0;
        }
        var16_5.measure(View.MeasureSpec.makeMeasureSpec((int)var20_8, (int)var19_9), 0);
        var21_10 = (LinearLayout.LayoutParams)var16_5.getLayoutParams();
        var22_11 = var16_5.getMeasuredHeight() + var21_10.topMargin + var21_10.bottomMargin;
        var23_12 = var17_6;
        ** GOTO lbl55
lbl45: // 1 sources:
        (ViewGroup)this.e.getContentView();
        var3_18 = this.q;
        if (var3_18 != null) {
            var12_19 = (LinearLayout.LayoutParams)var3_18.getLayoutParams();
            var4_13 = var3_18.getMeasuredHeight() + var12_19.topMargin + var12_19.bottomMargin;
        } else {
            var4_13 = 0;
        }
        ** GOTO lbl57
lbl53: // 1 sources:
        var23_12 = var15_4;
        var22_11 = 0;
lbl55: // 2 sources:
        this.e.setContentView((View)var23_12);
        var4_13 = var22_11;
lbl57: // 3 sources:
        if ((var5_14 = this.e.getBackground()) == null) ** GOTO lbl64
        var5_14.getPadding(this.D);
        var11_15 = this.D.top + this.D.bottom;
        if (this.m) ** GOTO lbl67
        this.k = - this.D.top;
        var6_16 = var11_15;
        ** GOTO lbl68
lbl64: // 1 sources:
        this.D.setEmpty();
        var6_16 = 0;
        ** GOTO lbl68
lbl67: // 1 sources:
        var6_16 = var11_15;
lbl68: // 3 sources:
        if (this.e.getInputMethodMode() != 2) {
            var1_1 = 0;
        }
        var7_17 = this.a(this.e(), this.k, (boolean)var1_1);
        if (this.o != false) return var7_17 + var6_16;
        if (this.h == -1) {
            return var7_17 + var6_16;
        }
        switch (this.i) {
            default: {
                var8_20 = View.MeasureSpec.makeMeasureSpec((int)this.i, (int)1073741824);
                break;
            }
            case -2: {
                var8_20 = View.MeasureSpec.makeMeasureSpec((int)(this.d.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right)), (int)Integer.MIN_VALUE);
                break;
            }
            case -1: {
                var8_20 = View.MeasureSpec.makeMeasureSpec((int)(this.d.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right)), (int)1073741824);
            }
        }
        if ((var9_21 = this.g.a(var8_20, 0, -1, var7_17 - var4_13, -1)) <= 0) return var9_21 + var4_13;
        var4_13 += var6_16;
        return var9_21 + var4_13;
    }

    static /* synthetic */ PopupWindow b(df df2) {
        return df2.e;
    }

    private void b(boolean bl2) {
        if (a == null) return;
        try {
            Method method = a;
            PopupWindow popupWindow = this.e;
            Object[] arrobject = new Object[]{bl2};
            method.invoke((Object)popupWindow, arrobject);
            return;
        }
        catch (Exception var2_5) {
            Log.i((String)"ListPopupWindow", (String)"Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            return;
        }
    }

    static /* synthetic */ dr c(df df2) {
        return df2.x;
    }

    static /* synthetic */ Handler d(df df2) {
        return df2.C;
    }

    public void a(int n2) {
        this.r = n2;
    }

    public void a(Drawable drawable) {
        this.e.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.t = view;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.s == null) {
            this.s = new do(this, null);
        } else if (this.f != null) {
            this.f.unregisterDataSetObserver(this.s);
        }
        this.f = listAdapter;
        if (this.f != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        if (this.g == null) return;
        this.g.setAdapter(this.f);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.e.setOnDismissListener(onDismissListener);
    }

    public void a(boolean bl2) {
        this.E = bl2;
        this.e.setFocusable(bl2);
    }

    public void b(int n2) {
        this.j = n2;
    }

    public void c() {
        boolean bl2 = true;
        int n2 = -1;
        int n3 = this.b();
        boolean bl3 = this.l();
        ag.a(this.e, this.l);
        if (this.e.isShowing()) {
            int n4;
            int n5 = this.i == n2 ? n2 : (this.i == -2 ? this.e().getWidth() : this.i);
            if (this.h == n2) {
                if (!bl3) {
                    n3 = n2;
                }
                if (bl3) {
                    PopupWindow popupWindow = this.e;
                    int n6 = this.i == n2 ? n2 : 0;
                    popupWindow.setWidth(n6);
                    this.e.setHeight(0);
                    n4 = n3;
                } else {
                    PopupWindow popupWindow = this.e;
                    int n7 = this.i == n2 ? n2 : 0;
                    popupWindow.setWidth(n7);
                    this.e.setHeight(n2);
                    n4 = n3;
                }
            } else {
                n4 = this.h == -2 ? n3 : this.h;
            }
            PopupWindow popupWindow = this.e;
            boolean bl4 = this.p;
            boolean bl5 = false;
            if (!bl4) {
                boolean bl6 = this.o;
                bl5 = false;
                if (!bl6) {
                    bl5 = bl2;
                }
            }
            popupWindow.setOutsideTouchable(bl5);
            PopupWindow popupWindow2 = this.e;
            View view = this.e();
            int n8 = this.j;
            int n9 = this.k;
            if (n5 < 0) {
                n5 = n2;
            }
            if (n4 >= 0) {
                n2 = n4;
            }
            popupWindow2.update(view, n8, n9, n5, n2);
            return;
        }
        int n10 = this.i == n2 ? n2 : (this.i == -2 ? this.e().getWidth() : this.i);
        if (this.h == n2) {
            n3 = n2;
        } else if (this.h != -2) {
            n3 = this.h;
        }
        this.e.setWidth(n10);
        this.e.setHeight(n3);
        this.b(bl2);
        PopupWindow popupWindow = this.e;
        if (this.p || this.o) {
            bl2 = false;
        }
        popupWindow.setOutsideTouchable(bl2);
        this.e.setTouchInterceptor((View.OnTouchListener)this.y);
        ag.a(this.e, this.e(), this.j, this.k, this.n);
        this.g.setSelection(n2);
        if (!this.E || this.g.isInTouchMode()) {
            this.j();
        }
        if (this.E) return;
        this.C.post((Runnable)this.A);
    }

    public void c(int n2) {
        this.k = n2;
        this.m = true;
    }

    public Drawable d() {
        return this.e.getBackground();
    }

    public void d(int n2) {
        this.n = n2;
    }

    public View e() {
        return this.t;
    }

    public void e(int n2) {
        this.i = n2;
    }

    public int f() {
        return this.j;
    }

    public void f(int n2) {
        Drawable drawable = this.e.getBackground();
        if (drawable != null) {
            drawable.getPadding(this.D);
            this.i = n2 + (this.D.left + this.D.right);
            return;
        }
        this.e(n2);
    }

    public int g() {
        if (this.m) return this.k;
        return 0;
    }

    public void g(int n2) {
        this.e.setInputMethodMode(n2);
    }

    public int h() {
        return this.i;
    }

    public void h(int n2) {
        dj dj2 = this.g;
        if (!this.k()) return;
        if (dj2 == null) return;
        dj.a(dj2, false);
        dj2.setSelection(n2);
        if (Build.VERSION.SDK_INT < 11) return;
        if (dj2.getChoiceMode() == 0) return;
        dj2.setItemChecked(n2, true);
    }

    public void i() {
        this.e.dismiss();
        this.a();
        this.e.setContentView(null);
        this.g = null;
        this.C.removeCallbacks((Runnable)this.x);
    }

    public void j() {
        dj dj2 = this.g;
        if (dj2 == null) return;
        dj.a(dj2, true);
        dj2.requestLayout();
    }

    public boolean k() {
        return this.e.isShowing();
    }

    public boolean l() {
        if (this.e.getInputMethodMode() != 2) return false;
        return true;
    }

    public ListView m() {
        return this.g;
    }
}

