package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

static class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl
{
    TaskStackBuilderImplJellybean() {
        super();
    }
    
    @Override
    public PendingIntent getPendingIntent(final Context context, final Intent[] array, final int n, final int n2, final Bundle bundle) {
        array[0] = new Intent(array[0]).addFlags(268484608);
        return TaskStackBuilderJellybean.getActivitiesPendingIntent(context, n, array, n2, bundle);
    }
}
