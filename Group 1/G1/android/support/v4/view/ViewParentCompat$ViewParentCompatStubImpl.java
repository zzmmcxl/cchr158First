package android.support.v4.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;

static class ViewParentCompatStubImpl implements ViewParentCompatImpl
{
    ViewParentCompatStubImpl() {
        super();
    }
    
    @Override
    public void notifySubtreeAccessibilityStateChanged(final ViewParent viewParent, final View view, final View view2, final int n) {
    }
    
    @Override
    public boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        return viewParent instanceof NestedScrollingParent && ((NestedScrollingParent)viewParent).onNestedFling(view, n, n2, b);
    }
    
    @Override
    public boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        return viewParent instanceof NestedScrollingParent && ((NestedScrollingParent)viewParent).onNestedPreFling(view, n, n2);
    }
    
    @Override
    public void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onNestedPreScroll(view, n, n2, array);
        }
    }
    
    @Override
    public void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onNestedScroll(view, n, n2, n3, n4);
        }
    }
    
    @Override
    public void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onNestedScrollAccepted(view, view2, n);
        }
    }
    
    @Override
    public boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        return viewParent instanceof NestedScrollingParent && ((NestedScrollingParent)viewParent).onStartNestedScroll(view, view2, n);
    }
    
    @Override
    public void onStopNestedScroll(final ViewParent viewParent, final View view) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent)viewParent).onStopNestedScroll(view);
        }
    }
    
    @Override
    public boolean requestSendAccessibilityEvent(final ViewParent viewParent, final View view, final AccessibilityEvent accessibilityEvent) {
        if (view == null) {
            return false;
        }
        ((AccessibilityManager)view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
        return true;
    }
}
