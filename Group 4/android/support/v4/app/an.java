/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.aj;
import android.support.v4.app.ao;
import android.support.v4.app.ap;
import android.view.View;
import android.view.animation.Animation;

class an
implements Animation.AnimationListener {
    private Animation.AnimationListener a = null;
    private boolean b = false;
    private View c = null;

    public an(View view, Animation animation) {
        if (view == null) return;
        if (animation == null) {
            return;
        }
        this.c = view;
    }

    public an(View view, Animation animation, Animation.AnimationListener animationListener) {
        if (view == null) return;
        if (animation == null) {
            return;
        }
        this.a = animationListener;
        this.c = view;
    }

    static /* synthetic */ View a(an an2) {
        return an2.c;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.c != null && this.b) {
            this.c.post((Runnable)new ap(this));
        }
        if (this.a == null) return;
        this.a.onAnimationEnd(animation);
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.a == null) return;
        this.a.onAnimationRepeat(animation);
    }

    public void onAnimationStart(Animation animation) {
        if (this.c != null) {
            this.b = aj.a(this.c, animation);
            if (this.b) {
                this.c.post((Runnable)new ao(this));
            }
        }
        if (this.a == null) return;
        this.a.onAnimationStart(animation);
    }
}

