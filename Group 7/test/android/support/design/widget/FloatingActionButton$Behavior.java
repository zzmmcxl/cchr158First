package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$Behavior;
import android.support.design.widget.CoordinatorLayout$LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton$Behavior$1;
import android.support.design.widget.FloatingActionButton$OnVisibilityChangedListener;
import android.support.design.widget.Snackbar$SnackbarLayout;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewGroupUtils;
import android.support.design.widget.ViewUtils;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.List;

public class FloatingActionButton$Behavior extends CoordinatorLayout$Behavior<FloatingActionButton> {
   private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
   private float mFabTranslationY;
   private ValueAnimatorCompat mFabTranslationYAnimator;
   private Rect mTmpRect;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 11) {
         var0 = true;
      } else {
         var0 = false;
      }

      SNACKBAR_BEHAVIOR_ENABLED = var0;
   }

   private float getFabTranslationYForSnackbar(CoordinatorLayout var1, FloatingActionButton var2) {
      float var3 = 0.0F;
      List var7 = var1.getDependencies(var2);
      int var5 = 0;

      float var4;
      for(int var6 = var7.size(); var5 < var6; var3 = var4) {
         View var8 = (View)var7.get(var5);
         var4 = var3;
         if(var8 instanceof Snackbar$SnackbarLayout) {
            var4 = var3;
            if(var1.doViewsOverlap(var2, var8)) {
               var4 = Math.min(var3, ViewCompat.getTranslationY(var8) - (float)var8.getHeight());
            }
         }

         ++var5;
      }

      return var3;
   }

   private void offsetIfNeeded(CoordinatorLayout var1, FloatingActionButton var2) {
      Rect var5 = FloatingActionButton.access$200(var2);
      if(var5 != null && var5.centerX() > 0 && var5.centerY() > 0) {
         CoordinatorLayout$LayoutParams var6 = (CoordinatorLayout$LayoutParams)var2.getLayoutParams();
         int var4 = 0;
         int var3 = 0;
         if(var2.getRight() >= var1.getWidth() - var6.rightMargin) {
            var3 = var5.right;
         } else if(var2.getLeft() <= var6.leftMargin) {
            var3 = -var5.left;
         }

         if(var2.getBottom() >= var1.getBottom() - var6.bottomMargin) {
            var4 = var5.bottom;
         } else if(var2.getTop() <= var6.topMargin) {
            var4 = -var5.top;
         }

         var2.offsetTopAndBottom(var4);
         var2.offsetLeftAndRight(var3);
      }

   }

   private void updateFabTranslationForSnackbar(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
      float var4 = this.getFabTranslationYForSnackbar(var1, var2);
      if(this.mFabTranslationY != var4) {
         float var5 = ViewCompat.getTranslationY(var2);
         if(this.mFabTranslationYAnimator != null && this.mFabTranslationYAnimator.isRunning()) {
            this.mFabTranslationYAnimator.cancel();
         }

         if(var2.isShown() && Math.abs(var5 - var4) > (float)var2.getHeight() * 0.667F) {
            if(this.mFabTranslationYAnimator == null) {
               this.mFabTranslationYAnimator = ViewUtils.createAnimator();
               this.mFabTranslationYAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
               this.mFabTranslationYAnimator.setUpdateListener(new FloatingActionButton$Behavior$1(this, var2));
            }

            this.mFabTranslationYAnimator.setFloatValues(var5, var4);
            this.mFabTranslationYAnimator.start();
         } else {
            ViewCompat.setTranslationY(var2, var4);
         }

         this.mFabTranslationY = var4;
      }
   }

   private boolean updateFabVisibility(CoordinatorLayout var1, AppBarLayout var2, FloatingActionButton var3) {
      if(((CoordinatorLayout$LayoutParams)var3.getLayoutParams()).getAnchorId() == var2.getId() && var3.getUserSetVisibility() == 0) {
         if(this.mTmpRect == null) {
            this.mTmpRect = new Rect();
         }

         Rect var4 = this.mTmpRect;
         ViewGroupUtils.getDescendantRect(var1, var2, var4);
         if(var4.bottom <= var2.getMinimumHeightForVisibleOverlappingContent()) {
            FloatingActionButton.access$000(var3, (FloatingActionButton$OnVisibilityChangedListener)null, false);
         } else {
            FloatingActionButton.access$100(var3, (FloatingActionButton$OnVisibilityChangedListener)null, false);
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean layoutDependsOn(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
      return SNACKBAR_BEHAVIOR_ENABLED && var3 instanceof Snackbar$SnackbarLayout;
   }

   public boolean onDependentViewChanged(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
      if(var3 instanceof Snackbar$SnackbarLayout) {
         this.updateFabTranslationForSnackbar(var1, var2, var3);
      } else if(var3 instanceof AppBarLayout) {
         this.updateFabVisibility(var1, (AppBarLayout)var3, var2);
      }

      return false;
   }

   public boolean onLayoutChild(CoordinatorLayout var1, FloatingActionButton var2, int var3) {
      List var6 = var1.getDependencies(var2);
      int var4 = 0;

      for(int var5 = var6.size(); var4 < var5; ++var4) {
         View var7 = (View)var6.get(var4);
         if(var7 instanceof AppBarLayout && this.updateFabVisibility(var1, (AppBarLayout)var7, var2)) {
            break;
         }
      }

      var1.onLayoutChild(var2, var3);
      this.offsetIfNeeded(var1, var2);
      return true;
   }
}
