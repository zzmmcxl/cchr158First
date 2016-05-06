package android.support.v4.widget;

import android.view.View$OnTouchListener;

static class BasePopupMenuImpl implements PopupMenuImpl
{
    BasePopupMenuImpl() {
        super();
    }
    
    @Override
    public View$OnTouchListener getDragToOpenListener(final Object o) {
        return null;
    }
}
