package android.support.v4.util;

public class LongSparseArray<E> implements Cloneable
{
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;
    
    static {
        DELETED = new Object();
    }
    
    public LongSparseArray() {
        this(10);
    }
    
    public LongSparseArray(final int n) {
        super();
        mGarbage = false;
        if (n == 0) {
            mKeys = ContainerHelpers.EMPTY_LONGS;
            mValues = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            final int idealLongArraySize = ContainerHelpers.idealLongArraySize(n);
            mKeys = new long[idealLongArraySize];
            mValues = new Object[idealLongArraySize];
        }
        mSize = 0;
    }
    
    private void gc() {
        final int mSize = this.mSize;
        int mSize2 = 0;
        final long[] mKeys = this.mKeys;
        final Object[] mValues = this.mValues;
        for (int i = 0; i < mSize; ++i) {
            final Object o = mValues[i];
            if (o != DELETED) {
                if (i != mSize2) {
                    mKeys[mSize2] = mKeys[i];
                    mValues[mSize2] = o;
                    mValues[i] = null;
                }
                ++mSize2;
            }
        }
        mGarbage = false;
        this.mSize = mSize2;
    }
    
    public void append(final long n, final E e) {
        if (mSize != 0 && n <= mKeys[-1 + mSize]) {
            this.put(n, e);
            return;
        }
        if (mGarbage && mSize >= mKeys.length) {
            this.gc();
        }
        final int mSize = this.mSize;
        if (mSize >= mKeys.length) {
            final int idealLongArraySize = ContainerHelpers.idealLongArraySize(mSize + 1);
            final long[] mKeys = new long[idealLongArraySize];
            final Object[] mValues = new Object[idealLongArraySize];
            System.arraycopy(this.mKeys, 0, mKeys, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, mValues, 0, this.mValues.length);
            this.mKeys = mKeys;
            this.mValues = mValues;
        }
        mKeys[mSize] = n;
        mValues[mSize] = e;
        this.mSize = mSize + 1;
    }
    
    public void clear() {
        final int mSize = this.mSize;
        final Object[] mValues = this.mValues;
        for (int i = 0; i < mSize; ++i) {
            mValues[i] = null;
        }
        this.mSize = 0;
        mGarbage = false;
    }
    
    public LongSparseArray<E> clone() {
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray)super.clone();
            mKeys = mKeys.clone();
            mValues = mValues.clone();
            return longSparseArray;
        }
        catch (CloneNotSupportedException ex) {
            return longSparseArray;
        }
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.clone();
    }
    
    public void delete(final long n) {
        final int binarySearch = ContainerHelpers.binarySearch(mKeys, mSize, n);
        if (binarySearch >= 0 && mValues[binarySearch] != DELETED) {
            mValues[binarySearch] = DELETED;
            mGarbage = true;
        }
    }
    
    public E get(final long n) {
        return this.get(n, null);
    }
    
    public E get(final long n, final E e) {
        final int binarySearch = ContainerHelpers.binarySearch(mKeys, mSize, n);
        if (binarySearch < 0 || mValues[binarySearch] == DELETED) {
            return e;
        }
        return (E)mValues[binarySearch];
    }
    
    public int indexOfKey(final long n) {
        if (mGarbage) {
            this.gc();
        }
        return ContainerHelpers.binarySearch(mKeys, mSize, n);
    }
    
    public int indexOfValue(final E e) {
        if (mGarbage) {
            this.gc();
        }
        for (int i = 0; i < mSize; ++i) {
            if (mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }
    
    public long keyAt(final int n) {
        if (mGarbage) {
            this.gc();
        }
        return mKeys[n];
    }
    
    public void put(final long n, final E e) {
        final int binarySearch = ContainerHelpers.binarySearch(mKeys, mSize, n);
        if (binarySearch >= 0) {
            mValues[binarySearch] = e;
            return;
        }
        int n2 = ~binarySearch;
        if (n2 < mSize && mValues[n2] == DELETED) {
            mKeys[n2] = n;
            mValues[n2] = e;
            return;
        }
        if (mGarbage && mSize >= mKeys.length) {
            this.gc();
            n2 = (-1 ^ ContainerHelpers.binarySearch(mKeys, mSize, n));
        }
        if (mSize >= mKeys.length) {
            final int idealLongArraySize = ContainerHelpers.idealLongArraySize(1 + mSize);
            final long[] mKeys = new long[idealLongArraySize];
            final Object[] mValues = new Object[idealLongArraySize];
            System.arraycopy(this.mKeys, 0, mKeys, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, mValues, 0, this.mValues.length);
            this.mKeys = mKeys;
            this.mValues = mValues;
        }
        if (mSize - n2 != 0) {
            System.arraycopy(mKeys, n2, mKeys, n2 + 1, mSize - n2);
            System.arraycopy(mValues, n2, mValues, n2 + 1, mSize - n2);
        }
        mKeys[n2] = n;
        mValues[n2] = e;
        ++mSize;
    }
    
    public void remove(final long n) {
        this.delete(n);
    }
    
    public void removeAt(final int n) {
        if (mValues[n] != DELETED) {
            mValues[n] = DELETED;
            mGarbage = true;
        }
    }
    
    public void setValueAt(final int n, final E e) {
        if (mGarbage) {
            this.gc();
        }
        mValues[n] = e;
    }
    
    public int size() {
        if (mGarbage) {
            this.gc();
        }
        return mSize;
    }
    
    @Override
    public String toString() {
        if (this.size() <= 0) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(28 * mSize);
        sb.append('{');
        for (int i = 0; i < mSize; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.keyAt(i));
            sb.append('=');
            final E value = this.valueAt(i);
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
    
    public E valueAt(final int n) {
        if (mGarbage) {
            this.gc();
        }
        return (E)mValues[n];
    }
}
