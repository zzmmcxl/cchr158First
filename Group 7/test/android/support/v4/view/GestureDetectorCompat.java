package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2;
import android.view.MotionEvent;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

public final class GestureDetectorCompat {
   private final GestureDetectorCompat$GestureDetectorCompatImpl mImpl;

   public GestureDetectorCompat(Context var1, OnGestureListener var2) {
      this(var1, var2, (Handler)null);
   }

   public GestureDetectorCompat(Context var1, OnGestureListener var2, Handler var3) {
      if(VERSION.SDK_INT > 17) {
         this.mImpl = new GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(var1, var2, var3);
      } else {
         this.mImpl = new GestureDetectorCompat$GestureDetectorCompatImplBase(var1, var2, var3);
      }
   }

   public boolean isLongpressEnabled() {
      return this.mImpl.isLongpressEnabled();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mImpl.onTouchEvent(var1);
   }

   public void setIsLongpressEnabled(boolean var1) {
      this.mImpl.setIsLongpressEnabled(var1);
   }

   public void setOnDoubleTapListener(OnDoubleTapListener var1) {
      this.mImpl.setOnDoubleTapListener(var1);
   }
}
