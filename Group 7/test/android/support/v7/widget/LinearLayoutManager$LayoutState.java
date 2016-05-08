package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.util.Log;
import android.view.View;
import java.util.List;

class LinearLayoutManager$LayoutState {
   static final int INVALID_LAYOUT = Integer.MIN_VALUE;
   static final int ITEM_DIRECTION_HEAD = -1;
   static final int ITEM_DIRECTION_TAIL = 1;
   static final int LAYOUT_END = 1;
   static final int LAYOUT_START = -1;
   static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
   static final String TAG = "LinearLayoutManager#LayoutState";
   int mAvailable;
   int mCurrentPosition;
   int mExtra = 0;
   boolean mInfinite;
   boolean mIsPreLayout = false;
   int mItemDirection;
   int mLastScrollDelta;
   int mLayoutDirection;
   int mOffset;
   boolean mRecycle = true;
   List<RecyclerView$ViewHolder> mScrapList = null;
   int mScrollingOffset;

   private View nextViewFromScrapList() {
      int var2 = this.mScrapList.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var3 = ((RecyclerView$ViewHolder)this.mScrapList.get(var1)).itemView;
         RecyclerView$LayoutParams var4 = (RecyclerView$LayoutParams)var3.getLayoutParams();
         if(!var4.isItemRemoved() && this.mCurrentPosition == var4.getViewLayoutPosition()) {
            this.assignPositionFromScrapList(var3);
            return var3;
         }
      }

      return null;
   }

   public void assignPositionFromScrapList() {
      this.assignPositionFromScrapList((View)null);
   }

   public void assignPositionFromScrapList(View var1) {
      var1 = this.nextViewInLimitedList(var1);
      if(var1 == null) {
         this.mCurrentPosition = -1;
      } else {
         this.mCurrentPosition = ((RecyclerView$LayoutParams)var1.getLayoutParams()).getViewLayoutPosition();
      }
   }

   boolean hasMore(RecyclerView$State var1) {
      return this.mCurrentPosition >= 0 && this.mCurrentPosition < var1.getItemCount();
   }

   void log() {
      Log.d("LinearLayoutManager#LayoutState", "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
   }

   View next(RecyclerView$Recycler var1) {
      if(this.mScrapList != null) {
         return this.nextViewFromScrapList();
      } else {
         View var2 = var1.getViewForPosition(this.mCurrentPosition);
         this.mCurrentPosition += this.mItemDirection;
         return var2;
      }
   }

   public View nextViewInLimitedList(View var1) {
      int var6 = this.mScrapList.size();
      View var7 = null;
      int var3 = Integer.MAX_VALUE;
      int var2 = 0;

      View var8;
      while(true) {
         var8 = var7;
         if(var2 >= var6) {
            break;
         }

         View var9 = ((RecyclerView$ViewHolder)this.mScrapList.get(var2)).itemView;
         RecyclerView$LayoutParams var10 = (RecyclerView$LayoutParams)var9.getLayoutParams();
         var8 = var7;
         int var4 = var3;
         if(var9 != var1) {
            if(var10.isItemRemoved()) {
               var4 = var3;
               var8 = var7;
            } else {
               int var5 = (var10.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
               var8 = var7;
               var4 = var3;
               if(var5 >= 0) {
                  var8 = var7;
                  var4 = var3;
                  if(var5 < var3) {
                     var4 = var5;
                     var8 = var9;
                     if(var5 == 0) {
                        var8 = var9;
                        break;
                     }
                  }
               }
            }
         }

         ++var2;
         var7 = var8;
         var3 = var4;
      }

      return var8;
   }
}
