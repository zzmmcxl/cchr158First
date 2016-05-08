package android.support.v4.view;

import android.support.v4.view.VelocityTrackerCompat$VelocityTrackerVersionImpl;
import android.support.v4.view.VelocityTrackerCompatHoneycomb;
import android.view.VelocityTracker;

class VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl implements VelocityTrackerCompat$VelocityTrackerVersionImpl {
   public float getXVelocity(VelocityTracker var1, int var2) {
      return VelocityTrackerCompatHoneycomb.getXVelocity(var1, var2);
   }

   public float getYVelocity(VelocityTracker var1, int var2) {
      return VelocityTrackerCompatHoneycomb.getYVelocity(var1, var2);
   }
}
