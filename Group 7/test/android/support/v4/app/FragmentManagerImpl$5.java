package android.support.v4.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener;
import android.view.View;
import android.view.animation.Animation;

class FragmentManagerImpl$5 extends FragmentManagerImpl$AnimateOnHWLayerIfNeededListener {
   FragmentManagerImpl$5(FragmentManagerImpl var1, View var2, Animation var3, Fragment var4) {
      super(var2, var3);
      this.this$0 = var1;
      this.val$fragment = var4;
   }

   public void onAnimationEnd(Animation var1) {
      super.onAnimationEnd(var1);
      if(this.val$fragment.mAnimatingAway != null) {
         this.val$fragment.mAnimatingAway = null;
         this.this$0.moveToState(this.val$fragment, this.val$fragment.mStateAfterAnimating, 0, 0, false);
      }

   }
}
