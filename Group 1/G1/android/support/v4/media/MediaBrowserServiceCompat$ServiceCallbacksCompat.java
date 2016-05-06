package android.support.v4.media;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Message;
import android.os.Bundle;
import android.os.Messenger;

private class ServiceCallbacksCompat implements ServiceCallbacks
{
    final Messenger mCallbacks;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    ServiceCallbacksCompat(final MediaBrowserServiceCompat this$0, final Messenger mCallbacks) {
        this$0 = this$0;
        super();
        mCallbacks = mCallbacks;
    }
    
    private void sendRequest(final int what, final Bundle data) throws RemoteException {
        final Message obtain = Message.obtain();
        obtain.what = what;
        obtain.arg1 = 1;
        obtain.setData(data);
        mCallbacks.send(obtain);
    }
    
    @Override
    public IBinder asBinder() {
        return mCallbacks.getBinder();
    }
    
    @Override
    public void onConnect(final String s, final MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 1);
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", s);
        bundle2.putParcelable("data_media_session_token", (Parcelable)token);
        bundle2.putBundle("data_root_hints", bundle);
        this.sendRequest(1, bundle2);
    }
    
    @Override
    public void onConnectFailed() throws RemoteException {
        this.sendRequest(2, null);
    }
    
    @Override
    public void onLoadChildren(final String s, final List<MediaBrowserCompat.MediaItem> list, final Bundle bundle) throws RemoteException {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", s);
        bundle2.putBundle("data_options", bundle);
        if (list != null) {
            ArrayList list2;
            if (list instanceof ArrayList) {
                list2 = (ArrayList<? extends E>)list;
            }
            else {
                list2 = new ArrayList((Collection<? extends E>)list);
            }
            bundle2.putParcelableArrayList("data_media_item_list", list2);
        }
        this.sendRequest(3, bundle2);
    }
}
