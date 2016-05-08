package android.support.v4.hardware.display;

import android.content.Context;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.view.Display;
import android.view.WindowManager;

class DisplayManagerCompat$LegacyImpl extends DisplayManagerCompat {
   private final WindowManager mWindowManager;

   public DisplayManagerCompat$LegacyImpl(Context var1) {
      this.mWindowManager = (WindowManager)var1.getSystemService("window");
   }

   public Display getDisplay(int var1) {
      Display var2 = this.mWindowManager.getDefaultDisplay();
      return var2.getDisplayId() == var1?var2:null;
   }

   public Display[] getDisplays() {
      return new Display[]{this.mWindowManager.getDefaultDisplay()};
   }

   public Display[] getDisplays(String var1) {
      return var1 == null?this.getDisplays():new Display[0];
   }
}
