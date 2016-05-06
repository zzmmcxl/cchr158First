package android.support.design.widget;

import android.view.View;

private static class ViewUtilsImplLollipop implements ViewUtilsImpl
{
    private ViewUtilsImplLollipop() {
        super();
    }
    
    ViewUtilsImplLollipop(final ViewUtils$1 creator) {
        this();
    }
    
    @Override
    public void setBoundsViewOutlineProvider(final View boundsViewOutlineProvider) {
        ViewUtilsLollipop.setBoundsViewOutlineProvider(boundsViewOutlineProvider);
    }
}
