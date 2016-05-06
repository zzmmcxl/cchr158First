package android.support.v4.util;

import java.util.Map;
import java.util.LinkedHashMap;

public class LruCache<K, V>
{
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
    
    public LruCache(final int maxSize) {
        super();
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        maxSize = maxSize;
        map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }
    
    private int safeSizeOf(final K k, final V v) {
        final int size = this.sizeOf(k, v);
        if (size < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return size;
    }
    
    protected V create(final K k) {
        return null;
    }
    
    public final int createCount() {
        synchronized (this) {
            return createCount;
        }
    }
    
    protected void entryRemoved(final boolean b, final K k, final V v, final V v2) {
    }
    
    public final void evictAll() {
        this.trimToSize(-1);
    }
    
    public final int evictionCount() {
        synchronized (this) {
            return evictionCount;
        }
    }
    
    public final V get(final K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        final V create;
        synchronized (this) {
            final V value = map.get(k);
            if (value != null) {
                ++hitCount;
                return value;
            }
            ++missCount;
            // monitorexit(this)
            create = this.create(k);
            if (create == null) {
                return null;
            }
        }
        synchronized (this) {
            ++createCount;
            final V put = map.put(k, create);
            if (put != null) {
                map.put(k, put);
            }
            else {
                size += this.safeSizeOf(k, create);
            }
            // monitorexit(this)
            if (put != null) {
                this.entryRemoved(false, k, create, put);
                return put;
            }
        }
        this.trimToSize(maxSize);
        return create;
    }
    
    public final int hitCount() {
        synchronized (this) {
            return hitCount;
        }
    }
    
    public final int maxSize() {
        synchronized (this) {
            return maxSize;
        }
    }
    
    public final int missCount() {
        synchronized (this) {
            return missCount;
        }
    }
    
    public final V put(final K k, final V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            ++putCount;
            size += this.safeSizeOf(k, v);
            final V put = map.put(k, v);
            if (put != null) {
                size -= this.safeSizeOf(k, put);
            }
            // monitorexit(this)
            if (put != null) {
                this.entryRemoved(false, k, put, v);
            }
            this.trimToSize(maxSize);
            return put;
        }
    }
    
    public final int putCount() {
        synchronized (this) {
            return putCount;
        }
    }
    
    public final V remove(final K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            final V remove = map.remove(k);
            if (remove != null) {
                size -= this.safeSizeOf(k, remove);
            }
            // monitorexit(this)
            if (remove != null) {
                this.entryRemoved(false, k, remove, null);
            }
            return remove;
        }
    }
    
    public void resize(final int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = maxSize;
            // monitorexit(this)
            this.trimToSize(maxSize);
        }
    }
    
    public final int size() {
        synchronized (this) {
            return size;
        }
    }
    
    protected int sizeOf(final K k, final V v) {
        return 1;
    }
    
    public final Map<K, V> snapshot() {
        synchronized (this) {
            return new LinkedHashMap<K, V>((Map<? extends K, ? extends V>)map);
        }
    }
    
    @Override
    public final String toString() {
        synchronized (this) {
            final int n = hitCount + missCount;
            int n2 = 0;
            if (n != 0) {
                n2 = 100 * hitCount / n;
            }
            return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", maxSize, hitCount, missCount, n2);
        }
    }
    
    public void trimToSize(final int n) {
        while (true) {
            synchronized (this) {
                if (size < 0 || (map.isEmpty() && size != 0)) {
                    throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                }
            }
            if (size <= n || map.isEmpty()) {
                break;
            }
            final Map.Entry<K, V> entry = (Map.Entry<K, V>)map.entrySet().iterator().next();
            final K key = entry.getKey();
            final V value = entry.getValue();
            map.remove(key);
            size -= this.safeSizeOf(key, value);
            ++evictionCount;
            // monitorexit(this)
            this.entryRemoved(true, key, value, null);
        }
    }
    // monitorexit(this)
}
