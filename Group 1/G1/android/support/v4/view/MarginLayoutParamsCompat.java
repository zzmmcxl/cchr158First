package android.support.v4.view;

import android.view.ViewGroup$MarginLayoutParams;
import android.os.Build$VERSION;

public final class MarginLayoutParamsCompat
{
    static final MarginLayoutParamsCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 17) {
            IMPL = (MarginLayoutParamsCompatImpl)new MarginLayoutParamsCompatImplJbMr1();
            return;
        }
        IMPL = (MarginLayoutParamsCompatImpl)new MarginLayoutParamsCompatImplBase();
    }
    
    private MarginLayoutParamsCompat() {
        super();
    }
    
    public static int getLayoutDirection(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        int layoutDirection = IMPL.getLayoutDirection(viewGroup$MarginLayoutParams);
        if (layoutDirection != 0 && layoutDirection != 1) {
            layoutDirection = 0;
        }
        return layoutDirection;
    }
    
    public static int getMarginEnd(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return IMPL.getMarginEnd(viewGroup$MarginLayoutParams);
    }
    
    public static int getMarginStart(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return IMPL.getMarginStart(viewGroup$MarginLayoutParams);
    }
    
    public static boolean isMarginRelative(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return IMPL.isMarginRelative(viewGroup$MarginLayoutParams);
    }
    
    public static void resolveLayoutDirection(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
        IMPL.resolveLayoutDirection(viewGroup$MarginLayoutParams, n);
    }
    
    public static void setLayoutDirection(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
        IMPL.setLayoutDirection(viewGroup$MarginLayoutParams, n);
    }
    
    public static void setMarginEnd(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
        IMPL.setMarginEnd(viewGroup$MarginLayoutParams, n);
    }
    
    public static void setMarginStart(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
        IMPL.setMarginStart(viewGroup$MarginLayoutParams, n);
    }
}
