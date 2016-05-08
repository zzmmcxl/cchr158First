package android.support.v4.view;

import android.view.MotionEvent;
import android.view.GestureDetector.OnDoubleTapListener;

interface GestureDetectorCompat$GestureDetectorCompatImpl {
   boolean isLongpressEnabled();

   boolean onTouchEvent(MotionEvent var1);

   void setIsLongpressEnabled(boolean var1);

   void setOnDoubleTapListener(OnDoubleTapListener var1);
}
