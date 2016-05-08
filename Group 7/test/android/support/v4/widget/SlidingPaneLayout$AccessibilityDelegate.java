package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class SlidingPaneLayout$AccessibilityDelegate extends AccessibilityDelegateCompat {
   private final Rect mTmpRect;

   SlidingPaneLayout$AccessibilityDelegate(SlidingPaneLayout var1) {
      this.this$0 = var1;
      this.mTmpRect = new Rect();
   }

   private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat var1, AccessibilityNodeInfoCompat var2) {
      Rect var3 = this.mTmpRect;
      var2.getBoundsInParent(var3);
      var1.setBoundsInParent(var3);
      var2.getBoundsInScreen(var3);
      var1.setBoundsInScreen(var3);
      var1.setVisibleToUser(var2.isVisibleToUser());
      var1.setPackageName(var2.getPackageName());
      var1.setClassName(var2.getClassName());
      var1.setContentDescription(var2.getContentDescription());
      var1.setEnabled(var2.isEnabled());
      var1.setClickable(var2.isClickable());
      var1.setFocusable(var2.isFocusable());
      var1.setFocused(var2.isFocused());
      var1.setAccessibilityFocused(var2.isAccessibilityFocused());
      var1.setSelected(var2.isSelected());
      var1.setLongClickable(var2.isLongClickable());
      var1.addAction(var2.getActions());
      var1.setMovementGranularities(var2.getMovementGranularities());
   }

   public boolean filter(View var1) {
      return this.this$0.isDimmed(var1);
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onInitializeAccessibilityEvent(var1, var2);
      var2.setClassName(SlidingPaneLayout.class.getName());
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      AccessibilityNodeInfoCompat var5 = AccessibilityNodeInfoCompat.obtain(var2);
      super.onInitializeAccessibilityNodeInfo(var1, var5);
      this.copyNodeInfoNoChildren(var2, var5);
      var5.recycle();
      var2.setClassName(SlidingPaneLayout.class.getName());
      var2.setSource(var1);
      ViewParent var6 = ViewCompat.getParentForAccessibility(var1);
      if(var6 instanceof View) {
         var2.setParent((View)var6);
      }

      int var4 = this.this$0.getChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         var1 = this.this$0.getChildAt(var3);
         if(!this.filter(var1) && var1.getVisibility() == 0) {
            ViewCompat.setImportantForAccessibility(var1, 1);
            var2.addChild(var1);
         }
      }

   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return !this.filter(var2)?super.onRequestSendAccessibilityEvent(var1, var2, var3):false;
   }
}
