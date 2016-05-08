package android.support.design.widget;

import android.support.design.widget.StateListAnimator$1;
import android.support.design.widget.StateListAnimator$Tuple;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class StateListAnimator {
   private AnimationListener mAnimationListener = new StateListAnimator$1(this);
   private StateListAnimator$Tuple mLastMatch = null;
   private Animation mRunningAnimation = null;
   private final ArrayList<StateListAnimator$Tuple> mTuples = new ArrayList();
   private WeakReference<View> mViewRef;

   private void cancel() {
      if(this.mRunningAnimation != null) {
         View var1 = this.getTarget();
         if(var1 != null && var1.getAnimation() == this.mRunningAnimation) {
            var1.clearAnimation();
         }

         this.mRunningAnimation = null;
      }

   }

   private void clearTarget() {
      View var3 = this.getTarget();
      int var2 = this.mTuples.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         Animation var4 = ((StateListAnimator$Tuple)this.mTuples.get(var1)).mAnimation;
         if(var3.getAnimation() == var4) {
            var3.clearAnimation();
         }
      }

      this.mViewRef = null;
      this.mLastMatch = null;
      this.mRunningAnimation = null;
   }

   private void start(StateListAnimator$Tuple var1) {
      this.mRunningAnimation = var1.mAnimation;
      View var2 = this.getTarget();
      if(var2 != null) {
         var2.startAnimation(this.mRunningAnimation);
      }

   }

   public void addState(int[] var1, Animation var2) {
      StateListAnimator$Tuple var3 = new StateListAnimator$Tuple(var1, var2, (StateListAnimator$1)null);
      var2.setAnimationListener(this.mAnimationListener);
      this.mTuples.add(var3);
   }

   Animation getRunningAnimation() {
      return this.mRunningAnimation;
   }

   View getTarget() {
      return this.mViewRef == null?null:(View)this.mViewRef.get();
   }

   ArrayList<StateListAnimator$Tuple> getTuples() {
      return this.mTuples;
   }

   public void jumpToCurrentState() {
      if(this.mRunningAnimation != null) {
         View var1 = this.getTarget();
         if(var1 != null && var1.getAnimation() == this.mRunningAnimation) {
            var1.clearAnimation();
         }
      }

   }

   void setState(int[] var1) {
      Object var5 = null;
      int var3 = this.mTuples.size();
      int var2 = 0;

      StateListAnimator$Tuple var4;
      while(true) {
         var4 = (StateListAnimator$Tuple)var5;
         if(var2 >= var3) {
            break;
         }

         var4 = (StateListAnimator$Tuple)this.mTuples.get(var2);
         if(StateSet.stateSetMatches(var4.mSpecs, var1)) {
            break;
         }

         ++var2;
      }

      if(var4 != this.mLastMatch) {
         if(this.mLastMatch != null) {
            this.cancel();
         }

         this.mLastMatch = var4;
         View var6 = (View)this.mViewRef.get();
         if(var4 != null && var6 != null && var6.getVisibility() == 0) {
            this.start(var4);
            return;
         }
      }

   }

   void setTarget(View var1) {
      View var2 = this.getTarget();
      if(var2 != var1) {
         if(var2 != null) {
            this.clearTarget();
         }

         if(var1 != null) {
            this.mViewRef = new WeakReference(var1);
            return;
         }
      }

   }
}
