package android.support.v7.widget;

protected static class LayoutChunkResult
{
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;
    
    protected LayoutChunkResult() {
        super();
    }
    
    void resetInternal() {
        mConsumed = 0;
        mFinished = false;
        mIgnoreConsumed = false;
        mFocusable = false;
    }
}
