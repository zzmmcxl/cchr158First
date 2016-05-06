package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup$OnHierarchyChangeListener;

private class HierarchyChangeListener implements ViewGroup$OnHierarchyChangeListener
{
    final /* synthetic */ CoordinatorLayout this$0;
    
    private HierarchyChangeListener(final CoordinatorLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    HierarchyChangeListener(final CoordinatorLayout coordinatorLayout, final CoordinatorLayout$1 comparator) {
        this(coordinatorLayout);
    }
    
    public void onChildViewAdded(final View view, final View view2) {
        if (CoordinatorLayout.access$300(this$0) != null) {
            CoordinatorLayout.access$300(this$0).onChildViewAdded(view, view2);
        }
    }
    
    public void onChildViewRemoved(final View view, final View view2) {
        this$0.dispatchDependentViewRemoved(view2);
        if (CoordinatorLayout.access$300(this$0) != null) {
            CoordinatorLayout.access$300(this$0).onChildViewRemoved(view, view2);
        }
    }
}
