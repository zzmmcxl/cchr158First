package android.support.v4.util;

import android.support.v4.util.Pools$SimplePool;

public class Pools$SynchronizedPool<T> extends Pools$SimplePool<T> {
   private final Object mLock = new Object();

   public Pools$SynchronizedPool(int var1) {
      super(var1);
   }

   public T acquire() {
      // $FF: Couldn't be decompiled
   }

   public boolean release(T param1) {
      // $FF: Couldn't be decompiled
   }
}
