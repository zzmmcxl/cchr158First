package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator
{
    private final float mStepSize;
    private final float[] mValues;
    
    public LookupTableInterpolator(final float[] mValues) {
        super();
        mValues = mValues;
        mStepSize = 1.0f / (-1 + mValues.length);
    }
    
    public float getInterpolation(final float n) {
        if (n >= 1.0f) {
            return 1.0f;
        }
        if (n <= 0.0f) {
            return 0.0f;
        }
        final int min = Math.min((int)(n * (-1 + mValues.length)), -2 + mValues.length);
        return mValues[min] + (n - min * mStepSize) / mStepSize * (mValues[min + 1] - mValues[min]);
    }
}
