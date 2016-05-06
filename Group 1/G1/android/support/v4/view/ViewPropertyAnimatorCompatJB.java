package android.support.v4.view;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewPropertyAnimatorCompatJB
{
    ViewPropertyAnimatorCompatJB() {
        super();
    }
    
    public static void setListener(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener((Animator$AnimatorListener)new AnimatorListenerAdapter() {
                final /* synthetic */ ViewPropertyAnimatorListener val$listener;
                final /* synthetic */ View val$view;
                
                ViewPropertyAnimatorCompatJB$1() {
                    super();
                }
                
                public void onAnimationCancel(final Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
                
                public void onAnimationEnd(final Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
                
                public void onAnimationStart(final Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
            return;
        }
        view.animate().setListener((Animator$AnimatorListener)null);
    }
    
    public static void withEndAction(final View view, final Runnable runnable) {
        view.animate().withEndAction(runnable);
    }
    
    public static void withLayer(final View view) {
        view.animate().withLayer();
    }
    
    public static void withStartAction(final View view, final Runnable runnable) {
        view.animate().withStartAction(runnable);
    }
}
