package android.support.v4.media;

import android.os.IBinder;
import android.content.Intent;

interface MediaBrowserServiceImpl
{
    IBinder onBind(final Intent p0);
    
    void onCreate();
}
