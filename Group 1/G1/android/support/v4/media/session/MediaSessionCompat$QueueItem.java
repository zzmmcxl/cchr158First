package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static final class QueueItem implements Parcelable
{
    public static final Parcelable$Creator<QueueItem> CREATOR;
    public static final int UNKNOWN_ID = -1;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private Object mItem;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<QueueItem>() {
            MediaSessionCompat$QueueItem$1() {
                super();
            }
            
            public QueueItem createFromParcel(final Parcel parcel) {
                return new QueueItem(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public QueueItem[] newArray(final int n) {
                return new QueueItem[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private QueueItem(final Parcel parcel) {
        super();
        this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.mId = parcel.readLong();
    }
    
    QueueItem(final Parcel parcel, final MediaSessionCompat$1 object) {
        this(parcel);
    }
    
    public QueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final long n) {
        this(null, mediaDescriptionCompat, n);
    }
    
    private QueueItem(final Object mItem, final MediaDescriptionCompat mDescription, final long mId) {
        super();
        if (mDescription == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }
        if (mId == -1L) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.mDescription = mDescription;
        this.mId = mId;
        this.mItem = mItem;
    }
    
    public static QueueItem obtain(final Object o) {
        return new QueueItem(o, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(o)), MediaSessionCompatApi21.QueueItem.getQueueId(o));
    }
    
    public int describeContents() {
        return 0;
    }
    
    public MediaDescriptionCompat getDescription() {
        return mDescription;
    }
    
    public long getQueueId() {
        return mId;
    }
    
    public Object getQueueItem() {
        if (mItem != null || Build$VERSION.SDK_INT < 21) {
            return mItem;
        }
        return mItem = MediaSessionCompatApi21.QueueItem.createItem(mDescription.getMediaDescription(), mId);
    }
    
    @Override
    public String toString() {
        return "MediaSession.QueueItem {Description=" + mDescription + ", Id=" + mId + " }";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        mDescription.writeToParcel(parcel, n);
        parcel.writeLong(mId);
    }
}
