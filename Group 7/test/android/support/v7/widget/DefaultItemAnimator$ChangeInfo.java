package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$ViewHolder;

class DefaultItemAnimator$ChangeInfo {
   public int fromX;
   public int fromY;
   public RecyclerView$ViewHolder newHolder;
   public RecyclerView$ViewHolder oldHolder;
   public int toX;
   public int toY;

   private DefaultItemAnimator$ChangeInfo(RecyclerView$ViewHolder var1, RecyclerView$ViewHolder var2) {
      this.oldHolder = var1;
      this.newHolder = var2;
   }

   private DefaultItemAnimator$ChangeInfo(RecyclerView$ViewHolder var1, RecyclerView$ViewHolder var2, int var3, int var4, int var5, int var6) {
      this(var1, var2);
      this.fromX = var3;
      this.fromY = var4;
      this.toX = var5;
      this.toY = var6;
   }

   public String toString() {
      return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
   }
}
