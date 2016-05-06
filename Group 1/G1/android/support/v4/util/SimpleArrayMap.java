package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V>
{
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;
    
    public SimpleArrayMap() {
        super();
        mHashes = ContainerHelpers.EMPTY_INTS;
        mArray = ContainerHelpers.EMPTY_OBJECTS;
        mSize = 0;
    }
    
    public SimpleArrayMap(final int n) {
        super();
        if (n == 0) {
            mHashes = ContainerHelpers.EMPTY_INTS;
            mArray = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            this.allocArrays(n);
        }
        mSize = 0;
    }
    
    public SimpleArrayMap(final SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            this.putAll(simpleArrayMap);
        }
    }
    
    private void allocArrays(final int n) {
        while (true) {
            Label_0104: {
                if (n != 8) {
                    break Label_0104;
                }
                synchronized (ArrayMap.class) {
                    if (mTwiceBaseCache != null) {
                        final Object[] mTwiceBaseCache = SimpleArrayMap.mTwiceBaseCache;
                        mArray = mTwiceBaseCache;
                        SimpleArrayMap.mTwiceBaseCache = (Object[])mTwiceBaseCache[0];
                        mHashes = (int[])mTwiceBaseCache[1];
                        mTwiceBaseCache[0] = (mTwiceBaseCache[1] = null);
                        --mTwiceBaseCacheSize;
                        return;
                    }
                    // monitorexit(ArrayMap.class)
                    mHashes = new int[n];
                    mArray = new Object[n << 1];
                    return;
                }
            }
            if (n == 4) {
                synchronized (ArrayMap.class) {
                    if (mBaseCache != null) {
                        final Object[] mBaseCache = SimpleArrayMap.mBaseCache;
                        mArray = mBaseCache;
                        SimpleArrayMap.mBaseCache = (Object[])mBaseCache[0];
                        mHashes = (int[])mBaseCache[1];
                        mBaseCache[0] = (mBaseCache[1] = null);
                        --mBaseCacheSize;
                        return;
                    }
                }
                // monitorexit(ArrayMap.class)
                continue;
            }
            continue;
        }
    }
    
    private static void freeArrays(final int[] array, final Object[] array2, final int n) {
        if (array.length == 8) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    array2[0] = mTwiceBaseCache;
                    array2[1] = array;
                    for (int i = -1 + (n << 1); i >= 2; --i) {
                        array2[i] = null;
                    }
                    mTwiceBaseCache = array2;
                    ++mTwiceBaseCacheSize;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (ArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    array2[0] = mBaseCache;
                    array2[1] = array;
                    for (int j = -1 + (n << 1); j >= 2; --j) {
                        array2[j] = null;
                    }
                    mBaseCache = array2;
                    ++mBaseCacheSize;
                }
            }
        }
    }
    
    public void clear() {
        if (mSize != 0) {
            freeArrays(mHashes, mArray, mSize);
            mHashes = ContainerHelpers.EMPTY_INTS;
            mArray = ContainerHelpers.EMPTY_OBJECTS;
            mSize = 0;
        }
    }
    
    public boolean containsKey(final Object o) {
        return this.indexOfKey(o) >= 0;
    }
    
    public boolean containsValue(final Object o) {
        return this.indexOfValue(o) >= 0;
    }
    
    public void ensureCapacity(final int n) {
        if (mHashes.length < n) {
            final int[] mHashes = this.mHashes;
            final Object[] mArray = this.mArray;
            this.allocArrays(n);
            if (mSize > 0) {
                System.arraycopy(mHashes, 0, this.mHashes, 0, mSize);
                System.arraycopy(mArray, 0, this.mArray, 0, mSize << 1);
            }
            freeArrays(mHashes, mArray, mSize);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof Map) {
                final Map map = (Map)o;
                if (this.size() != map.size()) {
                    return false;
                }
                int i = 0;
                try {
                    while (i < mSize) {
                        final K key = this.keyAt(i);
                        final V value = this.valueAt(i);
                        final Object value2 = map.get(key);
                        if (value == null) {
                            if (value2 != null || !map.containsKey(key)) {
                                return false;
                            }
                        }
                        else if (!value.equals(value2)) {
                            return false;
                        }
                        ++i;
                    }
                    return true;
                }
                catch (NullPointerException ex) {
                    return false;
                }
                catch (ClassCastException ex2) {
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }
    
    public V get(final Object o) {
        final int indexOfKey = this.indexOfKey(o);
        if (indexOfKey >= 0) {
            return (V)mArray[1 + (indexOfKey << 1)];
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        final int[] mHashes = this.mHashes;
        final Object[] mArray = this.mArray;
        int n = 0;
        for (int i = 0, n2 = 1; i < mSize; ++i, n2 += 2) {
            final Object o = mArray[n2];
            final int n3 = mHashes[i];
            int hashCode;
            if (o == null) {
                hashCode = 0;
            }
            else {
                hashCode = o.hashCode();
            }
            n += (hashCode ^ n3);
        }
        return n;
    }
    
    int indexOf(final Object o, final int n) {
        final int mSize = this.mSize;
        int binarySearch;
        if (mSize == 0) {
            binarySearch = -1;
        }
        else {
            binarySearch = ContainerHelpers.binarySearch(mHashes, mSize, n);
            if (binarySearch >= 0 && !o.equals(mArray[binarySearch << 1])) {
                int n2;
                for (n2 = binarySearch + 1; n2 < mSize && mHashes[n2] == n; ++n2) {
                    if (o.equals(mArray[n2 << 1])) {
                        return n2;
                    }
                }
                for (int n3 = binarySearch - 1; n3 >= 0 && mHashes[n3] == n; --n3) {
                    if (o.equals(mArray[n3 << 1])) {
                        return n3;
                    }
                }
                return ~n2;
            }
        }
        return binarySearch;
    }
    
    public int indexOfKey(final Object o) {
        if (o == null) {
            return this.indexOfNull();
        }
        return this.indexOf(o, o.hashCode());
    }
    
    int indexOfNull() {
        final int mSize = this.mSize;
        int binarySearch;
        if (mSize == 0) {
            binarySearch = -1;
        }
        else {
            binarySearch = ContainerHelpers.binarySearch(mHashes, mSize, 0);
            if (binarySearch >= 0 && mArray[binarySearch << 1] != null) {
                int n;
                for (n = binarySearch + 1; n < mSize && mHashes[n] == 0; ++n) {
                    if (mArray[n << 1] == null) {
                        return n;
                    }
                }
                for (int n2 = binarySearch - 1; n2 >= 0 && mHashes[n2] == 0; --n2) {
                    if (mArray[n2 << 1] == null) {
                        return n2;
                    }
                }
                return ~n;
            }
        }
        return binarySearch;
    }
    
    int indexOfValue(final Object o) {
        final int n = 2 * mSize;
        final Object[] mArray = this.mArray;
        if (o == null) {
            for (int i = 1; i < n; i += 2) {
                if (mArray[i] == null) {
                    return i >> 1;
                }
            }
        }
        else {
            for (int j = 1; j < n; j += 2) {
                if (o.equals(mArray[j])) {
                    return j >> 1;
                }
            }
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return mSize <= 0;
    }
    
    public K keyAt(final int n) {
        return (K)mArray[n << 1];
    }
    
    public V put(final K k, final V v) {
        int n = 8;
        int hashCode;
        int n2;
        if (k == null) {
            hashCode = 0;
            n2 = this.indexOfNull();
        }
        else {
            hashCode = k.hashCode();
            n2 = this.indexOf(k, hashCode);
        }
        if (n2 >= 0) {
            final int n3 = 1 + (n2 << 1);
            final Object o = mArray[n3];
            mArray[n3] = v;
            return (V)o;
        }
        final int n4 = ~n2;
        if (mSize >= mHashes.length) {
            if (mSize >= n) {
                n = mSize + (mSize >> 1);
            }
            else if (mSize < 4) {
                n = 4;
            }
            final int[] mHashes = this.mHashes;
            final Object[] mArray = this.mArray;
            this.allocArrays(n);
            if (this.mHashes.length > 0) {
                System.arraycopy(mHashes, 0, this.mHashes, 0, mHashes.length);
                System.arraycopy(mArray, 0, this.mArray, 0, mArray.length);
            }
            freeArrays(mHashes, mArray, mSize);
        }
        if (n4 < mSize) {
            System.arraycopy(mHashes, n4, mHashes, n4 + 1, mSize - n4);
            System.arraycopy(mArray, n4 << 1, mArray, n4 + 1 << 1, mSize - n4 << 1);
        }
        mHashes[n4] = hashCode;
        mArray[n4 << 1] = k;
        mArray[1 + (n4 << 1)] = v;
        ++mSize;
        return null;
    }
    
    public void putAll(final SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        final int mSize = simpleArrayMap.mSize;
        this.ensureCapacity(mSize + this.mSize);
        if (this.mSize == 0) {
            if (mSize > 0) {
                System.arraycopy(mHashes, 0, mHashes, 0, mSize);
                System.arraycopy(mArray, 0, mArray, 0, mSize << 1);
                this.mSize = mSize;
            }
        }
        else {
            for (int i = 0; i < mSize; ++i) {
                this.put(simpleArrayMap.keyAt(i), simpleArrayMap.valueAt(i));
            }
        }
    }
    
    public V remove(final Object o) {
        final int indexOfKey = this.indexOfKey(o);
        if (indexOfKey >= 0) {
            return this.removeAt(indexOfKey);
        }
        return null;
    }
    
    public V removeAt(final int n) {
        int n2 = 8;
        final Object o = mArray[1 + (n << 1)];
        if (mSize <= 1) {
            freeArrays(mHashes, mArray, mSize);
            mHashes = ContainerHelpers.EMPTY_INTS;
            mArray = ContainerHelpers.EMPTY_OBJECTS;
            mSize = 0;
        }
        else {
            if (mHashes.length <= n2 || mSize >= mHashes.length / 3) {
                --mSize;
                if (n < mSize) {
                    System.arraycopy(mHashes, n + 1, mHashes, n, mSize - n);
                    System.arraycopy(mArray, n + 1 << 1, mArray, n << 1, mSize - n << 1);
                }
                mArray[mSize << 1] = null;
                mArray[1 + (mSize << 1)] = null;
                return (V)o;
            }
            if (mSize > n2) {
                n2 = mSize + (mSize >> 1);
            }
            final int[] mHashes = this.mHashes;
            final Object[] mArray = this.mArray;
            this.allocArrays(n2);
            --mSize;
            if (n > 0) {
                System.arraycopy(mHashes, 0, this.mHashes, 0, n);
                System.arraycopy(mArray, 0, this.mArray, 0, n << 1);
            }
            if (n < mSize) {
                System.arraycopy(mHashes, n + 1, this.mHashes, n, mSize - n);
                System.arraycopy(mArray, n + 1 << 1, this.mArray, n << 1, mSize - n << 1);
                return (V)o;
            }
        }
        return (V)o;
    }
    
    public V setValueAt(final int n, final V v) {
        final int n2 = 1 + (n << 1);
        final Object o = mArray[n2];
        mArray[n2] = v;
        return (V)o;
    }
    
    public int size() {
        return mSize;
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(28 * mSize);
        sb.append('{');
        for (int i = 0; i < mSize; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final K key = this.keyAt(i);
            if (key != this) {
                sb.append(key);
            }
            else {
                sb.append("(this Map)");
            }
            sb.append('=');
            final V value = this.valueAt(i);
            if (value != this) {
                sb.append(value);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
    
    public V valueAt(final int n) {
        return (V)mArray[1 + (n << 1)];
    }
}
