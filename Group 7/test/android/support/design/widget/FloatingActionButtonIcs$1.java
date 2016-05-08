package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.FloatingActionButtonIcs;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;

class FloatingActionButtonIcs$1 extends AnimatorListenerAdapter {
   private boolean mCancelled;

   FloatingActionButtonIcs$1(FloatingActionButtonIcs var1, boolean var2, FloatingActionButtonImpl$InternalVisibilityChangedListener var3) {
      this.this$0 = var1;
      this.val$fromUser = var2;
      this.val$listener = var3;
   }

   public void onAnimationCancel(Animator var1) {
      FloatingActionButtonIcs.access$002(this.this$0, false);
      this.mCancelled = true;
   }

   public void onAnimationEnd(Animator var1) {
      FloatingActionButtonIcs.access$002(this.this$0, false);
      if(!this.mCancelled) {
         this.this$0.mView.internalSetVisibility(8, this.val$fromUser);
         if(this.val$listener != null) {
            this.val$listener.onHidden();
         }
      }

   }

   public void onAnimationStart(Animator var1) {
      FloatingActionButtonIcs.access$002(this.this$0, true);
      this.mCancelled = false;
      this.this$0.mView.internalSetVisibility(0, this.val$fromUser);
   }
}
