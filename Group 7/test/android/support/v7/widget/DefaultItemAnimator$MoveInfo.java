package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$ViewHolder;

class DefaultItemAnimator$MoveInfo {
   public int fromX;
   public int fromY;
   public RecyclerView$ViewHolder holder;
   public int toX;
   public int toY;

   private DefaultItemAnimator$MoveInfo(RecyclerView$ViewHolder var1, int var2, int var3, int var4, int var5) {
      this.holder = var1;
      this.fromX = var2;
      this.fromY = var3;
      this.toX = var4;
      this.toY = var5;
   }
}
