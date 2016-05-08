package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class RecyclerView$LayoutParams extends MarginLayoutParams {
   final Rect mDecorInsets = new Rect();
   boolean mInsetsDirty = true;
   boolean mPendingInvalidate = false;
   RecyclerView$ViewHolder mViewHolder;

   public RecyclerView$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   public RecyclerView$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public RecyclerView$LayoutParams(RecyclerView$LayoutParams var1) {
      super(var1);
   }

   public RecyclerView$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public RecyclerView$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }

   public int getViewAdapterPosition() {
      return this.mViewHolder.getAdapterPosition();
   }

   public int getViewLayoutPosition() {
      return this.mViewHolder.getLayoutPosition();
   }

   public int getViewPosition() {
      return this.mViewHolder.getPosition();
   }

   public boolean isItemChanged() {
      return this.mViewHolder.isUpdated();
   }

   public boolean isItemRemoved() {
      return this.mViewHolder.isRemoved();
   }

   public boolean isViewInvalid() {
      return this.mViewHolder.isInvalid();
   }

   public boolean viewNeedsUpdate() {
      return this.mViewHolder.needsUpdate();
   }
}
