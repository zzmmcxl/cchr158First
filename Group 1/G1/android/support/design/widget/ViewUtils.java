package android.support.design.widget;

import android.view.View;
import android.os.Build$VERSION;

class ViewUtils
{
    static final ValueAnimatorCompat.Creator DEFAULT_ANIMATOR_CREATOR;
    private static final ViewUtilsImpl IMPL;
    
    static {
        DEFAULT_ANIMATOR_CREATOR = new ValueAnimatorCompat.Creator() {
            ViewUtils$1() {
                super();
            }
            
            @Override
            public ValueAnimatorCompat createAnimator() {
                Impl impl;
                if (Build$VERSION.SDK_INT >= 12) {
                    impl = new ValueAnimatorCompatImplHoneycombMr1();
                }
                else {
                    impl = new ValueAnimatorCompatImplEclairMr1();
                }
                return new ValueAnimatorCompat(impl);
            }
        };
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = (ViewUtilsImpl)new ViewUtilsImplLollipop();
            return;
        }
        IMPL = (ViewUtilsImpl)new ViewUtilsImplBase();
    }
    
    ViewUtils() {
        super();
    }
    
    static ValueAnimatorCompat createAnimator() {
        return DEFAULT_ANIMATOR_CREATOR.createAnimator();
    }
    
    static void setBoundsViewOutlineProvider(final View boundsViewOutlineProvider) {
        IMPL.setBoundsViewOutlineProvider(boundsViewOutlineProvider);
    }
}
