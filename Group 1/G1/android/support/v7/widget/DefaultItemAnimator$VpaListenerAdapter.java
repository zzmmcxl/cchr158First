package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListener;

private static class VpaListenerAdapter implements ViewPropertyAnimatorListener
{
    private VpaListenerAdapter() {
        super();
    }
    
    VpaListenerAdapter(final DefaultItemAnimator$1 runnable) {
        this();
    }
    
    @Override
    public void onAnimationCancel(final View view) {
    }
    
    @Override
    public void onAnimationEnd(final View view) {
    }
    
    @Override
    public void onAnimationStart(final View view) {
    }
}
