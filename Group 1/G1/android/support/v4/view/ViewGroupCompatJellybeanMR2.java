package android.support.v4.view;

import android.view.ViewGroup;

class ViewGroupCompatJellybeanMR2
{
    ViewGroupCompatJellybeanMR2() {
        super();
    }
    
    public static int getLayoutMode(final ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }
    
    public static void setLayoutMode(final ViewGroup viewGroup, final int layoutMode) {
        viewGroup.setLayoutMode(layoutMode);
    }
}
