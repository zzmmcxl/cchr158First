package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.content.Intent;
import android.os.Message;
import android.os.Looper;
import android.view.KeyEvent;
import android.os.IInterface;
import android.net.Uri;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.graphics.Bitmap;
import android.os.Build$VERSION;
import android.support.v4.media.VolumeProviderCompat;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.content.Context;
import android.content.ComponentName;
import android.media.AudioManager;

static class MediaSessionImplBase implements MediaSessionImpl
{
    private final AudioManager mAudioManager;
    private volatile Callback mCallback;
    private final ComponentName mComponentName;
    private final Context mContext;
    private final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
    private boolean mDestroyed;
    private Bundle mExtras;
    private int mFlags;
    private MessageHandler mHandler;
    private boolean mIsActive;
    private boolean mIsMbrRegistered;
    private boolean mIsRccRegistered;
    private int mLocalStream;
    private final Object mLock;
    private final PendingIntent mMediaButtonEventReceiver;
    private MediaMetadataCompat mMetadata;
    private final String mPackageName;
    private List<QueueItem> mQueue;
    private CharSequence mQueueTitle;
    private int mRatingType;
    private final Object mRccObj;
    private PendingIntent mSessionActivity;
    private PlaybackStateCompat mState;
    private final MediaSessionStub mStub;
    private final String mTag;
    private final Token mToken;
    private VolumeProviderCompat.Callback mVolumeCallback;
    private VolumeProviderCompat mVolumeProvider;
    private int mVolumeType;
    
    public MediaSessionImplBase(final Context mContext, final String mTag, final ComponentName mComponentName, final PendingIntent mMediaButtonEventReceiver) {
        super();
        this.mLock = new Object();
        this.mControllerCallbacks = (RemoteCallbackList<IMediaControllerCallback>)new RemoteCallbackList();
        this.mDestroyed = false;
        this.mIsActive = false;
        this.mIsRccRegistered = false;
        this.mIsMbrRegistered = false;
        this.mVolumeCallback = new VolumeProviderCompat.Callback() {
            final /* synthetic */ MediaSessionImplBase this$0;
            
            MediaSessionCompat$MediaSessionImplBase$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onVolumeChanged(final VolumeProviderCompat volumeProviderCompat) {
                if (mVolumeProvider != volumeProviderCompat) {
                    return;
                }
                this$0.sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
            }
        };
        if (mComponentName == null) {
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }
        this.mContext = mContext;
        this.mPackageName = mContext.getPackageName();
        this.mAudioManager = (AudioManager)mContext.getSystemService("audio");
        this.mTag = mTag;
        this.mComponentName = mComponentName;
        this.mMediaButtonEventReceiver = mMediaButtonEventReceiver;
        this.mStub = new MediaSessionStub();
        this.mToken = new Token(this.mStub);
        this.mRatingType = 0;
        this.mVolumeType = 1;
        this.mLocalStream = 3;
        if (Build$VERSION.SDK_INT >= 14) {
            this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(mMediaButtonEventReceiver);
            return;
        }
        this.mRccObj = null;
    }
    
    static /* synthetic */ boolean access$1000(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mDestroyed;
    }
    
    static /* synthetic */ RemoteCallbackList access$1100(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mControllerCallbacks;
    }
    
    static /* synthetic */ String access$1200(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mPackageName;
    }
    
    static /* synthetic */ String access$1300(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mTag;
    }
    
    static /* synthetic */ Object access$1400(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mLock;
    }
    
    static /* synthetic */ PendingIntent access$1500(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mSessionActivity;
    }
    
    static /* synthetic */ AudioManager access$1600(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mAudioManager;
    }
    
    static /* synthetic */ void access$1700(final MediaSessionImplBase mediaSessionImplBase, final int n, final int n2) {
        mediaSessionImplBase.adjustVolume(n, n2);
    }
    
    static /* synthetic */ void access$1800(final MediaSessionImplBase mediaSessionImplBase, final int n, final int n2) {
        mediaSessionImplBase.setVolumeTo(n, n2);
    }
    
    static /* synthetic */ void access$1900(final MediaSessionImplBase mediaSessionImplBase, final int n) {
        mediaSessionImplBase.postToHandler(n);
    }
    
