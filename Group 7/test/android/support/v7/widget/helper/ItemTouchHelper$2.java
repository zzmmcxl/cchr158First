package android.support.v7.widget.helper;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$OnItemTouchListener;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation;
import android.view.MotionEvent;

class ItemTouchHelper$2 implements RecyclerView$OnItemTouchListener {
   ItemTouchHelper$2(ItemTouchHelper var1) {
      this.this$0 = var1;
   }

   public boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2) {
      ItemTouchHelper.access$400(this.this$0).onTouchEvent(var2);
      int var3 = MotionEventCompat.getActionMasked(var2);
      if(var3 == 0) {
         this.this$0.mActivePointerId = MotionEventCompat.getPointerId(var2, 0);
         this.this$0.mInitialTouchX = var2.getX();
         this.this$0.mInitialTouchY = var2.getY();
         ItemTouchHelper.access$500(this.this$0);
         if(this.this$0.mSelected == null) {
            ItemTouchHelper$RecoverAnimation var6 = ItemTouchHelper.access$600(this.this$0, var2);
            if(var6 != null) {
               ItemTouchHelper var5 = this.this$0;
               var5.mInitialTouchX -= var6.mX;
               var5 = this.this$0;
               var5.mInitialTouchY -= var6.mY;
               ItemTouchHelper.access$700(this.this$0, var6.mViewHolder, true);
               if(this.this$0.mPendingCleanup.remove(var6.mViewHolder.itemView)) {
                  this.this$0.mCallback.clearView(ItemTouchHelper.access$300(this.this$0), var6.mViewHolder);
               }

               ItemTouchHelper.access$800(this.this$0, var6.mViewHolder, var6.mActionState);
               ItemTouchHelper.access$900(this.this$0, var2, this.this$0.mSelectedFlags, 0);
            }
         }
      } else if(var3 != 3 && var3 != 1) {
         if(this.this$0.mActivePointerId != -1) {
            int var4 = MotionEventCompat.findPointerIndex(var2, this.this$0.mActivePointerId);
            if(var4 >= 0) {
               ItemTouchHelper.access$1000(this.this$0, var3, var2, var4);
            }
         }
      } else {
         this.this$0.mActivePointerId = -1;
         ItemTouchHelper.access$800(this.this$0, (RecyclerView$ViewHolder)null, 0);
      }

      if(ItemTouchHelper.access$1100(this.this$0) != null) {
         ItemTouchHelper.access$1100(this.this$0).addMovement(var2);
      }

      return this.this$0.mSelected != null;
   }

   public void onRequestDisallowInterceptTouchEvent(boolean var1) {
      if(var1) {
         ItemTouchHelper.access$800(this.this$0, (RecyclerView$ViewHolder)null, 0);
      }
   }

   public void onTouchEvent(RecyclerView var1, MotionEvent var2) {
      byte var3 = 0;
      ItemTouchHelper.access$400(this.this$0).onTouchEvent(var2);
      if(ItemTouchHelper.access$1100(this.this$0) != null) {
         ItemTouchHelper.access$1100(this.this$0).addMovement(var2);
      }

      if(this.this$0.mActivePointerId != -1) {
         int var4 = MotionEventCompat.getActionMasked(var2);
         int var5 = MotionEventCompat.findPointerIndex(var2, this.this$0.mActivePointerId);
         if(var5 >= 0) {
            ItemTouchHelper.access$1000(this.this$0, var4, var2, var5);
         }

         RecyclerView$ViewHolder var6 = this.this$0.mSelected;
         if(var6 != null) {
            switch(var4) {
            case 2:
               if(var5 >= 0) {
                  ItemTouchHelper.access$900(this.this$0, var2, this.this$0.mSelectedFlags, var5);
                  ItemTouchHelper.access$100(this.this$0, var6);
                  ItemTouchHelper.access$300(this.this$0).removeCallbacks(ItemTouchHelper.access$200(this.this$0));
                  ItemTouchHelper.access$200(this.this$0).run();
                  ItemTouchHelper.access$300(this.this$0).invalidate();
                  return;
               }
               break;
            case 3:
               if(ItemTouchHelper.access$1100(this.this$0) != null) {
                  ItemTouchHelper.access$1100(this.this$0).clear();
               }
            case 1:
               ItemTouchHelper.access$800(this.this$0, (RecyclerView$ViewHolder)null, 0);
               this.this$0.mActivePointerId = -1;
               return;
            case 4:
            case 5:
            default:
               return;
            case 6:
               var4 = MotionEventCompat.getActionIndex(var2);
               if(MotionEventCompat.getPointerId(var2, var4) == this.this$0.mActivePointerId) {
                  if(var4 == 0) {
                     var3 = 1;
                  }

                  this.this$0.mActivePointerId = MotionEventCompat.getPointerId(var2, var3);
                  ItemTouchHelper.access$900(this.this$0, var2, this.this$0.mSelectedFlags, var4);
                  return;
               }
            }
         }
      }

   }
}
