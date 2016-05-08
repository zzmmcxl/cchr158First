package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ModernAsyncTask$1 implements ThreadFactory {
   private final AtomicInteger mCount = new AtomicInteger(1);

   public Thread newThread(Runnable var1) {
      return new Thread(var1, "ModernAsyncTask #" + this.mCount.getAndIncrement());
   }
}
