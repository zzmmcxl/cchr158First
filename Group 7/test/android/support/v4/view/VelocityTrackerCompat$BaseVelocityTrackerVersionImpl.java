package android.support.v4.view;

import android.support.v4.view.VelocityTrackerCompat$VelocityTrackerVersionImpl;
import android.view.VelocityTracker;

class VelocityTrackerCompat$BaseVelocityTrackerVersionImpl implements VelocityTrackerCompat$VelocityTrackerVersionImpl {
   public float getXVelocity(VelocityTracker var1, int var2) {
      return var1.getXVelocity();
   }

   public float getYVelocity(VelocityTracker var1, int var2) {
      return var1.getYVelocity();
   }
}
