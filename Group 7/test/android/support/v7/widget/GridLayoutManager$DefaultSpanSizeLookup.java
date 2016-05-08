package android.support.v7.widget;

import android.support.v7.widget.GridLayoutManager$SpanSizeLookup;

public final class GridLayoutManager$DefaultSpanSizeLookup extends GridLayoutManager$SpanSizeLookup {
   public int getSpanIndex(int var1, int var2) {
      return var1 % var2;
   }

   public int getSpanSize(int var1) {
      return 1;
   }
}
