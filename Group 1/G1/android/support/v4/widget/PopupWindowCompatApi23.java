package android.support.v4.widget;

import android.widget.PopupWindow;

class PopupWindowCompatApi23
{
    PopupWindowCompatApi23() {
        super();
    }
    
    static boolean getOverlapAnchor(final PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }
    
    static int getWindowLayoutType(final PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }
    
    static void setOverlapAnchor(final PopupWindow popupWindow, final boolean overlapAnchor) {
        popupWindow.setOverlapAnchor(overlapAnchor);
    }
    
    static void setWindowLayoutType(final PopupWindow popupWindow, final int windowLayoutType) {
        popupWindow.setWindowLayoutType(windowLayoutType);
    }
}
