package android.support.v7.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Arrays;
import java.lang.reflect.Array;

public class SortedList<T>
{
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mMergedSize;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;
    
    public SortedList(final Class<T> clazz, final Callback<T> callback) {
        this(clazz, callback, 10);
    }
    
    public SortedList(final Class<T> mtClass, final Callback<T> mCallback, final int n) {
        super();
        mTClass = mtClass;
        mData = (Object[])Array.newInstance(mtClass, n);
        mCallback = mCallback;
        mSize = 0;
    }
    
    private int add(final T t, final boolean b) {
        int index = this.findIndexOf(t, mData, 0, mSize, 1);
        if (index == -1) {
            index = 0;
        }
        else if (index < mSize) {
            final Object o = mData[index];
            if (mCallback.areItemsTheSame(o, t)) {
                if (mCallback.areContentsTheSame(o, t)) {
                    mData[index] = t;
                    return index;
                }
                mData[index] = t;
                mCallback.onChanged(index, 1);
                return index;
            }
        }
        this.addToData(index, t);
        if (b) {
            mCallback.onInserted(index, 1);
        }
        return index;
    }
    
    private void addAllInternal(final T[] mData) {
        boolean b;
        if (!(mCallback instanceof BatchedCallback)) {
            b = true;
        }
        else {
            b = false;
        }
        if (b) {
            this.beginBatchedUpdates();
        }
        mOldData = this.mData;
        mOldDataStart = 0;
        mOldDataSize = mSize;
        Arrays.<T>sort(mData, mCallback);
        final int deduplicate = this.deduplicate(mData);
        if (mSize == 0) {
            this.mData = mData;
            mSize = deduplicate;
            mMergedSize = deduplicate;
            mCallback.onInserted(0, deduplicate);
        }
        else {
            this.merge(mData, deduplicate);
        }
        mOldData = null;
        if (b) {
            this.endBatchedUpdates();
        }
    }
    
    private void addToData(final int n, final T t) {
        if (n > mSize) {
            throw new IndexOutOfBoundsException("cannot add item to " + n + " because size is " + mSize);
        }
        if (mSize == mData.length) {
            final Object[] mData = (Object[])Array.newInstance(mTClass, 10 + this.mData.length);
            System.arraycopy(this.mData, 0, mData, 0, n);
            mData[n] = t;
            System.arraycopy(this.mData, n, mData, n + 1, mSize - n);
            this.mData = mData;
        }
        else {
            System.arraycopy(mData, n, mData, n + 1, mSize - n);
            mData[n] = t;
        }
        ++mSize;
    }
    
