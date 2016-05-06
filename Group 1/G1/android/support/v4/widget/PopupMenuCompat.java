package android.support.v4.widget;

import android.view.View$OnTouchListener;
import android.os.Build$VERSION;

public final class PopupMenuCompat
{
    static final PopupMenuImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = (PopupMenuImpl)new KitKatPopupMenuImpl();
            return;
        }
        IMPL = (PopupMenuImpl)new BasePopupMenuImpl();
    }
    
    private PopupMenuCompat() {
        super();
    }
    
    public static View$OnTouchListener getDragToOpenListener(final Object o) {
        return IMPL.getDragToOpenListener(o);
    }
}
