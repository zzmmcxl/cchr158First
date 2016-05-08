package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.widget.AppBarLayout$1;
import android.support.design.widget.AppBarLayout$Behavior;
import android.support.design.widget.AppBarLayout$LayoutParams;
import android.support.design.widget.AppBarLayout$OnOffsetChangedListener;
import android.support.design.widget.CoordinatorLayout$DefaultBehavior;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ViewUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout$DefaultBehavior(AppBarLayout$Behavior.class)
public class AppBarLayout extends LinearLayout {
   private static final int INVALID_SCROLL_RANGE = -1;
   private static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
   private static final int PENDING_ACTION_COLLAPSED = 2;
   private static final int PENDING_ACTION_EXPANDED = 1;
   private static final int PENDING_ACTION_NONE = 0;
   private int mDownPreScrollRange;
   private int mDownScrollRange;
   boolean mHaveChildWithInterpolator;
   private WindowInsetsCompat mLastInsets;
   private final List<AppBarLayout$OnOffsetChangedListener> mListeners;
   private int mPendingAction;
   private float mTargetElevation;
   private int mTotalScrollRange;

   public AppBarLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppBarLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mTotalScrollRange = -1;
      this.mDownPreScrollRange = -1;
      this.mDownScrollRange = -1;
      this.mPendingAction = 0;
      this.setOrientation(1);
      ThemeUtils.checkAppCompatTheme(var1);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.AppBarLayout, 0, R$style.Widget_Design_AppBarLayout);
      this.mTargetElevation = (float)var3.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0);
      this.setBackgroundDrawable(var3.getDrawable(R$styleable.AppBarLayout_android_background));
      if(var3.hasValue(R$styleable.AppBarLayout_expanded)) {
         this.setExpanded(var3.getBoolean(R$styleable.AppBarLayout_expanded, false));
      }

      var3.recycle();
      ViewUtils.setBoundsViewOutlineProvider(this);
      this.mListeners = new ArrayList();
      ViewCompat.setElevation(this, this.mTargetElevation);
      ViewCompat.setOnApplyWindowInsetsListener(this, new AppBarLayout$1(this));
   }

   private int getDownNestedPreScrollRange() {
      if(this.mDownPreScrollRange != -1) {
         return this.mDownPreScrollRange;
      } else {
         int var3 = 0;

         int var1;
         for(int var2 = this.getChildCount() - 1; var2 >= 0; var3 = var1) {
            View var5 = this.getChildAt(var2);
            AppBarLayout$LayoutParams var6 = (AppBarLayout$LayoutParams)var5.getLayoutParams();
            var1 = var5.getMeasuredHeight();
            int var4 = var6.mScrollFlags;
            if((var4 & 5) == 5) {
               var3 += var6.topMargin + var6.bottomMargin;
               if((var4 & 8) != 0) {
                  var1 = var3 + ViewCompat.getMinimumHeight(var5);
               } else if((var4 & 2) != 0) {
                  var1 = var3 + (var1 - ViewCompat.getMinimumHeight(var5));
               } else {
                  var1 += var3;
               }
            } else {
               var1 = var3;
               if(var3 > 0) {
                  break;
               }
            }

            --var2;
         }

         var1 = Math.max(0, var3 - this.getTopInset());
         this.mDownPreScrollRange = var1;
         return var1;
      }
   }

   private int getDownNestedScrollRange() {
      if(this.mDownScrollRange != -1) {
         return this.mDownScrollRange;
      } else {
         int var1 = 0;
         int var2 = 0;
         int var4 = this.getChildCount();

         int var3;
         while(true) {
            var3 = var1;
            if(var2 >= var4) {
               break;
            }

            View var9 = this.getChildAt(var2);
            AppBarLayout$LayoutParams var10 = (AppBarLayout$LayoutParams)var9.getLayoutParams();
            int var6 = var9.getMeasuredHeight();
            int var7 = var10.topMargin;
            int var8 = var10.bottomMargin;
            int var5 = var10.mScrollFlags;
            var3 = var1;
            if((var5 & 1) == 0) {
               break;
            }

            var1 += var6 + var7 + var8;
            if((var5 & 2) != 0) {
               var3 = var1 - (ViewCompat.getMinimumHeight(var9) + this.getTopInset());
               break;
            }

            ++var2;
         }

         var1 = Math.max(0, var3);
         this.mDownScrollRange = var1;
         return var1;
      }
   }

   private int getPendingAction() {
      return this.mPendingAction;
   }

   private int getTopInset() {
      return this.mLastInsets != null?this.mLastInsets.getSystemWindowInsetTop():0;
   }

   private int getUpNestedPreScrollRange() {
      return this.getTotalScrollRange();
   }

   private boolean hasChildWithInterpolator() {
      return this.mHaveChildWithInterpolator;
   }

   private boolean hasScrollableChildren() {
      return this.getTotalScrollRange() != 0;
   }

   private void invalidateScrollRanges() {
      this.mTotalScrollRange = -1;
      this.mDownPreScrollRange = -1;
      this.mDownScrollRange = -1;
   }

   private WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat var1) {
      WindowInsetsCompat var2 = null;
      if(ViewCompat.getFitsSystemWindows(this)) {
         var2 = var1;
      }

      if(var2 != this.mLastInsets) {
         this.mLastInsets = var2;
         this.invalidateScrollRanges();
      }

      return var1;
   }

   private void resetPendingAction() {
      this.mPendingAction = 0;
   }

   public void addOnOffsetChangedListener(AppBarLayout$OnOffsetChangedListener var1) {
      if(var1 != null && !this.mListeners.contains(var1)) {
         this.mListeners.add(var1);
      }

   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof AppBarLayout$LayoutParams;
   }

   protected AppBarLayout$LayoutParams generateDefaultLayoutParams() {
      return new AppBarLayout$LayoutParams(-1, -2);
   }

   public AppBarLayout$LayoutParams generateLayoutParams(AttributeSet var1) {
      return new AppBarLayout$LayoutParams(this.getContext(), var1);
   }

   protected AppBarLayout$LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof android.widget.LinearLayout.LayoutParams?new AppBarLayout$LayoutParams((android.widget.LinearLayout.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new AppBarLayout$LayoutParams((MarginLayoutParams)var1):new AppBarLayout$LayoutParams(var1));
   }

   final int getMinimumHeightForVisibleOverlappingContent() {
      int var1 = this.getTopInset();
      int var2 = ViewCompat.getMinimumHeight(this);
      if(var2 != 0) {
         return var2 * 2 + var1;
      } else {
         var2 = this.getChildCount();
         return var2 >= 1?ViewCompat.getMinimumHeight(this.getChildAt(var2 - 1)) * 2 + var1:0;
      }
   }

   public float getTargetElevation() {
      return this.mTargetElevation;
   }

   public final int getTotalScrollRange() {
      if(this.mTotalScrollRange != -1) {
         return this.mTotalScrollRange;
      } else {
         int var1 = 0;
         int var2 = 0;
         int var4 = this.getChildCount();

         int var3;
         while(true) {
            var3 = var1;
            if(var2 >= var4) {
               break;
            }

            View var7 = this.getChildAt(var2);
            AppBarLayout$LayoutParams var8 = (AppBarLayout$LayoutParams)var7.getLayoutParams();
            int var6 = var7.getMeasuredHeight();
            int var5 = var8.mScrollFlags;
            var3 = var1;
            if((var5 & 1) == 0) {
               break;
            }

            var1 += var8.topMargin + var6 + var8.bottomMargin;
            if((var5 & 2) != 0) {
               var3 = var1 - ViewCompat.getMinimumHeight(var7);
               break;
            }

            ++var2;
         }

         var1 = Math.max(0, var3 - this.getTopInset());
         this.mTotalScrollRange = var1;
         return var1;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.invalidateScrollRanges();
      this.mHaveChildWithInterpolator = false;
      var2 = 0;

      for(var3 = this.getChildCount(); var2 < var3; ++var2) {
         if(((AppBarLayout$LayoutParams)this.getChildAt(var2).getLayoutParams()).getScrollInterpolator() != null) {
            this.mHaveChildWithInterpolator = true;
            break;
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      this.invalidateScrollRanges();
   }

   public void removeOnOffsetChangedListener(AppBarLayout$OnOffsetChangedListener var1) {
      if(var1 != null) {
         this.mListeners.remove(var1);
      }

   }

   public void setExpanded(boolean var1) {
      this.setExpanded(var1, ViewCompat.isLaidOut(this));
   }

   public void setExpanded(boolean var1, boolean var2) {
      byte var3;
      if(var1) {
         var3 = 1;
      } else {
         var3 = 2;
      }

      byte var4;
      if(var2) {
         var4 = 4;
      } else {
         var4 = 0;
      }

      this.mPendingAction = var4 | var3;
      this.requestLayout();
   }

   public void setOrientation(int var1) {
      if(var1 != 1) {
         throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
      } else {
         super.setOrientation(var1);
      }
   }

   public void setTargetElevation(float var1) {
      this.mTargetElevation = var1;
   }
}
