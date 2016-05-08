package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.ViewInfoStore$ProcessCallback;

class RecyclerView$4 implements ViewInfoStore$ProcessCallback {
   RecyclerView$4(RecyclerView var1) {
      this.this$0 = var1;
   }

   public void processAppeared(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3) {
      RecyclerView.access$800(this.this$0, var1, var2, var3);
   }

   public void processDisappeared(RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var3) {
      this.this$0.mRecycler.unscrapView(var1);
      RecyclerView.access$700(this.this$0, var1, var2, var3);
   }

   public void processPersistent(RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3) {
      var1.setIsRecyclable(false);
      if(RecyclerView.access$900(this.this$0)) {
         if(this.this$0.mItemAnimator.animateChange(var1, var1, var2, var3)) {
            RecyclerView.access$1000(this.this$0);
         }
      } else if(this.this$0.mItemAnimator.animatePersistence(var1, var2, var3)) {
         RecyclerView.access$1000(this.this$0);
         return;
      }

   }

   public void unused(RecyclerView$ViewHolder var1) {
      this.this$0.mLayout.removeAndRecycleView(var1.itemView, this.this$0.mRecycler);
   }
}
