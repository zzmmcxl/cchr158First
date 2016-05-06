package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build$VERSION;

class ViewGroupUtils
{
    private static final ViewGroupUtilsImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (ViewGroupUtilsImpl)new ViewGroupUtilsImplHoneycomb();
            return;
        }
        IMPL = (ViewGroupUtilsImpl)new ViewGroupUtilsImplBase();
    }
    
    ViewGroupUtils() {
        super();
    }
    
    static void getDescendantRect(final ViewGroup viewGroup, final View view, final Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        offsetDescendantRect(viewGroup, view, rect);
    }
    
    static void offsetDescendantRect(final ViewGroup viewGroup, final View view, final Rect rect) {
        IMPL.offsetDescendantRect(viewGroup, view, rect);
    }
}
