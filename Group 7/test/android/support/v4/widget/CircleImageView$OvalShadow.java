package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.widget.CircleImageView;

class CircleImageView$OvalShadow extends OvalShape {
   private int mCircleDiameter;
   private RadialGradient mRadialGradient;
   private Paint mShadowPaint;

   public CircleImageView$OvalShadow(CircleImageView var1, int var2, int var3) {
      this.this$0 = var1;
      this.mShadowPaint = new Paint();
      CircleImageView.access$002(var1, var2);
      this.mCircleDiameter = var3;
      float var4 = (float)(this.mCircleDiameter / 2);
      float var5 = (float)(this.mCircleDiameter / 2);
      float var6 = (float)CircleImageView.access$000(var1);
      TileMode var7 = TileMode.CLAMP;
      this.mRadialGradient = new RadialGradient(var4, var5, var6, new int[]{1023410176, 0}, (float[])null, var7);
      this.mShadowPaint.setShader(this.mRadialGradient);
   }

   public void draw(Canvas var1, Paint var2) {
      int var3 = this.this$0.getWidth();
      int var4 = this.this$0.getHeight();
      var1.drawCircle((float)(var3 / 2), (float)(var4 / 2), (float)(this.mCircleDiameter / 2 + CircleImageView.access$000(this.this$0)), this.mShadowPaint);
      var1.drawCircle((float)(var3 / 2), (float)(var4 / 2), (float)(this.mCircleDiameter / 2), var2);
   }
}
