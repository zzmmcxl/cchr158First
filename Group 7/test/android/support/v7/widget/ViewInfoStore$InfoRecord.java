package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.util.Pools$Pool;
import android.support.v4.util.Pools$SimplePool;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;

class ViewInfoStore$InfoRecord {
   static final int FLAG_APPEAR = 2;
   static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
   static final int FLAG_APPEAR_PRE_AND_POST = 14;
   static final int FLAG_DISAPPEARED = 1;
   static final int FLAG_POST = 8;
   static final int FLAG_PRE = 4;
   static final int FLAG_PRE_AND_POST = 12;
   static Pools$Pool<ViewInfoStore$InfoRecord> sPool = new Pools$SimplePool(20);
   int flags;
   @Nullable
   RecyclerView$ItemAnimator$ItemHolderInfo postInfo;
   @Nullable
   RecyclerView$ItemAnimator$ItemHolderInfo preInfo;

   static void drainCache() {
      while(sPool.acquire() != null) {
         ;
      }

   }

   static ViewInfoStore$InfoRecord obtain() {
      ViewInfoStore$InfoRecord var1 = (ViewInfoStore$InfoRecord)sPool.acquire();
      ViewInfoStore$InfoRecord var0 = var1;
      if(var1 == null) {
         var0 = new ViewInfoStore$InfoRecord();
      }

      return var0;
   }

   static void recycle(ViewInfoStore$InfoRecord var0) {
      var0.flags = 0;
      var0.preInfo = null;
      var0.postInfo = null;
      sPool.release(var0);
   }
}
