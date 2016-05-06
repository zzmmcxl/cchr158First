package android.support.v4.util;

public final class CircularIntArray
{
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;
    
    public CircularIntArray() {
        this(8);
    }
    
    public CircularIntArray(final int n) {
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
        mElements = new int[n2];
    }
    
    private void doubleCapacity() {
        final int length = mElements.length;
        final int n = length - mHead;
        final int n2 = length << 1;
        if (n2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        final int[] mElements = new int[n2];
        System.arraycopy(this.mElements, mHead, mElements, 0, n);
        System.arraycopy(this.mElements, 0, mElements, n, mHead);
        this.mElements = mElements;
        mHead = 0;
        mTail = length;
        mCapacityBitmask = n2 - 1;
    }
    
    public void addFirst(final int n) {
        mHead = (-1 + mHead & mCapacityBitmask);
        mElements[mHead] = n;
        if (mHead == mTail) {
            this.doubleCapacity();
        }
    }
    
    public void addLast(final int n) {
        mElements[mTail] = n;
        mTail = (1 + mTail & mCapacityBitmask);
        if (mTail == mHead) {
            this.doubleCapacity();
        }
    }
    
    public void clear() {
        mTail = mHead;
    }
    
    public int get(final int n) {
        if (n < 0 || n >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return mElements[n + mHead & mCapacityBitmask];
    }
    
    public int getFirst() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return mElements[mHead];
    }
    
    public int getLast() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return mElements[-1 + mTail & mCapacityBitmask];
    }
    
    public boolean isEmpty() {
        return mHead == mTail;
    }
    
    public int popFirst() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int n = mElements[mHead];
        mHead = (1 + mHead & mCapacityBitmask);
        return n;
    }
    
    public int popLast() {
        if (mHead == mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int mTail = -1 + this.mTail & mCapacityBitmask;
        final int n = mElements[mTail];
        this.mTail = mTail;
        return n;
    }
    
    public void removeFromEnd(final int n) {
        if (n <= 0) {
            return;
        }
        if (n > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mTail = (mTail - n & mCapacityBitmask);
    }
    
    public void removeFromStart(final int n) {
        if (n <= 0) {
            return;
        }
        if (n > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mHead = (n + mHead & mCapacityBitmask);
    }
    
    public int size() {
        return mTail - mHead & mCapacityBitmask;
    }
}
