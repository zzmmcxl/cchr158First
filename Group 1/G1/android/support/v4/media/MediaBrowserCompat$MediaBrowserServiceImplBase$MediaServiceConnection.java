package android.support.v4.media;

import android.os.RemoteException;
import android.os.Handler;
import android.os.Messenger;
import android.os.IBinder;
import android.content.ComponentName;
import android.util.Log;
import android.content.ServiceConnection;

private class MediaServiceConnection implements ServiceConnection
{
    final /* synthetic */ MediaBrowserServiceImplBase this$0;
    
    private MediaServiceConnection(final MediaBrowserServiceImplBase this$0) {
        this$0 = this$0;
        super();
    }
    
    MediaServiceConnection(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase, final MediaBrowserCompat$1 object) {
        this(mediaBrowserServiceImplBase);
    }
    
    static /* synthetic */ boolean access$1000(final MediaServiceConnection mediaServiceConnection, final String s) {
        return mediaServiceConnection.isCurrent(s);
    }
    
    private boolean isCurrent(final String s) {
        if (MediaBrowserServiceImplBase.access$700(this$0) != this) {
            if (MediaBrowserServiceImplBase.access$1400(this$0) != 0) {
                Log.i("MediaBrowserCompat", s + " for " + MediaBrowserServiceImplBase.access$1700(this$0) + " with mServiceConnection=" + MediaBrowserServiceImplBase.access$700(this$0) + " this=" + this);
            }
            return false;
        }
        return true;
    }
    
    private void postOrRun(final Runnable runnable) {
        if (Thread.currentThread() == MediaBrowserServiceImplBase.access$1300(this$0).getLooper().getThread()) {
            runnable.run();
            return;
        }
        MediaBrowserServiceImplBase.access$1300(this$0).post(runnable);
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.postOrRun(new Runnable() {
            final /* synthetic */ MediaServiceConnection this$1;
            final /* synthetic */ IBinder val$binder;
            final /* synthetic */ ComponentName val$name;
            
            MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                if (!this$1.isCurrent("onServiceConnected")) {
                    return;
                }
                MediaBrowserServiceImplBase.access$1102(this$0, new ServiceBinderWrapper(binder));
                MediaBrowserServiceImplBase.access$1202(this$0, new Messenger((Handler)MediaBrowserServiceImplBase.access$1300(this$0)));
                MediaBrowserServiceImplBase.access$1300(this$0).setCallbacksMessenger(MediaBrowserServiceImplBase.access$1200(this$0));
                MediaBrowserServiceImplBase.access$1402(this$0, 1);
                try {
                    MediaBrowserServiceImplBase.access$1100(this$0).connect(MediaBrowserServiceImplBase.access$1500(this$0), MediaBrowserServiceImplBase.access$1600(this$0), MediaBrowserServiceImplBase.access$1200(this$0));
                }
                catch (RemoteException ex) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserServiceImplBase.access$1700(this$0));
                }
            }
        });
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        this.postOrRun(new Runnable() {
            final /* synthetic */ MediaServiceConnection this$1;
            final /* synthetic */ ComponentName val$name;
            
            MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                if (!this$1.isCurrent("onServiceDisconnected")) {
                    return;
                }
                MediaBrowserServiceImplBase.access$1102(this$0, null);
                MediaBrowserServiceImplBase.access$1202(this$0, null);
                MediaBrowserServiceImplBase.access$1300(this$0).setCallbacksMessenger(null);
                MediaBrowserServiceImplBase.access$1402(this$0, 3);
                MediaBrowserServiceImplBase.access$900(this$0).onConnectionSuspended();
            }
        });
    }
}
