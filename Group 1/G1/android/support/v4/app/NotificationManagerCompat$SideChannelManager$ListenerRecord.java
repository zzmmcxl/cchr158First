package android.support.v4.app;

import java.util.LinkedList;
import android.content.ComponentName;

private static class ListenerRecord
{
    public boolean bound;
    public final ComponentName componentName;
    public int retryCount;
    public INotificationSideChannel service;
    public LinkedList<Task> taskQueue;
    
    public ListenerRecord(final ComponentName componentName) {
        super();
        this.bound = false;
        this.taskQueue = new LinkedList<Task>();
        this.retryCount = 0;
        this.componentName = componentName;
    }
}
