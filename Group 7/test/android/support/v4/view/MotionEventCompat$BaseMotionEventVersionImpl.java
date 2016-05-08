package android.support.v4.view;

import android.support.v4.view.MotionEventCompat$MotionEventVersionImpl;
import android.view.MotionEvent;

class MotionEventCompat$BaseMotionEventVersionImpl implements MotionEventCompat$MotionEventVersionImpl {
   public int findPointerIndex(MotionEvent var1, int var2) {
      return var2 == 0?0:-1;
   }

   public float getAxisValue(MotionEvent var1, int var2) {
      return 0.0F;
   }

   public float getAxisValue(MotionEvent var1, int var2, int var3) {
      return 0.0F;
   }

   public int getPointerCount(MotionEvent var1) {
      return 1;
   }

   public int getPointerId(MotionEvent var1, int var2) {
      if(var2 == 0) {
         return 0;
      } else {
         throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
      }
   }

   public int getSource(MotionEvent var1) {
      return 0;
   }

   public float getX(MotionEvent var1, int var2) {
      if(var2 == 0) {
         return var1.getX();
      } else {
         throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
      }
   }

   public float getY(MotionEvent var1, int var2) {
      if(var2 == 0) {
         return var1.getY();
      } else {
         throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
      }
   }
}
