package android.support.v7.util;

import android.support.v7.util.TileList$Tile;

public interface ThreadUtil$BackgroundCallback<T> {
   void loadTile(int var1, int var2);

   void recycleTile(TileList$Tile<T> var1);

   void refresh(int var1);

   void updateRange(int var1, int var2, int var3, int var4, int var5);
}
