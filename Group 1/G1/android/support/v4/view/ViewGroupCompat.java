package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build$VERSION;

public final class ViewGroupCompat
{
    static final ViewGroupCompatImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = (ViewGroupCompatImpl)new ViewGroupCompatLollipopImpl();
            return;
        }
        if (sdk_INT >= 18) {
            IMPL = (ViewGroupCompatImpl)new ViewGroupCompatJellybeanMR2Impl();
            return;
        }
        if (sdk_INT >= 14) {
            IMPL = (ViewGroupCompatImpl)new ViewGroupCompatIcsImpl();
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = (ViewGroupCompatImpl)new ViewGroupCompatHCImpl();
            return;
        }
        IMPL = (ViewGroupCompatImpl)new ViewGroupCompatStubImpl();
    }
    
    private ViewGroupCompat() {
        super();
    }
    
    public static int getLayoutMode(final ViewGroup viewGroup) {
        return IMPL.getLayoutMode(viewGroup);
    }
    
    public static int getNestedScrollAxes(final ViewGroup viewGroup) {
        return IMPL.getNestedScrollAxes(viewGroup);
    }
    
    public static boolean isTransitionGroup(final ViewGroup viewGroup) {
        return IMPL.isTransitionGroup(viewGroup);
    }
    
    public static boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return IMPL.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    public static void setLayoutMode(final ViewGroup viewGroup, final int n) {
        IMPL.setLayoutMode(viewGroup, n);
    }
    
    public static void setMotionEventSplittingEnabled(final ViewGroup viewGroup, final boolean b) {
        IMPL.setMotionEventSplittingEnabled(viewGroup, b);
    }
    
    public static void setTransitionGroup(final ViewGroup viewGroup, final boolean b) {
        IMPL.setTransitionGroup(viewGroup, b);
    }
}
