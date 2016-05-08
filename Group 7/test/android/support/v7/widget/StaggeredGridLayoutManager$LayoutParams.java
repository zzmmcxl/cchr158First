package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager$Span;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class StaggeredGridLayoutManager$LayoutParams extends RecyclerView$LayoutParams {
   public static final int INVALID_SPAN_ID = -1;
   boolean mFullSpan;
   StaggeredGridLayoutManager$Span mSpan;

   public StaggeredGridLayoutManager$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   public StaggeredGridLayoutManager$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public StaggeredGridLayoutManager$LayoutParams(RecyclerView$LayoutParams var1) {
      super(var1);
   }

   public StaggeredGridLayoutManager$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public StaggeredGridLayoutManager$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }

   public final int getSpanIndex() {
      return this.mSpan == null?-1:this.mSpan.mIndex;
   }

   public boolean isFullSpan() {
      return this.mFullSpan;
   }

   public void setFullSpan(boolean var1) {
      this.mFullSpan = var1;
   }
}
