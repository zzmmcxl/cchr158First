package android.support.v7.view;

import java.util.Iterator;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.animation.Interpolator;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;

public class ViewPropertyAnimatorCompatSet
{
    private final ArrayList<ViewPropertyAnimatorCompat> mAnimators;
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    private ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener;
    
    public ViewPropertyAnimatorCompatSet() {
        super();
        mDuration = -1L;
        mProxyListener = new ViewPropertyAnimatorListenerAdapter() {
            private int mProxyEndCount = 0;
            private boolean mProxyStarted = false;
            final /* synthetic */ ViewPropertyAnimatorCompatSet this$0;
            
            ViewPropertyAnimatorCompatSet$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                final int mProxyEndCount = 1 + this.mProxyEndCount;
                this.mProxyEndCount = mProxyEndCount;
                if (mProxyEndCount == mAnimators.size()) {
                    if (mListener != null) {
                        mListener.onAnimationEnd(null);
                    }
                    this.onEnd();
                }
            }
            
            @Override
            public void onAnimationStart(final View view) {
                if (!mProxyStarted) {
                    mProxyStarted = true;
                    if (mListener != null) {
                        mListener.onAnimationStart(null);
                    }
                }
            }
            
            void onEnd() {
                mProxyEndCount = 0;
                mProxyStarted = false;
                this$0.onAnimationsEnded();
            }
        };
        mAnimators = new ArrayList<ViewPropertyAnimatorCompat>();
    }
    
    static /* synthetic */ ViewPropertyAnimatorListener access$000(final ViewPropertyAnimatorCompatSet set) {
        return set.mListener;
    }
    
    static /* synthetic */ void access$100(final ViewPropertyAnimatorCompatSet set) {
        set.onAnimationsEnded();
    }
    
    static /* synthetic */ ArrayList access$200(final ViewPropertyAnimatorCompatSet set) {
        return set.mAnimators;
    }
    
    private void onAnimationsEnded() {
        mIsStarted = false;
    }
    
    public void cancel() {
        if (!mIsStarted) {
            return;
        }
        final Iterator<ViewPropertyAnimatorCompat> iterator = mAnimators.iterator();
        while (iterator.hasNext()) {
            ((ViewPropertyAnimatorCompat)iterator.next()).cancel();
        }
        mIsStarted = false;
    }
    
    public ViewPropertyAnimatorCompatSet play(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!mIsStarted) {
            mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet playSequentially(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet setDuration(final long mDuration) {
        if (!mIsStarted) {
            this.mDuration = mDuration;
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet setInterpolator(final Interpolator mInterpolator) {
        if (!mIsStarted) {
            this.mInterpolator = mInterpolator;
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompatSet setListener(final ViewPropertyAnimatorListener mListener) {
        if (!mIsStarted) {
            this.mListener = mListener;
        }
        return this;
    }
    
    public void start() {
        if (mIsStarted) {
            return;
        }
        for (final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : mAnimators) {
            if (mDuration >= 0L) {
                viewPropertyAnimatorCompat.setDuration(mDuration);
            }
            if (mInterpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(mInterpolator);
            }
            if (mListener != null) {
                viewPropertyAnimatorCompat.setListener(mProxyListener);
            }
            viewPropertyAnimatorCompat.start();
        }
        mIsStarted = true;
    }
}
