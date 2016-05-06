package android.support.design.widget;

import android.view.ViewTreeObserver$OnPreDrawListener;

class OnPreDrawListener implements ViewTreeObserver$OnPreDrawListener
{
    final /* synthetic */ CoordinatorLayout this$0;
    
    OnPreDrawListener(final CoordinatorLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public boolean onPreDraw() {
        this$0.dispatchOnDependentViewChanged(false);
        return true;
    }
}
