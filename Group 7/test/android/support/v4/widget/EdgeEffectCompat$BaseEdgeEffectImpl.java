package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl;

class EdgeEffectCompat$BaseEdgeEffectImpl implements EdgeEffectCompat$EdgeEffectImpl {
   public boolean draw(Object var1, Canvas var2) {
      return false;
   }

   public void finish(Object var1) {
   }

   public boolean isFinished(Object var1) {
      return true;
   }

   public Object newEdgeEffect(Context var1) {
      return null;
   }

   public boolean onAbsorb(Object var1, int var2) {
      return false;
   }

   public boolean onPull(Object var1, float var2) {
      return false;
   }

   public boolean onPull(Object var1, float var2, float var3) {
      return false;
   }

   public boolean onRelease(Object var1) {
      return false;
   }

   public void setSize(Object var1, int var2, int var3) {
   }
}
