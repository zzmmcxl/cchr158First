package android.support.v7.widget;

class RtlSpacingHelper
{
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft;
    private int mRight;
    private int mStart;
    
    RtlSpacingHelper() {
        super();
        mLeft = 0;
        mRight = 0;
        mStart = Integer.MIN_VALUE;
        mEnd = Integer.MIN_VALUE;
        mExplicitLeft = 0;
        mExplicitRight = 0;
        mIsRtl = false;
        mIsRelative = false;
    }
    
    public int getEnd() {
        if (mIsRtl) {
            return mLeft;
        }
        return mRight;
    }
    
    public int getLeft() {
        return mLeft;
    }
    
    public int getRight() {
        return mRight;
    }
    
    public int getStart() {
        if (mIsRtl) {
            return mRight;
        }
        return mLeft;
    }
    
    public void setAbsolute(final int n, final int n2) {
        mIsRelative = false;
        if (n != Integer.MIN_VALUE) {
            mExplicitLeft = n;
            mLeft = n;
        }
        if (n2 != Integer.MIN_VALUE) {
            mExplicitRight = n2;
            mRight = n2;
        }
    }
    
    public void setDirection(final boolean mIsRtl) {
        if (mIsRtl == this.mIsRtl) {
            return;
        }
        this.mIsRtl = mIsRtl;
        if (!mIsRelative) {
            mLeft = mExplicitLeft;
            mRight = mExplicitRight;
            return;
        }
        if (mIsRtl) {
            int mLeft;
            if (mEnd != Integer.MIN_VALUE) {
                mLeft = mEnd;
            }
            else {
                mLeft = mExplicitLeft;
            }
            this.mLeft = mLeft;
            int mRight;
            if (mStart != Integer.MIN_VALUE) {
                mRight = mStart;
            }
            else {
                mRight = mExplicitRight;
            }
            this.mRight = mRight;
            return;
        }
        int mLeft2;
        if (mStart != Integer.MIN_VALUE) {
            mLeft2 = mStart;
        }
        else {
            mLeft2 = mExplicitLeft;
        }
        mLeft = mLeft2;
        int mRight2;
        if (mEnd != Integer.MIN_VALUE) {
            mRight2 = mEnd;
        }
        else {
            mRight2 = mExplicitRight;
        }
        mRight = mRight2;
    }
    
    public void setRelative(final int mLeft, final int mRight) {
        mStart = mLeft;
        mEnd = mRight;
        mIsRelative = true;
        if (mIsRtl) {
            if (mRight != Integer.MIN_VALUE) {
                this.mLeft = mRight;
            }
            if (mLeft != Integer.MIN_VALUE) {
                this.mRight = mLeft;
            }
        }
        else {
            if (mLeft != Integer.MIN_VALUE) {
                this.mLeft = mLeft;
            }
            if (mRight != Integer.MIN_VALUE) {
                this.mRight = mRight;
            }
        }
    }
}
