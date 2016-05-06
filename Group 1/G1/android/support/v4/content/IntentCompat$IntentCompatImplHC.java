package android.support.v4.content;

import android.content.Intent;
import android.content.ComponentName;

static class IntentCompatImplHC extends IntentCompatImplBase
{
    IntentCompatImplHC() {
        super();
    }
    
    @Override
    public Intent makeMainActivity(final ComponentName componentName) {
        return IntentCompatHoneycomb.makeMainActivity(componentName);
    }
    
    @Override
    public Intent makeRestartActivityTask(final ComponentName componentName) {
        return IntentCompatHoneycomb.makeRestartActivityTask(componentName);
    }
}
