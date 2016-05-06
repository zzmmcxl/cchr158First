package android.support.v4.media;

import android.os.RemoteException;
import android.util.Log;
import android.os.Handler;
import android.os.Messenger;
import android.content.ComponentName;
import android.os.IBinder;

class MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1 implements Runnable {
    final /* synthetic */ MediaServiceConnection this$1;
    final /* synthetic */ IBinder val$binder;
    final /* synthetic */ ComponentName val$name;
    
    MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1(final MediaServiceConnection this$1, final ComponentName val$name, final IBinder val$binder) {
        this$1 = this$1;
        val$name = val$name;
        val$binder = val$binder;
        super();
    }
    
    @Override
    public void run() {
        if (!MediaServiceConnection.access$1000(this$1, "onServiceConnected")) {
            return;
        }
        MediaBrowserServiceImplBase.access$1102(this$0, new ServiceBinderWrapper(val$binder));
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
}