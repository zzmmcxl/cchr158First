package android.support.v4.widget;

import android.view.View$OnTouchListener;
import android.view.View;
import android.os.Build$VERSION;

public final class ListPopupWindowCompat
{
    static final ListPopupWindowImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = (ListPopupWindowImpl)new KitKatListPopupWindowImpl();
            return;
        }
        IMPL = (ListPopupWindowImpl)new BaseListPopupWindowImpl();
    }
    
    private ListPopupWindowCompat() {
        super();
    }
    
    public static View$OnTouchListener createDragToOpenListener(final Object o, final View view) {
        return IMPL.createDragToOpenListener(o, view);
    }
}
