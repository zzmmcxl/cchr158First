package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class PopupWindowCompatApi21
{
    private static final String TAG = "PopupWindowCompatApi21";
    private static Field sOverlapAnchorField;
    
    static {
        try {
            (sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor")).setAccessible(true);
        }
        catch (NoSuchFieldException ex) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", (Throwable)ex);
        }
    }
    
    PopupWindowCompatApi21() {
        super();
    }
    
    static boolean getOverlapAnchor(final PopupWindow popupWindow) {
        if (sOverlapAnchorField != null) {
            try {
                return (boolean)sOverlapAnchorField.get(popupWindow);
            }
            catch (IllegalAccessException ex) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", (Throwable)ex);
            }
        }
        return false;
    }
    
    static void setOverlapAnchor(final PopupWindow popupWindow, final boolean b) {
        if (sOverlapAnchorField == null) {
            return;
        }
        try {
            sOverlapAnchorField.set(popupWindow, b);
        }
        catch (IllegalAccessException ex) {
            Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", (Throwable)ex);
        }
    }
}
