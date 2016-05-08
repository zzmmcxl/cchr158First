package android.support.v4.view;

import android.support.v4.view.MotionEventCompat$GingerbreadMotionEventVersionImpl;
import android.support.v4.view.MotionEventCompatHoneycombMr1;
import android.view.MotionEvent;

class MotionEventCompat$HoneycombMr1MotionEventVersionImpl extends MotionEventCompat$GingerbreadMotionEventVersionImpl {
   public float getAxisValue(MotionEvent var1, int var2) {
      return MotionEventCompatHoneycombMr1.getAxisValue(var1, var2);
   }

   public float getAxisValue(MotionEvent var1, int var2, int var3) {
      return MotionEventCompatHoneycombMr1.getAxisValue(var1, var2, var3);
   }
}
