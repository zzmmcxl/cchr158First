package android.support.v4.media;

import android.text.TextUtils;
import android.support.v4.os.ResultReceiver;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.os.Bundle;

private class ServiceImpl
{
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    private ServiceImpl(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
    }
    
    ServiceImpl(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final MediaBrowserServiceCompat$1 runnable) {
        this(mediaBrowserServiceCompat);
    }
    
    public void addSubscription(final String s, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new Runnable() {
            final /* synthetic */ ServiceImpl this$1;
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$id;
            final /* synthetic */ Bundle val$options;
            
            MediaBrowserServiceCompat$ServiceImpl$3() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                final ConnectionRecord connectionRecord = (ConnectionRecord)MediaBrowserServiceCompat.access$500(this$0).get(serviceCallbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w("MediaBrowserServiceCompat", "addSubscription for callback that isn't registered id=" + s);
                    return;
                }
                MediaBrowserServiceCompat.access$700(this$0, s, connectionRecord, bundle);
            }
        });
    }
    
    public void connect(final String s, final int n, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
        if (!MediaBrowserServiceCompat.access$400(this$0, s, n)) {
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + n + " package=" + s);
        }
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new Runnable() {
            final /* synthetic */ ServiceImpl this$1;
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$pkg;
            final /* synthetic */ Bundle val$rootHints;
            final /* synthetic */ int val$uid;
            
            MediaBrowserServiceCompat$ServiceImpl$1() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                final IBinder binder = serviceCallbacks.asBinder();
                MediaBrowserServiceCompat.access$500(this$0).remove(binder);
                final ConnectionRecord connectionRecord = this$0.new ConnectionRecord();
                connectionRecord.pkg = s;
                connectionRecord.rootHints = bundle;
                connectionRecord.callbacks = serviceCallbacks;
                connectionRecord.root = this$0.onGetRoot(s, n, bundle);
                Label_0182: {
                    if (connectionRecord.root != null) {
                        break Label_0182;
                    }
                    Log.i("MediaBrowserServiceCompat", "No root for client " + s + " from service " + this.getClass().getName());
                    try {
                        serviceCallbacks.onConnectFailed();
                        return;
                    }
                    catch (RemoteException ex) {
                        Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + s);
                        return;
                    }
                    try {
                        MediaBrowserServiceCompat.access$500(this$0).put(binder, connectionRecord);
                        if (mSession != null) {
                            serviceCallbacks.onConnect(connectionRecord.root.getRootId(), mSession, connectionRecord.root.getExtras());
                        }
                    }
                    catch (RemoteException ex2) {
                        Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + s);
                        MediaBrowserServiceCompat.access$500(this$0).remove(binder);
                    }
                }
            }
        });
    }
    
    public void disconnect(final ServiceCallbacks serviceCallbacks) {
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new Runnable() {
            final /* synthetic */ ServiceImpl this$1;
            final /* synthetic */ ServiceCallbacks val$callbacks;
            
            MediaBrowserServiceCompat$ServiceImpl$2() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                if (MediaBrowserServiceCompat.access$500(this$0).remove(serviceCallbacks.asBinder()) != null) {}
            }
        });
    }
    
    public void getMediaItem(final String s, final ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty((CharSequence)s) || resultReceiver == null) {
            return;
        }
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new Runnable() {
            final /* synthetic */ ServiceImpl this$1;
            final /* synthetic */ String val$mediaId;
            final /* synthetic */ ResultReceiver val$receiver;
            
            MediaBrowserServiceCompat$ServiceImpl$5() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                MediaBrowserServiceCompat.access$900(this$0, s, resultReceiver);
            }
        });
    }
    
    public void registerCallbacks(final ServiceCallbacks serviceCallbacks) {
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new Runnable() {
            final /* synthetic */ ServiceImpl this$1;
            final /* synthetic */ ServiceCallbacks val$callbacks;
            
            MediaBrowserServiceCompat$ServiceImpl$6() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                final IBinder binder = serviceCallbacks.asBinder();
                MediaBrowserServiceCompat.access$500(this$0).remove(binder);
                final ConnectionRecord connectionRecord = this$0.new ConnectionRecord();
                connectionRecord.callbacks = serviceCallbacks;
                MediaBrowserServiceCompat.access$500(this$0).put(binder, connectionRecord);
            }
        });
    }
    
    public void removeSubscription(final String s, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
        MediaBrowserServiceCompat.access$100(this$0).postOrRun(new Runnable() {
            final /* synthetic */ ServiceImpl this$1;
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$id;
            final /* synthetic */ Bundle val$options;
            
            MediaBrowserServiceCompat$ServiceImpl$4() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                final ConnectionRecord connectionRecord = (ConnectionRecord)MediaBrowserServiceCompat.access$500(this$0).get(serviceCallbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn't registered id=" + s);
                }
                else if (!MediaBrowserServiceCompat.access$800(this$0, s, connectionRecord, bundle)) {
                    Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + s + " which is not subscribed");
                }
            }
        });
    }
}
