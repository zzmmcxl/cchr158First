package android.support.v4.widget;

import android.view.animation.Interpolator;
import android.content.Context;
import android.widget.Scroller;

static class ScrollerCompatImplBase implements ScrollerCompatImpl
{
    ScrollerCompatImplBase() {
        super();
    }
    
    @Override
    public void abortAnimation(final Object o) {
        ((Scroller)o).abortAnimation();
    }
    
    @Override
    public boolean computeScrollOffset(final Object o) {
        return ((Scroller)o).computeScrollOffset();
    }
    
    @Override
    public Object createScroller(final Context context, final Interpolator interpolator) {
        if (interpolator != null) {
            return new Scroller(context, interpolator);
        }
        return new Scroller(context);
    }
    
    @Override
    public void fling(final Object o, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        ((Scroller)o).fling(n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    @Override
    public void fling(final Object o, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        ((Scroller)o).fling(n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    @Override
    public float getCurrVelocity(final Object o) {
        return 0.0f;
    }
    
    @Override
    public int getCurrX(final Object o) {
        return ((Scroller)o).getCurrX();
    }
    
    @Override
    public int getCurrY(final Object o) {
        return ((Scroller)o).getCurrY();
    }
    
    @Override
    public int getFinalX(final Object o) {
        return ((Scroller)o).getFinalX();
    }
    
    @Override
    public int getFinalY(final Object o) {
        return ((Scroller)o).getFinalY();
    }
    
    @Override
    public boolean isFinished(final Object o) {
        return ((Scroller)o).isFinished();
    }
    
    @Override
    public boolean isOverScrolled(final Object o) {
        return false;
    }
    
    @Override
    public void notifyHorizontalEdgeReached(final Object o, final int n, final int n2, final int n3) {
    }
    
    @Override
    public void notifyVerticalEdgeReached(final Object o, final int n, final int n2, final int n3) {
    }
    
    @Override
    public boolean springBack(final Object o, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return false;
    }
    
    @Override
    public void startScroll(final Object o, final int n, final int n2, final int n3, final int n4) {
        ((Scroller)o).startScroll(n, n2, n3, n4);
    }
    
    @Override
    public void startScroll(final Object o, final int n, final int n2, final int n3, final int n4, final int n5) {
        ((Scroller)o).startScroll(n, n2, n3, n4, n5);
    }
}
