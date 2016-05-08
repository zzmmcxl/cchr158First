package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.AutoScrollHelper;
import android.support.v4.widget.AutoScrollHelper$ClampedScroller;

class AutoScrollHelper$ScrollAnimationRunnable implements Runnable {
   private AutoScrollHelper$ScrollAnimationRunnable(AutoScrollHelper var1) {
      this.this$0 = var1;
   }

   public void run() {
      if(AutoScrollHelper.access$100(this.this$0)) {
         if(AutoScrollHelper.access$200(this.this$0)) {
            AutoScrollHelper.access$202(this.this$0, false);
            AutoScrollHelper.access$300(this.this$0).start();
         }

         AutoScrollHelper$ClampedScroller var3 = AutoScrollHelper.access$300(this.this$0);
         if(!var3.isFinished() && AutoScrollHelper.access$400(this.this$0)) {
            if(AutoScrollHelper.access$500(this.this$0)) {
               AutoScrollHelper.access$502(this.this$0, false);
               AutoScrollHelper.access$600(this.this$0);
            }

            var3.computeScrollDelta();
            int var1 = var3.getDeltaX();
            int var2 = var3.getDeltaY();
            this.this$0.scrollTargetBy(var1, var2);
            ViewCompat.postOnAnimation(AutoScrollHelper.access$700(this.this$0), this);
         } else {
            AutoScrollHelper.access$102(this.this$0, false);
         }
      }
   }
}
