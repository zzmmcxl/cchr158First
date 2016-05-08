package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R$styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public class AppBarLayout$LayoutParams extends LayoutParams {
   static final int FLAG_QUICK_RETURN = 5;
   static final int FLAG_SNAP = 17;
   public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
   public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
   public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
   public static final int SCROLL_FLAG_SCROLL = 1;
   public static final int SCROLL_FLAG_SNAP = 16;
   int mScrollFlags = 1;
   Interpolator mScrollInterpolator;

   public AppBarLayout$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   public AppBarLayout$LayoutParams(int var1, int var2, float var3) {
      super(var1, var2, var3);
   }

   public AppBarLayout$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.AppBarLayout_LayoutParams);
      this.mScrollFlags = var3.getInt(R$styleable.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
      if(var3.hasValue(R$styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
         this.mScrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(var1, var3.getResourceId(R$styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
      }

      var3.recycle();
   }

   public AppBarLayout$LayoutParams(AppBarLayout$LayoutParams var1) {
      super(var1);
      this.mScrollFlags = var1.mScrollFlags;
      this.mScrollInterpolator = var1.mScrollInterpolator;
   }

   public AppBarLayout$LayoutParams(android.view.ViewGroup.LayoutParams var1) {
      super(var1);
   }

   public AppBarLayout$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }

   public AppBarLayout$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public int getScrollFlags() {
      return this.mScrollFlags;
   }

   public Interpolator getScrollInterpolator() {
      return this.mScrollInterpolator;
   }

   public void setScrollFlags(int var1) {
      this.mScrollFlags = var1;
   }

   public void setScrollInterpolator(Interpolator var1) {
      this.mScrollInterpolator = var1;
   }
}
