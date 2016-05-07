/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.graphics.drawable.Drawable;
import android.support.a.a.b;

class c
implements Drawable.Callback {
    final /* synthetic */ b a;

    c(b b2) {
        this.a = b2;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        this.a.scheduleSelf(runnable, l2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.a.unscheduleSelf(runnable);
    }
}

