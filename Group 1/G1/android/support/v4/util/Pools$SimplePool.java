package android.support.v4.util;

public static class SimplePool<T> implements Pool<T>
{
    private final Object[] mPool;
    private int mPoolSize;
    
    public SimplePool(final int n) {
        super();
        if (n <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.mPool = new Object[n];
    }
    
    private boolean isInPool(final T t) {
        for (int i = 0; i < mPoolSize; ++i) {
            if (mPool[i] == t) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public T acquire() {
        if (mPoolSize > 0) {
            final int n = -1 + mPoolSize;
            final Object o = mPool[n];
            mPool[n] = null;
            --mPoolSize;
            return (T)o;
        }
        return null;
    }
    
    @Override
    public boolean release(final T t) {
        if (this.isInPool(t)) {
            throw new IllegalStateException("Already in the pool!");
        }
        if (mPoolSize < mPool.length) {
            mPool[mPoolSize] = t;
            ++mPoolSize;
            return true;
        }
        return false;
    }
}
