package android.support.v4.widget;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

final class DrawerLayout$ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
   DrawerLayout$ChildAccessibilityDelegate(DrawerLayout var1) {
      this.this$0 = var1;
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      super.onInitializeAccessibilityNodeInfo(var1, var2);
      if(!DrawerLayout.access$700(var1)) {
         var2.setParent((View)null);
      }

   }
}
