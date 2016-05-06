package android.support.v4.media;

import android.text.TextUtils;
import android.os.Binder;
import java.util.Collection;
import android.os.Message;
import android.os.Parcel;
import android.support.v4.app.BundleCompat;
import android.os.Handler;
import android.os.Messenger;
import java.util.HashMap;
import android.os.Build$VERSION;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.support.v4.os.ResultReceiver;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.IBinder;
import android.support.v4.util.ArrayMap;
import android.app.Service;

public abstract class MediaBrowserServiceCompat extends Service
{
    private static final boolean DBG = false;
    public static final String KEY_MEDIA_ITEM = "media_item";
    private static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    private static final String TAG = "MediaBrowserServiceCompat";
    private final ArrayMap<IBinder, ConnectionRecord> mConnections;
    private final ServiceHandler mHandler;
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;
    
    public MediaBrowserServiceCompat() {
        super();
        mConnections = new ArrayMap<IBinder, ConnectionRecord>();
        mHandler = new ServiceHandler(this);
    }
    
    static /* synthetic */ ServiceHandler access$100(final MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        return mediaBrowserServiceCompat.mHandler;
    }
    
    static /* synthetic */ void access$1000(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final String s, final ConnectionRecord connectionRecord, final Bundle bundle) {
        mediaBrowserServiceCompat.performLoadChildren(s, connectionRecord, bundle);
    }
    
    static /* synthetic */ boolean access$400(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final String s, final int n) {
        return mediaBrowserServiceCompat.isValidPackage(s, n);
    }
    
    static /* synthetic */ ArrayMap access$500(final MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        return mediaBrowserServiceCompat.mConnections;
    }
    
    static /* synthetic */ void access$700(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final String s, final ConnectionRecord connectionRecord, final Bundle bundle) {
        mediaBrowserServiceCompat.addSubscription(s, connectionRecord, bundle);
    }
    
    static /* synthetic */ boolean access$800(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final String s, final ConnectionRecord connectionRecord, final Bundle bundle) {
        return mediaBrowserServiceCompat.removeSubscription(s, connectionRecord, bundle);
    }
    
    static /* synthetic */ void access$900(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final String s, final ResultReceiver resultReceiver) {
        mediaBrowserServiceCompat.performLoadItem(s, resultReceiver);
    }
    
