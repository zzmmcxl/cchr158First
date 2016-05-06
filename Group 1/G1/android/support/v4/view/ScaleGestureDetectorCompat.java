package android.support.v4.view;

import android.os.Build$VERSION;

public final class ScaleGestureDetectorCompat
{
    static final ScaleGestureDetectorImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = (ScaleGestureDetectorImpl)new ScaleGestureDetectorCompatKitKatImpl();
            return;
        }
        IMPL = (ScaleGestureDetectorImpl)new BaseScaleGestureDetectorImpl();
    }
    
    private ScaleGestureDetectorCompat() {
        super();
    }
    
    public static boolean isQuickScaleEnabled(final Object o) {
        return IMPL.isQuickScaleEnabled(o);
    }
    
    public static void setQuickScaleEnabled(final Object o, final boolean b) {
        IMPL.setQuickScaleEnabled(o, b);
    }
}
