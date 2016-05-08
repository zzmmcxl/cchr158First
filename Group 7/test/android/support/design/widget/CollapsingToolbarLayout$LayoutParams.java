package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R$styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout$LayoutParams extends LayoutParams {
   public static final int COLLAPSE_MODE_OFF = 0;
   public static final int COLLAPSE_MODE_PARALLAX = 2;
   public static final int COLLAPSE_MODE_PIN = 1;
   private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
   int mCollapseMode = 0;
   float mParallaxMult = 0.5F;

   public CollapsingToolbarLayout$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   public CollapsingToolbarLayout$LayoutParams(int var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public CollapsingToolbarLayout$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.CollapsingAppBarLayout_LayoutParams);
      this.mCollapseMode = var3.getInt(R$styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
      this.setParallaxMultiplier(var3.getFloat(R$styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5F));
      var3.recycle();
   }

   public CollapsingToolbarLayout$LayoutParams(android.view.ViewGroup.LayoutParams var1) {
      super(var1);
   }

   public CollapsingToolbarLayout$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }

   public CollapsingToolbarLayout$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public int getCollapseMode() {
      return this.mCollapseMode;
   }

   public float getParallaxMultiplier() {
      return this.mParallaxMult;
   }

   public void setCollapseMode(int var1) {
      this.mCollapseMode = var1;
   }

   public void setParallaxMultiplier(float var1) {
      this.mParallaxMult = var1;
   }
}
