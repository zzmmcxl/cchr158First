package android.support.v7.util;

import android.support.v7.util.AsyncListUtil;
import android.support.v7.util.ThreadUtil$MainThreadCallback;
import android.support.v7.util.TileList$Tile;
import android.util.Log;

class AsyncListUtil$1 implements ThreadUtil$MainThreadCallback<T> {
   AsyncListUtil$1(AsyncListUtil var1) {
      this.this$0 = var1;
   }

   private boolean isRequestedGeneration(int var1) {
      return var1 == this.this$0.mRequestedGeneration;
   }

   private void recycleAllTiles() {
      for(int var1 = 0; var1 < this.this$0.mTileList.size(); ++var1) {
         this.this$0.mBackgroundProxy.recycleTile(this.this$0.mTileList.getAtIndex(var1));
      }

      this.this$0.mTileList.clear();
   }

   public void addTile(int var1, TileList$Tile<T> var2) {
      if(!this.isRequestedGeneration(var1)) {
         this.this$0.mBackgroundProxy.recycleTile(var2);
      } else {
         TileList$Tile var6 = this.this$0.mTileList.addOrReplace(var2);
         if(var6 != null) {
            Log.e("AsyncListUtil", "duplicate tile @" + var6.mStartPosition);
            this.this$0.mBackgroundProxy.recycleTile(var6);
         }

         int var3 = var2.mStartPosition;
         int var4 = var2.mItemCount;
         var1 = 0;

         while(true) {
            while(var1 < AsyncListUtil.access$300(this.this$0).size()) {
               int var5 = AsyncListUtil.access$300(this.this$0).keyAt(var1);
               if(var2.mStartPosition <= var5 && var5 < var3 + var4) {
                  AsyncListUtil.access$300(this.this$0).removeAt(var1);
                  this.this$0.mViewCallback.onItemLoaded(var5);
               } else {
                  ++var1;
               }
            }

            return;
         }
      }
   }

   public void removeTile(int var1, int var2) {
      if(this.isRequestedGeneration(var1)) {
         TileList$Tile var3 = this.this$0.mTileList.removeAtPos(var2);
         if(var3 == null) {
            Log.e("AsyncListUtil", "tile not found @" + var2);
         } else {
            this.this$0.mBackgroundProxy.recycleTile(var3);
         }
      }
   }

   public void updateItemCount(int var1, int var2) {
      if(this.isRequestedGeneration(var1)) {
         AsyncListUtil.access$002(this.this$0, var2);
         this.this$0.mViewCallback.onDataRefresh();
         this.this$0.mDisplayedGeneration = this.this$0.mRequestedGeneration;
         this.recycleAllTiles();
         AsyncListUtil.access$102(this.this$0, false);
         AsyncListUtil.access$200(this.this$0);
      }
   }
}
