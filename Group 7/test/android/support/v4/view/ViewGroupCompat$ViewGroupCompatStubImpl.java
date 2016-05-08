package android.support.v4.view;

import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatImpl;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class ViewGroupCompat$ViewGroupCompatStubImpl implements ViewGroupCompat$ViewGroupCompatImpl {
   public int getLayoutMode(ViewGroup var1) {
      return 0;
   }

   public int getNestedScrollAxes(ViewGroup var1) {
      return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).getNestedScrollAxes():0;
   }

   public boolean isTransitionGroup(ViewGroup var1) {
      return false;
   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return true;
   }

   public void setLayoutMode(ViewGroup var1, int var2) {
   }

   public void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2) {
   }

   public void setTransitionGroup(ViewGroup var1, boolean var2) {
   }
}
