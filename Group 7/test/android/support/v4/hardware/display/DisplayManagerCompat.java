package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat {
   public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
   private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap();

   public static DisplayManagerCompat getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public abstract Display getDisplay(int var1);

   public abstract Display[] getDisplays();

   public abstract Display[] getDisplays(String var1);
}
