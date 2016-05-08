package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView$ItemAnimator;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation;

class ItemTouchHelper$4 implements Runnable {
   ItemTouchHelper$4(ItemTouchHelper var1, ItemTouchHelper$RecoverAnimation var2, int var3) {
      this.this$0 = var1;
      this.val$anim = var2;
      this.val$swipeDir = var3;
   }

   public void run() {
      if(ItemTouchHelper.access$300(this.this$0) != null && ItemTouchHelper.access$300(this.this$0).isAttachedToWindow() && !this.val$anim.mOverridden && this.val$anim.mViewHolder.getAdapterPosition() != -1) {
         RecyclerView$ItemAnimator var1 = ItemTouchHelper.access$300(this.this$0).getItemAnimator();
         if(var1 != null && var1.isRunning((RecyclerView$ItemAnimator$ItemAnimatorFinishedListener)null) || ItemTouchHelper.access$1800(this.this$0)) {
            ItemTouchHelper.access$300(this.this$0).post(this);
            return;
         }

         this.this$0.mCallback.onSwiped(this.val$anim.mViewHolder, this.val$swipeDir);
      }

   }
}
