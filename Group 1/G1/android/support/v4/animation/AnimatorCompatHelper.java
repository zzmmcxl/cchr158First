package android.support.v4.animation;

import android.view.View;
import android.os.Build$VERSION;

public final class AnimatorCompatHelper
{
    private static final AnimatorProvider IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 12) {
            IMPL = new HoneycombMr1AnimatorCompatProvider();
            return;
        }
        IMPL = new DonutAnimatorCompatProvider();
    }
    
    private AnimatorCompatHelper() {
        super();
    }
    
    public static void clearInterpolator(final View view) {
        IMPL.clearInterpolator(view);
    }
    
    public static ValueAnimatorCompat emptyValueAnimator() {
        return IMPL.emptyValueAnimator();
    }
}
