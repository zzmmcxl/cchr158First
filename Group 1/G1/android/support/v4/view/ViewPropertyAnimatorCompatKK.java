package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompatKK
{
    ViewPropertyAnimatorCompatKK() {
        super();
    }
    
    public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        Object updateListener = null;
        if (viewPropertyAnimatorUpdateListener != null) {
            updateListener = new ValueAnimator$AnimatorUpdateListener() {
                final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
                final /* synthetic */ View val$view;
                
                ViewPropertyAnimatorCompatKK$1() {
                    super();
                }
                
                public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                }
            };
        }
        view.animate().setUpdateListener((ValueAnimator$AnimatorUpdateListener)updateListener);
    }
}
