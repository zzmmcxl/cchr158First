package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;

class RecyclerView$1 implements Runnable {
   RecyclerView$1(RecyclerView var1) {
      this.this$0 = var1;
   }

   public void run() {
      if(RecyclerView.access$100(this.this$0) && !this.this$0.isLayoutRequested()) {
         if(RecyclerView.access$200(this.this$0)) {
            RecyclerView.access$302(this.this$0, true);
         } else {
            RecyclerView.access$400(this.this$0);
         }
      }
   }
}