    static /* synthetic */ void access$2000(final MediaSessionImplBase mediaSessionImplBase, final int n, final Object o, final Bundle bundle) {
        mediaSessionImplBase.postToHandler(n, o, bundle);
    }
    
    static /* synthetic */ MediaMetadataCompat access$2100(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mMetadata;
    }
    
    static /* synthetic */ PlaybackStateCompat access$2200(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.getStateWithUpdatedPosition();
    }
    
    static /* synthetic */ List access$2300(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mQueue;
    }
    
    static /* synthetic */ CharSequence access$2400(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mQueueTitle;
    }
    
    static /* synthetic */ Bundle access$2500(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mExtras;
    }
    
    static /* synthetic */ int access$2600(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mRatingType;
    }
    
    static /* synthetic */ Callback access$2700(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mCallback;
    }
    
    static /* synthetic */ PlaybackStateCompat access$2800(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mState;
    }
    
    static /* synthetic */ VolumeProviderCompat access$300(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mVolumeProvider;
    }
    
    static /* synthetic */ int access$400(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mVolumeType;
    }
    
    static /* synthetic */ int access$500(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mLocalStream;
    }
    
    static /* synthetic */ void access$600(final MediaSessionImplBase mediaSessionImplBase, final ParcelableVolumeInfo parcelableVolumeInfo) {
        mediaSessionImplBase.sendVolumeInfoChanged(parcelableVolumeInfo);
    }
    
    static /* synthetic */ void access$700(final MediaSessionImplBase mediaSessionImplBase, final int n, final Object o) {
        mediaSessionImplBase.postToHandler(n, o);
    }
    
    static /* synthetic */ int access$900(final MediaSessionImplBase mediaSessionImplBase) {
        return mediaSessionImplBase.mFlags;
    }
    
    private void adjustVolume(final int n, final int n2) {
        if (mVolumeType == 2) {
            if (mVolumeProvider != null) {
                mVolumeProvider.onAdjustVolume(n);
            }
            return;
        }
        mAudioManager.adjustStreamVolume(mLocalStream, n, n2);
    }
    
