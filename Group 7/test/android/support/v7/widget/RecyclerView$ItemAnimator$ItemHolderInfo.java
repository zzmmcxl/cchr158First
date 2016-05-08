package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;

public class RecyclerView$ItemAnimator$ItemHolderInfo {
   public int bottom;
   public int changeFlags;
   public int left;
   public int right;
   public int top;

   public RecyclerView$ItemAnimator$ItemHolderInfo setFrom(RecyclerView$ViewHolder var1) {
      return this.setFrom(var1, 0);
   }

   public RecyclerView$ItemAnimator$ItemHolderInfo setFrom(RecyclerView$ViewHolder var1, int var2) {
      View var3 = var1.itemView;
      this.left = var3.getLeft();
      this.top = var3.getTop();
      this.right = var3.getRight();
      this.bottom = var3.getBottom();
      return this;
   }
}
