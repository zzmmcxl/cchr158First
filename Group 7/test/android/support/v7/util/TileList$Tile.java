package android.support.v7.util;

import java.lang.reflect.Array;

public class TileList$Tile<T> {
   public int mItemCount;
   public final T[] mItems;
   TileList$Tile<T> mNext;
   public int mStartPosition;

   public TileList$Tile(Class<T> var1, int var2) {
      this.mItems = (Object[])((Object[])Array.newInstance(var1, var2));
   }

   boolean containsPosition(int var1) {
      return this.mStartPosition <= var1 && var1 < this.mStartPosition + this.mItemCount;
   }

   T getByPosition(int var1) {
      return this.mItems[var1 - this.mStartPosition];
   }
}
