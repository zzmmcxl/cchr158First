package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation;
import android.view.View;
import android.view.animation.Animation$AnimationListener;

static class AnimateOnHWLayerIfNeededListener implements Animation$AnimationListener
{
    private Animation$AnimationListener mOrignalListener;
    private boolean mShouldRunOnHWLayer;
    private View mView;
    
    public AnimateOnHWLayerIfNeededListener(final View mView, final Animation animation) {
        super();
        this.mOrignalListener = null;
        this.mShouldRunOnHWLayer = false;
        this.mView = null;
        if (mView == null || animation == null) {
            return;
        }
        this.mView = mView;
    }
    
    public AnimateOnHWLayerIfNeededListener(final View mView, final Animation animation, final Animation$AnimationListener mOrignalListener) {
        super();
        this.mOrignalListener = null;
        this.mShouldRunOnHWLayer = false;
        this.mView = null;
        if (mView == null || animation == null) {
            return;
        }
        this.mOrignalListener = mOrignalListener;
        this.mView = mView;
    }
    
    static /* synthetic */ View access$000(final AnimateOnHWLayerIfNeededListener animateOnHWLayerIfNeededListener) {
        return animateOnHWLayerIfNeededListener.mView;
    }
    
    @CallSuper
    public void onAnimationEnd(final Animation animation) {
        if (mView != null && mShouldRunOnHWLayer) {
            mView.post((Runnable)new Runnable() {
                final /* synthetic */ AnimateOnHWLayerIfNeededListener this$0;
                
                FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void run() {
                    ViewCompat.setLayerType(mView, 0, null);
                }
            });
        }
        if (mOrignalListener != null) {
            mOrignalListener.onAnimationEnd(animation);
        }
    }
    
    public void onAnimationRepeat(final Animation animation) {
        if (mOrignalListener != null) {
            mOrignalListener.onAnimationRepeat(animation);
        }
    }
    
    @CallSuper
    public void onAnimationStart(final Animation animation) {
        if (mView != null) {
            mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(mView, animation);
            if (mShouldRunOnHWLayer) {
                mView.post((Runnable)new Runnable() {
                    final /* synthetic */ AnimateOnHWLayerIfNeededListener this$0;
                    
                    FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void run() {
                        ViewCompat.setLayerType(mView, 2, null);
                    }
                });
            }
        }
        if (mOrignalListener != null) {
            mOrignalListener.onAnimationStart(animation);
        }
    }
}
