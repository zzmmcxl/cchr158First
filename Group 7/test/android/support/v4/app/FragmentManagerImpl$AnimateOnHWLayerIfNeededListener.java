package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1;
import android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$2;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener implements AnimationListener {
   private AnimationListener mOrignalListener = null;
   private boolean mShouldRunOnHWLayer = false;
   private View mView = null;

   public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View var1, Animation var2) {
      if(var1 != null && var2 != null) {
         this.mView = var1;
      }
   }

   public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View var1, Animation var2, AnimationListener var3) {
      if(var1 != null && var2 != null) {
         this.mOrignalListener = var3;
         this.mView = var1;
      }
   }

   @CallSuper
   public void onAnimationEnd(Animation var1) {
      if(this.mView != null && this.mShouldRunOnHWLayer) {
         this.mView.post(new FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$2(this));
      }

      if(this.mOrignalListener != null) {
         this.mOrignalListener.onAnimationEnd(var1);
      }

   }

   public void onAnimationRepeat(Animation var1) {
      if(this.mOrignalListener != null) {
         this.mOrignalListener.onAnimationRepeat(var1);
      }

   }

   @CallSuper
   public void onAnimationStart(Animation var1) {
      if(this.mView != null) {
         this.mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(this.mView, var1);
         if(this.mShouldRunOnHWLayer) {
            this.mView.post(new FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1(this));
         }
      }

      if(this.mOrignalListener != null) {
         this.mOrignalListener.onAnimationStart(var1);
      }

   }
}
