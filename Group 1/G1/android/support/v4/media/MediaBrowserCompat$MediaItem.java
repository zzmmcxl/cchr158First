package android.support.v4.media;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.text.TextUtils;
import android.support.annotation.NonNull;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static class MediaItem implements Parcelable
{
    public static final Parcelable$Creator<MediaItem> CREATOR;
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MediaItem>() {
            MediaBrowserCompat$MediaItem$1() {
                super();
            }
            
            public MediaItem createFromParcel(final Parcel parcel) {
                return new MediaItem(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public MediaItem[] newArray(final int n) {
                return new MediaItem[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private MediaItem(final Parcel parcel) {
        super();
        this.mFlags = parcel.readInt();
        this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }
    
    MediaItem(final Parcel parcel, final MediaBrowserCompat$1 object) {
        this(parcel);
    }
    
    public MediaItem(@NonNull final MediaDescriptionCompat mDescription, final int mFlags) {
        super();
        if (mDescription == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        if (TextUtils.isEmpty((CharSequence)mDescription.getMediaId())) {
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
        this.mFlags = mFlags;
        this.mDescription = mDescription;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @NonNull
    public MediaDescriptionCompat getDescription() {
        return mDescription;
    }
    
    public int getFlags() {
        return mFlags;
    }
    
    @NonNull
    public String getMediaId() {
        return mDescription.getMediaId();
    }
    
    public boolean isBrowsable() {
        return (0x1 & mFlags) != 0x0;
    }
    
    public boolean isPlayable() {
        return (0x2 & mFlags) != 0x0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MediaItem{");
        sb.append("mFlags=").append(mFlags);
        sb.append(", mDescription=").append(mDescription);
        sb.append('}');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(mFlags);
        mDescription.writeToParcel(parcel, n);
    }
}
