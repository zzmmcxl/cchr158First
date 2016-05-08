package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import android.support.v7.widget.RecyclerView$ViewHolder;

interface ViewInfoStore$ProcessCallback {
   void processAppeared(RecyclerView$ViewHolder var1, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var2, RecyclerView$ItemAnimator$ItemHolderInfo var3);

   void processDisappeared(RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var3);

   void processPersistent(RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3);

   void unused(RecyclerView$ViewHolder var1);
}
