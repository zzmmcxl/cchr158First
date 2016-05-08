package android.support.v7.util;

import android.support.v7.util.ThreadUtil$BackgroundCallback;
import android.support.v7.util.ThreadUtil$MainThreadCallback;

interface ThreadUtil<T> {
   ThreadUtil$BackgroundCallback<T> getBackgroundProxy(ThreadUtil$BackgroundCallback<T> var1);

   ThreadUtil$MainThreadCallback<T> getMainThreadProxy(ThreadUtil$MainThreadCallback<T> var1);
}
