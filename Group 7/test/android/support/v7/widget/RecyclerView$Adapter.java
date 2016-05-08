package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$AdapterDataObservable;
import android.support.v7.widget.RecyclerView$AdapterDataObserver;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.ViewGroup;
import java.util.List;

public abstract class RecyclerView$Adapter<VH extends RecyclerView$ViewHolder> {
   private boolean mHasStableIds = false;
   private final RecyclerView$AdapterDataObservable mObservable = new RecyclerView$AdapterDataObservable();

   public final void bindViewHolder(VH var1, int var2) {
      var1.mPosition = var2;
      if(this.hasStableIds()) {
         var1.mItemId = this.getItemId(var2);
      }

      var1.setFlags(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      this.onBindViewHolder(var1, var2, var1.getUnmodifiedPayloads());
      var1.clearPayload();
      TraceCompat.endSection();
   }

   public final VH createViewHolder(ViewGroup var1, int var2) {
      TraceCompat.beginSection("RV CreateView");
      RecyclerView$ViewHolder var3 = this.onCreateViewHolder(var1, var2);
      var3.mItemViewType = var2;
      TraceCompat.endSection();
      return var3;
   }

   public abstract int getItemCount();

   public long getItemId(int var1) {
      return -1L;
   }

   public int getItemViewType(int var1) {
      return 0;
   }

   public final boolean hasObservers() {
      return this.mObservable.hasObservers();
   }

   public final boolean hasStableIds() {
      return this.mHasStableIds;
   }

   public final void notifyDataSetChanged() {
      this.mObservable.notifyChanged();
   }

   public final void notifyItemChanged(int var1) {
      this.mObservable.notifyItemRangeChanged(var1, 1);
   }

   public final void notifyItemChanged(int var1, Object var2) {
      this.mObservable.notifyItemRangeChanged(var1, 1, var2);
   }

   public final void notifyItemInserted(int var1) {
      this.mObservable.notifyItemRangeInserted(var1, 1);
   }

   public final void notifyItemMoved(int var1, int var2) {
      this.mObservable.notifyItemMoved(var1, var2);
   }

   public final void notifyItemRangeChanged(int var1, int var2) {
      this.mObservable.notifyItemRangeChanged(var1, var2);
   }

   public final void notifyItemRangeChanged(int var1, int var2, Object var3) {
      this.mObservable.notifyItemRangeChanged(var1, var2, var3);
   }

   public final void notifyItemRangeInserted(int var1, int var2) {
      this.mObservable.notifyItemRangeInserted(var1, var2);
   }

   public final void notifyItemRangeRemoved(int var1, int var2) {
      this.mObservable.notifyItemRangeRemoved(var1, var2);
   }

   public final void notifyItemRemoved(int var1) {
      this.mObservable.notifyItemRangeRemoved(var1, 1);
   }

   public void onAttachedToRecyclerView(RecyclerView var1) {
   }

   public abstract void onBindViewHolder(VH var1, int var2);

   public void onBindViewHolder(VH var1, int var2, List<Object> var3) {
      this.onBindViewHolder(var1, var2);
   }

   public abstract VH onCreateViewHolder(ViewGroup var1, int var2);

   public void onDetachedFromRecyclerView(RecyclerView var1) {
   }

   public boolean onFailedToRecycleView(VH var1) {
      return false;
   }

   public void onViewAttachedToWindow(VH var1) {
   }

   public void onViewDetachedFromWindow(VH var1) {
   }

   public void onViewRecycled(VH var1) {
   }

   public void registerAdapterDataObserver(RecyclerView$AdapterDataObserver var1) {
      this.mObservable.registerObserver(var1);
   }

   public void setHasStableIds(boolean var1) {
      if(this.hasObservers()) {
         throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      } else {
         this.mHasStableIds = var1;
      }
   }

   public void unregisterAdapterDataObserver(RecyclerView$AdapterDataObserver var1) {
      this.mObservable.unregisterObserver(var1);
   }
}
