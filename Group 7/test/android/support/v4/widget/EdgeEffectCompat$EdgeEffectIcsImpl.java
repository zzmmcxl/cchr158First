package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl;
import android.support.v4.widget.EdgeEffectCompatIcs;

class EdgeEffectCompat$EdgeEffectIcsImpl implements EdgeEffectCompat$EdgeEffectImpl {
   public boolean draw(Object var1, Canvas var2) {
      return EdgeEffectCompatIcs.draw(var1, var2);
   }

   public void finish(Object var1) {
      EdgeEffectCompatIcs.finish(var1);
   }

   public boolean isFinished(Object var1) {
      return EdgeEffectCompatIcs.isFinished(var1);
   }

   public Object newEdgeEffect(Context var1) {
      return EdgeEffectCompatIcs.newEdgeEffect(var1);
   }

   public boolean onAbsorb(Object var1, int var2) {
      return EdgeEffectCompatIcs.onAbsorb(var1, var2);
   }

   public boolean onPull(Object var1, float var2) {
      return EdgeEffectCompatIcs.onPull(var1, var2);
   }

   public boolean onPull(Object var1, float var2, float var3) {
      return EdgeEffectCompatIcs.onPull(var1, var2);
   }

   public boolean onRelease(Object var1) {
      return EdgeEffectCompatIcs.onRelease(var1);
   }

   public void setSize(Object var1, int var2, int var3) {
      EdgeEffectCompatIcs.setSize(var1, var2, var3);
   }
}
