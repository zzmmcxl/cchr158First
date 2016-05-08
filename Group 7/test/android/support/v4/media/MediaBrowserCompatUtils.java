package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import java.util.List;

public class MediaBrowserCompatUtils {
   public static List<MediaBrowserCompat$MediaItem> applyOptions(List<MediaBrowserCompat$MediaItem> var0, Bundle var1) {
      int var2 = var1.getInt("android.media.browse.extra.PAGE", -1);
      int var5 = var1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      if(var2 == -1 && var5 == -1) {
         return var0;
      } else {
         int var4 = var5 * (var2 - 1);
         int var3 = var4 + var5;
         if(var2 >= 1 && var5 >= 1 && var4 < var0.size()) {
            var2 = var3;
            if(var3 > var0.size()) {
               var2 = var0.size();
            }

            return var0.subList(var4, var2);
         } else {
            return null;
         }
      }
   }

   public static boolean areSameOptions(Bundle var0, Bundle var1) {
      if(var0 != var1) {
         if(var0 == null) {
            if(var1.getInt("android.media.browse.extra.PAGE", -1) != -1 || var1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
               return false;
            }
         } else if(var1 == null) {
            if(var0.getInt("android.media.browse.extra.PAGE", -1) != -1 || var0.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
               return false;
            }
         } else if(var0.getInt("android.media.browse.extra.PAGE", -1) != var1.getInt("android.media.browse.extra.PAGE", -1) || var0.getInt("android.media.browse.extra.PAGE_SIZE", -1) != var1.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            return false;
         }
      }

      return true;
   }

   public static boolean hasDuplicatedItems(Bundle var0, Bundle var1) {
      int var4;
      if(var0 == null) {
         var4 = -1;
      } else {
         var4 = var0.getInt("android.media.browse.extra.PAGE", -1);
      }

      int var2;
      if(var1 == null) {
         var2 = -1;
      } else {
         var2 = var1.getInt("android.media.browse.extra.PAGE", -1);
      }

      int var5;
      if(var0 == null) {
         var5 = -1;
      } else {
         var5 = var0.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      }

      int var3;
      if(var1 == null) {
         var3 = -1;
      } else {
         var3 = var1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      }

      int var6;
      if(var4 != -1 && var5 != -1) {
         var6 = var5 * (var4 - 1);
         var4 = var6 + var5 - 1;
         var5 = var6;
      } else {
         var5 = 0;
         var4 = Integer.MAX_VALUE;
      }

      if(var2 != -1 && var3 != -1) {
         var6 = var3 * (var2 - 1);
         var2 = var6 + var3 - 1;
         var3 = var6;
      } else {
         var3 = 0;
         var2 = Integer.MAX_VALUE;
      }

      return var5 <= var3 && var3 <= var4 || var5 <= var2 && var2 <= var4;
   }
}
