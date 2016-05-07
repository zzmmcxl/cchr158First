/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.a.a.l;
import android.support.v4.g.a;
import java.util.ArrayList;

class d
extends Drawable.ConstantState {
    int a;
    l b;
    ArrayList c;
    a d;

    public d(Context context, d d2, Drawable.Callback callback, Resources resources) {
        int n2 = 0;
        if (d2 == null) return;
        this.a = d2.a;
        if (d2.b != null) {
            Drawable.ConstantState constantState = d2.b.getConstantState();
            this.b = resources != null ? (l)constantState.newDrawable(resources) : (l)constantState.newDrawable();
            this.b = (l)this.b.mutate();
            this.b.setCallback(callback);
            this.b.setBounds(d2.b.getBounds());
            this.b.a(false);
        }
        if (d2.c == null) return;
        int n3 = d2.c.size();
        this.c = new ArrayList(n3);
        this.d = new a(n3);
        while (n2 < n3) {
            Animator animator = (Animator)d2.c.get(n2);
            Animator animator2 = animator.clone();
            String string = (String)d2.d.get((Object)animator);
            animator2.setTarget(this.b.a(string));
            this.c.add(animator2);
            this.d.put((Object)animator2, string);
            ++n2;
        }
    }

    public int getChangingConfigurations() {
        return this.a;
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 21.");
    }

    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 21.");
    }
}

