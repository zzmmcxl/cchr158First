package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.widget.CoordinatorLayout$1;
import android.support.design.widget.CoordinatorLayout$ApplyInsetsListener;
import android.support.design.widget.CoordinatorLayout$Behavior;
import android.support.design.widget.CoordinatorLayout$DefaultBehavior;
import android.support.design.widget.CoordinatorLayout$HierarchyChangeListener;
import android.support.design.widget.CoordinatorLayout$LayoutParams;
import android.support.design.widget.CoordinatorLayout$OnPreDrawListener;
import android.support.design.widget.CoordinatorLayout$SavedState;
import android.support.design.widget.CoordinatorLayout$ViewElevationComparator;
import android.support.design.widget.CoordinatorLayoutInsetsHelper;
import android.support.design.widget.CoordinatorLayoutInsetsHelperLollipop;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ViewGroupUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {
   static final Class<?>[] CONSTRUCTOR_PARAMS;
   static final CoordinatorLayoutInsetsHelper INSETS_HELPER;
   static final String TAG = "CoordinatorLayout";
   static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
   private static final int TYPE_ON_INTERCEPT = 0;
   private static final int TYPE_ON_TOUCH = 1;
   static final String WIDGET_PACKAGE_NAME;
   static final ThreadLocal<Map<String, Constructor<CoordinatorLayout$Behavior>>> sConstructors;
   private View mBehaviorTouchView;
   private final List<View> mDependencySortedChildren;
   private boolean mDrawStatusBarBackground;
   private boolean mIsAttachedToWindow;
   private int[] mKeylines;
   private WindowInsetsCompat mLastInsets;
   final Comparator<View> mLayoutDependencyComparator;
   private boolean mNeedsPreDrawListener;
   private View mNestedScrollingDirectChild;
   private final NestedScrollingParentHelper mNestedScrollingParentHelper;
   private View mNestedScrollingTarget;
   private OnHierarchyChangeListener mOnHierarchyChangeListener;
   private CoordinatorLayout$OnPreDrawListener mOnPreDrawListener;
   private Paint mScrimPaint;
   private Drawable mStatusBarBackground;
   private final List<View> mTempDependenciesList;
   private final int[] mTempIntPair;
   private final List<View> mTempList1;
   private final Rect mTempRect1;
   private final Rect mTempRect2;
   private final Rect mTempRect3;

   static {
      Package var0 = CoordinatorLayout.class.getPackage();
      String var1;
      if(var0 != null) {
         var1 = var0.getName();
      } else {
         var1 = null;
      }

      WIDGET_PACKAGE_NAME = var1;
      if(VERSION.SDK_INT >= 21) {
         TOP_SORTED_CHILDREN_COMPARATOR = new CoordinatorLayout$ViewElevationComparator();
         INSETS_HELPER = new CoordinatorLayoutInsetsHelperLollipop();
      } else {
         TOP_SORTED_CHILDREN_COMPARATOR = null;
         INSETS_HELPER = null;
      }

      CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
      sConstructors = new ThreadLocal();
   }

   public CoordinatorLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CoordinatorLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CoordinatorLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mLayoutDependencyComparator = new CoordinatorLayout$1(this);
      this.mDependencySortedChildren = new ArrayList();
      this.mTempList1 = new ArrayList();
      this.mTempDependenciesList = new ArrayList();
      this.mTempRect1 = new Rect();
      this.mTempRect2 = new Rect();
      this.mTempRect3 = new Rect();
      this.mTempIntPair = new int[2];
      this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
      ThemeUtils.checkAppCompatTheme(var1);
      TypedArray var8 = var1.obtainStyledAttributes(var2, R$styleable.CoordinatorLayout, var3, R$style.Widget_Design_CoordinatorLayout);
      var3 = var8.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
      if(var3 != 0) {
         Resources var6 = var1.getResources();
         this.mKeylines = var6.getIntArray(var3);
         float var4 = var6.getDisplayMetrics().density;
         int var5 = this.mKeylines.length;

         for(var3 = 0; var3 < var5; ++var3) {
            int[] var7 = this.mKeylines;
            var7[var3] = (int)((float)var7[var3] * var4);
         }
      }

      this.mStatusBarBackground = var8.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
      var8.recycle();
      if(INSETS_HELPER != null) {
         INSETS_HELPER.setupForWindowInsets(this, new CoordinatorLayout$ApplyInsetsListener(this, (CoordinatorLayout$1)null));
      }

      super.setOnHierarchyChangeListener(new CoordinatorLayout$HierarchyChangeListener(this, (CoordinatorLayout$1)null));
   }

   private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat var1) {
      if(var1.isConsumed()) {
         return var1;
      } else {
         int var2 = 0;
         int var3 = this.getChildCount();

         WindowInsetsCompat var4;
         while(true) {
            var4 = var1;
            if(var2 >= var3) {
               break;
            }

            View var5 = this.getChildAt(var2);
            var4 = var1;
            if(ViewCompat.getFitsSystemWindows(var5)) {
               CoordinatorLayout$Behavior var6 = ((CoordinatorLayout$LayoutParams)var5.getLayoutParams()).getBehavior();
               var4 = var1;
               if(var6 != null) {
                  var1 = var6.onApplyWindowInsets(this, var5, var1);
                  var4 = var1;
                  if(var1.isConsumed()) {
                     var4 = var1;
                     break;
                  }
               }
            }

            ++var2;
            var1 = var4;
         }

         return var4;
      }
   }

   private int getKeyline(int var1) {
      if(this.mKeylines == null) {
         Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + var1);
         return 0;
      } else if(var1 >= 0 && var1 < this.mKeylines.length) {
         return this.mKeylines[var1];
      } else {
         Log.e("CoordinatorLayout", "Keyline index " + var1 + " out of range for " + this);
         return 0;
      }
   }

   private void getTopSortedChildren(List<View> var1) {
      var1.clear();
      boolean var5 = this.isChildrenDrawingOrderEnabled();
      int var4 = this.getChildCount();

      for(int var2 = var4 - 1; var2 >= 0; --var2) {
         int var3;
         if(var5) {
            var3 = this.getChildDrawingOrder(var4, var2);
         } else {
            var3 = var2;
         }

         var1.add(this.getChildAt(var3));
      }

      if(TOP_SORTED_CHILDREN_COMPARATOR != null) {
         Collections.sort(var1, TOP_SORTED_CHILDREN_COMPARATOR);
      }

   }

   private void layoutChild(View var1, int var2) {
      CoordinatorLayout$LayoutParams var3 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      Rect var4 = this.mTempRect1;
      var4.set(this.getPaddingLeft() + var3.leftMargin, this.getPaddingTop() + var3.topMargin, this.getWidth() - this.getPaddingRight() - var3.rightMargin, this.getHeight() - this.getPaddingBottom() - var3.bottomMargin);
      if(this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(var1)) {
         var4.left += this.mLastInsets.getSystemWindowInsetLeft();
         var4.top += this.mLastInsets.getSystemWindowInsetTop();
         var4.right -= this.mLastInsets.getSystemWindowInsetRight();
         var4.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
      }

      Rect var5 = this.mTempRect2;
      GravityCompat.apply(resolveGravity(var3.gravity), var1.getMeasuredWidth(), var1.getMeasuredHeight(), var4, var5, var2);
      var1.layout(var5.left, var5.top, var5.right, var5.bottom);
   }

   private void layoutChildWithAnchor(View var1, View var2, int var3) {
      CoordinatorLayout$LayoutParams var4 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      Rect var6 = this.mTempRect1;
      Rect var5 = this.mTempRect2;
      this.getDescendantRect(var2, var6);
      this.getDesiredAnchoredChildRect(var1, var3, var6, var5);
      var1.layout(var5.left, var5.top, var5.right, var5.bottom);
   }

   private void layoutChildWithKeyline(View var1, int var2, int var3) {
      CoordinatorLayout$LayoutParams var10 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      int var9 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(var10.gravity), var3);
      int var8 = this.getWidth();
      int var7 = this.getHeight();
      int var5 = var1.getMeasuredWidth();
      int var6 = var1.getMeasuredHeight();
      int var4 = var2;
      if(var3 == 1) {
         var4 = var8 - var2;
      }

      var2 = this.getKeyline(var4) - var5;
      var3 = 0;
      switch(var9 & 7) {
      case 1:
         var2 += var5 / 2;
         break;
      case 5:
         var2 += var5;
      }

      switch(var9 & 112) {
      case 16:
         var3 = 0 + var6 / 2;
         break;
      case 80:
         var3 = 0 + var6;
      }

      var2 = Math.max(this.getPaddingLeft() + var10.leftMargin, Math.min(var2, var8 - this.getPaddingRight() - var5 - var10.rightMargin));
      var3 = Math.max(this.getPaddingTop() + var10.topMargin, Math.min(var3, var7 - this.getPaddingBottom() - var6 - var10.bottomMargin));
      var1.layout(var2, var3, var2 + var5, var3 + var6);
   }

   static CoordinatorLayout$Behavior parseBehavior(Context param0, AttributeSet param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean performIntercept(MotionEvent var1, int var2) {
      boolean var8 = false;
      boolean var3 = false;
      MotionEvent var13 = null;
      int var6 = MotionEventCompat.getActionMasked(var1);
      List var15 = this.mTempList1;
      this.getTopSortedChildren(var15);
      int var7 = var15.size();
      int var4 = 0;

      boolean var9;
      while(true) {
         var9 = var8;
         if(var4 >= var7) {
            break;
         }

         View var16 = (View)var15.get(var4);
         CoordinatorLayout$LayoutParams var14 = (CoordinatorLayout$LayoutParams)var16.getLayoutParams();
         CoordinatorLayout$Behavior var17 = var14.getBehavior();
         boolean var5;
         boolean var10;
         MotionEvent var18;
         if((var8 || var3) && var6 != 0) {
            var18 = var13;
            var10 = var8;
            var5 = var3;
            if(var17 != null) {
               var18 = var13;
               if(var13 == null) {
                  long var11 = SystemClock.uptimeMillis();
                  var18 = MotionEvent.obtain(var11, var11, 3, 0.0F, 0.0F, 0);
               }

               switch(var2) {
               case 0:
                  var17.onInterceptTouchEvent(this, var16, var18);
                  var10 = var8;
                  var5 = var3;
                  break;
               case 1:
                  var17.onTouchEvent(this, var16, var18);
                  var10 = var8;
                  var5 = var3;
                  break;
               default:
                  var5 = var3;
                  var10 = var8;
               }
            }
         } else {
            var9 = var8;
            if(!var8) {
               var9 = var8;
               if(var17 != null) {
                  switch(var2) {
                  case 0:
                     var8 = var17.onInterceptTouchEvent(this, var16, var1);
                     break;
                  case 1:
                     var8 = var17.onTouchEvent(this, var16, var1);
                  }

                  var9 = var8;
                  if(var8) {
                     this.mBehaviorTouchView = var16;
                     var9 = var8;
                  }
               }
            }

            var10 = var14.didBlockInteraction();
            var8 = var14.isBlockingInteractionBelow(this, var16);
            if(var8 && !var10) {
               var3 = true;
            } else {
               var3 = false;
            }

            var18 = var13;
            var10 = var9;
            var5 = var3;
            if(var8) {
               var18 = var13;
               var10 = var9;
               var5 = var3;
               if(!var3) {
                  break;
               }
            }
         }

         ++var4;
         var13 = var18;
         var8 = var10;
         var3 = var5;
      }

      var15.clear();
      return var9;
   }

   private void prepareChildren() {
      this.mDependencySortedChildren.clear();
      int var1 = 0;

      for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         this.getResolvedLayoutParams(var3).findAnchorView(this, var3);
         this.mDependencySortedChildren.add(var3);
      }

      selectionSort(this.mDependencySortedChildren, this.mLayoutDependencyComparator);
   }

   private void resetTouchBehaviors() {
      if(this.mBehaviorTouchView != null) {
         CoordinatorLayout$Behavior var5 = ((CoordinatorLayout$LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
         if(var5 != null) {
            long var3 = SystemClock.uptimeMillis();
            MotionEvent var6 = MotionEvent.obtain(var3, var3, 3, 0.0F, 0.0F, 0);
            var5.onTouchEvent(this, this.mBehaviorTouchView, var6);
            var6.recycle();
         }

         this.mBehaviorTouchView = null;
      }

      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         ((CoordinatorLayout$LayoutParams)this.getChildAt(var1).getLayoutParams()).resetTouchBehaviorTracking();
      }

   }

   private static int resolveAnchoredChildGravity(int var0) {
      int var1 = var0;
      if(var0 == 0) {
         var1 = 17;
      }

      return var1;
   }

   private static int resolveGravity(int var0) {
      int var1 = var0;
      if(var0 == 0) {
         var1 = 8388659;
      }

      return var1;
   }

   private static int resolveKeylineGravity(int var0) {
      int var1 = var0;
      if(var0 == 0) {
         var1 = 8388661;
      }

      return var1;
   }

   private static void selectionSort(List<View> var0, Comparator<View> var1) {
      if(var0 != null && var0.size() >= 2) {
         View[] var7 = new View[var0.size()];
         var0.toArray(var7);
         int var6 = var7.length;

         int var2;
         for(var2 = 0; var2 < var6; ++var2) {
            int var4 = var2;

            int var5;
            for(int var3 = var2 + 1; var3 < var6; var4 = var5) {
               var5 = var4;
               if(var1.compare(var7[var3], var7[var4]) < 0) {
                  var5 = var3;
               }

               ++var3;
            }

            if(var2 != var4) {
               View var8 = var7[var4];
               var7[var4] = var7[var2];
               var7[var2] = var8;
            }
         }

         var0.clear();

         for(var2 = 0; var2 < var6; ++var2) {
            var0.add(var7[var2]);
         }
      }

   }

   private WindowInsetsCompat setWindowInsets(WindowInsetsCompat var1) {
      boolean var3 = true;
      WindowInsetsCompat var4 = var1;
      if(this.mLastInsets != var1) {
         this.mLastInsets = var1;
         boolean var2;
         if(var1 != null && var1.getSystemWindowInsetTop() > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.mDrawStatusBarBackground = var2;
         if(!this.mDrawStatusBarBackground && this.getBackground() == null) {
            var2 = var3;
         } else {
            var2 = false;
         }

         this.setWillNotDraw(var2);
         var4 = this.dispatchApplyWindowInsetsToBehaviors(var1);
         this.requestLayout();
      }

      return var4;
   }

   void addPreDrawListener() {
      if(this.mIsAttachedToWindow) {
         if(this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new CoordinatorLayout$OnPreDrawListener(this);
         }

         this.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
      }

      this.mNeedsPreDrawListener = true;
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof CoordinatorLayout$LayoutParams && super.checkLayoutParams(var1);
   }

   void dispatchDependentViewRemoved(View var1) {
      int var5 = this.mDependencySortedChildren.size();
      boolean var3 = false;

      boolean var4;
      for(int var2 = 0; var2 < var5; var3 = var4) {
         View var6 = (View)this.mDependencySortedChildren.get(var2);
         if(var6 == var1) {
            var4 = true;
         } else {
            var4 = var3;
            if(var3) {
               CoordinatorLayout$LayoutParams var7 = (CoordinatorLayout$LayoutParams)var6.getLayoutParams();
               CoordinatorLayout$Behavior var8 = var7.getBehavior();
               var4 = var3;
               if(var8 != null) {
                  var4 = var3;
                  if(var7.dependsOn(this, var6, var1)) {
                     var8.onDependentViewRemoved(this, var6, var1);
                     var4 = var3;
                  }
               }
            }
         }

         ++var2;
      }

   }

   public void dispatchDependentViewsChanged(View var1) {
      int var5 = this.mDependencySortedChildren.size();
      boolean var3 = false;

      boolean var4;
      for(int var2 = 0; var2 < var5; var3 = var4) {
         View var6 = (View)this.mDependencySortedChildren.get(var2);
         if(var6 == var1) {
            var4 = true;
         } else {
            var4 = var3;
            if(var3) {
               CoordinatorLayout$LayoutParams var7 = (CoordinatorLayout$LayoutParams)var6.getLayoutParams();
               CoordinatorLayout$Behavior var8 = var7.getBehavior();
               var4 = var3;
               if(var8 != null) {
                  var4 = var3;
                  if(var7.dependsOn(this, var6, var1)) {
                     var8.onDependentViewChanged(this, var6, var1);
                     var4 = var3;
                  }
               }
            }
         }

         ++var2;
      }

   }

   void dispatchOnDependentViewChanged(boolean var1) {
      int var4 = ViewCompat.getLayoutDirection(this);
      int var5 = this.mDependencySortedChildren.size();

      for(int var2 = 0; var2 < var5; ++var2) {
         View var7 = (View)this.mDependencySortedChildren.get(var2);
         CoordinatorLayout$LayoutParams var8 = (CoordinatorLayout$LayoutParams)var7.getLayoutParams();

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            View var9 = (View)this.mDependencySortedChildren.get(var3);
            if(var8.mAnchorDirectChild == var9) {
               this.offsetChildToAnchor(var7, var4);
            }
         }

         Rect var11 = this.mTempRect1;
         Rect var13 = this.mTempRect2;
         this.getLastChildRect(var7, var11);
         this.getChildRect(var7, true, var13);
         if(!var11.equals(var13)) {
            this.recordLastChildRect(var7, var13);

            for(var3 = var2 + 1; var3 < var5; ++var3) {
               View var12 = (View)this.mDependencySortedChildren.get(var3);
               CoordinatorLayout$LayoutParams var14 = (CoordinatorLayout$LayoutParams)var12.getLayoutParams();
               CoordinatorLayout$Behavior var10 = var14.getBehavior();
               if(var10 != null && var10.layoutDependsOn(this, var12, var7)) {
                  if(!var1 && var14.getChangedAfterNestedScroll()) {
                     var14.resetChangedAfterNestedScroll();
                  } else {
                     boolean var6 = var10.onDependentViewChanged(this, var12, var7);
                     if(var1) {
                        var14.setChangedAfterNestedScroll(var6);
                     }
                  }
               }
            }
         }
      }

   }

   public boolean doViewsOverlap(View var1, View var2) {
      if(var1.getVisibility() == 0 && var2.getVisibility() == 0) {
         Rect var4 = this.mTempRect1;
         boolean var3;
         if(var1.getParent() != this) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.getChildRect(var1, var3, var4);
         Rect var5 = this.mTempRect2;
         if(var2.getParent() != this) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.getChildRect(var2, var3, var5);
         return var4.left <= var5.right && var4.top <= var5.bottom && var4.right >= var5.left && var4.bottom >= var5.top;
      } else {
         return false;
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      CoordinatorLayout$LayoutParams var5 = (CoordinatorLayout$LayoutParams)var2.getLayoutParams();
      if(var5.mBehavior != null && var5.mBehavior.getScrimOpacity(this, var2) > 0.0F) {
         if(this.mScrimPaint == null) {
            this.mScrimPaint = new Paint();
         }

         this.mScrimPaint.setColor(var5.mBehavior.getScrimColor(this, var2));
         var1.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), this.mScrimPaint);
      }

      return super.drawChild(var1, var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var3 = this.getDrawableState();
      boolean var2 = false;
      Drawable var4 = this.mStatusBarBackground;
      boolean var1 = var2;
      if(var4 != null) {
         var1 = var2;
         if(var4.isStateful()) {
            var1 = false | var4.setState(var3);
         }
      }

      if(var1) {
         this.invalidate();
      }

   }

   void ensurePreDrawListener() {
      boolean var4 = false;
      int var2 = this.getChildCount();
      int var1 = 0;

      boolean var3;
      while(true) {
         var3 = var4;
         if(var1 >= var2) {
            break;
         }

         if(this.hasDependencies(this.getChildAt(var1))) {
            var3 = true;
            break;
         }

         ++var1;
      }

      if(var3 != this.mNeedsPreDrawListener) {
         if(!var3) {
            this.removePreDrawListener();
            return;
         }

         this.addPreDrawListener();
      }

   }

   protected CoordinatorLayout$LayoutParams generateDefaultLayoutParams() {
      return new CoordinatorLayout$LayoutParams(-2, -2);
   }

   public CoordinatorLayout$LayoutParams generateLayoutParams(AttributeSet var1) {
      return new CoordinatorLayout$LayoutParams(this.getContext(), var1);
   }

   protected CoordinatorLayout$LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof CoordinatorLayout$LayoutParams?new CoordinatorLayout$LayoutParams((CoordinatorLayout$LayoutParams)var1):(var1 instanceof MarginLayoutParams?new CoordinatorLayout$LayoutParams((MarginLayoutParams)var1):new CoordinatorLayout$LayoutParams(var1));
   }

   void getChildRect(View var1, boolean var2, Rect var3) {
      if(!var1.isLayoutRequested() && var1.getVisibility() != 8) {
         if(var2) {
            this.getDescendantRect(var1, var3);
         } else {
            var3.set(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom());
         }
      } else {
         var3.set(0, 0, 0, 0);
      }
   }

   public List<View> getDependencies(View var1) {
      CoordinatorLayout$LayoutParams var4 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      List var5 = this.mTempDependenciesList;
      var5.clear();
      int var3 = this.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         View var6 = this.getChildAt(var2);
         if(var6 != var1 && var4.dependsOn(this, var1, var6)) {
            var5.add(var6);
         }
      }

      return var5;
   }

   void getDescendantRect(View var1, Rect var2) {
      ViewGroupUtils.getDescendantRect(this, var1, var2);
   }

   void getDesiredAnchoredChildRect(View var1, int var2, Rect var3, Rect var4) {
      CoordinatorLayout$LayoutParams var10 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      int var9 = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(var10.gravity), var2);
      int var5 = GravityCompat.getAbsoluteGravity(resolveGravity(var10.anchorGravity), var2);
      int var7 = var1.getMeasuredWidth();
      int var8 = var1.getMeasuredHeight();
      switch(var5 & 7) {
      case 1:
         var2 = var3.left + var3.width() / 2;
         break;
      case 5:
         var2 = var3.right;
         break;
      default:
         var2 = var3.left;
      }

      switch(var5 & 112) {
      case 16:
         var5 = var3.top + var3.height() / 2;
         break;
      case 80:
         var5 = var3.bottom;
         break;
      default:
         var5 = var3.top;
      }

      int var6 = var2;
      switch(var9 & 7) {
      case 1:
         var6 = var2 - var7 / 2;
      case 5:
         break;
      default:
         var6 = var2 - var7;
      }

      var2 = var5;
      switch(var9 & 112) {
      case 16:
         var2 = var5 - var8 / 2;
      case 80:
         break;
      default:
         var2 = var5 - var8;
      }

      var9 = this.getWidth();
      var5 = this.getHeight();
      var6 = Math.max(this.getPaddingLeft() + var10.leftMargin, Math.min(var6, var9 - this.getPaddingRight() - var7 - var10.rightMargin));
      var2 = Math.max(this.getPaddingTop() + var10.topMargin, Math.min(var2, var5 - this.getPaddingBottom() - var8 - var10.bottomMargin));
      var4.set(var6, var2, var6 + var7, var2 + var8);
   }

   void getLastChildRect(View var1, Rect var2) {
      var2.set(((CoordinatorLayout$LayoutParams)var1.getLayoutParams()).getLastChildRect());
   }

   public int getNestedScrollAxes() {
      return this.mNestedScrollingParentHelper.getNestedScrollAxes();
   }

   CoordinatorLayout$LayoutParams getResolvedLayoutParams(View var1) {
      CoordinatorLayout$LayoutParams var4 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      if(!var4.mBehaviorResolved) {
         Class var2 = var1.getClass();
         CoordinatorLayout$DefaultBehavior var6 = null;

         CoordinatorLayout$DefaultBehavior var3;
         while(true) {
            var3 = var6;
            if(var2 == null) {
               break;
            }

            var6 = (CoordinatorLayout$DefaultBehavior)var2.getAnnotation(CoordinatorLayout$DefaultBehavior.class);
            var3 = var6;
            if(var6 != null) {
               break;
            }

            var2 = var2.getSuperclass();
         }

         if(var3 != null) {
            try {
               var4.setBehavior((CoordinatorLayout$Behavior)var3.value().newInstance());
            } catch (Exception var5) {
               Log.e("CoordinatorLayout", "Default behavior class " + var3.value().getName() + " could not be instantiated. Did you forget a default constructor?", var5);
            }
         }

         var4.mBehaviorResolved = true;
      }

      return var4;
   }

   @Nullable
   public Drawable getStatusBarBackground() {
      return this.mStatusBarBackground;
   }

   protected int getSuggestedMinimumHeight() {
      return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
   }

   protected int getSuggestedMinimumWidth() {
      return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
   }

   boolean hasDependencies(View var1) {
      CoordinatorLayout$LayoutParams var4 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      if(var4.mAnchorView != null) {
         return true;
      } else {
         int var3 = this.getChildCount();

         for(int var2 = 0; var2 < var3; ++var2) {
            View var5 = this.getChildAt(var2);
            if(var5 != var1 && var4.dependsOn(this, var1, var5)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean isPointInChildBounds(View var1, int var2, int var3) {
      Rect var4 = this.mTempRect1;
      this.getDescendantRect(var1, var4);
      return var4.contains(var2, var3);
   }

   void offsetChildToAnchor(View var1, int var2) {
      CoordinatorLayout$LayoutParams var4 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      if(var4.mAnchorView != null) {
         Rect var5 = this.mTempRect1;
         Rect var6 = this.mTempRect2;
         Rect var7 = this.mTempRect3;
         this.getDescendantRect(var4.mAnchorView, var5);
         this.getChildRect(var1, false, var6);
         this.getDesiredAnchoredChildRect(var1, var2, var5, var7);
         var2 = var7.left - var6.left;
         int var3 = var7.top - var6.top;
         if(var2 != 0) {
            var1.offsetLeftAndRight(var2);
         }

         if(var3 != 0) {
            var1.offsetTopAndBottom(var3);
         }

         if(var2 != 0 || var3 != 0) {
            CoordinatorLayout$Behavior var8 = var4.getBehavior();
            if(var8 != null) {
               var8.onDependentViewChanged(this, var1, var4.mAnchorView);
            }
         }
      }

   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.resetTouchBehaviors();
      if(this.mNeedsPreDrawListener) {
         if(this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new CoordinatorLayout$OnPreDrawListener(this);
         }

         this.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
      }

      if(this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
         ViewCompat.requestApplyInsets(this);
      }

      this.mIsAttachedToWindow = true;
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.resetTouchBehaviors();
      if(this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
         this.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
      }

      if(this.mNestedScrollingTarget != null) {
         this.onStopNestedScroll(this.mNestedScrollingTarget);
      }

      this.mIsAttachedToWindow = false;
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
         int var2;
         if(this.mLastInsets != null) {
            var2 = this.mLastInsets.getSystemWindowInsetTop();
         } else {
            var2 = 0;
         }

         if(var2 > 0) {
            this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), var2);
            this.mStatusBarBackground.draw(var1);
         }
      }

   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(var2 == 0) {
         this.resetTouchBehaviors();
      }

      boolean var3 = this.performIntercept(var1, 0);
      if(false) {
         throw new NullPointerException();
      } else {
         if(var2 == 1 || var2 == 3) {
            this.resetTouchBehaviors();
         }

         return var3;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var3 = ViewCompat.getLayoutDirection(this);
      var4 = this.mDependencySortedChildren.size();

      for(var2 = 0; var2 < var4; ++var2) {
         View var6 = (View)this.mDependencySortedChildren.get(var2);
         CoordinatorLayout$Behavior var7 = ((CoordinatorLayout$LayoutParams)var6.getLayoutParams()).getBehavior();
         if(var7 == null || !var7.onLayoutChild(this, var6, var3)) {
            this.onLayoutChild(var6, var3);
         }
      }

   }

   public void onLayoutChild(View var1, int var2) {
      CoordinatorLayout$LayoutParams var3 = (CoordinatorLayout$LayoutParams)var1.getLayoutParams();
      if(var3.checkAnchorChanged()) {
         throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
      } else if(var3.mAnchorView != null) {
         this.layoutChildWithAnchor(var1, var3.mAnchorView, var2);
      } else if(var3.keyline >= 0) {
         this.layoutChildWithKeyline(var1, var3.keyline, var2);
      } else {
         this.layoutChild(var1, var2);
      }
   }

   protected void onMeasure(int var1, int var2) {
      this.prepareChildren();
      this.ensurePreDrawListener();
      int var14 = this.getPaddingLeft();
      int var15 = this.getPaddingTop();
      int var16 = this.getPaddingRight();
      int var17 = this.getPaddingBottom();
      int var18 = ViewCompat.getLayoutDirection(this);
      boolean var4;
      if(var18 == 1) {
         var4 = true;
      } else {
         var4 = false;
      }

      int var19 = MeasureSpec.getMode(var1);
      int var20 = MeasureSpec.getSize(var1);
      int var21 = MeasureSpec.getMode(var2);
      int var22 = MeasureSpec.getSize(var2);
      int var9 = this.getSuggestedMinimumWidth();
      int var8 = this.getSuggestedMinimumHeight();
      int var7 = 0;
      boolean var5;
      if(this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
         var5 = true;
      } else {
         var5 = false;
      }

      int var23 = this.mDependencySortedChildren.size();

      for(int var6 = 0; var6 < var23; ++var6) {
         View var24 = (View)this.mDependencySortedChildren.get(var6);
         CoordinatorLayout$LayoutParams var25 = (CoordinatorLayout$LayoutParams)var24.getLayoutParams();
         byte var10 = 0;
         int var3 = var10;
         int var11;
         int var12;
         if(var25.keyline >= 0) {
            var3 = var10;
            if(var19 != 0) {
               var11 = this.getKeyline(var25.keyline);
               var12 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(var25.gravity), var18) & 7;
               if(var12 == 3 && !var4 || var12 == 5 && var4) {
                  var3 = Math.max(0, var20 - var16 - var11);
               } else {
                  label92: {
                     if(var12 != 5 || var4) {
                        var3 = var10;
                        if(var12 != 3) {
                           break label92;
                        }

                        var3 = var10;
                        if(!var4) {
                           break label92;
                        }
                     }

                     var3 = Math.max(0, var11 - var14);
                  }
               }
            }
         }

         int var13 = var1;
         int var27 = var2;
         if(var5) {
            var13 = var1;
            var27 = var2;
            if(!ViewCompat.getFitsSystemWindows(var24)) {
               var12 = this.mLastInsets.getSystemWindowInsetLeft();
               var13 = this.mLastInsets.getSystemWindowInsetRight();
               var27 = this.mLastInsets.getSystemWindowInsetTop();
               var11 = this.mLastInsets.getSystemWindowInsetBottom();
               var13 = MeasureSpec.makeMeasureSpec(var20 - (var12 + var13), var19);
               var27 = MeasureSpec.makeMeasureSpec(var22 - (var27 + var11), var21);
            }
         }

         CoordinatorLayout$Behavior var26 = var25.getBehavior();
         if(var26 == null || !var26.onMeasureChild(this, var24, var13, var3, var27, 0)) {
            this.onMeasureChild(var24, var13, var3, var27, 0);
         }

         var9 = Math.max(var9, var24.getMeasuredWidth() + var14 + var16 + var25.leftMargin + var25.rightMargin);
         var8 = Math.max(var8, var24.getMeasuredHeight() + var15 + var17 + var25.topMargin + var25.bottomMargin);
         var7 = ViewCompat.combineMeasuredStates(var7, ViewCompat.getMeasuredState(var24));
      }

      this.setMeasuredDimension(ViewCompat.resolveSizeAndState(var9, var1, -16777216 & var7), ViewCompat.resolveSizeAndState(var8, var2, var7 << 16));
   }

   public void onMeasureChild(View var1, int var2, int var3, int var4, int var5) {
      this.measureChildWithMargins(var1, var2, var3, var4, var5);
   }

   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      boolean var7 = false;
      int var6 = this.getChildCount();

      boolean var8;
      for(int var5 = 0; var5 < var6; var7 = var8) {
         View var9 = this.getChildAt(var5);
         CoordinatorLayout$LayoutParams var10 = (CoordinatorLayout$LayoutParams)var9.getLayoutParams();
         if(!var10.isNestedScrollAccepted()) {
            var8 = var7;
         } else {
            CoordinatorLayout$Behavior var11 = var10.getBehavior();
            var8 = var7;
            if(var11 != null) {
               var8 = var7 | var11.onNestedFling(this, var9, var1, var2, var3, var4);
            }
         }

         ++var5;
      }

      if(var7) {
         this.dispatchOnDependentViewChanged(true);
      }

      return var7;
   }

   public boolean onNestedPreFling(View var1, float var2, float var3) {
      boolean var6 = false;
      int var5 = this.getChildCount();

      boolean var7;
      for(int var4 = 0; var4 < var5; var6 = var7) {
         View var8 = this.getChildAt(var4);
         CoordinatorLayout$LayoutParams var9 = (CoordinatorLayout$LayoutParams)var8.getLayoutParams();
         if(!var9.isNestedScrollAccepted()) {
            var7 = var6;
         } else {
            CoordinatorLayout$Behavior var10 = var9.getBehavior();
            var7 = var6;
            if(var10 != null) {
               var7 = var6 | var10.onNestedPreFling(this, var8, var1, var2, var3);
            }
         }

         ++var4;
      }

      return var6;
   }

   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
      int var5 = 0;
      int var6 = 0;
      boolean var8 = false;
      int var11 = this.getChildCount();

      int var10;
      for(int var7 = 0; var7 < var11; var6 = var10) {
         View var12 = this.getChildAt(var7);
         CoordinatorLayout$LayoutParams var13 = (CoordinatorLayout$LayoutParams)var12.getLayoutParams();
         int var9;
         if(!var13.isNestedScrollAccepted()) {
            var10 = var6;
            var9 = var5;
         } else {
            CoordinatorLayout$Behavior var15 = var13.getBehavior();
            var9 = var5;
            var10 = var6;
            if(var15 != null) {
               int[] var14 = this.mTempIntPair;
               this.mTempIntPair[1] = 0;
               var14[0] = 0;
               var15.onNestedPreScroll(this, var12, var1, var2, var3, this.mTempIntPair);
               if(var2 > 0) {
                  var5 = Math.max(var5, this.mTempIntPair[0]);
               } else {
                  var5 = Math.min(var5, this.mTempIntPair[0]);
               }

               if(var3 > 0) {
                  var6 = Math.max(var6, this.mTempIntPair[1]);
               } else {
                  var6 = Math.min(var6, this.mTempIntPair[1]);
               }

               var8 = true;
               var9 = var5;
               var10 = var6;
            }
         }

         ++var7;
         var5 = var9;
      }

      var4[0] = var5;
      var4[1] = var6;
      if(var8) {
         this.dispatchOnDependentViewChanged(true);
      }

   }

   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      int var8 = this.getChildCount();
      boolean var7 = false;

      for(int var6 = 0; var6 < var8; ++var6) {
         View var9 = this.getChildAt(var6);
         CoordinatorLayout$LayoutParams var10 = (CoordinatorLayout$LayoutParams)var9.getLayoutParams();
         if(var10.isNestedScrollAccepted()) {
            CoordinatorLayout$Behavior var11 = var10.getBehavior();
            if(var11 != null) {
               var11.onNestedScroll(this, var9, var1, var2, var3, var4, var5);
               var7 = true;
            }
         }
      }

      if(var7) {
         this.dispatchOnDependentViewChanged(true);
      }

   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mNestedScrollingParentHelper.onNestedScrollAccepted(var1, var2, var3);
      this.mNestedScrollingDirectChild = var1;
      this.mNestedScrollingTarget = var2;
      int var5 = this.getChildCount();

      for(int var4 = 0; var4 < var5; ++var4) {
         View var6 = this.getChildAt(var4);
         CoordinatorLayout$LayoutParams var7 = (CoordinatorLayout$LayoutParams)var6.getLayoutParams();
         if(var7.isNestedScrollAccepted()) {
            CoordinatorLayout$Behavior var8 = var7.getBehavior();
            if(var8 != null) {
               var8.onNestedScrollAccepted(this, var6, var1, var2, var3);
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if(!(var1 instanceof CoordinatorLayout$SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         CoordinatorLayout$SavedState var8 = (CoordinatorLayout$SavedState)var1;
         super.onRestoreInstanceState(var8.getSuperState());
         SparseArray var9 = var8.behaviorStates;
         int var2 = 0;

         for(int var3 = this.getChildCount(); var2 < var3; ++var2) {
            View var5 = this.getChildAt(var2);
            int var4 = var5.getId();
            CoordinatorLayout$Behavior var6 = this.getResolvedLayoutParams(var5).getBehavior();
            if(var4 != -1 && var6 != null) {
               Parcelable var7 = (Parcelable)var9.get(var4);
               if(var7 != null) {
                  var6.onRestoreInstanceState(this, var5, var7);
               }
            }
         }
      }

   }

   protected Parcelable onSaveInstanceState() {
      CoordinatorLayout$SavedState var4 = new CoordinatorLayout$SavedState(super.onSaveInstanceState());
      SparseArray var5 = new SparseArray();
      int var1 = 0;

      for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
         View var6 = this.getChildAt(var1);
         int var3 = var6.getId();
         CoordinatorLayout$Behavior var7 = ((CoordinatorLayout$LayoutParams)var6.getLayoutParams()).getBehavior();
         if(var3 != -1 && var7 != null) {
            Parcelable var8 = var7.onSaveInstanceState(this, var6);
            if(var8 != null) {
               var5.append(var3, var8);
            }
         }
      }

      var4.behaviorStates = var5;
      return var4;
   }

   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      boolean var6 = false;
      int var5 = this.getChildCount();

      for(int var4 = 0; var4 < var5; ++var4) {
         View var8 = this.getChildAt(var4);
         CoordinatorLayout$LayoutParams var9 = (CoordinatorLayout$LayoutParams)var8.getLayoutParams();
         CoordinatorLayout$Behavior var10 = var9.getBehavior();
         if(var10 != null) {
            boolean var7 = var10.onStartNestedScroll(this, var8, var1, var2, var3);
            var6 |= var7;
            var9.acceptNestedScroll(var7);
         } else {
            var9.acceptNestedScroll(false);
         }
      }

      return var6;
   }

   public void onStopNestedScroll(View var1) {
      this.mNestedScrollingParentHelper.onStopNestedScroll(var1);
      int var3 = this.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         View var4 = this.getChildAt(var2);
         CoordinatorLayout$LayoutParams var5 = (CoordinatorLayout$LayoutParams)var4.getLayoutParams();
         if(var5.isNestedScrollAccepted()) {
            CoordinatorLayout$Behavior var6 = var5.getBehavior();
            if(var6 != null) {
               var6.onStopNestedScroll(this, var4, var1);
            }

            var5.resetNestedScroll();
            var5.resetChangedAfterNestedScroll();
         }
      }

      this.mNestedScrollingDirectChild = null;
      this.mNestedScrollingTarget = null;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2;
      boolean var3;
      boolean var4;
      boolean var5;
      Object var9;
      Object var10;
      label41: {
         boolean var6 = false;
         var4 = false;
         var9 = null;
         var10 = null;
         var2 = MotionEventCompat.getActionMasked(var1);
         if(this.mBehaviorTouchView == null) {
            var4 = this.performIntercept(var1, 1);
            var5 = var4;
            var3 = var6;
            if(!var4) {
               break label41;
            }
         }

         CoordinatorLayout$Behavior var11 = ((CoordinatorLayout$LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
         var5 = var4;
         var3 = var6;
         if(var11 != null) {
            var3 = var11.onTouchEvent(this, this.mBehaviorTouchView, var1);
            var5 = var4;
         }
      }

      if(this.mBehaviorTouchView == null) {
         var4 = var3 | super.onTouchEvent(var1);
         var1 = (MotionEvent)var10;
      } else {
         var1 = (MotionEvent)var10;
         var4 = var3;
         if(var5) {
            var1 = (MotionEvent)var9;
            if(true) {
               long var7 = SystemClock.uptimeMillis();
               var1 = MotionEvent.obtain(var7, var7, 3, 0.0F, 0.0F, 0);
            }

            super.onTouchEvent(var1);
            var4 = var3;
         }
      }

      if(!var4 && var2 == 0) {
         ;
      }

      if(var1 != null) {
         var1.recycle();
      }

      if(var2 == 1 || var2 == 3) {
         this.resetTouchBehaviors();
      }

      return var4;
   }

   void recordLastChildRect(View var1, Rect var2) {
      ((CoordinatorLayout$LayoutParams)var1.getLayoutParams()).setLastChildRect(var2);
   }

   void removePreDrawListener() {
      if(this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
         this.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
      }

      this.mNeedsPreDrawListener = false;
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      if(var1) {
         this.resetTouchBehaviors();
      }

   }

   public void setOnHierarchyChangeListener(OnHierarchyChangeListener var1) {
      this.mOnHierarchyChangeListener = var1;
   }

   public void setStatusBarBackground(@Nullable Drawable var1) {
      Drawable var3 = null;
      if(this.mStatusBarBackground != var1) {
         if(this.mStatusBarBackground != null) {
            this.mStatusBarBackground.setCallback((Callback)null);
         }

         if(var1 != null) {
            var3 = var1.mutate();
         }

         this.mStatusBarBackground = var3;
         if(this.mStatusBarBackground != null) {
            if(this.mStatusBarBackground.isStateful()) {
               this.mStatusBarBackground.setState(this.getDrawableState());
            }

            DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
            var1 = this.mStatusBarBackground;
            boolean var2;
            if(this.getVisibility() == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            var1.setVisible(var2, false);
            this.mStatusBarBackground.setCallback(this);
         }

         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void setStatusBarBackgroundColor(@ColorInt int var1) {
      this.setStatusBarBackground(new ColorDrawable(var1));
   }

   public void setStatusBarBackgroundResource(@DrawableRes int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = ContextCompat.getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setStatusBarBackground(var2);
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(this.mStatusBarBackground != null && this.mStatusBarBackground.isVisible() != var2) {
         this.mStatusBarBackground.setVisible(var2, false);
      }

   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mStatusBarBackground;
   }
}
