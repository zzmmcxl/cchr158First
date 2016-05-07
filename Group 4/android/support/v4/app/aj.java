/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.support.v4.app.ae;
import android.support.v4.app.ag;
import android.support.v4.app.ah;
import android.support.v4.app.ai;
import android.support.v4.app.ak;
import android.support.v4.app.al;
import android.support.v4.app.an;
import android.support.v4.app.aq;
import android.support.v4.app.at;
import android.support.v4.app.bd;
import android.support.v4.app.n;
import android.support.v4.app.s;
import android.support.v4.app.x;
import android.support.v4.g.d;
import android.support.v4.g.e;
import android.support.v4.h.af;
import android.support.v4.h.bo;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class aj
extends ah
implements af {
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;
    static final Interpolator D;
    static boolean a;
    static final boolean b;
    static Field r;
    ArrayList c;
    Runnable[] d;
    boolean e;
    ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n = 0;
    ag o;
    ae p;
    x q;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    Bundle x = null;
    SparseArray y = null;
    Runnable z;

    static {
        a = false;
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n2 >= 11) {
            bl2 = true;
        }
        b = bl2;
        r = null;
        A = new DecelerateInterpolator(2.5f);
        B = new DecelerateInterpolator(1.5f);
        C = new AccelerateInterpolator(2.5f);
        D = new AccelerateInterpolator(1.5f);
    }

    aj() {
        this.z = new ak(this);
    }

    static Animation a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation((Animation)scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation((Animation)alphaAnimation);
        return animationSet;
    }

    private void a(RuntimeException runtimeException) {
        Log.e((String)"FragmentManager", (String)runtimeException.getMessage());
        Log.e((String)"FragmentManager", (String)"Activity state:");
        PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.a("  ", null, printWriter, new String[0]);
            }
            catch (Exception var7_3) {
                Log.e((String)"FragmentManager", (String)"Failed dumping state", (Throwable)var7_3);
                throw runtimeException;
            }
            throw runtimeException;
        }
        try {
            this.a("  ", null, printWriter, new String[0]);
            throw runtimeException;
        }
        catch (Exception var5_4) {
            Log.e((String)"FragmentManager", (String)"Failed dumping state", (Throwable)var5_4);
            throw runtimeException;
        }
    }

    static boolean a(View view, Animation animation) {
        if (Build.VERSION.SDK_INT < 19) return false;
        if (bo.g(view) != 0) return false;
        if (!bo.v(view)) return false;
        if (!aj.a(animation)) return false;
        return true;
    }

    static boolean a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        boolean bl2 = animation instanceof AnimationSet;
        boolean bl3 = false;
        if (!bl2) return bl3;
        List list = ((AnimationSet)animation).getAnimations();
        int n2 = 0;
        do {
            int n3 = list.size();
            bl3 = false;
            if (n2 >= n3) return bl3;
            if (list.get(n2) instanceof AlphaAnimation) {
                return true;
            }
            ++n2;
        } while (true);
    }

    public static int b(int n2, boolean bl2) {
        switch (n2) {
            default: {
                return -1;
            }
            case 4097: {
                if (!bl2) return 2;
                return 1;
            }
            case 8194: {
                if (!bl2) return 4;
                return 3;
            }
            case 4099: 
        }
        if (!bl2) return 6;
        return 5;
    }

    private void b(View view, Animation animation) {
        Animation.AnimationListener animationListener;
        if (view == null) return;
        if (animation == null) {
            return;
        }
        if (!aj.a(view, animation)) return;
        try {
            if (r == null) {
                r = Animation.class.getDeclaredField("mListener");
                r.setAccessible(true);
            }
            animationListener = (Animation.AnimationListener)r.get((Object)animation);
        }
        catch (NoSuchFieldException var6_4) {
            Log.e((String)"FragmentManager", (String)"No field with the name mListener is found in Animation class", (Throwable)var6_4);
            animationListener = null;
        }
        catch (IllegalAccessException var3_5) {
            Log.e((String)"FragmentManager", (String)"Cannot access Animation's mListener field", (Throwable)var3_5);
            animationListener = null;
        }
        animation.setAnimationListener((Animation.AnimationListener)new an(view, animation, animationListener));
    }

    public static int c(int n2) {
        switch (n2) {
            default: {
                return 0;
            }
            case 4097: {
                return 8194;
            }
            case 8194: {
                return 4097;
            }
            case 4099: 
        }
        return 4099;
    }

    private void w() {
        if (this.t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.v == null) return;
        throw new IllegalStateException("Can not perform this action inside of " + this.v);
    }

    public int a(n n2) {
        // MONITORENTER : this
        if (this.l == null || this.l.size() <= 0) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int n3 = this.k.size();
            if (a) {
                Log.v((String)"FragmentManager", (String)("Setting back stack index " + n3 + " to " + n2));
            }
            this.k.add(n2);
            // MONITOREXIT : this
            return n3;
        }
        int n4 = (Integer)this.l.remove(-1 + this.l.size());
        if (a) {
            Log.v((String)"FragmentManager", (String)("Adding back stack index " + n4 + " with " + n2));
        }
        this.k.set(n4, n2);
        // MONITOREXIT : this
        return n4;
    }

    @Override
    public at a() {
        return new n(this);
    }

    @Override
    public x a(int n2) {
        x x2;
        if (this.g != null) {
            for (int i2 = -1 + this.g.size(); i2 >= 0; --i2) {
                x2 = (x)this.g.get(i2);
                if (x2 == null || x2.F != n2) continue;
                return x2;
            }
        }
        if (this.f == null) return null;
        int n3 = -1 + this.f.size();
        while (n3 >= 0) {
            x2 = (x)this.f.get(n3);
            if (x2 != null) {
                if (x2.F == n2) return x2;
            }
            --n3;
        }
        return null;
    }

    public x a(Bundle bundle, String string) {
        x x2;
        int n2 = bundle.getInt(string, -1);
        if (n2 == -1) {
            return null;
        }
        if (n2 >= this.f.size()) {
            this.a(new IllegalStateException("Fragment no longer exists for key " + string + ": index " + n2));
        }
        if ((x2 = (x)this.f.get(n2)) != null) return x2;
        this.a(new IllegalStateException("Fragment no longer exists for key " + string + ": index " + n2));
        return x2;
    }

    @Override
    public x a(String string) {
        x x2;
        if (this.g != null && string != null) {
            for (int i2 = -1 + this.g.size(); i2 >= 0; --i2) {
                x2 = (x)this.g.get(i2);
                if (x2 == null || !string.equals(x2.H)) continue;
                return x2;
            }
        }
        if (this.f == null) return null;
        if (string == null) return null;
        int n2 = -1 + this.f.size();
        while (n2 >= 0) {
            x2 = (x)this.f.get(n2);
            if (x2 != null) {
                if (string.equals(x2.H)) return x2;
            }
            --n2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public View a(View var1_1, String var2_2, Context var3_3, AttributeSet var4_4) {
        if (!"fragment".equals(var2_2)) {
            return null;
        }
        var5_5 = var4_4.getAttributeValue(null, "class");
        var6_6 = var3_3.obtainStyledAttributes(var4_4, aq.a);
        var7_7 = var5_5 == null ? var6_6.getString(0) : var5_5;
        var8_8 = var6_6.getResourceId(1, -1);
        var9_9 = var6_6.getString(2);
        var6_6.recycle();
        if (!x.b(this.o.g(), var7_7)) {
            return null;
        }
        var10_10 = var1_1 != null ? var1_1.getId() : 0;
        if (var10_10 == -1 && var8_8 == -1 && var9_9 == null) {
            throw new IllegalArgumentException(var4_4.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + var7_7);
        }
        var11_11 = var8_8 != -1 ? this.a(var8_8) : null;
        if (var11_11 != null) ** GOTO lbl18
        if (var9_9 == null) ** GOTO lbl-1000
        var11_11 = this.a(var9_9);
lbl18: // 2 sources:
        if (var11_11 == null) lbl-1000: // 2 sources:
        {
            if (var10_10 != -1) {
                var11_11 = this.a(var10_10);
            }
        }
        if (aj.a) {
            Log.v((String)"FragmentManager", (String)("onCreateView: id=0x" + Integer.toHexString(var8_8) + " fname=" + var7_7 + " existing=" + var11_11));
        }
        if (var11_11 == null) {
            var13_12 = x.a(var3_3, var7_7);
            var13_12.x = true;
            var14_13 = var8_8 != 0 ? var8_8 : var10_10;
            var13_12.F = var14_13;
            var13_12.G = var10_10;
            var13_12.H = var9_9;
            var13_12.y = true;
            var13_12.B = this;
            var13_12.C = this.o;
            var13_12.a(this.o.g(), var4_4, var13_12.n);
            this.a(var13_12, true);
            var12_14 = var13_12;
        } else {
            if (var11_11.y) {
                throw new IllegalArgumentException(var4_4.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(var8_8) + ", tag " + var9_9 + ", or parent id 0x" + Integer.toHexString(var10_10) + " with another fragment for " + var7_7);
            }
            var11_11.y = true;
            var11_11.C = this.o;
            if (!var11_11.L) {
                var11_11.a(this.o.g(), var4_4, var11_11.n);
            }
            var12_14 = var11_11;
        }
        if (this.n < 1 && var12_14.x) {
            this.a(var12_14, 1, 0, 0, false);
        } else {
            this.b(var12_14);
        }
        if (var12_14.R == null) {
            throw new IllegalStateException("Fragment " + var7_7 + " did not create a view.");
        }
        if (var8_8 != 0) {
            var12_14.R.setId(var8_8);
        }
        if (var12_14.R.getTag() != null) return var12_14.R;
        var12_14.R.setTag((Object)var9_9);
        return var12_14.R;
    }

    Animation a(x x2, int n2, boolean bl2, int n3) {
        Animation animation = x2.a(n2, bl2, x2.P);
        if (animation != null) {
            return animation;
        }
        if (x2.P != 0) {
            animation = AnimationUtils.loadAnimation((Context)this.o.g(), (int)x2.P);
            if (animation != null) return animation;
        }
        if (n2 == 0) {
            return null;
        }
        int n4 = aj.b(n2, bl2);
        if (n4 < 0) {
            return null;
        }
        switch (n4) {
            default: {
                if (n3 == 0 && this.o.d()) {
                    n3 = this.o.e();
                }
                if (n3 != 0) return null;
                return null;
            }
            case 1: {
                return aj.a(this.o.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            }
            case 2: {
                return aj.a(this.o.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            }
            case 3: {
                return aj.a(this.o.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            }
            case 4: {
                return aj.a(this.o.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            }
            case 5: {
                return aj.a(this.o.g(), 0.0f, 1.0f);
            }
            case 6: 
        }
        return aj.a(this.o.g(), 1.0f, 0.0f);
    }

    @Override
    public void a(int n2, int n3) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Bad id: " + n2);
        }
        this.a(new al(this, n2, n3), false);
    }

    /*
     * Unable to fully structure code
     */
    void a(int var1_1, int var2_2, int var3_3, boolean var4_4) {
        if (this.o == null && var1_1 != 0) {
            throw new IllegalStateException("No host");
        }
        if (!var4_4 && this.n == var1_1) {
            return;
        }
        this.n = var1_1;
        if (this.f == null) return;
        var5_5 = 0;
        var6_6 = false;
        do {
            if (var5_5 >= this.f.size()) {
                this.f();
                if (this.s == false) return;
                if (this.o == null) return;
                if (this.n != 5) return;
                this.o.c();
                this.s = false;
                return;
            }
            var7_7 = (x)this.f.get(var5_5);
            if (var7_7 == null) ** GOTO lbl-1000
            this.a(var7_7, var1_1, var2_2, var3_3, false);
            if (var7_7.V != null) {
                var8_8 = var6_6 | var7_7.V.a();
            } else lbl-1000: // 2 sources:
            {
                var8_8 = var6_6;
            }
            ++var5_5;
            var6_6 = var8_8;
        } while (true);
    }

    public void a(int n2, n n3) {
        int n4;
        // MONITORENTER : this
        if (this.k == null) {
            this.k = new ArrayList();
        }
        if (n2 < (n4 = this.k.size())) {
            if (a) {
                Log.v((String)"FragmentManager", (String)("Setting back stack index " + n2 + " to " + n3));
            }
            this.k.set(n2, n3);
            // MONITOREXIT : this
            return;
        }
        while (n4 < n2) {
            this.k.add(null);
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (a) {
                Log.v((String)"FragmentManager", (String)("Adding available back stack index " + n4));
            }
            this.l.add(n4);
            ++n4;
        }
        if (a) {
            Log.v((String)"FragmentManager", (String)("Adding back stack index " + n2 + " with " + n3));
        }
        this.k.add(n3);
        return;
    }

    void a(int n2, boolean bl2) {
        this.a(n2, 0, 0, bl2);
    }

    public void a(Configuration configuration) {
        if (this.g == null) return;
        int n2 = 0;
        while (n2 < this.g.size()) {
            x x2 = (x)this.g.get(n2);
            if (x2 != null) {
                x2.a(configuration);
            }
            ++n2;
        }
    }

    public void a(Bundle bundle, String string, x x2) {
        if (x2.p < 0) {
            this.a(new IllegalStateException("Fragment " + x2 + " is not currently in the FragmentManager"));
        }
        bundle.putInt(string, x2.p);
    }

    void a(Parcelable parcelable, List list) {
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState)parcelable;
        if (fragmentManagerState.a == null) return;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                x x2 = (x)list.get(i2);
                if (a) {
                    Log.v((String)"FragmentManager", (String)("restoreAllState: re-attaching retained " + x2));
                }
                FragmentState fragmentState = fragmentManagerState.a[x2.p];
                fragmentState.k = x2;
                x2.o = null;
                x2.A = 0;
                x2.y = false;
                x2.v = false;
                x2.s = null;
                if (fragmentState.j == null) continue;
                fragmentState.j.setClassLoader(this.o.g().getClassLoader());
                x2.o = fragmentState.j.getSparseParcelableArray("android:view_state");
                x2.n = fragmentState.j;
            }
        }
        this.f = new ArrayList(fragmentManagerState.a.length);
        if (this.h != null) {
            this.h.clear();
        }
        for (int i3 = 0; i3 < fragmentManagerState.a.length; ++i3) {
            FragmentState fragmentState = fragmentManagerState.a[i3];
            if (fragmentState != null) {
                x x3 = fragmentState.a(this.o, this.q);
                if (a) {
                    Log.v((String)"FragmentManager", (String)("restoreAllState: active #" + i3 + ": " + x3));
                }
                this.f.add(x3);
                fragmentState.k = null;
                continue;
            }
            this.f.add(null);
            if (this.h == null) {
                this.h = new ArrayList();
            }
            if (a) {
                Log.v((String)"FragmentManager", (String)("restoreAllState: avail #" + i3));
            }
            this.h.add(i3);
        }
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); ++i4) {
                x x4 = (x)list.get(i4);
                if (x4.t < 0) continue;
                if (x4.t < this.f.size()) {
                    x4.s = (x)this.f.get(x4.t);
                    continue;
                }
                Log.w((String)"FragmentManager", (String)("Re-attaching retained fragment " + x4 + " target no longer exists: " + x4.t));
                x4.s = null;
            }
        }
        if (fragmentManagerState.b == null) {
            this.g = null;
        } else {
            this.g = new ArrayList(fragmentManagerState.b.length);
            for (int i5 = 0; i5 < fragmentManagerState.b.length; ++i5) {
                x x5 = (x)this.f.get(fragmentManagerState.b[i5]);
                if (x5 == null) {
                    this.a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i5]));
                }
                x5.v = true;
                if (a) {
                    Log.v((String)"FragmentManager", (String)("restoreAllState: added #" + i5 + ": " + x5));
                }
                if (this.g.contains(x5)) {
                    throw new IllegalStateException("Already added!");
                }
                this.g.add(x5);
            }
        }
        if (fragmentManagerState.c == null) {
            this.i = null;
            return;
        }
        this.i = new ArrayList(fragmentManagerState.c.length);
        int n2 = 0;
        while (n2 < fragmentManagerState.c.length) {
            n n3 = fragmentManagerState.c[n2].a(this);
            if (a) {
                Log.v((String)"FragmentManager", (String)("restoreAllState: back stack #" + n2 + " (index " + n3.p + "): " + n3));
                n3.a("  ", new PrintWriter(new e("FragmentManager")), false);
            }
            this.i.add(n3);
            if (n3.p >= 0) {
                this.a(n3.p, n3);
            }
            ++n2;
        }
    }

    public void a(ag ag2, ae ae2, x x2) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = ag2;
        this.p = ae2;
        this.q = x2;
    }

    public void a(x x2) {
        if (!x2.T) return;
        if (this.e) {
            this.w = true;
            return;
        }
        x2.T = false;
        this.a(x2, this.n, 0, 0, false);
    }

    public void a(x x2, int n2, int n3) {
        if (a) {
            Log.v((String)"FragmentManager", (String)("remove: " + x2 + " nesting=" + x2.A));
        }
        boolean bl2 = !x2.f();
        if (x2.J) {
            if (!bl2) return;
        }
        if (this.g != null) {
            this.g.remove(x2);
        }
        if (x2.M && x2.N) {
            this.s = true;
        }
        x2.v = false;
        x2.w = true;
        int n4 = bl2 ? 0 : 1;
        this.a(x2, n4, n2, n3, false);
    }

    /*
     * Exception decompiling
     */
    void a(x var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
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

    public void a(x x2, boolean bl2) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (a) {
            Log.v((String)"FragmentManager", (String)("add: " + x2));
        }
        this.c(x2);
        if (x2.J) return;
        if (this.g.contains(x2)) {
            throw new IllegalStateException("Fragment already added: " + x2);
        }
        this.g.add(x2);
        x2.v = true;
        x2.w = false;
        if (x2.M && x2.N) {
            this.s = true;
        }
        if (!bl2) return;
        this.b(x2);
    }

    public void a(Runnable runnable, boolean bl2) {
        if (!bl2) {
            this.w();
        }
        // MONITORENTER : this
        if (this.u) throw new IllegalStateException("Activity has been destroyed");
        if (this.o == null) {
            throw new IllegalStateException("Activity has been destroyed");
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(runnable);
        if (this.c.size() == 1) {
            this.o.h().removeCallbacks(this.z);
            this.o.h().post(this.z);
        }
        // MONITOREXIT : this
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8 = 0;
        String string2 = string + "    ";
        if (this.f != null && (n2 = this.f.size()) > 0) {
            printWriter.print(string);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < n2; ++i2) {
                x x2 = (x)this.f.get(i2);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(x2);
                if (x2 == null) continue;
                x2.a(string2, fileDescriptor, printWriter, arrstring);
            }
        }
        if (this.g != null && (n7 = this.g.size()) > 0) {
            printWriter.print(string);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < n7; ++i3) {
                x x3 = (x)this.g.get(i3);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(x3.toString());
            }
        }
        if (this.j != null && (n6 = this.j.size()) > 0) {
            printWriter.print(string);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < n6; ++i4) {
                x x4 = (x)this.j.get(i4);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(x4.toString());
            }
        }
        if (this.i != null && (n3 = this.i.size()) > 0) {
            printWriter.print(string);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < n3; ++i5) {
                n n9 = (n)this.i.get(i5);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(n9.toString());
                n9.a(string2, fileDescriptor, printWriter, arrstring);
            }
        }
        // MONITORENTER : this
        if (this.k != null && (n4 = this.k.size()) > 0) {
            printWriter.print(string);
            printWriter.println("Back Stack Indices:");
            for (int i6 = 0; i6 < n4; ++i6) {
                n n10 = (n)this.k.get(i6);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(n10);
            }
        }
        if (this.l != null && this.l.size() > 0) {
            printWriter.print(string);
            printWriter.print("mAvailBackStackIndices: ");
            printWriter.println(Arrays.toString(this.l.toArray()));
        }
        // MONITOREXIT : this
        if (this.c != null && (n5 = this.c.size()) > 0) {
            printWriter.print(string);
            printWriter.println("Pending Actions:");
            while (n8 < n5) {
                Runnable runnable = (Runnable)this.c.get(n8);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(n8);
                printWriter.print(": ");
                printWriter.println(runnable);
                ++n8;
            }
        }
        printWriter.print(string);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(string);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(string);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(string);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(string);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.s) {
            printWriter.print(string);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.s);
        }
        if (this.v != null) {
            printWriter.print(string);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
        if (this.h == null) return;
        if (this.h.size() <= 0) return;
        printWriter.print(string);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.h.toArray()));
    }

    boolean a(Handler handler, String string, int n2, int n3) {
        if (this.i == null) {
            return false;
        }
        if (string == null && n2 < 0 && (n3 & 1) == 0) {
            int n4 = -1 + this.i.size();
            if (n4 < 0) return false;
            n n5 = (n)this.i.remove(n4);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            n5.a(sparseArray, sparseArray2);
            n5.a(true, null, sparseArray, sparseArray2);
            this.h();
            return true;
        }
        int n6 = -1;
        if (string != null || n2 >= 0) {
            int n7;
            for (n7 = -1 + this.i.size(); n7 >= 0; --n7) {
                n n8 = (n)this.i.get(n7);
                if (string != null && string.equals(n8.c()) || n2 >= 0 && n2 == n8.p) break;
            }
            if (n7 < 0) return false;
            if ((n3 & 1) != 0) {
                --n7;
                while (n7 >= 0) {
                    n n9 = (n)this.i.get(n7);
                    if ((string == null || !string.equals(n9.c())) && (n2 < 0 || n2 != n9.p)) break;
                    --n7;
                }
            }
            n6 = n7;
        }
        if (n6 == -1 + this.i.size()) return false;
        ArrayList arrayList = new ArrayList();
        for (int i2 = -1 + this.i.size(); i2 > n6; --i2) {
            arrayList.add(this.i.remove(i2));
        }
        int n10 = -1 + arrayList.size();
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray3 = new SparseArray();
        for (int i3 = 0; i3 <= n10; ++i3) {
            ((n)arrayList.get(i3)).a(sparseArray, sparseArray3);
        }
        s s2 = null;
        int n11 = 0;
        do {
            if (n11 > n10) {
                this.h();
                return true;
            }
            if (a) {
                Log.v((String)"FragmentManager", (String)("Popping back stack state: " + arrayList.get(n11)));
            }
            n n12 = (n)arrayList.get(n11);
            boolean bl2 = n11 == n10;
            s s3 = n12.a(bl2, s2, sparseArray, sparseArray3);
            ++n11;
            s2 = s3;
        } while (true);
    }

    public boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        int n2 = 0;
        boolean bl2 = false;
        while (n2 < this.g.size()) {
            x x2 = (x)this.g.get(n2);
            if (x2 != null && x2.c(menu)) {
                bl2 = true;
            }
            ++n2;
        }
        return bl2;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean bl2;
        ArrayList<x> arrayList = null;
        if (this.g != null) {
            bl2 = false;
            for (int i2 = 0; i2 < this.g.size(); ++i2) {
                x x2 = (x)this.g.get(i2);
                if (x2 != null && x2.b(menu, menuInflater)) {
                    bl2 = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<x>();
                    }
                    arrayList.add(x2);
                }
                boolean bl3 = bl2;
                bl2 = bl3;
            }
        } else {
            bl2 = false;
        }
        ArrayList arrayList2 = this.j;
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < this.j.size(); ++i3) {
                x x3 = (x)this.j.get(i3);
                if (arrayList != null && arrayList.contains(x3)) continue;
                x3.s();
            }
        }
        this.j = arrayList;
        return bl2;
    }

    public boolean a(MenuItem menuItem) {
        ArrayList arrayList = this.g;
        boolean bl2 = false;
        if (arrayList == null) return bl2;
        int n2 = 0;
        do {
            int n3 = this.g.size();
            bl2 = false;
            if (n2 >= n3) return bl2;
            x x2 = (x)this.g.get(n2);
            if (x2 != null && x2.c(menuItem)) {
                return true;
            }
            ++n2;
        } while (true);
    }

    public x b(String string) {
        if (this.f == null) return null;
        if (string == null) return null;
        int n2 = -1 + this.f.size();
        while (n2 >= 0) {
            x x2;
            x x3 = (x)this.f.get(n2);
            if (x3 != null && (x2 = x3.a(string)) != null) {
                return x2;
            }
            --n2;
        }
        return null;
    }

    public void b(int n2) {
        // MONITORENTER : this
        this.k.set(n2, null);
        if (this.l == null) {
            this.l = new ArrayList();
        }
        if (a) {
            Log.v((String)"FragmentManager", (String)("Freeing back stack index " + n2));
        }
        this.l.add(n2);
        // MONITOREXIT : this
        return;
    }

    void b(n n2) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(n2);
        this.h();
    }

    void b(x x2) {
        this.a(x2, this.n, 0, 0, false);
    }

    public void b(x x2, int n2, int n3) {
        if (a) {
            Log.v((String)"FragmentManager", (String)("hide: " + x2));
        }
        if (x2.I) return;
        x2.I = true;
        if (x2.R != null) {
            Animation animation = this.a(x2, n2, false, n3);
            if (animation != null) {
                this.b(x2.R, animation);
                x2.R.startAnimation(animation);
            }
            x2.R.setVisibility(8);
        }
        if (x2.v && x2.M && x2.N) {
            this.s = true;
        }
        x2.c(true);
    }

    public void b(Menu menu) {
        if (this.g == null) return;
        int n2 = 0;
        while (n2 < this.g.size()) {
            x x2 = (x)this.g.get(n2);
            if (x2 != null) {
                x2.d(menu);
            }
            ++n2;
        }
    }

    @Override
    public boolean b() {
        return this.g();
    }

    public boolean b(MenuItem menuItem) {
        ArrayList arrayList = this.g;
        boolean bl2 = false;
        if (arrayList == null) return bl2;
        int n2 = 0;
        do {
            int n3 = this.g.size();
            bl2 = false;
            if (n2 >= n3) return bl2;
            x x2 = (x)this.g.get(n2);
            if (x2 != null && x2.d(menuItem)) {
                return true;
            }
            ++n2;
        } while (true);
    }

    void c(x x2) {
        if (x2.p >= 0) {
            return;
        }
        if (this.h == null || this.h.size() <= 0) {
            if (this.f == null) {
                this.f = new ArrayList();
            }
            x2.a(this.f.size(), this.q);
            this.f.add(x2);
        } else {
            x2.a((Integer)this.h.remove(-1 + this.h.size()), this.q);
            this.f.set(x2.p, x2);
        }
        if (!a) return;
        Log.v((String)"FragmentManager", (String)("Allocated fragment index " + x2));
    }

    public void c(x x2, int n2, int n3) {
        if (a) {
            Log.v((String)"FragmentManager", (String)("show: " + x2));
        }
        if (!x2.I) return;
        x2.I = false;
        if (x2.R != null) {
            Animation animation = this.a(x2, n2, true, n3);
            if (animation != null) {
                this.b(x2.R, animation);
                x2.R.startAnimation(animation);
            }
            x2.R.setVisibility(0);
        }
        if (x2.v && x2.M && x2.N) {
            this.s = true;
        }
        x2.c(false);
    }

    @Override
    public boolean c() {
        this.w();
        this.b();
        return this.a(this.o.h(), null, -1, 0);
    }

    @Override
    public List d() {
        return this.f;
    }

    void d(x x2) {
        if (x2.p < 0) {
            return;
        }
        if (a) {
            Log.v((String)"FragmentManager", (String)("Freeing fragment index " + x2));
        }
        this.f.set(x2.p, null);
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.h.add(x2.p);
        this.o.a(x2.q);
        x2.r();
    }

    public void d(x x2, int n2, int n3) {
        if (a) {
            Log.v((String)"FragmentManager", (String)("detach: " + x2));
        }
        if (x2.J) return;
        x2.J = true;
        if (!x2.v) return;
        if (this.g != null) {
            if (a) {
                Log.v((String)"FragmentManager", (String)("remove from detach: " + x2));
            }
            this.g.remove(x2);
        }
        if (x2.M && x2.N) {
            this.s = true;
        }
        x2.v = false;
        this.a(x2, 1, n2, n3, false);
    }

    void e(x x2) {
        if (x2.S == null) {
            return;
        }
        if (this.y == null) {
            this.y = new SparseArray();
        } else {
            this.y.clear();
        }
        x2.S.saveHierarchyState(this.y);
        if (this.y.size() <= 0) return;
        x2.o = this.y;
        this.y = null;
    }

    public void e(x x2, int n2, int n3) {
        if (a) {
            Log.v((String)"FragmentManager", (String)("attach: " + x2));
        }
        if (!x2.J) return;
        x2.J = false;
        if (x2.v) return;
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (this.g.contains(x2)) {
            throw new IllegalStateException("Fragment already added: " + x2);
        }
        if (a) {
            Log.v((String)"FragmentManager", (String)("add from attach: " + x2));
        }
        this.g.add(x2);
        x2.v = true;
        if (x2.M && x2.N) {
            this.s = true;
        }
        this.a(x2, this.n, n2, n3, false);
    }

    @Override
    public boolean e() {
        return this.u;
    }

    Bundle f(x x2) {
        Bundle bundle;
        if (this.x == null) {
            this.x = new Bundle();
        }
        x2.j(this.x);
        if (!this.x.isEmpty()) {
            bundle = this.x;
            this.x = null;
        } else {
            bundle = null;
        }
        if (x2.R != null) {
            this.e(x2);
        }
        if (x2.o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", x2.o);
        }
        if (x2.U) return bundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("android:user_visible_hint", x2.U);
        return bundle;
    }

    void f() {
        if (this.f == null) {
            return;
        }
        int n2 = 0;
        while (n2 < this.f.size()) {
            x x2 = (x)this.f.get(n2);
            if (x2 != null) {
                this.a(x2);
            }
            ++n2;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean g() {
        if (this.e) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != this.o.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean bl2 = false;
        do {
            // MONITORENTER : this
            if (this.c == null || this.c.size() == 0) {
                // MONITOREXIT : this
                if (!this.w) return bl2;
                int n2 = 0;
                boolean bl3 = false;
                do {
                    if (n2 >= this.f.size()) {
                        this.w = false;
                        this.f();
                        return bl2;
                    }
                    x x2 = (x)this.f.get(n2);
                    if (x2 != null && x2.V != null) {
                        bl3 |= x2.V.a();
                    }
                    ++n2;
                } while (true);
            }
            int n3 = this.c.size();
            if (this.d == null || this.d.length < n3) {
                this.d = new Runnable[n3];
            }
            this.c.toArray(this.d);
            this.c.clear();
            this.o.h().removeCallbacks(this.z);
            // MONITOREXIT : this
            this.e = true;
            for (int i2 = 0; i2 < n3; ++i2) {
                this.d[i2].run();
                this.d[i2] = null;
            }
            this.e = false;
            bl2 = true;
        } while (true);
    }

    void h() {
        if (this.m == null) return;
        int n2 = 0;
        while (n2 < this.m.size()) {
            ((ai)this.m.get(n2)).a();
            ++n2;
        }
    }

    ArrayList i() {
        ArrayList arrayList = this.f;
        ArrayList<x> arrayList2 = null;
        if (arrayList == null) return arrayList2;
        int n2 = 0;
        while (n2 < this.f.size()) {
            x x2 = (x)this.f.get(n2);
            if (x2 != null && x2.K) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<x>();
                }
                arrayList2.add(x2);
                x2.L = true;
                int n3 = x2.s != null ? x2.s.p : -1;
                x2.t = n3;
                if (a) {
                    Log.v((String)"FragmentManager", (String)("retainNonConfig: keeping retained " + x2));
                }
            }
            ++n2;
        }
        return arrayList2;
    }

    Parcelable j() {
        this.g();
        if (b) {
            this.t = true;
        }
        if (this.f == null) return null;
        if (this.f.size() <= 0) {
            return null;
        }
        int n2 = this.f.size();
        FragmentState[] arrfragmentState = new FragmentState[n2];
        int n3 = 0;
        boolean bl2 = false;
        do {
            boolean bl3;
            if (n3 >= n2) {
                if (!a) return null;
                Log.v((String)"FragmentManager", (String)"saveAllState: no fragments!");
                return null;
            }
            x x2 = (x)this.f.get(n3);
            if (x2 != null) {
                FragmentState fragmentState;
                if (x2.p < 0) {
                    this.a(new IllegalStateException("Failure saving state: active " + x2 + " has cleared index: " + x2.p));
                }
                arrfragmentState[n3] = fragmentState = new FragmentState(x2);
                if (x2.k > 0 && fragmentState.j == null) {
                    fragmentState.j = this.f(x2);
                    if (x2.s != null) {
                        if (x2.s.p < 0) {
                            this.a(new IllegalStateException("Failure saving state: " + x2 + " has target not in fragment manager: " + x2.s));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        this.a(fragmentState.j, "android:target_state", x2.s);
                        if (x2.u != 0) {
                            fragmentState.j.putInt("android:target_req_state", x2.u);
                        }
                    }
                } else {
                    fragmentState.j = x2.n;
                }
                if (a) {
                    Log.v((String)"FragmentManager", (String)("Saved state of " + x2 + ": " + (Object)fragmentState.j));
                }
                bl3 = true;
            } else {
                bl3 = bl2;
            }
            ++n3;
            bl2 = bl3;
        } while (true);
    }

    public void k() {
        this.t = false;
    }

    public void l() {
        this.t = false;
        this.a(1, false);
    }

    public void m() {
        this.t = false;
        this.a(2, false);
    }

    public void n() {
        this.t = false;
        this.a(4, false);
    }

    public void o() {
        this.t = false;
        this.a(5, false);
    }

    public void p() {
        this.a(4, false);
    }

    public void q() {
        this.t = true;
        this.a(3, false);
    }

    public void r() {
        this.a(2, false);
    }

    public void s() {
        this.a(1, false);
    }

    public void t() {
        this.u = true;
        this.g();
        this.a(0, false);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.q != null) {
            d.a(this.q, stringBuilder);
        } else {
            d.a(this.o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void u() {
        if (this.g == null) return;
        int n2 = 0;
        while (n2 < this.g.size()) {
            x x2 = (x)this.g.get(n2);
            if (x2 != null) {
                x2.E();
            }
            ++n2;
        }
    }

    af v() {
        return this;
    }
}

