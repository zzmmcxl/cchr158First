package android.support.v4.hardware.display;

import android.view.Display;
import android.content.Context;
import android.view.WindowManager;

private static class LegacyImpl extends DisplayManagerCompat
{
    private final WindowManager mWindowManager;
    
    public LegacyImpl(final Context context) {
        super();
        this.mWindowManager = (WindowManager)context.getSystemService("window");
    }
    
    @Override
    public Display getDisplay(final int n) {
        final Display defaultDisplay = mWindowManager.getDefaultDisplay();
        if (defaultDisplay.getDisplayId() == n) {
            return defaultDisplay;
        }
        return null;
    }
    
    @Override
    public Display[] getDisplays() {
        return new Display[] { mWindowManager.getDefaultDisplay() };
    }
    
    @Override
    public Display[] getDisplays(final String s) {
        if (s == null) {
            return this.getDisplays();
        }
        return new Display[0];
    }
}
