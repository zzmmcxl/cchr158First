package android.support.v4.util;

public final class CircularArray<E>
{
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;
    
    public CircularArray() {
        this(8);
    }
    
    public CircularArray(final int n) {
        super();
        if (n < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (n > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        int n2;
        if (Integer.bitCount(n) != 1) {
            n2 = Integer.highestOneBit(n - 1) << 1;
        }
        else {
            n2 = n;
        }
        mCapacityBitmask = n2 - 1;
        mElements = new Object[n2];
    }
    
    private void doubleCapacity() {
        final int length = mElements.length;
        final int n = length - mHead;
        final int n2 = length << 1;
        if (n2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        final Object[] array = new Object[n2];
        System.arraycopy(mElements, mHead, array, 0, n);
        System.arraycopy(mElements, 0, array, n, mHead);
        mElements = array;
        mHead = 0;
        mTail = length;
        mCapacityBitmask = n2 - 1;
    }
    
    public void addFirst(final E e) {
        mHead = (-1 + mHead & mCapacityBitmask);
        mElements[mHead] = e;
        if (mHead == mTail) {
            this.doubleCapacity();
        }
    }
    
    public void addLast(final E e) {
        mElements[mTail] = e;
        mTail = (1 + mTail & mCapacityBitmask);
        if (mTail == mHead) {
            this.doubleCapacity();
        }
    }
    
    public void clear() {
        this.removeFromStart(this.size());
    }
    
    public E get(final int n) {
        if (n < 0 || n >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)mElements[n + mHead & mCapacityBitmask];
    }
    
    public E getFirst() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)mElements[mHead];
    }
    
    public E getLast() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)mElements[-1 + mTail & mCapacityBitmask];
    }
    
    public boolean isEmpty() {
        return mHead == mTail;
    }
    
    public E popFirst() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final Object o = mElements[mHead];
        mElements[mHead] = null;
        mHead = (1 + mHead & mCapacityBitmask);
        return (E)o;
    }
    
    public E popLast() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int mTail = -1 + this.mTail & mCapacityBitmask;
        final Object o = mElements[mTail];
        mElements[mTail] = null;
        this.mTail = mTail;
        return (E)o;
    }
    
    public void removeFromEnd(final int n) {
        if (n > 0) {
            if (n > this.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            final int mTail = this.mTail;
            int n2 = 0;
            if (n < mTail) {
                n2 = this.mTail - n;
            }
            for (int i = n2; i < this.mTail; ++i) {
                mElements[i] = null;
            }
            final int n3 = this.mTail - n2;
            final int n4 = n - n3;
            this.mTail -= n3;
            if (n4 > 0) {
                this.mTail = mElements.length;
                int j;
                int mTail2;
                for (mTail2 = (j = this.mTail - n4); j < this.mTail; ++j) {
                    mElements[j] = null;
                }
                this.mTail = mTail2;
            }
        }
    }
    
    public void removeFromStart(final int n) {
        if (n > 0) {
            if (n > this.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int length = mElements.length;
            if (n < length - mHead) {
                length = n + mHead;
            }
            for (int i = mHead; i < length; ++i) {
                mElements[i] = null;
            }
            final int n2 = length - mHead;
            final int mHead = n - n2;
            this.mHead = (n2 + this.mHead & mCapacityBitmask);
            if (mHead > 0) {
                for (int j = 0; j < mHead; ++j) {
                    mElements[j] = null;
                }
                this.mHead = mHead;
            }
        }
    }
    
    public int size() {
        return mTail - mHead & mCapacityBitmask;
    }
}
