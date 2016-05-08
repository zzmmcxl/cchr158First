package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.ScrollingTabContainerView;
import android.view.View;

public class ScrollingTabContainerView$VisibilityAnimListener implements ViewPropertyAnimatorListener {
   private boolean mCanceled;
   private int mFinalVisibility;

   protected ScrollingTabContainerView$VisibilityAnimListener(ScrollingTabContainerView var1) {
      this.this$0 = var1;
      this.mCanceled = false;
   }

   public void onAnimationCancel(View var1) {
      this.mCanceled = true;
   }

   public void onAnimationEnd(View var1) {
      if(!this.mCanceled) {
         this.this$0.mVisibilityAnim = null;
         this.this$0.setVisibility(this.mFinalVisibility);
      }
   }

   public void onAnimationStart(View var1) {
      this.this$0.setVisibility(0);
      this.mCanceled = false;
   }

   public ScrollingTabContainerView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat var1, int var2) {
      this.mFinalVisibility = var2;
      this.this$0.mVisibilityAnim = var1;
      return this;
   }
}
