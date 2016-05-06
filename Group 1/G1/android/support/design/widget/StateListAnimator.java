package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

final class StateListAnimator
{
    private Animation$AnimationListener mAnimationListener;
    private Tuple mLastMatch;
    private Animation mRunningAnimation;
    private final ArrayList<Tuple> mTuples;
    private WeakReference<View> mViewRef;
    
    StateListAnimator() {
        super();
        mTuples = new ArrayList<Tuple>();
        mLastMatch = null;
        mRunningAnimation = null;
        mAnimationListener = (Animation$AnimationListener)new Animation$AnimationListener() {
            final /* synthetic */ StateListAnimator this$0;
            
            StateListAnimator$1() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationEnd(final Animation animation) {
                if (mRunningAnimation == animation) {
                    mRunningAnimation = null;
                }
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        };
    }
    
    static /* synthetic */ Animation access$000(final StateListAnimator stateListAnimator) {
        return stateListAnimator.mRunningAnimation;
    }
    
    static /* synthetic */ Animation access$002(final StateListAnimator stateListAnimator, final Animation mRunningAnimation) {
        return stateListAnimator.mRunningAnimation = mRunningAnimation;
    }
    
    private void cancel() {
        if (mRunningAnimation != null) {
            final View target = this.getTarget();
            if (target != null && target.getAnimation() == mRunningAnimation) {
                target.clearAnimation();
            }
            mRunningAnimation = null;
        }
    }
    
    private void clearTarget() {
        final View target = this.getTarget();
        for (int size = mTuples.size(), i = 0; i < size; ++i) {
            if (target.getAnimation() == ((Tuple)mTuples.get(i)).mAnimation) {
                target.clearAnimation();
            }
        }
        mViewRef = null;
        mLastMatch = null;
        mRunningAnimation = null;
    }
    
    private void start(final Tuple tuple) {
        mRunningAnimation = tuple.mAnimation;
        final View target = this.getTarget();
        if (target != null) {
            target.startAnimation(mRunningAnimation);
        }
    }
    
    public void addState(final int[] array, final Animation animation) {
        final Tuple tuple = new Tuple(array, animation);
        animation.setAnimationListener(mAnimationListener);
        mTuples.add(tuple);
    }
    
    Animation getRunningAnimation() {
        return mRunningAnimation;
    }
    
    View getTarget() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }
    
    ArrayList<Tuple> getTuples() {
        return mTuples;
    }
    
    public void jumpToCurrentState() {
        if (mRunningAnimation != null) {
            final View target = this.getTarget();
            if (target != null && target.getAnimation() == mRunningAnimation) {
                target.clearAnimation();
            }
        }
    }
    
    void setState(final int[] array) {
        final int size = mTuples.size();
        int n = 0;
        Tuple mLastMatch;
        while (true) {
            mLastMatch = null;
            if (n >= size) {
                break;
            }
            final Tuple tuple = (Tuple)mTuples.get(n);
            if (StateSet.stateSetMatches(tuple.mSpecs, array)) {
                mLastMatch = tuple;
                break;
            }
            ++n;
        }
        if (mLastMatch != this.mLastMatch) {
            if (this.mLastMatch != null) {
                this.cancel();
            }
            this.mLastMatch = mLastMatch;
            final View view = (View)mViewRef.get();
            if (mLastMatch != null && view != null && view.getVisibility() == 0) {
                this.start(mLastMatch);
            }
        }
    }
    
    void setTarget(final View view) {
        final View target = this.getTarget();
        if (target != view) {
            if (target != null) {
                this.clearTarget();
            }
            if (view != null) {
                mViewRef = new WeakReference<View>(view);
            }
        }
    }
}
