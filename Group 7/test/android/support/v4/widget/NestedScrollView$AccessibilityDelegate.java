package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

class NestedScrollView$AccessibilityDelegate extends AccessibilityDelegateCompat {
   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onInitializeAccessibilityEvent(var1, var2);
      NestedScrollView var4 = (NestedScrollView)var1;
      var2.setClassName(ScrollView.class.getName());
      AccessibilityRecordCompat var5 = AccessibilityEventCompat.asRecord(var2);
      boolean var3;
      if(NestedScrollView.access$000(var4) > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      var5.setScrollable(var3);
      var5.setScrollX(var4.getScrollX());
      var5.setScrollY(var4.getScrollY());
      var5.setMaxScrollX(var4.getScrollX());
      var5.setMaxScrollY(NestedScrollView.access$000(var4));
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      super.onInitializeAccessibilityNodeInfo(var1, var2);
      NestedScrollView var4 = (NestedScrollView)var1;
      var2.setClassName(ScrollView.class.getName());
      if(var4.isEnabled()) {
         int var3 = NestedScrollView.access$000(var4);
         if(var3 > 0) {
            var2.setScrollable(true);
            if(var4.getScrollY() > 0) {
               var2.addAction(8192);
            }

            if(var4.getScrollY() < var3) {
               var2.addAction(4096);
            }
         }
      }

   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      if(super.performAccessibilityAction(var1, var2, var3)) {
         return true;
      } else {
         NestedScrollView var6 = (NestedScrollView)var1;
         if(!var6.isEnabled()) {
            return false;
         } else {
            int var4;
            int var5;
            switch(var2) {
            case 4096:
               var2 = var6.getHeight();
               var4 = var6.getPaddingBottom();
               var5 = var6.getPaddingTop();
               var2 = Math.min(var6.getScrollY() + (var2 - var4 - var5), NestedScrollView.access$000(var6));
               if(var2 != var6.getScrollY()) {
                  var6.smoothScrollTo(0, var2);
                  return true;
               }

               return false;
            case 8192:
               var2 = var6.getHeight();
               var4 = var6.getPaddingBottom();
               var5 = var6.getPaddingTop();
               var2 = Math.max(var6.getScrollY() - (var2 - var4 - var5), 0);
               if(var2 != var6.getScrollY()) {
                  var6.smoothScrollTo(0, var2);
                  return true;
               }

               return false;
            default:
               return false;
            }
         }
      }
   }
}
