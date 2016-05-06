package android.support.v7.widget;

import android.util.SparseArray;

public static class State
{
    static final int STEP_ANIMATIONS = 4;
    static final int STEP_LAYOUT = 2;
    static final int STEP_START = 1;
    private SparseArray<Object> mData;
    private int mDeletedInvisibleItemCountSincePreviousLayout;
    private boolean mInPreLayout;
    private boolean mIsMeasuring;
    int mItemCount;
    private int mLayoutStep;
    private int mPreviousLayoutItemCount;
    private boolean mRunPredictiveAnimations;
    private boolean mRunSimpleAnimations;
    private boolean mStructureChanged;
    private int mTargetPosition;
    private boolean mTrackOldChangeHolders;
    
    public State() {
        super();
        this.mTargetPosition = -1;
        this.mLayoutStep = 1;
        this.mItemCount = 0;
        this.mPreviousLayoutItemCount = 0;
        this.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        this.mStructureChanged = false;
        this.mInPreLayout = false;
        this.mRunSimpleAnimations = false;
        this.mRunPredictiveAnimations = false;
        this.mTrackOldChangeHolders = false;
        this.mIsMeasuring = false;
    }
    
    static /* synthetic */ int access$1702(final State state, final int mDeletedInvisibleItemCountSincePreviousLayout) {
        return state.mDeletedInvisibleItemCountSincePreviousLayout = mDeletedInvisibleItemCountSincePreviousLayout;
    }
    
    static /* synthetic */ int access$1712(final State state, final int n) {
        return state.mDeletedInvisibleItemCountSincePreviousLayout += n;
    }
    
    static /* synthetic */ boolean access$1800(final State state) {
        return state.mStructureChanged;
    }
    
    static /* synthetic */ boolean access$1802(final State state, final boolean mStructureChanged) {
        return state.mStructureChanged = mStructureChanged;
    }
    
    static /* synthetic */ int access$2100(final State state) {
        return state.mLayoutStep;
    }
    
    static /* synthetic */ int access$2102(final State state, final int mLayoutStep) {
        return state.mLayoutStep = mLayoutStep;
    }
    
    static /* synthetic */ boolean access$2202(final State state, final boolean mIsMeasuring) {
        return state.mIsMeasuring = mIsMeasuring;
    }
    
    static /* synthetic */ boolean access$2300(final State state) {
        return state.mRunPredictiveAnimations;
    }
    
    static /* synthetic */ boolean access$2302(final State state, final boolean mRunPredictiveAnimations) {
        return state.mRunPredictiveAnimations = mRunPredictiveAnimations;
    }
    
    static /* synthetic */ boolean access$2400(final State state) {
        return state.mInPreLayout;
    }
    
    static /* synthetic */ boolean access$2402(final State state, final boolean mInPreLayout) {
        return state.mInPreLayout = mInPreLayout;
    }
    
    static /* synthetic */ boolean access$2500(final State state) {
        return state.mRunSimpleAnimations;
    }
    
    static /* synthetic */ boolean access$2502(final State state, final boolean mRunSimpleAnimations) {
        return state.mRunSimpleAnimations = mRunSimpleAnimations;
    }
    
    static /* synthetic */ boolean access$2700(final State state) {
        return state.mTrackOldChangeHolders;
    }
    
    static /* synthetic */ boolean access$2702(final State state, final boolean mTrackOldChangeHolders) {
        return state.mTrackOldChangeHolders = mTrackOldChangeHolders;
    }
    
    static /* synthetic */ int access$2802(final State state, final int mPreviousLayoutItemCount) {
        return state.mPreviousLayoutItemCount = mPreviousLayoutItemCount;
    }
    
    static /* synthetic */ int access$5802(final State state, final int mTargetPosition) {
        return state.mTargetPosition = mTargetPosition;
    }
    
    void assertLayoutStep(final int n) {
        if ((n & mLayoutStep) == 0x0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(n) + " but it is " + Integer.toBinaryString(mLayoutStep));
        }
    }
    
    public boolean didStructureChange() {
        return mStructureChanged;
    }
    
    public <T> T get(final int n) {
        if (mData == null) {
            return null;
        }
        return (T)mData.get(n);
    }
    
    public int getItemCount() {
        if (mInPreLayout) {
            return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
        }
        return mItemCount;
    }
    
    public int getTargetScrollPosition() {
        return mTargetPosition;
    }
    
    public boolean hasTargetScrollPosition() {
        return mTargetPosition != -1;
    }
    
    public boolean isMeasuring() {
        return mIsMeasuring;
    }
    
    public boolean isPreLayout() {
        return mInPreLayout;
    }
    
    public void put(final int n, final Object o) {
        if (mData == null) {
            mData = (SparseArray<Object>)new SparseArray();
        }
        mData.put(n, o);
    }
    
    public void remove(final int n) {
        if (mData == null) {
            return;
        }
        mData.remove(n);
    }
    
    State reset() {
        mTargetPosition = -1;
        if (mData != null) {
            mData.clear();
        }
        mItemCount = 0;
        mStructureChanged = false;
        mIsMeasuring = false;
        return this;
    }
    
    @Override
    public String toString() {
        return "State{mTargetPosition=" + mTargetPosition + ", mData=" + mData + ", mItemCount=" + mItemCount + ", mPreviousLayoutItemCount=" + mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + mStructureChanged + ", mInPreLayout=" + mInPreLayout + ", mRunSimpleAnimations=" + mRunSimpleAnimations + ", mRunPredictiveAnimations=" + mRunPredictiveAnimations + '}';
    }
    
    public boolean willRunPredictiveAnimations() {
        return mRunPredictiveAnimations;
    }
    
    public boolean willRunSimpleAnimations() {
        return mRunSimpleAnimations;
    }
}
