package android.support.v7.widget;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DefaultItemAnimator$MoveInfo;
import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$1 implements Runnable {
   DefaultItemAnimator$1(DefaultItemAnimator var1, ArrayList var2) {
      this.this$0 = var1;
      this.val$moves = var2;
   }

   public void run() {
      Iterator var1 = this.val$moves.iterator();

      while(var1.hasNext()) {
         DefaultItemAnimator$MoveInfo var2 = (DefaultItemAnimator$MoveInfo)var1.next();
         DefaultItemAnimator.access$000(this.this$0, var2.holder, var2.fromX, var2.fromY, var2.toX, var2.toY);
      }

      this.val$moves.clear();
      DefaultItemAnimator.access$100(this.this$0).remove(this.val$moves);
   }
}
