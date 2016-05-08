package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewPager$MyAccessibilityDelegate extends AccessibilityDelegateCompat {
   ViewPager$MyAccessibilityDelegate(ViewPager var1) {
      this.this$0 = var1;
   }

   private boolean canScroll() {
      return ViewPager.access$200(this.this$0) != null && ViewPager.access$200(this.this$0).getCount() > 1;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onInitializeAccessibilityEvent(var1, var2);
      var2.setClassName(ViewPager.class.getName());
      AccessibilityRecordCompat var3 = AccessibilityEventCompat.asRecord(var2);
      var3.setScrollable(this.canScroll());
      if(var2.getEventType() == 4096 && ViewPager.access$200(this.this$0) != null) {
         var3.setItemCount(ViewPager.access$200(this.this$0).getCount());
         var3.setFromIndex(ViewPager.access$300(this.this$0));
         var3.setToIndex(ViewPager.access$300(this.this$0));
      }

   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      super.onInitializeAccessibilityNodeInfo(var1, var2);
      var2.setClassName(ViewPager.class.getName());
      var2.setScrollable(this.canScroll());
      if(this.this$0.canScrollHorizontally(1)) {
         var2.addAction(4096);
      }

      if(this.this$0.canScrollHorizontally(-1)) {
         var2.addAction(8192);
      }

   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      if(super.performAccessibilityAction(var1, var2, var3)) {
         return true;
      } else {
         switch(var2) {
         case 4096:
            if(this.this$0.canScrollHorizontally(1)) {
               this.this$0.setCurrentItem(ViewPager.access$300(this.this$0) + 1);
               return true;
            }

            return false;
         case 8192:
            if(this.this$0.canScrollHorizontally(-1)) {
               this.this$0.setCurrentItem(ViewPager.access$300(this.this$0) - 1);
               return true;
            }

            return false;
         default:
            return false;
         }
      }
   }
}