    private void addSubscription(final String s, final ConnectionRecord connectionRecord, final Bundle bundle) {
        List<Bundle> list = (List<Bundle>)connectionRecord.subscriptions.get(s);
        if (list == null) {
            list = new ArrayList<Bundle>();
        }
        final Iterator<Bundle> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (MediaBrowserCompatUtils.areSameOptions(bundle, iterator.next())) {
                return;
            }
        }
        list.add(bundle);
        connectionRecord.subscriptions.put(s, list);
        this.performLoadChildren(s, connectionRecord, bundle);
    }
    
    private List<MediaBrowserCompat.MediaItem> applyOptions(final List<MediaBrowserCompat.MediaItem> list, final Bundle bundle) {
        final int int1 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        final int int2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (int1 == -1 && int2 == -1) {
            return list;
        }
        final int n = int2 * (int1 - 1);
        int size = n + int2;
        if (int1 < 1 || int2 < 1 || n >= list.size()) {
            return Collections.<MediaBrowserCompat.MediaItem>emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(n, size);
    }
    
    private boolean isValidPackage(final String s, final int n) {
        if (s != null) {
            final String[] packagesForUid = this.getPackageManager().getPackagesForUid(n);
            for (int length = packagesForUid.length, i = 0; i < length; ++i) {
                if (packagesForUid[i].equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void notifyChildrenChangedInternal(final String s, final Bundle bundle) {
        if (s == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        mHandler.post((Runnable)new Runnable() {
            final /* synthetic */ MediaBrowserServiceCompat this$0;
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;
            
            MediaBrowserServiceCompat$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                final Iterator<IBinder> iterator = mConnections.keySet().iterator();
                while (iterator.hasNext()) {
                    final ConnectionRecord connectionRecord = (ConnectionRecord)mConnections.get(iterator.next());
                    final List<Bundle> list = (List<Bundle>)connectionRecord.subscriptions.get(s);
                    if (list != null) {
                        for (final Bundle bundle : list) {
                            if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, bundle)) {
                                this$0.performLoadChildren(s, connectionRecord, bundle);
                                break;
                            }
                        }
                    }
                }
            }
        });
    }
    
    private void performLoadChildren(final String s, final ConnectionRecord connectionRecord, final Bundle bundle) {
        final Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(s) {
            final /* synthetic */ MediaBrowserServiceCompat this$0;
            final /* synthetic */ ConnectionRecord val$connection;
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;
            
            MediaBrowserServiceCompat$3(final Object o) {
                this$0 = this$0;
                super(o);
            }
            
            @Override
            /* bridge */ void onResultSent(final Object o, final int n) {
                this.onResultSent((List<MediaBrowserCompat.MediaItem>)o, n);
            }
            
            void onResultSent(final List<MediaBrowserCompat.MediaItem> list, final int n) {
                if (mConnections.get(connectionRecord.callbacks.asBinder()) != connectionRecord) {
                    return;
                }
                while (true) {
                    Label_0113: {
                        if ((n & 0x1) == 0x0) {
                            break Label_0113;
                        }
                        final List<MediaBrowserCompat.MediaItem> applyOptions = MediaBrowserCompatUtils.applyOptions(list, bundle);
                        try {
                            connectionRecord.callbacks.onLoadChildren(s, applyOptions, bundle);
                            return;
                        }
                        catch (RemoteException ex) {
                            Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + s + " package=" + connectionRecord.pkg);
                            return;
                        }
                    }
                    final List<MediaBrowserCompat.MediaItem> applyOptions = list;
                    continue;
                }
            }
        };
        if (bundle == null) {
            this.onLoadChildren(s, (Result<List<MediaBrowserCompat.MediaItem>>)result);
        }
        else {
            this.onLoadChildren(s, (Result<List<MediaBrowserCompat.MediaItem>>)result, bundle);
        }
        if (!((Result)result).isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + s);
        }
    }
    
    private void performLoadItem(final String s, final ResultReceiver resultReceiver) {
        final Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(s) {
            final /* synthetic */ MediaBrowserServiceCompat this$0;
            final /* synthetic */ ResultReceiver val$receiver;
            
            MediaBrowserServiceCompat$4(final Object o) {
                this$0 = this$0;
                super(o);
            }
            
            void onResultSent(final MediaBrowserCompat.MediaItem mediaItem, final int n) {
                final Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", (Parcelable)mediaItem);
                resultReceiver.send(0, bundle);
            }
            
            @Override
            /* bridge */ void onResultSent(final Object o, final int n) {
                this.onResultSent((MediaBrowserCompat.MediaItem)o, n);
            }
        };
        this.onLoadItem(s, (Result<MediaBrowserCompat.MediaItem>)result);
        if (!((Result)result).isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + s);
        }
    }
    
    private boolean removeSubscription(final String s, final ConnectionRecord connectionRecord, final Bundle bundle) {
        final List<Bundle> list = (List<Bundle>)connectionRecord.subscriptions.get(s);
        boolean b = false;
        if (list != null) {
            final Iterator<Bundle> iterator = list.iterator();
            while (true) {
                Bundle bundle2;
                do {
                    final boolean hasNext = iterator.hasNext();
                    b = false;
                    if (hasNext) {
                        bundle2 = iterator.next();
                    }
                    else {
                        if (list.size() == 0) {
                            connectionRecord.subscriptions.remove(s);
                            return b;
                        }
                        return b;
                    }
                } while (!MediaBrowserCompatUtils.areSameOptions(bundle, bundle2));
                b = true;
                list.remove(bundle2);
                continue;
            }
        }
        return b;
    }
    
    public void dump(final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return mSession;
    }
    
    public void notifyChildrenChanged(@NonNull final String s) {
        this.notifyChildrenChangedInternal(s, null);
    }
    
    public void notifyChildrenChanged(@NonNull final String s, @NonNull final Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.notifyChildrenChangedInternal(s, bundle);
    }
    
    public IBinder onBind(final Intent intent) {
        return mImpl.onBind(intent);
    }
    
    public void onCreate() {
        super.onCreate();
        if (Build$VERSION.SDK_INT >= 23) {
            mImpl = (MediaBrowserServiceImpl)new MediaBrowserServiceImplApi23();
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            mImpl = (MediaBrowserServiceImpl)new MediaBrowserServiceImplApi21();
        }
        else {
            mImpl = (MediaBrowserServiceImpl)new MediaBrowserServiceImplBase();
        }
        mImpl.onCreate();
    }
    
    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull final String p0, final int p1, @Nullable final Bundle p2);
    
    public abstract void onLoadChildren(@NonNull final String p0, @NonNull final Result<List<MediaBrowserCompat.MediaItem>> p1);
    
    public void onLoadChildren(@NonNull final String s, @NonNull final Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull final Bundle bundle) {
        result.setFlags(1);
        this.onLoadChildren(s, result);
    }
    
    public void onLoadItem(final String s, final Result<MediaBrowserCompat.MediaItem> result) {
        result.sendResult(null);
    }
    
    public void setSessionToken(final MediaSessionCompat.Token mSession) {
        if (mSession == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = mSession;
        mHandler.post((Runnable)new Runnable() {
            final /* synthetic */ MediaBrowserServiceCompat this$0;
            final /* synthetic */ MediaSessionCompat.Token val$token;
            
            MediaBrowserServiceCompat$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                for (final IBinder binder : mConnections.keySet()) {
                    final ConnectionRecord connectionRecord = (ConnectionRecord)mConnections.get(binder);
                    try {
                        connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), mSession, connectionRecord.root.getExtras());
                    }
                    catch (RemoteException ex) {
                        Log.w("MediaBrowserServiceCompat", "Connection for " + connectionRecord.pkg + " is no longer valid.");
                        mConnections.remove(binder);
                    }
                }
            }
        });
    }
}
