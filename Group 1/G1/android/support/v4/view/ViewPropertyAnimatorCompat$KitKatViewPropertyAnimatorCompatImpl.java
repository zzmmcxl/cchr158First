package android.support.v4.view;

import android.view.View;

static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl
{
    KitKatViewPropertyAnimatorCompatImpl() {
        super();
    }
    
    @Override
    public void setUpdateListener(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        ViewPropertyAnimatorCompatKK.setUpdateListener(view, viewPropertyAnimatorUpdateListener);
    }
}
