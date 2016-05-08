package android.support.v7.util;

import android.support.v7.util.MessageThreadUtil$1;
import android.support.v7.util.MessageThreadUtil$2;
import android.support.v7.util.ThreadUtil;
import android.support.v7.util.ThreadUtil$BackgroundCallback;
import android.support.v7.util.ThreadUtil$MainThreadCallback;

class MessageThreadUtil<T> implements ThreadUtil<T> {
   public ThreadUtil$BackgroundCallback<T> getBackgroundProxy(ThreadUtil$BackgroundCallback<T> var1) {
      return new MessageThreadUtil$2(this, var1);
   }

   public ThreadUtil$MainThreadCallback<T> getMainThreadProxy(ThreadUtil$MainThreadCallback<T> var1) {
      return new MessageThreadUtil$1(this, var1);
   }
}
