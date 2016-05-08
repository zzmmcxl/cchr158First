package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.widget.EdgeEffectCompat$BaseEdgeEffectImpl;
import android.support.v4.widget.EdgeEffectCompat$EdgeEffectIcsImpl;
import android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl;
import android.support.v4.widget.EdgeEffectCompat$EdgeEffectLollipopImpl;

public final class EdgeEffectCompat {
   private static final EdgeEffectCompat$EdgeEffectImpl IMPL;
   private Object mEdgeEffect;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new EdgeEffectCompat$EdgeEffectLollipopImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new EdgeEffectCompat$EdgeEffectIcsImpl();
      } else {
         IMPL = new EdgeEffectCompat$BaseEdgeEffectImpl();
      }
   }

   public EdgeEffectCompat(Context var1) {
      this.mEdgeEffect = IMPL.newEdgeEffect(var1);
   }

   public boolean draw(Canvas var1) {
      return IMPL.draw(this.mEdgeEffect, var1);
   }

   public void finish() {
      IMPL.finish(this.mEdgeEffect);
   }

   public boolean isFinished() {
      return IMPL.isFinished(this.mEdgeEffect);
   }

   public boolean onAbsorb(int var1) {
      return IMPL.onAbsorb(this.mEdgeEffect, var1);
   }

   public boolean onPull(float var1) {
      return IMPL.onPull(this.mEdgeEffect, var1);
   }

   public boolean onPull(float var1, float var2) {
      return IMPL.onPull(this.mEdgeEffect, var1, var2);
   }

   public boolean onRelease() {
      return IMPL.onRelease(this.mEdgeEffect);
   }

   public void setSize(int var1, int var2) {
      IMPL.setSize(this.mEdgeEffect, var1, var2);
   }
}
