package android.support.v4.media;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.util.Log;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable
{
    public static final Parcelable$Creator<RatingCompat> CREATOR;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<RatingCompat>() {
            RatingCompat$1() {
                super();
            }
            
            public RatingCompat createFromParcel(final Parcel parcel) {
                return new RatingCompat(parcel.readInt(), parcel.readFloat(), null);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public RatingCompat[] newArray(final int n) {
                return new RatingCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private RatingCompat(final int mRatingStyle, final float mRatingValue) {
        super();
        mRatingStyle = mRatingStyle;
        mRatingValue = mRatingValue;
    }
    
    RatingCompat(final int n, final float n2, final RatingCompat$1 parcelable$Creator) {
        this(n, n2);
    }
    
    public static RatingCompat fromRating(final Object mRatingObj) {
        if (mRatingObj == null || Build$VERSION.SDK_INT < 21) {
            return null;
        }
        final int ratingStyle = RatingCompatApi21.getRatingStyle(mRatingObj);
        RatingCompat ratingCompat = null;
        if (RatingCompatApi21.isRated(mRatingObj)) {
            switch (ratingStyle) {
                default:
                    return null;
                case 1:
                    ratingCompat = newHeartRating(RatingCompatApi21.hasHeart(mRatingObj));
                    break;
                case 2:
                    ratingCompat = newThumbRating(RatingCompatApi21.isThumbUp(mRatingObj));
                    break;
                case 3:
                case 4:
                case 5:
                    ratingCompat = newStarRating(ratingStyle, RatingCompatApi21.getStarRating(mRatingObj));
                    break;
                case 6:
                    ratingCompat = newPercentageRating(RatingCompatApi21.getPercentRating(mRatingObj));
                    break;
            }
        }
        else {
            ratingCompat = newUnratedRating(ratingStyle);
        }
        ratingCompat.mRatingObj = mRatingObj;
        return ratingCompat;
    }
    
    public static RatingCompat newHeartRating(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        return new RatingCompat(1, n);
    }
    
    public static RatingCompat newPercentageRating(final float n) {
        if (n < 0.0f || n > 100.0f) {
            Log.e("Rating", "Invalid percentage-based rating value");
            return null;
        }
        return new RatingCompat(6, n);
    }
    
    public static RatingCompat newStarRating(final int n, final float n2) {
        float n3 = 0.0f;
        switch (n) {
            default:
                Log.e("Rating", "Invalid rating style (" + n + ") for a star rating");
                return null;
            case 3:
                n3 = 3.0f;
                break;
            case 4:
                n3 = 4.0f;
                break;
            case 5:
                n3 = 5.0f;
                break;
        }
        if (n2 < 0.0f || n2 > n3) {
            Log.e("Rating", "Trying to set out of range star-based rating");
            return null;
        }
        return new RatingCompat(n, n2);
    }
    
    public static RatingCompat newThumbRating(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        return new RatingCompat(2, n);
    }
    
    public static RatingCompat newUnratedRating(final int n) {
        switch (n) {
            default:
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(n, -1.0f);
        }
    }
    
    public int describeContents() {
        return mRatingStyle;
    }
    
    public float getPercentRating() {
        if (mRatingStyle != 6 || !this.isRated()) {
            return -1.0f;
        }
        return mRatingValue;
    }
    
    public Object getRating() {
        if (mRatingObj != null || Build$VERSION.SDK_INT < 21) {
            return mRatingObj;
        }
        if (this.isRated()) {
            switch (mRatingStyle) {
                case 1:
                    mRatingObj = RatingCompatApi21.newHeartRating(this.hasHeart());
                    return mRatingObj;
                case 2:
                    mRatingObj = RatingCompatApi21.newThumbRating(this.isThumbUp());
                    return mRatingObj;
                case 3:
                case 4:
                case 5:
                    mRatingObj = RatingCompatApi21.newStarRating(mRatingStyle, this.getStarRating());
                    return mRatingObj;
                case 6:
                    mRatingObj = RatingCompatApi21.newPercentageRating(this.getPercentRating());
                    break;
            }
            return null;
        }
        mRatingObj = RatingCompatApi21.newUnratedRating(mRatingStyle);
        return mRatingObj;
    }
    
    public int getRatingStyle() {
        return mRatingStyle;
    }
    
    public float getStarRating() {
        switch (mRatingStyle) {
            case 3:
            case 4:
            case 5:
                if (this.isRated()) {
                    return mRatingValue;
                }
                break;
        }
        return -1.0f;
    }
    
    public boolean hasHeart() {
        boolean b = true;
        if (mRatingStyle != (b ? 1 : 0)) {
            return false;
        }
        if (mRatingValue != 1.0f) {
            b = false;
        }
        return b;
    }
    
    public boolean isRated() {
        return mRatingValue >= 0.0f;
    }
    
    public boolean isThumbUp() {
        return mRatingStyle == 2 && mRatingValue == 1.0f;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append("Rating:style=").append(mRatingStyle).append(" rating=");
        String value;
        if (mRatingValue < 0.0f) {
            value = "unrated";
        }
        else {
            value = String.valueOf(mRatingValue);
        }
        return append.append(value).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(mRatingStyle);
        parcel.writeFloat(mRatingValue);
    }
}
