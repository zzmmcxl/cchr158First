package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompatGingerbread
{
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;
    
    PopupWindowCompatGingerbread() {
        super();
    }
    
    static int getWindowLayoutType(final PopupWindow popupWindow) {
        Label_0031: {
            if (sGetWindowLayoutTypeMethodAttempted) {
                break Label_0031;
            }
            while (true) {
                try {
                    (sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", (Class<?>[])new Class[0])).setAccessible(true);
                    sGetWindowLayoutTypeMethodAttempted = true;
                    if (sGetWindowLayoutTypeMethod != null) {
                        try {
                            return (int)sGetWindowLayoutTypeMethod.invoke(popupWindow, new Object[0]);
                        }
                        catch (Exception ex) {}
                    }
                    return 0;
                }
                catch (Exception ex2) {
                    continue;
                }
                break;
            }
        }
    }
    
    static void setWindowLayoutType(final PopupWindow popupWindow, final int n) {
        Label_0042: {
            if (sSetWindowLayoutTypeMethodAttempted) {
                break Label_0042;
            }
            while (true) {
                try {
                    (sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE)).setAccessible(true);
                    sSetWindowLayoutTypeMethodAttempted = true;
                    if (sSetWindowLayoutTypeMethod == null) {
                        return;
                    }
                    try {
                        sSetWindowLayoutTypeMethod.invoke(popupWindow, n);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {
                    continue;
                }
                break;
            }
        }
    }
}
