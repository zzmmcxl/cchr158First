package android.support.v4.view;

import android.view.MotionEvent;

interface MotionEventCompat$MotionEventVersionImpl {
   int findPointerIndex(MotionEvent var1, int var2);

   float getAxisValue(MotionEvent var1, int var2);

   float getAxisValue(MotionEvent var1, int var2, int var3);

   int getPointerCount(MotionEvent var1);

   int getPointerId(MotionEvent var1, int var2);

   int getSource(MotionEvent var1);

   float getX(MotionEvent var1, int var2);

   float getY(MotionEvent var1, int var2);
}
