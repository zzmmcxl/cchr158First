package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

interface EdgeEffectCompat$EdgeEffectImpl {
   boolean draw(Object var1, Canvas var2);

   void finish(Object var1);

   boolean isFinished(Object var1);

   Object newEdgeEffect(Context var1);

   boolean onAbsorb(Object var1, int var2);

   boolean onPull(Object var1, float var2);

   boolean onPull(Object var1, float var2, float var3);

   boolean onRelease(Object var1);

   void setSize(Object var1, int var2, int var3);
}
