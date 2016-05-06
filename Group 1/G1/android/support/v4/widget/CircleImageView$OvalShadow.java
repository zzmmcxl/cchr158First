package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.Shader$TileMode;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.shapes.OvalShape;

private class OvalShadow extends OvalShape
{
    private int mCircleDiameter;
    private RadialGradient mRadialGradient;
    private Paint mShadowPaint;
    final /* synthetic */ CircleImageView this$0;
    
    public OvalShadow(final CircleImageView this$0, final int n, final int mCircleDiameter) {
        this$0 = this$0;
        super();
        mShadowPaint = new Paint();
        CircleImageView.access$002(this$0, n);
        mCircleDiameter = mCircleDiameter;
        mRadialGradient = new RadialGradient((float)(mCircleDiameter / 2), (float)(mCircleDiameter / 2), (float)CircleImageView.access$000(this$0), new int[] { 1023410176, 0 }, (float[])null, Shader$TileMode.CLAMP);
        mShadowPaint.setShader((Shader)mRadialGradient);
    }
    
    public void draw(final Canvas canvas, final Paint paint) {
        final int width = this$0.getWidth();
        final int height = this$0.getHeight();
        canvas.drawCircle((float)(width / 2), (float)(height / 2), (float)(mCircleDiameter / 2 + CircleImageView.access$000(this$0)), mShadowPaint);
        canvas.drawCircle((float)(width / 2), (float)(height / 2), (float)(mCircleDiameter / 2), paint);
    }
}
