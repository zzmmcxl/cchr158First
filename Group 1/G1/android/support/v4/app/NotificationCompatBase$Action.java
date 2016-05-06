package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

public abstract static class Action
{
    public Action() {
        super();
    }
    
    public abstract PendingIntent getActionIntent();
    
    public abstract Bundle getExtras();
    
    public abstract int getIcon();
    
    public abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();
    
    public abstract CharSequence getTitle();
}
