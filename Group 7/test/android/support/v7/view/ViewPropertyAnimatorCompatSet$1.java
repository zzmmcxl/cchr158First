package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

class ViewPropertyAnimatorCompatSet$1 extends ViewPropertyAnimatorListenerAdapter {
   private int mProxyEndCount;
   private boolean mProxyStarted;

   ViewPropertyAnimatorCompatSet$1(ViewPropertyAnimatorCompatSet var1) {
      this.this$0 = var1;
      this.mProxyStarted = false;
      this.mProxyEndCount = 0;
   }

   public void onAnimationEnd(View var1) {
      int var2 = this.mProxyEndCount + 1;
      this.mProxyEndCount = var2;
      if(var2 == ViewPropertyAnimatorCompatSet.access$200(this.this$0).size()) {
         if(ViewPropertyAnimatorCompatSet.access$000(this.this$0) != null) {
            ViewPropertyAnimatorCompatSet.access$000(this.this$0).onAnimationEnd((View)null);
         }

         this.onEnd();
      }

   }

   public void onAnimationStart(View var1) {
      if(!this.mProxyStarted) {
         this.mProxyStarted = true;
         if(ViewPropertyAnimatorCompatSet.access$000(this.this$0) != null) {
            ViewPropertyAnimatorCompatSet.access$000(this.this$0).onAnimationStart((View)null);
            return;
         }
      }

   }

   void onEnd() {
      this.mProxyEndCount = 0;
      this.mProxyStarted = false;
      ViewPropertyAnimatorCompatSet.access$100(this.this$0);
   }
}
