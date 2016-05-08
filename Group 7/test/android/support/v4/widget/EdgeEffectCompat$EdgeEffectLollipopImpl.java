package android.support.v4.widget;

import android.support.v4.widget.EdgeEffectCompat$EdgeEffectIcsImpl;
import android.support.v4.widget.EdgeEffectCompatLollipop;

class EdgeEffectCompat$EdgeEffectLollipopImpl extends EdgeEffectCompat$EdgeEffectIcsImpl {
   public boolean onPull(Object var1, float var2, float var3) {
      return EdgeEffectCompatLollipop.onPull(var1, var2, var3);
   }
}
