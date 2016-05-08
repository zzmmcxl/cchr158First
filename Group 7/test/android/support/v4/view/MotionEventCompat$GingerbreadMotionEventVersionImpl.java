package android.support.v4.view;

import android.support.v4.view.MotionEventCompat$EclairMotionEventVersionImpl;
import android.support.v4.view.MotionEventCompatGingerbread;
import android.view.MotionEvent;

class MotionEventCompat$GingerbreadMotionEventVersionImpl extends MotionEventCompat$EclairMotionEventVersionImpl {
   public int getSource(MotionEvent var1) {
      return MotionEventCompatGingerbread.getSource(var1);
   }
}
