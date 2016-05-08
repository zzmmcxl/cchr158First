package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatHCImpl;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatIcsImpl;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatImpl;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatLollipopImpl;
import android.support.v4.view.ViewGroupCompat$ViewGroupCompatStubImpl;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat {
   static final ViewGroupCompat$ViewGroupCompatImpl IMPL;
   public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
   public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ViewGroupCompat$ViewGroupCompatLollipopImpl();
      } else if(var0 >= 18) {
         IMPL = new ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl();
      } else if(var0 >= 14) {
         IMPL = new ViewGroupCompat$ViewGroupCompatIcsImpl();
      } else if(var0 >= 11) {
         IMPL = new ViewGroupCompat$ViewGroupCompatHCImpl();
      } else {
         IMPL = new ViewGroupCompat$ViewGroupCompatStubImpl();
      }
   }

   public static int getLayoutMode(ViewGroup var0) {
      return IMPL.getLayoutMode(var0);
   }

   public static int getNestedScrollAxes(ViewGroup var0) {
      return IMPL.getNestedScrollAxes(var0);
   }

   public static boolean isTransitionGroup(ViewGroup var0) {
      return IMPL.isTransitionGroup(var0);
   }

   public static boolean onRequestSendAccessibilityEvent(ViewGroup var0, View var1, AccessibilityEvent var2) {
      return IMPL.onRequestSendAccessibilityEvent(var0, var1, var2);
   }

   public static void setLayoutMode(ViewGroup var0, int var1) {
      IMPL.setLayoutMode(var0, var1);
   }

   public static void setMotionEventSplittingEnabled(ViewGroup var0, boolean var1) {
      IMPL.setMotionEventSplittingEnabled(var0, var1);
   }

   public static void setTransitionGroup(ViewGroup var0, boolean var1) {
      IMPL.setTransitionGroup(var0, var1);
   }
}
