package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;
import android.os.Build$VERSION;

public final class PopupWindowCompat
{
    static final PopupWindowImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = (PopupWindowImpl)new Api23PopupWindowImpl();
            return;
        }
        if (sdk_INT >= 21) {
            IMPL = (PopupWindowImpl)new Api21PopupWindowImpl();
            return;
        }
        if (sdk_INT >= 19) {
            IMPL = (PopupWindowImpl)new KitKatPopupWindowImpl();
            return;
        }
        if (sdk_INT >= 9) {
            IMPL = (PopupWindowImpl)new GingerbreadPopupWindowImpl();
            return;
        }
        IMPL = (PopupWindowImpl)new BasePopupWindowImpl();
    }
    
    private PopupWindowCompat() {
        super();
    }
    
    public static boolean getOverlapAnchor(final PopupWindow popupWindow) {
        return IMPL.getOverlapAnchor(popupWindow);
    }
    
    public static int getWindowLayoutType(final PopupWindow popupWindow) {
        return IMPL.getWindowLayoutType(popupWindow);
    }
    
    public static void setOverlapAnchor(final PopupWindow popupWindow, final boolean b) {
        IMPL.setOverlapAnchor(popupWindow, b);
    }
    
    public static void setWindowLayoutType(final PopupWindow popupWindow, final int n) {
        IMPL.setWindowLayoutType(popupWindow, n);
    }
    
    public static void showAsDropDown(final PopupWindow popupWindow, final View view, final int n, final int n2, final int n3) {
        IMPL.showAsDropDown(popupWindow, view, n, n2, n3);
    }
}
