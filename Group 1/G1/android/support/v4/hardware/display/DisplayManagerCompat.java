package android.support.v4.hardware.display;

import android.view.WindowManager;
import android.view.Display;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat
{
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances;
    
    static {
        sInstances = new WeakHashMap<Context, DisplayManagerCompat>();
    }
    
    DisplayManagerCompat() {
        super();
    }
    
    public static DisplayManagerCompat getInstance(final Context context) {
        synchronized (sInstances) {
            DisplayManagerCompat displayManagerCompat = (DisplayManagerCompat)sInstances.get(context);
            if (displayManagerCompat == null) {
                if (Build$VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new JellybeanMr1Impl(context);
                }
                else {
                    displayManagerCompat = new LegacyImpl(context);
                }
                sInstances.put(context, displayManagerCompat);
            }
            return displayManagerCompat;
        }
    }
    
    public abstract Display getDisplay(final int p0);
    
    public abstract Display[] getDisplays();
    
    public abstract Display[] getDisplays(final String p0);
}
