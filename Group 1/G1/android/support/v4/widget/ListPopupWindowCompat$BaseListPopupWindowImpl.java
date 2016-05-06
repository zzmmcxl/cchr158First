package android.support.v4.widget;

import android.view.View$OnTouchListener;
import android.view.View;

static class BaseListPopupWindowImpl implements ListPopupWindowImpl
{
    BaseListPopupWindowImpl() {
        super();
    }
    
    @Override
    public View$OnTouchListener createDragToOpenListener(final Object o, final View view) {
        return null;
    }
}
