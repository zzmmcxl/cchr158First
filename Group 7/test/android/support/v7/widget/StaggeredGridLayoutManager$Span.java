package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$Span {
   static final int INVALID_LINE = Integer.MIN_VALUE;
   int mCachedEnd;
   int mCachedStart;
   int mDeletedSize;
   final int mIndex;
   private ArrayList<View> mViews;

   private StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager var1, int var2) {
      this.this$0 = var1;
      this.mViews = new ArrayList();
      this.mCachedStart = Integer.MIN_VALUE;
      this.mCachedEnd = Integer.MIN_VALUE;
      this.mDeletedSize = 0;
      this.mIndex = var2;
   }

   void appendToSpan(View var1) {
      StaggeredGridLayoutManager$LayoutParams var2 = this.getLayoutParams(var1);
      var2.mSpan = this;
      this.mViews.add(var1);
      this.mCachedEnd = Integer.MIN_VALUE;
      if(this.mViews.size() == 1) {
         this.mCachedStart = Integer.MIN_VALUE;
      }

      if(var2.isItemRemoved() || var2.isItemChanged()) {
         this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(var1);
      }

   }

   void cacheReferenceLineAndClear(boolean var1, int var2) {
      int var3;
      if(var1) {
         var3 = this.getEndLine(Integer.MIN_VALUE);
      } else {
         var3 = this.getStartLine(Integer.MIN_VALUE);
      }

      this.clear();
      if(var3 != Integer.MIN_VALUE && (!var1 || var3 >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) && (var1 || var3 <= this.this$0.mPrimaryOrientation.getStartAfterPadding())) {
         int var4 = var3;
         if(var2 != Integer.MIN_VALUE) {
            var4 = var3 + var2;
         }

         this.mCachedEnd = var4;
         this.mCachedStart = var4;
      }
   }

   void calculateCachedEnd() {
      View var1 = (View)this.mViews.get(this.mViews.size() - 1);
      StaggeredGridLayoutManager$LayoutParams var2 = this.getLayoutParams(var1);
      this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(var1);
      if(var2.mFullSpan) {
         StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var3 = this.this$0.mLazySpanLookup.getFullSpanItem(var2.getViewLayoutPosition());
         if(var3 != null && var3.mGapDir == 1) {
            this.mCachedEnd += var3.getGapForSpan(this.mIndex);
         }
      }

   }

   void calculateCachedStart() {
      View var1 = (View)this.mViews.get(0);
      StaggeredGridLayoutManager$LayoutParams var2 = this.getLayoutParams(var1);
      this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(var1);
      if(var2.mFullSpan) {
         StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var3 = this.this$0.mLazySpanLookup.getFullSpanItem(var2.getViewLayoutPosition());
         if(var3 != null && var3.mGapDir == -1) {
            this.mCachedStart -= var3.getGapForSpan(this.mIndex);
         }
      }

   }

   void clear() {
      this.mViews.clear();
      this.invalidateCache();
      this.mDeletedSize = 0;
   }

   public int findFirstCompletelyVisibleItemPosition() {
      return StaggeredGridLayoutManager.access$600(this.this$0)?this.findOneVisibleChild(this.mViews.size() - 1, -1, true):this.findOneVisibleChild(0, this.mViews.size(), true);
   }

   public int findFirstVisibleItemPosition() {
      return StaggeredGridLayoutManager.access$600(this.this$0)?this.findOneVisibleChild(this.mViews.size() - 1, -1, false):this.findOneVisibleChild(0, this.mViews.size(), false);
   }

   public int findLastCompletelyVisibleItemPosition() {
      return StaggeredGridLayoutManager.access$600(this.this$0)?this.findOneVisibleChild(0, this.mViews.size(), true):this.findOneVisibleChild(this.mViews.size() - 1, -1, true);
   }

   public int findLastVisibleItemPosition() {
      return StaggeredGridLayoutManager.access$600(this.this$0)?this.findOneVisibleChild(0, this.mViews.size(), false):this.findOneVisibleChild(this.mViews.size() - 1, -1, false);
   }

   int findOneVisibleChild(int var1, int var2, boolean var3) {
      byte var6 = -1;
      int var7 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
      int var8 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
      byte var4;
      if(var2 > var1) {
         var4 = 1;
      } else {
         var4 = -1;
      }

      int var5;
      while(true) {
         var5 = var6;
         if(var1 == var2) {
            break;
         }

         View var10 = (View)this.mViews.get(var1);
         var5 = this.this$0.mPrimaryOrientation.getDecoratedStart(var10);
         int var9 = this.this$0.mPrimaryOrientation.getDecoratedEnd(var10);
         if(var5 < var8 && var9 > var7) {
            if(!var3) {
               return this.this$0.getPosition(var10);
            }

            if(var5 >= var7 && var9 <= var8) {
               var5 = this.this$0.getPosition(var10);
               break;
            }
         }

         var1 += var4;
      }

      return var5;
   }

   public int getDeletedSize() {
      return this.mDeletedSize;
   }

   int getEndLine() {
      if(this.mCachedEnd != Integer.MIN_VALUE) {
         return this.mCachedEnd;
      } else {
         this.calculateCachedEnd();
         return this.mCachedEnd;
      }
   }

   int getEndLine(int var1) {
      if(this.mCachedEnd != Integer.MIN_VALUE) {
         var1 = this.mCachedEnd;
      } else if(this.mViews.size() != 0) {
         this.calculateCachedEnd();
         return this.mCachedEnd;
      }

      return var1;
   }

   public View getFocusableViewAfter(int var1, int var2) {
      View var7 = null;
      View var6 = null;
      View var8;
      if(var2 == -1) {
         int var3 = this.mViews.size();
         var2 = 0;

         while(true) {
            var7 = var6;
            if(var2 >= var3) {
               break;
            }

            var8 = (View)this.mViews.get(var2);
            var7 = var6;
            if(!var8.isFocusable()) {
               break;
            }

            boolean var5;
            if(this.this$0.getPosition(var8) > var1) {
               var5 = true;
            } else {
               var5 = false;
            }

            var7 = var6;
            if(var5 != StaggeredGridLayoutManager.access$600(this.this$0)) {
               break;
            }

            var6 = var8;
            ++var2;
         }
      } else {
         var2 = this.mViews.size() - 1;
         var6 = var7;

         while(true) {
            var7 = var6;
            if(var2 < 0) {
               break;
            }

            var8 = (View)this.mViews.get(var2);
            var7 = var6;
            if(!var8.isFocusable()) {
               break;
            }

            boolean var9;
            if(this.this$0.getPosition(var8) > var1) {
               var9 = true;
            } else {
               var9 = false;
            }

            boolean var4;
            if(!StaggeredGridLayoutManager.access$600(this.this$0)) {
               var4 = true;
            } else {
               var4 = false;
            }

            var7 = var6;
            if(var9 != var4) {
               break;
            }

            var6 = var8;
            --var2;
         }
      }

      return var7;
   }

   StaggeredGridLayoutManager$LayoutParams getLayoutParams(View var1) {
      return (StaggeredGridLayoutManager$LayoutParams)var1.getLayoutParams();
   }

   int getStartLine() {
      if(this.mCachedStart != Integer.MIN_VALUE) {
         return this.mCachedStart;
      } else {
         this.calculateCachedStart();
         return this.mCachedStart;
      }
   }

   int getStartLine(int var1) {
      if(this.mCachedStart != Integer.MIN_VALUE) {
         var1 = this.mCachedStart;
      } else if(this.mViews.size() != 0) {
         this.calculateCachedStart();
         return this.mCachedStart;
      }

      return var1;
   }

   void invalidateCache() {
      this.mCachedStart = Integer.MIN_VALUE;
      this.mCachedEnd = Integer.MIN_VALUE;
   }

   void onOffset(int var1) {
      if(this.mCachedStart != Integer.MIN_VALUE) {
         this.mCachedStart += var1;
      }

      if(this.mCachedEnd != Integer.MIN_VALUE) {
         this.mCachedEnd += var1;
      }

   }

   void popEnd() {
      int var1 = this.mViews.size();
      View var2 = (View)this.mViews.remove(var1 - 1);
      StaggeredGridLayoutManager$LayoutParams var3 = this.getLayoutParams(var2);
      var3.mSpan = null;
      if(var3.isItemRemoved() || var3.isItemChanged()) {
         this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(var2);
      }

      if(var1 == 1) {
         this.mCachedStart = Integer.MIN_VALUE;
      }

      this.mCachedEnd = Integer.MIN_VALUE;
   }

   void popStart() {
      View var1 = (View)this.mViews.remove(0);
      StaggeredGridLayoutManager$LayoutParams var2 = this.getLayoutParams(var1);
      var2.mSpan = null;
      if(this.mViews.size() == 0) {
         this.mCachedEnd = Integer.MIN_VALUE;
      }

      if(var2.isItemRemoved() || var2.isItemChanged()) {
         this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(var1);
      }

      this.mCachedStart = Integer.MIN_VALUE;
   }

   void prependToSpan(View var1) {
      StaggeredGridLayoutManager$LayoutParams var2 = this.getLayoutParams(var1);
      var2.mSpan = this;
      this.mViews.add(0, var1);
      this.mCachedStart = Integer.MIN_VALUE;
      if(this.mViews.size() == 1) {
         this.mCachedEnd = Integer.MIN_VALUE;
      }

      if(var2.isItemRemoved() || var2.isItemChanged()) {
         this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(var1);
      }

   }

   void setLine(int var1) {
      this.mCachedStart = var1;
      this.mCachedEnd = var1;
   }
}
