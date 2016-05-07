/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.design.h;
import android.support.design.i;
import android.support.design.widget.CoordinatorLayout$SavedState;
import android.support.design.widget.bt;
import android.support.design.widget.cf;
import android.support.design.widget.o;
import android.support.design.widget.p;
import android.support.design.widget.q;
import android.support.design.widget.r;
import android.support.design.widget.s;
import android.support.design.widget.t;
import android.support.design.widget.u;
import android.support.design.widget.w;
import android.support.design.widget.x;
import android.support.design.widget.y;
import android.support.v4.b.c;
import android.support.v4.c.a.a;
import android.support.v4.h.at;
import android.support.v4.h.be;
import android.support.v4.h.bf;
import android.support.v4.h.bg;
import android.support.v4.h.bo;
import android.support.v4.h.dw;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CoordinatorLayout
extends ViewGroup
implements be {
    static final String a;
    static final Class[] b;
    static final ThreadLocal c;
    static final Comparator e;
    static final x f;
    final Comparator d;
    private final List g;
    private final List h;
    private final List i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private final int[] m;
    private Paint n;
    private boolean o;
    private int[] p;
    private View q;
    private View r;
    private View s;
    private u t;
    private boolean u;
    private dw v;
    private boolean w;
    private Drawable x;
    private ViewGroup.OnHierarchyChangeListener y;
    private final bf z;

    static {
        Package package_ = CoordinatorLayout.class.getPackage();
        String string = package_ != null ? package_.getName() : null;
        a = string;
        if (Build.VERSION.SDK_INT >= 21) {
            e = new w();
            f = new y();
        } else {
            e = null;
            f = null;
        }
        b = new Class[]{Context.class, AttributeSet.class};
        c = new ThreadLocal();
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.d = new o(this);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        this.m = new int[2];
        this.z = new bf(this);
        bt.a(context);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.CoordinatorLayout, n2, h.Widget_Design_CoordinatorLayout);
        int n3 = typedArray.getResourceId(i.CoordinatorLayout_keylines, 0);
        if (n3 != 0) {
            Resources resources = context.getResources();
            this.p = resources.getIntArray(n3);
            float f2 = resources.getDisplayMetrics().density;
            int n4 = this.p.length;
            for (int i2 = 0; i2 < n4; ++i2) {
                int[] arrn = this.p;
                arrn[i2] = (int)(f2 * (float)arrn[i2]);
            }
        }
        this.x = typedArray.getDrawable(i.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        if (f != null) {
            f.a((View)this, new p(this, null));
        }
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)new s(this, null));
    }

    private int a(int n2) {
        if (this.p == null) {
            Log.e((String)"CoordinatorLayout", (String)("No keylines defined for " + this + " - attempted index lookup " + n2));
            return 0;
        }
        if (n2 >= 0) {
            if (n2 < this.p.length) return this.p[n2];
        }
        Log.e((String)"CoordinatorLayout", (String)("Keyline index " + n2 + " out of range for " + this));
        return 0;
    }

    static q a(Context context, AttributeSet attributeSet, String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        if (string.startsWith(".")) {
            string = context.getPackageName() + string;
        } else if (string.indexOf(46) < 0 && !TextUtils.isEmpty((CharSequence)a)) {
            string = a + '.' + string;
        }
        try {
            HashMap hashMap;
            Constructor constructor;
            HashMap hashMap2 = (HashMap)c.get();
            if (hashMap2 == null) {
                HashMap hashMap3 = new HashMap();
                c.set(hashMap3);
                hashMap = hashMap3;
            } else {
                hashMap = hashMap2;
            }
            if ((constructor = (Constructor)hashMap.get(string)) != null) return (q)constructor.newInstance(new Object[]{context, attributeSet});
            constructor = Class.forName(string, true, context.getClassLoader()).getConstructor(b);
            constructor.setAccessible(true);
            hashMap.put(string, constructor);
            return (q)constructor.newInstance(new Object[]{context, attributeSet});
        }
        catch (Exception var3_8) {
            throw new RuntimeException("Could not inflate Behavior subclass " + string, var3_8);
        }
    }

    static /* synthetic */ dw a(CoordinatorLayout coordinatorLayout, dw dw2) {
        return coordinatorLayout.a(dw2);
    }

    private dw a(dw dw2) {
        boolean bl2 = true;
        if (this.v == dw2) return dw2;
        this.v = dw2;
        boolean bl3 = dw2 != null && dw2.b() > 0 ? bl2 : false;
        this.w = bl3;
        if (this.w || this.getBackground() != null) {
            bl2 = false;
        }
        this.setWillNotDraw(bl2);
        dw2 = this.b(dw2);
        this.requestLayout();
        return dw2;
    }

    static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.y;
    }

    private void a(View view, View view2, int n2) {
        (t)view.getLayoutParams();
        Rect rect = this.j;
        Rect rect2 = this.k;
        this.a(view2, rect);
        this.a(view, n2, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void a(List list) {
        list.clear();
        boolean bl2 = this.isChildrenDrawingOrderEnabled();
        int n2 = this.getChildCount();
        int n3 = n2 - 1;
        do {
            if (n3 < 0) {
                if (e == null) return;
                Collections.sort(list, e);
                return;
            }
            int n4 = bl2 ? this.getChildDrawingOrder(n2, n3) : n3;
            list.add(this.getChildAt(n4));
            --n3;
        } while (true);
    }

    private static void a(List list, Comparator comparator) {
        if (list == null) return;
        if (list.size() < 2) {
            return;
        }
        View[] arrview = new View[list.size()];
        list.toArray((T[])arrview);
        int n2 = arrview.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            for (int i3 = i2 + 1; i3 < n2; ++i3) {
                if (comparator.compare(arrview[i3], arrview[n3]) >= 0) continue;
                n3 = i3;
            }
            if (i2 == n3) continue;
            View view = arrview[n3];
            arrview[n3] = arrview[i2];
            arrview[i2] = view;
        }
        list.clear();
        int n4 = 0;
        while (n4 < n2) {
            list.add(arrview[n4]);
            ++n4;
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(MotionEvent var1_1, int var2_2) {
        block13 : {
            var3_3 = false;
            var4_4 = false;
            var5_5 = null;
            var6_6 = at.a(var1_1);
            var7_7 = this.h;
            this.a(var7_7);
            var8_8 = var7_7.size();
            for (var9_9 = 0; var9_9 < var8_8; ++var9_9) {
                var11_11 = (View)var7_7.get(var9_9);
                var12_12 = (t)var11_11.getLayoutParams();
                var13_13 = var12_12.b();
                if (!var3_3 && !var4_4 || var6_6 == 0) ** GOTO lbl29
                if (var13_13 == null) ** GOTO lbl47
                if (var5_5 == null) {
                    var22_20 = SystemClock.uptimeMillis();
                    var19_19 = MotionEvent.obtain((long)var22_20, (long)var22_20, (int)3, (float)0.0f, (float)0.0f, (int)0);
                } else {
                    var19_19 = var5_5;
                }
                switch (var2_2) {
                    case 0: {
                        var13_13.a(this, var11_11, var19_19);
                    }
                    default: {
                        break;
                    }
                    case 1: {
                        var13_13.b(this, var11_11, var19_19);
                    }
                }
                var18_18 = var4_4;
                var10_10 = var3_3;
                ** GOTO lbl50
lbl29: // 1 sources:
                if (!var3_3 && var13_13 != null) {
                    switch (var2_2) {
                        case 0: {
                            var3_3 = var13_13.a(this, var11_11, var1_1);
                            break;
                        }
                        case 1: {
                            var3_3 = var13_13.b(this, var11_11, var1_1);
                        }
                    }
                    if (var3_3) {
                        this.q = var11_11;
                    }
                }
                var10_10 = var3_3;
                var14_14 = var12_12.e();
                var15_15 = var12_12.a(this, var11_11);
                var16_16 = var15_15 != false && var14_14 == false;
                if (var15_15 && !var16_16) break block13;
                var17_17 = var5_5;
                var18_18 = var16_16;
                var19_19 = var17_17;
                ** GOTO lbl50
lbl47: // 1 sources:
                var19_19 = var5_5;
                var10_10 = var3_3;
                var18_18 = var4_4;
lbl50: // 3 sources:
                var4_4 = var18_18;
                var3_3 = var10_10;
                var5_5 = var19_19;
            }
            var10_10 = var3_3;
        }
        var7_7.clear();
        return var10_10;
    }

    private static int b(int n2) {
        if (n2 != 0) return n2;
        return 8388659;
    }

    private dw b(dw dw2) {
        if (dw2.e()) {
            return dw2;
        }
        int n2 = this.getChildCount();
        int n3 = 0;
        dw dw3 = dw2;
        while (n3 < n2) {
            q q2;
            dw dw4;
            View view = this.getChildAt(n3);
            if (bo.t(view) && (q2 = ((t)view.getLayoutParams()).b()) != null) {
                dw4 = q2.a(this, view, dw3);
                if (dw4.e()) {
                    return dw4;
                }
            } else {
                dw4 = dw3;
            }
            ++n3;
            dw3 = dw4;
        }
        return dw3;
    }

    private void b(View view, int n2, int n3) {
        t t2 = (t)view.getLayoutParams();
        int n4 = android.support.v4.h.q.a(CoordinatorLayout.c(t2.c), n3);
        int n5 = n4 & 7;
        int n6 = n4 & 112;
        int n7 = this.getWidth();
        int n8 = this.getHeight();
        int n9 = view.getMeasuredWidth();
        int n10 = view.getMeasuredHeight();
        if (n3 == 1) {
            n2 = n7 - n2;
        }
        int n11 = this.a(n2) - n9;
        switch (n5) {
            case 5: {
                n11 += n9;
            }
            default: {
                break;
            }
            case 1: {
                n11 += n9 / 2;
            }
        }
        int n12 = 0;
        switch (n6) {
            case 80: {
                n12 = 0 + n10;
            }
            default: {
                break;
            }
            case 16: {
                n12 = 0 + n10 / 2;
            }
        }
        int n13 = Math.max(this.getPaddingLeft() + t2.leftMargin, Math.min(n11, n7 - this.getPaddingRight() - n9 - t2.rightMargin));
        int n14 = Math.max(this.getPaddingTop() + t2.topMargin, Math.min(n12, n8 - this.getPaddingBottom() - n10 - t2.bottomMargin));
        view.layout(n13, n14, n13 + n9, n14 + n10);
    }

    private static int c(int n2) {
        if (n2 != 0) return n2;
        return 8388661;
    }

    private void c(View view, int n2) {
        t t2 = (t)view.getLayoutParams();
        Rect rect = this.j;
        rect.set(this.getPaddingLeft() + t2.leftMargin, this.getPaddingTop() + t2.topMargin, this.getWidth() - this.getPaddingRight() - t2.rightMargin, this.getHeight() - this.getPaddingBottom() - t2.bottomMargin);
        if (this.v != null && bo.t((View)this) && !bo.t(view)) {
            rect.left += this.v.a();
            rect.top += this.v.b();
            rect.right -= this.v.c();
            rect.bottom -= this.v.d();
        }
        Rect rect2 = this.k;
        android.support.v4.h.q.a(CoordinatorLayout.b(t2.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, n2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int d(int n2) {
        if (n2 != 0) return n2;
        return 17;
    }

    private void e() {
        int n2 = 0;
        if (this.q != null) {
            q q2 = ((t)this.q.getLayoutParams()).b();
            if (q2 != null) {
                long l2 = SystemClock.uptimeMillis();
                MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
                q2.b(this, this.q, motionEvent);
                motionEvent.recycle();
            }
            this.q = null;
        }
        int n3 = this.getChildCount();
        while (n2 < n3) {
            ((t)this.getChildAt(n2).getLayoutParams()).f();
            ++n2;
        }
    }

    private void f() {
        this.g.clear();
        int n2 = 0;
        int n3 = this.getChildCount();
        do {
            if (n2 >= n3) {
                CoordinatorLayout.a(this.g, this.d);
                return;
            }
            View view = this.getChildAt(n2);
            this.a(view).b(this, view);
            this.g.add(view);
            ++n2;
        } while (true);
    }

    public t a(AttributeSet attributeSet) {
        return new t(this.getContext(), attributeSet);
    }

    t a(View view) {
        t t2 = (t)view.getLayoutParams();
        if (t2.b) return t2;
        r r2 = null;
        for (Class class_ = view.getClass(); class_ != null; class_ = class_.getSuperclass()) {
            r2 = (r)class_.getAnnotation(r.class);
            if (r2 == null) {
                continue;
            }
            r r3 = r2;
            if (r3 == null) break;
            try {
                t2.a((q)r3.a().newInstance());
                break;
            }
            catch (Exception var6_6) {
                Log.e((String)"CoordinatorLayout", (String)("Default behavior class " + r3.a().getName() + " could not be instantiated. Did you forget a default constructor?"), (Throwable)var6_6);
                break;
            }
        }
        t2.b = true;
        return t2;
    }

    protected t a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof t) {
            return new t((t)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new t(layoutParams);
        return new t((ViewGroup.MarginLayoutParams)layoutParams);
    }

    /*
     * Unable to fully structure code
     */
    void a() {
        var1_1 = this.getChildCount();
        var2_2 = 0;
        do {
            var3_3 = false;
            if (var2_2 >= var1_1) ** GOTO lbl8
            if (this.e(this.getChildAt(var2_2))) {
                var3_3 = true;
lbl8: // 2 sources:
                if (var3_3 == this.u) return;
                if (!var3_3) break;
                this.b();
                return;
            }
            ++var2_2;
        } while (true);
        this.c();
    }

    public void a(View view, int n2) {
        t t2 = (t)view.getLayoutParams();
        if (t2.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (t2.g != null) {
            this.a(view, t2.g, n2);
            return;
        }
        if (t2.e >= 0) {
            this.b(view, t2.e, n2);
            return;
        }
        this.c(view, n2);
    }

    public void a(View view, int n2, int n3, int n4, int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }

    /*
     * Exception decompiling
     */
    void a(View var1_1, int var2_2, Rect var3_3, Rect var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:486)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:425)
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

    void a(View view, Rect rect) {
        cf.b(this, view, rect);
    }

    void a(View view, boolean bl2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (bl2) {
            this.a(view, rect);
            return;
        }
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /*
     * Unable to fully structure code
     */
    void a(boolean var1_1) {
        var2_2 = bo.h((View)this);
        var3_3 = this.g.size();
        var4_4 = 0;
        block0 : do {
            if (var4_4 >= var3_3) return;
            var5_5 = (View)this.g.get(var4_4);
            var6_6 = (t)var5_5.getLayoutParams();
            for (var7_7 = 0; var7_7 < var4_4; ++var7_7) {
                var15_15 = (View)this.g.get(var7_7);
                if (var6_6.h != var15_15) continue;
                this.b(var5_5, var2_2);
            }
            var8_8 = this.j;
            var9_9 = this.k;
            this.c(var5_5, var8_8);
            this.a(var5_5, true, var9_9);
            if (var8_8.equals((Object)var9_9)) ** GOTO lbl-1000
            this.b(var5_5, var9_9);
            var10_10 = var4_4 + 1;
            do {
                if (var10_10 >= var3_3) lbl-1000: // 2 sources:
                {
                    ++var4_4;
                    continue block0;
                }
                var11_11 = (View)this.g.get(var10_10);
                var12_12 = (t)var11_11.getLayoutParams();
                var13_13 = var12_12.b();
                if (var13_13 != null && var13_13.b(this, var11_11, var5_5)) {
                    if (!var1_1 && var12_12.i()) {
                        var12_12.j();
                    } else {
                        var14_14 = var13_13.c(this, var11_11, var5_5);
                        if (var1_1) {
                            var12_12.b(var14_14);
                        }
                    }
                }
                ++var10_10;
            } while (true);
            break;
        } while (true);
    }

    public boolean a(View view, int n2, int n3) {
        Rect rect = this.j;
        this.a(view, rect);
        return rect.contains(n2, n3);
    }

    public boolean a(View view, View view2) {
        if (view.getVisibility() != 0) return false;
        if (view2.getVisibility() != 0) return false;
        Rect rect = this.j;
        boolean bl2 = view.getParent() != this;
        this.a(view, bl2, rect);
        Rect rect2 = this.k;
        boolean bl3 = view2.getParent() != this;
        this.a(view2, bl3, rect2);
        if (rect.left > rect2.right) return false;
        if (rect.top > rect2.bottom) return false;
        if (rect.right < rect2.left) return false;
        if (rect.bottom < rect2.top) return false;
        return true;
    }

    void b() {
        if (this.o) {
            if (this.t == null) {
                this.t = new u(this);
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.t);
        }
        this.u = true;
    }

    void b(View view) {
        int n2 = this.g.size();
        int n3 = 0;
        boolean bl2 = false;
        while (n3 < n2) {
            boolean bl3;
            View view2 = (View)this.g.get(n3);
            if (view2 == view) {
                bl3 = true;
            } else {
                t t2;
                q q2;
                if (bl2 && (q2 = (t2 = (t)view2.getLayoutParams()).b()) != null && t2.a(this, view2, view)) {
                    q2.d(this, view2, view);
                }
                bl3 = bl2;
            }
            ++n3;
            bl2 = bl3;
        }
    }

    void b(View view, int n2) {
        q q2;
        t t2 = (t)view.getLayoutParams();
        if (t2.g == null) return;
        Rect rect = this.j;
        Rect rect2 = this.k;
        Rect rect3 = this.l;
        this.a(t2.g, rect);
        this.a(view, false, rect2);
        this.a(view, n2, rect, rect3);
        int n3 = rect3.left - rect2.left;
        int n4 = rect3.top - rect2.top;
        if (n3 != 0) {
            view.offsetLeftAndRight(n3);
        }
        if (n4 != 0) {
            view.offsetTopAndBottom(n4);
        }
        if (n3 == 0) {
            if (n4 == 0) return;
        }
        if ((q2 = t2.b()) == null) return;
        q2.c(this, view, t2.g);
    }

    void b(View view, Rect rect) {
        ((t)view.getLayoutParams()).a(rect);
    }

    void c() {
        if (this.o && this.t != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.t);
        }
        this.u = false;
    }

    public void c(View view) {
        int n2 = this.g.size();
        int n3 = 0;
        boolean bl2 = false;
        while (n3 < n2) {
            boolean bl3;
            View view2 = (View)this.g.get(n3);
            if (view2 == view) {
                bl3 = true;
            } else {
                t t2;
                q q2;
                if (bl2 && (q2 = (t2 = (t)view2.getLayoutParams()).b()) != null && t2.a(this, view2, view)) {
                    q2.c(this, view2, view);
                }
                bl3 = bl2;
            }
            ++n3;
            bl2 = bl3;
        }
    }

    void c(View view, Rect rect) {
        rect.set(((t)view.getLayoutParams()).c());
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof t)) return false;
        if (!super.checkLayoutParams(layoutParams)) return false;
        return true;
    }

    protected t d() {
        return new t(-2, -2);
    }

    public List d(View view) {
        t t2 = (t)view.getLayoutParams();
        List list = this.i;
        list.clear();
        int n2 = this.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view2 = this.getChildAt(n3);
            if (view2 != view && t2.a(this, view, view2)) {
                list.add(view2);
            }
            ++n3;
        }
        return list;
    }

    protected boolean drawChild(Canvas canvas, View view, long l2) {
        t t2 = (t)view.getLayoutParams();
        if (t2.a == null) return super.drawChild(canvas, view, l2);
        if (t2.a.d(this, view) <= 0.0f) return super.drawChild(canvas, view, l2);
        if (this.n == null) {
            this.n = new Paint();
        }
        this.n.setColor(t2.a.c(this, view));
        canvas.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), this.n);
        return super.drawChild(canvas, view, l2);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arrn = this.getDrawableState();
        Drawable drawable = this.x;
        boolean bl2 = false;
        if (drawable == null) return;
        boolean bl3 = drawable.isStateful();
        bl2 = false;
        if (!bl3) return;
        bl2 = false | drawable.setState(arrn);
        if (!bl2) return;
        this.invalidate();
    }

    boolean e(View view) {
        t t2 = (t)view.getLayoutParams();
        if (t2.g != null) {
            return true;
        }
        int n2 = this.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view2 = this.getChildAt(n3);
            if (view2 != view && t2.a(this, view, view2)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.d();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.z.a();
    }

    public Drawable getStatusBarBackground() {
        return this.x;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e();
        if (this.u) {
            if (this.t == null) {
                this.t = new u(this);
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.t);
        }
        if (this.v == null && bo.t((View)this)) {
            bo.s((View)this);
        }
        this.o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e();
        if (this.u && this.t != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.t);
        }
        if (this.s != null) {
            this.onStopNestedScroll(this.s);
        }
        this.o = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.w) return;
        if (this.x == null) return;
        int n2 = this.v != null ? this.v.b() : 0;
        if (n2 <= 0) return;
        this.x.setBounds(0, 0, this.getWidth(), n2);
        this.x.draw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n2 = at.a(motionEvent);
        if (n2 == 0) {
            this.e();
        }
        boolean bl2 = this.a(motionEvent, 0);
        if (false) {
            ((}
    }
    java.lang.NullPointerException
    
    