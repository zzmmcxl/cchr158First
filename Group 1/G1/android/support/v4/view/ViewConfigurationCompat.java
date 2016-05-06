package android.support.v4.view;

import android.view.ViewConfiguration;
import android.os.Build$VERSION;

public final class ViewConfigurationCompat
{
    static final ViewConfigurationVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (ViewConfigurationVersionImpl)new IcsViewConfigurationVersionImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (ViewConfigurationVersionImpl)new HoneycombViewConfigurationVersionImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 8) {
            IMPL = (ViewConfigurationVersionImpl)new FroyoViewConfigurationVersionImpl();
            return;
        }
        IMPL = (ViewConfigurationVersionImpl)new BaseViewConfigurationVersionImpl();
    }
    
    private ViewConfigurationCompat() {
        super();
    }
    
    public static int getScaledPagingTouchSlop(final ViewConfiguration viewConfiguration) {
        return IMPL.getScaledPagingTouchSlop(viewConfiguration);
    }
    
    public static boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return IMPL.hasPermanentMenuKey(viewConfiguration);
    }
}
