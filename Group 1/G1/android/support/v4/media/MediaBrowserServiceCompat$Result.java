package android.support.v4.media;

public static class Result<T>
{
    private Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendResultCalled;
    
    Result(final Object mDebug) {
        super();
        this.mDebug = mDebug;
    }
    
    public void detach() {
        if (mDetachCalled) {
            throw new IllegalStateException("detach() called when detach() had already been called for: " + mDebug);
        }
        if (mSendResultCalled) {
            throw new IllegalStateException("detach() called when sendResult() had already been called for: " + mDebug);
        }
        mDetachCalled = true;
    }
    
    boolean isDone() {
        return mDetachCalled || mSendResultCalled;
    }
    
    void onResultSent(final T t, final int n) {
    }
    
    public void sendResult(final T t) {
        if (mSendResultCalled) {
            throw new IllegalStateException("sendResult() called twice for: " + mDebug);
        }
        mSendResultCalled = true;
        this.onResultSent(t, mFlags);
    }
    
    void setFlags(final int mFlags) {
        this.mFlags = mFlags;
    }
}
