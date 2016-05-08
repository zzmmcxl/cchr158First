package android.support.v7.util;

import android.support.v7.util.AsyncListUtil;
import android.support.v7.util.ThreadUtil$BackgroundCallback;
import android.support.v7.util.TileList$Tile;
import android.util.Log;
import android.util.SparseBooleanArray;

class AsyncListUtil$2 implements ThreadUtil$BackgroundCallback<T> {
   private int mFirstRequiredTileStart;
   private int mGeneration;
   private int mItemCount;
   private int mLastRequiredTileStart;
   final SparseBooleanArray mLoadedTiles;
   private TileList$Tile<T> mRecycledRoot;

   AsyncListUtil$2(AsyncListUtil var1) {
      this.this$0 = var1;
      this.mLoadedTiles = new SparseBooleanArray();
   }

   private TileList$Tile<T> acquireTile() {
      if(this.mRecycledRoot != null) {
         TileList$Tile var1 = this.mRecycledRoot;
         this.mRecycledRoot = this.mRecycledRoot.mNext;
         return var1;
      } else {
         return new TileList$Tile(this.this$0.mTClass, this.this$0.mTileSize);
      }
   }

   private void addTile(TileList$Tile<T> var1) {
      this.mLoadedTiles.put(var1.mStartPosition, true);
      this.this$0.mMainThreadProxy.addTile(this.mGeneration, var1);
   }

   private void flushTileCache(int var1) {
      int var2 = this.this$0.mDataCallback.getMaxCachedTiles();

      while(this.mLoadedTiles.size() >= var2) {
         int var3 = this.mLoadedTiles.keyAt(0);
         int var4 = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
         int var5 = this.mFirstRequiredTileStart - var3;
         int var6 = var4 - this.mLastRequiredTileStart;
         if(var5 > 0 && (var5 >= var6 || var1 == 2)) {
            this.removeTile(var3);
         } else {
            if(var6 <= 0 || var5 >= var6 && var1 != 1) {
               break;
            }

            this.removeTile(var4);
         }
      }

   }

   private int getTileStart(int var1) {
      return var1 - var1 % this.this$0.mTileSize;
   }

   private boolean isTileLoaded(int var1) {
      return this.mLoadedTiles.get(var1);
   }

   private void log(String var1, Object... var2) {
      Log.d("AsyncListUtil", "[BKGR] " + String.format(var1, var2));
   }

   private void removeTile(int var1) {
      this.mLoadedTiles.delete(var1);
      this.this$0.mMainThreadProxy.removeTile(this.mGeneration, var1);
   }

   private void requestTiles(int var1, int var2, int var3, boolean var4) {
      for(int var5 = var1; var5 <= var2; var5 += this.this$0.mTileSize) {
         int var6;
         if(var4) {
            var6 = var2 + var1 - var5;
         } else {
            var6 = var5;
         }

         this.this$0.mBackgroundProxy.loadTile(var6, var3);
      }

   }

   public void loadTile(int var1, int var2) {
      if(!this.isTileLoaded(var1)) {
         TileList$Tile var3 = this.acquireTile();
         var3.mStartPosition = var1;
         var3.mItemCount = Math.min(this.this$0.mTileSize, this.mItemCount - var3.mStartPosition);
         this.this$0.mDataCallback.fillData(var3.mItems, var3.mStartPosition, var3.mItemCount);
         this.flushTileCache(var2);
         this.addTile(var3);
      }
   }

   public void recycleTile(TileList$Tile<T> var1) {
      this.this$0.mDataCallback.recycleData(var1.mItems, var1.mItemCount);
      var1.mNext = this.mRecycledRoot;
      this.mRecycledRoot = var1;
   }

   public void refresh(int var1) {
      this.mGeneration = var1;
      this.mLoadedTiles.clear();
      this.mItemCount = this.this$0.mDataCallback.refreshData();
      this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
   }

   public void updateRange(int var1, int var2, int var3, int var4, int var5) {
      if(var1 <= var2) {
         var1 = this.getTileStart(var1);
         var2 = this.getTileStart(var2);
         this.mFirstRequiredTileStart = this.getTileStart(var3);
         this.mLastRequiredTileStart = this.getTileStart(var4);
         if(var5 == 1) {
            this.requestTiles(this.mFirstRequiredTileStart, var2, var5, true);
            this.requestTiles(this.this$0.mTileSize + var2, this.mLastRequiredTileStart, var5, false);
         } else {
            this.requestTiles(var1, this.mLastRequiredTileStart, var5, false);
            this.requestTiles(this.mFirstRequiredTileStart, var1 - this.this$0.mTileSize, var5, true);
         }
      }
   }
}
