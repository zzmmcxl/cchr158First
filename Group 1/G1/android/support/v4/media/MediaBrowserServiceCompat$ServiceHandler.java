package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.os.Message;
import android.os.Handler;

private final class ServiceHandler extends Handler
{
    private final ServiceImpl mServiceImpl;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    private ServiceHandler(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
        mServiceImpl = this$0.new ServiceImpl();
    }
    
    ServiceHandler(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final MediaBrowserServiceCompat$1 runnable) {
        this(mediaBrowserServiceCompat);
    }
    
    public ServiceImpl getServiceImpl() {
        return mServiceImpl;
    }
    
    public void handleMessage(final Message message) {
        final Bundle data = message.getData();
        switch (message.what) {
            default:
                Log.w("MediaBrowserServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 1 + "\n  Client version: " + message.arg1);
            case 1:
                mServiceImpl.connect(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), this$0.new ServiceCallbacksCompat(message.replyTo));
            case 2:
                mServiceImpl.disconnect(this$0.new ServiceCallbacksCompat(message.replyTo));
            case 3:
                mServiceImpl.addSubscription(data.getString("data_media_item_id"), data.getBundle("data_options"), this$0.new ServiceCallbacksCompat(message.replyTo));
            case 4:
                mServiceImpl.removeSubscription(data.getString("data_media_item_id"), data.getBundle("data_options"), this$0.new ServiceCallbacksCompat(message.replyTo));
            case 5:
                mServiceImpl.getMediaItem(data.getString("data_media_item_id"), (ResultReceiver)data.getParcelable("data_result_receiver"));
            case 6:
                mServiceImpl.registerCallbacks(this$0.new ServiceCallbacksCompat(message.replyTo));
        }
    }
    
    public void postOrRun(final Runnable runnable) {
        if (Thread.currentThread() == this.getLooper().getThread()) {
            runnable.run();
            return;
        }
        this.post(runnable);
    }
    
    public boolean sendMessageAtTime(final Message message, final long n) {
        final Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt("data_calling_uid", Binder.getCallingUid());
        return super.sendMessageAtTime(message, n);
    }
}
