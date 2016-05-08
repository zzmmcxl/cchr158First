package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LayoutState;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$LayoutManager$Properties;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.ScrollbarHelper;
import android.support.v7.widget.StaggeredGridLayoutManager$1;
import android.support.v7.widget.StaggeredGridLayoutManager$2;
import android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo;
import android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.StaggeredGridLayoutManager$SavedState;
import android.support.v7.widget.StaggeredGridLayoutManager$Span;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.BitSet;

public class StaggeredGridLayoutManager extends RecyclerView$LayoutManager {
   private static final boolean DEBUG = false;
   @Deprecated
   public static final int GAP_HANDLING_LAZY = 1;
   public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
   public static final int GAP_HANDLING_NONE = 0;
   public static final int HORIZONTAL = 0;
   private static final int INVALID_OFFSET = Integer.MIN_VALUE;
   private static final float MAX_SCROLL_FACTOR = 0.33333334F;
   public static final String TAG = "StaggeredGridLayoutManager";
   public static final int VERTICAL = 1;
   private final StaggeredGridLayoutManager$AnchorInfo mAnchorInfo;
   private final Runnable mCheckForGapsRunnable;
   private int mFullSizeSpec;
   private int mGapStrategy;
   private boolean mLaidOutInvalidFullSpan;
   private boolean mLastLayoutFromEnd;
   private boolean mLastLayoutRTL;
   private LayoutState mLayoutState;
   StaggeredGridLayoutManager$LazySpanLookup mLazySpanLookup;
   private int mOrientation;
   private StaggeredGridLayoutManager$SavedState mPendingSavedState;
   int mPendingScrollPosition;
   int mPendingScrollPositionOffset;
   OrientationHelper mPrimaryOrientation;
   private BitSet mRemainingSpans;
   private boolean mReverseLayout;
   OrientationHelper mSecondaryOrientation;
   boolean mShouldReverseLayout;
   private int mSizePerSpan;
   private boolean mSmoothScrollbarEnabled;
   private int mSpanCount;
   private StaggeredGridLayoutManager$Span[] mSpans;
   private final Rect mTmpRect;

   public StaggeredGridLayoutManager(int var1, int var2) {
      boolean var3 = true;
      super();
      this.mSpanCount = -1;
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mLazySpanLookup = new StaggeredGridLayoutManager$LazySpanLookup();
      this.mGapStrategy = 2;
      this.mTmpRect = new Rect();
      this.mAnchorInfo = new StaggeredGridLayoutManager$AnchorInfo(this, (StaggeredGridLayoutManager$1)null);
      this.mLaidOutInvalidFullSpan = false;
      this.mSmoothScrollbarEnabled = true;
      this.mCheckForGapsRunnable = new StaggeredGridLayoutManager$1(this);
      this.mOrientation = var2;
      this.setSpanCount(var1);
      if(this.mGapStrategy == 0) {
         var3 = false;
      }

      this.setAutoMeasureEnabled(var3);
   }

   public StaggeredGridLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      boolean var5 = true;
      super();
      this.mSpanCount = -1;
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mLazySpanLookup = new StaggeredGridLayoutManager$LazySpanLookup();
      this.mGapStrategy = 2;
      this.mTmpRect = new Rect();
      this.mAnchorInfo = new StaggeredGridLayoutManager$AnchorInfo(this, (StaggeredGridLayoutManager$1)null);
      this.mLaidOutInvalidFullSpan = false;
      this.mSmoothScrollbarEnabled = true;
      this.mCheckForGapsRunnable = new StaggeredGridLayoutManager$1(this);
      RecyclerView$LayoutManager$Properties var6 = getProperties(var1, var2, var3, var4);
      this.setOrientation(var6.orientation);
      this.setSpanCount(var6.spanCount);
      this.setReverseLayout(var6.reverseLayout);
      if(this.mGapStrategy == 0) {
         var5 = false;
      }