    private int deduplicate(final T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Input array must be non-empty");
        }
        int n = 0;
        int n2 = 1;
        for (int i = 1; i < array.length; ++i) {
            final T t = array[i];
            final int compare = mCallback.compare(array[n], t);
            if (compare > 0) {
                throw new IllegalArgumentException("Input must be sorted in ascending order.");
            }
            if (compare == 0) {
                final int sameItem = this.findSameItem(t, array, n, n2);
                if (sameItem != -1) {
                    array[sameItem] = t;
                }
                else {
                    if (n2 != i) {
                        array[n2] = t;
                    }
                    ++n2;
                }
            }
            else {
                if (n2 != i) {
                    array[n2] = t;
                }
                final int n3 = n2 + 1;
                n = n2;
                n2 = n3;
            }
        }
        return n2;
    }
    
    private int findIndexOf(final T t, final T[] array, int i, int n, final int n2) {
        while (i < n) {
            final int n3 = (i + n) / 2;
            final T t2 = array[n3];
            final int compare = mCallback.compare(t2, t);
            if (compare < 0) {
                i = n3 + 1;
            }
            else {
                if (compare == 0) {
                    if (!mCallback.areItemsTheSame(t2, t)) {
                        final int linearEqualitySearch = this.linearEqualitySearch(t, n3, i, n);
                        if (n2 != 1) {
                            return linearEqualitySearch;
                        }
                        if (linearEqualitySearch != -1) {
                            return linearEqualitySearch;
                        }
                    }
                    return n3;
                }
                n = n3;
            }
        }
        if (n2 != 1) {
            i = -1;
        }
        return i;
    }
    
    private int findSameItem(final T t, final T[] array, final int n, final int n2) {
        for (int i = n; i < n2; ++i) {
            if (mCallback.areItemsTheSame(array[i], t)) {
                return i;
            }
        }
        return -1;
    }
    
    private int linearEqualitySearch(final T t, final int n, final int n2, final int n3) {
        for (int i = n - 1; i >= n2; --i) {
            final Object o = mData[i];
            if (mCallback.compare(o, t) != 0) {
                break;
            }
            if (mCallback.areItemsTheSame(o, t)) {
                return i;
            }
        }
        for (int j = n + 1; j < n3; ++j) {
            final Object o2 = mData[j];
            if (mCallback.compare(o2, t) != 0) {
                break;
            }
            if (mCallback.areItemsTheSame(o2, t)) {
                return j;
            }
        }
        return -1;
    }
    
    private void merge(final T[] array, final int n) {
        mData = (Object[])Array.newInstance(mTClass, 10 + (n + mSize));
        mMergedSize = 0;
        int n2 = 0;
        while (mOldDataStart < mOldDataSize || n2 < n) {
            if (mOldDataStart == mOldDataSize) {
                final int n3 = n - n2;
                System.arraycopy(array, n2, mData, mMergedSize, n3);
                mMergedSize += n3;
                mSize += n3;
                mCallback.onInserted(mMergedSize - n3, n3);
                break;
            }
            if (n2 == n) {
                final int n4 = mOldDataSize - mOldDataStart;
                System.arraycopy(mOldData, mOldDataStart, mData, mMergedSize, n4);
                mMergedSize += n4;
                return;
            }
            final Object o = mOldData[mOldDataStart];
            final T t = array[n2];
            final int compare = mCallback.compare(o, t);
            if (compare > 0) {
                mData[mMergedSize++] = t;
                ++mSize;
                ++n2;
                mCallback.onInserted(-1 + mMergedSize, 1);
            }
            else if (compare == 0 && mCallback.areItemsTheSame(o, t)) {
                mData[mMergedSize++] = t;
                ++n2;
                ++mOldDataStart;
                if (mCallback.areContentsTheSame(o, t)) {
                    continue;
                }
                mCallback.onChanged(-1 + mMergedSize, 1);
            }
            else {
                mData[mMergedSize++] = o;
                ++mOldDataStart;
            }
        }
    }
    
    private boolean remove(final T t, final boolean b) {
        final int index = this.findIndexOf(t, mData, 0, mSize, 2);
        if (index == -1) {
            return false;
        }
        this.removeItemAtIndex(index, b);
        return true;
    }
    
    private void removeItemAtIndex(final int n, final boolean b) {
        System.arraycopy(mData, n + 1, mData, n, -1 + (mSize - n));
        --mSize;
        mData[mSize] = null;
        if (b) {
            mCallback.onRemoved(n, 1);
        }
    }
    
    private void throwIfMerging() {
        if (mOldData != null) {
            throw new IllegalStateException("Cannot call this method from within addAll");
        }
    }
    
    public int add(final T t) {
        this.throwIfMerging();
        return this.add(t, true);
    }
    
    public void addAll(final Collection<T> collection) {
        this.addAll(collection.<T>toArray((T[])Array.newInstance(mTClass, collection.size())), true);
    }
    
    public void addAll(final T... array) {
        this.addAll(array, false);
    }
    
    public void addAll(final T[] array, final boolean b) {
        this.throwIfMerging();
        if (array.length == 0) {
            return;
        }
        if (b) {
            this.addAllInternal(array);
            return;
        }
        final Object[] array2 = (Object[])Array.newInstance(mTClass, array.length);
        System.arraycopy(array, 0, array2, 0, array.length);
        this.addAllInternal((T[])array2);
    }
    
    public void beginBatchedUpdates() {
        this.throwIfMerging();
        if (mCallback instanceof BatchedCallback) {
            return;
        }
        if (mBatchedCallback == null) {
            mBatchedCallback = new BatchedCallback(mCallback);
        }
        mCallback = (Callback)mBatchedCallback;
    }
    
    public void clear() {
        this.throwIfMerging();
        if (mSize == 0) {
            return;
        }
        final int mSize = this.mSize;
        Arrays.fill(mData, 0, mSize, null);
        this.mSize = 0;
        mCallback.onRemoved(0, mSize);
    }
    
    public void endBatchedUpdates() {
        this.throwIfMerging();
        if (mCallback instanceof BatchedCallback) {
            ((BatchedCallback)mCallback).dispatchLastEvent();
        }
        if (mCallback == mBatchedCallback) {
            mCallback = (Callback)((BatchedCallback<Object>)mBatchedCallback).mWrappedCallback;
        }
    }
    
    public T get(final int n) throws IndexOutOfBoundsException {
        if (n >= mSize || n < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + n + " but size is " + mSize);
        }
        if (mOldData != null && n >= mMergedSize) {
            return (T)mOldData[n - mMergedSize + mOldDataStart];
        }
        return (T)mData[n];
    }
    
    public int indexOf(final T t) {
        if (mOldData == null) {
            return this.findIndexOf(t, mData, 0, mSize, 4);
        }
        final int index = this.findIndexOf(t, mData, 0, mMergedSize, 4);
        if (index != -1) {
            return index;
        }
        final int index2 = this.findIndexOf(t, mOldData, mOldDataStart, mOldDataSize, 4);
        if (index2 != -1) {
            return index2 - mOldDataStart + mMergedSize;
        }
        return -1;
    }
    
    public void recalculatePositionOfItemAt(final int n) {
        this.throwIfMerging();
        final T value = this.get(n);
        this.removeItemAtIndex(n, false);
        final int add = this.add(value, false);
        if (n != add) {
            mCallback.onMoved(n, add);
        }
    }
    
    public boolean remove(final T t) {
        this.throwIfMerging();
        return this.remove(t, true);
    }
    
    public T removeItemAt(final int n) {
        this.throwIfMerging();
        final T value = this.get(n);
        this.removeItemAtIndex(n, true);
        return value;
    }
    
    public int size() {
        return mSize;
    }
    
    public void updateItemAt(final int n, final T t) {
        this.throwIfMerging();
        final T value = this.get(n);
        boolean b;
        if (value == t || !mCallback.areContentsTheSame(value, t)) {
            b = true;
        }
        else {
            b = false;
        }
        if (value != t && mCallback.compare(value, t) == 0) {
            mData[n] = t;
            if (b) {
                mCallback.onChanged(n, 1);
            }
        }
        else {
            if (b) {
                mCallback.onChanged(n, 1);
            }
            this.removeItemAtIndex(n, false);
            final int add = this.add(t, false);
            if (n != add) {
                mCallback.onMoved(n, add);
            }
        }
    }
}
