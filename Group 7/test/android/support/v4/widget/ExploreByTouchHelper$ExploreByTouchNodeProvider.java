package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.widget.ExploreByTouchHelper;

class ExploreByTouchHelper$ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
   private ExploreByTouchHelper$ExploreByTouchNodeProvider(ExploreByTouchHelper var1) {
      this.this$0 = var1;
   }

   public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int var1) {
      return ExploreByTouchHelper.access$100(this.this$0, var1);
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      return ExploreByTouchHelper.access$200(this.this$0, var1, var2, var3);
   }
}