      this.setAutoMeasureEnabled(var5);
   }

   private void appendViewToAllSpans(View var1) {
      for(int var2 = this.mSpanCount - 1; var2 >= 0; --var2) {
         this.mSpans[var2].appendToSpan(var1);
      }

   }

   private void applyPendingSavedState(StaggeredGridLayoutManager$AnchorInfo var1) {
      if(this.mPendingSavedState.mSpanOffsetsSize > 0) {
         if(this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount) {
            for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
               this.mSpans[var3].clear();
               int var4 = this.mPendingSavedState.mSpanOffsets[var3];
               int var2 = var4;
               if(var4 != Integer.MIN_VALUE) {
                  if(this.mPendingSavedState.mAnchorLayoutFromEnd) {
                     var2 = var4 + this.mPrimaryOrientation.getEndAfterPadding();
                  } else {
                     var2 = var4 + this.mPrimaryOrientation.getStartAfterPadding();
                  }
               }

               this.mSpans[var3].setLine(var2);
            }
         } else {
            this.mPendingSavedState.invalidateSpanInfo();
            this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
         }
      }

      this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
      this.setReverseLayout(this.mPendingSavedState.mReverseLayout);
      this.resolveShouldLayoutReverse();
      if(this.mPendingSavedState.mAnchorPosition != -1) {
         this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
         var1.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
      } else {
         var1.mLayoutFromEnd = this.mShouldReverseLayout;
      }

      if(this.mPendingSavedState.mSpanLookupSize > 1) {
         this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
         this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
      }

   }

   private void attachViewToSpans(View var1, StaggeredGridLayoutManager$LayoutParams var2, LayoutState var3) {
      if(var3.mLayoutDirection == 1) {
         if(var2.mFullSpan) {
            this.appendViewToAllSpans(var1);
         } else {
            var2.mSpan.appendToSpan(var1);
         }
      } else if(var2.mFullSpan) {
         this.prependViewToAllSpans(var1);
      } else {
         var2.mSpan.prependToSpan(var1);
      }
   }

   private int calculateScrollDirectionForPosition(int var1) {
      byte var2 = -1;
      if(this.getChildCount() == 0) {
         return this.mShouldReverseLayout?1:-1;
      } else {
         boolean var3;
         if(var1 < this.getFirstChildPosition()) {
            var3 = true;
         } else {
            var3 = false;
         }

         byte var4;
         if(var3 != this.mShouldReverseLayout) {
            var4 = var2;
         } else {
            var4 = 1;
         }

         return var4;
      }
   }

   private boolean checkForGaps() {
      if(this.getChildCount() != 0 && this.mGapStrategy != 0 && this.isAttachedToWindow()) {
         int var1;
         int var2;
         if(this.mShouldReverseLayout) {
            var2 = this.getLastChildPosition();
            var1 = this.getFirstChildPosition();
         } else {
            var2 = this.getFirstChildPosition();
            var1 = this.getLastChildPosition();
         }

         if(var2 == 0 && this.hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            this.requestSimpleAnimationsInNextLayout();
            this.requestLayout();
            return true;
         } else if(!this.mLaidOutInvalidFullSpan) {
            return false;
         } else {
            byte var3;
            if(this.mShouldReverseLayout) {
               var3 = -1;
            } else {
               var3 = 1;
            }

            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var4 = this.mLazySpanLookup.getFirstFullSpanItemInRange(var2, var1 + 1, var3, true);
            if(var4 == null) {
               this.mLaidOutInvalidFullSpan = false;
               this.mLazySpanLookup.forceInvalidateAfter(var1 + 1);
               return false;
            } else {
               StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var5 = this.mLazySpanLookup.getFirstFullSpanItemInRange(var2, var4.mPosition, var3 * -1, true);
               if(var5 == null) {
                  this.mLazySpanLookup.forceInvalidateAfter(var4.mPosition);
               } else {
                  this.mLazySpanLookup.forceInvalidateAfter(var5.mPosition + 1);
               }

               this.requestSimpleAnimationsInNextLayout();
               this.requestLayout();
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean checkSpanForGap(StaggeredGridLayoutManager$Span var1) {
      if(this.mShouldReverseLayout) {
         if(var1.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
            if(var1.getLayoutParams((View)StaggeredGridLayoutManager$Span.access$200(var1).get(StaggeredGridLayoutManager$Span.access$200(var1).size() - 1)).mFullSpan) {
               return false;
            }

            return true;
         }
      } else if(var1.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
         if(var1.getLayoutParams((View)StaggeredGridLayoutManager$Span.access$200(var1).get(0)).mFullSpan) {
            return false;
         }

         return true;
      }

      return false;
   }

   private int computeScrollExtent(RecyclerView$State var1) {
      boolean var3 = false;
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureOrientationHelper();
         OrientationHelper var4 = this.mPrimaryOrientation;
         boolean var2;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var5 = this.findFirstVisibleItemClosestToStart(var2, true);
         var2 = var3;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         }

         return ScrollbarHelper.computeScrollExtent(var1, var4, var5, this.findFirstVisibleItemClosestToEnd(var2, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private int computeScrollOffset(RecyclerView$State var1) {
      boolean var3 = false;
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureOrientationHelper();
         OrientationHelper var4 = this.mPrimaryOrientation;
         boolean var2;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var5 = this.findFirstVisibleItemClosestToStart(var2, true);
         var2 = var3;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         }

         return ScrollbarHelper.computeScrollOffset(var1, var4, var5, this.findFirstVisibleItemClosestToEnd(var2, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
      }
   }

   private int computeScrollRange(RecyclerView$State var1) {
      boolean var3 = false;
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureOrientationHelper();
         OrientationHelper var4 = this.mPrimaryOrientation;
         boolean var2;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var5 = this.findFirstVisibleItemClosestToStart(var2, true);
         var2 = var3;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         }

         return ScrollbarHelper.computeScrollRange(var1, var4, var5, this.findFirstVisibleItemClosestToEnd(var2, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private int convertFocusDirectionToLayoutDirection(int var1) {
      byte var3 = -1;
      byte var4 = 1;
      int var5 = Integer.MIN_VALUE;
      int var2 = var3;
      switch(var1) {
      case 1:
         break;
      case 2:
         return 1;
      case 17:
         var2 = var3;
         if(this.mOrientation != 0) {
            return Integer.MIN_VALUE;
         }
         break;
      case 33:
         var2 = var3;
         if(this.mOrientation != 1) {
            return Integer.MIN_VALUE;
         }
         break;
      case 66:
         if(this.mOrientation == 0) {
            var1 = var4;
         } else {
            var1 = Integer.MIN_VALUE;
         }

         return var1;
      case 130:
         var1 = var5;
         if(this.mOrientation == 1) {
            var1 = 1;
         }

         return var1;
      default:
         var2 = Integer.MIN_VALUE;
      }

      return var2;
   }

   private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFullSpanItemFromEnd(int var1) {
      StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var3 = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
      var3.mGapPerSpan = new int[this.mSpanCount];

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var3.mGapPerSpan[var2] = var1 - this.mSpans[var2].getEndLine(var1);
      }

      return var3;
   }

   private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFullSpanItemFromStart(int var1) {
      StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var3 = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
      var3.mGapPerSpan = new int[this.mSpanCount];

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var3.mGapPerSpan[var2] = this.mSpans[var2].getStartLine(var1) - var1;
      }

      return var3;
   }

   private void ensureOrientationHelper() {
      if(this.mPrimaryOrientation == null) {
         this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
         this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
         this.mLayoutState = new LayoutState();
      }

   }

   private int fill(RecyclerView$Recycler var1, LayoutState var2, RecyclerView$State var3) {
      this.mRemainingSpans.set(0, this.mSpanCount, true);
      int var4;
      if(this.mLayoutState.mInfinite) {
         if(var2.mLayoutDirection == 1) {
            var4 = Integer.MAX_VALUE;
         } else {
            var4 = Integer.MIN_VALUE;
         }
      } else if(var2.mLayoutDirection == 1) {
         var4 = var2.mEndLine + var2.mAvailable;
      } else {
         var4 = var2.mStartLine - var2.mAvailable;
      }

      this.updateAllRemainingSpans(var2.mLayoutDirection, var4);
      int var6;
      if(this.mShouldReverseLayout) {
         var6 = this.mPrimaryOrientation.getEndAfterPadding();
      } else {
         var6 = this.mPrimaryOrientation.getStartAfterPadding();
      }

      boolean var5;
      for(var5 = false; var2.hasMore(var3) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty()); var5 = true) {
         View var13 = var2.next(var1);
         StaggeredGridLayoutManager$LayoutParams var14 = (StaggeredGridLayoutManager$LayoutParams)var13.getLayoutParams();
         int var11 = var14.getViewLayoutPosition();
         int var16 = this.mLazySpanLookup.getSpan(var11);
         boolean var9;
         if(var16 == -1) {
            var9 = true;
         } else {
            var9 = false;
         }

         StaggeredGridLayoutManager$Span var12;
         if(var9) {
            if(var14.mFullSpan) {
               var12 = this.mSpans[0];
            } else {
               var12 = this.getNextSpan(var2);
            }

            this.mLazySpanLookup.setSpan(var11, var12);
         } else {
            var12 = this.mSpans[var16];
         }

         var14.mSpan = var12;
         if(var2.mLayoutDirection == 1) {
            this.addView(var13);
         } else {
            this.addView(var13, 0);
         }

         this.measureChildWithDecorationsAndMargin(var13, var14, false);
         int var7;
         int var8;
         int var10;
         StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var15;
         if(var2.mLayoutDirection == 1) {
            if(var14.mFullSpan) {
               var16 = this.getMaxEnd(var6);
            } else {
               var16 = var12.getEndLine(var6);
            }

            var10 = var16 + this.mPrimaryOrientation.getDecoratedMeasurement(var13);
            var7 = var16;
            var8 = var10;
            if(var9) {
               var7 = var16;
               var8 = var10;
               if(var14.mFullSpan) {
                  var15 = this.createFullSpanItemFromEnd(var16);
                  var15.mGapDir = -1;
                  var15.mPosition = var11;
                  this.mLazySpanLookup.addFullSpanItem(var15);
                  var8 = var10;
                  var7 = var16;
               }
            }
         } else {
            if(var14.mFullSpan) {
               var16 = this.getMinStart(var6);
            } else {
               var16 = var12.getStartLine(var6);
            }

            var10 = var16 - this.mPrimaryOrientation.getDecoratedMeasurement(var13);
            var7 = var10;
            var8 = var16;
            if(var9) {
               var7 = var10;
               var8 = var16;
               if(var14.mFullSpan) {
                  var15 = this.createFullSpanItemFromStart(var16);
                  var15.mGapDir = 1;
                  var15.mPosition = var11;
                  this.mLazySpanLookup.addFullSpanItem(var15);
                  var7 = var10;
                  var8 = var16;
               }
            }
         }

         if(var14.mFullSpan && var2.mItemDirection == -1) {
            if(var9) {
               this.mLaidOutInvalidFullSpan = true;
            } else {
               if(var2.mLayoutDirection == 1) {
                  if(!this.areAllEndsEqual()) {
                     var5 = true;
                  } else {
                     var5 = false;
                  }
               } else if(!this.areAllStartsEqual()) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               if(var5) {
                  var15 = this.mLazySpanLookup.getFullSpanItem(var11);
                  if(var15 != null) {
                     var15.mHasUnwantedGapAfter = true;
                  }

                  this.mLaidOutInvalidFullSpan = true;
               }
            }
         }

         this.attachViewToSpans(var13, var14, var2);
         int var17;
         if(this.isLayoutRTL() && this.mOrientation == 1) {
            if(var14.mFullSpan) {
               var16 = this.mSecondaryOrientation.getEndAfterPadding();
            } else {
               var16 = this.mSecondaryOrientation.getEndAfterPadding() - (this.mSpanCount - 1 - var12.mIndex) * this.mSizePerSpan;
            }

            var10 = var16 - this.mSecondaryOrientation.getDecoratedMeasurement(var13);
            var17 = var16;
            var16 = var10;
         } else {
            if(var14.mFullSpan) {
               var16 = this.mSecondaryOrientation.getStartAfterPadding();
            } else {
               var16 = var12.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
            }

            var17 = var16 + this.mSecondaryOrientation.getDecoratedMeasurement(var13);
         }

         if(this.mOrientation == 1) {
            this.layoutDecoratedWithMargins(var13, var16, var7, var17, var8);
         } else {
            this.layoutDecoratedWithMargins(var13, var7, var16, var8, var17);
         }

         if(var14.mFullSpan) {
            this.updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, var4);
         } else {
            this.updateRemainingSpans(var12, this.mLayoutState.mLayoutDirection, var4);
         }

         this.recycle(var1, this.mLayoutState);
         if(this.mLayoutState.mStopInFocusable && var13.isFocusable()) {
            if(var14.mFullSpan) {
               this.mRemainingSpans.clear();
            } else {
               this.mRemainingSpans.set(var12.mIndex, false);
            }
         }
      }

      if(!var5) {
         this.recycle(var1, this.mLayoutState);
      }

      if(this.mLayoutState.mLayoutDirection == -1) {
         var4 = this.getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
         var4 = this.mPrimaryOrientation.getStartAfterPadding() - var4;
      } else {
         var4 = this.getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
      }

      return var4 > 0?Math.min(var2.mAvailable, var4):0;
   }

   private int findFirstReferenceChildPosition(int var1) {
      int var3 = this.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         int var4 = this.getPosition(this.getChildAt(var2));
         if(var4 >= 0 && var4 < var1) {
            return var4;
         }
      }

      return 0;
   }

   private int findLastReferenceChildPosition(int var1) {
      for(int var2 = this.getChildCount() - 1; var2 >= 0; --var2) {
         int var3 = this.getPosition(this.getChildAt(var2));
         if(var3 >= 0 && var3 < var1) {
            return var3;
         }
      }

      return 0;
   }

   private void fixEndGap(RecyclerView$Recycler var1, RecyclerView$State var2, boolean var3) {
      int var4 = this.getMaxEnd(Integer.MIN_VALUE);
      if(var4 != Integer.MIN_VALUE) {
         var4 = this.mPrimaryOrientation.getEndAfterPadding() - var4;
         if(var4 > 0) {
            var4 -= -this.scrollBy(-var4, var1, var2);
            if(var3 && var4 > 0) {
               this.mPrimaryOrientation.offsetChildren(var4);
               return;
            }
         }
      }

   }

   private void fixStartGap(RecyclerView$Recycler var1, RecyclerView$State var2, boolean var3) {
      int var4 = this.getMinStart(Integer.MAX_VALUE);
      if(var4 != Integer.MAX_VALUE) {
         var4 -= this.mPrimaryOrientation.getStartAfterPadding();
         if(var4 > 0) {
            var4 -= this.scrollBy(var4, var1, var2);
            if(var3 && var4 > 0) {
               this.mPrimaryOrientation.offsetChildren(-var4);
               return;
            }
         }
      }

   }

   private int getFirstChildPosition() {
      return this.getChildCount() == 0?0:this.getPosition(this.getChildAt(0));
   }

   private int getLastChildPosition() {
      int var1 = this.getChildCount();
      return var1 == 0?0:this.getPosition(this.getChildAt(var1 - 1));
   }

   private int getMaxEnd(int var1) {
      int var3 = this.mSpans[0].getEndLine(var1);

      int var4;
      for(int var2 = 1; var2 < this.mSpanCount; var3 = var4) {
         int var5 = this.mSpans[var2].getEndLine(var1);
         var4 = var3;
         if(var5 > var3) {
            var4 = var5;
         }

         ++var2;
      }

      return var3;
   }

   private int getMaxStart(int var1) {
      int var3 = this.mSpans[0].getStartLine(var1);

      int var4;
      for(int var2 = 1; var2 < this.mSpanCount; var3 = var4) {
         int var5 = this.mSpans[var2].getStartLine(var1);
         var4 = var3;
         if(var5 > var3) {
            var4 = var5;
         }

         ++var2;
      }

      return var3;
   }

   private int getMinEnd(int var1) {
      int var3 = this.mSpans[0].getEndLine(var1);

      int var4;
      for(int var2 = 1; var2 < this.mSpanCount; var3 = var4) {
         int var5 = this.mSpans[var2].getEndLine(var1);
         var4 = var3;
         if(var5 < var3) {
            var4 = var5;
         }

         ++var2;
      }

      return var3;
   }

   private int getMinStart(int var1) {
      int var3 = this.mSpans[0].getStartLine(var1);

      int var4;
      for(int var2 = 1; var2 < this.mSpanCount; var3 = var4) {
         int var5 = this.mSpans[var2].getStartLine(var1);
         var4 = var3;
         if(var5 < var3) {
            var4 = var5;
         }

         ++var2;
      }

      return var3;
   }

   private StaggeredGridLayoutManager$Span getNextSpan(LayoutState var1) {
      int var2;
      byte var3;
      int var4;
      if(this.preferLastSpan(var1.mLayoutDirection)) {
         var2 = this.mSpanCount - 1;
         var4 = -1;
         var3 = -1;
      } else {
         var2 = 0;
         var4 = this.mSpanCount;
         var3 = 1;
      }

      int var5;
      int var6;
      int var7;
      int var8;
      StaggeredGridLayoutManager$Span var9;
      StaggeredGridLayoutManager$Span var10;
      if(var1.mLayoutDirection == 1) {
         var10 = null;
         var5 = Integer.MAX_VALUE;
         var8 = this.mPrimaryOrientation.getStartAfterPadding();

         while(true) {
            var9 = var10;
            if(var2 == var4) {
               break;
            }

            var9 = this.mSpans[var2];
            var7 = var9.getEndLine(var8);
            var6 = var5;
            if(var7 < var5) {
               var10 = var9;
               var6 = var7;
            }

            var2 += var3;
            var5 = var6;
         }
      } else {
         var10 = null;
         var5 = Integer.MIN_VALUE;

         for(var8 = this.mPrimaryOrientation.getEndAfterPadding(); var2 != var4; var5 = var6) {
            var9 = this.mSpans[var2];
            var7 = var9.getStartLine(var8);
            var6 = var5;
            if(var7 > var5) {
               var10 = var9;
               var6 = var7;
            }

            var2 += var3;
         }

         var9 = var10;
      }

      return var9;
   }

   private void handleUpdate(int var1, int var2, int var3) {
      int var6;
      if(this.mShouldReverseLayout) {
         var6 = this.getLastChildPosition();
      } else {
         var6 = this.getFirstChildPosition();
      }

      int var4;
      int var5;
      if(var3 == 8) {
         if(var1 < var2) {
            var5 = var2 + 1;
            var4 = var1;
         } else {
            var5 = var1 + 1;
            var4 = var2;
         }
      } else {
         var4 = var1;
         var5 = var1 + var2;
      }

      this.mLazySpanLookup.invalidateAfter(var4);
      switch(var3) {
      case 1:
         this.mLazySpanLookup.offsetForAddition(var1, var2);
         break;
      case 2:
         this.mLazySpanLookup.offsetForRemoval(var1, var2);
         break;
      case 8:
         this.mLazySpanLookup.offsetForRemoval(var1, 1);
         this.mLazySpanLookup.offsetForAddition(var2, 1);
      }

      if(var5 > var6) {
         if(this.mShouldReverseLayout) {
            var1 = this.getFirstChildPosition();
         } else {
            var1 = this.getLastChildPosition();
         }

         if(var4 <= var1) {
            this.requestLayout();
            return;
         }
      }

   }

   private void layoutDecoratedWithMargins(View var1, int var2, int var3, int var4, int var5) {
      StaggeredGridLayoutManager$LayoutParams var6 = (StaggeredGridLayoutManager$LayoutParams)var1.getLayoutParams();
      this.layoutDecorated(var1, var2 + var6.leftMargin, var3 + var6.topMargin, var4 - var6.rightMargin, var5 - var6.bottomMargin);
   }

   private void measureChildWithDecorationsAndMargin(View var1, int var2, int var3, boolean var4) {
      this.calculateItemDecorationsForChild(var1, this.mTmpRect);
      StaggeredGridLayoutManager$LayoutParams var5 = (StaggeredGridLayoutManager$LayoutParams)var1.getLayoutParams();
      var2 = this.updateSpecWithExtra(var2, var5.leftMargin + this.mTmpRect.left, var5.rightMargin + this.mTmpRect.right);
      var3 = this.updateSpecWithExtra(var3, var5.topMargin + this.mTmpRect.top, var5.bottomMargin + this.mTmpRect.bottom);
      if(var4) {
         var4 = this.shouldReMeasureChild(var1, var2, var3, var5);
      } else {
         var4 = this.shouldMeasureChild(var1, var2, var3, var5);
      }

      if(var4) {
         var1.measure(var2, var3);
      }

   }

   private void measureChildWithDecorationsAndMargin(View var1, StaggeredGridLayoutManager$LayoutParams var2, boolean var3) {
      if(var2.mFullSpan) {
         if(this.mOrientation == 1) {
            this.measureChildWithDecorationsAndMargin(var1, this.mFullSizeSpec, getChildMeasureSpec(this.getHeight(), this.getHeightMode(), 0, var2.height, true), var3);
         } else {
            this.measureChildWithDecorationsAndMargin(var1, getChildMeasureSpec(this.getWidth(), this.getWidthMode(), 0, var2.width, true), this.mFullSizeSpec, var3);
         }
      } else if(this.mOrientation == 1) {
         this.measureChildWithDecorationsAndMargin(var1, getChildMeasureSpec(this.mSizePerSpan, this.getWidthMode(), 0, var2.width, false), getChildMeasureSpec(this.getHeight(), this.getHeightMode(), 0, var2.height, true), var3);
      } else {
         this.measureChildWithDecorationsAndMargin(var1, getChildMeasureSpec(this.getWidth(), this.getWidthMode(), 0, var2.width, true), getChildMeasureSpec(this.mSizePerSpan, this.getHeightMode(), 0, var2.height, false), var3);
      }
   }

   private void onLayoutChildren(RecyclerView$Recycler var1, RecyclerView$State var2, boolean var3) {
      boolean var6 = true;
      this.ensureOrientationHelper();
      StaggeredGridLayoutManager$AnchorInfo var8 = this.mAnchorInfo;
      var8.reset();
      if((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && var2.getItemCount() == 0) {
         this.removeAndRecycleAllViews(var1);
      } else {
         if(this.mPendingSavedState != null) {
            this.applyPendingSavedState(var8);
         } else {
            this.resolveShouldLayoutReverse();
            var8.mLayoutFromEnd = this.mShouldReverseLayout;
         }

         this.updateAnchorInfoForLayout(var2, var8);
         if(this.mPendingSavedState == null && (var8.mLayoutFromEnd != this.mLastLayoutFromEnd || this.isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            var8.mInvalidateOffsets = true;
         }

         if(this.getChildCount() > 0 && (this.mPendingSavedState == null || this.mPendingSavedState.mSpanOffsetsSize < 1)) {
            int var4;
            if(var8.mInvalidateOffsets) {
               for(var4 = 0; var4 < this.mSpanCount; ++var4) {
                  this.mSpans[var4].clear();
                  if(var8.mOffset != Integer.MIN_VALUE) {
                     this.mSpans[var4].setLine(var8.mOffset);
                  }
               }
            } else {
               for(var4 = 0; var4 < this.mSpanCount; ++var4) {
                  this.mSpans[var4].cacheReferenceLineAndClear(this.mShouldReverseLayout, var8.mOffset);
               }
            }
         }

         this.detachAndScrapAttachedViews(var1);
         this.mLayoutState.mRecycle = false;
         this.mLaidOutInvalidFullSpan = false;
         this.updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
         this.updateLayoutState(var8.mPosition, var2);
         if(var8.mLayoutFromEnd) {
            this.setLayoutStateDirection(-1);
            this.fill(var1, this.mLayoutState, var2);
            this.setLayoutStateDirection(1);
            this.mLayoutState.mCurrentPosition = var8.mPosition + this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2);
         } else {
            this.setLayoutStateDirection(1);
            this.fill(var1, this.mLayoutState, var2);
            this.setLayoutStateDirection(-1);
            this.mLayoutState.mCurrentPosition = var8.mPosition + this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2);
         }

         this.repositionToWrapContentIfNecessary();
         if(this.getChildCount() > 0) {
            if(this.mShouldReverseLayout) {
               this.fixEndGap(var1, var2, true);
               this.fixStartGap(var1, var2, false);
            } else {
               this.fixStartGap(var1, var2, true);
               this.fixEndGap(var1, var2, false);
            }
         }

         boolean var5 = false;
         boolean var7 = false;
         boolean var9 = var5;
         if(var3) {
            var9 = var5;
            if(!var2.isPreLayout()) {
               label70: {
                  if(this.mGapStrategy != 0 && this.getChildCount() > 0) {
                     var5 = var6;
                     if(this.mLaidOutInvalidFullSpan) {
                        break label70;
                     }

                     if(this.hasGapsToFix() != null) {
                        var5 = var6;
                        break label70;
                     }
                  }

                  var5 = false;
               }

               var9 = var7;
               if(var5) {
                  this.removeCallbacks(this.mCheckForGapsRunnable);
                  var9 = var7;
                  if(this.checkForGaps()) {
                     var9 = true;
                  }
               }

               this.mPendingScrollPosition = -1;
               this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            }
         }

         this.mLastLayoutFromEnd = var8.mLayoutFromEnd;
         this.mLastLayoutRTL = this.isLayoutRTL();
         this.mPendingSavedState = null;
         if(var9) {
            this.onLayoutChildren(var1, var2, false);
            return;
         }
      }

   }

   private boolean preferLastSpan(int var1) {
      boolean var2;
      if(this.mOrientation == 0) {
         if(var1 == -1) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(var2 == this.mShouldReverseLayout) {
            return false;
         }
      } else {
         if(var1 == -1) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(var2 == this.mShouldReverseLayout) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(var2 != this.isLayoutRTL()) {
            return false;
         }
      }

      return true;
   }

   private void prependViewToAllSpans(View var1) {
      for(int var2 = this.mSpanCount - 1; var2 >= 0; --var2) {
         this.mSpans[var2].prependToSpan(var1);
      }

   }

   private void recycle(RecyclerView$Recycler var1, LayoutState var2) {
      if(var2.mRecycle && !var2.mInfinite) {
         if(var2.mAvailable == 0) {
            if(var2.mLayoutDirection == -1) {
               this.recycleFromEnd(var1, var2.mEndLine);
            } else {
               this.recycleFromStart(var1, var2.mStartLine);
            }
         } else {
            int var3;
            if(var2.mLayoutDirection == -1) {
               var3 = var2.mStartLine - this.getMaxStart(var2.mStartLine);
               if(var3 < 0) {
                  var3 = var2.mEndLine;
               } else {
                  var3 = var2.mEndLine - Math.min(var3, var2.mAvailable);
               }

               this.recycleFromEnd(var1, var3);
            } else {
               var3 = this.getMinEnd(var2.mEndLine) - var2.mEndLine;
               if(var3 < 0) {
                  var3 = var2.mStartLine;
               } else {
                  var3 = var2.mStartLine + Math.min(var3, var2.mAvailable);
               }

               this.recycleFromStart(var1, var3);
            }
         }
      }
   }

   private void recycleFromEnd(RecyclerView$Recycler var1, int var2) {
      for(int var3 = this.getChildCount() - 1; var3 >= 0; --var3) {
         View var5 = this.getChildAt(var3);
         if(this.mPrimaryOrientation.getDecoratedStart(var5) < var2) {
            break;
         }

         StaggeredGridLayoutManager$LayoutParams var6 = (StaggeredGridLayoutManager$LayoutParams)var5.getLayoutParams();
         if(var6.mFullSpan) {
            int var4;
            for(var4 = 0; var4 < this.mSpanCount; ++var4) {
               if(StaggeredGridLayoutManager$Span.access$200(this.mSpans[var4]).size() == 1) {
                  return;
               }
            }

            for(var4 = 0; var4 < this.mSpanCount; ++var4) {
               this.mSpans[var4].popEnd();
            }
         } else {
            if(StaggeredGridLayoutManager$Span.access$200(var6.mSpan).size() == 1) {
               break;
            }

            var6.mSpan.popEnd();
         }

         this.removeAndRecycleView(var5, var1);
      }

   }

   private void recycleFromStart(RecyclerView$Recycler var1, int var2) {
      View var4;
      for(; this.getChildCount() > 0; this.removeAndRecycleView(var4, var1)) {
         var4 = this.getChildAt(0);
         if(this.mPrimaryOrientation.getDecoratedEnd(var4) > var2) {
            break;
         }

         StaggeredGridLayoutManager$LayoutParams var5 = (StaggeredGridLayoutManager$LayoutParams)var4.getLayoutParams();
         if(!var5.mFullSpan) {
            if(StaggeredGridLayoutManager$Span.access$200(var5.mSpan).size() == 1) {
               break;
            }

            var5.mSpan.popStart();
         } else {
            int var3;
            for(var3 = 0; var3 < this.mSpanCount; ++var3) {
               if(StaggeredGridLayoutManager$Span.access$200(this.mSpans[var3]).size() == 1) {
                  return;
               }
            }

            for(var3 = 0; var3 < this.mSpanCount; ++var3) {
               this.mSpans[var3].popStart();
            }
         }
      }

   }

   private void repositionToWrapContentIfNecessary() {
      if(this.mSecondaryOrientation.getMode() != 1073741824) {
         float var1 = 0.0F;
         int var6 = this.getChildCount();

         int var4;
         View var9;
         for(var4 = 0; var4 < var6; ++var4) {
            var9 = this.getChildAt(var4);
            float var3 = (float)this.mSecondaryOrientation.getDecoratedMeasurement(var9);
            if(var3 >= var1) {
               float var2 = var3;
               if(((StaggeredGridLayoutManager$LayoutParams)var9.getLayoutParams()).isFullSpan()) {
                  var2 = 1.0F * var3 / (float)this.mSpanCount;
               }

               var1 = Math.max(var1, var2);
            }
         }

         int var7 = this.mSizePerSpan;
         int var5 = Math.round((float)this.mSpanCount * var1);
         var4 = var5;
         if(this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            var4 = Math.min(var5, this.mSecondaryOrientation.getTotalSpace());
         }

         this.updateMeasureSpecs(var4);
         if(this.mSizePerSpan != var7) {
            for(var4 = 0; var4 < var6; ++var4) {
               var9 = this.getChildAt(var4);
               StaggeredGridLayoutManager$LayoutParams var10 = (StaggeredGridLayoutManager$LayoutParams)var9.getLayoutParams();
               if(!var10.mFullSpan) {
                  if(this.isLayoutRTL() && this.mOrientation == 1) {
                     var9.offsetLeftAndRight(-(this.mSpanCount - 1 - var10.mSpan.mIndex) * this.mSizePerSpan - -(this.mSpanCount - 1 - var10.mSpan.mIndex) * var7);
                  } else {
                     var5 = var10.mSpan.mIndex * this.mSizePerSpan;
                     int var8 = var10.mSpan.mIndex * var7;
                     if(this.mOrientation == 1) {
                        var9.offsetLeftAndRight(var5 - var8);
                     } else {
                        var9.offsetTopAndBottom(var5 - var8);
                     }
                  }
               }
            }
         }
      }

   }

   private void resolveShouldLayoutReverse() {
      boolean var1 = true;
      if(this.mOrientation != 1 && this.isLayoutRTL()) {
         if(this.mReverseLayout) {
            var1 = false;
         }

         this.mShouldReverseLayout = var1;
      } else {
         this.mShouldReverseLayout = this.mReverseLayout;
      }
   }

   private void setLayoutStateDirection(int var1) {
      byte var2 = 1;
      this.mLayoutState.mLayoutDirection = var1;
      LayoutState var5 = this.mLayoutState;
      boolean var4 = this.mShouldReverseLayout;
      boolean var3;
      if(var1 == -1) {
         var3 = true;
      } else {
         var3 = false;
      }

      byte var6;
      if(var4 == var3) {
         var6 = var2;
      } else {
         var6 = -1;
      }

      var5.mItemDirection = var6;
   }

   private void updateAllRemainingSpans(int var1, int var2) {
      for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
         if(!StaggeredGridLayoutManager$Span.access$200(this.mSpans[var3]).isEmpty()) {
            this.updateRemainingSpans(this.mSpans[var3], var1, var2);
         }
      }

   }

   private boolean updateAnchorFromChildren(RecyclerView$State var1, StaggeredGridLayoutManager$AnchorInfo var2) {
      int var3;
      if(this.mLastLayoutFromEnd) {
         var3 = this.findLastReferenceChildPosition(var1.getItemCount());
      } else {
         var3 = this.findFirstReferenceChildPosition(var1.getItemCount());
      }

      var2.mPosition = var3;
      var2.mOffset = Integer.MIN_VALUE;
      return true;
   }

   private void updateLayoutState(int var1, RecyclerView$State var2) {
      boolean var9 = true;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.mCurrentPosition = var1;
      byte var5 = 0;
      byte var6 = 0;
      int var3 = var6;
      int var4 = var5;
      boolean var8;
      if(this.isSmoothScrolling()) {
         int var7 = var2.getTargetScrollPosition();
         var3 = var6;
         var4 = var5;
         if(var7 != -1) {
            boolean var10 = this.mShouldReverseLayout;
            if(var7 < var1) {
               var8 = true;
            } else {
               var8 = false;
            }

            if(var10 == var8) {
               var3 = this.mPrimaryOrientation.getTotalSpace();
               var4 = var5;
            } else {
               var4 = this.mPrimaryOrientation.getTotalSpace();
               var3 = var6;
            }
         }
      }

      if(this.getClipToPadding()) {
         this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - var4;
         this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + var3;
      } else {
         this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + var3;
         this.mLayoutState.mStartLine = -var4;
      }

      this.mLayoutState.mStopInFocusable = false;
      this.mLayoutState.mRecycle = true;
      LayoutState var11 = this.mLayoutState;
      if(this.mPrimaryOrientation.getMode() == 0) {
         var8 = var9;
      } else {
         var8 = false;
      }

      var11.mInfinite = var8;
   }

   private void updateRemainingSpans(StaggeredGridLayoutManager$Span var1, int var2, int var3) {
      int var4 = var1.getDeletedSize();
      if(var2 == -1) {
         if(var1.getStartLine() + var4 <= var3) {
            this.mRemainingSpans.set(var1.mIndex, false);
         }
      } else if(var1.getEndLine() - var4 >= var3) {
         this.mRemainingSpans.set(var1.mIndex, false);
         return;
      }

   }

   private int updateSpecWithExtra(int var1, int var2, int var3) {
      if(var2 != 0 || var3 != 0) {
         int var4 = MeasureSpec.getMode(var1);
         if(var4 == Integer.MIN_VALUE || var4 == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, MeasureSpec.getSize(var1) - var2 - var3), var4);
         }
      }

      return var1;
   }

   boolean areAllEndsEqual() {
      int var2 = this.mSpans[0].getEndLine(Integer.MIN_VALUE);

      for(int var1 = 1; var1 < this.mSpanCount; ++var1) {
         if(this.mSpans[var1].getEndLine(Integer.MIN_VALUE) != var2) {
            return false;
         }
      }

      return true;
   }

   boolean areAllStartsEqual() {
      int var2 = this.mSpans[0].getStartLine(Integer.MIN_VALUE);

      for(int var1 = 1; var1 < this.mSpanCount; ++var1) {
         if(this.mSpans[var1].getStartLine(Integer.MIN_VALUE) != var2) {
            return false;
         }
      }

      return true;
   }

   public void assertNotInLayoutOrScroll(String var1) {
      if(this.mPendingSavedState == null) {
         super.assertNotInLayoutOrScroll(var1);
      }

   }

   public boolean canScrollHorizontally() {
      return this.mOrientation == 0;
   }

   public boolean canScrollVertically() {
      return this.mOrientation == 1;
   }

   public boolean checkLayoutParams(RecyclerView$LayoutParams var1) {
      return var1 instanceof StaggeredGridLayoutManager$LayoutParams;
   }

   public int computeHorizontalScrollExtent(RecyclerView$State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeHorizontalScrollOffset(RecyclerView$State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeHorizontalScrollRange(RecyclerView$State var1) {
      return this.computeScrollRange(var1);
   }

   public int computeVerticalScrollExtent(RecyclerView$State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeVerticalScrollOffset(RecyclerView$State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeVerticalScrollRange(RecyclerView$State var1) {
      return this.computeScrollRange(var1);
   }

   public int[] findFirstCompletelyVisibleItemPositions(int[] var1) {
      int[] var3;
      if(var1 == null) {
         var3 = new int[this.mSpanCount];
      } else {
         var3 = var1;
         if(var1.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
         }
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var3[var2] = this.mSpans[var2].findFirstCompletelyVisibleItemPosition();
      }

      return var3;
   }

   View findFirstVisibleItemClosestToEnd(boolean var1, boolean var2) {
      this.ensureOrientationHelper();
      int var4 = this.mPrimaryOrientation.getStartAfterPadding();
      int var5 = this.mPrimaryOrientation.getEndAfterPadding();
      View var8 = null;

      View var9;
      for(int var3 = this.getChildCount() - 1; var3 >= 0; var8 = var9) {
         View var10 = this.getChildAt(var3);
         int var6 = this.mPrimaryOrientation.getDecoratedStart(var10);
         int var7 = this.mPrimaryOrientation.getDecoratedEnd(var10);
         var9 = var8;
         if(var7 > var4) {
            if(var6 >= var5) {
               var9 = var8;
            } else {
               if(var7 <= var5 || !var1) {
                  return var10;
               }

               var9 = var8;
               if(var2) {
                  var9 = var8;
                  if(var8 == null) {
                     var9 = var10;
                  }
               }
            }
         }

         --var3;
      }

      return var8;
   }

   View findFirstVisibleItemClosestToStart(boolean var1, boolean var2) {
      this.ensureOrientationHelper();
      int var4 = this.mPrimaryOrientation.getStartAfterPadding();
      int var5 = this.mPrimaryOrientation.getEndAfterPadding();
      int var6 = this.getChildCount();
      View var8 = null;

      View var9;
      for(int var3 = 0; var3 < var6; var8 = var9) {
         View var10 = this.getChildAt(var3);
         int var7 = this.mPrimaryOrientation.getDecoratedStart(var10);
         var9 = var8;
         if(this.mPrimaryOrientation.getDecoratedEnd(var10) > var4) {
            if(var7 >= var5) {
               var9 = var8;
            } else {
               if(var7 >= var4 || !var1) {
                  return var10;
               }

               var9 = var8;
               if(var2) {
                  var9 = var8;
                  if(var8 == null) {
                     var9 = var10;
                  }
               }
            }
         }

         ++var3;
      }

      return var8;
   }

   int findFirstVisibleItemPositionInt() {
      View var1;
      if(this.mShouldReverseLayout) {
         var1 = this.findFirstVisibleItemClosestToEnd(true, true);
      } else {
         var1 = this.findFirstVisibleItemClosestToStart(true, true);
      }

      return var1 == null?-1:this.getPosition(var1);
   }

   public int[] findFirstVisibleItemPositions(int[] var1) {
      int[] var3;
      if(var1 == null) {
         var3 = new int[this.mSpanCount];
      } else {
         var3 = var1;
         if(var1.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
         }
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var3[var2] = this.mSpans[var2].findFirstVisibleItemPosition();
      }

      return var3;
   }

   public int[] findLastCompletelyVisibleItemPositions(int[] var1) {
      int[] var3;
      if(var1 == null) {
         var3 = new int[this.mSpanCount];
      } else {
         var3 = var1;
         if(var1.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
         }
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var3[var2] = this.mSpans[var2].findLastCompletelyVisibleItemPosition();
      }

      return var3;
   }

   public int[] findLastVisibleItemPositions(int[] var1) {
      int[] var3;
      if(var1 == null) {
         var3 = new int[this.mSpanCount];
      } else {
         var3 = var1;
         if(var1.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
         }
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var3[var2] = this.mSpans[var2].findLastVisibleItemPosition();
      }

      return var3;
   }

   public RecyclerView$LayoutParams generateDefaultLayoutParams() {
      return this.mOrientation == 0?new StaggeredGridLayoutManager$LayoutParams(-2, -1):new StaggeredGridLayoutManager$LayoutParams(-1, -2);
   }

   public RecyclerView$LayoutParams generateLayoutParams(Context var1, AttributeSet var2) {
      return new StaggeredGridLayoutManager$LayoutParams(var1, var2);
   }

   public RecyclerView$LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof MarginLayoutParams?new StaggeredGridLayoutManager$LayoutParams((MarginLayoutParams)var1):new StaggeredGridLayoutManager$LayoutParams(var1);
   }

   public int getColumnCountForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mOrientation == 1?this.mSpanCount:super.getColumnCountForAccessibility(var1, var2);
   }

   public int getGapStrategy() {
      return this.mGapStrategy;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public boolean getReverseLayout() {
      return this.mReverseLayout;
   }

   public int getRowCountForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mOrientation == 0?this.mSpanCount:super.getRowCountForAccessibility(var1, var2);
   }

   public int getSpanCount() {
      return this.mSpanCount;
   }

   View hasGapsToFix() {
      int var1 = this.getChildCount() - 1;
      BitSet var8 = new BitSet(this.mSpanCount);
      var8.set(0, this.mSpanCount, true);
      byte var2;
      if(this.mOrientation == 1 && this.isLayoutRTL()) {
         var2 = 1;
      } else {
         var2 = -1;
      }

      int var3;
      if(this.mShouldReverseLayout) {
         var3 = 0 - 1;
      } else {
         byte var4 = 0;
         var3 = var1 + 1;
         var1 = var4;
      }

      byte var13;
      if(var1 < var3) {
         var13 = 1;
      } else {
         var13 = -1;
      }

      int var5 = var1;

      View var9;
      while(true) {
         if(var5 == var3) {
            return null;
         }

         var9 = this.getChildAt(var5);
         StaggeredGridLayoutManager$LayoutParams var10 = (StaggeredGridLayoutManager$LayoutParams)var9.getLayoutParams();
         if(var8.get(var10.mSpan.mIndex)) {
            if(this.checkSpanForGap(var10.mSpan)) {
               break;
            }

            var8.clear(var10.mSpan.mIndex);
         }

         if(!var10.mFullSpan && var5 + var13 != var3) {
            View var11 = this.getChildAt(var5 + var13);
            boolean var12 = false;
            int var6;
            int var7;
            if(this.mShouldReverseLayout) {
               var6 = this.mPrimaryOrientation.getDecoratedEnd(var9);
               var7 = this.mPrimaryOrientation.getDecoratedEnd(var11);
               if(var6 < var7) {
                  break;
               }

               if(var6 == var7) {
                  var12 = true;
               }
            } else {
               var6 = this.mPrimaryOrientation.getDecoratedStart(var9);
               var7 = this.mPrimaryOrientation.getDecoratedStart(var11);
               if(var6 > var7) {
                  break;
               }

               if(var6 == var7) {
                  var12 = true;
               }
            }

            if(var12) {
               StaggeredGridLayoutManager$LayoutParams var15 = (StaggeredGridLayoutManager$LayoutParams)var11.getLayoutParams();
               if(var10.mSpan.mIndex - var15.mSpan.mIndex < 0) {
                  var12 = true;
               } else {
                  var12 = false;
               }

               boolean var14;
               if(var2 < 0) {
                  var14 = true;
               } else {
                  var14 = false;
               }

               if(var12 != var14) {
                  return var9;
               }
            }
         }

         var5 += var13;
      }

      return var9;
   }

   public void invalidateSpanAssignments() {
      this.mLazySpanLookup.clear();
      this.requestLayout();
   }

   boolean isLayoutRTL() {
      return this.getLayoutDirection() == 1;
   }

   public void offsetChildrenHorizontal(int var1) {
      super.offsetChildrenHorizontal(var1);

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         this.mSpans[var2].onOffset(var1);
      }

   }

   public void offsetChildrenVertical(int var1) {
      super.offsetChildrenVertical(var1);

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         this.mSpans[var2].onOffset(var1);
      }

   }

   public void onDetachedFromWindow(RecyclerView var1, RecyclerView$Recycler var2) {
      this.removeCallbacks(this.mCheckForGapsRunnable);

      for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
         this.mSpans[var3].clear();
      }

   }

   @Nullable
   public View onFocusSearchFailed(View var1, int var2, RecyclerView$Recycler var3, RecyclerView$State var4) {
      if(this.getChildCount() == 0) {
         var1 = null;
         return var1;
      } else {
         View var8 = this.findContainingItemView(var1);
         if(var8 == null) {
            return null;
         } else {
            this.ensureOrientationHelper();
            this.resolveShouldLayoutReverse();
            int var6 = this.convertFocusDirectionToLayoutDirection(var2);
            if(var6 == Integer.MIN_VALUE) {
               return null;
            } else {
               StaggeredGridLayoutManager$LayoutParams var9 = (StaggeredGridLayoutManager$LayoutParams)var8.getLayoutParams();
               boolean var7 = var9.mFullSpan;
               StaggeredGridLayoutManager$Span var10 = var9.mSpan;
               if(var6 == 1) {
                  var2 = this.getLastChildPosition();
               } else {
                  var2 = this.getFirstChildPosition();
               }

               this.updateLayoutState(var2, var4);
               this.setLayoutStateDirection(var6);
               this.mLayoutState.mCurrentPosition = this.mLayoutState.mItemDirection + var2;
               this.mLayoutState.mAvailable = (int)(0.33333334F * (float)this.mPrimaryOrientation.getTotalSpace());
               this.mLayoutState.mStopInFocusable = true;
               this.mLayoutState.mRecycle = false;
               this.fill(var3, this.mLayoutState, var4);
               this.mLastLayoutFromEnd = this.mShouldReverseLayout;
               View var11;
               if(!var7) {
                  var11 = var10.getFocusableViewAfter(var2, var6);
                  if(var11 != null) {
                     var1 = var11;
                     if(var11 != var8) {
                        return var1;
                     }
                  }
               }

               int var5;
               if(this.preferLastSpan(var6)) {
                  for(var5 = this.mSpanCount - 1; var5 >= 0; --var5) {
                     var11 = this.mSpans[var5].getFocusableViewAfter(var2, var6);
                     if(var11 != null) {
                        var1 = var11;
                        if(var11 != var8) {
                           return var1;
                        }
                     }
                  }
               } else {
                  for(var5 = 0; var5 < this.mSpanCount; ++var5) {
                     var11 = this.mSpans[var5].getFocusableViewAfter(var2, var6);
                     if(var11 != null) {
                        var1 = var11;
                        if(var11 != var8) {
                           return var1;
                        }
                     }
                  }
               }

               return null;
            }
         }
      }
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      if(this.getChildCount() > 0) {
         AccessibilityRecordCompat var6 = AccessibilityEventCompat.asRecord(var1);
         View var4 = this.findFirstVisibleItemClosestToStart(false, true);
         View var5 = this.findFirstVisibleItemClosestToEnd(false, true);
         if(var4 != null && var5 != null) {
            int var2 = this.getPosition(var4);
            int var3 = this.getPosition(var5);
            if(var2 < var3) {
               var6.setFromIndex(var2);
               var6.setToIndex(var3);
               return;
            }

            var6.setFromIndex(var3);
            var6.setToIndex(var2);
            return;
         }
      }

   }

   public void onInitializeAccessibilityNodeInfoForItem(RecyclerView$Recycler var1, RecyclerView$State var2, View var3, AccessibilityNodeInfoCompat var4) {
      LayoutParams var7 = var3.getLayoutParams();
      if(!(var7 instanceof StaggeredGridLayoutManager$LayoutParams)) {
         super.onInitializeAccessibilityNodeInfoForItem(var3, var4);
      } else {
         StaggeredGridLayoutManager$LayoutParams var8 = (StaggeredGridLayoutManager$LayoutParams)var7;
         int var5;
         int var6;
         if(this.mOrientation == 0) {
            var6 = var8.getSpanIndex();
            if(var8.mFullSpan) {
               var5 = this.mSpanCount;
            } else {
               var5 = 1;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(var6, var5, -1, -1, var8.mFullSpan, false));
         } else {
            var6 = var8.getSpanIndex();
            if(var8.mFullSpan) {
               var5 = this.mSpanCount;
            } else {
               var5 = 1;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(-1, -1, var6, var5, var8.mFullSpan, false));
         }
      }
   }

   public void onItemsAdded(RecyclerView var1, int var2, int var3) {
      this.handleUpdate(var2, var3, 1);
   }

   public void onItemsChanged(RecyclerView var1) {
      this.mLazySpanLookup.clear();
      this.requestLayout();
   }

   public void onItemsMoved(RecyclerView var1, int var2, int var3, int var4) {
      this.handleUpdate(var2, var3, 8);
   }

   public void onItemsRemoved(RecyclerView var1, int var2, int var3) {
      this.handleUpdate(var2, var3, 2);
   }

   public void onItemsUpdated(RecyclerView var1, int var2, int var3, Object var4) {
      this.handleUpdate(var2, var3, 4);
   }

   public void onLayoutChildren(RecyclerView$Recycler var1, RecyclerView$State var2) {
      this.onLayoutChildren(var1, var2, true);
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(var1 instanceof StaggeredGridLayoutManager$SavedState) {
         this.mPendingSavedState = (StaggeredGridLayoutManager$SavedState)var1;
         this.requestLayout();
      }

   }

   public Parcelable onSaveInstanceState() {
      StaggeredGridLayoutManager$SavedState var4;
      if(this.mPendingSavedState != null) {
         var4 = new StaggeredGridLayoutManager$SavedState(this.mPendingSavedState);
      } else {
         StaggeredGridLayoutManager$SavedState var5 = new StaggeredGridLayoutManager$SavedState();
         var5.mReverseLayout = this.mReverseLayout;
         var5.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
         var5.mLastLayoutRTL = this.mLastLayoutRTL;
         if(this.mLazySpanLookup != null && this.mLazySpanLookup.mData != null) {
            var5.mSpanLookup = this.mLazySpanLookup.mData;
            var5.mSpanLookupSize = var5.mSpanLookup.length;
            var5.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
         } else {
            var5.mSpanLookupSize = 0;
         }

         if(this.getChildCount() <= 0) {
            var5.mAnchorPosition = -1;
            var5.mVisibleAnchorPosition = -1;
            var5.mSpanOffsetsSize = 0;
            return var5;
         }

         this.ensureOrientationHelper();
         int var1;
         if(this.mLastLayoutFromEnd) {
            var1 = this.getLastChildPosition();
         } else {
            var1 = this.getFirstChildPosition();
         }

         var5.mAnchorPosition = var1;
         var5.mVisibleAnchorPosition = this.findFirstVisibleItemPositionInt();
         var5.mSpanOffsetsSize = this.mSpanCount;
         var5.mSpanOffsets = new int[this.mSpanCount];
         int var2 = 0;

         while(true) {
            var4 = var5;
            if(var2 >= this.mSpanCount) {
               break;
            }

            int var3;
            if(this.mLastLayoutFromEnd) {
               var3 = this.mSpans[var2].getEndLine(Integer.MIN_VALUE);
               var1 = var3;
               if(var3 != Integer.MIN_VALUE) {
                  var1 = var3 - this.mPrimaryOrientation.getEndAfterPadding();
               }
            } else {
               var3 = this.mSpans[var2].getStartLine(Integer.MIN_VALUE);
               var1 = var3;
               if(var3 != Integer.MIN_VALUE) {
                  var1 = var3 - this.mPrimaryOrientation.getStartAfterPadding();
               }
            }

            var5.mSpanOffsets[var2] = var1;
            ++var2;
         }
      }

      return var4;
   }

   public void onScrollStateChanged(int var1) {
      if(var1 == 0) {
         this.checkForGaps();
      }

   }

   int scrollBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      this.ensureOrientationHelper();
      byte var4;
      int var5;
      if(var1 > 0) {
         var4 = 1;
         var5 = this.getLastChildPosition();
      } else {
         var4 = -1;
         var5 = this.getFirstChildPosition();
      }

      this.mLayoutState.mRecycle = true;
      this.updateLayoutState(var5, var3);
      this.setLayoutStateDirection(var4);
      this.mLayoutState.mCurrentPosition = this.mLayoutState.mItemDirection + var5;
      var5 = Math.abs(var1);
      this.mLayoutState.mAvailable = var5;
      int var6 = this.fill(var2, this.mLayoutState, var3);
      if(var5 >= var6) {
         if(var1 < 0) {
            var1 = -var6;
         } else {
            var1 = var6;
         }
      }

      this.mPrimaryOrientation.offsetChildren(-var1);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      return var1;
   }

   public int scrollHorizontallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      return this.scrollBy(var1, var2, var3);
   }

   public void scrollToPosition(int var1) {
      if(this.mPendingSavedState != null && this.mPendingSavedState.mAnchorPosition != var1) {
         this.mPendingSavedState.invalidateAnchorPositionInfo();
      }

      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.requestLayout();
   }

   public void scrollToPositionWithOffset(int var1, int var2) {
      if(this.mPendingSavedState != null) {
         this.mPendingSavedState.invalidateAnchorPositionInfo();
      }

      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = var2;
      this.requestLayout();
   }

   public int scrollVerticallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      return this.scrollBy(var1, var2, var3);
   }

   public void setGapStrategy(int var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(var1 != this.mGapStrategy) {
         if(var1 != 0 && var1 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
         } else {
            this.mGapStrategy = var1;
            boolean var2;
            if(this.mGapStrategy != 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.setAutoMeasureEnabled(var2);
            this.requestLayout();
         }
      }
   }

   public void setMeasuredDimension(Rect var1, int var2, int var3) {
      int var5 = this.getPaddingLeft() + this.getPaddingRight();
      int var6 = this.getPaddingTop() + this.getPaddingBottom();
      int var4;
      if(this.mOrientation == 1) {
         var4 = chooseSize(var3, var1.height() + var6, this.getMinimumHeight());
         var3 = chooseSize(var2, this.mSizePerSpan * this.mSpanCount + var5, this.getMinimumWidth());
         var2 = var4;
      } else {
         var4 = chooseSize(var2, var1.width() + var5, this.getMinimumWidth());
         var2 = chooseSize(var3, this.mSizePerSpan * this.mSpanCount + var6, this.getMinimumHeight());
         var3 = var4;
      }

      this.setMeasuredDimension(var3, var2);
   }

   public void setOrientation(int var1) {
      if(var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation.");
      } else {
         this.assertNotInLayoutOrScroll((String)null);
         if(var1 != this.mOrientation) {
            this.mOrientation = var1;
            if(this.mPrimaryOrientation != null && this.mSecondaryOrientation != null) {
               OrientationHelper var2 = this.mPrimaryOrientation;
               this.mPrimaryOrientation = this.mSecondaryOrientation;
               this.mSecondaryOrientation = var2;
            }

            this.requestLayout();
         }
      }
   }

   public void setReverseLayout(boolean var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(this.mPendingSavedState != null && this.mPendingSavedState.mReverseLayout != var1) {
         this.mPendingSavedState.mReverseLayout = var1;
      }

      this.mReverseLayout = var1;
      this.requestLayout();
   }

   public void setSpanCount(int var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(var1 != this.mSpanCount) {
         this.invalidateSpanAssignments();
         this.mSpanCount = var1;
         this.mRemainingSpans = new BitSet(this.mSpanCount);
         this.mSpans = new StaggeredGridLayoutManager$Span[this.mSpanCount];

         for(var1 = 0; var1 < this.mSpanCount; ++var1) {
            this.mSpans[var1] = new StaggeredGridLayoutManager$Span(this, var1, (StaggeredGridLayoutManager$1)null);
         }

         this.requestLayout();
      }

   }

   public void smoothScrollToPosition(RecyclerView var1, RecyclerView$State var2, int var3) {
      StaggeredGridLayoutManager$2 var4 = new StaggeredGridLayoutManager$2(this, var1.getContext());
      var4.setTargetPosition(var3);
      this.startSmoothScroll(var4);
   }

   public boolean supportsPredictiveItemAnimations() {
      return this.mPendingSavedState == null;
   }

   boolean updateAnchorFromPendingData(RecyclerView$State var1, StaggeredGridLayoutManager$AnchorInfo var2) {
      boolean var4 = false;
      if(!var1.isPreLayout() && this.mPendingScrollPosition != -1) {
         if(this.mPendingScrollPosition >= 0 && this.mPendingScrollPosition < var1.getItemCount()) {
            if(this.mPendingSavedState != null && this.mPendingSavedState.mAnchorPosition != -1 && this.mPendingSavedState.mSpanOffsetsSize >= 1) {
               var2.mOffset = Integer.MIN_VALUE;
               var2.mPosition = this.mPendingScrollPosition;
               return true;
            } else {
               View var5 = this.findViewByPosition(this.mPendingScrollPosition);
               if(var5 != null) {
                  int var3;
                  if(this.mShouldReverseLayout) {
                     var3 = this.getLastChildPosition();
                  } else {
                     var3 = this.getFirstChildPosition();
                  }

                  var2.mPosition = var3;
                  if(this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                     if(var2.mLayoutFromEnd) {
                        var2.mOffset = this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(var5);
                        return true;
                     } else {
                        var2.mOffset = this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(var5);
                        return true;
                     }
                  } else if(this.mPrimaryOrientation.getDecoratedMeasurement(var5) > this.mPrimaryOrientation.getTotalSpace()) {
                     if(var2.mLayoutFromEnd) {
                        var3 = this.mPrimaryOrientation.getEndAfterPadding();
                     } else {
                        var3 = this.mPrimaryOrientation.getStartAfterPadding();
                     }

                     var2.mOffset = var3;
                     return true;
                  } else {
                     var3 = this.mPrimaryOrientation.getDecoratedStart(var5) - this.mPrimaryOrientation.getStartAfterPadding();
                     if(var3 < 0) {
                        var2.mOffset = -var3;
                        return true;
                     } else {
                        var3 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(var5);
                        if(var3 < 0) {
                           var2.mOffset = var3;
                           return true;
                        } else {
                           var2.mOffset = Integer.MIN_VALUE;
                           return true;
                        }
                     }
                  }
               } else {
                  var2.mPosition = this.mPendingScrollPosition;
                  if(this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                     if(this.calculateScrollDirectionForPosition(var2.mPosition) == 1) {
                        var4 = true;
                     }

                     var2.mLayoutFromEnd = var4;
                     var2.assignCoordinateFromPadding();
                  } else {
                     var2.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
                  }

                  var2.mInvalidateOffsets = true;
                  return true;
               }
            }
         } else {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
         }
      } else {
         return false;
      }
   }

   void updateAnchorInfoForLayout(RecyclerView$State var1, StaggeredGridLayoutManager$AnchorInfo var2) {
      if(!this.updateAnchorFromPendingData(var1, var2) && !this.updateAnchorFromChildren(var1, var2)) {
         var2.assignCoordinateFromPadding();
         var2.mPosition = 0;
      }
   }

   void updateMeasureSpecs(int var1) {
      this.mSizePerSpan = var1 / this.mSpanCount;
      this.mFullSizeSpec = MeasureSpec.makeMeasureSpec(var1, this.mSecondaryOrientation.getMode());
   }
}
