/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.bo;
import android.support.design.widget.bp;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class bn {
    private final ArrayList a = new ArrayList();
    private bp b = null;
    private Animation c = null;
    private WeakReference d;
    private Animation.AnimationListener e;

    bn() {
        this.e = new bo(this);
    }

    static /* synthetic */ Animation a(bn bn2) {
        return bn2.c;
    }

    static /* synthetic */ Animation a(bn bn2, Animation animation) {
        bn2.c = animation;
        return animation;
    }

    private void a(bp bp2) {
        this.c = bp2.b;
        View view = this.a();
        if (view == null) return;
        view.startAnimation(this.c);
    }

    private void c() {
        View view = this.a();
        int n2 = this.a.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.d = null;
                this.b = null;
                this.c = null;
                return;
            }
            Animation animation = ((bp)this.a.get((int)n3)).b;
            if (view.getAnimation() == animation) {
                view.clearAnimation();
            }
            ++n3;
        } while (true);
    }

    private void d() {
        if (this.c == null) return;
        View view = this.a();
        if (view != null && view.getAnimation() == this.c) {
            view.clearAnimation();
        }
        this.c = null;
    }

    View a() {
        if (this.d != null) return (View)this.d.get();
        return null;
    }

    void a(View view) {
        View view2 = this.a();
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            this.c();
        }
        if (view == null) return;
        this.d = new WeakReference<View>(view);
    }

    /*
     * Unable to fully structure code
     */
    void a(int[] var1_1) {
        var2_2 = this.a.size();
        var3_3 = 0;
        do {
            var4_4 = null;
            if (var3_3 >= var2_2) ** GOTO lbl9
            var6_5 = (bp)this.a.get(var3_3);
            if (StateSet.stateSetMatches((int[])var6_5.a, (int[])var1_1)) {
                var4_4 = var6_5;
lbl9: // 2 sources:
                if (var4_4 != this.b) break;
                return;
            }
            ++var3_3;
        } while (true);
        if (this.b != null) {
            this.d();
        }
        this.b = var4_4;
        var5_6 = (View)this.d.get();
        if (var4_4 == null) return;
        if (var5_6 == null) return;
        if (var5_6.getVisibility() != 0) return;
        this.a(var4_4);
    }

    public void a(int[] arrn, Animation animation) {
        bp bp2 = new bp(arrn, animation, null);
        animation.setAnimationListener(this.e);
        this.a.add(bp2);
    }

    public void b() {
        if (this.c == null) return;
        View view = this.a();
        if (view == null) return;
        if (view.getAnimation() != this.c) return;
        view.clearAnimation();
    }
}

