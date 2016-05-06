package android.support.v4.view;

import android.view.MotionEvent;

static class EclairMotionEventVersionImpl extends BaseMotionEventVersionImpl
{
    EclairMotionEventVersionImpl() {
        super();
    }
    
    @Override
    public int findPointerIndex(final MotionEvent motionEvent, final int n) {
        return MotionEventCompatEclair.findPointerIndex(motionEvent, n);
    }
    
    @Override
    public int getPointerCount(final MotionEvent motionEvent) {
        return MotionEventCompatEclair.getPointerCount(motionEvent);
    }
    
    @Override
    public int getPointerId(final MotionEvent motionEvent, final int n) {
        return MotionEventCompatEclair.getPointerId(motionEvent, n);
    }
    
    @Override
    public float getX(final MotionEvent motionEvent, final int n) {
        return MotionEventCompatEclair.getX(motionEvent, n);
    }
    
    @Override
    public float getY(final MotionEvent motionEvent, final int n) {
        return MotionEventCompatEclair.getY(motionEvent, n);
    }
}
