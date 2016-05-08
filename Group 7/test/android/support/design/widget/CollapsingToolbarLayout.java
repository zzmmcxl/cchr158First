package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.R$id;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$OnOffsetChangedListener;
import android.support.design.widget.CollapsingTextHelper;
import android.support.design.widget.CollapsingToolbarLayout$1;
import android.support.design.widget.CollapsingToolbarLayout$2;
import android.support.design.widget.CollapsingToolbarLayout$LayoutParams;
import android.support.design.widget.CollapsingToolbarLayout$OffsetUpdateListener;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewGroupUtils;
import android.support.design.widget.ViewOffsetHelper;
import android.support.design.widget.ViewUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
   private static final int SCRIM_ANIMATION_DURATION = 600;
   private final CollapsingTextHelper mCollapsingTextHelper;
   private boolean mCollapsingTitleEnabled;
   private Drawable mContentScrim;
   private int mCurrentOffset;
   private boolean mDrawCollapsingTitle;
   private View mDummyView;
   private int mExpandedMarginBottom;
   private int mExpandedMarginEnd;
   private int mExpandedMarginStart;
   private int mExpandedMarginTop;
   private WindowInsetsCompat mLastInsets;
   private AppBarLayout$OnOffsetChangedListener mOnOffsetChangedListener;
   private boolean mRefreshToolbar;
   private int mScrimAlpha;
   private ValueAnimatorCompat mScrimAnimator;
   private boolean mScrimsAreShown;
   private Drawable mStatusBarScrim;
   private final Rect mTmpRect;
   private Toolbar mToolbar;
   private View mToolbarDirectChild;
   private int mToolbarId;

   public CollapsingToolbarLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CollapsingToolbarLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CollapsingToolbarLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mRefreshToolbar = true;
      this.mTmpRect = new Rect();
      ThemeUtils.checkAppCompatTheme(var1);
      this.mCollapsingTextHelper = new CollapsingTextHelper(this);
      this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R$styleable.CollapsingToolbarLayout, var3, R$style.Widget_Design_CollapsingToolbar);
      this.mCollapsingTextHelper.setExpandedTextGravity(var4.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
      this.mCollapsingTextHelper.setCollapsedTextGravity(var4.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
      var3 = var4.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
      this.mExpandedMarginBottom = var3;
      this.mExpandedMarginEnd = var3;
      this.mExpandedMarginTop = var3;
      this.mExpandedMarginStart = var3;
      if(var4.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
         this.mExpandedMarginStart = var4.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
      }

      if(var4.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
         this.mExpandedMarginEnd = var4.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
      }

      if(var4.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
         this.mExpandedMarginTop = var4.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
      }

      if(var4.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
         this.mExpandedMarginBottom = var4.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
      }

      this.mCollapsingTitleEnabled = var4.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
      this.setTitle(var4.getText(R$styleable.CollapsingToolbarLayout_title));
      this.mCollapsingTextHelper.setExpandedTextAppearance(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
      this.mCollapsingTextHelper.setCollapsedTextAppearance(R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
      if(var4.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
         this.mCollapsingTextHelper.setExpandedTextAppearance(var4.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
      }

      if(var4.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
         this.mCollapsingTextHelper.setCollapsedTextAppearance(var4.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
      }

      this.setContentScrim(var4.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
      this.setStatusBarScrim(var4.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
      this.mToolbarId = var4.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
      var4.recycle();
      this.setWillNotDraw(false);
      ViewCompat.setOnApplyWindowInsetsListener(this, new CollapsingToolbarLayout$1(this));
   }

   private void animateScrim(int var1) {
      this.ensureToolbar();
      if(this.mScrimAnimator == null) {
         this.mScrimAnimator = ViewUtils.createAnimator();
         this.mScrimAnimator.setDuration(600);
         ValueAnimatorCompat var3 = this.mScrimAnimator;
         Interpolator var2;
         if(var1 > this.mScrimAlpha) {
            var2 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
         } else {
            var2 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
         }

         var3.setInterpolator(var2);
         this.mScrimAnimator.setUpdateListener(new CollapsingToolbarLayout$2(this));
      } else if(this.mScrimAnimator.isRunning()) {
         this.mScrimAnimator.cancel();
      }

      this.mScrimAnimator.setIntValues(this.mScrimAlpha, var1);
      this.mScrimAnimator.start();
   }

   private void ensureToolbar() {
      if(this.mRefreshToolbar) {
         this.mToolbar = null;
         this.mToolbarDirectChild = null;
         if(this.mToolbarId != -1) {
            this.mToolbar = (Toolbar)this.findViewById(this.mToolbarId);
            if(this.mToolbar != null) {
               this.mToolbarDirectChild = this.findDirectChild(this.mToolbar);
            }
         }

         if(this.mToolbar == null) {
            Object var4 = null;
            int var1 = 0;
            int var2 = this.getChildCount();

            Toolbar var3;
            while(true) {
               var3 = (Toolbar)var4;
               if(var1 >= var2) {
                  break;
               }

               View var5 = this.getChildAt(var1);
               if(var5 instanceof Toolbar) {
                  var3 = (Toolbar)var5;
                  break;
               }

               ++var1;
            }

            this.mToolbar = var3;
         }

         this.updateDummyView();
         this.mRefreshToolbar = false;
      }
   }

   private View findDirectChild(View var1) {
      View var2 = var1;

      for(ViewParent var3 = var1.getParent(); var3 != this && var3 != null; var3 = var3.getParent()) {
         if(var3 instanceof View) {
            var2 = (View)var3;
         }
      }

      return var2;
   }

   private static int getHeightWithMargins(@NonNull View var0) {
      LayoutParams var1 = var0.getLayoutParams();
      if(var1 instanceof MarginLayoutParams) {
         MarginLayoutParams var2 = (MarginLayoutParams)var1;
         return var0.getHeight() + var2.topMargin + var2.bottomMargin;
      } else {
         return var0.getHeight();
      }
   }

   private static ViewOffsetHelper getViewOffsetHelper(View var0) {
      ViewOffsetHelper var2 = (ViewOffsetHelper)var0.getTag(R$id.view_offset_helper);
      ViewOffsetHelper var1 = var2;
      if(var2 == null) {
         var1 = new ViewOffsetHelper(var0);
         var0.setTag(R$id.view_offset_helper, var1);
      }

      return var1;
   }

   private void setScrimAlpha(int var1) {
      if(var1 != this.mScrimAlpha) {
         if(this.mContentScrim != null && this.mToolbar != null) {
            ViewCompat.postInvalidateOnAnimation(this.mToolbar);
         }

         this.mScrimAlpha = var1;
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private WindowInsetsCompat setWindowInsets(WindowInsetsCompat var1) {
      if(this.mLastInsets != var1) {
         this.mLastInsets = var1;
         this.requestLayout();
      }

      return var1.consumeSystemWindowInsets();
   }

   private void updateDummyView() {
      if(!this.mCollapsingTitleEnabled && this.mDummyView != null) {
         ViewParent var1 = this.mDummyView.getParent();
         if(var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.mDummyView);
         }
      }

      if(this.mCollapsingTitleEnabled && this.mToolbar != null) {
         if(this.mDummyView == null) {
            this.mDummyView = new View(this.getContext());
         }

         if(this.mDummyView.getParent() == null) {
            this.mToolbar.addView(this.mDummyView, -1, -1);
         }
      }

   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof CollapsingToolbarLayout$LayoutParams;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      this.ensureToolbar();
      if(this.mToolbar == null && this.mContentScrim != null && this.mScrimAlpha > 0) {
         this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
         this.mContentScrim.draw(var1);
      }

      if(this.mCollapsingTitleEnabled && this.mDrawCollapsingTitle) {
         this.mCollapsingTextHelper.draw(var1);
      }

      if(this.mStatusBarScrim != null && this.mScrimAlpha > 0) {
         int var2;
         if(this.mLastInsets != null) {
            var2 = this.mLastInsets.getSystemWindowInsetTop();
         } else {
            var2 = 0;
         }

         if(var2 > 0) {
            this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, this.getWidth(), var2 - this.mCurrentOffset);
            this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mStatusBarScrim.draw(var1);
         }
      }

   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      this.ensureToolbar();
      if(var2 == this.mToolbar && this.mContentScrim != null && this.mScrimAlpha > 0) {
         this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
         this.mContentScrim.draw(var1);
      }

      return super.drawChild(var1, var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var3 = this.getDrawableState();
      boolean var2 = false;
      Drawable var4 = this.mStatusBarScrim;
      boolean var1 = var2;
      if(var4 != null) {
         var1 = var2;
         if(var4.isStateful()) {
            var1 = false | var4.setState(var3);
         }
      }

      var4 = this.mContentScrim;
      var2 = var1;
      if(var4 != null) {
         var2 = var1;
         if(var4.isStateful()) {
            var2 = var1 | var4.setState(var3);
         }
      }

      if(var2) {
         this.invalidate();
      }

   }

   protected CollapsingToolbarLayout$LayoutParams generateDefaultLayoutParams() {
      return new CollapsingToolbarLayout$LayoutParams(super.generateDefaultLayoutParams());
   }

   public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new CollapsingToolbarLayout$LayoutParams(this.getContext(), var1);
   }

   protected android.widget.FrameLayout.LayoutParams generateLayoutParams(LayoutParams var1) {
      return new CollapsingToolbarLayout$LayoutParams(var1);
   }

   public int getCollapsedTitleGravity() {
      return this.mCollapsingTextHelper.getCollapsedTextGravity();
   }

   @NonNull
   public Typeface getCollapsedTitleTypeface() {
      return this.mCollapsingTextHelper.getCollapsedTypeface();
   }

   @Nullable
   public Drawable getContentScrim() {
      return this.mContentScrim;
   }

   public int getExpandedTitleGravity() {
      return this.mCollapsingTextHelper.getExpandedTextGravity();
   }

   public int getExpandedTitleMarginBottom() {
      return this.mExpandedMarginBottom;
   }

   public int getExpandedTitleMarginEnd() {
      return this.mExpandedMarginEnd;
   }

   public int getExpandedTitleMarginStart() {
      return this.mExpandedMarginStart;
   }

   public int getExpandedTitleMarginTop() {
      return this.mExpandedMarginTop;
   }

   @NonNull
   public Typeface getExpandedTitleTypeface() {
      return this.mCollapsingTextHelper.getExpandedTypeface();
   }

   final int getScrimTriggerOffset() {
      return ViewCompat.getMinimumHeight(this) * 2;
   }

   @Nullable
   public Drawable getStatusBarScrim() {
      return this.mStatusBarScrim;
   }

   @Nullable
   public CharSequence getTitle() {
      return this.mCollapsingTitleEnabled?this.mCollapsingTextHelper.getText():null;
   }

   public boolean isTitleEnabled() {
      return this.mCollapsingTitleEnabled;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ViewParent var1 = this.getParent();
      if(var1 instanceof AppBarLayout) {
         if(this.mOnOffsetChangedListener == null) {
            this.mOnOffsetChangedListener = new CollapsingToolbarLayout$OffsetUpdateListener(this, (CollapsingToolbarLayout$1)null);
         }

         ((AppBarLayout)var1).addOnOffsetChangedListener(this.mOnOffsetChangedListener);
      }

      ViewCompat.requestApplyInsets(this);
   }

   protected void onDetachedFromWindow() {
      ViewParent var1 = this.getParent();
      if(this.mOnOffsetChangedListener != null && var1 instanceof AppBarLayout) {
         ((AppBarLayout)var1).removeOnOffsetChangedListener(this.mOnOffsetChangedListener);
      }

      super.onDetachedFromWindow();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if(this.mCollapsingTitleEnabled && this.mDummyView != null) {
         if(ViewCompat.isAttachedToWindow(this.mDummyView) && this.mDummyView.getVisibility() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.mDrawCollapsingTitle = var1;
         if(this.mDrawCollapsingTitle) {
            byte var7 = 0;
            int var6 = var7;
            if(this.mToolbarDirectChild != null) {
               var6 = var7;
               if(this.mToolbarDirectChild != this) {
                  var6 = ((CollapsingToolbarLayout$LayoutParams)this.mToolbarDirectChild.getLayoutParams()).bottomMargin;
               }
            }

            ViewGroupUtils.getDescendantRect(this, this.mDummyView, this.mTmpRect);
            this.mCollapsingTextHelper.setCollapsedBounds(this.mTmpRect.left, var5 - this.mTmpRect.height() - var6, this.mTmpRect.right, var5 - var6);
            boolean var11;
            if(ViewCompat.getLayoutDirection(this) == 1) {
               var11 = true;
            } else {
               var11 = false;
            }

            CollapsingTextHelper var10 = this.mCollapsingTextHelper;
            if(var11) {
               var6 = this.mExpandedMarginEnd;
            } else {
               var6 = this.mExpandedMarginStart;
            }

            int var8 = this.mTmpRect.bottom;
            int var9 = this.mExpandedMarginTop;
            int var12;
            if(var11) {
               var12 = this.mExpandedMarginStart;
            } else {
               var12 = this.mExpandedMarginEnd;
            }

            var10.setExpandedBounds(var6, var9 + var8, var4 - var2 - var12, var5 - var3 - this.mExpandedMarginBottom);
            this.mCollapsingTextHelper.recalculate();
         }
      }

      var2 = 0;

      for(var3 = this.getChildCount(); var2 < var3; ++var2) {
         View var13 = this.getChildAt(var2);
         if(this.mLastInsets != null && !ViewCompat.getFitsSystemWindows(var13)) {
            var4 = this.mLastInsets.getSystemWindowInsetTop();
            if(var13.getTop() < var4) {
               ViewCompat.offsetTopAndBottom(var13, var4);
            }
         }

         getViewOffsetHelper(var13).onViewLayout();
      }

      if(this.mToolbar != null) {
         if(this.mCollapsingTitleEnabled && TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
            this.mCollapsingTextHelper.setText(this.mToolbar.getTitle());
         }

         if(this.mToolbarDirectChild != null && this.mToolbarDirectChild != this) {
            this.setMinimumHeight(getHeightWithMargins(this.mToolbarDirectChild));
            return;
         }

         this.setMinimumHeight(getHeightWithMargins(this.mToolbar));
      }

   }

   protected void onMeasure(int var1, int var2) {
      this.ensureToolbar();
      super.onMeasure(var1, var2);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(this.mContentScrim != null) {
         this.mContentScrim.setBounds(0, 0, var1, var2);
      }

   }

   public void setCollapsedTitleGravity(int var1) {
      this.mCollapsingTextHelper.setCollapsedTextGravity(var1);
   }

   public void setCollapsedTitleTextAppearance(@StyleRes int var1) {
      this.mCollapsingTextHelper.setCollapsedTextAppearance(var1);
   }

   public void setCollapsedTitleTextColor(@ColorInt int var1) {
      this.mCollapsingTextHelper.setCollapsedTextColor(var1);
   }

   public void setCollapsedTitleTypeface(@Nullable Typeface var1) {
      this.mCollapsingTextHelper.setCollapsedTypeface(var1);
   }

   public void setContentScrim(@Nullable Drawable var1) {
      Drawable var2 = null;
      if(this.mContentScrim != var1) {
         if(this.mContentScrim != null) {
            this.mContentScrim.setCallback((Callback)null);
         }

         if(var1 != null) {
            var2 = var1.mutate();
         }

         this.mContentScrim = var2;
         if(this.mContentScrim != null) {
            this.mContentScrim.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.mContentScrim.setCallback(this);
            this.mContentScrim.setAlpha(this.mScrimAlpha);
         }

         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void setContentScrimColor(@ColorInt int var1) {
      this.setContentScrim(new ColorDrawable(var1));
   }

   public void setContentScrimResource(@DrawableRes int var1) {
      this.setContentScrim(ContextCompat.getDrawable(this.getContext(), var1));
   }

   public void setExpandedTitleColor(@ColorInt int var1) {
      this.mCollapsingTextHelper.setExpandedTextColor(var1);
   }

   public void setExpandedTitleGravity(int var1) {
      this.mCollapsingTextHelper.setExpandedTextGravity(var1);
   }

   public void setExpandedTitleMargin(int var1, int var2, int var3, int var4) {
      this.mExpandedMarginStart = var1;
      this.mExpandedMarginTop = var2;
      this.mExpandedMarginEnd = var3;
      this.mExpandedMarginBottom = var4;
      this.requestLayout();
   }

   public void setExpandedTitleMarginBottom(int var1) {
      this.mExpandedMarginBottom = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginEnd(int var1) {
      this.mExpandedMarginEnd = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginStart(int var1) {
      this.mExpandedMarginStart = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginTop(int var1) {
      this.mExpandedMarginTop = var1;
      this.requestLayout();
   }

   public void setExpandedTitleTextAppearance(@StyleRes int var1) {
      this.mCollapsingTextHelper.setExpandedTextAppearance(var1);
   }

   public void setExpandedTitleTypeface(@Nullable Typeface var1) {
      this.mCollapsingTextHelper.setExpandedTypeface(var1);
   }

   public void setScrimsShown(boolean var1) {
      boolean var2;
      if(ViewCompat.isLaidOut(this) && !this.isInEditMode()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setScrimsShown(var1, var2);
   }

   public void setScrimsShown(boolean var1, boolean var2) {
      short var3 = 255;
      if(this.mScrimsAreShown != var1) {
         if(var2) {
            if(!var1) {
               var3 = 0;
            }

            this.animateScrim(var3);
         } else {
            if(!var1) {
               var3 = 0;
            }

            this.setScrimAlpha(var3);
         }

         this.mScrimsAreShown = var1;
      }

   }

   public void setStatusBarScrim(@Nullable Drawable var1) {
      Drawable var3 = null;
      if(this.mStatusBarScrim != var1) {
         if(this.mStatusBarScrim != null) {
            this.mStatusBarScrim.setCallback((Callback)null);
         }

         if(var1 != null) {
            var3 = var1.mutate();
         }

         this.mStatusBarScrim = var3;
         if(this.mStatusBarScrim != null) {
            if(this.mStatusBarScrim.isStateful()) {
               this.mStatusBarScrim.setState(this.getDrawableState());
            }

            DrawableCompat.setLayoutDirection(this.mStatusBarScrim, ViewCompat.getLayoutDirection(this));
            var1 = this.mStatusBarScrim;
            boolean var2;
            if(this.getVisibility() == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            var1.setVisible(var2, false);
            this.mStatusBarScrim.setCallback(this);
            this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
         }

         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void setStatusBarScrimColor(@ColorInt int var1) {
      this.setStatusBarScrim(new ColorDrawable(var1));
   }

   public void setStatusBarScrimResource(@DrawableRes int var1) {
      this.setStatusBarScrim(ContextCompat.getDrawable(this.getContext(), var1));
   }

   public void setTitle(@Nullable CharSequence var1) {
      this.mCollapsingTextHelper.setText(var1);
   }

   public void setTitleEnabled(boolean var1) {
      if(var1 != this.mCollapsingTitleEnabled) {
         this.mCollapsingTitleEnabled = var1;
         this.updateDummyView();
         this.requestLayout();
      }

   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(this.mStatusBarScrim != null && this.mStatusBarScrim.isVisible() != var2) {
         this.mStatusBarScrim.setVisible(var2, false);
      }

      if(this.mContentScrim != null && this.mContentScrim.isVisible() != var2) {
         this.mContentScrim.setVisible(var2, false);
      }

   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mContentScrim || var1 == this.mStatusBarScrim;
   }
}
