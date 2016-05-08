package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup {
   private boolean mCacheSpanIndices = false;
   final SparseIntArray mSpanIndexCache = new SparseIntArray();

   int findReferenceIndexFromCache(int var1) {
      int var2 = 0;
      int var3 = this.mSpanIndexCache.size() - 1;

      while(var2 <= var3) {
         int var4 = var2 + var3 >>> 1;
         if(this.mSpanIndexCache.keyAt(var4) < var1) {
            var2 = var4 + 1;
         } else {
            var3 = var4 - 1;
         }
      }

      var1 = var2 - 1;
      if(var1 >= 0 && var1 < this.mSpanIndexCache.size()) {
         return this.mSpanIndexCache.keyAt(var1);
      } else {
         return -1;
      }
   }

   int getCachedSpanIndex(int var1, int var2) {
      int var3;
      if(!this.mCacheSpanIndices) {
         var3 = this.getSpanIndex(var1, var2);
      } else {
         int var4 = this.mSpanIndexCache.get(var1, -1);
         var3 = var4;
         if(var4 == -1) {
            var2 = this.getSpanIndex(var1, var2);
            this.mSpanIndexCache.put(var1, var2);
            return var2;
         }
      }

      return var3;
   }

   public int getSpanGroupIndex(int var1, int var2) {
      int var3 = 0;
      int var4 = 0;
      int var9 = this.getSpanSize(var1);

      int var5;
      for(int var6 = 0; var6 < var1; var4 = var5) {
         int var7 = this.getSpanSize(var6);
         int var8 = var3 + var7;
         if(var8 == var2) {
            var3 = 0;
            var5 = var4 + 1;
         } else {
            var5 = var4;
            var3 = var8;
            if(var8 > var2) {
               var3 = var7;
               var5 = var4 + 1;
            }
         }

         ++var6;
      }

      var1 = var4;
      if(var3 + var9 > var2) {
         var1 = var4 + 1;
      }

      return var1;
   }

   public int getSpanIndex(int var1, int var2) {
      int var7 = this.getSpanSize(var1);
      if(var7 == var2) {
         var1 = 0;
      } else {
         byte var5 = 0;
         byte var6 = 0;
         int var3 = var5;
         int var4 = var6;
         if(this.mCacheSpanIndices) {
            var3 = var5;
            var4 = var6;
            if(this.mSpanIndexCache.size() > 0) {
               int var8 = this.findReferenceIndexFromCache(var1);
               var3 = var5;
               var4 = var6;
               if(var8 >= 0) {
                  var3 = this.mSpanIndexCache.get(var8) + this.getSpanSize(var8);
                  var4 = var8 + 1;
               }
            }
         }

         for(; var4 < var1; ++var4) {
            int var9 = this.getSpanSize(var4);
            int var10 = var3 + var9;
            if(var10 == var2) {
               var3 = 0;
            } else {
               var3 = var10;
               if(var10 > var2) {
                  var3 = var9;
               }
            }
         }

         var1 = var3;
         if(var3 + var7 > var2) {
            return 0;
         }
      }

      return var1;
   }

   public abstract int getSpanSize(int var1);

   public void invalidateSpanIndexCache() {
      this.mSpanIndexCache.clear();
   }

   public boolean isSpanIndexCacheEnabled() {
      return this.mCacheSpanIndices;
   }

   public void setSpanIndexCacheEnabled(boolean var1) {
      this.mCacheSpanIndices = var1;
   }
}
