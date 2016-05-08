package android.support.design.widget;

import android.support.design.widget.AnimationUtils$AnimationListenerAdapter;
import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import android.view.animation.Animation;

class FloatingActionButtonEclairMr1$2 extends AnimationUtils$AnimationListenerAdapter {
   FloatingActionButtonEclairMr1$2(FloatingActionButtonEclairMr1 var1, FloatingActionButtonImpl$InternalVisibilityChangedListener var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public void onAnimationEnd(Animation var1) {
      if(this.val$listener != null) {
         this.val$listener.onShown();
      }

   }
}
