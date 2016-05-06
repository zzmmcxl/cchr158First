package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.support.v4.view.AccessibilityDelegateCompat;

class RecyclerViewAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ RecyclerViewAccessibilityDelegate this$0;
    
    RecyclerViewAccessibilityDelegate$1(final RecyclerViewAccessibilityDelegate this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!RecyclerViewAccessibilityDelegate.access$000(this$0) && mRecyclerView.getLayoutManager() != null) {
            mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
        }
    }
    
    @Override
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return super.performAccessibilityAction(view, n, bundle) || (!RecyclerViewAccessibilityDelegate.access$000(this$0) && mRecyclerView.getLayoutManager() != null && mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, n, bundle));
    }
}