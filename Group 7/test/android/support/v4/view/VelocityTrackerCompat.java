package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.VelocityTrackerCompat$BaseVelocityTrackerVersionImpl;
import android.support.v4.view.VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl;
import android.support.v4.view.VelocityTrackerCompat$VelocityTrackerVersionImpl;
import android.view.VelocityTracker;

public final class VelocityTrackerCompat {
   static final VelocityTrackerCompat$VelocityTrackerVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl();
      } else {
         IMPL = new VelocityTrackerCompat$BaseVelocityTrackerVersionImpl();
      }
   }

   public static float getXVelocity(VelocityTracker var0, int var1) {
      return IMPL.getXVelocity(var0, var1);
   }

   public static float getYVelocity(VelocityTracker var0, int var1) {
      return IMPL.getYVelocity(var0, var1);
   }
}
