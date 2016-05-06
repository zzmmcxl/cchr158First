package android.support.v4.app;

import android.os.IBinder;
import android.content.ComponentName;

private static class ServiceConnectedEvent
{
    final ComponentName componentName;
    final IBinder iBinder;
    
    public ServiceConnectedEvent(final ComponentName componentName, final IBinder iBinder) {
        super();
        this.componentName = componentName;
        this.iBinder = iBinder;
    }
}
