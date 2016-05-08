package android.support.v7.widget;

import android.support.v7.widget.ChildHelper$Callback;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class RecyclerView$5 implements ChildHelper$Callback {
   RecyclerView$5(RecyclerView var1) {
      this.this$0 = var1;
   }

   public void addView(View var1, int var2) {
      this.this$0.addView(var1, var2);
      RecyclerView.access$1100(this.this$0, var1);
   }

   public void attachViewToParent(View var1, int var2, LayoutParams var3) {
      RecyclerView$ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
      if(var4 != null) {
         if(!var4.isTmpDetached() && !var4.shouldIgnore()) {
            throw new IllegalArgumentException("Called attach on a child which is not detached: " + var4);
         }

         var4.clearTmpDetachFlag();
      }

      RecyclerView.access$1300(this.this$0, var1, var2, var3);
   }

   public void detachViewFromParent(int var1) {
      View var2 = this.getChildAt(var1);
      if(var2 != null) {
         RecyclerView$ViewHolder var3 = RecyclerView.getChildViewHolderInt(var2);
         if(var3 != null) {
            if(var3.isTmpDetached() && !var3.shouldIgnore()) {
               throw new IllegalArgumentException("called detach on an already detached child " + var3);
            }

            var3.addFlags(256);
         }
      }

      RecyclerView.access$1400(this.this$0, var1);
   }

   public View getChildAt(int var1) {
      return this.this$0.getChildAt(var1);
   }

   public int getChildCount() {
      return this.this$0.getChildCount();
   }

   public RecyclerView$ViewHolder getChildViewHolder(View var1) {
      return RecyclerView.getChildViewHolderInt(var1);
   }

   public int indexOfChild(View var1) {
      return this.this$0.indexOfChild(var1);
   }

   public void onEnteredHiddenState(View var1) {
      RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
      if(var2 != null) {
         RecyclerView$ViewHolder.access$1500(var2);
      }

   }

   public void onLeftHiddenState(View var1) {
      RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
      if(var2 != null) {
         RecyclerView$ViewHolder.access$1600(var2);
      }

   }

   public void removeAllViews() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView.access$1200(this.this$0, this.getChildAt(var1));
      }

      this.this$0.removeAllViews();
   }

   public void removeViewAt(int var1) {
      View var2 = this.this$0.getChildAt(var1);
      if(var2 != null) {
         RecyclerView.access$1200(this.this$0, var2);
      }

      this.this$0.removeViewAt(var1);
   }
}
