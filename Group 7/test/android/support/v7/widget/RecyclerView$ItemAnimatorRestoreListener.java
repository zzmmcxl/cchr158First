package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorListener;
import android.support.v7.widget.RecyclerView$ViewHolder;

class RecyclerView$ItemAnimatorRestoreListener implements RecyclerView$ItemAnimator$ItemAnimatorListener {
   private RecyclerView$ItemAnimatorRestoreListener(RecyclerView var1) {
      this.this$0 = var1;
   }

   public void onAnimationFinished(RecyclerView$ViewHolder var1) {
      var1.setIsRecyclable(true);
      if(var1.mShadowedHolder != null && var1.mShadowingHolder == null) {
         var1.mShadowedHolder = null;
      }

      var1.mShadowingHolder = null;
      if(!RecyclerView$ViewHolder.access$6300(var1) && !RecyclerView.access$6400(this.this$0, var1.itemView) && var1.isTmpDetached()) {
         this.this$0.removeDetachedView(var1.itemView, false);
      }

   }
}
