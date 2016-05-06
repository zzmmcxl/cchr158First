package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class ActionBarOverlayLayout$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ ActionBarOverlayLayout this$0;
    
    ActionBarOverlayLayout$1(final ActionBarOverlayLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationCancel(final View view) {
        ActionBarOverlayLayout.access$002(this$0, null);
        ActionBarOverlayLayout.access$102(this$0, false);
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        ActionBarOverlayLayout.access$002(this$0, null);
        ActionBarOverlayLayout.access$102(this$0, false);
    }
}