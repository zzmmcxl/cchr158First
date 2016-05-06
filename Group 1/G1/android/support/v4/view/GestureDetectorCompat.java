package android.support.v4.view;

import android.view.GestureDetector;
import android.os.Message;
import android.view.ViewConfiguration;
import android.view.VelocityTracker;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.os.Handler;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;

public final class GestureDetectorCompat
{
    private final GestureDetectorCompatImpl mImpl;
    
    public GestureDetectorCompat(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener) {
        this(context, gestureDetector$OnGestureListener, null);
    }
    
    public GestureDetectorCompat(final Context context, final GestureDetector$OnGestureListener gestureDetector$OnGestureListener, final Handler handler) {
        super();
        if (Build$VERSION.SDK_INT > 17) {
            mImpl = (GestureDetectorCompatImpl)new GestureDetectorCompatImplJellybeanMr2(context, gestureDetector$OnGestureListener, handler);
            return;
        }
        mImpl = (GestureDetectorCompatImpl)new GestureDetectorCompatImplBase(context, gestureDetector$OnGestureListener, handler);
    }
    
    public boolean isLongpressEnabled() {
        return mImpl.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return mImpl.onTouchEvent(motionEvent);
    }
    
    public void setIsLongpressEnabled(final boolean isLongpressEnabled) {
        mImpl.setIsLongpressEnabled(isLongpressEnabled);
    }
    
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener onDoubleTapListener) {
        mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
