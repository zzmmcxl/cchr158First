package android.support.v4.util;

import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Map;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V>
{
    MapCollections<K, V> mCollections;
    
    public ArrayMap() {
        super();
    }
    
    public ArrayMap(final int n) {
        super(n);
    }
    
    public ArrayMap(final SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
    
    private MapCollections<K, V> getCollection() {
        if (mCollections == null) {
            mCollections = new MapCollections<K, V>() {
                final /* synthetic */ ArrayMap this$0;
                
                ArrayMap$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                protected void colClear() {
                    this$0.clear();
                }
                
                @Override
                protected Object colGetEntry(final int n, final int n2) {
                    return this$0.mArray[n2 + (n << 1)];
                }
                
                @Override
                protected Map<K, V> colGetMap() {
                    return (Map<K, V>)this$0;
                }
                
                @Override
                protected int colGetSize() {
                    return this$0.mSize;
                }
                
                @Override
                protected int colIndexOfKey(final Object o) {
                    return this$0.indexOfKey(o);
                }
                
                @Override
                protected int colIndexOfValue(final Object o) {
                    return this$0.indexOfValue(o);
                }
                
                @Override
                protected void colPut(final K k, final V v) {
                    this$0.put(k, v);
                }
                
                @Override
                protected void colRemoveAt(final int n) {
                    this$0.removeAt(n);
                }
                
                @Override
                protected V colSetValue(final int n, final V v) {
                    return this$0.setValueAt(n, v);
                }
            };
        }
        return mCollections;
    }
    
    public boolean containsAll(final Collection<?> collection) {
        return MapCollections.<Object, Object>containsAllHelper((Map<Object, Object>)this, collection);
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.getCollection().getEntrySet();
    }
    
    @Override
    public Set<K> keySet() {
        return this.getCollection().getKeySet();
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        this.ensureCapacity(this.mSize + map.size());
        for (final Entry<? extends K, ? extends V> entry : map.entrySet()) {
            this.put((K)entry.getKey(), (V)entry.getValue());
        }
    }
    
    public boolean removeAll(final Collection<?> collection) {
        return MapCollections.<Object, Object>removeAllHelper((Map<Object, Object>)this, collection);
    }
    
    public boolean retainAll(final Collection<?> collection) {
        return MapCollections.<Object, Object>retainAllHelper((Map<Object, Object>)this, collection);
    }
    
    @Override
    public Collection<V> values() {
        return this.getCollection().getValues();
    }
}
