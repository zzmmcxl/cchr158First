package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView$ChildDrawingOrderCallback;
import android.support.v7.widget.helper.ItemTouchHelper;

class ItemTouchHelper$5 implements RecyclerView$ChildDrawingOrderCallback {
   ItemTouchHelper$5(ItemTouchHelper var1) {
      this.this$0 = var1;
   }

   public int onGetChildDrawingOrder(int var1, int var2) {
      if(ItemTouchHelper.access$1600(this.this$0) != null) {
         int var4 = ItemTouchHelper.access$2300(this.this$0);
         int var3 = var4;
         if(var4 == -1) {
            var3 = ItemTouchHelper.access$300(this.this$0).indexOfChild(ItemTouchHelper.access$1600(this.this$0));
            ItemTouchHelper.access$2302(this.this$0, var3);
         }

         if(var2 == var1 - 1) {
            return var3;
         }

         if(var2 >= var3) {
            return var2 + 1;
         }
      }

      return var2;
   }
}
