package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

private static class ViewGroupUtilsImplHoneycomb implements ViewGroupUtilsImpl
{
    private ViewGroupUtilsImplHoneycomb() {
        super();
    }
    
    ViewGroupUtilsImplHoneycomb(final ViewGroupUtils$1 object) {
        this();
    }
    
    @Override
    public void offsetDescendantRect(final ViewGroup viewGroup, final View view, final Rect rect) {
        ViewGroupUtilsHoneycomb.offsetDescendantRect(viewGroup, view, rect);
    }
}
