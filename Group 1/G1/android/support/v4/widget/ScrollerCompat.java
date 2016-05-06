package android.support.v4.widget;

import android.widget.Scroller;
import android.os.Build$VERSION;
import android.view.animation.Interpolator;
import android.content.Context;

public final class ScrollerCompat
{
    static final int CHASE_FRAME_TIME = 16;
    private static final String TAG = "ScrollerCompat";
    ScrollerCompatImpl mImpl;
    Object mScroller;
    
    private ScrollerCompat(final int n, final Context context, final Interpolator interpolator) {
        super();
        if (n >= 14) {
            mImpl = (ScrollerCompatImpl)new ScrollerCompatImplIcs();
        }
        else if (n >= 9) {
            mImpl = (ScrollerCompatImpl)new ScrollerCompatImplGingerbread();
        }
        else {
            mImpl = (ScrollerCompatImpl)new ScrollerCompatImplBase();
        }
        mScroller = mImpl.createScroller(context, interpolator);
    }
    
    public static ScrollerCompat create(final Context context) {
        return create(context, null);
    }
    
    public static ScrollerCompat create(final Context context, final Interpolator interpolator) {
        return new ScrollerCompat(Build$VERSION.SDK_INT, context, interpolator);
    }
    
    public void abortAnimation() {
        mImpl.abortAnimation(mScroller);
    }
    
    public boolean computeScrollOffset() {
        return mImpl.computeScrollOffset(mScroller);
    }
    
    public void fling(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        mImpl.fling(mScroller, n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    public void fling(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        mImpl.fling(mScroller, n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }
    
    public float getCurrVelocity() {
        return mImpl.getCurrVelocity(mScroller);
    }
    
    public int getCurrX() {
        return mImpl.getCurrX(mScroller);
    }
    
    public int getCurrY() {
        return mImpl.getCurrY(mScroller);
    }
    
    public int getFinalX() {
        return mImpl.getFinalX(mScroller);
    }
    
    public int getFinalY() {
        return mImpl.getFinalY(mScroller);
    }
    
    public boolean isFinished() {
        return mImpl.isFinished(mScroller);
    }
    
    public boolean isOverScrolled() {
        return mImpl.isOverScrolled(mScroller);
    }
    
    public void notifyHorizontalEdgeReached(final int n, final int n2, final int n3) {
        mImpl.notifyHorizontalEdgeReached(mScroller, n, n2, n3);
    }
    
    public void notifyVerticalEdgeReached(final int n, final int n2, final int n3) {
        mImpl.notifyVerticalEdgeReached(mScroller, n, n2, n3);
    }
    
    public boolean springBack(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return mImpl.springBack(mScroller, n, n2, n3, n4, n5, n6);
    }
    
    public void startScroll(final int n, final int n2, final int n3, final int n4) {
        mImpl.startScroll(mScroller, n, n2, n3, n4);
    }
    
    public void startScroll(final int n, final int n2, final int n3, final int n4, final int n5) {
        mImpl.startScroll(mScroller, n, n2, n3, n4, n5);
    }
}
