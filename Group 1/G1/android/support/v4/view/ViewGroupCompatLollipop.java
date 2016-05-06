package android.support.v4.view;

import android.view.ViewGroup;

class ViewGroupCompatLollipop
{
    ViewGroupCompatLollipop() {
        super();
    }
    
    public static int getNestedScrollAxes(final ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }
    
    public static boolean isTransitionGroup(final ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }
    
    public static void setTransitionGroup(final ViewGroup viewGroup, final boolean transitionGroup) {
        viewGroup.setTransitionGroup(transitionGroup);
    }
}
