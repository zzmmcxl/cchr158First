package android.support.v7.util;

import android.support.v7.util.AsyncListUtil$1;
import android.support.v7.util.AsyncListUtil$2;
import android.support.v7.util.AsyncListUtil$DataCallback;
import android.support.v7.util.AsyncListUtil$ViewCallback;
import android.support.v7.util.MessageThreadUtil;
import android.support.v7.util.ThreadUtil$BackgroundCallback;
import android.support.v7.util.ThreadUtil$MainThreadCallback;
import android.support.v7.util.TileList;
import android.util.Log;
import android.util.SparseIntArray;

public class AsyncListUtil<T> {
   private static final boolean DEBUG = false;
   private static final String TAG = "AsyncListUtil";
   private boolean mAllowScrollHints;
   private final ThreadUtil$BackgroundCallback<T> mBackgroundCallback;
   final ThreadUtil$BackgroundCallback<T> mBackgroundProxy;
   final AsyncListUtil$DataCallback<T> mDataCallback;
   int mDisplayedGeneration = 0;
   private int mItemCount = 0;
   private final ThreadUtil$MainThreadCallback<T> mMainThreadCallback;
   final ThreadUtil$MainThreadCallback<T> mMainThreadProxy;
   private final SparseIntArray mMissingPositions;
   final int[] mPrevRange = new int[2];
   int mRequestedGeneration;
   private int mScrollHint = 0;
   final Class<T> mTClass;
   final TileList<T> mTileList;
   final int mTileSize;
   final int[] mTmpRange = new int[2];
   final int[] mTmpRangeExtended = new int[2];
   final AsyncListUtil$ViewCallback mViewCallback;

   public AsyncListUtil(Class<T> var1, int var2, AsyncListUtil$DataCallback<T> var3, AsyncListUtil$ViewCallback var4) {
      this.mRequestedGeneration = this.mDisplayedGeneration;
      this.mMissingPositions = new SparseIntArray();
      this.mMainThreadCallback = new AsyncListUtil$1(this);
      this.mBackgroundCallback = new AsyncListUtil$2(this);
      this.mTClass = var1;
      this.mTileSize = var2;
      this.mDataCallback = var3;
      this.mViewCallback = var4;
      this.mTileList = new TileList(this.mTileSize);
      MessageThreadUtil var5 = new MessageThreadUtil();
      this.mMainThreadProxy = var5.getMainThreadProxy(this.mMainThreadCallback);
      this.mBackgroundProxy = var5.getBackgroundProxy(this.mBackgroundCallback);
      this.refresh();
   }

   private boolean isRefreshPending() {
      return this.mRequestedGeneration != this.mDisplayedGeneration;
   }

   private void log(String var1, Object... var2) {
      Log.d("AsyncListUtil", "[MAIN] " + String.format(var1, var2));
   }

   private void updateRange() {
      this.mViewCallback.getItemRangeInto(this.mTmpRange);
      if(this.mTmpRange[0] <= this.mTmpRange[1] && this.mTmpRange[0] >= 0 && this.mTmpRange[1] < this.mItemCount) {
         if(!this.mAllowScrollHints) {
            this.mScrollHint = 0;
         } else if(this.mTmpRange[0] <= this.mPrevRange[1] && this.mPrevRange[0] <= this.mTmpRange[1]) {
            if(this.mTmpRange[0] < this.mPrevRange[0]) {
               this.mScrollHint = 1;
            } else if(this.mTmpRange[0] > this.mPrevRange[0]) {
               this.mScrollHint = 2;
            }
         } else {
            this.mScrollHint = 0;
         }

         this.mPrevRange[0] = this.mTmpRange[0];
         this.mPrevRange[1] = this.mTmpRange[1];
         this.mViewCallback.extendRangeInto(this.mTmpRange, this.mTmpRangeExtended, this.mScrollHint);
         this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
         this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], this.mItemCount - 1));
         this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
      }
   }

   public T getItem(int var1) {
      if(var1 >= 0 && var1 < this.mItemCount) {
         Object var2 = this.mTileList.getItemAt(var1);
         if(var2 == null && !this.isRefreshPending()) {
            this.mMissingPositions.put(var1, 0);
         }

         return var2;
      } else {
         throw new IndexOutOfBoundsException(var1 + " is not within 0 and " + this.mItemCount);
      }
   }

   public int getItemCount() {
      return this.mItemCount;
   }

   public void onRangeChanged() {
      if(!this.isRefreshPending()) {
         this.updateRange();
         this.mAllowScrollHints = true;
      }
   }

   public void refresh() {
      this.mMissingPositions.clear();
      ThreadUtil$BackgroundCallback var2 = this.mBackgroundProxy;
      int var1 = this.mRequestedGeneration + 1;
      this.mRequestedGeneration = var1;
      var2.refresh(var1);
   }
}
