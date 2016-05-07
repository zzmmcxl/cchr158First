/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.h.bo;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.ae;
import android.support.v7.a.as;
import android.support.v7.a.f;
import android.support.v7.a.g;
import android.support.v7.a.h;
import android.support.v7.a.i;
import android.support.v7.a.j;
import android.support.v7.a.q;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

class e {
    private TextView A;
    private TextView B;
    private View C;
    private ListAdapter D;
    private int E = -1;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L = 0;
    private Handler M;
    private final View.OnClickListener N;
    private final Context a;
    private final as b;
    private final Window c;
    private CharSequence d;
    private CharSequence e;
    private ListView f;
    private View g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m = false;
    private Button n;
    private CharSequence o;
    private Message p;
    private Button q;
    private CharSequence r;
    private Message s;
    private Button t;
    private CharSequence u;
    private Message v;
    private NestedScrollView w;
    private int x = 0;
    private Drawable y;
    private ImageView z;

    public e(Context context, as as2, Window window) {
        this.N = new f(this);
        this.a = context;
        this.b = as2;
        this.c = window;
        this.M = new q((DialogInterface)as2);
        TypedArray typedArray = context.obtainStyledAttributes(null, l.AlertDialog, b.alertDialogStyle, 0);
        this.F = typedArray.getResourceId(l.AlertDialog_android_layout, 0);
        this.G = typedArray.getResourceId(l.AlertDialog_buttonPanelSideLayout, 0);
        this.H = typedArray.getResourceId(l.AlertDialog_listLayout, 0);
        this.I = typedArray.getResourceId(l.AlertDialog_multiChoiceItemLayout, 0);
        this.J = typedArray.getResourceId(l.AlertDialog_singleChoiceItemLayout, 0);
        this.K = typedArray.getResourceId(l.AlertDialog_listItemLayout, 0);
        typedArray.recycle();
    }

    static /* synthetic */ int a(e e2, int n2) {
        e2.E = n2;
        return n2;
    }

