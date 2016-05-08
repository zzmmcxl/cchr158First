package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.recyclerview.R$styleable;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$Adapter;
import android.support.v7.widget.RecyclerView$LayoutManager$Properties;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$SmoothScroller;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager {
   private boolean mAutoMeasure = false;
   ChildHelper mChildHelper;
   private int mHeightSpec;
   boolean mIsAttachedToWindow = false;
   private boolean mMeasurementCacheEnabled = true;
   RecyclerView mRecyclerView;
   private boolean mRequestedSimpleAnimations = false;
   @Nullable
   RecyclerView$SmoothScroller mSmoothScroller;
   private int mWidthSpec;

   private void addViewInt(View var1, int var2, boolean var3) {
      RecyclerView$ViewHolder var6 = RecyclerView.getChildViewHolderInt(var1);
      if(!var3 && !var6.isRemoved()) {
         this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(var6);
      } else {
         this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(var6);
      }

      RecyclerView$LayoutParams var7 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      if(!var6.wasReturnedFromScrap() && !var6.isScrap()) {
         if(var1.getParent() == this.mRecyclerView) {
            int var5 = this.mChildHelper.indexOfChild(var1);
            int var4 = var2;
            if(var2 == -1) {
               var4 = this.mChildHelper.getChildCount();
            }

            if(var5 == -1) {
               throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(var1));
            }

            if(var5 != var4) {
               this.mRecyclerView.mLayout.moveView(var5, var4);
            }
         } else {
            this.mChildHelper.addView(var1, var2, false);
            var7.mInsetsDirty = true;
            if(this.mSmoothScroller != null && this.mSmoothScroller.isRunning()) {
               this.mSmoothScroller.onChildAttachedToWindow(var1);
            }
         }
      } else {
         if(var6.isScrap()) {
            var6.unScrap();
         } else {
            var6.clearReturnedFromScrapFlag();
         }

         this.mChildHelper.attachViewToParent(var1, var2, var1.getLayoutParams(), false);
      }

      if(var7.mPendingInvalidate) {
         var6.itemView.invalidate();
         var7.mPendingInvalidate = false;
      }

   }

   public static int chooseSize(int var0, int var1, int var2) {
      int var4 = MeasureSpec.getMode(var0);
      int var3 = MeasureSpec.getSize(var0);
      var0 = var3;
      switch(var4) {
      case Integer.MIN_VALUE:
         return Math.min(var3, Math.max(var1, var2));
      default:
         var0 = Math.max(var1, var2);
      case 1073741824:
         return var0;
      }
   }

   private void detachViewInternal(int var1, View var2) {
      this.mChildHelper.detachViewFromParent(var1);
   }

   public static int getChildMeasureSpec(int var0, int var1, int var2, int var3, boolean var4) {
      int var5 = Math.max(0, var0 - var2);
      var2 = 0;
      var0 = 0;
      if(var4) {
         if(var3 >= 0) {
            var2 = var3;
            var0 = 1073741824;
         } else if(var3 == -1) {
            switch(var1) {
            case Integer.MIN_VALUE:
            case 1073741824:
               var2 = var5;
               var0 = var1;
               break;
            case 0:
               var2 = 0;
               var0 = 0;
            }
         } else if(var3 == -2) {
            var2 = 0;
            var0 = 0;
         }
      } else if(var3 >= 0) {
         var2 = var3;
         var0 = 1073741824;
      } else if(var3 == -1) {
         var2 = var5;
         var0 = var1;
      } else if(var3 == -2) {
         var2 = var5;
         if(var1 != Integer.MIN_VALUE && var1 != 1073741824) {
            var0 = 0;
         } else {
            var0 = Integer.MIN_VALUE;
         }
      }

      return MeasureSpec.makeMeasureSpec(var2, var0);
   }

   @Deprecated
   public static int getChildMeasureSpec(int var0, int var1, int var2, boolean var3) {
      int var4 = Math.max(0, var0 - var1);
      var1 = 0;
      var0 = 0;
      if(var3) {
         if(var2 >= 0) {
            var1 = var2;
            var0 = 1073741824;
         } else {
            var1 = 0;
            var0 = 0;
         }
      } else if(var2 >= 0) {
         var1 = var2;
         var0 = 1073741824;
      } else if(var2 == -1) {
         var1 = var4;
         var0 = 1073741824;
      } else if(var2 == -2) {
         var1 = var4;
         var0 = Integer.MIN_VALUE;
      }

      return MeasureSpec.makeMeasureSpec(var1, var0);
   }

   public static RecyclerView$LayoutManager$Properties getProperties(Context var0, AttributeSet var1, int var2, int var3) {
      RecyclerView$LayoutManager$Properties var4 = new RecyclerView$LayoutManager$Properties();
      TypedArray var5 = var0.obtainStyledAttributes(var1, R$styleable.RecyclerView, var2, var3);
      var4.orientation = var5.getInt(R$styleable.RecyclerView_android_orientation, 1);
      var4.spanCount = var5.getInt(R$styleable.RecyclerView_spanCount, 1);
      var4.reverseLayout = var5.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
      var4.stackFromEnd = var5.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
      var5.recycle();
      return var4;
   }

   private static boolean isMeasurementUpToDate(int var0, int var1, int var2) {
      boolean var5 = true;
      int var3 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      boolean var4;
      if(var2 > 0 && var0 != var2) {
         var4 = false;
      } else {
         var4 = var5;
         switch(var3) {
         case Integer.MIN_VALUE:
            var4 = var5;
            if(var1 < var0) {
               return false;
            }
         case 0:
            break;
         case 1073741824:
            var4 = var5;
            if(var1 != var0) {
               return false;
            }
            break;
         default:
            return false;
         }
      }

      return var4;
   }

   private void onSmoothScrollerStopped(RecyclerView$SmoothScroller var1) {
      if(this.mSmoothScroller == var1) {
         this.mSmoothScroller = null;
      }

   }

   private void scrapOrRecycleView(RecyclerView$Recycler var1, int var2, View var3) {
      RecyclerView$ViewHolder var4 = RecyclerView.getChildViewHolderInt(var3);
      if(!var4.shouldIgnore()) {
         if(var4.isInvalid() && !var4.isRemoved() && !RecyclerView.access$3100(this.mRecyclerView).hasStableIds()) {
            this.removeViewAt(var2);
            var1.recycleViewHolderInternal(var4);
         } else {
            this.detachViewAt(var2);
            var1.scrapView(var3);
            this.mRecyclerView.mViewInfoStore.onViewDetached(var4);
         }
      }
   }

   public void addDisappearingView(View var1) {
      this.addDisappearingView(var1, -1);
   }

   public void addDisappearingView(View var1, int var2) {
      this.addViewInt(var1, var2, true);
   }

   public void addView(View var1) {
      this.addView(var1, -1);
   }

   public void addView(View var1, int var2) {
      this.addViewInt(var1, var2, false);
   }

   public void assertInLayoutOrScroll(String var1) {
      if(this.mRecyclerView != null) {
         this.mRecyclerView.assertInLayoutOrScroll(var1);
      }

   }

   public void assertNotInLayoutOrScroll(String var1) {
      if(this.mRecyclerView != null) {
         this.mRecyclerView.assertNotInLayoutOrScroll(var1);
      }

   }

   public void attachView(View var1) {
      this.attachView(var1, -1);
   }

   public void attachView(View var1, int var2) {
      this.attachView(var1, var2, (RecyclerView$LayoutParams)var1.getLayoutParams());
   }

   public void attachView(View var1, int var2, RecyclerView$LayoutParams var3) {
      RecyclerView$ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
      if(var4.isRemoved()) {
         this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(var4);
      } else {
         this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(var4);
      }

      this.mChildHelper.attachViewToParent(var1, var2, var3, var4.isRemoved());
   }

   public void calculateItemDecorationsForChild(View var1, Rect var2) {
      if(this.mRecyclerView == null) {
         var2.set(0, 0, 0, 0);
      } else {
         var2.set(this.mRecyclerView.getItemDecorInsetsForChild(var1));
      }
   }

   public boolean canScrollHorizontally() {
      return false;
   }

   public boolean canScrollVertically() {
      return false;
   }

   public boolean checkLayoutParams(RecyclerView$LayoutParams var1) {
      return var1 != null;
   }

   public int computeHorizontalScrollExtent(RecyclerView$State var1) {
      return 0;
   }

   public int computeHorizontalScrollOffset(RecyclerView$State var1) {
      return 0;
   }

   public int computeHorizontalScrollRange(RecyclerView$State var1) {
      return 0;
   }

   public int computeVerticalScrollExtent(RecyclerView$State var1) {
      return 0;
   }

   public int computeVerticalScrollOffset(RecyclerView$State var1) {
      return 0;
   }

   public int computeVerticalScrollRange(RecyclerView$State var1) {
      return 0;
   }

   public void detachAndScrapAttachedViews(RecyclerView$Recycler var1) {
      for(int var2 = this.getChildCount() - 1; var2 >= 0; --var2) {
         this.scrapOrRecycleView(var1, var2, this.getChildAt(var2));
      }

   }

   public void detachAndScrapView(View var1, RecyclerView$Recycler var2) {
      this.scrapOrRecycleView(var2, this.mChildHelper.indexOfChild(var1), var1);
   }

   public void detachAndScrapViewAt(int var1, RecyclerView$Recycler var2) {
      this.scrapOrRecycleView(var2, var1, this.getChildAt(var1));
   }

   public void detachView(View var1) {
      int var2 = this.mChildHelper.indexOfChild(var1);
      if(var2 >= 0) {
         this.detachViewInternal(var2, var1);
      }

   }

   public void detachViewAt(int var1) {
      this.detachViewInternal(var1, this.getChildAt(var1));
   }

   void dispatchAttachedToWindow(RecyclerView var1) {
      this.mIsAttachedToWindow = true;
      this.onAttachedToWindow(var1);
   }

   void dispatchDetachedFromWindow(RecyclerView var1, RecyclerView$Recycler var2) {
      this.mIsAttachedToWindow = false;
      this.onDetachedFromWindow(var1, var2);
   }

   public void endAnimation(View var1) {
      if(this.mRecyclerView.mItemAnimator != null) {
         this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(var1));
      }

   }

   @Nullable
   public View findContainingItemView(View var1) {
      if(this.mRecyclerView == null) {
         var1 = null;
      } else {
         View var2 = this.mRecyclerView.findContainingItemView(var1);
         if(var2 == null) {
            return null;
         }

         var1 = var2;
         if(this.mChildHelper.isHidden(var2)) {
            return null;
         }
      }

      return var1;
   }

   public View findViewByPosition(int var1) {
      int var3 = this.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         View var4 = this.getChildAt(var2);
         RecyclerView$ViewHolder var5 = RecyclerView.getChildViewHolderInt(var4);
         if(var5 != null && var5.getLayoutPosition() == var1 && !var5.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !var5.isRemoved())) {
            return var4;
         }
      }

      return null;
   }

   public abstract RecyclerView$LayoutParams generateDefaultLayoutParams();

   public RecyclerView$LayoutParams generateLayoutParams(Context var1, AttributeSet var2) {
      return new RecyclerView$LayoutParams(var1, var2);
   }

   public RecyclerView$LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof RecyclerView$LayoutParams?new RecyclerView$LayoutParams((RecyclerView$LayoutParams)var1):(var1 instanceof MarginLayoutParams?new RecyclerView$LayoutParams((MarginLayoutParams)var1):new RecyclerView$LayoutParams(var1));
   }

   public int getBaseline() {
      return -1;
   }

   public int getBottomDecorationHeight(View var1) {
      return ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets.bottom;
   }

   public View getChildAt(int var1) {
      return this.mChildHelper != null?this.mChildHelper.getChildAt(var1):null;
   }

   public int getChildCount() {
      return this.mChildHelper != null?this.mChildHelper.getChildCount():0;
   }

   public boolean getClipToPadding() {
      return this.mRecyclerView != null && RecyclerView.access$5500(this.mRecyclerView);
   }

   public int getColumnCountForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mRecyclerView != null && RecyclerView.access$3100(this.mRecyclerView) != null && this.canScrollHorizontally()?RecyclerView.access$3100(this.mRecyclerView).getItemCount():1;
   }

   public int getDecoratedBottom(View var1) {
      return var1.getBottom() + this.getBottomDecorationHeight(var1);
   }

   public int getDecoratedLeft(View var1) {
      return var1.getLeft() - this.getLeftDecorationWidth(var1);
   }

   public int getDecoratedMeasuredHeight(View var1) {
      Rect var2 = ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets;
      return var1.getMeasuredHeight() + var2.top + var2.bottom;
   }

   public int getDecoratedMeasuredWidth(View var1) {
      Rect var2 = ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets;
      return var1.getMeasuredWidth() + var2.left + var2.right;
   }

   public int getDecoratedRight(View var1) {
      return var1.getRight() + this.getRightDecorationWidth(var1);
   }

   public int getDecoratedTop(View var1) {
      return var1.getTop() - this.getTopDecorationHeight(var1);
   }

   public View getFocusedChild() {
      View var1;
      if(this.mRecyclerView == null) {
         var1 = null;
         return var1;
      } else {
         View var2 = this.mRecyclerView.getFocusedChild();
         if(var2 != null) {
            var1 = var2;
            if(!this.mChildHelper.isHidden(var2)) {
               return var1;
            }
         }

         return null;
      }
   }

   public int getHeight() {
      return MeasureSpec.getSize(this.mHeightSpec);
   }

   public int getHeightMode() {
      return MeasureSpec.getMode(this.mHeightSpec);
   }

   public int getItemCount() {
      RecyclerView$Adapter var1;
      if(this.mRecyclerView != null) {
         var1 = this.mRecyclerView.getAdapter();
      } else {
         var1 = null;
      }

      return var1 != null?var1.getItemCount():0;
   }

   public int getItemViewType(View var1) {
      return RecyclerView.getChildViewHolderInt(var1).getItemViewType();
   }

   public int getLayoutDirection() {
      return ViewCompat.getLayoutDirection(this.mRecyclerView);
   }

   public int getLeftDecorationWidth(View var1) {
      return ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets.left;
   }

   public int getMinimumHeight() {
      return ViewCompat.getMinimumHeight(this.mRecyclerView);
   }

   public int getMinimumWidth() {
      return ViewCompat.getMinimumWidth(this.mRecyclerView);
   }

   public int getPaddingBottom() {
      return this.mRecyclerView != null?this.mRecyclerView.getPaddingBottom():0;
   }

   public int getPaddingEnd() {
      return this.mRecyclerView != null?ViewCompat.getPaddingEnd(this.mRecyclerView):0;
   }

   public int getPaddingLeft() {
      return this.mRecyclerView != null?this.mRecyclerView.getPaddingLeft():0;
   }

   public int getPaddingRight() {
      return this.mRecyclerView != null?this.mRecyclerView.getPaddingRight():0;
   }

   public int getPaddingStart() {
      return this.mRecyclerView != null?ViewCompat.getPaddingStart(this.mRecyclerView):0;
   }

   public int getPaddingTop() {
      return this.mRecyclerView != null?this.mRecyclerView.getPaddingTop():0;
   }

   public int getPosition(View var1) {
      return ((RecyclerView$LayoutParams)var1.getLayoutParams()).getViewLayoutPosition();
   }

   public int getRightDecorationWidth(View var1) {
      return ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets.right;
   }

   public int getRowCountForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mRecyclerView != null && RecyclerView.access$3100(this.mRecyclerView) != null && this.canScrollVertically()?RecyclerView.access$3100(this.mRecyclerView).getItemCount():1;
   }

   public int getSelectionModeForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return 0;
   }

   public int getTopDecorationHeight(View var1) {
      return ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets.top;
   }

   public int getWidth() {
      return MeasureSpec.getSize(this.mWidthSpec);
   }

   public int getWidthMode() {
      return MeasureSpec.getMode(this.mWidthSpec);
   }

   boolean hasFlexibleChildInBothOrientations() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         LayoutParams var3 = this.getChildAt(var1).getLayoutParams();
         if(var3.width < 0 && var3.height < 0) {
            return true;
         }
      }

      return false;
   }

   public boolean hasFocus() {
      return this.mRecyclerView != null && this.mRecyclerView.hasFocus();
   }

   public void ignoreView(View var1) {
      if(var1.getParent() == this.mRecyclerView && this.mRecyclerView.indexOfChild(var1) != -1) {
         RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         var2.addFlags(128);
         this.mRecyclerView.mViewInfoStore.removeViewHolder(var2);
      } else {
         throw new IllegalArgumentException("View should be fully attached to be ignored");
      }
   }

   public boolean isAttachedToWindow() {
      return this.mIsAttachedToWindow;
   }

   public boolean isAutoMeasureEnabled() {
      return this.mAutoMeasure;
   }

   public boolean isFocused() {
      return this.mRecyclerView != null && this.mRecyclerView.isFocused();
   }

   public boolean isLayoutHierarchical(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return false;
   }

   public boolean isMeasurementCacheEnabled() {
      return this.mMeasurementCacheEnabled;
   }

   public boolean isSmoothScrolling() {
      return this.mSmoothScroller != null && this.mSmoothScroller.isRunning();
   }

   public void layoutDecorated(View var1, int var2, int var3, int var4, int var5) {
      Rect var6 = ((RecyclerView$LayoutParams)var1.getLayoutParams()).mDecorInsets;
      var1.layout(var6.left + var2, var6.top + var3, var4 - var6.right, var5 - var6.bottom);
   }

   public void measureChild(View var1, int var2, int var3) {
      RecyclerView$LayoutParams var8 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      Rect var9 = this.mRecyclerView.getItemDecorInsetsForChild(var1);
      int var6 = var9.left;
      int var7 = var9.right;
      int var4 = var9.top;
      int var5 = var9.bottom;
      var2 = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + var2 + var6 + var7, var8.width, this.canScrollHorizontally());
      var3 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + var3 + var4 + var5, var8.height, this.canScrollVertically());
      if(this.shouldMeasureChild(var1, var2, var3, var8)) {
         var1.measure(var2, var3);
      }

   }

   public void measureChildWithMargins(View var1, int var2, int var3) {
      RecyclerView$LayoutParams var8 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      Rect var9 = this.mRecyclerView.getItemDecorInsetsForChild(var1);
      int var6 = var9.left;
      int var7 = var9.right;
      int var4 = var9.top;
      int var5 = var9.bottom;
      var2 = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + var8.leftMargin + var8.rightMargin + var2 + var6 + var7, var8.width, this.canScrollHorizontally());
      var3 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + var8.topMargin + var8.bottomMargin + var3 + var4 + var5, var8.height, this.canScrollVertically());
      if(this.shouldMeasureChild(var1, var2, var3, var8)) {
         var1.measure(var2, var3);
      }

   }

   public void moveView(int var1, int var2) {
      View var3 = this.getChildAt(var1);
      if(var3 == null) {
         throw new IllegalArgumentException("Cannot move a child from non-existing index:" + var1);
      } else {
         this.detachViewAt(var1);
         this.attachView(var3, var2);
      }
   }

   public void offsetChildrenHorizontal(int var1) {
      if(this.mRecyclerView != null) {
         this.mRecyclerView.offsetChildrenHorizontal(var1);
      }

   }

   public void offsetChildrenVertical(int var1) {
      if(this.mRecyclerView != null) {
         this.mRecyclerView.offsetChildrenVertical(var1);
      }

   }

   public void onAdapterChanged(RecyclerView$Adapter var1, RecyclerView$Adapter var2) {
   }

   public boolean onAddFocusables(RecyclerView var1, ArrayList<View> var2, int var3, int var4) {
      return false;
   }

   @CallSuper
   public void onAttachedToWindow(RecyclerView var1) {
   }

   @Deprecated
   public void onDetachedFromWindow(RecyclerView var1) {
   }

   @CallSuper
   public void onDetachedFromWindow(RecyclerView var1, RecyclerView$Recycler var2) {
      this.onDetachedFromWindow(var1);
   }

   @Nullable
   public View onFocusSearchFailed(View var1, int var2, RecyclerView$Recycler var3, RecyclerView$State var4) {
      return null;
   }

   public void onInitializeAccessibilityEvent(RecyclerView$Recycler var1, RecyclerView$State var2, AccessibilityEvent var3) {
      boolean var5 = true;
      AccessibilityRecordCompat var6 = AccessibilityEventCompat.asRecord(var3);
      if(this.mRecyclerView != null && var6 != null) {
         boolean var4 = var5;
         if(!ViewCompat.canScrollVertically(this.mRecyclerView, 1)) {
            var4 = var5;
            if(!ViewCompat.canScrollVertically(this.mRecyclerView, -1)) {
               var4 = var5;
               if(!ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
                  if(ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
                     var4 = var5;
                  } else {
                     var4 = false;
                  }
               }
            }
         }

         var6.setScrollable(var4);
         if(RecyclerView.access$3100(this.mRecyclerView) != null) {
            var6.setItemCount(RecyclerView.access$3100(this.mRecyclerView).getItemCount());
            return;
         }
      }

   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      this.onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1);
   }

   void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat var1) {
      this.onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1);
   }

   public void onInitializeAccessibilityNodeInfo(RecyclerView$Recycler var1, RecyclerView$State var2, AccessibilityNodeInfoCompat var3) {
      if(ViewCompat.canScrollVertically(this.mRecyclerView, -1) || ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
         var3.addAction(8192);
         var3.setScrollable(true);
      }

      if(ViewCompat.canScrollVertically(this.mRecyclerView, 1) || ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
         var3.addAction(4096);
         var3.setScrollable(true);
      }

      var3.setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(this.getRowCountForAccessibility(var1, var2), this.getColumnCountForAccessibility(var1, var2), this.isLayoutHierarchical(var1, var2), this.getSelectionModeForAccessibility(var1, var2)));
   }

   public void onInitializeAccessibilityNodeInfoForItem(RecyclerView$Recycler var1, RecyclerView$State var2, View var3, AccessibilityNodeInfoCompat var4) {
      int var5;
      if(this.canScrollVertically()) {
         var5 = this.getPosition(var3);
      } else {
         var5 = 0;
      }

      int var6;
      if(this.canScrollHorizontally()) {
         var6 = this.getPosition(var3);
      } else {
         var6 = 0;
      }

      var4.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(var5, 1, var6, 1, false, false));
   }

   void onInitializeAccessibilityNodeInfoForItem(View var1, AccessibilityNodeInfoCompat var2) {
      RecyclerView$ViewHolder var3 = RecyclerView.getChildViewHolderInt(var1);
      if(var3 != null && !var3.isRemoved() && !this.mChildHelper.isHidden(var3.itemView)) {
         this.onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1, var2);
      }

   }

   public View onInterceptFocusSearch(View var1, int var2) {
      return null;
   }

   public void onItemsAdded(RecyclerView var1, int var2, int var3) {
   }

   public void onItemsChanged(RecyclerView var1) {
   }

   public void onItemsMoved(RecyclerView var1, int var2, int var3, int var4) {
   }

   public void onItemsRemoved(RecyclerView var1, int var2, int var3) {
   }

   public void onItemsUpdated(RecyclerView var1, int var2, int var3) {
   }

   public void onItemsUpdated(RecyclerView var1, int var2, int var3, Object var4) {
      this.onItemsUpdated(var1, var2, var3);
   }

   public void onLayoutChildren(RecyclerView$Recycler var1, RecyclerView$State var2) {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
   }

   public void onMeasure(RecyclerView$Recycler var1, RecyclerView$State var2, int var3, int var4) {
      this.mRecyclerView.defaultOnMeasure(var3, var4);
   }

   public boolean onRequestChildFocus(RecyclerView var1, RecyclerView$State var2, View var3, View var4) {
      return this.onRequestChildFocus(var1, var3, var4);
   }

   @Deprecated
   public boolean onRequestChildFocus(RecyclerView var1, View var2, View var3) {
      return this.isSmoothScrolling() || var1.isComputingLayout();
   }

   public void onRestoreInstanceState(Parcelable var1) {
   }

   public Parcelable onSaveInstanceState() {
      return null;
   }

   public void onScrollStateChanged(int var1) {
   }

   boolean performAccessibilityAction(int var1, Bundle var2) {
      return this.performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1, var2);
   }

   public boolean performAccessibilityAction(RecyclerView$Recycler var1, RecyclerView$State var2, int var3, Bundle var4) {
      if(this.mRecyclerView != null) {
         byte var7 = 0;
         byte var8 = 0;
         byte var5 = 0;
         int var6 = 0;
         int var9;
         switch(var3) {
         case 4096:
            var9 = var8;
            if(ViewCompat.canScrollVertically(this.mRecyclerView, 1)) {
               var9 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            }

            var3 = var9;
            if(ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
               var6 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
               var3 = var9;
            }
            break;
         case 8192:
            var9 = var7;
            if(ViewCompat.canScrollVertically(this.mRecyclerView, -1)) {
               var9 = -(this.getHeight() - this.getPaddingTop() - this.getPaddingBottom());
            }

            var3 = var9;
            if(ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
               var6 = -(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
               var3 = var9;
            }
            break;
         default:
            var3 = var5;
         }

         if(var3 != 0 || var6 != 0) {
            this.mRecyclerView.scrollBy(var6, var3);
            return true;
         }
      }

      return false;
   }

   public boolean performAccessibilityActionForItem(RecyclerView$Recycler var1, RecyclerView$State var2, View var3, int var4, Bundle var5) {
      return false;
   }

   boolean performAccessibilityActionForItem(View var1, int var2, Bundle var3) {
      return this.performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1, var2, var3);
   }

   public void postOnAnimation(Runnable var1) {
      if(this.mRecyclerView != null) {
         ViewCompat.postOnAnimation(this.mRecyclerView, var1);
      }

   }

   public void removeAllViews() {
      for(int var1 = this.getChildCount() - 1; var1 >= 0; --var1) {
         this.mChildHelper.removeViewAt(var1);
      }

   }

   public void removeAndRecycleAllViews(RecyclerView$Recycler var1) {
      for(int var2 = this.getChildCount() - 1; var2 >= 0; --var2) {
         if(!RecyclerView.getChildViewHolderInt(this.getChildAt(var2)).shouldIgnore()) {
            this.removeAndRecycleViewAt(var2, var1);
         }
      }

   }

   void removeAndRecycleScrapInt(RecyclerView$Recycler var1) {
      int var3 = var1.getScrapCount();

      for(int var2 = var3 - 1; var2 >= 0; --var2) {
         View var4 = var1.getScrapViewAt(var2);
         RecyclerView$ViewHolder var5 = RecyclerView.getChildViewHolderInt(var4);
         if(!var5.shouldIgnore()) {
            var5.setIsRecyclable(false);
            if(var5.isTmpDetached()) {
               this.mRecyclerView.removeDetachedView(var4, false);
            }

            if(this.mRecyclerView.mItemAnimator != null) {
               this.mRecyclerView.mItemAnimator.endAnimation(var5);
            }

            var5.setIsRecyclable(true);
            var1.quickRecycleScrapView(var4);
         }
      }

      var1.clearScrap();
      if(var3 > 0) {
         this.mRecyclerView.invalidate();
      }

   }

   public void removeAndRecycleView(View var1, RecyclerView$Recycler var2) {
      this.removeView(var1);
      var2.recycleView(var1);
   }

   public void removeAndRecycleViewAt(int var1, RecyclerView$Recycler var2) {
      View var3 = this.getChildAt(var1);
      this.removeViewAt(var1);
      var2.recycleView(var3);
   }

   public boolean removeCallbacks(Runnable var1) {
      return this.mRecyclerView != null?this.mRecyclerView.removeCallbacks(var1):false;
   }

   public void removeDetachedView(View var1) {
      this.mRecyclerView.removeDetachedView(var1, false);
   }

   public void removeView(View var1) {
      this.mChildHelper.removeView(var1);
   }

   public void removeViewAt(int var1) {
      if(this.getChildAt(var1) != null) {
         this.mChildHelper.removeViewAt(var1);
      }

   }

   public boolean requestChildRectangleOnScreen(RecyclerView var1, View var2, Rect var3, boolean var4) {
      int var11 = this.getPaddingLeft();
      int var8 = this.getPaddingTop();
      int var12 = this.getWidth() - this.getPaddingRight();
      int var10 = this.getHeight();
      int var15 = this.getPaddingBottom();
      int var13 = var2.getLeft() + var3.left - var2.getScrollX();
      int var9 = var2.getTop() + var3.top - var2.getScrollY();
      int var14 = var13 + var3.width();
      int var16 = var3.height();
      int var5 = Math.min(0, var13 - var11);
      int var6 = Math.min(0, var9 - var8);
      int var7 = Math.max(0, var14 - var12);
      var10 = Math.max(0, var9 + var16 - (var10 - var15));
      if(this.getLayoutDirection() == 1) {
         if(var7 != 0) {
            var5 = var7;
         } else {
            var5 = Math.max(var5, var14 - var12);
         }
      } else if(var5 == 0) {
         var5 = Math.min(var13 - var11, var7);
      }

      if(var6 == 0) {
         var6 = Math.min(var9 - var8, var10);
      }

      if(var5 == 0 && var6 == 0) {
         return false;
      } else {
         if(var4) {
            var1.scrollBy(var5, var6);
         } else {
            var1.smoothScrollBy(var5, var6);
         }

         return true;
      }
   }

   public void requestLayout() {
      if(this.mRecyclerView != null) {
         this.mRecyclerView.requestLayout();
      }

   }

   public void requestSimpleAnimationsInNextLayout() {
      this.mRequestedSimpleAnimations = true;
   }

   public int scrollHorizontallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      return 0;
   }

   public void scrollToPosition(int var1) {
   }

   public int scrollVerticallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      return 0;
   }

   public void setAutoMeasureEnabled(boolean var1) {
      this.mAutoMeasure = var1;
   }

   void setExactMeasureSpecsFrom(RecyclerView var1) {
      this.setMeasureSpecs(MeasureSpec.makeMeasureSpec(var1.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(var1.getHeight(), 1073741824));
   }

   void setMeasureSpecs(int var1, int var2) {
      this.mWidthSpec = var1;
      this.mHeightSpec = var2;
   }

   public void setMeasuredDimension(int var1, int var2) {
      RecyclerView.access$5600(this.mRecyclerView, var1, var2);
   }

   public void setMeasuredDimension(Rect var1, int var2, int var3) {
      int var4 = var1.width();
      int var5 = this.getPaddingLeft();
      int var6 = this.getPaddingRight();
      int var7 = var1.height();
      int var8 = this.getPaddingTop();
      int var9 = this.getPaddingBottom();
      this.setMeasuredDimension(chooseSize(var2, var4 + var5 + var6, this.getMinimumWidth()), chooseSize(var3, var7 + var8 + var9, this.getMinimumHeight()));
   }

   void setMeasuredDimensionFromChildren(int var1, int var2) {
      int var13 = this.getChildCount();
      if(var13 == 0) {
         this.mRecyclerView.defaultOnMeasure(var1, var2);
      } else {
         int var8 = Integer.MAX_VALUE;
         int var4 = Integer.MAX_VALUE;
         int var7 = Integer.MIN_VALUE;
         int var3 = Integer.MIN_VALUE;

         int var9;
         for(int var5 = 0; var5 < var13; var4 = var9) {
            View var14 = this.getChildAt(var5);
            RecyclerView$LayoutParams var15 = (RecyclerView$LayoutParams)var14.getLayoutParams();
            int var12 = this.getDecoratedLeft(var14) - var15.leftMargin;
            var9 = this.getDecoratedRight(var14) + var15.rightMargin;
            int var11 = this.getDecoratedTop(var14) - var15.topMargin;
            int var10 = this.getDecoratedBottom(var14) + var15.bottomMargin;
            int var6 = var8;
            if(var12 < var8) {
               var6 = var12;
            }

            var8 = var7;
            if(var9 > var7) {
               var8 = var9;
            }

            var9 = var4;
            if(var11 < var4) {
               var9 = var11;
            }

            var4 = var3;
            if(var10 > var3) {
               var4 = var10;
            }

            ++var5;
            var7 = var8;
            var3 = var4;
            var8 = var6;
         }

         RecyclerView.access$5400(this.mRecyclerView).set(var8, var4, var7, var3);
         this.setMeasuredDimension(RecyclerView.access$5400(this.mRecyclerView), var1, var2);
      }
   }

   public void setMeasurementCacheEnabled(boolean var1) {
      this.mMeasurementCacheEnabled = var1;
   }

   void setRecyclerView(RecyclerView var1) {
      if(var1 == null) {
         this.mRecyclerView = null;
         this.mChildHelper = null;
         this.mWidthSpec = MeasureSpec.makeMeasureSpec(0, 1073741824);
         this.mHeightSpec = MeasureSpec.makeMeasureSpec(0, 1073741824);
      } else {
         this.mRecyclerView = var1;
         this.mChildHelper = var1.mChildHelper;
         this.mWidthSpec = MeasureSpec.makeMeasureSpec(var1.getWidth(), 1073741824);
         this.mHeightSpec = MeasureSpec.makeMeasureSpec(var1.getHeight(), 1073741824);
      }
   }

   boolean shouldMeasureChild(View var1, int var2, int var3, RecyclerView$LayoutParams var4) {
      return var1.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(var1.getWidth(), var2, var4.width) || !isMeasurementUpToDate(var1.getHeight(), var3, var4.height);
   }

   boolean shouldMeasureTwice() {
      return false;
   }

   boolean shouldReMeasureChild(View var1, int var2, int var3, RecyclerView$LayoutParams var4) {
      return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(var1.getMeasuredWidth(), var2, var4.width) || !isMeasurementUpToDate(var1.getMeasuredHeight(), var3, var4.height);
   }

   public void smoothScrollToPosition(RecyclerView var1, RecyclerView$State var2, int var3) {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
   }

   public void startSmoothScroll(RecyclerView$SmoothScroller var1) {
      if(this.mSmoothScroller != null && var1 != this.mSmoothScroller && this.mSmoothScroller.isRunning()) {
         this.mSmoothScroller.stop();
      }

      this.mSmoothScroller = var1;
      this.mSmoothScroller.start(this.mRecyclerView, this);
   }

   public void stopIgnoringView(View var1) {
      RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
      var2.stopIgnoring();
      var2.resetInternal();
      var2.addFlags(4);
   }

   void stopSmoothScroller() {
      if(this.mSmoothScroller != null) {
         this.mSmoothScroller.stop();
      }

   }

   public boolean supportsPredictiveItemAnimations() {
      return false;
   }
}
