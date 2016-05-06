package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewGroup;

static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl
{
    ViewGroupCompatStubImpl() {
        super();
    }
    
    @Override
    public int getLayoutMode(final ViewGroup viewGroup) {
        return 0;
    }
    
    @Override
    public int getNestedScrollAxes(final ViewGroup viewGroup) {
        if (viewGroup instanceof NestedScrollingParent) {
            return ((NestedScrollingParent)viewGroup).getNestedScrollAxes();
        }
        return 0;
    }
    
    @Override
    public boolean isTransitionGroup(final ViewGroup viewGroup) {
        return false;
    }
    
    @Override
    public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return true;
    }
    
    @Override
    public void setLayoutMode(final ViewGroup viewGroup, final int n) {
    }
    
    @Override
    public void setMotionEventSplittingEnabled(final ViewGroup viewGroup, final boolean b) {
    }
    
    @Override
    public void setTransitionGroup(final ViewGroup viewGroup, final boolean b) {
    }
}
