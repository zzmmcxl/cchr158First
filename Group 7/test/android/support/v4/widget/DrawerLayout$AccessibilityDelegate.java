package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

class DrawerLayout$AccessibilityDelegate extends AccessibilityDelegateCompat {
   private final Rect mTmpRect;

   DrawerLayout$AccessibilityDelegate(DrawerLayout var1) {
      this.this$0 = var1;
      this.mTmpRect = new Rect();
   }

   private void addChildrenForAccessibility(AccessibilityNodeInfoCompat var1, ViewGroup var2) {
      int var4 = var2.getChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         View var5 = var2.getChildAt(var3);
         if(DrawerLayout.access$700(var5)) {
            var1.addChild(var5);
         }
      }

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
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      if(var2.getEventType() == 32) {
         List var4 = var2.getText();
         View var5 = DrawerLayout.access$600(this.this$0);
         if(var5 != null) {
            int var3 = this.this$0.getDrawerViewAbsoluteGravity(var5);
            CharSequence var6 = this.this$0.getDrawerTitle(var3);
            if(var6 != null) {
               var4.add(var6);
            }
         }

         return true;
      } else {
         return super.dispatchPopulateAccessibilityEvent(var1, var2);
      }
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onInitializeAccessibilityEvent(var1, var2);
      var2.setClassName(DrawerLayout.class.getName());
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      if(DrawerLayout.access$500()) {
         super.onInitializeAccessibilityNodeInfo(var1, var2);
      } else {
         AccessibilityNodeInfoCompat var3 = AccessibilityNodeInfoCompat.obtain(var2);
         super.onInitializeAccessibilityNodeInfo(var1, var3);
         var2.setSource(var1);
         ViewParent var4 = ViewCompat.getParentForAccessibility(var1);
         if(var4 instanceof View) {
            var2.setParent((View)var4);
         }

         this.copyNodeInfoNoChildren(var2, var3);
         var3.recycle();
         this.addChildrenForAccessibility(var2, (ViewGroup)var1);
      }

      var2.setClassName(DrawerLayout.class.getName());
      var2.setFocusable(false);
      var2.setFocused(false);
      var2.removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_FOCUS);
      var2.removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return !DrawerLayout.access$500() && !DrawerLayout.access$700(var2)?false:super.onRequestSendAccessibilityEvent(var1, var2, var3);
   }
}
