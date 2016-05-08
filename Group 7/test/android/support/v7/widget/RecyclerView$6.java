package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper$Callback;
import android.support.v7.widget.AdapterHelper$UpdateOp;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewHolder;

class RecyclerView$6 implements AdapterHelper$Callback {
   RecyclerView$6(RecyclerView var1) {
      this.this$0 = var1;
   }

   void dispatchUpdate(AdapterHelper$UpdateOp var1) {
      switch(var1.cmd) {
      case 1:
         this.this$0.mLayout.onItemsAdded(this.this$0, var1.positionStart, var1.itemCount);
         return;
      case 2:
         this.this$0.mLayout.onItemsRemoved(this.this$0, var1.positionStart, var1.itemCount);
         return;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return;
      case 4:
         this.this$0.mLayout.onItemsUpdated(this.this$0, var1.positionStart, var1.itemCount, var1.payload);
         return;
      case 8:
         this.this$0.mLayout.onItemsMoved(this.this$0, var1.positionStart, var1.itemCount, 1);
      }
   }

   public RecyclerView$ViewHolder findViewHolder(int var1) {
      RecyclerView$ViewHolder var3 = this.this$0.findViewHolderForPosition(var1, true);
      RecyclerView$ViewHolder var2;
      if(var3 == null) {
         var2 = null;
      } else {
         var2 = var3;
         if(this.this$0.mChildHelper.isHidden(var3.itemView)) {
            return null;
         }
      }

      return var2;
   }

   public void markViewHoldersUpdated(int var1, int var2, Object var3) {
      this.this$0.viewRangeUpdate(var1, var2, var3);
      this.this$0.mItemsChanged = true;
   }

   public void offsetPositionsForAdd(int var1, int var2) {
      this.this$0.offsetPositionRecordsForInsert(var1, var2);
      this.this$0.mItemsAddedOrRemoved = true;
   }

   public void offsetPositionsForMove(int var1, int var2) {
      this.this$0.offsetPositionRecordsForMove(var1, var2);
      this.this$0.mItemsAddedOrRemoved = true;
   }

   public void offsetPositionsForRemovingInvisible(int var1, int var2) {
      this.this$0.offsetPositionRecordsForRemove(var1, var2, true);
      this.this$0.mItemsAddedOrRemoved = true;
      RecyclerView$State.access$1712(this.this$0.mState, var2);
   }

   public void offsetPositionsForRemovingLaidOutOrNewView(int var1, int var2) {
      this.this$0.offsetPositionRecordsForRemove(var1, var2, false);
      this.this$0.mItemsAddedOrRemoved = true;
   }

   public void onDispatchFirstPass(AdapterHelper$UpdateOp var1) {
      this.dispatchUpdate(var1);
   }

   public void onDispatchSecondPass(AdapterHelper$UpdateOp var1) {
      this.dispatchUpdate(var1);
   }
}
