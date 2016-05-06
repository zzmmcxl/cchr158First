package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

interface TaskStackBuilderImpl
{
    PendingIntent getPendingIntent(final Context p0, final Intent[] p1, final int p2, final int p3, final Bundle p4);
}
