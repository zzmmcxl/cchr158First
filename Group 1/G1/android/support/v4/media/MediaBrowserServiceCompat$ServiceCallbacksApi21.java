package android.support.v4.media;

import java.util.Iterator;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import android.os.RemoteException;
import android.support.v4.app.BundleCompat;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.IBinder;
import android.os.Messenger;

private class ServiceCallbacksApi21 implements ServiceCallbacks
{
    final MediaBrowserServiceCompatApi21.ServiceCallbacks mCallbacks;
    Messenger mMessenger;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    ServiceCallbacksApi21(final MediaBrowserServiceCompat this$0, final MediaBrowserServiceCompatApi21.ServiceCallbacks mCallbacks) {
        this$0 = this$0;
        super();
        mCallbacks = mCallbacks;
    }
    
    @Override
    public IBinder asBinder() {
        return mCallbacks.asBinder();
    }
    
    @Override
    public void onConnect(final String s, final MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        mMessenger = new Messenger((Handler)MediaBrowserServiceCompat.access$100(this$0));
        BundleCompat.putBinder(bundle, "extra_messenger", mMessenger.getBinder());
        bundle.putInt("extra_service_version", 1);
        mCallbacks.onConnect(s, token.getToken(), bundle);
    }
    
    @Override
    public void onConnectFailed() throws RemoteException {
        mCallbacks.onConnectFailed();
    }
    
    @Override
    public void onLoadChildren(final String s, final List<MediaBrowserCompat.MediaItem> list, final Bundle bundle) throws RemoteException {
        List<Parcel> list2 = null;
        if (list != null) {
            list2 = new ArrayList<Parcel>();
            for (final MediaBrowserCompat.MediaItem mediaItem : list) {
                final Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                list2.add(obtain);
            }
        }
        mCallbacks.onLoadChildren(s, list2);
    }
}
