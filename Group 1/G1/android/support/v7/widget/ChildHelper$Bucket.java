package android.support.v7.widget;

static class Bucket
{
    static final int BITS_PER_WORD = 64;
    static final long LAST_BIT = Long.MIN_VALUE;
    long mData;
    Bucket next;
    
    Bucket() {
        super();
        this.mData = 0L;
    }
    
    private void ensureNext() {
        if (next == null) {
            next = new Bucket();
        }
    }
    
    void clear(final int n) {
        if (n >= 64) {
            if (next != null) {
                next.clear(n - 64);
            }
            return;
        }
        mData &= (-1L ^ 1L << n);
    }
    
    int countOnesBefore(final int n) {
        if (next == null) {
            if (n >= 64) {
                return Long.bitCount(mData);
            }
            return Long.bitCount(mData & (1L << n) - 1L);
        }
        else {
            if (n < 64) {
                return Long.bitCount(mData & (1L << n) - 1L);
            }
            return next.countOnesBefore(n - 64) + Long.bitCount(mData);
        }
    }
    
    boolean get(final int n) {
        if (n >= 64) {
            this.ensureNext();
            return next.get(n - 64);
        }
        return (mData & 1L << n) != 0x0L;
    }
    
    void insert(final int n, final boolean b) {
        if (n >= 64) {
            this.ensureNext();
            next.insert(n - 64, b);
        }
        else {
            final boolean b2 = (Long.MIN_VALUE & mData) != 0x0L;
            final long n2 = (1L << n) - 1L;
            mData = ((n2 & mData) | (mData & (-1L ^ n2)) << 1);
            if (b) {
                this.set(n);
            }
            else {
                this.clear(n);
            }
            if (b2 || next != null) {
                this.ensureNext();
                next.insert(0, b2);
            }
        }
    }
    
    boolean remove(final int n) {
        boolean remove;
        if (n >= 64) {
            this.ensureNext();
            remove = next.remove(n - 64);
        }
        else {
            final long n2 = 1L << n;
            remove = ((n2 & mData) != 0x0L);
            mData &= (-1L ^ n2);
            final long n3 = n2 - 1L;
            mData = ((n3 & mData) | Long.rotateRight(mData & (-1L ^ n3), 1));
            if (next != null) {
                if (next.get(0)) {
                    this.set(63);
                }
                next.remove(0);
                return remove;
            }
        }
        return remove;
    }
    
    void reset() {
        mData = 0L;
        if (next != null) {
            next.reset();
        }
    }
    
    void set(final int n) {
        if (n >= 64) {
            this.ensureNext();
            next.set(n - 64);
            return;
        }
        mData |= 1L << n;
    }
    
    @Override
    public String toString() {
        if (next == null) {
            return Long.toBinaryString(mData);
        }
        return next.toString() + "xx" + Long.toBinaryString(mData);
    }
}
