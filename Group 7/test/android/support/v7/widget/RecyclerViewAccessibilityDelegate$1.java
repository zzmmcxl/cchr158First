package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;

class RecyclerViewAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
   RecyclerViewAccessibilityDelegate$1(RecyclerViewAccessibilityDelegate var1) {
      this.this$0 = var1;
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      super.onInitializeAccessibilityNodeInfo(var1, var2);
      if(!RecyclerViewAccessibilityDelegate.access$000(this.this$0) && this.this$0.mRecyclerView.getLayoutManager() != null) {
         this.this$0.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(var1, var2);
      }

   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return super.performAccessibilityAction(var1, var2, var3)?true:(!RecyclerViewAccessibilityDelegate.access$000(this.this$0) && this.this$0.mRecyclerView.getLayoutManager() != null?this.this$0.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(var1, var2, var3):false);
   }
}
