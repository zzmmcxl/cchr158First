package android.support.v4.widget;

import android.support.v4.widget.ContentLoadingProgressBar;

class ContentLoadingProgressBar$1 implements Runnable {
   ContentLoadingProgressBar$1(ContentLoadingProgressBar var1) {
      this.this$0 = var1;
   }

   public void run() {
      ContentLoadingProgressBar.access$002(this.this$0, false);
      ContentLoadingProgressBar.access$102(this.this$0, -1L);
      this.this$0.setVisibility(8);
   }
}
