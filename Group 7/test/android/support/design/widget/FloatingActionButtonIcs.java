package android.support.design.widget;

import android.support.annotation.Nullable;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.support.design.widget.FloatingActionButtonIcs$1;
import android.support.design.widget.FloatingActionButtonIcs$2;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import android.support.design.widget.ShadowViewDelegate;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.view.ViewCompat;

class FloatingActionButtonIcs extends FloatingActionButtonEclairMr1 {
   private boolean mIsHiding;

   FloatingActionButtonIcs(VisibilityAwareImageButton var1, ShadowViewDelegate var2) {
      super(var1, var2);
   }

   private void updateFromViewRotation(float var1) {
      if(this.mShadowDrawable != null) {
         this.mShadowDrawable.setRotation(-var1);
      }

      if(this.mBorderDrawable != null) {
         this.mBorderDrawable.setRotation(-var1);
      }

   }

   void hide(@Nullable FloatingActionButtonImpl$InternalVisibilityChangedListener var1, boolean var2) {
      if(!this.mIsHiding && this.mView.getVisibility() == 0) {
         if(ViewCompat.isLaidOut(this.mView) && !this.mView.isInEditMode()) {
            this.mView.animate().cancel();
            this.mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new FloatingActionButtonIcs$1(this, var2, var1));
            return;
         }

         this.mView.internalSetVisibility(8, var2);
         if(var1 != null) {
            var1.onHidden();
            return;
         }
      } else if(var1 != null) {
         var1.onHidden();
      }

   }

   void onPreDraw() {
      this.updateFromViewRotation(this.mView.getRotation());
   }

   boolean requirePreDrawListener() {
      return true;
   }

   void show(@Nullable FloatingActionButtonImpl$InternalVisibilityChangedListener var1, boolean var2) {
      if(this.mIsHiding || this.mView.getVisibility() != 0) {
         if(ViewCompat.isLaidOut(this.mView) && !this.mView.isInEditMode()) {
            this.mView.animate().cancel();
            if(this.mView.getVisibility() != 0) {
               this.mView.setAlpha(0.0F);
               this.mView.setScaleY(0.0F);
               this.mView.setScaleX(0.0F);
            }

            this.mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new FloatingActionButtonIcs$2(this, var2, var1));
         } else {
            this.mView.internalSetVisibility(0, var2);
            this.mView.setAlpha(1.0F);
            this.mView.setScaleY(1.0F);
            this.mView.setScaleX(1.0F);
            if(var1 != null) {
               var1.onShown();
               return;
            }
         }
      }

   }
}
