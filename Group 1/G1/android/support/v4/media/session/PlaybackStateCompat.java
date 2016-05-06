package android.support.v4.media.session;

import android.os.SystemClock;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.annotation.Nullable;
import java.util.Iterator;
import android.os.Build$VERSION;
import android.text.TextUtils;
import java.util.Collection;
import java.util.ArrayList;
import android.os.Parcel;
import android.os.Bundle;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class PlaybackStateCompat implements Parcelable
{
    public static final long ACTION_FAST_FORWARD = 64L;
    public static final long ACTION_PAUSE = 2L;
    public static final long ACTION_PLAY = 4L;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
    public static final long ACTION_PLAY_FROM_URI = 8192L;
    public static final long ACTION_PLAY_PAUSE = 512L;
    public static final long ACTION_REWIND = 8L;
    public static final long ACTION_SEEK_TO = 256L;
    public static final long ACTION_SET_RATING = 128L;
    public static final long ACTION_SKIP_TO_NEXT = 32L;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L;
    public static final long ACTION_STOP = 1L;
    public static final Parcelable$Creator<PlaybackStateCompat> CREATOR;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    private final long mActions;
    private final long mActiveItemId;
    private final long mBufferedPosition;
    private List<CustomAction> mCustomActions;
    private final CharSequence mErrorMessage;
    private final Bundle mExtras;
    private final long mPosition;
    private final float mSpeed;
    private final int mState;
    private Object mStateObj;
    private final long mUpdateTime;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PlaybackStateCompat>() {
            PlaybackStateCompat$1() {
                super();
            }
            
            public PlaybackStateCompat createFromParcel(final Parcel parcel) {
                return new PlaybackStateCompat(parcel, null);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public PlaybackStateCompat[] newArray(final int n) {
                return new PlaybackStateCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private PlaybackStateCompat(final int mState, final long mPosition, final long mBufferedPosition, final float mSpeed, final long mActions, final CharSequence mErrorMessage, final long mUpdateTime, final List<CustomAction> list, final long mActiveItemId, final Bundle mExtras) {
        super();
        mState = mState;
        mPosition = mPosition;
        mBufferedPosition = mBufferedPosition;
        mSpeed = mSpeed;
        mActions = mActions;
        mErrorMessage = mErrorMessage;
        mUpdateTime = mUpdateTime;
        mCustomActions = new ArrayList<CustomAction>(list);
        mActiveItemId = mActiveItemId;
        mExtras = mExtras;
    }
    
    PlaybackStateCompat(final int n, final long n2, final long n3, final float n4, final long n5, final CharSequence charSequence, final long n6, final List list, final long n7, final Bundle bundle, final PlaybackStateCompat$1 parcelable$Creator) {
        this(n, n2, n3, n4, n5, charSequence, n6, list, n7, bundle);
    }
    
    private PlaybackStateCompat(final Parcel parcel) {
        super();
        mState = parcel.readInt();
        mPosition = parcel.readLong();
        mSpeed = parcel.readFloat();
        mUpdateTime = parcel.readLong();
        mBufferedPosition = parcel.readLong();
        mActions = parcel.readLong();
        mErrorMessage = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mCustomActions = (List<CustomAction>)parcel.createTypedArrayList((Parcelable$Creator)CustomAction.CREATOR);
        mActiveItemId = parcel.readLong();
        mExtras = parcel.readBundle();
    }
    
    PlaybackStateCompat(final Parcel parcel, final PlaybackStateCompat$1 parcelable$Creator) {
        this(parcel);
    }
    
    static /* synthetic */ List access$1000(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mCustomActions;
    }
    
    static /* synthetic */ long access$1100(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mActiveItemId;
    }
    
    static /* synthetic */ Bundle access$1200(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mExtras;
    }
    
    static /* synthetic */ int access$300(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mState;
    }
    
    static /* synthetic */ long access$400(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mPosition;
    }
    
    static /* synthetic */ float access$500(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mSpeed;
    }
    
    static /* synthetic */ long access$600(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mUpdateTime;
    }
    
    static /* synthetic */ long access$700(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mBufferedPosition;
    }
    
    static /* synthetic */ long access$800(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mActions;
    }
    
    static /* synthetic */ CharSequence access$900(final PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat.mErrorMessage;
    }
    
    public static PlaybackStateCompat fromPlaybackState(final Object mStateObj) {
        if (mStateObj == null || Build$VERSION.SDK_INT < 21) {
            return null;
        }
        final List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(mStateObj);
        ArrayList list = null;
        if (customActions != null) {
            list = new ArrayList<CustomAction>(customActions.size());
            final Iterator<Object> iterator = customActions.iterator();
            while (iterator.hasNext()) {
                list.add(CustomAction.fromCustomAction(iterator.next()));
            }
        }
        Bundle extras;
        if (Build$VERSION.SDK_INT >= 22) {
            extras = PlaybackStateCompatApi22.getExtras(mStateObj);
        }
        else {
            extras = null;
        }
        final PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(mStateObj), PlaybackStateCompatApi21.getPosition(mStateObj), PlaybackStateCompatApi21.getBufferedPosition(mStateObj), PlaybackStateCompatApi21.getPlaybackSpeed(mStateObj), PlaybackStateCompatApi21.getActions(mStateObj), PlaybackStateCompatApi21.getErrorMessage(mStateObj), PlaybackStateCompatApi21.getLastPositionUpdateTime(mStateObj), (List<CustomAction>)list, PlaybackStateCompatApi21.getActiveQueueItemId(mStateObj), extras);
        playbackStateCompat.mStateObj = mStateObj;
        return playbackStateCompat;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public long getActions() {
        return mActions;
    }
    
    public long getActiveQueueItemId() {
        return mActiveItemId;
    }
    
    public long getBufferedPosition() {
        return mBufferedPosition;
    }
    
    public List<CustomAction> getCustomActions() {
        return mCustomActions;
    }
    
    public CharSequence getErrorMessage() {
        return mErrorMessage;
    }
    
    @Nullable
    public Bundle getExtras() {
        return mExtras;
    }
    
    public long getLastPositionUpdateTime() {
        return mUpdateTime;
    }
    
    public float getPlaybackSpeed() {
        return mSpeed;
    }
    
    public Object getPlaybackState() {
        if (mStateObj != null || Build$VERSION.SDK_INT < 21) {
            return mStateObj;
        }
        final List<CustomAction> mCustomActions = this.mCustomActions;
        List<Object> list = null;
        if (mCustomActions != null) {
            list = new ArrayList<Object>(this.mCustomActions.size());
            final Iterator<CustomAction> iterator = this.mCustomActions.iterator();
            while (iterator.hasNext()) {
                list.add(((CustomAction)iterator.next()).getCustomAction());
            }
        }
        if (Build$VERSION.SDK_INT >= 22) {
            mStateObj = PlaybackStateCompatApi22.newInstance(mState, mPosition, mBufferedPosition, mSpeed, mActions, mErrorMessage, mUpdateTime, list, mActiveItemId, mExtras);
        }
        else {
            mStateObj = PlaybackStateCompatApi21.newInstance(mState, mPosition, mBufferedPosition, mSpeed, mActions, mErrorMessage, mUpdateTime, list, mActiveItemId);
        }
        return mStateObj;
    }
    
    public long getPosition() {
        return mPosition;
    }
    
    public int getState() {
        return mState;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(mState);
        sb.append(", position=").append(mPosition);
        sb.append(", buffered position=").append(mBufferedPosition);
        sb.append(", speed=").append(mSpeed);
        sb.append(", updated=").append(mUpdateTime);
        sb.append(", actions=").append(mActions);
        sb.append(", error=").append(mErrorMessage);
        sb.append(", custom actions=").append(mCustomActions);
        sb.append(", active item id=").append(mActiveItemId);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(mState);
        parcel.writeLong(mPosition);
        parcel.writeFloat(mSpeed);
        parcel.writeLong(mUpdateTime);
        parcel.writeLong(mBufferedPosition);
        parcel.writeLong(mActions);
        TextUtils.writeToParcel(mErrorMessage, parcel, n);
        parcel.writeTypedList((List)mCustomActions);
        parcel.writeLong(mActiveItemId);
        parcel.writeBundle(mExtras);
    }
}
