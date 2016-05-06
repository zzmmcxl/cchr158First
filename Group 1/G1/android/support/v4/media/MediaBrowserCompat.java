package android.support.v4.media;

import java.util.ArrayList;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.os.Parcelable$Creator;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.Iterator;
import java.util.Map;
import android.os.IBinder;
import android.support.v4.app.BundleCompat;
import android.os.RemoteException;
import android.text.TextUtils;
import android.support.v4.util.ArrayMap;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import android.os.Parcel;
import java.util.List;
import android.util.Log;
import android.os.Message;
import android.os.Messenger;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;

public final class MediaBrowserCompat
{
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;
    
    public MediaBrowserCompat(final Context context, final ComponentName componentName, final ConnectionCallback connectionCallback, final Bundle bundle) {
        super();
        if (Build$VERSION.SDK_INT >= 23) {
            mImpl = (MediaBrowserImpl)new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
            return;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            mImpl = (MediaBrowserImpl)new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
            return;
        }
        mImpl = (MediaBrowserImpl)new MediaBrowserServiceImplBase(context, componentName, connectionCallback, bundle);
    }
    
    public void connect() {
        mImpl.connect();
    }
    
    public void disconnect() {
        mImpl.disconnect();
    }
    
    @Nullable
    public Bundle getExtras() {
        return mImpl.getExtras();
    }
    
    public void getItem(@NonNull final String s, @NonNull final ItemCallback itemCallback) {
        mImpl.getItem(s, itemCallback);
    }
    
    @NonNull
    public String getRoot() {
        return mImpl.getRoot();
    }
    
    @NonNull
    public ComponentName getServiceComponent() {
        return mImpl.getServiceComponent();
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return mImpl.getSessionToken();
    }
    
    public boolean isConnected() {
        return mImpl.isConnected();
    }
    
    public void subscribe(@NonNull final String s, @NonNull final Bundle bundle, @NonNull final SubscriptionCallback subscriptionCallback) {
        if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        }
        mImpl.subscribe(s, bundle, subscriptionCallback);
    }
    
    public void subscribe(@NonNull final String s, @NonNull final SubscriptionCallback subscriptionCallback) {
        mImpl.subscribe(s, null, subscriptionCallback);
    }
    
    public void unsubscribe(@NonNull final String s) {
        mImpl.unsubscribe(s, null);
    }
    
    public void unsubscribe(@NonNull final String s, @NonNull final Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        }
        mImpl.unsubscribe(s, bundle);
    }
}
