package android.support.v7.widget;

private class AnchorInfo
{
    boolean mInvalidateOffsets;
    boolean mLayoutFromEnd;
    int mOffset;
    int mPosition;
    final /* synthetic */ StaggeredGridLayoutManager this$0;
    
    private AnchorInfo(final StaggeredGridLayoutManager this$0) {
        this$0 = this$0;
        super();
    }
    
    AnchorInfo(final StaggeredGridLayoutManager staggeredGridLayoutManager, final StaggeredGridLayoutManager$1 runnable) {
        this(staggeredGridLayoutManager);
    }
    
    void assignCoordinateFromPadding() {
        int mOffset;
        if (mLayoutFromEnd) {
            mOffset = mPrimaryOrientation.getEndAfterPadding();
        }
        else {
            mOffset = mPrimaryOrientation.getStartAfterPadding();
        }
        this.mOffset = mOffset;
    }
    
    void assignCoordinateFromPadding(final int n) {
        if (mLayoutFromEnd) {
            mOffset = mPrimaryOrientation.getEndAfterPadding() - n;
            return;
        }
        mOffset = n + mPrimaryOrientation.getStartAfterPadding();
    }
    
    void reset() {
        mPosition = -1;
        mOffset = Integer.MIN_VALUE;
        mLayoutFromEnd = false;
        mInvalidateOffsets = false;
    }
}
