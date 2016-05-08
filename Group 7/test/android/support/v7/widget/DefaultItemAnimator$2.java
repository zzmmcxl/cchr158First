package android.support.v7.widget;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DefaultItemAnimator$ChangeInfo;
import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$2 implements Runnable {
   DefaultItemAnimator$2(DefaultItemAnimator var1, ArrayList var2) {
      this.this$0 = var1;
      this.val$changes = var2;
   }

   public void run() {
      Iterator var1 = this.val$changes.iterator();

      while(var1.hasNext()) {
         DefaultItemAnimator$ChangeInfo var2 = (DefaultItemAnimator$ChangeInfo)var1.next();
         DefaultItemAnimator.access$200(this.this$0, var2);
      }

      this.val$changes.clear();
      DefaultItemAnimator.access$300(this.this$0).remove(this.val$changes);
   }
}
