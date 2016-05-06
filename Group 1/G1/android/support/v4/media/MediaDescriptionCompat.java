package android.support.v4.media;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaDescriptionCompat implements Parcelable
{
    public static final Parcelable$Creator<MediaDescriptionCompat> CREATOR;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MediaDescriptionCompat>() {
            MediaDescriptionCompat$1() {
                super();
            }
            
            public MediaDescriptionCompat createFromParcel(final Parcel parcel) {
                if (Build$VERSION.SDK_INT < 21) {
                    return new MediaDescriptionCompat(parcel, null);
                }
                return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public MediaDescriptionCompat[] newArray(final int n) {
                return new MediaDescriptionCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private MediaDescriptionCompat(final Parcel parcel) {
        super();
        mMediaId = parcel.readString();
        mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mIcon = (Bitmap)parcel.readParcelable((ClassLoader)null);
        mIconUri = (Uri)parcel.readParcelable((ClassLoader)null);
        mExtras = parcel.readBundle();
        mMediaUri = (Uri)parcel.readParcelable((ClassLoader)null);
    }
    
    MediaDescriptionCompat(final Parcel parcel, final MediaDescriptionCompat$1 parcelable$Creator) {
        this(parcel);
    }
    
    private MediaDescriptionCompat(final String mMediaId, final CharSequence mTitle, final CharSequence mSubtitle, final CharSequence mDescription, final Bitmap mIcon, final Uri mIconUri, final Bundle mExtras, final Uri mMediaUri) {
        super();
        mMediaId = mMediaId;
        mTitle = mTitle;
        mSubtitle = mSubtitle;
        mDescription = mDescription;
        mIcon = mIcon;
        mIconUri = mIconUri;
        mExtras = mExtras;
        mMediaUri = mMediaUri;
    }
    
    MediaDescriptionCompat(final String s, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final Bitmap bitmap, final Uri uri, final Bundle bundle, final Uri uri2, final MediaDescriptionCompat$1 parcelable$Creator) {
        this(s, charSequence, charSequence2, charSequence3, bitmap, uri, bundle, uri2);
    }
    
    public static MediaDescriptionCompat fromMediaDescription(final Object mDescriptionObj) {
        if (mDescriptionObj == null || Build$VERSION.SDK_INT < 21) {
            return null;
        }
        final Builder builder = new Builder();
        builder.setMediaId(MediaDescriptionCompatApi21.getMediaId(mDescriptionObj));
        builder.setTitle(MediaDescriptionCompatApi21.getTitle(mDescriptionObj));
        builder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(mDescriptionObj));
        builder.setDescription(MediaDescriptionCompatApi21.getDescription(mDescriptionObj));
        builder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(mDescriptionObj));
        builder.setIconUri(MediaDescriptionCompatApi21.getIconUri(mDescriptionObj));
        Bundle extras = MediaDescriptionCompatApi21.getExtras(mDescriptionObj);
        Uri mediaUri;
        if (extras == null) {
            mediaUri = null;
        }
        else {
            mediaUri = (Uri)extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (mediaUri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                extras = null;
            }
            else {
                extras.remove("android.support.v4.media.description.MEDIA_URI");
                extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            }
        }
        builder.setExtras(extras);
        if (mediaUri != null) {
            builder.setMediaUri(mediaUri);
        }
        else if (Build$VERSION.SDK_INT >= 23) {
            builder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(mDescriptionObj));
        }
        final MediaDescriptionCompat build = builder.build();
        build.mDescriptionObj = mDescriptionObj;
        return build;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Nullable
    public CharSequence getDescription() {
        return mDescription;
    }
    
    @Nullable
    public Bundle getExtras() {
        return mExtras;
    }
    
    @Nullable
    public Bitmap getIconBitmap() {
        return mIcon;
    }
    
    @Nullable
    public Uri getIconUri() {
        return mIconUri;
    }
    
    public Object getMediaDescription() {
        if (mDescriptionObj != null || Build$VERSION.SDK_INT < 21) {
            return mDescriptionObj;
        }
        final Object instance = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(instance, mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(instance, mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(instance, mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(instance, mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(instance, mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(instance, mIconUri);
        Bundle mExtras = this.mExtras;
        if (Build$VERSION.SDK_INT < 23 && mMediaUri != null) {
            if (mExtras == null) {
                mExtras = new Bundle();
                mExtras.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            mExtras.putParcelable("android.support.v4.media.description.MEDIA_URI", (Parcelable)mMediaUri);
        }
        MediaDescriptionCompatApi21.Builder.setExtras(instance, mExtras);
        if (Build$VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.setMediaUri(instance, mMediaUri);
        }
        return mDescriptionObj = MediaDescriptionCompatApi21.Builder.build(instance);
    }
    
    @Nullable
    public String getMediaId() {
        return mMediaId;
    }
    
    @Nullable
    public Uri getMediaUri() {
        return mMediaUri;
    }
    
    @Nullable
    public CharSequence getSubtitle() {
        return mSubtitle;
    }
    
    @Nullable
    public CharSequence getTitle() {
        return mTitle;
    }
    
    @Override
    public String toString() {
        return (Object)mTitle + ", " + (Object)mSubtitle + ", " + (Object)mDescription;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (Build$VERSION.SDK_INT < 21) {
            parcel.writeString(mMediaId);
            TextUtils.writeToParcel(mTitle, parcel, n);
            TextUtils.writeToParcel(mSubtitle, parcel, n);
            TextUtils.writeToParcel(mDescription, parcel, n);
            parcel.writeParcelable((Parcelable)mIcon, n);
            parcel.writeParcelable((Parcelable)mIconUri, n);
            parcel.writeBundle(mExtras);
            parcel.writeParcelable((Parcelable)mMediaUri, n);
            return;
        }
        MediaDescriptionCompatApi21.writeToParcel(this.getMediaDescription(), parcel, n);
    }
}
