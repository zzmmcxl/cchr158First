package android.support.v7.widget.helper;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.helper.ItemTouchHelper;

class ItemTouchHelper$1 implements Runnable {
   ItemTouchHelper$1(ItemTouchHelper var1) {
      this.this$0 = var1;
   }

   public void run() {
      if(this.this$0.mSelected != null && ItemTouchHelper.access$000(this.this$0)) {
         if(this.this$0.mSelected != null) {
            ItemTouchHelper.access$100(this.this$0, this.this$0.mSelected);
         }

         ItemTouchHelper.access$300(this.this$0).removeCallbacks(ItemTouchHelper.access$200(this.this$0));
         ViewCompat.postOnAnimation(ItemTouchHelper.access$300(this.this$0), this);
      }

   }
}
