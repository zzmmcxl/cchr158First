package android.support.v7.widget;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$3 implements Runnable {
   DefaultItemAnimator$3(DefaultItemAnimator var1, ArrayList var2) {
      this.this$0 = var1;
      this.val$additions = var2;
   }

   public void run() {
      Iterator var1 = this.val$additions.iterator();

      while(var1.hasNext()) {
         RecyclerView$ViewHolder var2 = (RecyclerView$ViewHolder)var1.next();
         DefaultItemAnimator.access$400(this.this$0, var2);
      }

      this.val$additions.clear();
      DefaultItemAnimator.access$500(this.this$0).remove(this.val$additions);
   }
}
