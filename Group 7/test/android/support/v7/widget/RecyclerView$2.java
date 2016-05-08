package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;

class RecyclerView$2 implements Runnable {
   RecyclerView$2(RecyclerView var1) {
      this.this$0 = var1;
   }

   public void run() {
      if(this.this$0.mItemAnimator != null) {
         this.this$0.mItemAnimator.runPendingAnimations();
      }

      RecyclerView.access$602(this.this$0, false);
   }
}
