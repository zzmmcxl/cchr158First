package android.support.v4.view;

import android.support.v4.view.MotionEventCompat$BaseMotionEventVersionImpl;
import android.support.v4.view.MotionEventCompatEclair;
import android.view.MotionEvent;

class MotionEventCompat$EclairMotionEventVersionImpl extends MotionEventCompat$BaseMotionEventVersionImpl {
   public int findPointerIndex(MotionEvent var1, int var2) {
      return MotionEventCompatEclair.findPointerIndex(var1, var2);
   }

   public int getPointerCount(MotionEvent var1) {
      return MotionEventCompatEclair.getPointerCount(var1);
   }

   public int getPointerId(MotionEvent var1, int var2) {
      return MotionEventCompatEclair.getPointerId(var1, var2);
   }

   public float getX(MotionEvent var1, int var2) {
      return MotionEventCompatEclair.getX(var1, var2);
   }

   public float getY(MotionEvent var1, int var2) {
      return MotionEventCompatEclair.getY(var1, var2);
   }
}
