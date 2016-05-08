package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$State;
import android.view.View;

public abstract class RecyclerView$ItemDecoration {
   @Deprecated
   public void getItemOffsets(Rect var1, int var2, RecyclerView var3) {
      var1.set(0, 0, 0, 0);
   }

   public void getItemOffsets(Rect var1, View var2, RecyclerView var3, RecyclerView$State var4) {
      this.getItemOffsets(var1, ((RecyclerView$LayoutParams)var2.getLayoutParams()).getViewLayoutPosition(), var3);
   }

   @Deprecated
   public void onDraw(Canvas var1, RecyclerView var2) {
   }

   public void onDraw(Canvas var1, RecyclerView var2, RecyclerView$State var3) {
      this.onDraw(var1, var2);
   }

   @Deprecated
   public void onDrawOver(Canvas var1, RecyclerView var2) {
   }

   public void onDrawOver(Canvas var1, RecyclerView var2, RecyclerView$State var3) {
      this.onDrawOver(var1, var2);
   }
}
