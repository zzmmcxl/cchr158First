package android.support.design.widget;

import android.view.animation.Animation;

class StateListAnimator$Tuple {
   final Animation mAnimation;
   final int[] mSpecs;

   private StateListAnimator$Tuple(int[] var1, Animation var2) {
      this.mSpecs = var1;
      this.mAnimation = var2;
   }

   Animation getAnimation() {
      return this.mAnimation;
   }

   int[] getSpecs() {
      return this.mSpecs;
   }
}
