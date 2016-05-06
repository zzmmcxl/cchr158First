package android.support.v4.util;

import java.util.Map;
import java.util.Iterator;

final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V>
{
    int mEnd;
    boolean mEntryValid;
    int mIndex;
    final /* synthetic */ MapCollections this$0;
    
    MapIterator(final MapCollections this$0) {
        this$0 = this$0;
        super();
        mEntryValid = false;
        mEnd = -1 + this$0.colGetSize();
        mIndex = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        int n = 1;
        if (!mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(o instanceof Entry)) {
            return false;
        }
        final Entry entry = (Entry)o;
        if (!ContainerHelpers.equal(entry.getKey(), this$0.colGetEntry(mIndex, 0)) || !ContainerHelpers.equal(entry.getValue(), this$0.colGetEntry(mIndex, n))) {
            n = 0;
        }
        return n != 0;
    }
    
    @Override
    public K getKey() {
        if (!mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return (K)this$0.colGetEntry(mIndex, 0);
    }
    
    @Override
    public V getValue() {
        if (!mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return (V)this$0.colGetEntry(mIndex, 1);
    }
    
    @Override
    public boolean hasNext() {
        return mIndex < mEnd;
    }
    
    @Override
    public final int hashCode() {
        if (!mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        final Object colGetEntry = this$0.colGetEntry(mIndex, 0);
        final Object colGetEntry2 = this$0.colGetEntry(mIndex, 1);
        int hashCode;
        if (colGetEntry == null) {
            hashCode = 0;
        }
        else {
            hashCode = colGetEntry.hashCode();
        }
        int hashCode2 = 0;
        if (colGetEntry2 != null) {
            hashCode2 = colGetEntry2.hashCode();
        }
        return hashCode2 ^ hashCode;
    }
    
    @Override
    public /* bridge */ Object next() {
        return this.next();
    }
    
    @Override
    public Entry<K, V> next() {
        ++mIndex;
        mEntryValid = true;
        return this;
    }
    
    @Override
    public void remove() {
        if (!mEntryValid) {
            throw new IllegalStateException();
        }
        this$0.colRemoveAt(mIndex);
        --mIndex;
        --mEnd;
        mEntryValid = false;
    }
    
    @Override
    public V setValue(final V v) {
        if (!mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this$0.colSetValue(mIndex, v);
    }
    
    @Override
    public final String toString() {
        return this.getKey() + "=" + this.getValue();
    }
}
