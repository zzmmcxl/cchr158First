package android.support.v4.util;

import java.util.Iterator;
import java.util.Collection;
import java.util.Set;

final class KeySet implements Set<K>
{
    final /* synthetic */ MapCollections this$0;
    
    KeySet(final MapCollections this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean add(final K k) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(final Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        this$0.colClear();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this$0.colIndexOfKey(o) >= 0;
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return MapCollections.<Object, Object>containsAllHelper(this$0.colGetMap(), collection);
    }
    
    @Override
    public boolean equals(final Object o) {
        return MapCollections.<Object>equalsSetHelper((Set<Object>)this, o);
    }
    
    @Override
    public int hashCode() {
        int n = 0;
        for (int i = -1 + this$0.colGetSize(); i >= 0; --i) {
            final Object colGetEntry = this$0.colGetEntry(i, 0);
            int hashCode;
            if (colGetEntry == null) {
                hashCode = 0;
            }
            else {
                hashCode = colGetEntry.hashCode();
            }
            n += hashCode;
        }
        return n;
    }
    
    @Override
    public boolean isEmpty() {
        return this$0.colGetSize() == 0;
    }
    
    @Override
    public Iterator<K> iterator() {
        return (Iterator<K>)this$0.new ArrayIterator(0);
    }
    
    @Override
    public boolean remove(final Object o) {
        final int colIndexOfKey = this$0.colIndexOfKey(o);
        if (colIndexOfKey >= 0) {
            this$0.colRemoveAt(colIndexOfKey);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        return MapCollections.<Object, Object>removeAllHelper(this$0.colGetMap(), collection);
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        return MapCollections.<Object, Object>retainAllHelper(this$0.colGetMap(), collection);
    }
    
    @Override
    public int size() {
        return this$0.colGetSize();
    }
    
    @Override
    public Object[] toArray() {
        return this$0.toArrayHelper(0);
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        return this$0.<T>toArrayHelper(array, 0);
    }
}
