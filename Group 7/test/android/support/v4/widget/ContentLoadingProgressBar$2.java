package android.support.v4.widget;

import android.support.v4.widget.ContentLoadingProgressBar;

class ContentLoadingProgressBar$2 implements Runnable {
   ContentLoadingProgressBar$2(ContentLoadingProgressBar var1) {
      this.this$0 = var1;
   }

   public void run() {
      ContentLoadingProgressBar.access$202(this.this$0, false);
      if(!ContentLoadingProgressBar.access$300(this.this$0)) {
         ContentLoadingProgressBar.access$102(this.this$0, System.currentTimeMillis());
         this.this$0.setVisibility(0);
      }

   }
}