    private MediaMetadataCompat cloneMetadataIfNeeded(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            mediaMetadataCompat = null;
        }
        else if (mediaMetadataCompat.containsKey("android.media.metadata.ART") || mediaMetadataCompat.containsKey("android.media.metadata.ALBUM_ART")) {
            final MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder(mediaMetadataCompat);
            final Bitmap bitmap = mediaMetadataCompat.getBitmap("android.media.metadata.ART");
            if (bitmap != null) {
                builder.putBitmap("android.media.metadata.ART", bitmap.copy(bitmap.getConfig(), false));
            }
            final Bitmap bitmap2 = mediaMetadataCompat.getBitmap("android.media.metadata.ALBUM_ART");
            if (bitmap2 != null) {
                builder.putBitmap("android.media.metadata.ALBUM_ART", bitmap2.copy(bitmap2.getConfig(), false));
            }
            return builder.build();
        }
        return mediaMetadataCompat;
    }
    
    private PlaybackStateCompat getStateWithUpdatedPosition() {
        PlaybackStateCompat build;
        while (true) {
            long long1 = -1L;
            while (true) {
                long n2 = 0L;
                Label_0208: {
                    synchronized (mLock) {
                        final PlaybackStateCompat mState = this.mState;
                        if (mMetadata != null && mMetadata.containsKey("android.media.metadata.DURATION")) {
                            long1 = mMetadata.getLong("android.media.metadata.DURATION");
                        }
                        // monitorexit(this.mLock)
                        build = null;
                        Label_0193: {
                            if (mState != null) {
                                if (mState.getState() != 3 && mState.getState() != 4) {
                                    final int state = mState.getState();
                                    build = null;
                                    if (state != 5) {
                                        break Label_0193;
                                    }
                                }
                                final long lastPositionUpdateTime = mState.getLastPositionUpdateTime();
                                final long elapsedRealtime = SystemClock.elapsedRealtime();
                                final long n = lcmp(lastPositionUpdateTime, 0L);
                                build = null;
                                if (n > 0) {
                                    n2 = (long)(mState.getPlaybackSpeed() * (elapsedRealtime - lastPositionUpdateTime)) + mState.getPosition();
                                    if (long1 < 0L || n2 <= long1) {
                                        break Label_0208;
                                    }
                                    n2 = long1;
                                    final PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder(mState);
                                    builder.setState(mState.getState(), n2, mState.getPlaybackSpeed(), elapsedRealtime);
                                    build = builder.build();
                                }
                            }
                        }
                        if (build == null) {
                            return mState;
                        }
                        break;
                    }
                }
                if (n2 < 0L) {
                    n2 = 0L;
                    continue;
                }
                continue;
            }
        }
        return build;
    }
    
    private void postToHandler(final int n) {
        this.postToHandler(n, null);
    }
    
    private void postToHandler(final int n, final Object o) {
        this.postToHandler(n, o, null);
    }
    
    private void postToHandler(final int n, final Object o, final Bundle bundle) {
        synchronized (mLock) {
            if (mHandler != null) {
                mHandler.post(n, o, bundle);
            }
        }
    }
    
    private void sendEvent(final String s, final Bundle bundle) {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0036_Outer:
        while (true) {
            Label_0042: {
                if (n < 0) {
                    break Label_0042;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onEvent(s, bundle);
                        --n;
                        continue Label_0036_Outer;
                        mControllerCallbacks.finishBroadcast();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendMetadata(final MediaMetadataCompat mediaMetadataCompat) {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0033_Outer:
        while (true) {
            Label_0039: {
                if (n < 0) {
                    break Label_0039;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onMetadataChanged(mediaMetadataCompat);
                        --n;
                        continue Label_0033_Outer;
                        mControllerCallbacks.finishBroadcast();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendQueue(final List<QueueItem> list) {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0033_Outer:
        while (true) {
            Label_0039: {
                if (n < 0) {
                    break Label_0039;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onQueueChanged(list);
                        --n;
                        continue Label_0033_Outer;
                        mControllerCallbacks.finishBroadcast();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendQueueTitle(final CharSequence charSequence) {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0033_Outer:
        while (true) {
            Label_0039: {
                if (n < 0) {
                    break Label_0039;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onQueueTitleChanged(charSequence);
                        --n;
                        continue Label_0033_Outer;
                        mControllerCallbacks.finishBroadcast();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendSessionDestroyed() {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0032_Outer:
        while (true) {
            Label_0038: {
                if (n < 0) {
                    break Label_0038;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onSessionDestroyed();
                        --n;
                        continue Label_0032_Outer;
                        mControllerCallbacks.finishBroadcast();
                        mControllerCallbacks.kill();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendState(final PlaybackStateCompat playbackStateCompat) {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0033_Outer:
        while (true) {
            Label_0039: {
                if (n < 0) {
                    break Label_0039;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onPlaybackStateChanged(playbackStateCompat);
                        --n;
                        continue Label_0033_Outer;
                        mControllerCallbacks.finishBroadcast();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) {
        int n = -1 + mControllerCallbacks.beginBroadcast();
    Label_0033_Outer:
        while (true) {
            Label_0039: {
                if (n < 0) {
                    break Label_0039;
                }
                final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(n);
                while (true) {
                    try {
                        mediaControllerCallback.onVolumeInfoChanged(parcelableVolumeInfo);
                        --n;
                        continue Label_0033_Outer;
                        mControllerCallbacks.finishBroadcast();
                    }
                    catch (RemoteException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void setVolumeTo(final int n, final int n2) {
        if (mVolumeType == 2) {
            if (mVolumeProvider != null) {
                mVolumeProvider.onSetVolumeTo(n);
            }
            return;
        }
        mAudioManager.setStreamVolume(mLocalStream, n, n2);
    }
    
    private boolean update() {
        boolean b;
        if (mIsActive) {
            if (Build$VERSION.SDK_INT >= 8) {
                if (!mIsMbrRegistered && (0x1 & mFlags) != 0x0) {
                    if (Build$VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.registerMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver, mComponentName);
                    }
                    else {
                        MediaSessionCompatApi8.registerMediaButtonEventReceiver(mContext, mComponentName);
                    }
                    mIsMbrRegistered = true;
                }
                else if (mIsMbrRegistered && (0x1 & mFlags) == 0x0) {
                    if (Build$VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver, mComponentName);
                    }
                    else {
                        MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(mContext, mComponentName);
                    }
                    mIsMbrRegistered = false;
                }
            }
            final int sdk_INT = Build$VERSION.SDK_INT;
            b = false;
            if (sdk_INT >= 14) {
                if (!mIsRccRegistered && (0x2 & mFlags) != 0x0) {
                    MediaSessionCompatApi14.registerRemoteControlClient(mContext, mRccObj);
                    mIsRccRegistered = true;
                    b = true;
                }
                else {
                    final boolean mIsRccRegistered = this.mIsRccRegistered;
                    b = false;
                    if (mIsRccRegistered) {
                        final int n = 0x2 & mFlags;
                        b = false;
                        if (n == 0) {
                            MediaSessionCompatApi14.setState(mRccObj, 0);
                            MediaSessionCompatApi14.unregisterRemoteControlClient(mContext, mRccObj);
                            return this.mIsRccRegistered = false;
                        }
                    }
                }
            }
        }
        else {
            if (mIsMbrRegistered) {
                if (Build$VERSION.SDK_INT >= 18) {
                    MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver, mComponentName);
                }
                else {
                    MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(mContext, mComponentName);
                }
                mIsMbrRegistered = false;
            }
            final boolean mIsRccRegistered2 = mIsRccRegistered;
            b = false;
            if (mIsRccRegistered2) {
                MediaSessionCompatApi14.setState(mRccObj, 0);
                MediaSessionCompatApi14.unregisterRemoteControlClient(mContext, mRccObj);
                return mIsRccRegistered = false;
            }
        }
        return b;
    }
    
    @Override
    public Object getMediaSession() {
        return null;
    }
    
    @Override
    public Object getRemoteControlClient() {
        return mRccObj;
    }
    
    @Override
    public Token getSessionToken() {
        return mToken;
    }
    
    @Override
    public boolean isActive() {
        return mIsActive;
    }
    
    @Override
    public void release() {
        mIsActive = false;
        mDestroyed = true;
        this.update();
        this.sendSessionDestroyed();
    }
    
    @Override
    public void sendSessionEvent(final String s, final Bundle bundle) {
        this.sendEvent(s, bundle);
    }
    
    @Override
    public void setActive(final boolean mIsActive) {
        if (mIsActive != this.mIsActive) {
            this.mIsActive = mIsActive;
            if (this.update()) {
                this.setMetadata(mMetadata);
                this.setPlaybackState(mState);
            }
        }
    }
    
    @Override
    public void setCallback(final Callback mCallback, Handler handler) {
        this.mCallback = mCallback;
        if (mCallback == null) {
            if (Build$VERSION.SDK_INT >= 18) {
                MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(mRccObj, null);
            }
            if (Build$VERSION.SDK_INT >= 19) {
                MediaSessionCompatApi19.setOnMetadataUpdateListener(mRccObj, null);
            }
        }
        else {
            if (handler == null) {
                handler = new Handler();
            }
            synchronized (mLock) {
                mHandler = new MessageHandler(handler.getLooper());
                // monitorexit(this.mLock)
                final MediaSessionCompatApi19.Callback callback = new MediaSessionCompatApi19.Callback() {
                    final /* synthetic */ MediaSessionImplBase this$0;
                    
                    MediaSessionCompat$MediaSessionImplBase$2() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void onSeekTo(final long n) {
                        this$0.postToHandler(11, n);
                    }
                    
                    @Override
                    public void onSetRating(final Object o) {
                        this$0.postToHandler(12, RatingCompat.fromRating(o));
                    }
                };
                if (Build$VERSION.SDK_INT >= 18) {
                    MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(mRccObj, MediaSessionCompatApi18.createPlaybackPositionUpdateListener((MediaSessionCompatApi18.Callback)callback));
                }
                if (Build$VERSION.SDK_INT >= 19) {
                    MediaSessionCompatApi19.setOnMetadataUpdateListener(mRccObj, MediaSessionCompatApi19.createMetadataUpdateListener((MediaSessionCompatApi19.Callback)callback));
                }
            }
        }
    }
    
    @Override
    public void setExtras(final Bundle mExtras) {
        this.mExtras = mExtras;
    }
    
    @Override
    public void setFlags(final int mFlags) {
        synchronized (mLock) {
            this.mFlags = mFlags;
            // monitorexit(this.mLock)
            this.update();
        }
    }
    
    @Override
    public void setMediaButtonReceiver(final PendingIntent pendingIntent) {
    }
    
    @Override
    public void setMetadata(MediaMetadataCompat cloneMetadataIfNeeded) {
        if (Build$VERSION.SDK_INT >= 14 && cloneMetadataIfNeeded != null) {
            cloneMetadataIfNeeded = this.cloneMetadataIfNeeded(cloneMetadataIfNeeded);
        }
        while (true) {
            synchronized (mLock) {
                mMetadata = cloneMetadataIfNeeded;
                // monitorexit(this.mLock)
                this.sendMetadata(cloneMetadataIfNeeded);
                if (!mIsActive) {
                    return;
                }
            }
            if (Build$VERSION.SDK_INT >= 19) {
                final Object mRccObj = this.mRccObj;
                Bundle bundle = null;
                if (cloneMetadataIfNeeded != null) {
                    bundle = cloneMetadataIfNeeded.getBundle();
                }
                long actions;
                if (mState == null) {
                    actions = 0L;
                }
                else {
                    actions = mState.getActions();
                }
                MediaSessionCompatApi19.setMetadata(mRccObj, bundle, actions);
                return;
            }
            if (Build$VERSION.SDK_INT >= 14) {
                final Object mRccObj2 = mRccObj;
                Bundle bundle2 = null;
                if (cloneMetadataIfNeeded != null) {
                    bundle2 = cloneMetadataIfNeeded.getBundle();
                }
                MediaSessionCompatApi14.setMetadata(mRccObj2, bundle2);
            }
        }
    }
    
    @Override
    public void setPlaybackState(final PlaybackStateCompat mState) {
        while (true) {
            synchronized (mLock) {
                this.mState = mState;
                // monitorexit(this.mLock)
                this.sendState(mState);
                if (!mIsActive) {
                    return;
                }
            }
            if (mState == null) {
                if (Build$VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setState(mRccObj, 0);
                    MediaSessionCompatApi14.setTransportControlFlags(mRccObj, 0L);
                }
            }
            else {
                if (Build$VERSION.SDK_INT >= 18) {
                    MediaSessionCompatApi18.setState(mRccObj, mState.getState(), mState.getPosition(), mState.getPlaybackSpeed(), mState.getLastPositionUpdateTime());
                }
                else if (Build$VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setState(mRccObj, mState.getState());
                }
                if (Build$VERSION.SDK_INT >= 19) {
                    MediaSessionCompatApi19.setTransportControlFlags(mRccObj, mState.getActions());
                    return;
                }
                if (Build$VERSION.SDK_INT >= 18) {
                    MediaSessionCompatApi18.setTransportControlFlags(mRccObj, mState.getActions());
                    return;
                }
                if (Build$VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setTransportControlFlags(mRccObj, mState.getActions());
                }
            }
        }
    }
    
    @Override
    public void setPlaybackToLocal(final int n) {
        if (mVolumeProvider != null) {
            mVolumeProvider.setCallback(null);
        }
        mVolumeType = 1;
        this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, 2, mAudioManager.getStreamMaxVolume(mLocalStream), mAudioManager.getStreamVolume(mLocalStream)));
    }
    
    @Override
    public void setPlaybackToRemote(final VolumeProviderCompat mVolumeProvider) {
        if (mVolumeProvider == null) {
            throw new IllegalArgumentException("volumeProvider may not be null");
        }
        if (this.mVolumeProvider != null) {
            this.mVolumeProvider.setCallback(null);
        }
        mVolumeType = 2;
        this.mVolumeProvider = mVolumeProvider;
        this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
        mVolumeProvider.setCallback(mVolumeCallback);
    }
    
    @Override
    public void setQueue(final List<QueueItem> mQueue) {
        this.sendQueue(this.mQueue = mQueue);
    }
    
    @Override
    public void setQueueTitle(final CharSequence mQueueTitle) {
        this.sendQueueTitle(this.mQueueTitle = mQueueTitle);
    }
    
    @Override
    public void setRatingType(final int mRatingType) {
        this.mRatingType = mRatingType;
    }
    
    @Override
    public void setSessionActivity(final PendingIntent mSessionActivity) {
        synchronized (mLock) {
            this.mSessionActivity = mSessionActivity;
        }
    }
}
