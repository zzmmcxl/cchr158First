package android.support.v4.hardware.display;

import android.view.Display;
import android.content.Context;

private static class JellybeanMr1Impl extends DisplayManagerCompat
{
    private final Object mDisplayManagerObj;
    
    public JellybeanMr1Impl(final Context context) {
        super();
        this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(context);
    }
    
    @Override
    public Display getDisplay(final int n) {
        return DisplayManagerJellybeanMr1.getDisplay(mDisplayManagerObj, n);
    }
    
    @Override
    public Display[] getDisplays() {
        return DisplayManagerJellybeanMr1.getDisplays(mDisplayManagerObj);
    }
    
    @Override
    public Display[] getDisplays(final String s) {
        return DisplayManagerJellybeanMr1.getDisplays(mDisplayManagerObj, s);
    }
}
