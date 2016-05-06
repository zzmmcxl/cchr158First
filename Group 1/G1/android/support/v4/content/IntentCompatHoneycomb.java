package android.support.v4.content;

import android.content.Intent;
import android.content.ComponentName;

class IntentCompatHoneycomb
{
    IntentCompatHoneycomb() {
        super();
    }
    
    public static Intent makeMainActivity(final ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }
    
    public static Intent makeRestartActivityTask(final ComponentName componentName) {
        return Intent.makeRestartActivityTask(componentName);
    }
}
