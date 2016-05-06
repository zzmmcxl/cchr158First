package android.support.v4.view;

import android.view.View;

static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl
{
    JBViewPropertyAnimatorCompatImpl() {
        super();
    }
    
    @Override
    public void setListener(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
    }
    
    @Override
    public void withEndAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable runnable) {
        ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
    }
    
    @Override
    public void withLayer(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        ViewPropertyAnimatorCompatJB.withLayer(view);
    }
    
    @Override
    public void withStartAction(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final Runnable runnable) {
        ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
    }
}
