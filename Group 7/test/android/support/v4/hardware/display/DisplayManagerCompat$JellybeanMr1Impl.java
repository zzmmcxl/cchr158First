package android.support.v4.hardware.display;

import android.content.Context;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.hardware.display.DisplayManagerJellybeanMr1;
import android.view.Display;

class DisplayManagerCompat$JellybeanMr1Impl extends DisplayManagerCompat {
   private final Object mDisplayManagerObj;

   public DisplayManagerCompat$JellybeanMr1Impl(Context var1) {
      this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(var1);
   }

   public Display getDisplay(int var1) {
      return DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, var1);
   }

   public Display[] getDisplays() {
      return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
   }

   public Display[] getDisplays(String var1) {
      return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, var1);
   }
}
