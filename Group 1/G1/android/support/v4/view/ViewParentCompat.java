package android.support.v4.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;
import android.os.Build$VERSION;

public final class ViewParentCompat
{
    static final ViewParentCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = (ViewParentCompatImpl)new ViewParentCompatLollipopImpl();
            return;
        }
        if (sdk_INT >= 19) {
            IMPL = (ViewParentCompatImpl)new ViewParentCompatKitKatImpl();
            return;
        }
        if (sdk_INT >= 14) {
            IMPL = (ViewParentCompatImpl)new ViewParentCompatICSImpl();
            return;
        }
        IMPL = (ViewParentCompatImpl)new ViewParentCompatStubImpl();
    }
    
    private ViewParentCompat() {
        super();
    }
    
    public static void notifySubtreeAccessibilityStateChanged(final ViewParent viewParent, final View view, final View view2, final int n) {
        IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, n);
    }
    
    public static boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        return IMPL.onNestedFling(viewParent, view, n, n2, b);
    }
    
    public static boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        return IMPL.onNestedPreFling(viewParent, view, n, n2);
    }
    
    public static void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        IMPL.onNestedPreScroll(viewParent, view, n, n2, array);
    }
    
    public static void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        IMPL.onNestedScroll(viewParent, view, n, n2, n3, n4);
    }
    
    public static void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        IMPL.onNestedScrollAccepted(viewParent, view, view2, n);
    }
    
    public static boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        return IMPL.onStartNestedScroll(viewParent, view, view2, n);
    }
    
    public static void onStopNestedScroll(final ViewParent viewParent, final View view) {
        IMPL.onStopNestedScroll(viewParent, view);
    }
    
    public static boolean requestSendAccessibilityEvent(final ViewParent viewParent, final View view, final AccessibilityEvent accessibilityEvent) {
        return IMPL.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }
}
