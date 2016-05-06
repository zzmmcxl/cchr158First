package android.support.v4.widget;

import android.view.View$OnTouchListener;

static class KitKatPopupMenuImpl extends BasePopupMenuImpl
{
    KitKatPopupMenuImpl() {
        super();
    }
    
    @Override
    public View$OnTouchListener getDragToOpenListener(final Object o) {
        return PopupMenuCompatKitKat.getDragToOpenListener(o);
    }
}
