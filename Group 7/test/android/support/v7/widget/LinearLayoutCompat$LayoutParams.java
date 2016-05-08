package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class LinearLayoutCompat$LayoutParams extends MarginLayoutParams {
   public int gravity = -1;
   public float weight;

   public LinearLayoutCompat$LayoutParams(int var1, int var2) {
      super(var1, var2);
      this.weight = 0.0F;
   }

   public LinearLayoutCompat$LayoutParams(int var1, int var2, float var3) {
      super(var1, var2);
      this.weight = var3;
   }

   public LinearLayoutCompat$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.LinearLayoutCompat_Layout);
      this.weight = var3.getFloat(R$styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = var3.getInt(R$styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      var3.recycle();
   }

   public LinearLayoutCompat$LayoutParams(LinearLayoutCompat$LayoutParams var1) {
      super(var1);
      this.weight = var1.weight;
      this.gravity = var1.gravity;
   }

   public LinearLayoutCompat$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public LinearLayoutCompat$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }
}
