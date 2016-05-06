package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.TypedArray;
import java.util.ArrayList;
import android.graphics.Paint$Style;
import android.graphics.Region$Op;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.support.v4.util.ArrayMap;
import android.graphics.PathMeasure;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.Matrix;

private static class VPathRenderer
{
    private static final Matrix IDENTITY_MATRIX;
    float mBaseHeight;
    float mBaseWidth;
    private int mChangingConfigurations;
    private Paint mFillPaint;
    private final Matrix mFinalPathMatrix;
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    int mRootAlpha;
    private final VGroup mRootGroup;
    String mRootName;
    private Paint mStrokePaint;
    final ArrayMap<String, Object> mVGTargetsMap;
    float mViewportHeight;
    float mViewportWidth;
    
    static {
        IDENTITY_MATRIX = new Matrix();
    }
    
    public VPathRenderer() {
        super();
        this.mFinalPathMatrix = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mVGTargetsMap = new ArrayMap<String, Object>();
        this.mRootGroup = new VGroup();
        this.mPath = new Path();
        this.mRenderPath = new Path();
    }
    
    public VPathRenderer(final VPathRenderer vPathRenderer) {
        super();
        this.mFinalPathMatrix = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mVGTargetsMap = new ArrayMap<String, Object>();
        this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, this.mVGTargetsMap);
        this.mPath = new Path(vPathRenderer.mPath);
        this.mRenderPath = new Path(vPathRenderer.mRenderPath);
        this.mBaseWidth = vPathRenderer.mBaseWidth;
        this.mBaseHeight = vPathRenderer.mBaseHeight;
        this.mViewportWidth = vPathRenderer.mViewportWidth;
        this.mViewportHeight = vPathRenderer.mViewportHeight;
        this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
        this.mRootAlpha = vPathRenderer.mRootAlpha;
        this.mRootName = vPathRenderer.mRootName;
        if (vPathRenderer.mRootName != null) {
            this.mVGTargetsMap.put(vPathRenderer.mRootName, this);
        }
    }
    
    static /* synthetic */ VGroup access$000(final VPathRenderer vPathRenderer) {
        return vPathRenderer.mRootGroup;
    }
    
    static /* synthetic */ Paint access$400(final VPathRenderer vPathRenderer) {
        return vPathRenderer.mFillPaint;
    }
    
    static /* synthetic */ Paint access$402(final VPathRenderer vPathRenderer, final Paint mFillPaint) {
        return vPathRenderer.mFillPaint = mFillPaint;
    }
    
    static /* synthetic */ Paint access$500(final VPathRenderer vPathRenderer) {
        return vPathRenderer.mStrokePaint;
    }
    
    static /* synthetic */ Paint access$502(final VPathRenderer vPathRenderer, final Paint mStrokePaint) {
        return vPathRenderer.mStrokePaint = mStrokePaint;
    }
    
    private static float cross(final float n, final float n2, final float n3, final float n4) {
        return n * n4 - n2 * n3;
    }
    
    private void drawGroupTree(final VGroup vGroup, final Matrix matrix, final Canvas canvas, final int n, final int n2, final ColorFilter colorFilter) {
        vGroup.mStackedMatrix.set(matrix);
        vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
        for (int i = 0; i < vGroup.mChildren.size(); ++i) {
            final Object value = vGroup.mChildren.get(i);
            if (value instanceof VGroup) {
                this.drawGroupTree((VGroup)value, vGroup.mStackedMatrix, canvas, n, n2, colorFilter);
            }
            else if (value instanceof VPath) {
                this.drawPath(vGroup, (VPath)value, canvas, n, n2, colorFilter);
            }
        }
    }
    
    private void drawPath(final VGroup vGroup, final VPath vPath, final Canvas canvas, final int n, final int n2, final ColorFilter colorFilter) {
        final float n3 = n / mViewportWidth;
        final float n4 = n2 / mViewportHeight;
        final float min = Math.min(n3, n4);
        final Matrix access$700 = vGroup.mStackedMatrix;
        mFinalPathMatrix.set(access$700);
        mFinalPathMatrix.postScale(n3, n4);
        final float matrixScale = this.getMatrixScale(access$700);
        if (matrixScale != 0.0f) {
            vPath.toPath(mPath);
            final Path mPath = this.mPath;
            mRenderPath.reset();
            if (vPath.isClipPath()) {
                mRenderPath.addPath(mPath, mFinalPathMatrix);
                canvas.clipPath(mRenderPath, Region$Op.REPLACE);
                return;
            }
            final VFullPath vFullPath = (VFullPath)vPath;
            if (vFullPath.mTrimPathStart != 0.0f || vFullPath.mTrimPathEnd != 1.0f) {
                final float n5 = (vFullPath.mTrimPathStart + vFullPath.mTrimPathOffset) % 1.0f;
                final float n6 = (vFullPath.mTrimPathEnd + vFullPath.mTrimPathOffset) % 1.0f;
                if (mPathMeasure == null) {
                    mPathMeasure = new PathMeasure();
                }
                mPathMeasure.setPath(this.mPath, false);
                final float length = mPathMeasure.getLength();
                final float n7 = n5 * length;
                final float n8 = n6 * length;
                mPath.reset();
                if (n7 > n8) {
                    mPathMeasure.getSegment(n7, length, mPath, true);
                    mPathMeasure.getSegment(0.0f, n8, mPath, true);
                }
                else {
                    mPathMeasure.getSegment(n7, n8, mPath, true);
                }
                mPath.rLineTo(0.0f, 0.0f);
            }
            mRenderPath.addPath(mPath, mFinalPathMatrix);
            if (vFullPath.mFillColor != 0) {
                if (mFillPaint == null) {
                    (mFillPaint = new Paint()).setStyle(Paint$Style.FILL);
                    mFillPaint.setAntiAlias(true);
                }
                final Paint mFillPaint = this.mFillPaint;
                mFillPaint.setColor(VectorDrawableCompat.access$900(vFullPath.mFillColor, vFullPath.mFillAlpha));
                mFillPaint.setColorFilter(colorFilter);
                canvas.drawPath(mRenderPath, mFillPaint);
            }
            if (vFullPath.mStrokeColor != 0) {
                if (mStrokePaint == null) {
                    (mStrokePaint = new Paint()).setStyle(Paint$Style.STROKE);
                    mStrokePaint.setAntiAlias(true);
                }
                final Paint mStrokePaint = this.mStrokePaint;
                if (vFullPath.mStrokeLineJoin != null) {
                    mStrokePaint.setStrokeJoin(vFullPath.mStrokeLineJoin);
                }
                if (vFullPath.mStrokeLineCap != null) {
                    mStrokePaint.setStrokeCap(vFullPath.mStrokeLineCap);
                }
                mStrokePaint.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                mStrokePaint.setColor(VectorDrawableCompat.access$900(vFullPath.mStrokeColor, vFullPath.mStrokeAlpha));
                mStrokePaint.setColorFilter(colorFilter);
                mStrokePaint.setStrokeWidth(min * matrixScale * vFullPath.mStrokeWidth);
                canvas.drawPath(mRenderPath, mStrokePaint);
            }
        }
    }
    
    private float getMatrixScale(final Matrix matrix) {
        final float[] array = { 0.0f, 1.0f, 1.0f, 0.0f };
        matrix.mapVectors(array);
        final float n = (float)Math.hypot(array[0], array[1]);
        final float n2 = (float)Math.hypot(array[2], array[3]);
        final float cross = cross(array[0], array[1], array[2], array[3]);
        final float max = Math.max(n, n2);
        final float n3 = fcmpl(max, 0.0f);
        float n4 = 0.0f;
        if (n3 > 0) {
            n4 = Math.abs(cross) / max;
        }
        return n4;
    }
    
    public void draw(final Canvas canvas, final int n, final int n2, final ColorFilter colorFilter) {
        this.drawGroupTree(mRootGroup, IDENTITY_MATRIX, canvas, n, n2, colorFilter);
    }
    
    public float getAlpha() {
        return this.getRootAlpha() / 255.0f;
    }
    
    public int getRootAlpha() {
        return mRootAlpha;
    }
    
    public void setAlpha(final float n) {
        this.setRootAlpha((int)(255.0f * n));
    }
    
    public void setRootAlpha(final int mRootAlpha) {
        this.mRootAlpha = mRootAlpha;
    }
}
