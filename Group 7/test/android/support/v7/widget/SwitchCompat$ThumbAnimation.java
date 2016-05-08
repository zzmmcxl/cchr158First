package android.support.v7.widget;

import android.support.v7.widget.SwitchCompat;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwitchCompat$ThumbAnimation extends Animation {
   final float mDiff;
   final float mEndPosition;
   final float mStartPosition;

   private SwitchCompat$ThumbAnimation(SwitchCompat var1, float var2, float var3) {
      this.this$0 = var1;
      this.mStartPosition = var2;
      this.mEndPosition = var3;
      this.mDiff = var3 - var2;
   }

   protected void applyTransformation(float var1, Transformation var2) {
      SwitchCompat.access$200(this.this$0, this.mStartPosition + this.mDiff * var1);
   }
}
