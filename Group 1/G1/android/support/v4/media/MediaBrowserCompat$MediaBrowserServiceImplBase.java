package android.support.v4.media;

import android.os.IBinder;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import android.support.v4.os.ResultReceiver;
import android.os.Handler;
import android.text.TextUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.RemoteException;
import android.content.Intent;
import android.util.Log;
import android.content.ServiceConnection;
import android.support.v4.util.ArrayMap;
import android.content.ComponentName;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.Bundle;
import android.content.Context;
import android.os.Messenger;

static class MediaBrowserServiceImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl
{
    private static final int CONNECT_STATE_CONNECTED = 2;
    private static final int CONNECT_STATE_CONNECTING = 1;
    private static final int CONNECT_STATE_DISCONNECTED = 0;
    private static final int CONNECT_STATE_SUSPENDED = 3;
    private static final boolean DBG;
    private final ConnectionCallback mCallback;
    private Messenger mCallbacksMessenger;
    private final Context mContext;
    private Bundle mExtras;
    private final CallbackHandler mHandler;
    private MediaSessionCompat.Token mMediaSessionToken;
    private final Bundle mRootHints;
    private String mRootId;
    private ServiceBinderWrapper mServiceBinderWrapper;
    private final ComponentName mServiceComponent;
    private MediaServiceConnection mServiceConnection;
    private int mState;
    private final ArrayMap<String, Subscription> mSubscriptions;
    
