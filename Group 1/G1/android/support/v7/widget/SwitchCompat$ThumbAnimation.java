package android.support.v7.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

private class ThumbAnimation extends Animation
{
    final float mDiff;
    final float mEndPosition;
    final float mStartPosition;
    final /* synthetic */ SwitchCompat this$0;
    
    private ThumbAnimation(final SwitchCompat this$0, final float mStartPosition, final float mEndPosition) {
        this$0 = this$0;
        super();
        mStartPosition = mStartPosition;
        mEndPosition = mEndPosition;
        mDiff = mEndPosition - mStartPosition;
    }
    
    ThumbAnimation(final SwitchCompat switchCompat, final float n, final float n2, final SwitchCompat$1 animation$AnimationListener) {
        this(switchCompat, n, n2);
    }
    
    protected void applyTransformation(final float n, final Transformation transformation) {
        SwitchCompat.access$200(this$0, mStartPosition + n * mDiff);
    }
}
