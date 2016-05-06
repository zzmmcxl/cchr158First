package android.support.design.widget;

import android.view.ViewOutlineProvider;
import android.view.View;

class ViewUtilsLollipop
{
    ViewUtilsLollipop() {
        super();
    }
    
    static void setBoundsViewOutlineProvider(final View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }
}