    public MediaBrowserServiceImplBase(final Context mContext, final ComponentName mServiceComponent, final ConnectionCallback mCallback, final Bundle mRootHints) {
        super();
        this.mHandler = new CallbackHandler(this);
        this.mSubscriptions = new ArrayMap<String, Subscription>();
        this.mState = 0;
        if (mContext == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (mServiceComponent == null) {
            throw new IllegalArgumentException("service component must not be null");
        }
        if (mCallback == null) {
            throw new IllegalArgumentException("connection callback must not be null");
        }
        this.mContext = mContext;
        this.mServiceComponent = mServiceComponent;
        this.mCallback = mCallback;
        this.mRootHints = mRootHints;
    }
    
    static /* synthetic */ ServiceBinderWrapper access$1100(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mServiceBinderWrapper;
    }
    
    static /* synthetic */ ServiceBinderWrapper access$1102(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase, final ServiceBinderWrapper mServiceBinderWrapper) {
        return mediaBrowserServiceImplBase.mServiceBinderWrapper = mServiceBinderWrapper;
    }
    
    static /* synthetic */ Messenger access$1200(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mCallbacksMessenger;
    }
    
    static /* synthetic */ Messenger access$1202(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase, final Messenger mCallbacksMessenger) {
        return mediaBrowserServiceImplBase.mCallbacksMessenger = mCallbacksMessenger;
    }
    
    static /* synthetic */ CallbackHandler access$1300(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mHandler;
    }
    
    static /* synthetic */ int access$1400(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mState;
    }
    
    static /* synthetic */ int access$1402(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase, final int mState) {
        return mediaBrowserServiceImplBase.mState = mState;
    }
    
    static /* synthetic */ Context access$1500(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mContext;
    }
    
    static /* synthetic */ Bundle access$1600(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mRootHints;
    }
    
    static /* synthetic */ ComponentName access$1700(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mServiceComponent;
    }
    
    static /* synthetic */ MediaServiceConnection access$700(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mServiceConnection;
    }
    
    static /* synthetic */ void access$800(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        mediaBrowserServiceImplBase.forceCloseConnection();
    }
    
    static /* synthetic */ ConnectionCallback access$900(final MediaBrowserServiceImplBase mediaBrowserServiceImplBase) {
        return mediaBrowserServiceImplBase.mCallback;
    }
    
    private void forceCloseConnection() {
        if (mServiceConnection != null) {
            mContext.unbindService((ServiceConnection)mServiceConnection);
        }
        mState = 0;
        mServiceConnection = null;
        mServiceBinderWrapper = null;
        mCallbacksMessenger = null;
        mRootId = null;
        mMediaSessionToken = null;
    }
    
    private static String getStateLabel(final int n) {
        switch (n) {
            default:
                return "UNKNOWN/" + n;
            case 0:
                return "CONNECT_STATE_DISCONNECTED";
            case 1:
                return "CONNECT_STATE_CONNECTING";
            case 2:
                return "CONNECT_STATE_CONNECTED";
            case 3:
                return "CONNECT_STATE_SUSPENDED";
        }
    }
    
    private boolean isCurrent(final Messenger messenger, final String s) {
        if (mCallbacksMessenger != messenger) {
            if (mState != 0) {
                Log.i("MediaBrowserCompat", s + " for " + mServiceComponent + " with mCallbacksMessenger=" + mCallbacksMessenger + " this=" + this);
            }
            return false;
        }
        return true;
    }
    
    @Override
    public void connect() {
        if (mState != 0) {
            throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(mState) + ")");
        }
        if (mServiceBinderWrapper != null) {
            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + mServiceBinderWrapper);
        }
        if (mCallbacksMessenger != null) {
            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + mCallbacksMessenger);
        }
        mState = 1;
        final Intent intent = new Intent("android.media.browse.MediaBrowserService");
        intent.setComponent(mServiceComponent);
        final MediaServiceConnection mServiceConnection = new MediaServiceConnection(this);
        this.mServiceConnection = mServiceConnection;
        while (true) {
            try {
                final int bindService = mContext.bindService(intent, (ServiceConnection)this.mServiceConnection, 1) ? 1 : 0;
                if (bindService == 0) {
                    mHandler.post((Runnable)new Runnable() {
                        final /* synthetic */ MediaBrowserServiceImplBase this$0;
                        final /* synthetic */ ServiceConnection val$thisConnection;
                        
                        MediaBrowserCompat$MediaBrowserServiceImplBase$1() {
                            this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public void run() {
                            if (mServiceConnection == mServiceConnection) {
                                this$0.forceCloseConnection();
                                mCallback.onConnectionFailed();
                            }
                        }
                    });
                }
            }
            catch (Exception ex) {
                Log.e("MediaBrowserCompat", "Failed binding to service " + mServiceComponent);
                final int bindService = 0;
                continue;
            }
            break;
        }
    }
    
    @Override
    public void disconnect() {
        while (true) {
            if (mCallbacksMessenger == null) {
                break Label_0018;
            }
            try {
                mServiceBinderWrapper.disconnect(mCallbacksMessenger);
                this.forceCloseConnection();
            }
            catch (RemoteException ex) {
                Log.w("MediaBrowserCompat", "RemoteException during connect for " + mServiceComponent);
                continue;
            }
            break;
        }
    }
    
    void dump() {
        Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
        Log.d("MediaBrowserCompat", "  mServiceComponent=" + mServiceComponent);
        Log.d("MediaBrowserCompat", "  mCallback=" + mCallback);
        Log.d("MediaBrowserCompat", "  mRootHints=" + mRootHints);
        Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(mState));
        Log.d("MediaBrowserCompat", "  mServiceConnection=" + mServiceConnection);
        Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + mServiceBinderWrapper);
        Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + mCallbacksMessenger);
        Log.d("MediaBrowserCompat", "  mRootId=" + mRootId);
        Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + mMediaSessionToken);
    }
    
    @Nullable
    @Override
    public Bundle getExtras() {
        if (!this.isConnected()) {
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(mState) + ")");
        }
        return mExtras;
    }
    
    @Override
    public void getItem(@NonNull final String s, @NonNull final ItemCallback itemCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("mediaId is empty.");
        }
        if (itemCallback == null) {
            throw new IllegalArgumentException("cb is null.");
        }
        if (mState != 2) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            mHandler.post((Runnable)new Runnable() {
                final /* synthetic */ MediaBrowserServiceImplBase this$0;
                final /* synthetic */ ItemCallback val$cb;
                final /* synthetic */ String val$mediaId;
                
                MediaBrowserCompat$MediaBrowserServiceImplBase$2() {
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
        final ItemReceiver itemReceiver = new ItemReceiver(s, itemCallback, mHandler);
        try {
            mServiceBinderWrapper.getMediaItem(s, itemReceiver);
        }
        catch (RemoteException ex) {
            Log.i("MediaBrowserCompat", "Remote error getting media item.");
            mHandler.post((Runnable)new Runnable() {
                final /* synthetic */ MediaBrowserServiceImplBase this$0;
                final /* synthetic */ ItemCallback val$cb;
                final /* synthetic */ String val$mediaId;
                
                MediaBrowserCompat$MediaBrowserServiceImplBase$3() {
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
        if (!this.isConnected()) {
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(mState) + ")");
        }
        return mRootId;
    }
    
    @NonNull
    @Override
    public ComponentName getServiceComponent() {
        if (!this.isConnected()) {
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + mState + ")");
        }
        return mServiceComponent;
    }
    
    @NonNull
    @Override
    public MediaSessionCompat.Token getSessionToken() {
        if (!this.isConnected()) {
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + mState + ")");
        }
        return mMediaSessionToken;
    }
    
    @Override
    public boolean isConnected() {
        return mState == 2;
    }
    
    @Override
    public void onConnectionFailed(final Messenger messenger) {
        Log.e("MediaBrowserCompat", "onConnectFailed for " + mServiceComponent);
        if (!this.isCurrent(messenger, "onConnectFailed")) {
            return;
        }
        if (mState != 1) {
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(mState) + "... ignoring");
            return;
        }
        this.forceCloseConnection();
        mCallback.onConnectionFailed();
    }
    
    @Override
    public void onLoadChildren(final Messenger messenger, final String s, final List list, final Bundle bundle) {
        if (this.isCurrent(messenger, "onLoadChildren")) {
            final Subscription subscription = (Subscription)mSubscriptions.get(s);
            if (subscription != null) {
                final SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        callback.onChildrenLoaded(s, list);
                        return;
                    }
                    callback.onChildrenLoaded(s, list, bundle);
                }
            }
        }
    }
    
    @Override
    public void onServiceConnected(final Messenger messenger, final String mRootId, final MediaSessionCompat.Token mMediaSessionToken, final Bundle mExtras) {
        if (this.isCurrent(messenger, "onConnect")) {
            if (mState != 1) {
                Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(mState) + "... ignoring");
                return;
            }
            this.mRootId = mRootId;
            this.mMediaSessionToken = mMediaSessionToken;
            this.mExtras = mExtras;
            mState = 2;
            mCallback.onConnected();
            try {
                for (final Map.Entry<String, Subscription> entry : mSubscriptions.entrySet()) {
                    final String s = (String)entry.getKey();
                    final Iterator<Bundle> iterator2 = ((Subscription)entry.getValue()).getOptionsList().iterator();
                    while (iterator2.hasNext()) {
                        mServiceBinderWrapper.addSubscription(s, iterator2.next(), mCallbacksMessenger);
                    }
                }
            }
            catch (RemoteException ex) {
                Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
            }
        }
    }
    
    @Override
    public void subscribe(@NonNull final String s, final Bundle bundle, @NonNull final SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty.");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        Subscription subscription = (Subscription)mSubscriptions.get(s);
        if (subscription == null) {
            subscription = new Subscription();
            mSubscriptions.put(s, subscription);
        }
        subscription.setCallbackForOptions(subscriptionCallback, bundle);
        if (mState != 2) {
            return;
        }
        try {
            mServiceBinderWrapper.addSubscription(s, bundle, mCallbacksMessenger);
        }
        catch (RemoteException ex) {
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + s);
        }
    }
    
    @Override
    public void unsubscribe(@NonNull final String s, final Bundle bundle) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty.");
        }
        final Subscription subscription = (Subscription)mSubscriptions.get(s);
        while (true) {
            if (subscription == null || !subscription.remove(bundle) || mState != 2) {
                break Label_0063;
            }
            try {
                mServiceBinderWrapper.removeSubscription(s, bundle, mCallbacksMessenger);
                if (subscription != null && subscription.isEmpty()) {
                    mSubscriptions.remove(s);
                }
            }
            catch (RemoteException ex) {
                Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + s);
                continue;
            }
            break;
        }
    }
}