    private ViewGroup a(View view, View view2) {
        View view3;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view3 = ((ViewStub)view2).inflate();
                return (ViewGroup)view3;
            }
        } else {
            View view4;
            ViewParent viewParent;
            if (view2 != null && (viewParent = view2.getParent()) instanceof ViewGroup) {
                ((ViewGroup)viewParent).removeView(view2);
            }
            if (view instanceof ViewStub) {
                view4 = ((ViewStub)view).inflate();
                return (ViewGroup)view4;
            }
            view4 = view;
            return (ViewGroup)view4;
        }
        view3 = view2;
        return (ViewGroup)view3;
    }

    static /* synthetic */ Button a(e e2) {
        return e2.n;
    }

    static /* synthetic */ ListAdapter a(e e2, ListAdapter listAdapter) {
        e2.D = listAdapter;
        return listAdapter;
    }

    static /* synthetic */ ListView a(e e2, ListView listView) {
        e2.f = listView;
        return listView;
    }

    static /* synthetic */ void a(View view, View view2, View view3) {
        e.b(view, view2, view3);
    }

    private void a(ViewGroup viewGroup) {
        View view = this.g != null ? this.g : (this.h != 0 ? LayoutInflater.from((Context)this.a).inflate(this.h, viewGroup, false) : null);
        boolean bl2 = false;
        if (view == null || !(bl2 = true) || !e.a(view)) {
            this.c.setFlags(131072, 131072);
            if (!bl2) {
                viewGroup.setVisibility(8);
                return;
            }
        }
        FrameLayout frameLayout = (FrameLayout)this.c.findViewById(android.support.v7.b.g.custom);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.m) {
            frameLayout.setPadding(this.i, this.j, this.k, this.l);
        }
        if (this.f == null) return;
        ((LinearLayout.LayoutParams)viewGroup.getLayoutParams()).weight = 0.0f;
    }

    private void a(ViewGroup viewGroup, View view, int n2, int n3) {
        View view2 = null;
        View view3 = this.c.findViewById(android.support.v7.b.g.scrollIndicatorUp);
        View view4 = this.c.findViewById(android.support.v7.b.g.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            bo.a(view, n2, n3);
            if (view3 != null) {
                viewGroup.removeView(view3);
            }
            if (view4 == null) return;
            viewGroup.removeView(view4);
            return;
        }
        if (view3 != null && (n2 & 1) == 0) {
            viewGroup.removeView(view3);
            view3 = null;
        }
        if (view4 != null && (n2 & 2) == 0) {
            viewGroup.removeView(view4);
        } else {
            view2 = view4;
        }
        if (view3 == null) {
            if (view2 == null) return;
        }
        if (this.e != null) {
            this.w.setOnScrollChangeListener(new g(this, view3, view2));
            this.w.post((Runnable)new h(this, view3, view2));
            return;
        }
        if (this.f != null) {
            this.f.setOnScrollListener((AbsListView.OnScrollListener)new i(this, view3, view2));
            this.f.post((Runnable)new j(this, view3, view2));
            return;
        }
        if (view3 != null) {
            viewGroup.removeView(view3);
        }
        if (view2 == null) return;
        viewGroup.removeView(view2);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        int n2 = viewGroup.getChildCount();
        do {
            if (n2 <= 0) return false;
        } while (!e.a(viewGroup.getChildAt(--n2)));
        return true;
    }

    private int b() {
        if (this.G == 0) {
            return this.F;
        }
        if (this.L != 1) return this.F;
        return this.G;
    }

    static /* synthetic */ Message b(e e2) {
        return e2.p;
    }

    private static void b(View view, View view2, View view3) {
        if (view2 != null) {
            int n2 = bo.b(view, -1) ? 0 : 4;
            view2.setVisibility(n2);
        }
        if (view3 == null) return;
        boolean bl2 = bo.b(view, 1);
        int n3 = 0;
        if (!bl2) {
            n3 = 4;
        }
        view3.setVisibility(n3);
    }

    private void b(ViewGroup viewGroup) {
        if (this.C != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            viewGroup.addView(this.C, 0, layoutParams);
            this.c.findViewById(android.support.v7.b.g.title_template).setVisibility(8);
            return;
        }
        this.z = (ImageView)this.c.findViewById(16908294);
        boolean bl2 = !TextUtils.isEmpty((CharSequence)this.d);
        if (!bl2) {
            this.c.findViewById(android.support.v7.b.g.title_template).setVisibility(8);
            this.z.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.A = (TextView)this.c.findViewById(android.support.v7.b.g.alertTitle);
        this.A.setText(this.d);
        if (this.x != 0) {
            this.z.setImageResource(this.x);
            return;
        }
        if (this.y != null) {
            this.z.setImageDrawable(this.y);
            return;
        }
        this.A.setPadding(this.z.getPaddingLeft(), this.z.getPaddingTop(), this.z.getPaddingRight(), this.z.getPaddingBottom());
        this.z.setVisibility(8);
    }

    static /* synthetic */ Button c(e e2) {
        return e2.q;
    }

    private void c() {
        View view;
        ListView listView;
        View view2 = this.c.findViewById(android.support.v7.b.g.parentPanel);
        View view3 = view2.findViewById(android.support.v7.b.g.topPanel);
        View view4 = view2.findViewById(android.support.v7.b.g.contentPanel);
        View view5 = view2.findViewById(android.support.v7.b.g.buttonPanel);
        ViewGroup viewGroup = (ViewGroup)view2.findViewById(android.support.v7.b.g.customPanel);
        this.a(viewGroup);
        View view6 = viewGroup.findViewById(android.support.v7.b.g.topPanel);
        View view7 = viewGroup.findViewById(android.support.v7.b.g.contentPanel);
        View view8 = viewGroup.findViewById(android.support.v7.b.g.buttonPanel);
        ViewGroup viewGroup2 = this.a(view6, view3);
        ViewGroup viewGroup3 = this.a(view7, view4);
        ViewGroup viewGroup4 = this.a(view8, view5);
        this.c(viewGroup3);
        this.d(viewGroup4);
        this.b(viewGroup2);
        boolean bl2 = viewGroup != null && viewGroup.getVisibility() != 8;
        boolean bl3 = viewGroup2 != null && viewGroup2.getVisibility() != 8;
        boolean bl4 = viewGroup4 != null && viewGroup4.getVisibility() != 8;
        if (!bl4 && viewGroup3 != null && (view = viewGroup3.findViewById(android.support.v7.b.g.textSpacerNoButtons)) != null) {
            view.setVisibility(0);
        }
        if (bl3 && this.w != null) {
            this.w.setClipToPadding(true);
        }
        if (!bl2) {
            ListView listView2 = this.f != null ? this.f : this.w;
            if (listView2 != null) {
                int n2 = bl3 ? 1 : 0;
                int n3 = bl4 ? 2 : 0;
                this.a(viewGroup3, (View)listView2, n3 | n2, 3);
            }
        }
        if ((listView = this.f) == null) return;
        if (this.D == null) return;
        listView.setAdapter(this.D);
        int n4 = this.E;
        if (n4 <= -1) return;
        listView.setItemChecked(n4, true);
        listView.setSelection(n4);
    }

    private void c(ViewGroup viewGroup) {
        this.w = (NestedScrollView)this.c.findViewById(android.support.v7.b.g.scrollView);
        this.w.setFocusable(false);
        this.w.setNestedScrollingEnabled(false);
        this.B = (TextView)viewGroup.findViewById(16908299);
        if (this.B == null) {
            return;
        }
        if (this.e != null) {
            this.B.setText(this.e);
            return;
        }
        this.B.setVisibility(8);
        this.w.removeView((View)this.B);
        if (this.f != null) {
            ViewGroup viewGroup2 = (ViewGroup)this.w.getParent();
            int n2 = viewGroup2.indexOfChild((View)this.w);
            viewGroup2.removeViewAt(n2);
            viewGroup2.addView((View)this.f, n2, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    static /* synthetic */ Message d(e e2) {
        return e2.s;
    }

    private void d(ViewGroup viewGroup) {
        int n2;
        int n3 = 1;
        this.n = (Button)viewGroup.findViewById(16908313);
        this.n.setOnClickListener(this.N);
        if (TextUtils.isEmpty((CharSequence)this.o)) {
            this.n.setVisibility(8);
            n2 = 0;
        } else {
            this.n.setText(this.o);
            this.n.setVisibility(0);
            n2 = n3;
        }
        this.q = (Button)viewGroup.findViewById(16908314);
        this.q.setOnClickListener(this.N);
        if (TextUtils.isEmpty((CharSequence)this.r)) {
            this.q.setVisibility(8);
        } else {
            this.q.setText(this.r);
            this.q.setVisibility(0);
            n2 |= 2;
        }
        this.t = (Button)viewGroup.findViewById(16908315);
        this.t.setOnClickListener(this.N);
        if (TextUtils.isEmpty((CharSequence)this.u)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(this.u);
            this.t.setVisibility(0);
            n2 |= 4;
        }
        if (n2 == 0) {
            n3 = 0;
        }
        if (n3 != 0) return;
        viewGroup.setVisibility(8);
    }

    static /* synthetic */ Button e(e e2) {
        return e2.t;
    }

    static /* synthetic */ Message f(e e2) {
        return e2.v;
    }

    static /* synthetic */ as g(e e2) {
        return e2.b;
    }

    static /* synthetic */ Handler h(e e2) {
        return e2.M;
    }

    static /* synthetic */ NestedScrollView i(e e2) {
        return e2.w;
    }

    static /* synthetic */ ListView j(e e2) {
        return e2.f;
    }

    static /* synthetic */ int k(e e2) {
        return e2.H;
    }

    static /* synthetic */ int l(e e2) {
        return e2.I;
    }

    static /* synthetic */ int m(e e2) {
        return e2.J;
    }

    static /* synthetic */ int n(e e2) {
        return e2.K;
    }

    public void a() {
        this.b.a(1);
        int n2 = this.b();
        this.b.setContentView(n2);
        this.c();
    }

    public void a(int n2) {
        this.g = null;
        this.h = n2;
        this.m = false;
    }

    public void a(int n2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.M.obtainMessage(n2, (Object)onClickListener);
        }
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Button does not exist");
            }
            case -1: {
                this.o = charSequence;
                this.p = message;
                return;
            }
            case -2: {
                this.r = charSequence;
                this.s = message;
                return;
            }
            case -3: 
        }
        this.u = charSequence;
        this.v = message;
    }

    public void a(Drawable drawable) {
        this.y = drawable;
        this.x = 0;
        if (this.z == null) return;
        if (drawable != null) {
            this.z.setVisibility(0);
            this.z.setImageDrawable(drawable);
            return;
        }
        this.z.setVisibility(8);
    }

    public void a(View view, int n2, int n3, int n4, int n5) {
        this.g = view;
        this.h = 0;
        this.m = true;
        this.i = n2;
        this.j = n3;
        this.k = n4;
        this.l = n5;
    }

    public void a(CharSequence charSequence) {
        this.d = charSequence;
        if (this.A == null) return;
        this.A.setText(charSequence);
    }

    public boolean a(int n2, KeyEvent keyEvent) {
        if (this.w == null) return false;
        if (!this.w.a(keyEvent)) return false;
        return true;
    }

    public void b(int n2) {
        this.y = null;
        this.x = n2;
        if (this.z == null) return;
        if (n2 != 0) {
            this.z.setVisibility(0);
            this.z.setImageResource(this.x);
            return;
        }
        this.z.setVisibility(8);
    }

    public void b(View view) {
        this.C = view;
    }

    public void b(CharSequence charSequence) {
        this.e = charSequence;
        if (this.B == null) return;
        this.B.setText(charSequence);
    }

    public boolean b(int n2, KeyEvent keyEvent) {
        if (this.w == null) return false;
        if (!this.w.a(keyEvent)) return false;
        return true;
    }

    public int c(int n2) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(n2, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.g = view;
        this.h = 0;
        this.m = false;
    }
}

