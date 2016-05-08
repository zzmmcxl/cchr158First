package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R$styleable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$Behavior;
import android.support.design.widget.CoordinatorLayout$LayoutParams;
import android.support.design.widget.HeaderScrollingViewBehavior;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior extends HeaderScrollingViewBehavior {
   public AppBarLayout$ScrollingViewBehavior() {
   }

   public AppBarLayout$ScrollingViewBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.ScrollingViewBehavior_Params);
      this.setOverlayTop(var3.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
      var3.recycle();
   }

   private static int getAppBarLayoutOffset(AppBarLayout var0) {
      CoordinatorLayout$Behavior var1 = ((CoordinatorLayout$LayoutParams)var0.getLayoutParams()).getBehavior();
      return var1 instanceof AppBarLayout$Behavior?((AppBarLayout$Behavior)var1).getTopBottomOffsetForScrollingSibling():0;
   }

   private void offsetChildAsNeeded(CoordinatorLayout var1, View var2, View var3) {
      CoordinatorLayout$Behavior var4 = ((CoordinatorLayout$LayoutParams)var3.getLayoutParams()).getBehavior();
      if(var4 instanceof AppBarLayout$Behavior) {
         AppBarLayout$Behavior var5 = (AppBarLayout$Behavior)var4;
         var5.getTopBottomOffsetForScrollingSibling();
         var2.offsetTopAndBottom(var3.getBottom() - var2.getTop() + AppBarLayout$Behavior.access$1000(var5) + this.getVerticalLayoutGap() - this.getOverlapPixelsForOffset(var3));
      }

   }

   View findFirstDependency(List<View> var1) {
      int var2 = 0;

      for(int var3 = var1.size(); var2 < var3; ++var2) {
         View var4 = (View)var1.get(var2);
         if(var4 instanceof AppBarLayout) {
            return var4;
         }
      }

      return null;
   }

   float getOverlapRatioForOffset(View var1) {
      if(var1 instanceof AppBarLayout) {
         AppBarLayout var5 = (AppBarLayout)var1;
         int var3 = var5.getTotalScrollRange();
         int var4 = AppBarLayout.access$200(var5);
         int var2 = getAppBarLayoutOffset(var5);
         if(var4 == 0 || var3 + var2 > var4) {
            var3 -= var4;
            if(var3 != 0) {
               return 1.0F + (float)var2 / (float)var3;
            }
         }
      }

      return 0.0F;
   }

   int getScrollRange(View var1) {
      return var1 instanceof AppBarLayout?((AppBarLayout)var1).getTotalScrollRange():super.getScrollRange(var1);
   }

   public boolean layoutDependsOn(CoordinatorLayout var1, View var2, View var3) {
      return var3 instanceof AppBarLayout;
   }

   public boolean onDependentViewChanged(CoordinatorLayout var1, View var2, View var3) {
      this.offsetChildAsNeeded(var1, var2, var3);
      return false;
   }
}
