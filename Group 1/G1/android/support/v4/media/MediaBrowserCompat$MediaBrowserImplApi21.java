package android.support.v4.media;

import java.util.ArrayList;
import android.os.Parcel;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import android.os.IBinder;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import android.os.Handler;
import android.util.Log;
import android.text.TextUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.content.ComponentName;
import android.os.Messenger;

static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallbackInternal
{
    private static final boolean DBG;
    protected Object mBrowserObj;
    private Messenger mCallbacksMessenger;
    private final CallbackHandler mHandler;
    private ServiceBinderWrapper mServiceBinderWrapper;
    private final ComponentName mServiceComponent;
    private final ArrayMap<String, Subscription> mSubscriptions;
    
    public MediaBrowserImplApi21(final Context context, final ComponentName mServiceComponent, final ConnectionCallback connectionCallback, final Bundle bundle) {
        super();
        this.mHandler = new CallbackHandler(this);
        this.mSubscriptions = new ArrayMap<String, Subscription>();
        this.mServiceComponent = mServiceComponent;
        connectionCallback.setInternalConnectionCallback((ConnectionCallback.ConnectionCallbackInternal)this);
        this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(context, mServiceComponent, connectionCallback.mConnectionCallbackObj, bundle);
    }
    
    @Override
    public void connect() {
        MediaBrowserCompatApi21.connect(mBrowserObj);
    }
    
    @Override
    public void disconnect() {
        MediaBrowserCompatApi21.disconnect(mBrowserObj);
    }
    
    @Nullable
    @Override
    public Bundle getExtras() {
        return MediaBrowserCompatApi21.getExtras(mBrowserObj);
    }
    
    @Override
    public void getItem(@NonNull final String s, @NonNull final ItemCallback itemCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("mediaId is empty.");
        }
        if (itemCallback == null) {
            throw new IllegalArgumentException("cb is null.");
        }
        if (!MediaBrowserCompatApi21.isConnected(mBrowserObj)) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            mHandler.post((Runnable)new Runnable() {
                final /* synthetic */ MediaBrowserImplApi21 this$0;
                final /* synthetic */ ItemCallback val$cb;
                final /* synthetic */ String val$mediaId;
                
                MediaBrowserCompat$MediaBrowserImplApi21$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void run() {
                    itemCallback.onError(s);
                }
            });
            return;
        }
        if (mServiceBinderWrapper == null) {
            mHandler.post((Runnable)new Runnable() {
                final /* synthetic */ MediaBrowserImplApi21 this$0;
                final /* synthetic */ ItemCallback val$cb;
                
                MediaBrowserCompat$MediaBrowserImplApi21$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void run() {
                    itemCallback.onItemLoaded(null);
                }
            });
            return;
        }
        final ItemReceiver itemReceiver = new ItemReceiver(s, itemCallback, mHandler);
        try {
            mServiceBinderWrapper.getMediaItem(s, itemReceiver);
        }
        catch (RemoteException ex) {
            Log.i("MediaBrowserCompat", "Remote error getting media item: " + s);
            mHandler.post((Runnable)new Runnable() {
                final /* synthetic */ MediaBrowserImplApi21 this$0;
                final /* synthetic */ ItemCallback val$cb;
                final /* synthetic */ String val$mediaId;
                
                MediaBrowserCompat$MediaBrowserImplApi21$3() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void run() {
                    itemCallback.onError(s);
                }
            });
        }
    }
    
    @NonNull
    @Override
    public String getRoot() {
        return MediaBrowserCompatApi21.getRoot(mBrowserObj);
    }
    
    @Override
    public ComponentName getServiceComponent() {
        return MediaBrowserCompatApi21.getServiceComponent(mBrowserObj);
    }
    
    @NonNull
    @Override
    public MediaSessionCompat.Token getSessionToken() {
        return MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(mBrowserObj));
    }
    
    @Override
    public boolean isConnected() {
        return MediaBrowserCompatApi21.isConnected(mBrowserObj);
    }
    
    @Override
    public void onConnected() {
        final Bundle extras = MediaBrowserCompatApi21.getExtras(mBrowserObj);
        if (extras != null) {
            final IBinder binder = BundleCompat.getBinder(extras, "extra_messenger");
            if (binder != null) {
                mServiceBinderWrapper = new ServiceBinderWrapper(binder);
                mCallbacksMessenger = new Messenger((Handler)mHandler);
                mHandler.setCallbacksMessenger(mCallbacksMessenger);
                while (true) {
                    try {
                        mServiceBinderWrapper.registerCallbackMessenger(mCallbacksMessenger);
                        this.onServiceConnected(mCallbacksMessenger, null, null, null);
                    }
                    catch (RemoteException ex) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public void onConnectionFailed() {
    }
    
    @Override
    public void onConnectionFailed(final Messenger messenger) {
    }
    
    @Override
    public void onConnectionSuspended() {
        mServiceBinderWrapper = null;
        mCallbacksMessenger = null;
    }
    
    @Override
    public void onLoadChildren(final Messenger messenger, final String s, final List list, @NonNull final Bundle bundle) {
        if (mCallbacksMessenger == messenger) {
            final Subscription subscription = (Subscription)mSubscriptions.get(s);
            if (subscription != null) {
                subscription.getCallback(bundle).onChildrenLoaded(s, list, bundle);
            }
        }
    }
    
    @Override
    public void onServiceConnected(final Messenger messenger, final String s, final MediaSessionCompat.Token token, final Bundle bundle) {
        for (final Map.Entry<String, Subscription> entry : mSubscriptions.entrySet()) {
            final String s2 = (String)entry.getKey();
            final Subscription subscription = (Subscription)entry.getValue();
            final List<Bundle> optionsList = subscription.getOptionsList();
            final List<SubscriptionCallback> callbacks = subscription.getCallbacks();
            for (int i = 0; i < optionsList.size(); ++i) {
                if (optionsList.get(i) == null) {
                    MediaBrowserCompatApi21.subscribe(mBrowserObj, s2, ((SubscriptionCallbackApi21)callbacks.get(i)).mSubscriptionCallbackObj);
                }
                else {
                    try {
                        mServiceBinderWrapper.addSubscription(s2, optionsList.get(i), mCallbacksMessenger);
                    }
                    catch (RemoteException ex) {
                        Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + s2);
                    }
                }
            }
        }
    }
    
    @Override
    public void subscribe(@NonNull final String s, final Bundle bundle, @NonNull final SubscriptionCallback subscriptionCallback) {
        final SubscriptionCallbackApi21 subscriptionCallbackApi21 = new SubscriptionCallbackApi21(subscriptionCallback, bundle);
        Subscription subscription = (Subscription)mSubscriptions.get(s);
        if (subscription == null) {
            subscription = new Subscription();
            mSubscriptions.put(s, subscription);
        }
        subscription.setCallbackForOptions(subscriptionCallbackApi21, bundle);
        if (MediaBrowserCompatApi21.isConnected(mBrowserObj)) {
            if (bundle == null || mServiceBinderWrapper == null) {
                MediaBrowserCompatApi21.subscribe(mBrowserObj, s, subscriptionCallbackApi21.mSubscriptionCallbackObj);
            }
            else {
                try {
                    mServiceBinderWrapper.addSubscription(s, bundle, mCallbacksMessenger);
                }
                catch (RemoteException ex) {
                    Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + s);
                }
            }
        }
    }
    
    @Override
    public void unsubscribe(@NonNull final String s, final Bundle bundle) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty.");
        }
        final Subscription subscription = (Subscription)mSubscriptions.get(s);
        if (subscription != null && subscription.remove(bundle)) {
            if (bundle == null || mServiceBinderWrapper == null) {
                if (mServiceBinderWrapper != null || subscription.isEmpty()) {
                    MediaBrowserCompatApi21.unsubscribe(mBrowserObj, s);
                }
            }
            else if (mServiceBinderWrapper == null) {
                try {
                    mServiceBinderWrapper.removeSubscription(s, bundle, mCallbacksMessenger);
                }
                catch (RemoteException ex) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + s);
                }
            }
        }
        if (subscription != null && subscription.isEmpty()) {
            mSubscriptions.remove(s);
        }
    }
}
