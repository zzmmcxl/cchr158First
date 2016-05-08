package android.support.v7.widget;

class PositionMap$ContainerHelpers {
   static final boolean[] EMPTY_BOOLEANS = new boolean[0];
   static final int[] EMPTY_INTS = new int[0];
   static final long[] EMPTY_LONGS = new long[0];
   static final Object[] EMPTY_OBJECTS = new Object[0];

   static int binarySearch(int[] var0, int var1, int var2) {
      byte var3 = 0;
      int var4 = var1 - 1;
      var1 = var3;
      int var6 = var4;

      while(true) {
         if(var1 > var6) {
            var6 = ~var1;
            break;
         }

         var4 = var1 + var6 >>> 1;
         int var5 = var0[var4];
         if(var5 < var2) {
            var1 = var4 + 1;
         } else {
            var6 = var4;
            if(var5 <= var2) {
               break;
            }

            var6 = var4 - 1;
         }
      }

      return var6;
   }
}
