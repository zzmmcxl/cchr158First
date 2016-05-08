package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper$UpdateOp;
import android.support.v7.widget.RecyclerView$ViewHolder;

interface AdapterHelper$Callback {
   RecyclerView$ViewHolder findViewHolder(int var1);

   void markViewHoldersUpdated(int var1, int var2, Object var3);

   void offsetPositionsForAdd(int var1, int var2);

   void offsetPositionsForMove(int var1, int var2);

   void offsetPositionsForRemovingInvisible(int var1, int var2);

   void offsetPositionsForRemovingLaidOutOrNewView(int var1, int var2);

   void onDispatchFirstPass(AdapterHelper$UpdateOp var1);

   void onDispatchSecondPass(AdapterHelper$UpdateOp var1);
}
