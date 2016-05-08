package android.support.v7.util;

import android.support.v7.util.TileList$Tile;

public interface ThreadUtil$MainThreadCallback<T> {
   void addTile(int var1, TileList$Tile<T> var2);

   void removeTile(int var1, int var2);

   void updateItemCount(int var1, int var2);
}
