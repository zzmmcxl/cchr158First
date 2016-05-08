package android.support.v4.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout$1;
import android.support.v4.widget.SlidingPaneLayout$AccessibilityDelegate;
import android.support.v4.widget.SlidingPaneLayout$DisableLayerRunnable;
import android.support.v4.widget.SlidingPaneLayout$DragHelperCallback;
import android.support.v4.widget.SlidingPaneLayout$LayoutParams;
import android.support.v4.widget.SlidingPaneLayout$PanelSlideListener;
import android.support.v4.widget.SlidingPaneLayout$SavedState;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImpl;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJB;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJBMR1;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
   private static final int DEFAULT_FADE_COLOR = -858993460;
   private static final int DEFAULT_OVERHANG_SIZE = 32;
   static final SlidingPaneLayout$SlidingPanelLayoutImpl IMPL;
   private static final int MIN_FLING_VELOCITY = 400;
   private static final String TAG = "SlidingPaneLayout";
   private boolean mCanSlide;
   private int mCoveredFadeColor;
   private final ViewDragHelper mDragHelper;
   private boolean mFirstLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private boolean mIsUnableToDrag;
   private final int mOverhangSize;
   private SlidingPaneLayout$PanelSlideListener mPanelSlideListener;
   private int mParallaxBy;
   private float mParallaxOffset;
   private final ArrayList<SlidingPaneLayout$DisableLayerRunnable> mPostedRunnables;
   private boolean mPreservedOpenState;
   private Drawable mShadowDrawableLeft;
   private Drawable mShadowDrawableRight;
   private float mSlideOffset;
   private int mSlideRange;
   private View mSlideableView;
   private int mSliderFadeColor;
   private final Rect mTmpRect;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 17) {
         IMPL = new SlidingPaneLayout$SlidingPanelLayoutImplJBMR1();
      } else if(var0 >= 16) {
         IMPL = new SlidingPaneLayout$SlidingPanelLayoutImplJB();
      } else {
         IMPL = new SlidingPaneLayout$SlidingPanelLayoutImplBase();
      }
   }

   public SlidingPaneLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SlidingPaneLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SlidingPaneLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mSliderFadeColor = -858993460;
      this.mFirstLayout = true;
      this.mTmpRect = new Rect();
      this.mPostedRunnables = new ArrayList();
      float var4 = var1.getResources().getDisplayMetrics().density;
      this.mOverhangSize = (int)(32.0F * var4 + 0.5F);
      ViewConfiguration.get(var1);
      this.setWillNotDraw(false);
      ViewCompat.setAccessibilityDelegate(this, new SlidingPaneLayout$AccessibilityDelegate(this));
      ViewCompat.setImportantForAccessibility(this, 1);
      this.mDragHelper = ViewDragHelper.create(this, 0.5F, new SlidingPaneLayout$DragHelperCallback(this, (SlidingPaneLayout$1)null));
      this.mDragHelper.setMinVelocity(400.0F * var4);
   }

   private boolean closePane(View var1, int var2) {
      boolean var3 = false;
      if(this.mFirstLayout || this.smoothSlideTo(0.0F, var2)) {
         this.mPreservedOpenState = false;
         var3 = true;
      }

      return var3;
   }

   private void dimChildView(View var1, float var2, int var3) {
      SlidingPaneLayout$LayoutParams var5 = (SlidingPaneLayout$LayoutParams)var1.getLayoutParams();
      if(var2 > 0.0F && var3 != 0) {
         int var4 = (int)((float)((-16777216 & var3) >>> 24) * var2);
         if(var5.dimPaint == null) {
            var5.dimPaint = new Paint();
         }

         var5.dimPaint.setColorFilter(new PorterDuffColorFilter(var4 << 24 | 16777215 & var3, Mode.SRC_OVER));
         if(ViewCompat.getLayerType(var1) != 2) {
            ViewCompat.setLayerType(var1, 2, var5.dimPaint);
         }

         this.invalidateChildRegion(var1);
      } else if(ViewCompat.getLayerType(var1) != 0) {
         if(var5.dimPaint != null) {
            var5.dimPaint.setColorFilter((ColorFilter)null);
         }

         SlidingPaneLayout$DisableLayerRunnable var6 = new SlidingPaneLayout$DisableLayerRunnable(this, var1);
         this.mPostedRunnables.add(var6);
         ViewCompat.postOnAnimation(this, var6);
         return;
      }

   }

   private void invalidateChildRegion(View var1) {
      IMPL.invalidateChildRegion(this, var1);
   }

   private boolean isLayoutRtlSupport() {
      return ViewCompat.getLayoutDirection(this) == 1;
   }

   private void onPanelDragged(int var1) {
      if(this.mSlideableView == null) {
         this.mSlideOffset = 0.0F;
      } else {
         boolean var4 = this.isLayoutRtlSupport();
         SlidingPaneLayout$LayoutParams var5 = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
         int var2 = this.mSlideableView.getWidth();
         if(var4) {
            var1 = this.getWidth() - var1 - var2;
         }

         if(var4) {
            var2 = this.getPaddingRight();
         } else {
            var2 = this.getPaddingLeft();
         }

         int var3;
         if(var4) {
            var3 = var5.rightMargin;
         } else {
            var3 = var5.leftMargin;
         }

         this.mSlideOffset = (float)(var1 - (var2 + var3)) / (float)this.mSlideRange;
         if(this.mParallaxBy != 0) {
            this.parallaxOtherViews(this.mSlideOffset);
         }

         if(var5.dimWhenOffset) {
            this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
         }

         this.dispatchOnPanelSlide(this.mSlideableView);
      }
   }

   private boolean openPane(View var1, int var2) {
      if(!this.mFirstLayout && !this.smoothSlideTo(1.0F, var2)) {
         return false;
      } else {
         this.mPreservedOpenState = true;
         return true;
      }
   }

   private void parallaxOtherViews(float var1) {
      boolean var8;
      boolean var10;
      label39: {
         var8 = this.isLayoutRtlSupport();
         SlidingPaneLayout$LayoutParams var9 = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
         if(var9.dimWhenOffset) {
            int var3;
            if(var8) {
               var3 = var9.rightMargin;
            } else {
               var3 = var9.leftMargin;
            }

            if(var3 <= 0) {
               var10 = true;
               break label39;
            }
         }

         var10 = false;
      }

      int var7 = this.getChildCount();

      for(int var4 = 0; var4 < var7; ++var4) {
         View var11 = this.getChildAt(var4);
         if(var11 != this.mSlideableView) {
            int var5 = (int)((1.0F - this.mParallaxOffset) * (float)this.mParallaxBy);
            this.mParallaxOffset = var1;
            int var6 = var5 - (int)((1.0F - var1) * (float)this.mParallaxBy);
            var5 = var6;
            if(var8) {
               var5 = -var6;
            }

            var11.offsetLeftAndRight(var5);
            if(var10) {
               float var2;
               if(var8) {
                  var2 = this.mParallaxOffset - 1.0F;
               } else {
                  var2 = 1.0F - this.mParallaxOffset;
               }

               this.dimChildView(var11, var2, this.mCoveredFadeColor);
            }
         }
      }

   }

   private static boolean viewIsOpaque(View var0) {
      if(!ViewCompat.isOpaque(var0)) {
         if(VERSION.SDK_INT >= 18) {
            return false;
         }

         Drawable var1 = var0.getBackground();
         if(var1 == null) {
            return false;
         }

         if(var1.getOpacity() != -1) {
            return false;
         }
      }

      return true;
   }

   protected boolean canScroll(View var1, boolean var2, int var3, int var4, int var5) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var9 = (ViewGroup)var1;
         int var7 = var1.getScrollX();
         int var8 = var1.getScrollY();

         for(int var6 = var9.getChildCount() - 1; var6 >= 0; --var6) {
            View var10 = var9.getChildAt(var6);
            if(var4 + var7 >= var10.getLeft() && var4 + var7 < var10.getRight() && var5 + var8 >= var10.getTop() && var5 + var8 < var10.getBottom() && this.canScroll(var10, true, var3, var4 + var7 - var10.getLeft(), var5 + var8 - var10.getTop())) {
               return true;
            }
         }
      }

      if(var2) {
         if(!this.isLayoutRtlSupport()) {
            var3 = -var3;
         }

         if(ViewCompat.canScrollHorizontally(var1, var3)) {
            return true;
         }
      }

      return false;
   }

   @Deprecated
   public boolean canSlide() {
      return this.mCanSlide;
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof SlidingPaneLayout$LayoutParams && super.checkLayoutParams(var1);
   }

   public boolean closePane() {
      return this.closePane(this.mSlideableView, 0);
   }

   public void computeScroll() {
      if(this.mDragHelper.continueSettling(true)) {
         if(this.mCanSlide) {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
         }

         this.mDragHelper.abort();
      }

   }

   void dispatchOnPanelClosed(View var1) {
      if(this.mPanelSlideListener != null) {
         this.mPanelSlideListener.onPanelClosed(var1);
      }

      this.sendAccessibilityEvent(32);
   }

   void dispatchOnPanelOpened(View var1) {
      if(this.mPanelSlideListener != null) {
         this.mPanelSlideListener.onPanelOpened(var1);
      }

      this.sendAccessibilityEvent(32);
   }

   void dispatchOnPanelSlide(View var1) {
      if(this.mPanelSlideListener != null) {
         this.mPanelSlideListener.onPanelSlide(var1, this.mSlideOffset);
      }

   }

   public void draw(Canvas var1) {
      super.draw(var1);
      Drawable var7;
      if(this.isLayoutRtlSupport()) {
         var7 = this.mShadowDrawableRight;
      } else {
         var7 = this.mShadowDrawableLeft;
      }

      View var8;
      if(this.getChildCount() > 1) {
         var8 = this.getChildAt(1);
      } else {
         var8 = null;
      }

      if(var8 != null && var7 != null) {
         int var4 = var8.getTop();
         int var5 = var8.getBottom();
         int var6 = var7.getIntrinsicWidth();
         int var2;
         int var3;
         if(this.isLayoutRtlSupport()) {
            var2 = var8.getRight();
            var3 = var2 + var6;
         } else {
            var3 = var8.getLeft();
            var2 = var3 - var6;
         }

         var7.setBounds(var2, var4, var3, var5);
         var7.draw(var1);
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      SlidingPaneLayout$LayoutParams var7 = (SlidingPaneLayout$LayoutParams)var2.getLayoutParams();
      int var5 = var1.save(2);
      if(this.mCanSlide && !var7.slideable && this.mSlideableView != null) {
         var1.getClipBounds(this.mTmpRect);
         if(this.isLayoutRtlSupport()) {
            this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
         } else {
            this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
         }

         var1.clipRect(this.mTmpRect);
      }

      boolean var6;
      if(VERSION.SDK_INT >= 11) {
         var6 = super.drawChild(var1, var2, var3);
      } else if(var7.dimWhenOffset && this.mSlideOffset > 0.0F) {
         if(!var2.isDrawingCacheEnabled()) {
            var2.setDrawingCacheEnabled(true);
         }

         Bitmap var8 = var2.getDrawingCache();
         if(var8 != null) {
            var1.drawBitmap(var8, (float)var2.getLeft(), (float)var2.getTop(), var7.dimPaint);
            var6 = false;
         } else {
            Log.e("SlidingPaneLayout", "drawChild: child view " + var2 + " returned null drawing cache");
            var6 = super.drawChild(var1, var2, var3);
         }
      } else {
         if(var2.isDrawingCacheEnabled()) {
            var2.setDrawingCacheEnabled(false);
         }

         var6 = super.drawChild(var1, var2, var3);
      }

      var1.restoreToCount(var5);
      return var6;
   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new SlidingPaneLayout$LayoutParams();
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new SlidingPaneLayout$LayoutParams(this.getContext(), var1);
   }

   protected LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof MarginLayoutParams?new SlidingPaneLayout$LayoutParams((MarginLayoutParams)var1):new SlidingPaneLayout$LayoutParams(var1);
   }

   @ColorInt
   public int getCoveredFadeColor() {
      return this.mCoveredFadeColor;
   }

   public int getParallaxDistance() {
      return this.mParallaxBy;
   }

   @ColorInt
   public int getSliderFadeColor() {
      return this.mSliderFadeColor;
   }

   boolean isDimmed(View var1) {
      if(var1 != null) {
         SlidingPaneLayout$LayoutParams var2 = (SlidingPaneLayout$LayoutParams)var1.getLayoutParams();
         if(this.mCanSlide && var2.dimWhenOffset && this.mSlideOffset > 0.0F) {
            return true;
         }
      }

      return false;
   }

   public boolean isOpen() {
      return !this.mCanSlide || this.mSlideOffset == 1.0F;
   }

   public boolean isSlideable() {
      return this.mCanSlide;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mFirstLayout = true;
      int var1 = 0;

      for(int var2 = this.mPostedRunnables.size(); var1 < var2; ++var1) {
         ((SlidingPaneLayout$DisableLayerRunnable)this.mPostedRunnables.get(var1)).run();
      }

      this.mPostedRunnables.clear();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var6 = MotionEventCompat.getActionMasked(var1);
      if(!this.mCanSlide && var6 == 0 && this.getChildCount() > 1) {
         View var8 = this.getChildAt(1);
         if(var8 != null) {
            boolean var7;
            if(!this.mDragHelper.isViewUnder(var8, (int)var1.getX(), (int)var1.getY())) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.mPreservedOpenState = var7;
         }
      }

      if(this.mCanSlide && (!this.mIsUnableToDrag || var6 == 0)) {
         if(var6 != 3 && var6 != 1) {
            boolean var5 = false;
            boolean var4 = var5;
            float var2;
            float var3;
            switch(var6) {
            case 0:
               this.mIsUnableToDrag = false;
               var2 = var1.getX();
               var3 = var1.getY();
               this.mInitialMotionX = var2;
               this.mInitialMotionY = var3;
               var4 = var5;
               if(this.mDragHelper.isViewUnder(this.mSlideableView, (int)var2, (int)var3)) {
                  var4 = var5;
                  if(this.isDimmed(this.mSlideableView)) {
                     var4 = true;
                  }
               }
            case 1:
               break;
            case 2:
               var3 = var1.getX();
               var2 = var1.getY();
               var3 = Math.abs(var3 - this.mInitialMotionX);
               var2 = Math.abs(var2 - this.mInitialMotionY);
               var4 = var5;
               if(var3 > (float)this.mDragHelper.getTouchSlop()) {
                  var4 = var5;
                  if(var2 > var3) {
                     this.mDragHelper.cancel();
                     this.mIsUnableToDrag = true;
                     return false;
                  }
               }
               break;
            default:
               var4 = var5;
            }

            return this.mDragHelper.shouldInterceptTouchEvent(var1) || var4;
         } else {
            this.mDragHelper.cancel();
            return false;
         }
      } else {
         this.mDragHelper.cancel();
         return super.onInterceptTouchEvent(var1);
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var14 = this.isLayoutRtlSupport();
      if(var14) {
         this.mDragHelper.setEdgeTrackingEnabled(2);
      } else {
         this.mDragHelper.setEdgeTrackingEnabled(1);
      }

      int var9 = var4 - var2;
      if(var14) {
         var2 = this.getPaddingRight();
      } else {
         var2 = this.getPaddingLeft();
      }

      if(var14) {
         var4 = this.getPaddingLeft();
      } else {
         var4 = this.getPaddingRight();
      }

      int var11 = this.getPaddingTop();
      int var10 = this.getChildCount();
      if(this.mFirstLayout) {
         float var6;
         if(this.mCanSlide && this.mPreservedOpenState) {
            var6 = 1.0F;
         } else {
            var6 = 0.0F;
         }

         this.mSlideOffset = var6;
      }

      byte var7 = 0;
      var3 = var2;
      var2 = var2;

      for(var5 = var7; var5 < var10; ++var5) {
         View var15 = this.getChildAt(var5);
         if(var15.getVisibility() != 8) {
            SlidingPaneLayout$LayoutParams var16 = (SlidingPaneLayout$LayoutParams)var15.getLayoutParams();
            int var12 = var15.getMeasuredWidth();
            byte var8 = 0;
            int var17;
            if(var16.slideable) {
               var17 = var16.leftMargin;
               int var13 = var16.rightMargin;
               var13 = Math.min(var2, var9 - var4 - this.mOverhangSize) - var3 - (var17 + var13);
               this.mSlideRange = var13;
               if(var14) {
                  var17 = var16.rightMargin;
               } else {
                  var17 = var16.leftMargin;
               }

               if(var3 + var17 + var13 + var12 / 2 > var9 - var4) {
                  var1 = true;
               } else {
                  var1 = false;
               }

               var16.dimWhenOffset = var1;
               var13 = (int)((float)var13 * this.mSlideOffset);
               var3 += var13 + var17;
               this.mSlideOffset = (float)var13 / (float)this.mSlideRange;
               var17 = var8;
            } else if(this.mCanSlide && this.mParallaxBy != 0) {
               var17 = (int)((1.0F - this.mSlideOffset) * (float)this.mParallaxBy);
               var3 = var2;
            } else {
               var3 = var2;
               var17 = var8;
            }

            int var18;
            if(var14) {
               var18 = var9 - var3 + var17;
               var17 = var18 - var12;
            } else {
               var17 = var3 - var17;
               var18 = var17 + var12;
            }

            var15.layout(var17, var11, var18, var11 + var15.getMeasuredHeight());
            var2 += var15.getWidth();
         }
      }

      if(this.mFirstLayout) {
         if(this.mCanSlide) {
            if(this.mParallaxBy != 0) {
               this.parallaxOtherViews(this.mSlideOffset);
            }

            if(((SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
               this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
         } else {
            for(var2 = 0; var2 < var10; ++var2) {
               this.dimChildView(this.getChildAt(var2), 0.0F, this.mSliderFadeColor);
            }
         }

         this.updateObscuredViewsVisibility(this.mSlideableView);
      }

      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var8 = MeasureSpec.getMode(var1);
      int var5 = MeasureSpec.getSize(var1);
      int var6 = MeasureSpec.getMode(var2);
      var2 = MeasureSpec.getSize(var2);
      int var7;
      int var9;
      if(var8 != 1073741824) {
         if(!this.isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
         }

         if(var8 == Integer.MIN_VALUE) {
            var7 = var5;
            var1 = var2;
            var9 = var6;
         } else {
            var9 = var6;
            var1 = var2;
            var7 = var5;
            if(var8 == 0) {
               var7 = 300;
               var9 = var6;
               var1 = var2;
            }
         }
      } else {
         var9 = var6;
         var1 = var2;
         var7 = var5;
         if(var6 == 0) {
            if(!this.isInEditMode()) {
               throw new IllegalStateException("Height must not be UNSPECIFIED");
            }

            var9 = var6;
            var1 = var2;
            var7 = var5;
            if(var6 == 0) {
               var9 = Integer.MIN_VALUE;
               var1 = 300;
               var7 = var5;
            }
         }
      }

      var5 = 0;
      var2 = -1;
      switch(var9) {
      case Integer.MIN_VALUE:
         var2 = var1 - this.getPaddingTop() - this.getPaddingBottom();
         break;
      case 1073741824:
         var2 = var1 - this.getPaddingTop() - this.getPaddingBottom();
         var5 = var2;
      }

      float var3 = 0.0F;
      boolean var15 = false;
      int var12 = var7 - this.getPaddingLeft() - this.getPaddingRight();
      var8 = var12;
      int var13 = this.getChildCount();
      if(var13 > 2) {
         Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
      }

      this.mSlideableView = null;

      int var10;
      int var11;
      View var17;
      SlidingPaneLayout$LayoutParams var18;
      for(var10 = 0; var10 < var13; var8 = var11) {
         var17 = this.getChildAt(var10);
         var18 = (SlidingPaneLayout$LayoutParams)var17.getLayoutParams();
         boolean var16;
         if(var17.getVisibility() == 8) {
            var18.dimWhenOffset = false;
            var11 = var8;
            var6 = var5;
            var16 = var15;
         } else {
            label182: {
               float var4 = var3;
               if(var18.weight > 0.0F) {
                  var4 = var3 + var18.weight;
                  var16 = var15;
                  var6 = var5;
                  var3 = var4;
                  var11 = var8;
                  if(var18.width == 0) {
                     break label182;
                  }
               }

               var1 = var18.leftMargin + var18.rightMargin;
               if(var18.width == -2) {
                  var1 = MeasureSpec.makeMeasureSpec(var12 - var1, Integer.MIN_VALUE);
               } else if(var18.width == -1) {
                  var1 = MeasureSpec.makeMeasureSpec(var12 - var1, 1073741824);
               } else {
                  var1 = MeasureSpec.makeMeasureSpec(var18.width, 1073741824);
               }

               if(var18.height == -2) {
                  var6 = MeasureSpec.makeMeasureSpec(var2, Integer.MIN_VALUE);
               } else if(var18.height == -1) {
                  var6 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
               } else {
                  var6 = MeasureSpec.makeMeasureSpec(var18.height, 1073741824);
               }

               var17.measure(var1, var6);
               var6 = var17.getMeasuredWidth();
               var11 = var17.getMeasuredHeight();
               var1 = var5;
               if(var9 == Integer.MIN_VALUE) {
                  var1 = var5;
                  if(var11 > var5) {
                     var1 = Math.min(var11, var2);
                  }
               }

               var5 = var8 - var6;
               if(var5 < 0) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               var18.slideable = var16;
               var15 |= var16;
               var16 = var15;
               var6 = var1;
               var3 = var4;
               var11 = var5;
               if(var18.slideable) {
                  this.mSlideableView = var17;
                  var16 = var15;
                  var6 = var1;
                  var3 = var4;
                  var11 = var5;
               }
            }
         }

         ++var10;
         var15 = var16;
         var5 = var6;
      }

      if(var15 || var3 > 0.0F) {
         var10 = var12 - this.mOverhangSize;

         for(var6 = 0; var6 < var13; ++var6) {
            var17 = this.getChildAt(var6);
            if(var17.getVisibility() != 8) {
               var18 = (SlidingPaneLayout$LayoutParams)var17.getLayoutParams();
               if(var17.getVisibility() != 8) {
                  boolean var19;
                  if(var18.width == 0 && var18.weight > 0.0F) {
                     var19 = true;
                  } else {
                     var19 = false;
                  }

                  if(var19) {
                     var9 = 0;
                  } else {
                     var9 = var17.getMeasuredWidth();
                  }

                  if(var15 && var17 != this.mSlideableView) {
                     if(var18.width < 0 && (var9 > var10 || var18.weight > 0.0F)) {
                        if(var19) {
                           if(var18.height == -2) {
                              var1 = MeasureSpec.makeMeasureSpec(var2, Integer.MIN_VALUE);
                           } else if(var18.height == -1) {
                              var1 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
                           } else {
                              var1 = MeasureSpec.makeMeasureSpec(var18.height, 1073741824);
                           }
                        } else {
                           var1 = MeasureSpec.makeMeasureSpec(var17.getMeasuredHeight(), 1073741824);
                        }

                        var17.measure(MeasureSpec.makeMeasureSpec(var10, 1073741824), var1);
                     }
                  } else if(var18.weight > 0.0F) {
                     if(var18.width == 0) {
                        if(var18.height == -2) {
                           var1 = MeasureSpec.makeMeasureSpec(var2, Integer.MIN_VALUE);
                        } else if(var18.height == -1) {
                           var1 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
                        } else {
                           var1 = MeasureSpec.makeMeasureSpec(var18.height, 1073741824);
                        }
                     } else {
                        var1 = MeasureSpec.makeMeasureSpec(var17.getMeasuredHeight(), 1073741824);
                     }

                     if(var15) {
                        var11 = var12 - (var18.leftMargin + var18.rightMargin);
                        int var14 = MeasureSpec.makeMeasureSpec(var11, 1073741824);
                        if(var9 != var11) {
                           var17.measure(var14, var1);
                        }
                     } else {
                        var11 = Math.max(0, var8);
                        var17.measure(MeasureSpec.makeMeasureSpec(var9 + (int)(var18.weight * (float)var11 / var3), 1073741824), var1);
                     }
                  }
               }
            }
         }
      }

      this.setMeasuredDimension(var7, this.getPaddingTop() + var5 + this.getPaddingBottom());
      this.mCanSlide = var15;
      if(this.mDragHelper.getViewDragState() != 0 && !var15) {
         this.mDragHelper.abort();
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      SlidingPaneLayout$SavedState var2 = (SlidingPaneLayout$SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      if(var2.isOpen) {
         this.openPane();
      } else {
         this.closePane();
      }

      this.mPreservedOpenState = var2.isOpen;
   }

   protected Parcelable onSaveInstanceState() {
      SlidingPaneLayout$SavedState var2 = new SlidingPaneLayout$SavedState(super.onSaveInstanceState());
      boolean var1;
      if(this.isSlideable()) {
         var1 = this.isOpen();
      } else {
         var1 = this.mPreservedOpenState;
      }

      var2.isOpen = var1;
      return var2;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(var1 != var3) {
         this.mFirstLayout = true;
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var7;
      if(!this.mCanSlide) {
         var7 = super.onTouchEvent(var1);
      } else {
         this.mDragHelper.processTouchEvent(var1);
         int var6 = var1.getAction();
         boolean var8 = true;
         float var2;
         float var3;
         switch(var6 & 255) {
         case 0:
            var2 = var1.getX();
            var3 = var1.getY();
            this.mInitialMotionX = var2;
            this.mInitialMotionY = var3;
            return true;
         case 1:
            var7 = var8;
            if(this.isDimmed(this.mSlideableView)) {
               var2 = var1.getX();
               var3 = var1.getY();
               float var4 = var2 - this.mInitialMotionX;
               float var5 = var3 - this.mInitialMotionY;
               var6 = this.mDragHelper.getTouchSlop();
               var7 = var8;
               if(var4 * var4 + var5 * var5 < (float)(var6 * var6)) {
                  var7 = var8;
                  if(this.mDragHelper.isViewUnder(this.mSlideableView, (int)var2, (int)var3)) {
                     this.closePane(this.mSlideableView, 0);
                     return true;
                  }
               }
            }
            break;
         default:
            return true;
         }
      }

      return var7;
   }

   public boolean openPane() {
      return this.openPane(this.mSlideableView, 0);
   }

   public void requestChildFocus(View var1, View var2) {
      super.requestChildFocus(var1, var2);
      if(!this.isInTouchMode() && !this.mCanSlide) {
         boolean var3;
         if(var1 == this.mSlideableView) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.mPreservedOpenState = var3;
      }

   }

   void setAllChildrenVisible() {
      int var1 = 0;

      for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         if(var3.getVisibility() == 4) {
            var3.setVisibility(0);
         }
      }

   }

   public void setCoveredFadeColor(@ColorInt int var1) {
      this.mCoveredFadeColor = var1;
   }

   public void setPanelSlideListener(SlidingPaneLayout$PanelSlideListener var1) {
      this.mPanelSlideListener = var1;
   }

   public void setParallaxDistance(int var1) {
      this.mParallaxBy = var1;
      this.requestLayout();
   }

   @Deprecated
   public void setShadowDrawable(Drawable var1) {
      this.setShadowDrawableLeft(var1);
   }

   public void setShadowDrawableLeft(Drawable var1) {
      this.mShadowDrawableLeft = var1;
   }

   public void setShadowDrawableRight(Drawable var1) {
      this.mShadowDrawableRight = var1;
   }

   @Deprecated
   public void setShadowResource(@DrawableRes int var1) {
      this.setShadowDrawable(this.getResources().getDrawable(var1));
   }

   public void setShadowResourceLeft(int var1) {
      this.setShadowDrawableLeft(this.getResources().getDrawable(var1));
   }

   public void setShadowResourceRight(int var1) {
      this.setShadowDrawableRight(this.getResources().getDrawable(var1));
   }

   public void setSliderFadeColor(@ColorInt int var1) {
      this.mSliderFadeColor = var1;
   }

   @Deprecated
   public void smoothSlideClosed() {
      this.closePane();
   }

   @Deprecated
   public void smoothSlideOpen() {
      this.openPane();
   }

   boolean smoothSlideTo(float var1, int var2) {
      if(this.mCanSlide) {
         boolean var5 = this.isLayoutRtlSupport();
         SlidingPaneLayout$LayoutParams var6 = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
         if(var5) {
            var2 = this.getPaddingRight();
            int var3 = var6.rightMargin;
            int var4 = this.mSlideableView.getWidth();
            var2 = (int)((float)this.getWidth() - ((float)(var2 + var3) + (float)this.mSlideRange * var1 + (float)var4));
         } else {
            var2 = (int)((float)(this.getPaddingLeft() + var6.leftMargin) + (float)this.mSlideRange * var1);
         }

         if(this.mDragHelper.smoothSlideViewTo(this.mSlideableView, var2, this.mSlideableView.getTop())) {
            this.setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
         }
      }

      return false;
   }

   void updateObscuredViewsVisibility(View var1) {
      boolean var17 = this.isLayoutRtlSupport();
      int var2;
      if(var17) {
         var2 = this.getWidth() - this.getPaddingRight();
      } else {
         var2 = this.getPaddingLeft();
      }

      int var3;
      if(var17) {
         var3 = this.getPaddingLeft();
      } else {
         var3 = this.getWidth() - this.getPaddingRight();
      }

      int var10 = this.getPaddingTop();
      int var11 = this.getHeight();
      int var12 = this.getPaddingBottom();
      int var4;
      int var5;
      int var6;
      int var7;
      if(var1 != null && viewIsOpaque(var1)) {
         var5 = var1.getLeft();
         var6 = var1.getRight();
         var7 = var1.getTop();
         var4 = var1.getBottom();
      } else {
         var4 = 0;
         var7 = 0;
         var6 = 0;
         var5 = 0;
      }

      int var8 = 0;

      for(int var13 = this.getChildCount(); var8 < var13; ++var8) {
         View var18 = this.getChildAt(var8);
         if(var18 == var1) {
            break;
         }

         int var9;
         if(var17) {
            var9 = var3;
         } else {
            var9 = var2;
         }

         int var14 = Math.max(var9, var18.getLeft());
         int var15 = Math.max(var10, var18.getTop());
         if(var17) {
            var9 = var2;
         } else {
            var9 = var3;
         }

         var9 = Math.min(var9, var18.getRight());
         int var16 = Math.min(var11 - var12, var18.getBottom());
         byte var19;
         if(var14 >= var5 && var15 >= var7 && var9 <= var6 && var16 <= var4) {
            var19 = 4;
         } else {
            var19 = 0;
         }

         var18.setVisibility(var19);
      }

   }
}
