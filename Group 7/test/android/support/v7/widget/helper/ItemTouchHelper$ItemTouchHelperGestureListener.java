package android.support.v7.widget.helper;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper$Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;

class ItemTouchHelper$ItemTouchHelperGestureListener extends SimpleOnGestureListener {
   private ItemTouchHelper$ItemTouchHelperGestureListener(ItemTouchHelper var1) {
      this.this$0 = var1;
   }

   public boolean onDown(MotionEvent var1) {
      return true;
   }

   public void onLongPress(MotionEvent var1) {
      View var5 = ItemTouchHelper.access$2400(this.this$0, var1);
      if(var5 != null) {
         RecyclerView$ViewHolder var7 = ItemTouchHelper.access$300(this.this$0).getChildViewHolder(var5);
         if(var7 != null && ItemTouchHelper$Callback.access$2100(this.this$0.mCallback, ItemTouchHelper.access$300(this.this$0), var7) && MotionEventCompat.getPointerId(var1, 0) == this.this$0.mActivePointerId) {
            int var4 = MotionEventCompat.findPointerIndex(var1, this.this$0.mActivePointerId);
            float var2 = MotionEventCompat.getX(var1, var4);
            float var3 = MotionEventCompat.getY(var1, var4);
            this.this$0.mInitialTouchX = var2;
            this.this$0.mInitialTouchY = var3;
            ItemTouchHelper var6 = this.this$0;
            this.this$0.mDy = 0.0F;
            var6.mDx = 0.0F;
            if(this.this$0.mCallback.isLongPressDragEnabled()) {
               ItemTouchHelper.access$800(this.this$0, var7, 2);
               return;
            }
         }
      }

   }
}
