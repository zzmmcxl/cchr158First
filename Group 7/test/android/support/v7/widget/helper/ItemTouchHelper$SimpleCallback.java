package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper$Callback;

public abstract class ItemTouchHelper$SimpleCallback extends ItemTouchHelper$Callback {
   private int mDefaultDragDirs;
   private int mDefaultSwipeDirs;

   public ItemTouchHelper$SimpleCallback(int var1, int var2) {
      this.mDefaultSwipeDirs = var2;
      this.mDefaultDragDirs = var1;
   }

   public int getDragDirs(RecyclerView var1, RecyclerView$ViewHolder var2) {
      return this.mDefaultDragDirs;
   }

   public int getMovementFlags(RecyclerView var1, RecyclerView$ViewHolder var2) {
      return makeMovementFlags(this.getDragDirs(var1, var2), this.getSwipeDirs(var1, var2));
   }

   public int getSwipeDirs(RecyclerView var1, RecyclerView$ViewHolder var2) {
      return this.mDefaultSwipeDirs;
   }

   public void setDefaultDragDirs(int var1) {
      this.mDefaultDragDirs = var1;
   }

   public void setDefaultSwipeDirs(int var1) {
      this.mDefaultSwipeDirs = var1;
   }
}
