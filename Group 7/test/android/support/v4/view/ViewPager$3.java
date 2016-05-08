package android.support.v4.view;

import android.support.v4.view.ViewPager;

class ViewPager$3 implements Runnable {
   ViewPager$3(ViewPager var1) {
      this.this$0 = var1;
   }

   public void run() {
      ViewPager.access$000(this.this$0, 0);
      this.this$0.populate();
   }
}
