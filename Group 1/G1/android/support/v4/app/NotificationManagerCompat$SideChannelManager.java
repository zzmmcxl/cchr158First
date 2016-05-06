package android.support.v4.app;

import java.util.LinkedList;
import android.os.Message;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.os.DeadObjectException;
import android.os.IBinder;
import java.util.Iterator;
import android.util.Log;
import android.content.Intent;
import java.util.HashSet;
import java.util.HashMap;
import android.content.ComponentName;
import java.util.Map;
import android.os.HandlerThread;
import android.os.Handler;
import android.content.Context;
import java.util.Set;
import android.content.ServiceConnection;
import android.os.Handler$Callback;

private static class SideChannelManager implements Handler$Callback, ServiceConnection
{
    private static final String KEY_BINDER = "binder";
    private static final int MSG_QUEUE_TASK = 0;
    private static final int MSG_RETRY_LISTENER_QUEUE = 3;
    private static final int MSG_SERVICE_CONNECTED = 1;
    private static final int MSG_SERVICE_DISCONNECTED = 2;
    private Set<String> mCachedEnabledPackages;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, ListenerRecord> mRecordMap;
    
    public SideChannelManager(final Context mContext) {
        super();
        this.mRecordMap = new HashMap<ComponentName, ListenerRecord>();
        this.mCachedEnabledPackages = new HashSet<String>();
        this.mContext = mContext;
        (this.mHandlerThread = new HandlerThread("NotificationManagerCompat")).start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), (Handler$Callback)this);
    }
    
    private boolean ensureServiceBound(final ListenerRecord listenerRecord) {
        if (listenerRecord.bound) {
            return true;
        }
        listenerRecord.bound = mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.componentName), (ServiceConnection)this, NotificationManagerCompat.access$000());
        if (listenerRecord.bound) {
            listenerRecord.retryCount = 0;
        }
        else {
            Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.componentName);
            mContext.unbindService((ServiceConnection)this);
        }
        return listenerRecord.bound;
    }
    
    private void ensureServiceUnbound(final ListenerRecord listenerRecord) {
        if (listenerRecord.bound) {
            mContext.unbindService((ServiceConnection)this);
            listenerRecord.bound = false;
        }
        listenerRecord.service = null;
    }
    
    private void handleQueueTask(final Task task) {
        this.updateListenerMap();
        for (final ListenerRecord listenerRecord : mRecordMap.values()) {
            listenerRecord.taskQueue.add(task);
            this.processListenerQueue(listenerRecord);
        }
    }
    
    private void handleRetryListenerQueue(final ComponentName componentName) {
        final ListenerRecord listenerRecord = (ListenerRecord)mRecordMap.get(componentName);
        if (listenerRecord != null) {
            this.processListenerQueue(listenerRecord);
        }
    }
    
    private void handleServiceConnected(final ComponentName componentName, final IBinder binder) {
        final ListenerRecord listenerRecord = (ListenerRecord)mRecordMap.get(componentName);
        if (listenerRecord != null) {
            listenerRecord.service = INotificationSideChannel.Stub.asInterface(binder);
            listenerRecord.retryCount = 0;
            this.processListenerQueue(listenerRecord);
        }
    }
    
    private void handleServiceDisconnected(final ComponentName componentName) {
        final ListenerRecord listenerRecord = (ListenerRecord)mRecordMap.get(componentName);
        if (listenerRecord != null) {
            this.ensureServiceUnbound(listenerRecord);
        }
    }
    
    private void processListenerQueue(final ListenerRecord listenerRecord) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + listenerRecord.componentName + ", " + listenerRecord.taskQueue.size() + " queued tasks");
        }
        if (!listenerRecord.taskQueue.isEmpty()) {
            if (!this.ensureServiceBound(listenerRecord) || listenerRecord.service == null) {
                this.scheduleListenerRetry(listenerRecord);
                return;
            }
            Label_0141: {
                break Label_0141;
                while (true) {
                    try {
                        Task task = null;
                        do {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Sending task " + task);
                            }
                            task.send(listenerRecord.service);
                            listenerRecord.taskQueue.remove();
                            task = listenerRecord.taskQueue.peek();
                        } while (task != null);
                        if (!listenerRecord.taskQueue.isEmpty()) {
                            this.scheduleListenerRetry(listenerRecord);
                        }
                    }
                    catch (DeadObjectException ex2) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.componentName);
                        }
                        continue;
                    }
                    catch (RemoteException ex) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.componentName, (Throwable)ex);
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void scheduleListenerRetry(final ListenerRecord listenerRecord) {
        if (mHandler.hasMessages(3, (Object)listenerRecord.componentName)) {
            return;
        }
        ++listenerRecord.retryCount;
        if (listenerRecord.retryCount > 6) {
            Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.taskQueue.size() + " tasks to " + listenerRecord.componentName + " after " + listenerRecord.retryCount + " retries");
            listenerRecord.taskQueue.clear();
            return;
        }
        final int n = 1000 * (1 << -1 + listenerRecord.retryCount);
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + n + " ms");
        }
        mHandler.sendMessageDelayed(mHandler.obtainMessage(3, (Object)listenerRecord.componentName), (long)n);
    }
    
    private void updateListenerMap() {
        final Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(mContext);
        if (!enabledListenerPackages.equals(mCachedEnabledPackages)) {
            mCachedEnabledPackages = enabledListenerPackages;
            final List queryIntentServices = mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
            final HashSet<ComponentName> set = new HashSet<ComponentName>();
            for (final ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    final ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    }
                    else {
                        set.add(componentName);
                    }
                }
            }
            for (final ComponentName componentName2 : set) {
                if (!mRecordMap.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            final Iterator<Map.Entry<ComponentName, ListenerRecord>> iterator3 = mRecordMap.entrySet().iterator();
            while (iterator3.hasNext()) {
                final Map.Entry<ComponentName, ListenerRecord> entry = (Map.Entry<ComponentName, ListenerRecord>)iterator3.next();
                if (!set.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    this.ensureServiceUnbound(entry.getValue());
                    iterator3.remove();
                }
            }
        }
    }
    
    public boolean handleMessage(final Message message) {
        switch (message.what) {
            default:
                return false;
            case 0:
                this.handleQueueTask((Task)message.obj);
                return true;
            case 1: {
                final ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent)message.obj;
                this.handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                return true;
            }
            case 2:
                this.handleServiceDisconnected((ComponentName)message.obj);
                return true;
            case 3:
                this.handleRetryListenerQueue((ComponentName)message.obj);
                return true;
        }
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        mHandler.obtainMessage(1, (Object)new ServiceConnectedEvent(componentName, binder)).sendToTarget();
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        mHandler.obtainMessage(2, (Object)componentName).sendToTarget();
    }
    
    public void queueTask(final Task task) {
        mHandler.obtainMessage(0, (Object)task).sendToTarget();
    }
}
