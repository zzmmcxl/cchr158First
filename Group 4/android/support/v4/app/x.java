/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.aa;
import android.support.v4.app.ae;
import android.support.v4.app.ag;
import android.support.v4.app.ah;
import android.support.v4.app.aj;
import android.support.v4.app.bd;
import android.support.v4.app.df;
import android.support.v4.app.dg;
import android.support.v4.app.y;
import android.support.v4.app.z;
import android.support.v4.g.d;
import android.support.v4.g.q;
import android.support.v4.h.af;
import android.support.v4.h.v;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class x
implements ComponentCallbacks,
View.OnCreateContextMenuListener {
    private static final q a = new q();
    static final Object j = new Object();
    int A;
    aj B;
    ag C;
    aj D;
    x E;
    int F;
    int G;
    String H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N = true;
    boolean O;
    int P;
    ViewGroup Q;
    View R;
    View S;
    boolean T;
    boolean U = true;
    bd V;
    boolean W;
    boolean X;
    Object Y = null;
    Object Z = j;
    Object aa = null;
    Object ab = j;
    Object ac = null;
    Object ad = j;
    Boolean ae;
    Boolean af;
    df ag = null;
    df ah = null;
    int k = 0;
    View l;
    int m;
    Bundle n;
    SparseArray o;
    int p = -1;
    String q;
    Bundle r;
    x s;
    int t = -1;
    int u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    public static x a(Context context, String string) {
        return x.a(context, string, null);
    }

    public static x a(Context context, String string, Bundle bundle) {
        try {
            Class class_ = (Class)a.get(string);
            if (class_ == null) {
                class_ = context.getClassLoader().loadClass(string);
                a.put(string, class_);
            }
            x x2 = (x)class_.newInstance();
            if (bundle == null) return x2;
            bundle.setClassLoader(x2.getClass().getClassLoader());
            x2.r = bundle;
            return x2;
        }
        catch (ClassNotFoundException var5_5) {
            throw new z("Unable to instantiate fragment " + string + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var5_5);
        }
        catch (InstantiationException var4_6) {
            throw new z("Unable to instantiate fragment " + string + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var4_6);
        }
        catch (IllegalAccessException var3_7) {
            throw new z("Unable to instantiate fragment " + string + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var3_7);
        }
    }

    static boolean b(Context context, String string) {
        try {
            Class class_ = (Class)a.get(string);
            if (class_ != null) return x.class.isAssignableFrom(class_);
            class_ = context.getClassLoader().loadClass(string);
            a.put(string, class_);
            return x.class.isAssignableFrom(class_);
        }
        catch (ClassNotFoundException var2_4) {
            return false;
        }
    }

    public boolean A() {
        if (this.ae != null) return this.ae;
        return true;
    }

    void B() {
        this.D = new aj();
        this.D.a(this.C, new y(this), this);
    }

    void C() {
        if (this.D != null) {
            this.D.k();
            this.D.g();
        }
        this.k = 4;
        this.O = false;
        this.c();
        if (!this.O) {
            throw new dg("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.D != null) {
            this.D.n();
        }
        if (this.V == null) return;
        this.V.g();
    }

    void D() {
        if (this.D != null) {
            this.D.k();
            this.D.g();
        }
        this.k = 5;
        this.O = false;
        this.o();
        if (!this.O) {
            throw new dg("Fragment " + this + " did not call through to super.onResume()");
        }
        if (this.D == null) return;
        this.D.o();
        this.D.g();
    }

    void E() {
        this.onLowMemory();
        if (this.D == null) return;
        this.D.u();
    }

    void F() {
        if (this.D != null) {
            this.D.p();
        }
        this.k = 4;
        this.O = false;
        this.p();
        if (this.O) return;
        throw new dg("Fragment " + this + " did not call through to super.onPause()");
    }

    void G() {
        if (this.D != null) {
            this.D.q();
        }
        this.k = 3;
        this.O = false;
        this.d();
        if (this.O) return;
        throw new dg("Fragment " + this + " did not call through to super.onStop()");
    }

    void H() {
        if (this.D != null) {
            this.D.r();
        }
        this.k = 2;
        if (!this.W) return;
        this.W = false;
        if (!this.X) {
            this.X = true;
            this.V = this.C.a(this.q, this.W, false);
        }
        if (this.V == null) return;
        if (this.C.k()) {
            this.V.d();
            return;
        }
        this.V.c();
    }

    void I() {
        if (this.D != null) {
            this.D.s();
        }
        this.k = 1;
        this.O = false;
        this.e();
        if (!this.O) {
            throw new dg("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        if (this.V == null) return;
        this.V.f();
    }

    void J() {
        if (this.D != null) {
            this.D.t();
        }
        this.k = 0;
        this.O = false;
        this.q();
        if (this.O) return;
        throw new dg("Fragment " + this + " did not call through to super.onDestroy()");
    }

    x a(String string) {
        if (string.equals(this.q)) {
            return this;
        }
        if (this.D == null) return null;
        return this.D.b(string);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int n2, boolean bl2, int n3) {
        return null;
    }

    public void a(int n2, int n3, Intent intent) {
    }

    final void a(int n2, x x2) {
        this.p = n2;
        if (x2 != null) {
            this.q = x2.q + ":" + this.p;
            return;
        }
        this.q = "android:fragment:" + this.p;
    }

    public void a(int n2, String[] arrstring, int[] arrn) {
    }

    @Deprecated
    public void a(Activity activity) {
        this.O = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.O = true;
    }

    public void a(Context context) {
        this.O = true;
        if (this.C == null) {
            return;
        }
        Activity activity = this.C.f();
        if (activity == null) return;
        this.O = false;
        this.a(activity);
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.O = true;
        if (this.C == null) {
            return;
        }
        Activity activity = this.C.f();
        if (activity == null) return;
        this.O = false;
        this.a(activity, attributeSet, bundle);
    }

    public void a(Intent intent, int n2) {
        this.a(intent, n2, null);
    }

    public void a(Intent intent, int n2, Bundle bundle) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, n2, bundle);
    }

    void a(Configuration configuration) {
        this.onConfigurationChanged(configuration);
        if (this.D == null) return;
        this.D.a(configuration);
    }

    public void a(Bundle bundle) {
        this.O = true;
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mTag=");
        printWriter.println(this.H);
        printWriter.print(string);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.p);
        printWriter.print(" mWho=");
        printWriter.print(this.q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(string);
        printWriter.print("mAdded=");
        printWriter.print(this.v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.y);
        printWriter.print(string);
        printWriter.print("mHidden=");
        printWriter.print(this.I);
        printWriter.print(" mDetached=");
        printWriter.print(this.J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.M);
        printWriter.print(string);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.U);
        if (this.B != null) {
            printWriter.print(string);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(string);
            printWriter.print("mHost=");
            printWriter.println(this.C);
        }
        if (this.E != null) {
            printWriter.print(string);
            printWriter.print("mParentFragment=");
            printWriter.println(this.E);
        }
        if (this.r != null) {
            printWriter.print(string);
            printWriter.print("mArguments=");
            printWriter.println((Object)this.r);
        }
        if (this.n != null) {
            printWriter.print(string);
            printWriter.print("mSavedFragmentState=");
            printWriter.println((Object)this.n);
        }
        if (this.o != null) {
            printWriter.print(string);
            printWriter.print("mSavedViewState=");
            printWriter.println((Object)this.o);
        }
        if (this.s != null) {
            printWriter.print(string);
            printWriter.print("mTarget=");
            printWriter.print(this.s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.u);
        }
        if (this.P != 0) {
            printWriter.print(string);
            printWriter.print("mNextAnim=");
            printWriter.println(this.P);
        }
        if (this.Q != null) {
            printWriter.print(string);
            printWriter.print("mContainer=");
            printWriter.println((Object)this.Q);
        }
        if (this.R != null) {
            printWriter.print(string);
            printWriter.print("mView=");
            printWriter.println((Object)this.R);
        }
        if (this.S != null) {
            printWriter.print(string);
            printWriter.print("mInnerView=");
            printWriter.println((Object)this.R);
        }
        if (this.l != null) {
            printWriter.print(string);
            printWriter.print("mAnimatingAway=");
            printWriter.println((Object)this.l);
            printWriter.print(string);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.m);
        }
        if (this.V != null) {
            printWriter.print(string);
            printWriter.println("Loader Manager:");
            this.V.a(string + "  ", fileDescriptor, printWriter, arrstring);
        }
        if (this.D == null) return;
        printWriter.print(string);
        printWriter.println("Child " + this.D + ":");
        this.D.a(string + "  ", fileDescriptor, printWriter, arrstring);
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater b(Bundle bundle) {
        LayoutInflater layoutInflater = this.C.b();
        this.j();
        v.a(layoutInflater, this.D.v());
        return layoutInflater;
    }

    View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.D == null) return this.a(layoutInflater, viewGroup, bundle);
        this.D.k();
        return this.a(layoutInflater, viewGroup, bundle);
    }

    public void b() {
        this.O = true;
    }

    public void b(Menu menu) {
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean bl2 = this.I;
        boolean bl3 = false;
        if (bl2) return bl3;
        boolean bl4 = this.M;
        bl3 = false;
        if (bl4) {
            boolean bl5 = this.N;
            bl3 = false;
            if (bl5) {
                bl3 = true;
                this.a(menu, menuInflater);
            }
        }
        if (this.D == null) return bl3;
        bl3 |= this.D.a(menu, menuInflater);
        return bl3;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void c() {
        this.O = true;
        if (this.W) return;
        this.W = true;
        if (!this.X) {
            this.X = true;
            this.V = this.C.a(this.q, this.W, false);
        }
        if (this.V == null) return;
        this.V.b();
    }

    public void c(boolean bl2) {
    }

    boolean c(Menu menu) {
        boolean bl2 = this.I;
        boolean bl3 = false;
        if (bl2) return bl3;
        boolean bl4 = this.M;
        bl3 = false;
        if (bl4) {
            boolean bl5 = this.N;
            bl3 = false;
            if (bl5) {
                bl3 = true;
                this.a(menu);
            }
        }
        if (this.D == null) return bl3;
        bl3 |= this.D.a(menu);
        return bl3;
    }

    boolean c(MenuItem menuItem) {
        if (this.I) return false;
        if (this.M && this.N && this.a(menuItem)) {
            return true;
        }
        if (this.D == null) return false;
        if (this.D.a(menuItem)) return true;
        return false;
    }

    public void d() {
        this.O = true;
    }

    public void d(Bundle bundle) {
        this.O = true;
    }

    void d(Menu menu) {
        if (this.I) return;
        if (this.M && this.N) {
            this.b(menu);
        }
        if (this.D == null) return;
        this.D.b(menu);
    }

    boolean d(MenuItem menuItem) {
        if (this.I) return false;
        if (this.b(menuItem)) {
            return true;
        }
        if (this.D == null) return false;
        if (this.D.b(menuItem)) return true;
        return false;
    }

    public void e() {
        this.O = true;
    }

    public void e(Bundle bundle) {
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    final void f(Bundle bundle) {
        if (this.o != null) {
            this.S.restoreHierarchyState(this.o);
            this.o = null;
        }
        this.O = false;
        this.g(bundle);
        if (this.O) return;
        throw new dg("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    final boolean f() {
        if (this.A <= 0) return false;
        return true;
    }

    public final aa g() {
        if (this.C != null) return (aa)this.C.f();
        return null;
    }

    public void g(Bundle bundle) {
        this.O = true;
    }

    public final Resources h() {
        if (this.C != null) return this.C.g().getResources();
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    void h(Bundle bundle) {
        if (this.D != null) {
            this.D.k();
        }
        this.k = 1;
        this.O = false;
        this.a(bundle);
        if (!this.O) {
            throw new dg("Fragment " + this + " did not call through to super.onCreate()");
        }
        if (bundle == null) return;
        Parcelable parcelable = bundle.getParcelable("android:support:fragments");
        if (parcelable == null) return;
        if (this.D == null) {
            this.B();
        }
        this.D.a(parcelable, null);
        this.D.l();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final ah i() {
        return this.B;
    }

    void i(Bundle bundle) {
        if (this.D != null) {
            this.D.k();
        }
        this.k = 2;
        this.O = false;
        this.d(bundle);
        if (!this.O) {
            throw new dg("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (this.D == null) return;
        this.D.m();
    }

    public final ah j() {
        if (this.D != null) return this.D;
        this.B();
        if (this.k >= 5) {
            this.D.o();
            return this.D;
        }
        if (this.k >= 4) {
            this.D.n();
            return this.D;
        }
        if (this.k >= 2) {
            this.D.m();
            return this.D;
        }
        if (this.k < 1) return this.D;
        this.D.l();
        return this.D;
    }

    void j(Bundle bundle) {
        this.e(bundle);
        if (this.D == null) return;
        Parcelable parcelable = this.D.j();
        if (parcelable == null) return;
        bundle.putParcelable("android:support:fragments", parcelable);
    }

    public final boolean k() {
        if (this.C == null) return false;
        if (!this.v) return false;
        return true;
    }

    public final boolean l() {
        return this.w;
    }

    public final boolean m() {
        return this.I;
    }

    public View n() {
        return this.R;
    }

    public void o() {
        this.O = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.O = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.g().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.O = true;
    }

    public void p() {
        this.O = true;
    }

    public void q() {
        this.O = true;
        if (!this.X) {
            this.X = true;
            this.V = this.C.a(this.q, this.W, false);
        }
        if (this.V == null) return;
        this.V.h();
    }

    void r() {
        this.p = -1;
        this.q = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.D = null;
        this.C = null;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = false;
        this.J = false;
        this.L = false;
        this.V = null;
        this.W = false;
        this.X = false;
    }

    public void s() {
    }

    public Object t() {
        return this.Y;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        d.a(this, stringBuilder);
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.F != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.F));
        }
        if (this.H != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.H);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object u() {
        if (this.Z != j) return this.Z;
        return this.t();
    }

    public Object v() {
        return this.aa;
    }

    public Object w() {
        if (this.ab != j) return this.ab;
        return this.v();
    }

    public Object x() {
        return this.ac;
    }

    public Object y() {
        if (this.ad != j) return this.ad;
        return this.x();
    }

    public boolean z() {
        if (this.af != null) return this.af;
        return true;
    }
}

