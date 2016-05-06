package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;

private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat
{
    final /* synthetic */ ExploreByTouchHelper this$0;
    
    private ExploreByTouchNodeProvider(final ExploreByTouchHelper this$0) {
        this$0 = this$0;
        super();
    }
    
    ExploreByTouchNodeProvider(final ExploreByTouchHelper exploreByTouchHelper, final ExploreByTouchHelper$1 object) {
        this(exploreByTouchHelper);
    }
    
    @Override
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(final int n) {
        return ExploreByTouchHelper.access$100(this$0, n);
    }
    
    @Override
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return ExploreByTouchHelper.access$200(this$0, n, n2, bundle);
    }
}
