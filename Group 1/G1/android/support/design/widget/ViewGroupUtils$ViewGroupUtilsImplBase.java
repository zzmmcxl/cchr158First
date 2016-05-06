package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

private static class ViewGroupUtilsImplBase implements ViewGroupUtilsImpl
{
    private ViewGroupUtilsImplBase() {
        super();
    }
    
    ViewGroupUtilsImplBase(final ViewGroupUtils$1 object) {
        this();
    }
    
    @Override
    public void offsetDescendantRect(final ViewGroup viewGroup, final View view, final Rect rect) {
        viewGroup.offsetDescendantRectToMyCoords(view, rect);
        rect.offset(view.getScrollX(), view.getScrollY());
    }
}
