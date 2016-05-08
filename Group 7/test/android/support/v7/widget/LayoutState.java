package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$State;
import android.view.View;

class LayoutState {
   static final int INVALID_LAYOUT = Integer.MIN_VALUE;
   static final int ITEM_DIRECTION_HEAD = -1;
   static final int ITEM_DIRECTION_TAIL = 1;
   static final int LAYOUT_END = 1;
   static final int LAYOUT_START = -1;
   static final String TAG = "LayoutState";
   int mAvailable;
   int mCurrentPosition;
   int mEndLine = 0;
   boolean mInfinite;
   int mItemDirection;
   int mLayoutDirection;
   boolean mRecycle = true;
   int mStartLine = 0;
   boolean mStopInFocusable;

   boolean hasMore(RecyclerView$State var1) {
      return this.mCurrentPosition >= 0 && this.mCurrentPosition < var1.getItemCount();
   }

   View next(RecyclerView$Recycler var1) {
      View var2 = var1.getViewForPosition(this.mCurrentPosition);
      this.mCurrentPosition += this.mItemDirection;
      return var2;
   }

   public String toString() {
      return "LayoutState{mAvailable=" + this.mAvailable + ", mCurrentPosition=" + this.mCurrentPosition + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.mStartLine + ", mEndLine=" + this.mEndLine + '}';
   }
}
