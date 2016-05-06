package android.support.v4.util;

import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class EntrySet implements Set<Map.Entry<K, V>>
{
    final /* synthetic */ MapCollections this$0;
    
    EntrySet(final MapCollections this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public /* bridge */ boolean add(final Object o) {
        return this.add((Map.Entry<K, V>)(Map.Entry)o);
    }
    
    @Override
    public boolean add(final Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(final Collection<? extends Map.Entry<K, V>> collection) {
        final int colGetSize = this$0.colGetSize();
        for (final Map.Entry<K, V> entry : collection) {
            this$0.colPut(entry.getKey(), entry.getValue());
        }
        return colGetSize != this$0.colGetSize();
    }
    
    @Override
    public void clear() {
        this$0.colClear();
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final int colIndexOfKey = this$0.colIndexOfKey(entry.getKey());
            if (colIndexOfKey >= 0) {
                return ContainerHelpers.equal(this$0.colGetEntry(colIndexOfKey, 1), entry.getValue());
            }
        }
        return false;
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                return false;
            }
        }
        return true;
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
            final Object colGetEntry2 = this$0.colGetEntry(i, 1);
            int hashCode;
            if (colGetEntry == null) {
                hashCode = 0;
            }
            else {
                hashCode = colGetEntry.hashCode();
            }
            int hashCode2;
            if (colGetEntry2 == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = colGetEntry2.hashCode();
            }
            n += (hashCode2 ^ hashCode);
        }
        return n;
    }
    
    @Override
    public boolean isEmpty() {
        return this$0.colGetSize() == 0;
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return this$0.new MapIterator();
    }
    
    @Override
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
        return this$0.colGetSize();
    }
    
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        throw new UnsupportedOperationException();
    }
}
