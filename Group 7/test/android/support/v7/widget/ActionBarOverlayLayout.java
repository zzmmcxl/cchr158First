package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$id;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarOverlayLayout$1;
import android.support.v7.widget.ActionBarOverlayLayout$2;
import android.support.v7.widget.ActionBarOverlayLayout$3;
import android.support.v7.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback;
import android.support.v7.widget.ActionBarOverlayLayout$LayoutParams;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent {
   static final int[] ATTRS;
   private static final String TAG = "ActionBarOverlayLayout";
   private final int ACTION_BAR_ANIMATE_DELAY;
   private int mActionBarHeight;
   private ActionBarContainer mActionBarTop;
   private ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback;
   private final Runnable mAddActionBarHideOffset;
   private boolean mAnimatingForFling;
   private final Rect mBaseContentInsets;
   private final Rect mBaseInnerInsets;
   private ContentFrameLayout mContent;
   private final Rect mContentInsets;
   private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
   private DecorToolbar mDecorToolbar;
   private ScrollerCompat mFlingEstimator;
   private boolean mHasNonEmbeddedTabs;
   private boolean mHideOnContentScroll;
   private int mHideOnContentScrollReference;
   private boolean mIgnoreWindowContentOverlay;
   private final Rect mInnerInsets;
   private final Rect mLastBaseContentInsets;
   private final Rect mLastInnerInsets;
   private int mLastSystemUiVisibility;
   private boolean mOverlayMode;
   private final NestedScrollingParentHelper mParentHelper;
   private final Runnable mRemoveActionBarHideOffset;
   private final ViewPropertyAnimatorListener mTopAnimatorListener;
   private Drawable mWindowContentOverlay;
   private int mWindowVisibility;

   static {
      ATTRS = new int[]{R$attr.actionBarSize, 16842841};
   }

   public ActionBarOverlayLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionBarOverlayLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mWindowVisibility = 0;
      this.mBaseContentInsets = new Rect();
      this.mLastBaseContentInsets = new Rect();
      this.mContentInsets = new Rect();
      this.mBaseInnerInsets = new Rect();
      this.mInnerInsets = new Rect();
      this.mLastInnerInsets = new Rect();
      this.ACTION_BAR_ANIMATE_DELAY = 600;
      this.mTopAnimatorListener = new ActionBarOverlayLayout$1(this);
      this.mRemoveActionBarHideOffset = new ActionBarOverlayLayout$2(this);
      this.mAddActionBarHideOffset = new ActionBarOverlayLayout$3(this);
      this.init(var1);
      this.mParentHelper = new NestedScrollingParentHelper(this);
   }

   private void addActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.mAddActionBarHideOffset.run();
   }

   private boolean applyInsets(View var1, Rect var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      boolean var8 = false;
      ActionBarOverlayLayout$LayoutParams var9 = (ActionBarOverlayLayout$LayoutParams)var1.getLayoutParams();
      boolean var7 = var8;
      if(var3) {
         var7 = var8;
         if(var9.leftMargin != var2.left) {
            var7 = true;
            var9.leftMargin = var2.left;
         }
      }

      var3 = var7;
      if(var4) {
         var3 = var7;
         if(var9.topMargin != var2.top) {
            var3 = true;
            var9.topMargin = var2.top;
         }
      }

      var4 = var3;
      if(var6) {
         var4 = var3;
         if(var9.rightMargin != var2.right) {
            var4 = true;
            var9.rightMargin = var2.right;
         }
      }

      var3 = var4;
      if(var5) {
         var3 = var4;
         if(var9.bottomMargin != var2.bottom) {
            var3 = true;
            var9.bottomMargin = var2.bottom;
         }
      }

      return var3;
   }

   private DecorToolbar getDecorToolbar(View var1) {
      if(var1 instanceof DecorToolbar) {
         return (DecorToolbar)var1;
      } else if(var1 instanceof Toolbar) {
         return ((Toolbar)var1).getWrapper();
      } else {
         throw new IllegalStateException("Can\'t make a decor toolbar out of " + var1.getClass().getSimpleName());
      }
   }

   private void haltActionBarHideOffsetAnimations() {
      this.removeCallbacks(this.mRemoveActionBarHideOffset);
      this.removeCallbacks(this.mAddActionBarHideOffset);
      if(this.mCurrentActionBarTopAnimator != null) {
         this.mCurrentActionBarTopAnimator.cancel();
      }

   }

   private void init(Context var1) {
      boolean var3 = true;
      TypedArray var4 = this.getContext().getTheme().obtainStyledAttributes(ATTRS);
      this.mActionBarHeight = var4.getDimensionPixelSize(0, 0);
      this.mWindowContentOverlay = var4.getDrawable(1);
      boolean var2;
      if(this.mWindowContentOverlay == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      var4.recycle();
      if(var1.getApplicationInfo().targetSdkVersion < 19) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.mIgnoreWindowContentOverlay = var2;
      this.mFlingEstimator = ScrollerCompat.create(var1);
   }

   private void postAddActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.postDelayed(this.mAddActionBarHideOffset, 600L);
   }

   private void postRemoveActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.postDelayed(this.mRemoveActionBarHideOffset, 600L);
   }

   private void removeActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.mRemoveActionBarHideOffset.run();
   }

   private boolean shouldHideActionBarOnFling(float var1, float var2) {
      boolean var3 = false;
      this.mFlingEstimator.fling(0, 0, 0, (int)var2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
      if(this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
         var3 = true;
      }

      return var3;
   }

   public boolean canShowOverflowMenu() {
      this.pullChildren();
      return this.mDecorToolbar.canShowOverflowMenu();
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof ActionBarOverlayLayout$LayoutParams;
   }

   public void dismissPopups() {
      this.pullChildren();
      this.mDecorToolbar.dismissPopupMenus();
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if(this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
         int var2;
         if(this.mActionBarTop.getVisibility() == 0) {
            var2 = (int)((float)this.mActionBarTop.getBottom() + ViewCompat.getTranslationY(this.mActionBarTop) + 0.5F);
         } else {
            var2 = 0;
         }

         this.mWindowContentOverlay.setBounds(0, var2, this.getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + var2);
         this.mWindowContentOverlay.draw(var1);
      }

   }

   protected boolean fitSystemWindows(Rect var1) {
      this.pullChildren();
      if((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
         ;
      }

      boolean var2 = this.applyInsets(this.mActionBarTop, var1, true, true, false, true);
      this.mBaseInnerInsets.set(var1);
      ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsets, this.mBaseContentInsets);
      if(!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
         var2 = true;
         this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      }

      if(var2) {
         this.requestLayout();
      }

      return true;
   }

   protected ActionBarOverlayLayout$LayoutParams generateDefaultLayoutParams() {
      return new ActionBarOverlayLayout$LayoutParams(-1, -1);
   }

   public ActionBarOverlayLayout$LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ActionBarOverlayLayout$LayoutParams(this.getContext(), var1);
   }

   protected LayoutParams generateLayoutParams(LayoutParams var1) {
      return new ActionBarOverlayLayout$LayoutParams(var1);
   }

   public int getActionBarHideOffset() {
      return this.mActionBarTop != null?-((int)ViewCompat.getTranslationY(this.mActionBarTop)):0;
   }

   public int getNestedScrollAxes() {
      return this.mParentHelper.getNestedScrollAxes();
   }

   public CharSequence getTitle() {
      this.pullChildren();
      return this.mDecorToolbar.getTitle();
   }

   public boolean hasIcon() {
      this.pullChildren();
      return this.mDecorToolbar.hasIcon();
   }

   public boolean hasLogo() {
      this.pullChildren();
      return this.mDecorToolbar.hasLogo();
   }

   public boolean hideOverflowMenu() {
      this.pullChildren();
      return this.mDecorToolbar.hideOverflowMenu();
   }

   public void initFeature(int var1) {
      this.pullChildren();
      switch(var1) {
      case 2:
         this.mDecorToolbar.initProgress();
         return;
      case 5:
         this.mDecorToolbar.initIndeterminateProgress();
         return;
      case 109:
         this.setOverlayMode(true);
         return;
      default:
      }
   }

   public boolean isHideOnContentScrollEnabled() {
      return this.mHideOnContentScroll;
   }

   public boolean isInOverlayMode() {
      return this.mOverlayMode;
   }

   public boolean isOverflowMenuShowPending() {
      this.pullChildren();
      return this.mDecorToolbar.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      this.pullChildren();
      return this.mDecorToolbar.isOverflowMenuShowing();
   }

   protected void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      this.init(this.getContext());
      ViewCompat.requestApplyInsets(this);
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.haltActionBarHideOffsetAnimations();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var3 = this.getChildCount();
      var4 = this.getPaddingLeft();
      this.getPaddingRight();
      var5 = this.getPaddingTop();
      this.getPaddingBottom();

      for(var2 = 0; var2 < var3; ++var2) {
         View var10 = this.getChildAt(var2);
         if(var10.getVisibility() != 8) {
            ActionBarOverlayLayout$LayoutParams var11 = (ActionBarOverlayLayout$LayoutParams)var10.getLayoutParams();
            int var6 = var10.getMeasuredWidth();
            int var7 = var10.getMeasuredHeight();
            int var8 = var4 + var11.leftMargin;
            int var9 = var5 + var11.topMargin;
            var10.layout(var8, var9, var8 + var6, var9 + var7);
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      this.pullChildren();
      int var3 = 0;
      this.measureChildWithMargins(this.mActionBarTop, var1, 0, var2, 0);
      ActionBarOverlayLayout$LayoutParams var9 = (ActionBarOverlayLayout$LayoutParams)this.mActionBarTop.getLayoutParams();
      int var8 = Math.max(0, this.mActionBarTop.getMeasuredWidth() + var9.leftMargin + var9.rightMargin);
      int var7 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + var9.topMargin + var9.bottomMargin);
      int var6 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mActionBarTop));
      boolean var4;
      if((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      int var5;
      if(var4) {
         var5 = this.mActionBarHeight;
         var3 = var5;
         if(this.mHasNonEmbeddedTabs) {
            var3 = var5;
            if(this.mActionBarTop.getTabContainer() != null) {
               var3 = var5 + this.mActionBarHeight;
            }
         }
      } else if(this.mActionBarTop.getVisibility() != 8) {
         var3 = this.mActionBarTop.getMeasuredHeight();
      }

      this.mContentInsets.set(this.mBaseContentInsets);
      this.mInnerInsets.set(this.mBaseInnerInsets);
      Rect var11;
      if(!this.mOverlayMode && !var4) {
         var11 = this.mContentInsets;
         var11.top += var3;
         var11 = this.mContentInsets;
         var11.bottom += 0;
      } else {
         var11 = this.mInnerInsets;
         var11.top += var3;
         var11 = this.mInnerInsets;
         var11.bottom += 0;
      }

      this.applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
      if(!this.mLastInnerInsets.equals(this.mInnerInsets)) {
         this.mLastInnerInsets.set(this.mInnerInsets);
         this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
      }

      this.measureChildWithMargins(this.mContent, var1, 0, var2, 0);
      var9 = (ActionBarOverlayLayout$LayoutParams)this.mContent.getLayoutParams();
      var3 = Math.max(var8, this.mContent.getMeasuredWidth() + var9.leftMargin + var9.rightMargin);
      int var10 = Math.max(var7, this.mContent.getMeasuredHeight() + var9.topMargin + var9.bottomMargin);
      var5 = ViewUtils.combineMeasuredStates(var6, ViewCompat.getMeasuredState(this.mContent));
      var6 = this.getPaddingLeft();
      var7 = this.getPaddingRight();
      var10 = Math.max(var10 + this.getPaddingTop() + this.getPaddingBottom(), this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(var3 + var6 + var7, this.getSuggestedMinimumWidth()), var1, var5), ViewCompat.resolveSizeAndState(var10, var2, var5 << 16));
   }

   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      if(this.mHideOnContentScroll && var4) {
         if(this.shouldHideActionBarOnFling(var2, var3)) {
            this.addActionBarHideOffset();
         } else {
            this.removeActionBarHideOffset();
         }

         this.mAnimatingForFling = true;
         return true;
      } else {
         return false;
      }
   }

   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return false;
   }

   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
   }

   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      this.mHideOnContentScrollReference += var3;
      this.setActionBarHideOffset(this.mHideOnContentScrollReference);
   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mParentHelper.onNestedScrollAccepted(var1, var2, var3);
      this.mHideOnContentScrollReference = this.getActionBarHideOffset();
      this.haltActionBarHideOffsetAnimations();
      if(this.mActionBarVisibilityCallback != null) {
         this.mActionBarVisibilityCallback.onContentScrollStarted();
      }

   }

   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      return (var3 & 2) != 0 && this.mActionBarTop.getVisibility() == 0?this.mHideOnContentScroll:false;
   }

   public void onStopNestedScroll(View var1) {
      if(this.mHideOnContentScroll && !this.mAnimatingForFling) {
         if(this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
            this.postRemoveActionBarHideOffset();
         } else {
            this.postAddActionBarHideOffset();
         }
      }

      if(this.mActionBarVisibilityCallback != null) {
         this.mActionBarVisibilityCallback.onContentScrollStopped();
      }

   }

   public void onWindowSystemUiVisibilityChanged(int var1) {
      boolean var5 = true;
      if(VERSION.SDK_INT >= 16) {
         super.onWindowSystemUiVisibilityChanged(var1);
      }

      this.pullChildren();
      int var4 = this.mLastSystemUiVisibility;
      this.mLastSystemUiVisibility = var1;
      boolean var2;
      if((var1 & 4) == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if((var1 & 256) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(this.mActionBarVisibilityCallback != null) {
         ActionBarOverlayLayout$ActionBarVisibilityCallback var6 = this.mActionBarVisibilityCallback;
         if(var3) {
            var5 = false;
         }

         var6.enableContentAnimations(var5);
         if(!var2 && var3) {
            this.mActionBarVisibilityCallback.hideForSystem();
         } else {
            this.mActionBarVisibilityCallback.showForSystem();
         }
      }

      if(((var4 ^ var1) & 256) != 0 && this.mActionBarVisibilityCallback != null) {
         ViewCompat.requestApplyInsets(this);
      }

   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      this.mWindowVisibility = var1;
      if(this.mActionBarVisibilityCallback != null) {
         this.mActionBarVisibilityCallback.onWindowVisibilityChanged(var1);
      }

   }

   void pullChildren() {
      if(this.mContent == null) {
         this.mContent = (ContentFrameLayout)this.findViewById(R$id.action_bar_activity_content);
         this.mActionBarTop = (ActionBarContainer)this.findViewById(R$id.action_bar_container);
         this.mDecorToolbar = this.getDecorToolbar(this.findViewById(R$id.action_bar));
      }

   }

   public void restoreToolbarHierarchyState(SparseArray<Parcelable> var1) {
      this.pullChildren();
      this.mDecorToolbar.restoreHierarchyState(var1);
   }

   public void saveToolbarHierarchyState(SparseArray<Parcelable> var1) {
      this.pullChildren();
      this.mDecorToolbar.saveHierarchyState(var1);
   }

   public void setActionBarHideOffset(int var1) {
      this.haltActionBarHideOffsetAnimations();
      var1 = Math.max(0, Math.min(var1, this.mActionBarTop.getHeight()));
      ViewCompat.setTranslationY(this.mActionBarTop, (float)(-var1));
   }

   public void setActionBarVisibilityCallback(ActionBarOverlayLayout$ActionBarVisibilityCallback var1) {
      this.mActionBarVisibilityCallback = var1;
      if(this.getWindowToken() != null) {
         this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
         if(this.mLastSystemUiVisibility != 0) {
            this.onWindowSystemUiVisibilityChanged(this.mLastSystemUiVisibility);
            ViewCompat.requestApplyInsets(this);
         }
      }

   }

   public void setHasNonEmbeddedTabs(boolean var1) {
      this.mHasNonEmbeddedTabs = var1;
   }

   public void setHideOnContentScrollEnabled(boolean var1) {
      if(var1 != this.mHideOnContentScroll) {
         this.mHideOnContentScroll = var1;
         if(!var1) {
            this.haltActionBarHideOffsetAnimations();
            this.setActionBarHideOffset(0);
         }
      }

   }

   public void setIcon(int var1) {
      this.pullChildren();
      this.mDecorToolbar.setIcon(var1);
   }

   public void setIcon(Drawable var1) {
      this.pullChildren();
      this.mDecorToolbar.setIcon(var1);
   }

   public void setLogo(int var1) {
      this.pullChildren();
      this.mDecorToolbar.setLogo(var1);
   }

   public void setMenu(Menu var1, MenuPresenter$Callback var2) {
      this.pullChildren();
      this.mDecorToolbar.setMenu(var1, var2);
   }

   public void setMenuPrepared() {
      this.pullChildren();
      this.mDecorToolbar.setMenuPrepared();
   }

   public void setOverlayMode(boolean var1) {
      this.mOverlayMode = var1;
      if(var1 && this.getContext().getApplicationInfo().targetSdkVersion < 19) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.mIgnoreWindowContentOverlay = var1;
   }

   public void setShowingForActionMode(boolean var1) {
   }

   public void setUiOptions(int var1) {
   }

   public void setWindowCallback(Callback var1) {
      this.pullChildren();
      this.mDecorToolbar.setWindowCallback(var1);
   }

   public void setWindowTitle(CharSequence var1) {
      this.pullChildren();
      this.mDecorToolbar.setWindowTitle(var1);
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }

   public boolean showOverflowMenu() {
      this.pullChildren();
      return this.mDecorToolbar.showOverflowMenu();
   }
}
