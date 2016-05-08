package android.support.v4.app;

import android.support.v4.app.ListFragment;

class ListFragment$1 implements Runnable {
   ListFragment$1(ListFragment var1) {
      this.this$0 = var1;
   }

   public void run() {
      this.this$0.mList.focusableViewAvailable(this.this$0.mList);
   }
}
