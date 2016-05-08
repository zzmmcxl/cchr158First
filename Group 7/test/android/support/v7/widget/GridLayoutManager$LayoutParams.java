package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class GridLayoutManager$LayoutParams extends RecyclerView$LayoutParams {
   public static final int INVALID_SPAN_ID = -1;
   private int mSpanIndex = -1;
   private int mSpanSize = 0;

   public GridLayoutManager$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   public GridLayoutManager$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public GridLayoutManager$LayoutParams(RecyclerView$LayoutParams var1) {
      super(var1);
   }

   public GridLayoutManager$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public GridLayoutManager$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }

   public int getSpanIndex() {
      return this.mSpanIndex;
   }

   public int getSpanSize() {
      return this.mSpanSize;
   }
}
