package android.support.v4.util;

import java.util.Iterator;
import java.util.Collection;

final class ValuesCollection implements Collection<V>
{
    final /* synthetic */ MapCollections this$0;
    
    ValuesCollection(final MapCollections this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean add(final V v) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(final Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        this$0.colClear();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this$0.colIndexOfValue(o) >= 0;
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
    public boolean isEmpty() {
        return this$0.colGetSize() == 0;
    }
    
    @Override
    public Iterator<V> iterator() {
        return (Iterator<V>)this$0.new ArrayIterator(1);
    }
    
    @Override
    public boolean remove(final Object o) {
        final int colIndexOfValue = this$0.colIndexOfValue(o);
        if (colIndexOfValue >= 0) {
            this$0.colRemoveAt(colIndexOfValue);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        int colGetSize = this$0.colGetSize();
        boolean b = false;
        for (int i = 0; i < colGetSize; ++i) {
            if (collection.contains(this$0.colGetEntry(i, 1))) {
                this$0.colRemoveAt(i);
                --i;
                --colGetSize;
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        int colGetSize = this$0.colGetSize();
        boolean b = false;
        for (int i = 0; i < colGetSize; ++i) {
            if (!collection.contains(this$0.colGetEntry(i, 1))) {
                this$0.colRemoveAt(i);
                --i;
                --colGetSize;
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public int size() {
        return this$0.colGetSize();
    }
    
    @Override
    public Object[] toArray() {
        return this$0.toArrayHelper(1);
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        return this$0.<T>toArrayHelper(array, 1);
    }
}
