package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

static class ViewParentCompatLollipopImpl extends ViewParentCompatKitKatImpl
{
    ViewParentCompatLollipopImpl() {
        super();
    }
    
    @Override
    public boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        return ViewParentCompatLollipop.onNestedFling(viewParent, view, n, n2, b);
    }
    
    @Override
    public boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        return ViewParentCompatLollipop.onNestedPreFling(viewParent, view, n, n2);
    }
    
    @Override
    public void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        ViewParentCompatLollipop.onNestedPreScroll(viewParent, view, n, n2, array);
    }
    
    @Override
    public void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        ViewParentCompatLollipop.onNestedScroll(viewParent, view, n, n2, n3, n4);
    }
    
    @Override
    public void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        ViewParentCompatLollipop.onNestedScrollAccepted(viewParent, view, view2, n);
    }
    
    @Override
    public boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        return ViewParentCompatLollipop.onStartNestedScroll(viewParent, view, view2, n);
    }
    
    @Override
    public void onStopNestedScroll(final ViewParent viewParent, final View view) {
        ViewParentCompatLollipop.onStopNestedScroll(viewParent, view);
    }
}
