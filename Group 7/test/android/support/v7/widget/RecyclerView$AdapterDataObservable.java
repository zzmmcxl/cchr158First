package android.support.v7.widget;

import android.database.Observable;
import android.support.v7.widget.RecyclerView$AdapterDataObserver;

class RecyclerView$AdapterDataObservable extends Observable<RecyclerView$AdapterDataObserver> {
   public boolean hasObservers() {
      return !this.mObservers.isEmpty();
   }

   public void notifyChanged() {
      for(int var1 = this.mObservers.size() - 1; var1 >= 0; --var1) {
         ((RecyclerView$AdapterDataObserver)this.mObservers.get(var1)).onChanged();
      }

   }

   public void notifyItemMoved(int var1, int var2) {
      for(int var3 = this.mObservers.size() - 1; var3 >= 0; --var3) {
         ((RecyclerView$AdapterDataObserver)this.mObservers.get(var3)).onItemRangeMoved(var1, var2, 1);
      }

   }

   public void notifyItemRangeChanged(int var1, int var2) {
      this.notifyItemRangeChanged(var1, var2, (Object)null);
   }

   public void notifyItemRangeChanged(int var1, int var2, Object var3) {
      for(int var4 = this.mObservers.size() - 1; var4 >= 0; --var4) {
         ((RecyclerView$AdapterDataObserver)this.mObservers.get(var4)).onItemRangeChanged(var1, var2, var3);
      }

   }

   public void notifyItemRangeInserted(int var1, int var2) {
      for(int var3 = this.mObservers.size() - 1; var3 >= 0; --var3) {
         ((RecyclerView$AdapterDataObserver)this.mObservers.get(var3)).onItemRangeInserted(var1, var2);
      }

   }

   public void notifyItemRangeRemoved(int var1, int var2) {
      for(int var3 = this.mObservers.size() - 1; var3 >= 0; --var3) {
         ((RecyclerView$AdapterDataObserver)this.mObservers.get(var3)).onItemRangeRemoved(var1, var2);
      }

   }
}
