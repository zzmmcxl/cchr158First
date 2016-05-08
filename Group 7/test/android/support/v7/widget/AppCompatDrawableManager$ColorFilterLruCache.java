package android.support.v7.widget;

import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff.Mode;
import android.support.v4.util.LruCache;

class AppCompatDrawableManager$ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
   public AppCompatDrawableManager$ColorFilterLruCache(int var1) {
      super(var1);
   }

   private static int generateCacheKey(int var0, Mode var1) {
      return (var0 + 31) * 31 + var1.hashCode();
   }

   PorterDuffColorFilter get(int var1, Mode var2) {
      return (PorterDuffColorFilter)this.get(Integer.valueOf(generateCacheKey(var1, var2)));
   }

   PorterDuffColorFilter put(int var1, Mode var2, PorterDuffColorFilter var3) {
      return (PorterDuffColorFilter)this.put(Integer.valueOf(generateCacheKey(var1, var2)), var3);
   }
}
