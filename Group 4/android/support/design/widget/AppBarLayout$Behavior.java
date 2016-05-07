/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$Behavior$SavedState;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.a;
import android.support.design.widget.aq;
import android.support.design.widget.at;
import android.support.design.widget.bu;
import android.support.design.widget.bw;
import android.support.design.widget.cn;
import android.support.design.widget.d;
import android.support.design.widget.e;
import android.support.design.widget.g;
import android.support.design.widget.h;
import android.support.v4.h.bo;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout$Behavior
extends aq {
    private int a;
    private boolean b;
    private boolean c;
    private bu d;
    private int e = -1;
    private boolean f;
    private float g;
    private WeakReference h;
    private e i;

    public AppBarLayout$Behavior() {
    }

    public AppBarLayout$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ int a(AppBarLayout$Behavior appBarLayout$Behavior) {
        return appBarLayout$Behavior.a;
    }

    private View a(AppBarLayout appBarLayout, int n2) {
        int n3 = appBarLayout.getChildCount();
        int n4 = 0;
        while (n4 < n3) {
            View view = appBarLayout.getChildAt(n4);
            if (view.getTop() <= - n2 && view.getBottom() >= - n2) {
                return view;
            }
            ++n4;
        }
        return null;
    }

    private int b(AppBarLayout appBarLayout, int n2) {
        Interpolator interpolator;
        View view;
        int n3;
        int n4;
        block5 : {
            block4 : {
                n4 = Math.abs(n2);
                int n5 = appBarLayout.getChildCount();
                int n6 = 0;
                while (n6 < n5) {
                    view = appBarLayout.getChildAt(n6);
                    g g2 = (g)view.getLayoutParams();
                    interpolator = g2.b();
                    if (n4 >= view.getTop() && n4 <= view.getBottom()) {
                        if (interpolator == null) return n2;
                        int n7 = g2.a();
                        if ((n7 & 1) == 0) break block4;
                        n3 = 0 + (view.getHeight() + g2.topMargin + g2.bottomMargin);
                        if ((n7 & 2) != 0) {
                            n3 -= bo.p(view);
                        }
                        break block5;
                    }
                    ++n6;
                }
                return n2;
            }
            n3 = 0;
        }
        if (bo.t(view)) {
            n3 -= AppBarLayout.i(appBarLayout);
        }
        if (n3 <= 0) return n2;
        int n8 = n4 - view.getTop();
        int n9 = Math.round((float)n3 * interpolator.getInterpolation((float)n8 / (float)n3));
        return Integer.signum(n2) * (n9 + view.getTop());
    }

    private void b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n2) {
        int n3 = this.a();
        if (n3 == n2) {
            if (this.d == null) return;
            if (!this.d.b()) return;
            this.d.e();
            return;
        }
        if (this.d == null) {
            this.d = cn.a();
            this.d.a(a.e);
            this.d.a(new d(this, coordinatorLayout, appBarLayout));
        } else {
            this.d.e();
        }
        float f2 = (float)Math.abs(n3 - n2) / coordinatorLayout.getResources().getDisplayMetrics().density;
        this.d.a(Math.round(f2 * 1000.0f / 300.0f));
        this.d.a(n3, n2);
        this.d.a();
    }

    private void c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        int n2 = this.a();
        View view = this.a(appBarLayout, n2);
        if (view == null) return;
        g g2 = (g)view.getLayoutParams();
        if ((17 & g2.a()) != 17) return;
        int n3 = - view.getTop();
        int n4 = - view.getBottom();
        int n5 = (2 & g2.a()) == 2 ? n4 + bo.p(view) : n4;
        if (n2 >= (n5 + n3) / 2) {
            n5 = n3;
        }
        this.b(coordinatorLayout, appBarLayout, at.a(n5, - appBarLayout.getTotalScrollRange(), 0));
    }

    private void d(AppBarLayout appBarLayout) {
        List list = AppBarLayout.h(appBarLayout);
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            h h2 = (h)list.get(n3);
            if (h2 != null) {
                h2.a(appBarLayout, this.b());
            }
            ++n3;
        }
    }

    @Override
    int a() {
        return this.b() + this.a;
    }

    int a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n2, int n3, int n4) {
        int n5 = this.a();
        if (n3 != 0 && n5 >= n3 && n5 <= n4) {
            int n6 = at.a(n2, n3, n4);
            int n7 = 0;
            if (n5 == n6) return n7;
            int n8 = AppBarLayout.g(appBarLayout) ? this.b(appBarLayout, n6) : n6;
            boolean bl2 = this.a(n8);
            int n9 = n5 - n6;
            this.a = n6 - n8;
            if (!bl2 && AppBarLayout.g(appBarLayout)) {
                coordinatorLayout.c((View)appBarLayout);
            }
            this.d(appBarLayout);
            return n9;
        }
        this.a = 0;
        return 0;
    }

    @Override
    /* synthetic */ int a(View view) {
        return this.c((AppBarLayout)view);
    }

    void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c(coordinatorLayout, appBarLayout);
    }

    public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
        if (parcelable instanceof AppBarLayout$Behavior$SavedState) {
            AppBarLayout$Behavior$SavedState appBarLayout$Behavior$SavedState = (AppBarLayout$Behavior$SavedState)parcelable;
            super.a(coordinatorLayout, (View)appBarLayout, appBarLayout$Behavior$SavedState.getSuperState());
            this.e = appBarLayout$Behavior$SavedState.a;
            this.g = appBarLayout$Behavior$SavedState.b;
            this.f = appBarLayout$Behavior$SavedState.c;
            return;
        }
        super.a(coordinatorLayout, (View)appBarLayout, parcelable);
        this.e = -1;
    }

    public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
        if (!this.c) {
            this.c(coordinatorLayout, appBarLayout);
        }
        this.b = false;
        this.c = false;
        this.h = new WeakReference<View>(view);
    }

    public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int n2, int n3, int n4, int n5) {
        if (n5 < 0) {
            this.b(coordinatorLayout, (View)appBarLayout, n5, - AppBarLayout.d(appBarLayout), 0);
            this.b = true;
            return;
        }
        this.b = false;
    }

    public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int n2, int n3, int[] arrn) {
        int n4;
        int n5;
        if (n3 == 0) return;
        if (this.b) return;
        if (n3 < 0) {
            n4 = - appBarLayout.getTotalScrollRange();
            n5 = n4 + AppBarLayout.b(appBarLayout);
        } else {
            n4 = - AppBarLayout.c(appBarLayout);
            n5 = 0;
        }
        arrn[1] = this.b(coordinatorLayout, (View)appBarLayout, n3, n4, n5);
    }

    boolean a(AppBarLayout appBarLayout) {
        if (this.i != null) {
            return this.i.a(appBarLayout);
        }
        if (this.h == null) return true;
        View view = (View)this.h.get();
        if (view == null) return false;
        if (!view.isShown()) return false;
        if (bo.b(view, -1)) return false;
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n2) {
        boolean bl2 = super.a(coordinatorLayout, (View)appBarLayout, n2);
        int n3 = AppBarLayout.e(appBarLayout);
        if (n3 != 0) {
            boolean bl3 = (n3 & 4) != 0;
            if ((n3 & 2) != 0) {
                int n4 = - AppBarLayout.c(appBarLayout);
                if (bl3) {
                    this.b(coordinatorLayout, appBarLayout, n4);
                } else {
                    this.a_(coordinatorLayout, (View)appBarLayout, n4);
                }
            } else if ((n3 & 1) != 0) {
                if (bl3) {
                    this.b(coordinatorLayout, appBarLayout, 0);
                } else {
                    this.a_(coordinatorLayout, (View)appBarLayout, 0);
                }
            }
        } else if (this.e >= 0) {
            View view = appBarLayout.getChildAt(this.e);
            int n5 = - view.getBottom();
            int n6 = this.f ? n5 + bo.p(view) : n5 + Math.round((float)view.getHeight() * this.g);
            this.a(n6);
        }
        AppBarLayout.f(appBarLayout);
        this.e = -1;
        this.a(at.a(this.b(), - appBarLayout.getTotalScrollRange(), 0));
        this.d(appBarLayout);
        return bl2;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3, boolean bl2) {
        boolean bl3;
        if (!bl2) {
            bl3 = this.a(coordinatorLayout, (View)appBarLayout, - appBarLayout.getTotalScrollRange(), 0, - f3);
        } else if (f3 < 0.0f) {
            int n2 = - appBarLayout.getTotalScrollRange() + AppBarLayout.b(appBarLayout);
            int n3 = this.a();
            bl3 = false;
            if (n3 < n2) {
                this.b(coordinatorLayout, appBarLayout, n2);
                bl3 = true;
            }
        } else {
            int n4 = - AppBarLayout.c(appBarLayout);
            int n5 = this.a();
            bl3 = false;
            if (n5 > n4) {
                this.b(coordinatorLayout, appBarLayout, n4);
                bl3 = true;
            }
        }
        this.c = bl3;
        return bl3;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int n2) {
        boolean bl2 = (n2 & 2) != 0 && AppBarLayout.a(appBarLayout) && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        if (bl2 && this.d != null) {
            this.d.e();
        }
        this.h = null;
        return bl2;
    }

    int b(AppBarLayout appBarLayout) {
        return - AppBarLayout.d(appBarLayout);
    }

    public Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        Parcelable parcelable = super.b(coordinatorLayout, (View)appBarLayout);
        int n2 = this.b();
        int n3 = appBarLayout.getChildCount();
        int n4 = 0;
        while (n4 < n3) {
            View view = appBarLayout.getChildAt(n4);
            int n5 = n2 + view.getBottom();
            if (n2 + view.getTop() <= 0 && n5 >= 0) {
                AppBarLayout$Behavior$SavedState appBarLayout$Behavior$SavedState = new AppBarLayout$Behavior$SavedState(parcelable);
                appBarLayout$Behavior$SavedState.a = n4;
                int n6 = bo.p(view);
                boolean bl2 = false;
                if (n5 == n6) {
                    bl2 = true;
                }
                appBarLayout$Behavior$SavedState.c = bl2;
                appBarLayout$Behavior$SavedState.b = (float)n5 / (float)view.getHeight();
                return appBarLayout$Behavior$SavedState;
            }
            ++n4;
        }
        return parcelable;
    }

    int c(AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange();
    }

    @Override
    /* synthetic */ boolean c(View view) {
        return this.a((AppBarLayout)view);
    }
}

