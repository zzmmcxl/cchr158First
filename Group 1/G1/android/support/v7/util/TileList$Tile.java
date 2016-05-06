package android.support.v7.util;

import java.lang.reflect.Array;

public static class Tile<T>
{
    public int mItemCount;
    public final T[] mItems;
    Tile<T> mNext;
    public int mStartPosition;
    
    public Tile(final Class<T> clazz, final int n) {
        super();
        this.mItems = (Object[])Array.newInstance(clazz, n);
    }
    
    boolean containsPosition(final int n) {
        return mStartPosition <= n && n < mStartPosition + mItemCount;
    }
    
    T getByPosition(final int n) {
        return (T)mItems[n - mStartPosition];
    }
}
