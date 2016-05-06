package android.support.v4.view.animation;

import android.graphics.PathMeasure;
import android.graphics.Path;
import android.view.animation.Interpolator;

class PathInterpolatorDonut implements Interpolator
{
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;
    
    public PathInterpolatorDonut(final float n, final float n2) {
        this(createQuad(n, n2));
    }
    
    public PathInterpolatorDonut(final float n, final float n2, final float n3, final float n4) {
        this(createCubic(n, n2, n3, n4));
    }
    
    public PathInterpolatorDonut(final Path path) {
        super();
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        final float length = pathMeasure.getLength();
        final int n = 1 + (int)(length / 0.002f);
        mX = new float[n];
        mY = new float[n];
        final float[] array = new float[2];
        for (int i = 0; i < n; ++i) {
            pathMeasure.getPosTan(length * i / (float)(n - 1), array, (float[])null);
            mX[i] = array[0];
            mY[i] = array[1];
        }
    }
    
    private static Path createCubic(final float n, final float n2, final float n3, final float n4) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(n, n2, n3, n4, 1.0f, 1.0f);
        return path;
    }
    
    private static Path createQuad(final float n, final float n2) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(n, n2, 1.0f, 1.0f);
        return path;
    }
    
    public float getInterpolation(final float n) {
        if (n <= 0.0f) {
            return 0.0f;
        }
        if (n >= 1.0f) {
            return 1.0f;
        }
        int n2 = 0;
        int n3 = -1 + mX.length;
        while (n3 - n2 > 1) {
            final int n4 = (n2 + n3) / 2;
            if (n < mX[n4]) {
                n3 = n4;
            }
            else {
                n2 = n4;
            }
        }
        final float n5 = mX[n3] - mX[n2];
        if (n5 == 0.0f) {
            return mY[n2];
        }
        final float n6 = (n - mX[n2]) / n5;
        final float n7 = mY[n2];
        return n7 + n6 * (mY[n3] - n7);
    }
}
