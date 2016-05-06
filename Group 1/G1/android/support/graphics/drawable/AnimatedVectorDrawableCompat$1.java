package android.support.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;

class AnimatedVectorDrawableCompat$1 implements Drawable$Callback {
    final /* synthetic */ AnimatedVectorDrawableCompat this$0;
    
    AnimatedVectorDrawableCompat$1(final AnimatedVectorDrawableCompat this$0) {
        this$0 = this$0;
        super();
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        this$0.invalidateSelf();
    }
    
    public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
        this$0.scheduleSelf(runnable, n);
    }
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        this$0.unscheduleSelf(runnable);
    }
}