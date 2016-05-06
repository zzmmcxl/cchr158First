package android.support.design.widget;

import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.support.v4.view.OnApplyWindowInsetsListener;

private class ApplyInsetsListener implements OnApplyWindowInsetsListener
{
    final /* synthetic */ CoordinatorLayout this$0;
    
    private ApplyInsetsListener(final CoordinatorLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    ApplyInsetsListener(final CoordinatorLayout coordinatorLayout, final CoordinatorLayout$1 comparator) {
        this(coordinatorLayout);
    }
    
    @Override
    public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return CoordinatorLayout.access$200(this$0, windowInsetsCompat);
    }
}
