package android.support.v7.util;

interface ThreadUtil<T>
{
    BackgroundCallback<T> getBackgroundProxy(final BackgroundCallback<T> p0);
    
    MainThreadCallback<T> getMainThreadProxy(final MainThreadCallback<T> p0);
}
