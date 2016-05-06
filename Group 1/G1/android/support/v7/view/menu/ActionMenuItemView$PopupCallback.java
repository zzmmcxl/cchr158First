package android.support.v7.view.menu;

import android.support.v7.widget.ListPopupWindow;

public abstract static class PopupCallback
{
    public PopupCallback() {
        super();
    }
    
    public abstract ListPopupWindow getPopup();
}
