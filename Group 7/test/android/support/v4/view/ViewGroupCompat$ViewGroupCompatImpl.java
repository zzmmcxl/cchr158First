package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

interface ViewGroupCompat$ViewGroupCompatImpl {
   int getLayoutMode(ViewGroup var1);

   int getNestedScrollAxes(ViewGroup var1);

   boolean isTransitionGroup(ViewGroup var1);

   boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3);

   void setLayoutMode(ViewGroup var1, int var2);

   void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2);

   void setTransitionGroup(ViewGroup var1, boolean var2);
}
