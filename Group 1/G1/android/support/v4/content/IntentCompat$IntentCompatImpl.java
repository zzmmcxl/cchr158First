package android.support.v4.content;

import android.content.Intent;
import android.content.ComponentName;

interface IntentCompatImpl
{
    Intent makeMainActivity(final ComponentName p0);
    
    Intent makeMainSelectorActivity(final String p0, final String p1);
    
    Intent makeRestartActivityTask(final ComponentName p0);
}
