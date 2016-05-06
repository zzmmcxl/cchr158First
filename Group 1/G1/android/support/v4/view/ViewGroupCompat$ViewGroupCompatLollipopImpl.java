package android.support.v4.view;

import android.view.ViewGroup;

static class ViewGroupCompatLollipopImpl extends ViewGroupCompatJellybeanMR2Impl
{
    ViewGroupCompatLollipopImpl() {
        super();
    }
    
    @Override
    public int getNestedScrollAxes(final ViewGroup viewGroup) {
        return ViewGroupCompatLollipop.getNestedScrollAxes(viewGroup);
    }
    
    @Override
    public boolean isTransitionGroup(final ViewGroup viewGroup) {
        return ViewGroupCompatLollipop.isTransitionGroup(viewGroup);
    }
    
    @Override
    public void setTransitionGroup(final ViewGroup viewGroup, final boolean b) {
        ViewGroupCompatLollipop.setTransitionGroup(viewGroup, b);
    }
}
