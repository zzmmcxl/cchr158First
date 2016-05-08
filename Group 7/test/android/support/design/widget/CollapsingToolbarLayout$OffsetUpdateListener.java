package android.support.design.widget;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CollapsingToolbarLayout$LayoutParams;
import android.support.design.widget.ViewOffsetHelper;
import android.support.v4.view.ViewCompat;
import android.view.View;

class CollapsingToolbarLayout$OffsetUpdateListener implements AppBarLayout$OnOffsetChangedListener {
   private CollapsingToolbarLayout$OffsetUpdateListener(CollapsingToolbarLayout var1) {
      this.this$0 = var1;
   }

   public void onOffsetChanged(AppBarLayout var1, int var2) {
      boolean var7 = false;
      CollapsingToolbarLayout.access$302(this.this$0, var2);
      int var3;
      if(CollapsingToolbarLayout.access$400(this.this$0) != null) {
         var3 = CollapsingToolbarLayout.access$400(this.this$0).getSystemWindowInsetTop();
      } else {
         var3 = 0;
      }

      int var5 = var1.getTotalScrollRange();
      int var4 = 0;

      int var6;
      for(var6 = this.this$0.getChildCount(); var4 < var6; ++var4) {
         View var8 = this.this$0.getChildAt(var4);
         CollapsingToolbarLayout$LayoutParams var9 = (CollapsingToolbarLayout$LayoutParams)var8.getLayoutParams();
         ViewOffsetHelper var10 = CollapsingToolbarLayout.access$500(var8);
         switch(var9.mCollapseMode) {
         case 1:
            if(this.this$0.getHeight() - var3 + var2 >= var8.getHeight()) {
               var10.setTopAndBottomOffset(-var2);
            }
            break;
         case 2:
            var10.setTopAndBottomOffset(Math.round((float)(-var2) * var9.mParallaxMult));
         }
      }

      if(CollapsingToolbarLayout.access$600(this.this$0) != null || CollapsingToolbarLayout.access$700(this.this$0) != null) {
         CollapsingToolbarLayout var11 = this.this$0;
         if(this.this$0.getHeight() + var2 < this.this$0.getScrimTriggerOffset() + var3) {
            var7 = true;
         }

         var11.setScrimsShown(var7);
      }

      if(CollapsingToolbarLayout.access$700(this.this$0) != null && var3 > 0) {
         ViewCompat.postInvalidateOnAnimation(this.this$0);
      }

      var4 = this.this$0.getHeight();
      var6 = ViewCompat.getMinimumHeight(this.this$0);
      CollapsingToolbarLayout.access$800(this.this$0).setExpansionFraction((float)Math.abs(var2) / (float)(var4 - var6 - var3));
      if(Math.abs(var2) == var5) {
         ViewCompat.setElevation(var1, var1.getTargetElevation());
      } else {
         ViewCompat.setElevation(var1, 0.0F);
      }
   }
}
