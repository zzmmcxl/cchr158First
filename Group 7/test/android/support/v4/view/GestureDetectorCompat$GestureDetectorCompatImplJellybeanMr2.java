package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

class GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompat$GestureDetectorCompatImpl {
   private final GestureDetector mDetector;

   public GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(Context var1, OnGestureListener var2, Handler var3) {
      this.mDetector = new GestureDetector(var1, var2, var3);
   }

   public boolean isLongpressEnabled() {
      return this.mDetector.isLongpressEnabled();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mDetector.onTouchEvent(var1);
   }

   public void setIsLongpressEnabled(boolean var1) {
      this.mDetector.setIsLongpressEnabled(var1);
   }

   public void setOnDoubleTapListener(OnDoubleTapListener var1) {
      this.mDetector.setOnDoubleTapListener(var1);
   }
}
