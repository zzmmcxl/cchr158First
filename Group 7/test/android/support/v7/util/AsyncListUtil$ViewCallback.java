package android.support.v7.util;

import android.support.annotation.UiThread;

public abstract class AsyncListUtil$ViewCallback {
   public static final int HINT_SCROLL_ASC = 2;
   public static final int HINT_SCROLL_DESC = 1;
   public static final int HINT_SCROLL_NONE = 0;

   @UiThread
   public void extendRangeInto(int[] var1, int[] var2, int var3) {
      int var4 = var1[1] - var1[0] + 1;
      int var5 = var4 / 2;
      int var7 = var1[0];
      int var6;
      if(var3 == 1) {
         var6 = var4;
      } else {
         var6 = var5;
      }

      var2[0] = var7 - var6;
      var6 = var1[1];
      if(var3 != 2) {
         var4 = var5;
      }

      var2[1] = var6 + var4;
   }

   @UiThread
   public abstract void getItemRangeInto(int[] var1);

   @UiThread
   public abstract void onDataRefresh();

   @UiThread
   public abstract void onItemLoaded(int var1);
}
