package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;

abstract class MapCollections<K, V>
{
    EntrySet mEntrySet;
    KeySet mKeySet;
    ValuesCollection mValues;
    
    MapCollections() {
        super();
    }
    
    public static <K, V> boolean containsAllHelper(final Map<K, V> map, final Collection<?> collection) {
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!map.containsKey(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static <T> boolean equalsSetHelper(final Set<T> set, final Object o) {
        boolean b = true;
        boolean b2;
        if (set == o) {
            b2 = b;
        }
        else {
            final boolean b3 = o instanceof Set;
            b2 = false;
            if (b3) {
                final Set set2 = (Set)o;
                try {
                    if (set.size() != set2.size() || !set.containsAll(set2)) {
                        b = false;
                    }
                    return b;
                }
                catch (NullPointerException ex) {
                    return false;
                }
                catch (ClassCastException ex2) {
                    return false;
                }
            }
        }
        return b2;
    }
    
    public static <K, V> boolean removeAllHelper(final Map<K, V> map, final Collection<?> collection) {
        final int size = map.size();
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            map.remove(iterator.next());
        }
        return size != map.size();
    }
    
    public static <K, V> boolean retainAllHelper(final Map<K, V> map, final Collection<?> collection) {
        final int size = map.size();
        final Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != map.size();
    }
    
    protected abstract void colClear();
    
    protected abstract Object colGetEntry(final int p0, final int p1);
    
    protected abstract Map<K, V> colGetMap();
    
    protected abstract int colGetSize();
    
    protected abstract int colIndexOfKey(final Object p0);
    
    protected abstract int colIndexOfValue(final Object p0);
    
    protected abstract void colPut(final K p0, final V p1);
    
    protected abstract void colRemoveAt(final int p0);
    
    protected abstract V colSetValue(final int p0, final V p1);
    
    public Set<Map.Entry<K, V>> getEntrySet() {
        if (mEntrySet == null) {
            mEntrySet = new EntrySet();
        }
        return mEntrySet;
    }
    
    public Set<K> getKeySet() {
        if (mKeySet == null) {
            mKeySet = new KeySet();
        }
        return mKeySet;
    }
    
    public Collection<V> getValues() {
        if (mValues == null) {
            mValues = new ValuesCollection();
        }
        return mValues;
    }
    
    public Object[] toArrayHelper(final int n) {
        final int colGetSize = this.colGetSize();
        final Object[] array = new Object[colGetSize];
        for (int i = 0; i < colGetSize; ++i) {
            array[i] = this.colGetEntry(i, n);
        }
        return array;
    }
    
    public <T> T[] toArrayHelper(T[] array, final int n) {
        final int colGetSize = this.colGetSize();
        if (array.length < colGetSize) {
            array = (T[])Array.newInstance(array.getClass().getComponentType(), colGetSize);
        }
        for (int i = 0; i < colGetSize; ++i) {
            array[i] = (T)this.colGetEntry(i, n);
        }
        if (array.length > colGetSize) {
            array[colGetSize] = null;
        }
        return array;
    }
}
