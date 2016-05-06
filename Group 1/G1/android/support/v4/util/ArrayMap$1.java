package android.support.v4.util;

import java.util.Map;

class ArrayMap$1 extends MapCollections<K, V> {
    final /* synthetic */ ArrayMap this$0;
    
    ArrayMap$1(final ArrayMap this$0) {
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
}