package android.support.v7.util;

import android.support.v7.util.SortedList$Callback;

public class SortedList$BatchedCallback<T2> extends SortedList$Callback<T2> {
   static final int TYPE_ADD = 1;
   static final int TYPE_CHANGE = 3;
   static final int TYPE_MOVE = 4;
   static final int TYPE_NONE = 0;
   static final int TYPE_REMOVE = 2;
   int mLastEventCount = -1;
   int mLastEventPosition = -1;
   int mLastEventType = 0;
   private final SortedList$Callback<T2> mWrappedCallback;

   public SortedList$BatchedCallback(SortedList$Callback<T2> var1) {
      this.mWrappedCallback = var1;
   }

   public boolean areContentsTheSame(T2 var1, T2 var2) {
      return this.mWrappedCallback.areContentsTheSame(var1, var2);
   }

   public boolean areItemsTheSame(T2 var1, T2 var2) {
      return this.mWrappedCallback.areItemsTheSame(var1, var2);
   }

   public int compare(T2 var1, T2 var2) {
      return this.mWrappedCallback.compare(var1, var2);
   }

   public void dispatchLastEvent() {
      if(this.mLastEventType != 0) {
         switch(this.mLastEventType) {
         case 1:
            this.mWrappedCallback.onInserted(this.mLastEventPosition, this.mLastEventCount);
            break;
         case 2:
            this.mWrappedCallback.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            break;
         case 3:
            this.mWrappedCallback.onChanged(this.mLastEventPosition, this.mLastEventCount);
         }

         this.mLastEventType = 0;
      }
   }

   public void onChanged(int var1, int var2) {
      if(this.mLastEventType == 3 && var1 <= this.mLastEventPosition + this.mLastEventCount && var1 + var2 >= this.mLastEventPosition) {
         int var3 = this.mLastEventPosition;
         int var4 = this.mLastEventCount;
         this.mLastEventPosition = Math.min(var1, this.mLastEventPosition);
         this.mLastEventCount = Math.max(var3 + var4, var1 + var2) - this.mLastEventPosition;
      } else {
         this.dispatchLastEvent();
         this.mLastEventPosition = var1;
         this.mLastEventCount = var2;
         this.mLastEventType = 3;
      }
   }

   public void onInserted(int var1, int var2) {
      if(this.mLastEventType == 1 && var1 >= this.mLastEventPosition && var1 <= this.mLastEventPosition + this.mLastEventCount) {
         this.mLastEventCount += var2;
         this.mLastEventPosition = Math.min(var1, this.mLastEventPosition);
      } else {
         this.dispatchLastEvent();
         this.mLastEventPosition = var1;
         this.mLastEventCount = var2;
         this.mLastEventType = 1;
      }
   }

   public void onMoved(int var1, int var2) {
      this.dispatchLastEvent();
      this.mWrappedCallback.onMoved(var1, var2);
   }

   public void onRemoved(int var1, int var2) {
      if(this.mLastEventType == 2 && this.mLastEventPosition == var1) {
         this.mLastEventCount += var2;
      } else {
         this.dispatchLastEvent();
         this.mLastEventPosition = var1;
         this.mLastEventCount = var2;
         this.mLastEventType = 2;
      }
   }
}
