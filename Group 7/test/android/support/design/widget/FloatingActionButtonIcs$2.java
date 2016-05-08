package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.FloatingActionButtonIcs;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;

class FloatingActionButtonIcs$2 extends AnimatorListenerAdapter {
   FloatingActionButtonIcs$2(FloatingActionButtonIcs var1, boolean var2, FloatingActionButtonImpl$InternalVisibilityChangedListener var3) {
      this.this$0 = var1;
      this.val$fromUser = var2;
      this.val$listener = var3;
   }

   public void onAnimationEnd(Animator var1) {
      if(this.val$listener != null) {
         this.val$listener.onShown();
      }

   }

   public void onAnimationStart(Animator var1) {
      this.this$0.mView.internalSetVisibility(0, this.val$fromUser);
   }
}
