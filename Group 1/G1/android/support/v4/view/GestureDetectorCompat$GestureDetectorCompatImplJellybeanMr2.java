package android.support.v4.view;

import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;
import android.os.Handler;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;
import android.view.GestureDetector;

static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl
{
    private final GestureDetector mDetector;
    
    public GestureDetectorCompatImplJellybeanMr2(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
        super();
        this.mDetector = new GestureDetector(context, gestureDetector$OnGestureListener, handler);
    }
    
    @Override
    public boolean isLongpressEnabled() {
        return mDetector.isLongpressEnabled();
    }
    
    @Override
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return mDetector.onTouchEvent(motionEvent);
    }
    
    @Override
    public void setIsLongpressEnabled(final boolean isLongpressEnabled) {
        mDetector.setIsLongpressEnabled(isLongpressEnabled);
    }
    
    @Override
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener onDoubleTapListener) {
        mDetector.setOnDoubleTapListener(onDoubleTapListener);
    }
}
