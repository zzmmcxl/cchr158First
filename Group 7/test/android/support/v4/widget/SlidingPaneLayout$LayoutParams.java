package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class SlidingPaneLayout$LayoutParams extends MarginLayoutParams {
   private static final int[] ATTRS = new int[]{16843137};
   Paint dimPaint;
   boolean dimWhenOffset;
   boolean slideable;
   public float weight = 0.0F;

   public SlidingPaneLayout$LayoutParams() {
      super(-1, -1);
   }

   public SlidingPaneLayout$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   public SlidingPaneLayout$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, ATTRS);
      this.weight = var3.getFloat(0, 0.0F);
      var3.recycle();
   }

   public SlidingPaneLayout$LayoutParams(SlidingPaneLayout$LayoutParams var1) {
      super(var1);
      this.weight = var1.weight;
   }

   public SlidingPaneLayout$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public SlidingPaneLayout$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }
}
