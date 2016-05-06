package android.support.v4.util;

import java.util.Iterator;

final class ArrayIterator<T> implements Iterator<T>
{
    boolean mCanRemove;
    int mIndex;
    final int mOffset;
    int mSize;
    final /* synthetic */ MapCollections this$0;
    
    ArrayIterator(final MapCollections this$0, final int mOffset) {
        this$0 = this$0;
        super();
        mCanRemove = false;
        mOffset = mOffset;
        mSize = this$0.colGetSize();
    }
    
    @Override
    public boolean hasNext() {
        return mIndex < mSize;
    }
    
    @Override
    public T next() {
        final Object colGetEntry = this$0.colGetEntry(mIndex, mOffset);
        ++mIndex;
        mCanRemove = true;
        return (T)colGetEntry;
    }
    
    @Override
    public void remove() {
        if (!mCanRemove) {
            throw new IllegalStateException();
        }
        --mIndex;
        --mSize;
        mCanRemove = false;
        this$0.colRemoveAt(mIndex);
    }
}
