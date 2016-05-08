package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import android.support.v7.widget.GridLayoutManager$DefaultSpanSizeLookup;
import android.support.v7.widget.GridLayoutManager$LayoutParams;
import android.support.v7.widget.GridLayoutManager$SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearLayoutManager$AnchorInfo;
import android.support.v7.widget.LinearLayoutManager$LayoutChunkResult;
import android.support.v7.widget.LinearLayoutManager$LayoutState;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
   private static final boolean DEBUG = false;
   public static final int DEFAULT_SPAN_COUNT = -1;
   private static final String TAG = "GridLayoutManager";
   int[] mCachedBorders;
   final Rect mDecorInsets = new Rect();
   boolean mPendingSpanCountChange = false;
   final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
   final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
   View[] mSet;
   int mSpanCount = -1;
   GridLayoutManager$SpanSizeLookup mSpanSizeLookup = new GridLayoutManager$DefaultSpanSizeLookup();

   public GridLayoutManager(Context var1, int var2) {
      super(var1);
      this.setSpanCount(var2);
   }

   public GridLayoutManager(Context var1, int var2, int var3, boolean var4) {
      super(var1, var3, var4);
      this.setSpanCount(var2);
   }

   public GridLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.setSpanCount(getProperties(var1, var2, var3, var4).spanCount);
   }

   private void assignSpans(RecyclerView$Recycler var1, RecyclerView$State var2, int var3, int var4, boolean var5) {
      byte var6;
      int var7;
      if(var5) {
         byte var11 = 0;
         var7 = var3;
         var6 = 1;
         var3 = var11;
      } else {
         --var3;
         var7 = -1;
         var6 = -1;
      }

      byte var8;
      if(this.mOrientation == 1 && this.isLayoutRTL()) {
         var4 = this.mSpanCount - 1;
         var8 = -1;
      } else {
         var4 = 0;
         var8 = 1;
      }

      while(var3 != var7) {
         View var9 = this.mSet[var3];
         GridLayoutManager$LayoutParams var10 = (GridLayoutManager$LayoutParams)var9.getLayoutParams();
         GridLayoutManager$LayoutParams.access$102(var10, this.getSpanSize(var1, var2, this.getPosition(var9)));
         if(var8 == -1 && GridLayoutManager$LayoutParams.access$100(var10) > 1) {
            GridLayoutManager$LayoutParams.access$002(var10, var4 - (GridLayoutManager$LayoutParams.access$100(var10) - 1));
         } else {
            GridLayoutManager$LayoutParams.access$002(var10, var4);
         }

         var4 += GridLayoutManager$LayoutParams.access$100(var10) * var8;
         var3 += var6;
      }

   }

   private void cachePreLayoutSpanMapping() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         GridLayoutManager$LayoutParams var4 = (GridLayoutManager$LayoutParams)this.getChildAt(var1).getLayoutParams();
         int var3 = var4.getViewLayoutPosition();
         this.mPreLayoutSpanSizeCache.put(var3, var4.getSpanSize());
         this.mPreLayoutSpanIndexCache.put(var3, var4.getSpanIndex());
      }

   }

   private void calculateItemBorders(int var1) {
      this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, var1);
   }

   static int[] calculateItemBorders(int[] var0, int var1, int var2) {
      int[] var10;
      label26: {
         if(var0 != null && var0.length == var1 + 1) {
            var10 = var0;
            if(var0[var0.length - 1] == var2) {
               break label26;
            }
         }

         var10 = new int[var1 + 1];
      }

      var10[0] = 0;
      int var7 = var2 / var1;
      int var9 = var2 % var1;
      int var4 = 0;
      var2 = 0;

      for(int var3 = 1; var3 <= var1; ++var3) {
         int var8 = var2 + var9;
         var2 = var8;
         int var6 = var7;
         if(var8 > 0) {
            var2 = var8;
            var6 = var7;
            if(var1 - var8 < var9) {
               var6 = var7 + 1;
               var2 = var8 - var1;
            }
         }

         var4 += var6;
         var10[var3] = var4;
      }

      return var10;
   }

   private void clearPreLayoutSpanMappingCache() {
      this.mPreLayoutSpanSizeCache.clear();
      this.mPreLayoutSpanIndexCache.clear();
   }

   private void ensureAnchorIsInCorrectSpan(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$AnchorInfo var3, int var4) {
      boolean var5 = true;
      if(var4 != 1) {
         var5 = false;
      }

      var4 = this.getSpanIndex(var1, var2, var3.mPosition);
      if(var5) {
         while(var4 > 0 && var3.mPosition > 0) {
            --var3.mPosition;
            var4 = this.getSpanIndex(var1, var2, var3.mPosition);
         }
      } else {
         int var7 = var2.getItemCount();

         int var6;
         int var8;
         for(var8 = var3.mPosition; var8 < var7 - 1; var4 = var6) {
            var6 = this.getSpanIndex(var1, var2, var8 + 1);
            if(var6 <= var4) {
               break;
            }

            ++var8;
         }

         var3.mPosition = var8;
      }

   }

   private void ensureViewSet() {
      if(this.mSet == null || this.mSet.length != this.mSpanCount) {
         this.mSet = new View[this.mSpanCount];
      }

   }

   private int getSpanGroupIndex(RecyclerView$Recycler var1, RecyclerView$State var2, int var3) {
      if(!var2.isPreLayout()) {
         return this.mSpanSizeLookup.getSpanGroupIndex(var3, this.mSpanCount);
      } else {
         int var4 = var1.convertPreLayoutPositionToPostLayout(var3);
         if(var4 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + var3);
            return 0;
         } else {
            return this.mSpanSizeLookup.getSpanGroupIndex(var4, this.mSpanCount);
         }
      }
   }

   private int getSpanIndex(RecyclerView$Recycler var1, RecyclerView$State var2, int var3) {
      int var4;
      if(!var2.isPreLayout()) {
         var4 = this.mSpanSizeLookup.getCachedSpanIndex(var3, this.mSpanCount);
      } else {
         int var5 = this.mPreLayoutSpanIndexCache.get(var3, -1);
         var4 = var5;
         if(var5 == -1) {
            var4 = var1.convertPreLayoutPositionToPostLayout(var3);
            if(var4 == -1) {
               Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + var3);
               return 0;
            }

            return this.mSpanSizeLookup.getCachedSpanIndex(var4, this.mSpanCount);
         }
      }

      return var4;
   }

   private int getSpanSize(RecyclerView$Recycler var1, RecyclerView$State var2, int var3) {
      int var4;
      if(!var2.isPreLayout()) {
         var4 = this.mSpanSizeLookup.getSpanSize(var3);
      } else {
         int var5 = this.mPreLayoutSpanSizeCache.get(var3, -1);
         var4 = var5;
         if(var5 == -1) {
            var4 = var1.convertPreLayoutPositionToPostLayout(var3);
            if(var4 == -1) {
               Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + var3);
               return 1;
            }

            return this.mSpanSizeLookup.getSpanSize(var4);
         }
      }

      return var4;
   }

   private void guessMeasurement(float var1, int var2) {
      this.calculateItemBorders(Math.max(Math.round((float)this.mSpanCount * var1), var2));
   }

   private void measureChildWithDecorationsAndMargin(View var1, int var2, int var3, boolean var4, boolean var5) {
      int var6;
      RecyclerView$LayoutParams var7;
      label28: {
         this.calculateItemDecorationsForChild(var1, this.mDecorInsets);
         var7 = (RecyclerView$LayoutParams)var1.getLayoutParams();
         if(!var4) {
            var6 = var2;
            if(this.mOrientation != 1) {
               break label28;
            }
         }

         var6 = this.updateSpecWithExtra(var2, var7.leftMargin + this.mDecorInsets.left, var7.rightMargin + this.mDecorInsets.right);
      }

      label23: {
         if(!var4) {
            var2 = var3;
            if(this.mOrientation != 0) {
               break label23;
            }
         }

         var2 = this.updateSpecWithExtra(var3, var7.topMargin + this.mDecorInsets.top, var7.bottomMargin + this.mDecorInsets.bottom);
      }

      if(var5) {
         var4 = this.shouldReMeasureChild(var1, var6, var2, var7);
      } else {
         var4 = this.shouldMeasureChild(var1, var6, var2, var7);
      }

      if(var4) {
         var1.measure(var6, var2);
      }

   }

   private void updateMeasurements() {
      int var1;
      if(this.getOrientation() == 1) {
         var1 = this.getWidth() - this.getPaddingRight() - this.getPaddingLeft();
      } else {
         var1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
      }

      this.calculateItemBorders(var1);
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

   public boolean checkLayoutParams(RecyclerView$LayoutParams var1) {
      return var1 instanceof GridLayoutManager$LayoutParams;
   }

   View findReferenceChild(RecyclerView$Recycler var1, RecyclerView$State var2, int var3, int var4, int var5) {
      this.ensureLayoutState();
      View var11 = null;
      View var10 = null;
      int var7 = this.mOrientationHelper.getStartAfterPadding();
      int var8 = this.mOrientationHelper.getEndAfterPadding();
      byte var6;
      if(var4 > var3) {
         var6 = 1;
      } else {
         var6 = -1;
      }

      View var13;
      while(true) {
         if(var3 == var4) {
            if(var10 == null) {
               var10 = var11;
            }

            var13 = var10;
            break;
         }

         View var12 = this.getChildAt(var3);
         int var9 = this.getPosition(var12);
         var13 = var11;
         View var14 = var10;
         if(var9 >= 0) {
            var13 = var11;
            var14 = var10;
            if(var9 < var5) {
               if(this.getSpanIndex(var1, var2, var9) != 0) {
                  var14 = var10;
                  var13 = var11;
               } else if(((RecyclerView$LayoutParams)var12.getLayoutParams()).isItemRemoved()) {
                  var13 = var11;
                  var14 = var10;
                  if(var11 == null) {
                     var13 = var12;
                     var14 = var10;
                  }
               } else {
                  if(this.mOrientationHelper.getDecoratedStart(var12) < var8) {
                     var13 = var12;
                     if(this.mOrientationHelper.getDecoratedEnd(var12) >= var7) {
                        break;
                     }
                  }

                  var13 = var11;
                  var14 = var10;
                  if(var10 == null) {
                     var13 = var11;
                     var14 = var12;
                  }
               }
            }
         }

         var3 += var6;
         var11 = var13;
         var10 = var14;
      }

      return var13;
   }

   public RecyclerView$LayoutParams generateDefaultLayoutParams() {
      return this.mOrientation == 0?new GridLayoutManager$LayoutParams(-2, -1):new GridLayoutManager$LayoutParams(-1, -2);
   }

   public RecyclerView$LayoutParams generateLayoutParams(Context var1, AttributeSet var2) {
      return new GridLayoutManager$LayoutParams(var1, var2);
   }

   public RecyclerView$LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof MarginLayoutParams?new GridLayoutManager$LayoutParams((MarginLayoutParams)var1):new GridLayoutManager$LayoutParams(var1);
   }

   public int getColumnCountForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mOrientation == 1?this.mSpanCount:(var2.getItemCount() < 1?0:this.getSpanGroupIndex(var1, var2, var2.getItemCount() - 1) + 1);
   }

   public int getRowCountForAccessibility(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mOrientation == 0?this.mSpanCount:(var2.getItemCount() < 1?0:this.getSpanGroupIndex(var1, var2, var2.getItemCount() - 1) + 1);
   }

   public int getSpanCount() {
      return this.mSpanCount;
   }

   public GridLayoutManager$SpanSizeLookup getSpanSizeLookup() {
      return this.mSpanSizeLookup;
   }

   void layoutChunk(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$LayoutState var3, LinearLayoutManager$LayoutChunkResult var4) {
      int var15 = this.mOrientationHelper.getModeInOther();
      boolean var9;
      if(var15 != 1073741824) {
         var9 = true;
      } else {
         var9 = false;
      }

      int var10;
      if(this.getChildCount() > 0) {
         var10 = this.mCachedBorders[this.mSpanCount];
      } else {
         var10 = 0;
      }

      if(var9) {
         this.updateMeasurements();
      }

      boolean var18;
      if(var3.mItemDirection == 1) {
         var18 = true;
      } else {
         var18 = false;
      }

      byte var13 = 0;
      byte var14 = 0;
      int var8 = this.mSpanCount;
      int var12 = var13;
      int var11 = var14;
      if(!var18) {
         var8 = this.getSpanIndex(var1, var2, var3.mCurrentPosition) + this.getSpanSize(var1, var2, var3.mCurrentPosition);
         var11 = var14;
         var12 = var13;
      }

      int var24;
      int var25;
      while(var12 < this.mSpanCount && var3.hasMore(var2) && var8 > 0) {
         var25 = var3.mCurrentPosition;
         var24 = this.getSpanSize(var1, var2, var25);
         if(var24 > this.mSpanCount) {
            throw new IllegalArgumentException("Item at position " + var25 + " requires " + var24 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
         }

         var8 -= var24;
         if(var8 < 0) {
            break;
         }

         View var20 = var3.next(var1);
         if(var20 == null) {
            break;
         }

         var11 += var24;
         this.mSet[var12] = var20;
         ++var12;
      }

      if(var12 == 0) {
         var4.mFinished = true;
      } else {
         var8 = 0;
         float var5 = 0.0F;
         this.assignSpans(var1, var2, var12, var11, var18);

         float var6;
         View var21;
         GridLayoutManager$LayoutParams var22;
         for(var11 = 0; var11 < var12; var5 = var6) {
            var21 = this.mSet[var11];
            if(var3.mScrapList == null) {
               if(var18) {
                  this.addView(var21);
               } else {
                  this.addView(var21, 0);
               }
            } else if(var18) {
               this.addDisappearingView(var21);
            } else {
               this.addDisappearingView(var21, 0);
            }

            var22 = (GridLayoutManager$LayoutParams)var21.getLayoutParams();
            var25 = this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22) + GridLayoutManager$LayoutParams.access$100(var22)];
            int var16 = this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22)];
            if(this.mOrientation == 0) {
               var24 = var22.height;
            } else {
               var24 = var22.width;
            }

            var25 = getChildMeasureSpec(var25 - var16, var15, 0, var24, false);
            var16 = this.mOrientationHelper.getTotalSpace();
            int var17 = this.mOrientationHelper.getMode();
            if(this.mOrientation == 1) {
               var24 = var22.height;
            } else {
               var24 = var22.width;
            }

            var24 = getChildMeasureSpec(var16, var17, 0, var24, true);
            boolean var19;
            if(this.mOrientation == 1) {
               if(var22.height == -1) {
                  var19 = true;
               } else {
                  var19 = false;
               }

               this.measureChildWithDecorationsAndMargin(var21, var25, var24, var19, false);
            } else {
               if(var22.width == -1) {
                  var19 = true;
               } else {
                  var19 = false;
               }

               this.measureChildWithDecorationsAndMargin(var21, var24, var25, var19, false);
            }

            var25 = this.mOrientationHelper.getDecoratedMeasurement(var21);
            var24 = var8;
            if(var25 > var8) {
               var24 = var25;
            }

            float var7 = 1.0F * (float)this.mOrientationHelper.getDecoratedMeasurementInOther(var21) / (float)GridLayoutManager$LayoutParams.access$100(var22);
            var6 = var5;
            if(var7 > var5) {
               var6 = var7;
            }

            ++var11;
            var8 = var24;
         }

         var11 = var8;
         int var23;
         if(var9) {
            this.guessMeasurement(var5, var10);
            var8 = 0;
            var23 = 0;

            while(true) {
               var11 = var8;
               if(var23 >= var12) {
                  break;
               }

               var21 = this.mSet[var23];
               var22 = (GridLayoutManager$LayoutParams)var21.getLayoutParams();
               var11 = this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22) + GridLayoutManager$LayoutParams.access$100(var22)];
               var24 = this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22)];
               if(this.mOrientation == 0) {
                  var10 = var22.height;
               } else {
                  var10 = var22.width;
               }

               var11 = getChildMeasureSpec(var11 - var24, 1073741824, 0, var10, false);
               var24 = this.mOrientationHelper.getTotalSpace();
               var25 = this.mOrientationHelper.getMode();
               if(this.mOrientation == 1) {
                  var10 = var22.height;
               } else {
                  var10 = var22.width;
               }

               var10 = getChildMeasureSpec(var24, var25, 0, var10, true);
               if(this.mOrientation == 1) {
                  this.measureChildWithDecorationsAndMargin(var21, var11, var10, false, true);
               } else {
                  this.measureChildWithDecorationsAndMargin(var21, var10, var11, false, true);
               }

               var11 = this.mOrientationHelper.getDecoratedMeasurement(var21);
               var10 = var8;
               if(var11 > var8) {
                  var10 = var11;
               }

               ++var23;
               var8 = var10;
            }
         }

         var10 = MeasureSpec.makeMeasureSpec(var11, 1073741824);

         for(var8 = 0; var8 < var12; ++var8) {
            var21 = this.mSet[var8];
            if(this.mOrientationHelper.getDecoratedMeasurement(var21) != var11) {
               var22 = (GridLayoutManager$LayoutParams)var21.getLayoutParams();
               var24 = this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22) + GridLayoutManager$LayoutParams.access$100(var22)];
               var25 = this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22)];
               if(this.mOrientation == 0) {
                  var23 = var22.height;
               } else {
                  var23 = var22.width;
               }

               var23 = getChildMeasureSpec(var24 - var25, 1073741824, 0, var23, false);
               if(this.mOrientation == 1) {
                  this.measureChildWithDecorationsAndMargin(var21, var23, var10, true, true);
               } else {
                  this.measureChildWithDecorationsAndMargin(var21, var10, var23, true, true);
               }
            }
         }

         var4.mConsumed = var11;
         var23 = 0;
         var10 = 0;
         var13 = 0;
         var8 = 0;
         if(this.mOrientation == 1) {
            if(var3.mLayoutDirection == -1) {
               var8 = var3.mOffset;
               var11 = var8 - var11;
            } else {
               var24 = var3.mOffset;
               var8 = var24 + var11;
               var11 = var24;
            }
         } else if(var3.mLayoutDirection == -1) {
            var10 = var3.mOffset;
            var23 = var10 - var11;
            var11 = var13;
         } else {
            var23 = var3.mOffset;
            var10 = var23 + var11;
            var11 = var13;
         }

         var13 = 0;
         var25 = var10;
         var15 = var23;
         var10 = var13;

         for(var24 = var8; var10 < var12; var25 = var23) {
            var21 = this.mSet[var10];
            var22 = (GridLayoutManager$LayoutParams)var21.getLayoutParams();
            if(this.mOrientation == 1) {
               if(this.isLayoutRTL()) {
                  var23 = this.getPaddingLeft() + this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22) + GridLayoutManager$LayoutParams.access$100(var22)];
                  var8 = var23 - this.mOrientationHelper.getDecoratedMeasurementInOther(var21);
               } else {
                  var8 = this.getPaddingLeft() + this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22)];
                  var23 = var8 + this.mOrientationHelper.getDecoratedMeasurementInOther(var21);
               }
            } else {
               var11 = this.getPaddingTop() + this.mCachedBorders[GridLayoutManager$LayoutParams.access$000(var22)];
               var24 = var11 + this.mOrientationHelper.getDecoratedMeasurementInOther(var21);
               var8 = var15;
               var23 = var25;
            }

            this.layoutDecorated(var21, var8 + var22.leftMargin, var11 + var22.topMargin, var23 - var22.rightMargin, var24 - var22.bottomMargin);
            if(var22.isItemRemoved() || var22.isItemChanged()) {
               var4.mIgnoreConsumed = true;
            }

            var4.mFocusable |= var21.isFocusable();
            ++var10;
            var15 = var8;
         }

         Arrays.fill(this.mSet, (Object)null);
      }
   }

   void onAnchorReady(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$AnchorInfo var3, int var4) {
      super.onAnchorReady(var1, var2, var3, var4);
      this.updateMeasurements();
      if(var2.getItemCount() > 0 && !var2.isPreLayout()) {
         this.ensureAnchorIsInCorrectSpan(var1, var2, var3, var4);
      }

      this.ensureViewSet();
   }

   public View onFocusSearchFailed(View var1, int var2, RecyclerView$Recycler var3, RecyclerView$State var4) {
      View var18 = this.findContainingItemView(var1);
      View var21;
      if(var18 == null) {
         var21 = null;
      } else {
         GridLayoutManager$LayoutParams var19 = (GridLayoutManager$LayoutParams)var18.getLayoutParams();
         int var13 = GridLayoutManager$LayoutParams.access$000(var19);
         int var14 = GridLayoutManager$LayoutParams.access$000(var19) + GridLayoutManager$LayoutParams.access$100(var19);
         if(super.onFocusSearchFailed(var1, var2, var3, var4) == null) {
            return null;
         }

         boolean var17;
         if(this.convertFocusDirectionToLayoutDirection(var2) == 1) {
            var17 = true;
         } else {
            var17 = false;
         }

         boolean var20;
         if(var17 != this.mShouldReverseLayout) {
            var20 = true;
         } else {
            var20 = false;
         }

         byte var5;
         int var6;
         if(var20) {
            var2 = this.getChildCount() - 1;
            var5 = -1;
            var6 = -1;
         } else {
            var2 = 0;
            var5 = 1;
            var6 = this.getChildCount();
         }

         boolean var7;
         if(this.mOrientation == 1 && this.isLayoutRTL()) {
            var7 = true;
         } else {
            var7 = false;
         }

         View var22 = null;
         int var9 = -1;
         int var10 = 0;
         int var8 = var2;

         while(true) {
            if(var8 == var6) {
               return var22;
            }

            var1 = this.getChildAt(var8);
            if(var1 == var18) {
               return var22;
            }

            if(var1.isFocusable()) {
               var19 = (GridLayoutManager$LayoutParams)var1.getLayoutParams();
               int var15 = GridLayoutManager$LayoutParams.access$000(var19);
               int var16 = GridLayoutManager$LayoutParams.access$000(var19) + GridLayoutManager$LayoutParams.access$100(var19);
               if(var15 == var13) {
                  var21 = var1;
                  if(var16 == var14) {
                     break;
                  }
               }

               boolean var12 = false;
               if(var22 == null) {
                  var20 = true;
               } else {
                  var2 = Math.max(var15, var13);
                  int var11 = Math.min(var16, var14) - var2;
                  if(var11 > var10) {
                     var20 = true;
                  } else {
                     var20 = var12;
                     if(var11 == var10) {
                        boolean var23;
                        if(var15 > var9) {
                           var23 = true;
                        } else {
                           var23 = false;
                        }

                        var20 = var12;
                        if(var7 == var23) {
                           var20 = true;
                        }
                     }
                  }
               }

               if(var20) {
                  var9 = GridLayoutManager$LayoutParams.access$000(var19);
                  var10 = Math.min(var16, var14) - Math.max(var15, var13);
                  var22 = var1;
               }
            }

            var8 += var5;
         }
      }

      return var21;
   }

   public void onInitializeAccessibilityNodeInfoForItem(RecyclerView$Recycler var1, RecyclerView$State var2, View var3, AccessibilityNodeInfoCompat var4) {
      LayoutParams var9 = var3.getLayoutParams();
      if(!(var9 instanceof GridLayoutManager$LayoutParams)) {
         super.onInitializeAccessibilityNodeInfoForItem(var3, var4);
      } else {
         GridLayoutManager$LayoutParams var10 = (GridLayoutManager$LayoutParams)var9;
         int var5 = this.getSpanGroupIndex(var1, var2, var10.getViewLayoutPosition());
         int var6;
         int var7;
         boolean var8;
         if(this.mOrientation == 0) {
            var6 = var10.getSpanIndex();
            var7 = var10.getSpanSize();
            if(this.mSpanCount > 1 && var10.getSpanSize() == this.mSpanCount) {
               var8 = true;
            } else {
               var8 = false;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(var6, var7, var5, 1, var8, false));
         } else {
            var6 = var10.getSpanIndex();
            var7 = var10.getSpanSize();
            if(this.mSpanCount > 1 && var10.getSpanSize() == this.mSpanCount) {
               var8 = true;
            } else {
               var8 = false;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(var5, 1, var6, var7, var8, false));
         }
      }
   }

   public void onItemsAdded(RecyclerView var1, int var2, int var3) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsChanged(RecyclerView var1) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsMoved(RecyclerView var1, int var2, int var3, int var4) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsRemoved(RecyclerView var1, int var2, int var3) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsUpdated(RecyclerView var1, int var2, int var3, Object var4) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onLayoutChildren(RecyclerView$Recycler var1, RecyclerView$State var2) {
      if(var2.isPreLayout()) {
         this.cachePreLayoutSpanMapping();
      }

      super.onLayoutChildren(var1, var2);
      this.clearPreLayoutSpanMappingCache();
      if(!var2.isPreLayout()) {
         this.mPendingSpanCountChange = false;
      }

   }

   public int scrollHorizontallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      this.updateMeasurements();
      this.ensureViewSet();
      return super.scrollHorizontallyBy(var1, var2, var3);
   }

   public int scrollVerticallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      this.updateMeasurements();
      this.ensureViewSet();
      return super.scrollVerticallyBy(var1, var2, var3);
   }

   public void setMeasuredDimension(Rect var1, int var2, int var3) {
      if(this.mCachedBorders == null) {
         super.setMeasuredDimension(var1, var2, var3);
      }

      int var5 = this.getPaddingLeft() + this.getPaddingRight();
      int var6 = this.getPaddingTop() + this.getPaddingBottom();
      int var4;
      if(this.mOrientation == 1) {
         var4 = chooseSize(var3, var1.height() + var6, this.getMinimumHeight());
         var3 = chooseSize(var2, this.mCachedBorders[this.mCachedBorders.length - 1] + var5, this.getMinimumWidth());
         var2 = var4;
      } else {
         var4 = chooseSize(var2, var1.width() + var5, this.getMinimumWidth());
         var2 = chooseSize(var3, this.mCachedBorders[this.mCachedBorders.length - 1] + var6, this.getMinimumHeight());
         var3 = var4;
      }

      this.setMeasuredDimension(var3, var2);
   }

   public void setSpanCount(int var1) {
      if(var1 != this.mSpanCount) {
         this.mPendingSpanCountChange = true;
         if(var1 < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + var1);
         } else {
            this.mSpanCount = var1;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
         }
      }
   }

   public void setSpanSizeLookup(GridLayoutManager$SpanSizeLookup var1) {
      this.mSpanSizeLookup = var1;
   }

   public void setStackFromEnd(boolean var1) {
      if(var1) {
         throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
      } else {
         super.setStackFromEnd(false);
      }
   }

   public boolean supportsPredictiveItemAnimations() {
      return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
   }
}
