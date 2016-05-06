package android.support.v4.media;

import android.os.Bundle;
import java.util.List;
import android.util.Log;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.Message;
import android.os.Messenger;
import java.lang.ref.WeakReference;
import android.os.Handler;

private static class CallbackHandler extends Handler
{
    private final MediaBrowserServiceCallbackImpl mCallbackImpl;
    private WeakReference<Messenger> mCallbacksMessengerRef;
    
    CallbackHandler(final MediaBrowserServiceCallbackImpl mCallbackImpl) {
        super();
        this.mCallbackImpl = mCallbackImpl;
    }
    
    public void handleMessage(final Message message) {
        if (mCallbacksMessengerRef == null) {
            return;
        }
        final Bundle data = message.getData();
        data.setClassLoader(MediaSessionCompat.class.getClassLoader());
        switch (message.what) {
            default:
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
            case 1:
                mCallbackImpl.onServiceConnected(mCallbacksMessengerRef.get(), data.getString("data_media_item_id"), (MediaSessionCompat.Token)data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
            case 2:
                mCallbackImpl.onConnectionFailed(mCallbacksMessengerRef.get());
            case 3:
                mCallbackImpl.onLoadChildren(mCallbacksMessengerRef.get(), data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), data.getBundle("data_options"));
        }
    }
    
    void setCallbacksMessenger(final Messenger messenger) {
        mCallbacksMessengerRef = new WeakReference<Messenger>(messenger);
    }
}
