package android.support.v4.content;

import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

class ContextCompatJellybean
{
    ContextCompatJellybean() {
        super();
    }
    
    public static void startActivities(final Context context, final Intent[] array, final Bundle bundle) {
        context.startActivities(array, bundle);
    }
}
