package android.support.v4.view;

import android.view.MotionEvent;

static class GingerbreadMotionEventVersionImpl extends EclairMotionEventVersionImpl
{
    GingerbreadMotionEventVersionImpl() {
        super();
    }
    
    @Override
    public int getSource(final MotionEvent motionEvent) {
        return MotionEventCompatGingerbread.getSource(motionEvent);
    }
}
