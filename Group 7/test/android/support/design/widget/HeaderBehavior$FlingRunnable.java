package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.HeaderBehavior;
import android.support.v4.view.ViewCompat;
import android.view.View;

class HeaderBehavior$FlingRunnable implements Runnable {
   private final V mLayout;
   private final CoordinatorLayout mParent;

   HeaderBehavior$FlingRunnable(HeaderBehavior var1, CoordinatorLayout var2, View var3) {
      this.this$0 = var1;
      this.mParent = var2;
      this.mLayout = var3;
   }

   public void run() {
      if(this.mLayout != null && HeaderBehavior.access$000(this.this$0) != null) {
         if(!HeaderBehavior.access$000(this.this$0).computeScrollOffset()) {
            this.this$0.onFlingFinished(this.mParent, this.mLayout);
            return;
         }

         this.this$0.setHeaderTopBottomOffset(this.mParent, this.mLayout, HeaderBehavior.access$000(this.this$0).getCurrY());
         ViewCompat.postOnAnimation(this.mLayout, this);
      }

   }
}
