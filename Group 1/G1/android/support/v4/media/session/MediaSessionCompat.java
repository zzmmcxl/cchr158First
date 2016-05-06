package android.support.v4.media.session;

import android.os.IBinder;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.Message;
import android.os.Looper;
import android.view.KeyEvent;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.graphics.Bitmap;
import android.os.RemoteCallbackList;
import android.media.AudioManager;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.os.ResultReceiver;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Handler;
import java.util.Iterator;
import android.os.Bundle;
import java.util.List;
import android.os.Build$VERSION;
import android.util.Log;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.text.TextUtils;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import java.util.ArrayList;

public class MediaSessionCompat
{
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final String TAG = "MediaSessionCompat";
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;
    
    private MediaSessionCompat(final Context context, final MediaSessionImpl mImpl) {
        super();
        mActiveListeners = new ArrayList<OnActiveChangeListener>();
        mImpl = mImpl;
        mController = new MediaControllerCompat(context, this);
    }
    
    public MediaSessionCompat(final Context context, final String s) {
        this(context, s, null, null);
    }
    
    public MediaSessionCompat(final Context context, final String s, ComponentName component, PendingIntent broadcast) {
        super();
        mActiveListeners = new ArrayList<OnActiveChangeListener>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (component == null) {
            final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setPackage(context.getPackageName());
            final List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers.size() == 1) {
                final ResolveInfo resolveInfo = (ResolveInfo)queryBroadcastReceivers.get(0);
                component = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            }
            else if (queryBroadcastReceivers.size() > 1) {
                Log.w("MediaSessionCompat", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, using null. Provide a specific ComponentName to use as this session's media button receiver");
            }
        }
        if (component != null && broadcast == null) {
            final Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent2.setComponent(component);
            broadcast = PendingIntent.getBroadcast(context, 0, intent2, 0);
        }
        if (Build$VERSION.SDK_INT >= 21) {
            (mImpl = (MediaSessionImpl)new MediaSessionImplApi21(context, s)).setMediaButtonReceiver(broadcast);
        }
        else {
            mImpl = (MediaSessionImpl)new MediaSessionImplBase(context, s, component, broadcast);
        }
        mController = new MediaControllerCompat(context, this);
    }
    
    public static MediaSessionCompat obtain(final Context context, final Object o) {
        return new MediaSessionCompat(context, (MediaSessionImpl)new MediaSessionImplApi21(o));
    }
    
    public void addOnActiveChangeListener(final OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        mActiveListeners.add(onActiveChangeListener);
    }
    
    public MediaControllerCompat getController() {
        return mController;
    }
    
    public Object getMediaSession() {
        return mImpl.getMediaSession();
    }
    
    public Object getRemoteControlClient() {
        return mImpl.getRemoteControlClient();
    }
    
    public Token getSessionToken() {
        return mImpl.getSessionToken();
    }
    
    public boolean isActive() {
        return mImpl.isActive();
    }
    
    public void release() {
        mImpl.release();
    }
    
    public void removeOnActiveChangeListener(final OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        mActiveListeners.remove(onActiveChangeListener);
    }
    
    public void sendSessionEvent(final String s, final Bundle bundle) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        mImpl.sendSessionEvent(s, bundle);
    }
    
    public void setActive(final boolean active) {
        mImpl.setActive(active);
        final Iterator<OnActiveChangeListener> iterator = mActiveListeners.iterator();
        while (iterator.hasNext()) {
            ((OnActiveChangeListener)iterator.next()).onActiveChanged();
        }
    }
    
    public void setCallback(final Callback callback) {
        this.setCallback(callback, null);
    }
    
    public void setCallback(final Callback callback, Handler handler) {
        final MediaSessionImpl mImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mImpl.setCallback(callback, handler);
    }
    
    public void setExtras(final Bundle extras) {
        mImpl.setExtras(extras);
    }
    
    public void setFlags(final int flags) {
        mImpl.setFlags(flags);
    }
    
    public void setMediaButtonReceiver(final PendingIntent mediaButtonReceiver) {
        mImpl.setMediaButtonReceiver(mediaButtonReceiver);
    }
    
    public void setMetadata(final MediaMetadataCompat metadata) {
        mImpl.setMetadata(metadata);
    }
    
    public void setPlaybackState(final PlaybackStateCompat playbackState) {
        mImpl.setPlaybackState(playbackState);
    }
    
    public void setPlaybackToLocal(final int playbackToLocal) {
        mImpl.setPlaybackToLocal(playbackToLocal);
    }
    
    public void setPlaybackToRemote(final VolumeProviderCompat playbackToRemote) {
        if (playbackToRemote == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        mImpl.setPlaybackToRemote(playbackToRemote);
    }
    
    public void setQueue(final List<QueueItem> queue) {
        mImpl.setQueue(queue);
    }
    
    public void setQueueTitle(final CharSequence queueTitle) {
        mImpl.setQueueTitle(queueTitle);
    }
    
    public void setRatingType(final int ratingType) {
        mImpl.setRatingType(ratingType);
    }
    
    public void setSessionActivity(final PendingIntent sessionActivity) {
        mImpl.setSessionActivity(sessionActivity);
    }
}
