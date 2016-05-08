package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

interface ChildHelper$Callback {
   void addView(View var1, int var2);

   void attachViewToParent(View var1, int var2, LayoutParams var3);

   void detachViewFromParent(int var1);

   View getChildAt(int var1);

   int getChildCount();

   RecyclerView$ViewHolder getChildViewHolder(View var1);

   int indexOfChild(View var1);

   void onEnteredHiddenState(View var1);

   void onLeftHiddenState(View var1);

   void removeAllViews();

   void removeViewAt(int var1);
}
