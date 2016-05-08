package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper$UpdateOp;

interface OpReorderer$Callback {
   AdapterHelper$UpdateOp obtainUpdateOp(int var1, int var2, int var3, Object var4);

   void recycleUpdateOp(AdapterHelper$UpdateOp var1);
}
