package android.support.v7.util;

import android.support.v7.util.TileList$Tile;
import android.util.SparseArray;

class TileList<T> {
   TileList$Tile<T> mLastAccessedTile;
   final int mTileSize;
   private final SparseArray<TileList$Tile<T>> mTiles = new SparseArray(10);

   public TileList(int var1) {
      this.mTileSize = var1;
   }

   public TileList$Tile<T> addOrReplace(TileList$Tile<T> var1) {
      int var2 = this.mTiles.indexOfKey(var1.mStartPosition);
      TileList$Tile var3;
      if(var2 < 0) {
         this.mTiles.put(var1.mStartPosition, var1);
         var3 = null;
      } else {
         TileList$Tile var4 = (TileList$Tile)this.mTiles.valueAt(var2);
         this.mTiles.setValueAt(var2, var1);
         var3 = var4;
         if(this.mLastAccessedTile == var4) {
            this.mLastAccessedTile = var1;
            return var4;
         }
      }

      return var3;
   }

   public void clear() {
      this.mTiles.clear();
   }

   public TileList$Tile<T> getAtIndex(int var1) {
      return (TileList$Tile)this.mTiles.valueAt(var1);
   }

   public T getItemAt(int var1) {
      if(this.mLastAccessedTile == null || !this.mLastAccessedTile.containsPosition(var1)) {
         int var2 = this.mTileSize;
         var2 = this.mTiles.indexOfKey(var1 - var1 % var2);
         if(var2 < 0) {
            return null;
         }

         this.mLastAccessedTile = (TileList$Tile)this.mTiles.valueAt(var2);
      }

      return this.mLastAccessedTile.getByPosition(var1);
   }

   public TileList$Tile<T> removeAtPos(int var1) {
      TileList$Tile var2 = (TileList$Tile)this.mTiles.get(var1);
      if(this.mLastAccessedTile == var2) {
         this.mLastAccessedTile = null;
      }

      this.mTiles.delete(var1);
      return var2;
   }

   public int size() {
      return this.mTiles.size();
   }
}
