package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.AbsActionBarView;
import android.view.View;

public class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener {
   private boolean mCanceled;
   int mFinalVisibility;

   protected AbsActionBarView$VisibilityAnimListener(AbsActionBarView var1) {
      this.this$0 = var1;
      this.mCanceled = false;
   }

   public void onAnimationCancel(View var1) {
      this.mCanceled = true;
   }

   public void onAnimationEnd(View var1) {
      if(!this.mCanceled) {
         this.this$0.mVisibilityAnim = null;
         AbsActionBarView.access$101(this.this$0, this.mFinalVisibility);
      }
   }

   public void onAnimationStart(View var1) {
      AbsActionBarView.access$001(this.this$0, 0);
      this.mCanceled = false;
   }

   public AbsActionBarView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat var1, int var2) {
      this.this$0.mVisibilityAnim = var1;
      this.mFinalVisibility = var2;
      return this;
   }
}
