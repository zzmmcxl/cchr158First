package android.support.design.widget;

import android.support.design.widget.AnimationUtils$AnimationListenerAdapter;
import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import android.view.animation.Animation;

class FloatingActionButtonEclairMr1$1 extends AnimationUtils$AnimationListenerAdapter {
   FloatingActionButtonEclairMr1$1(FloatingActionButtonEclairMr1 var1, boolean var2, FloatingActionButtonImpl$InternalVisibilityChangedListener var3) {
      this.this$0 = var1;
      this.val$fromUser = var2;
      this.val$listener = var3;
   }

   public void onAnimationEnd(Animation var1) {
      FloatingActionButtonEclairMr1.access$202(this.this$0, false);
      this.this$0.mView.internalSetVisibility(8, this.val$fromUser);
      if(this.val$listener != null) {
         this.val$listener.onHidden();
      }

   }

   public void onAnimationStart(Animation var1) {
      FloatingActionButtonEclairMr1.access$202(this.this$0, true);
   }
}
