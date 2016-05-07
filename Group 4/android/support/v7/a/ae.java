/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.bf;
import android.support.v4.h.bo;
import android.support.v4.h.cn;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.a.a;
import android.support.v7.a.af;
import android.support.v7.a.ag;
import android.support.v7.a.ah;
import android.support.v7.a.ai;
import android.support.v7.a.aj;
import android.support.v7.a.al;
import android.support.v7.a.am;
import android.support.v7.a.an;
import android.support.v7.a.ap;
import android.support.v7.a.aq;
import android.support.v7.a.ar;
import android.support.v7.a.at;
import android.support.v7.a.be;
import android.support.v7.a.bp;
import android.support.v7.a.v;
import android.support.v7.a.x;
import android.support.v7.b.b;
import android.support.v7.b.d;
import android.support.v7.b.g;
import android.support.v7.b.i;
import android.support.v7.b.l;
import android.support.v7.view.c;
import android.support.v7.view.e;
import android.support.v7.view.f;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.y;
import android.support.v7.view.menu.z;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.cd;
import android.support.v7.widget.ce;
import android.support.v7.widget.ct;
import android.support.v7.widget.cu;
import android.support.v7.widget.gz;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class ae
extends x
implements android.support.v4.h.af,
j {
    private boolean A;
    private aq[] B;
    private aq C;
    private boolean D;
    private boolean E;
    private int F;
    private final Runnable G;
    private boolean H;
    private Rect I;
    private Rect J;
    private at K;
    android.support.v7.view.b m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    dc q = null;
    private ce r;
    private am s;
    private ar t;
    private boolean u;
    private ViewGroup v;
    private TextView w;
    private View x;
    private boolean y;
    private boolean z;

    ae(Context context, Window window, v v2) {
        super(context, window, v2);
        this.G = new af(this);
    }

    static /* synthetic */ int a(ae ae2) {
        return ae2.F;
    }

    private aq a(int n2, boolean bl2) {
        aq aq2;
        aq aq3;
        aq[] arraq = this.B;
        if (arraq == null || arraq.length <= n2) {
            aq[] arraq2 = new aq[n2 + 1];
            if (arraq != null) {
                System.arraycopy(arraq, 0, arraq2, 0, arraq.length);
            }
            this.B = arraq2;
            arraq = arraq2;
        }
        if ((aq3 = arraq[n2]) != null) return aq3;
        arraq[n2] = aq2 = new aq(n2);
        return aq2;
    }

    static /* synthetic */ aq a(ae ae2, Menu menu) {
        return ae2.a(menu);
    }

    private aq a(Menu menu) {
        aq[] arraq = this.B;
        int n2 = arraq != null ? arraq.length : 0;
        int n3 = 0;
        while (n3 < n2) {
            aq aq2 = arraq[n3];
            if (aq2 != null && aq2.j == menu) {
                return aq2;
            }
            ++n3;
        }
        return null;
    }

    private void a(int n2, aq aq2, Menu menu) {
        if (menu == null) {
            if (aq2 == null && n2 >= 0 && n2 < this.B.length) {
                aq2 = this.B[n2];
            }
            if (aq2 != null) {
                menu = aq2.j;
            }
        }
        if (aq2 != null && !aq2.o) {
            return;
        }
        if (this.n()) return;
        this.c.onPanelClosed(n2, menu);
    }

    static /* synthetic */ void a(ae ae2, int n2) {
        ae2.e(n2);
    }

    static /* synthetic */ void a(ae ae2, int n2, aq aq2, Menu menu) {
        ae2.a(n2, aq2, menu);
    }

    static /* synthetic */ void a(ae ae2, aq aq2, boolean bl2) {
        ae2.a(aq2, bl2);
    }

    static /* synthetic */ void a(ae ae2, android.support.v7.view.menu.i i2) {
        ae2.b(i2);
    }

    private void a(aq aq2, KeyEvent keyEvent) {
        Window.Callback callback;
        ViewGroup.LayoutParams layoutParams;
        int n2 = -1;
        if (aq2.o) return;
        if (this.n()) {
            return;
        }
        if (aq2.a == 0) {
            Context context = this.a;
            boolean bl2 = (15 & context.getResources().getConfiguration().screenLayout) == 4;
            boolean bl3 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (bl2) {
                if (bl3) return;
            }
        }
        if ((callback = this.o()) != null && !callback.onMenuOpened(aq2.a, (Menu)aq2.j)) {
            this.a(aq2, true);
            return;
        }
        WindowManager windowManager = (WindowManager)this.a.getSystemService("window");
        if (windowManager == null) return;
        if (!this.b(aq2, keyEvent)) return;
        if (aq2.g == null || aq2.q) {
            if (aq2.g == null) {
                if (!this.a(aq2)) return;
                if (aq2.g == null) return;
            } else if (aq2.q && aq2.g.getChildCount() > 0) {
                aq2.g.removeAllViews();
            }
            if (!this.c(aq2)) return;
            if (!aq2.a()) return;
            ViewGroup.LayoutParams layoutParams2 = aq2.h.getLayoutParams();
            ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
            int n3 = aq2.b;
            aq2.g.setBackgroundResource(n3);
            ViewParent viewParent = aq2.h.getParent();
            if (viewParent != null && viewParent instanceof ViewGroup) {
                ((ViewGroup)viewParent).removeView(aq2.h);
            }
            aq2.g.addView(aq2.h, layoutParams3);
            if (!aq2.h.hasFocus()) {
                aq2.h.requestFocus();
            }
            n2 = -2;
        } else if (aq2.i == null || (layoutParams = aq2.i.getLayoutParams()) == null || layoutParams.width != n2) {
            n2 = -2;
        }
        aq2.n = false;
        WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(n2, -2, aq2.d, aq2.e, 1002, 8519680, -3);
        layoutParams4.gravity = aq2.c;
        layoutParams4.windowAnimations = aq2.f;
        windowManager.addView((View)aq2.g, (ViewGroup.LayoutParams)layoutParams4);
        aq2.o = true;
    }

    private void a(aq aq2, boolean bl2) {
        if (bl2 && aq2.a == 0 && this.r != null && this.r.e()) {
            this.b(aq2.j);
            return;
        }
        WindowManager windowManager = (WindowManager)this.a.getSystemService("window");
        if (windowManager != null && aq2.o && aq2.g != null) {
            windowManager.removeView((View)aq2.g);
            if (bl2) {
                this.a(aq2.a, aq2, null);
            }
        }
        aq2.m = false;
        aq2.n = false;
        aq2.o = false;
        aq2.h = null;
        aq2.q = true;
        if (this.C != aq2) return;
        this.C = null;
    }

    private void a(android.support.v7.view.menu.i i2, boolean bl2) {
        if (this.r != null && this.r.d() && (!cn.b(ViewConfiguration.get((Context)this.a)) || this.r.f())) {
            Window.Callback callback = this.o();
            if (this.r.e() && bl2) {
                this.r.h();
                if (this.n()) return;
                callback.onPanelClosed(108, (Menu)this.a((int)0, (boolean)true).j);
                return;
            }
            if (callback == null) return;
            if (this.n()) return;
            if (this.E && (1 & this.F) != 0) {
                this.b.getDecorView().removeCallbacks(this.G);
                this.G.run();
            }
            aq aq2 = this.a(0, true);
            if (aq2.j == null) return;
            if (aq2.r) return;
            if (!callback.onPreparePanel(0, aq2.i, (Menu)aq2.j)) return;
            callback.onMenuOpened(108, (Menu)aq2.j);
            this.r.g();
            return;
        }
        aq aq3 = this.a(0, true);
        aq3.q = true;
        this.a(aq3, false);
        this.a(aq3, null);
    }

    static /* synthetic */ boolean a(ae ae2, boolean bl2) {
        ae2.E = bl2;
        return bl2;
    }

    private boolean a(aq aq2) {
        aq2.a(this.l());
        aq2.g = new ap(this, aq2.l);
        aq2.c = 81;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(aq var1_1, int var2_2, KeyEvent var3_3, int var4_4) {
        var5_5 = var3_3.isSystem();
        var6_6 = false;
        if (var5_5) {
            return var6_6;
        }
        if (var1_1.m) ** GOTO lbl-1000
        var8_7 = this.b(var1_1, var3_3);
        var6_6 = false;
        if (var8_7) lbl-1000: // 2 sources:
        {
            var7_8 = var1_1.j;
            var6_6 = false;
            if (var7_8 != null) {
                var6_6 = var1_1.j.performShortcut(var2_2, var3_3, var4_4);
            }
        }
        if (var6_6 == false) return var6_6;
        if ((var4_4 & 1) != 0) return var6_6;
        if (this.r != null) return var6_6;
        this.a(var1_1, true);
        return var6_6;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View view = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == view) return false;
            if (!(viewParent2 instanceof View)) return false;
            if (bo.C((View)viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    static /* synthetic */ int b(ae ae2, int n2) {
        ae2.F = n2;
        return n2;
    }

    static /* synthetic */ void b(ae ae2) {
        ae2.w();
    }

    private void b(android.support.v7.view.menu.i i2) {
        if (this.A) {
            return;
        }
        this.A = true;
        this.r.j();
        Window.Callback callback = this.o();
        if (callback != null && !this.n()) {
            callback.onPanelClosed(108, (Menu)i2);
        }
        this.A = false;
    }

    /*
     * Unable to fully structure code
     */
    private boolean b(aq var1_1) {
        var2_2 = this.a;
        if (var1_1.a != 0 && var1_1.a != 108 || this.r == null) ** GOTO lbl-1000
        var3_3 = new TypedValue();
        var4_4 = var2_2.getTheme();
        var4_4.resolveAttribute(b.actionBarTheme, var3_3, true);
        if (var3_3.resourceId != 0) {
            var7_5 = var2_2.getResources().newTheme();
            var7_5.setTo(var4_4);
            var7_5.applyStyle(var3_3.resourceId, true);
            var7_5.resolveAttribute(b.actionBarWidgetTheme, var3_3, true);
        } else {
            var4_4.resolveAttribute(b.actionBarWidgetTheme, var3_3, true);
            var7_5 = null;
        }
        if (var3_3.resourceId == 0) ** GOTO lbl-1000
        if (var7_5 == null) {
            var7_5 = var2_2.getResources().newTheme();
            var7_5.setTo(var4_4);
        }
        var7_5.applyStyle(var3_3.resourceId, true);
        var8_6 = var7_5;
        if (var8_6 != null) {
            var9_7 = new e(var2_2, 0);
            var9_7.getTheme().setTo(var8_6);
        } else lbl-1000: // 3 sources:
        {
            var9_7 = var2_2;
        }
        var10_8 = new android.support.v7.view.menu.i((Context)var9_7);
        var10_8.a(this);
        var1_1.a(var10_8);
        return true;
    }

    private boolean b(aq aq2, KeyEvent keyEvent) {
        Window.Callback callback;
        if (this.n()) {
            return false;
        }
        if (aq2.m) {
            return true;
        }
        if (this.C != null && this.C != aq2) {
            this.a(this.C, false);
        }
        if ((callback = this.o()) != null) {
            aq2.i = callback.onCreatePanelView(aq2.a);
        }
        boolean bl2 = aq2.a == 0 || aq2.a == 108;
        if (bl2 && this.r != null) {
            this.r.i();
        }
        if (!(aq2.i != null || bl2 && this.k() instanceof be)) {
            if (aq2.j == null || aq2.r) {
                if (aq2.j == null) {
                    if (!this.b(aq2)) return false;
                    if (aq2.j == null) return false;
                }
                if (bl2 && this.r != null) {
                    if (this.s == null) {
                        this.s = new am(this, null);
                    }
                    this.r.a(aq2.j, this.s);
                }
                aq2.j.g();
                if (!callback.onCreatePanelMenu(aq2.a, (Menu)aq2.j)) {
                    aq2.a((android.support.v7.view.menu.i)null);
                    if (!bl2) return false;
                    if (this.r == null) return false;
                    this.r.a(null, this.s);
                    return false;
                }
                aq2.r = false;
            }
            aq2.j.g();
            if (aq2.s != null) {
                aq2.j.b(aq2.s);
                aq2.s = null;
            }
            if (!callback.onPreparePanel(0, aq2.i, (Menu)aq2.j)) {
                if (bl2 && this.r != null) {
                    this.r.a(null, this.s);
                }
                aq2.j.h();
                return false;
            }
            int n2 = keyEvent != null ? keyEvent.getDeviceId() : -1;
            boolean bl3 = KeyCharacterMap.load((int)n2).getKeyboardType() != 1;
            aq2.p = bl3;
            aq2.j.setQwertyMode(aq2.p);
            aq2.j.h();
        }
        aq2.m = true;
        aq2.n = false;
        this.C = aq2;
        return true;
    }

    static /* synthetic */ int c(ae ae2, int n2) {
        return ae2.f(n2);
    }

    private void c(int n2) {
        this.a(this.a(n2, true), true);
    }

    static /* synthetic */ void c(ae ae2) {
        ae2.u();
    }

    private boolean c(aq aq2) {
        if (aq2.i != null) {
            aq2.h = aq2.i;
            return true;
        }
        if (aq2.j == null) {
            return false;
        }
        if (this.t == null) {
            this.t = new ar(this, null);
        }
        aq2.h = (View)aq2.a(this.t);
        if (aq2.h == null) return false;
        return true;
    }

    private void d(int n2) {
        this.F |= 1 << n2;
        if (this.E) return;
        bo.a(this.b.getDecorView(), this.G);
        this.E = true;
    }

    static /* synthetic */ void d(ae ae2, int n2) {
        ae2.c(n2);
    }

    private boolean d(int n2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) return false;
        aq aq2 = this.a(n2, true);
        if (aq2.o) return false;
        return this.b(aq2, keyEvent);
    }

    private void e(int n2) {
        aq aq2 = this.a(n2, true);
        if (aq2.j != null) {
            Bundle bundle = new Bundle();
            aq2.j.a(bundle);
            if (bundle.size() > 0) {
                aq2.s = bundle;
            }
            aq2.j.g();
            aq2.j.clear();
        }
        aq2.r = true;
        aq2.q = true;
        if (n2 != 108) {
            if (n2 != 0) return;
        }
        if (this.r == null) return;
        aq aq3 = this.a(0, false);
        if (aq3 == null) return;
        aq3.m = false;
        this.b(aq3, null);
    }

    /*
     * Unable to fully structure code
     */
    private boolean e(int var1_1, KeyEvent var2_2) {
        var3_3 = true;
        if (this.m != null) {
            return false;
        }
        var4_4 = this.a(var1_1, var3_3);
        if (var1_1 != 0 || this.r == null || !this.r.d() || cn.b(ViewConfiguration.get((Context)this.a))) ** GOTO lbl12
        if (this.r.e()) ** GOTO lbl10
        if (this.n() || !this.b(var4_4, var2_2)) ** GOTO lbl-1000
        var3_3 = this.r.g();
        ** GOTO lbl27
lbl10: // 1 sources:
        var3_3 = this.r.h();
        ** GOTO lbl27
lbl12: // 1 sources:
        if (!var4_4.o && !var4_4.n) ** GOTO lbl17
        var5_6 = var4_4.o;
        this.a(var4_4, var3_3);
        var3_3 = var5_6;
        ** GOTO lbl27
lbl17: // 1 sources:
        if (!var4_4.m) ** GOTO lbl-1000
        if (var4_4.r) {
            var4_4.m = false;
            var8_7 = this.b(var4_4, var2_2);
        } else {
            var8_7 = var3_3;
        }
        if (var8_7) {
            this.a(var4_4, var2_2);
        } else lbl-1000: // 3 sources:
        {
            var3_3 = false;
        }
lbl27: // 5 sources:
        if (var3_3 == false) return var3_3;
        var6_5 = (AudioManager)this.a.getSystemService("audio");
        if (var6_5 != null) {
            var6_5.playSoundEffect(0);
            return var3_3;
        }
        Log.w((String)"AppCompatDelegate", (String)"Couldn't get audio manager");
        return var3_3;
    }

    /*
     * Unable to fully structure code
     */
    private int f(int var1_1) {
        var2_2 = true;
        if (this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) ** GOTO lbl46
        var6_3 = (ViewGroup.MarginLayoutParams)this.n.getLayoutParams();
        if (!this.n.isShown()) ** GOTO lbl27
        if (this.I == null) {
            this.I = new Rect();
            this.J = new Rect();
        }
        var8_4 = this.I;
        var9_5 = this.J;
        var8_4.set(0, var1_1, 0, 0);
        gz.a((View)this.v, var8_4, var9_5);
        var10_6 = var9_5.top == 0 ? var1_1 : 0;
        if (var6_3.topMargin == var10_6) ** GOTO lbl34
        var6_3.topMargin = var1_1;
        if (this.x == null) {
            this.x = new View(this.a);
            this.x.setBackgroundColor(this.a.getResources().getColor(d.abc_input_method_navigation_guard));
            this.v.addView(this.x, -1, new ViewGroup.LayoutParams(-1, var1_1));
            var11_7 = var2_2;
        } else {
            var13_13 = this.x.getLayoutParams();
            if (var13_13.height != var1_1) {
                var13_13.height = var1_1;
                this.x.setLayoutParams(var13_13);
            }
            var11_7 = var2_2;
        }
        ** GOTO lbl35
lbl27: // 1 sources:
        if (var6_3.topMargin != 0) {
            var6_3.topMargin = 0;
            var7_9 = false;
        } else {
            var7_9 = false;
            var2_2 = false;
        }
        ** GOTO lbl42
lbl34: // 1 sources:
        var11_7 = false;
lbl35: // 3 sources:
        if (this.x == null) {
            var2_2 = false;
        }
        if (!this.j && var2_2) {
            var1_1 = 0;
        }
        var12_8 = var11_7;
        var7_9 = var2_2;
        var2_2 = var12_8;
lbl42: // 3 sources:
        if (var2_2) {
            this.n.setLayoutParams((ViewGroup.LayoutParams)var6_3);
        }
        var3_10 = var7_9;
        ** GOTO lbl47
lbl46: // 1 sources:
        var3_10 = false;
lbl47: // 2 sources:
        if (this.x == null) return var1_1;
        var4_11 = this.x;
        var5_12 = 0;
        if (!var3_10) {
            var5_12 = 8;
        }
        var4_11.setVisibility(var5_12);
        return var1_1;
    }

    private int g(int n2) {
        if (n2 == 8) {
            Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (n2 != 9) return n2;
        Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private void r() {
        if (this.u) return;
        this.v = this.s();
        CharSequence charSequence = this.p();
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.b(charSequence);
        }
        this.t();
        this.a(this.v);
        this.u = true;
        aq aq2 = this.a(0, false);
        if (this.n()) return;
        if (aq2 != null) {
            if (aq2.j != null) return;
        }
        this.d(108);
    }

    /*
     * Unable to fully structure code
     */
    private ViewGroup s() {
        var1_1 = this.a.obtainStyledAttributes(l.AppCompatTheme);
        if (!var1_1.hasValue(l.AppCompatTheme_windowActionBar)) {
            var1_1.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (var1_1.getBoolean(l.AppCompatTheme_windowNoTitle, false)) {
            this.b(1);
        } else if (var1_1.getBoolean(l.AppCompatTheme_windowActionBar, false)) {
            this.b(108);
        }
        if (var1_1.getBoolean(l.AppCompatTheme_windowActionBarOverlay, false)) {
            this.b(109);
        }
        if (var1_1.getBoolean(l.AppCompatTheme_windowActionModeOverlay, false)) {
            this.b(10);
        }
        this.k = var1_1.getBoolean(l.AppCompatTheme_android_windowIsFloating, false);
        var1_1.recycle();
        var3_2 = LayoutInflater.from((Context)this.a);
        if (this.l) ** GOTO lbl39
        if (!this.k) ** GOTO lbl24
        var13_3 = (ViewGroup)var3_2.inflate(i.abc_dialog_title_material, null);
        this.i = false;
        this.h = false;
        var5_4 = var13_3;
        ** GOTO lbl48
lbl24: // 1 sources:
        if (!this.h) ** GOTO lbl47
        var9_6 = new TypedValue();
        this.a.getTheme().resolveAttribute(b.actionBarTheme, var9_6, true);
        var11_7 = var9_6.resourceId != 0 ? new e(this.a, var9_6.resourceId) : this.a;
        var12_8 = (ViewGroup)LayoutInflater.from((Context)var11_7).inflate(i.abc_screen_toolbar, null);
        this.r = (ce)var12_8.findViewById(g.decor_content_parent);
        this.r.setWindowCallback(this.o());
        if (this.i) {
            this.r.a(109);
        }
        if (this.y) {
            this.r.a(2);
        }
        if (this.z) {
            this.r.a(5);
        }
        var5_4 = var12_8;
        ** GOTO lbl48
lbl39: // 1 sources:
        var4_5 = this.j != false ? (ViewGroup)var3_2.inflate(i.abc_screen_simple_overlay_action_mode, null) : (ViewGroup)var3_2.inflate(i.abc_screen_simple, null);
        if (Build.VERSION.SDK_INT >= 21) {
            bo.a((View)var4_5, new ag(this));
            var5_4 = var4_5;
        } else {
            ((ct)var4_5).setOnFitSystemWindowsListener(new ah(this));
            var5_4 = var4_5;
        }
        ** GOTO lbl48
lbl47: // 1 sources:
        var5_4 = null;
lbl48: // 5 sources:
        if (var5_4 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        }
        if (this.r == null) {
            this.w = (TextView)var5_4.findViewById(g.title);
        }
        gz.b((View)var5_4);
        var6_9 = (ViewGroup)this.b.findViewById(16908290);
        var7_10 = (ContentFrameLayout)var5_4.findViewById(g.action_bar_activity_content);
        while (var6_9.getChildCount() > 0) {
            var8_11 = var6_9.getChildAt(0);
            var6_9.removeViewAt(0);
            var7_10.addView(var8_11);
        }
        this.b.setContentView((View)var5_4);
        var6_9.setId(-1);
        var7_10.setId(16908290);
        if (var6_9 instanceof FrameLayout) {
            ((FrameLayout)var6_9).setForeground(null);
        }
        var7_10.setAttachListener(new ai(this));
        return var5_4;
    }

    private void t() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.v.findViewById(16908290);
        View view = this.b.getDecorView();
        contentFrameLayout.a(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        TypedArray typedArray = this.a.obtainStyledAttributes(l.AppCompatTheme);
        typedArray.getValue(l.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArray.getValue(l.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArray.hasValue(l.AppCompatTheme_windowFixedWidthMajor)) {
            typedArray.getValue(l.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArray.hasValue(l.AppCompatTheme_windowFixedWidthMinor)) {
            typedArray.getValue(l.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArray.hasValue(l.AppCompatTheme_windowFixedHeightMajor)) {
            typedArray.getValue(l.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArray.hasValue(l.AppCompatTheme_windowFixedHeightMinor)) {
            typedArray.getValue(l.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArray.recycle();
        contentFrameLayout.requestLayout();
    }

    private void u() {
        if (this.q == null) return;
        this.q.b();
    }

    private void v() {
        if (!this.u) return;
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private void w() {
        if (this.r != null) {
            this.r.j();
        }
        if (this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                }
                catch (IllegalArgumentException var3_2) {}
            }
            this.o = null;
        }
        this.u();
        aq aq2 = this.a(0, false);
        if (aq2 == null) return;
        if (aq2.j == null) return;
        aq2.j.close();
    }

    @Override
    android.support.v7.view.b a(c c2) {
        android.support.v7.view.b b2;
        this.u();
        if (this.m != null) {
            this.m.c();
        }
        an an2 = new an(this, c2);
        if (this.e != null && !this.n()) {
            try {
                android.support.v7.view.b b3;
                b2 = b3 = this.e.a(an2);
            }
            catch (AbstractMethodError var18_5) {
                b2 = null;
            }
        } else {
            b2 = null;
        }
        if (b2 != null) {
            this.m = b2;
        } else {
            if (this.n == null) {
                if (this.k) {
                    Object object;
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.a.getTheme();
                    theme.resolveAttribute(b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme theme2 = this.a.getResources().newTheme();
                        theme2.setTo(theme);
                        theme2.applyStyle(typedValue.resourceId, true);
                        object = new e(this.a, 0);
                        object.getTheme().setTo(theme2);
                    } else {
                        object = this.a;
                    }
                    this.n = new ActionBarContextView((Context)object);
                    this.o = new PopupWindow((Context)object, null, b.actionModePopupWindowStyle);
                    android.support.v4.widget.ag.a(this.o, 2);
                    this.o.setContentView((View)this.n);
                    this.o.setWidth(-1);
                    object.getTheme().resolveAttribute(b.actionBarSize, typedValue, true);
                    int n2 = TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)object.getResources().getDisplayMetrics());
                    this.n.setContentHeight(n2);
                    this.o.setHeight(-2);
                    this.p = new aj(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat)this.v.findViewById(g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from((Context)this.l()));
                        this.n = (ActionBarContextView)viewStubCompat.a();
                    }
                }
            }
            if (this.n != null) {
                this.u();
                this.n.c();
                Context context = this.n.getContext();
                ActionBarContextView actionBarContextView = this.n;
                boolean bl2 = this.o == null;
                f f2 = new f(context, actionBarContextView, an2, bl2);
                if (c2.a((android.support.v7.view.b)f2, f2.b())) {
                    f2.d();
                    this.n.a(f2);
                    this.m = f2;
                    bo.c((View)this.n, 0.0f);
                    this.q = bo.q((View)this.n).a(1.0f);
                    this.q.a(new al(this));
                    if (this.o != null) {
                        this.b.getDecorView().post(this.p);
                    }
                } else {
                    this.m = null;
                }
            }
        }
        if (this.m == null) return this.m;
        if (this.e == null) return this.m;
        this.e.a(this.m);
        return this.m;
    }

    @Override
    public final View a(View view, String string, Context context, AttributeSet attributeSet) {
        View view2 = this.b(view, string, context, attributeSet);
        if (view2 == null) return this.c(view, string, context, attributeSet);
        return view2;
    }

    @Override
    public void a(int n2) {
        this.r();
        ViewGroup viewGroup = (ViewGroup)this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from((Context)this.a).inflate(n2, viewGroup);
        this.c.onContentChanged();
    }

    @Override
    void a(int n2, Menu menu) {
        if (n2 == 108) {
            a a2 = this.a();
            if (a2 == null) return;
            a2.e(false);
            return;
        }
        if (n2 != 0) return;
        aq aq2 = this.a(n2, true);
        if (!aq2.o) return;
        this.a(aq2, false);
    }

    @Override
    public void a(Configuration configuration) {
        if (!this.h) return;
        if (!this.u) return;
        a a2 = this.a();
        if (a2 == null) return;
        a2.a(configuration);
    }

    @Override
    public void a(Bundle bundle) {
        if (!(this.c instanceof Activity)) return;
        if (bf.b((Activity)this.c) == null) return;
        a a2 = this.k();
        if (a2 == null) {
            this.H = true;
            return;
        }
        a2.c(true);
    }

    @Override
    public void a(android.support.v7.view.menu.i i2) {
        this.a(i2, true);
    }

    @Override
    public void a(Toolbar toolbar) {
        if (!(this.c instanceof Activity)) {
            return;
        }
        a a2 = this.a();
        if (a2 instanceof bp) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
        this.g = null;
        if (a2 != null) {
            a2.h();
        }
        if (toolbar != null) {
            be be2;
            this.f = be2 = new be(toolbar, ((Activity)this.a).getTitle(), this.d);
            this.b.setCallback(be2.i());
        } else {
            this.f = null;
            this.b.setCallback(this.d);
        }
        this.e();
    }

    @Override
    public void a(View view) {
        this.r();
        ViewGroup viewGroup = (ViewGroup)this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    @Override
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.r();
        ViewGroup viewGroup = (ViewGroup)this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    @Override
    boolean a(int n2, KeyEvent keyEvent) {
        a a2 = this.a();
        if (a2 != null && a2.a(n2, keyEvent)) {
            return true;
        }
        if (this.C != null && this.a(this.C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.C == null) return true;
            this.C.n = true;
            return true;
        }
        if (this.C != null) return false;
        aq aq2 = this.a(0, true);
        this.b(aq2, keyEvent);
        boolean bl2 = this.a(aq2, keyEvent.getKeyCode(), keyEvent, 1);
        aq2.m = false;
        if (bl2) return true;
        return false;
    }

    @Override
    public boolean a(android.support.v7.view.menu.i i2, MenuItem menuItem) {
        Window.Callback callback = this.o();
        if (callback == null) return false;
        if (this.n()) return false;
        aq aq2 = this.a((Menu)i2.p());
        if (aq2 == null) return false;
        return callback.onMenuItemSelected(aq2.a, menuItem);
    }

    @Override
    boolean a(KeyEvent keyEvent) {
        boolean bl2 = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return bl2;
        }
        int n2 = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) return this.b(n2, keyEvent);
        if (!bl2) return this.b(n2, keyEvent);
        return this.c(n2, keyEvent);
    }

    public android.support.v7.view.b b(c c2) {
        if (c2 == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.m != null) {
            this.m.c();
        }
        an an2 = new an(this, c2);
        a a2 = this.a();
        if (a2 != null) {
            this.m = a2.a(an2);
            if (this.m != null && this.e != null) {
                this.e.a(this.m);
            }
        }
        if (this.m != null) return this.m;
        this.m = this.a(an2);
        return this.m;
    }

    View b(View view, String string, Context context, AttributeSet attributeSet) {
        if (!(this.c instanceof LayoutInflater.Factory)) return null;
        View view2 = ((LayoutInflater.Factory)this.c).onCreateView(string, context, attributeSet);
        if (view2 == null) return null;
        return view2;
    }

    @Override
    public void b(Bundle bundle) {
        this.r();
    }

    @Override
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        this.r();
        ((ViewGroup)this.v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    @Override
    void b(CharSequence charSequence) {
        if (this.r != null) {
            this.r.setWindowTitle(charSequence);
            return;
        }
        if (this.k() != null) {
            this.k().a(charSequence);
            return;
        }
        if (this.w == null) return;
        this.w.setText(charSequence);
    }

    @Override
    public boolean b(int n2) {
        int n3 = this.g(n2);
        if (this.l && n3 == 108) {
            return false;
        }
        if (this.h && n3 == 1) {
            this.h = false;
        }
        switch (n3) {
            default: {
                return this.b.requestFeature(n3);
            }
            case 108: {
                this.v();
                this.h = true;
                return true;
            }
            case 109: {
                this.v();
                this.i = true;
                return true;
            }
            case 10: {
                this.v();
                this.j = true;
                return true;
            }
            case 2: {
                this.v();
                this.y = true;
                return true;
            }
            case 5: {
                this.v();
                this.z = true;
                return true;
            }
            case 1: 
        }
        this.v();
        this.l = true;
        return true;
    }

    boolean b(int n2, KeyEvent keyEvent) {
        boolean bl2 = true;
        switch (n2) {
            default: {
                return false;
            }
            case 82: {
                this.e(0, keyEvent);
                return bl2;
            }
            case 4: {
                boolean bl3 = this.D;
                this.D = false;
                aq aq2 = this.a(0, false);
                if (aq2 != null && aq2.o) {
                    if (bl3) return bl2;
                    this.a(aq2, bl2);
                    return bl2;
                }
                if (!this.q()) return false;
                return bl2;
            }
        }
    }

    @Override
    boolean b(int n2, Menu menu) {
        if (n2 != 108) return false;
        a a2 = this.a();
        if (a2 == null) return true;
        a2.e(true);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public View c(View var1_1, String var2_2, Context var3_3, AttributeSet var4_4) {
        var5_5 = Build.VERSION.SDK_INT < 21;
        if (this.K != null) ** GOTO lbl-1000
        this.K = new at();
        if (var5_5) lbl-1000: // 2 sources:
        {
            if (this.a((ViewParent)var1_1)) {
                var6_6 = true;
                return this.K.a(var1_1, var2_2, var3_3, var4_4, var6_6, var5_5, true, var5_5);
            }
        }
        var6_6 = false;
        return this.K.a(var1_1, var2_2, var3_3, var4_4, var6_6, var5_5, true, var5_5);
    }

    @Override
    public void c() {
        a a2 = this.a();
        if (a2 == null) return;
        a2.d(false);
    }

    boolean c(int n2, KeyEvent keyEvent) {
        boolean bl2 = true;
        switch (n2) {
            default: {
                break;
            }
            case 82: {
                this.d(0, keyEvent);
                return bl2;
            }
            case 4: {
                if ((128 & keyEvent.getFlags()) == 0) {
                    bl2 = false;
                }
                this.D = bl2;
            }
        }
        if (Build.VERSION.SDK_INT >= 11) return false;
        this.a(n2, keyEvent);
        return false;
    }

    @Override
    public void d() {
        a a2 = this.a();
        if (a2 == null) return;
        a2.d(true);
    }

    @Override
    public void e() {
        a a2 = this.a();
        if (a2 != null && a2.e()) {
            return;
        }
        this.d(0);
    }

    @Override
    public void f() {
        super.f();
        if (this.f == null) return;
        this.f.h();
        this.f = null;
    }

    @Override
    public void g() {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (layoutInflater.getFactory() == null) {
            android.support.v4.h.v.a(layoutInflater, this);
            return;
        }
        if (android.support.v4.h.v.a(layoutInflater) instanceof ae) return;
        Log.i((String)"AppCompatDelegate", (String)"The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }

    @Override
    public void j() {
        this.r();
        if (!this.h) return;
        if (this.f != null) {
            return;
        }
        if (this.c instanceof Activity) {
            this.f = new bp((Activity)this.c, this.i);
        } else if (this.c instanceof Dialog) {
            this.f = new bp((Dialog)this.c);
        }
        if (this.f == null) return;
        this.f.c(this.H);
    }

    boolean q() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        a a2 = this.a();
        if (a2 == null) return false;
        if (a2.f()) return true;
        return false;
    }
}

