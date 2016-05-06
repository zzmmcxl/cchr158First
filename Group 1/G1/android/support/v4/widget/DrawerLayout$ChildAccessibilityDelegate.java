package android.support.v4.widget;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.support.v4.view.AccessibilityDelegateCompat;

final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat
{
    final /* synthetic */ DrawerLayout this$0;
    
    ChildAccessibilityDelegate(final DrawerLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!DrawerLayout.access$700(view)) {
            accessibilityNodeInfoCompat.setParent(null);
        }
    }
}
