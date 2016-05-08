package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$AdapterDataObserver;
import android.support.v7.widget.RecyclerView$State;

class RecyclerView$RecyclerViewDataObserver extends RecyclerView$AdapterDataObserver {
   private RecyclerView$RecyclerViewDataObserver(RecyclerView var1) {
      this.this$0 = var1;
   }

   public void onChanged() {
      this.this$0.assertNotInLayoutOrScroll((String)null);
      if(RecyclerView.access$3100(this.this$0).hasStableIds()) {
         RecyclerView$State.access$1802(this.this$0.mState, true);
         RecyclerView.access$4000(this.this$0);
      } else {
         RecyclerView$State.access$1802(this.this$0.mState, true);
         RecyclerView.access$4000(this.this$0);
      }

      if(!this.this$0.mAdapterHelper.hasPendingUpdates()) {
         this.this$0.requestLayout();
      }

   }

   public void onItemRangeChanged(int var1, int var2, Object var3) {
      this.this$0.assertNotInLayoutOrScroll((String)null);
      if(this.this$0.mAdapterHelper.onItemRangeChanged(var1, var2, var3)) {
         this.triggerUpdateProcessor();
      }

   }

   public void onItemRangeInserted(int var1, int var2) {
      this.this$0.assertNotInLayoutOrScroll((String)null);
      if(this.this$0.mAdapterHelper.onItemRangeInserted(var1, var2)) {
         this.triggerUpdateProcessor();
      }

   }

   public void onItemRangeMoved(int var1, int var2, int var3) {
      this.this$0.assertNotInLayoutOrScroll((String)null);
      if(this.this$0.mAdapterHelper.onItemRangeMoved(var1, var2, var3)) {
         this.triggerUpdateProcessor();
      }

   }

   public void onItemRangeRemoved(int var1, int var2) {
      this.this$0.assertNotInLayoutOrScroll((String)null);
      if(this.this$0.mAdapterHelper.onItemRangeRemoved(var1, var2)) {
         this.triggerUpdateProcessor();
      }

   }

   void triggerUpdateProcessor() {
      if(RecyclerView.access$4100(this.this$0) && RecyclerView.access$4200(this.this$0) && RecyclerView.access$4300(this.this$0)) {
         ViewCompat.postOnAnimation(this.this$0, RecyclerView.access$4400(this.this$0));
      } else {
         RecyclerView.access$4502(this.this$0, true);
         this.this$0.requestLayout();
      }
   }
}
