package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class ViewPager$LayoutParams extends LayoutParams {
   int childIndex;
   public int gravity;
   public boolean isDecor;
   boolean needsMeasure;
   int position;
   float widthFactor = 0.0F;

   public ViewPager$LayoutParams() {
      super(-1, -1);
   }

   public ViewPager$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, ViewPager.access$400());
      this.gravity = var3.getInteger(0, 48);
      var3.recycle();
   }
}
