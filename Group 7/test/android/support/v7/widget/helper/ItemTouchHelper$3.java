package android.support.v7.widget.helper;

import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation;

class ItemTouchHelper$3 extends ItemTouchHelper$RecoverAnimation {
   ItemTouchHelper$3(ItemTouchHelper var1, RecyclerView$ViewHolder var2, int var3, int var4, float var5, float var6, float var7, float var8, int var9, RecyclerView$ViewHolder var10) {
      super(var1, var2, var3, var4, var5, var6, var7, var8);
      this.this$0 = var1;
      this.val$swipeDir = var9;
      this.val$prevSelected = var10;
   }

   public void onAnimationEnd(ValueAnimatorCompat var1) {
      super.onAnimationEnd(var1);
      if(!this.mOverridden) {
         if(this.val$swipeDir <= 0) {
            this.this$0.mCallback.clearView(ItemTouchHelper.access$300(this.this$0), this.val$prevSelected);
         } else {
            this.this$0.mPendingCleanup.add(this.val$prevSelected.itemView);
            this.mIsPendingCleanup = true;
            if(this.val$swipeDir > 0) {
               ItemTouchHelper.access$1500(this.this$0, this, this.val$swipeDir);
            }
         }

         if(ItemTouchHelper.access$1600(this.this$0) == this.val$prevSelected.itemView) {
            ItemTouchHelper.access$1700(this.this$0, this.val$prevSelected.itemView);
            return;
         }
      }

   }
}
