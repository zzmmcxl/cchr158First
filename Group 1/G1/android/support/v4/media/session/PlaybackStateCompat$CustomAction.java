package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.text.TextUtils;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public static final class CustomAction implements Parcelable
{
    public static final Parcelable$Creator<CustomAction> CREATOR;
    private final String mAction;
    private Object mCustomActionObj;
    private final Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<CustomAction>() {
            PlaybackStateCompat$CustomAction$1() {
                super();
            }
            
            public CustomAction createFromParcel(final Parcel parcel) {
                return new CustomAction(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public CustomAction[] newArray(final int n) {
                return new CustomAction[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private CustomAction(final Parcel parcel) {
        super();
        this.mAction = parcel.readString();
        this.mName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = parcel.readInt();
        this.mExtras = parcel.readBundle();
    }
    
    CustomAction(final Parcel parcel, final PlaybackStateCompat$1 parcelable$Creator) {
        this(parcel);
    }
    
    private CustomAction(final String mAction, final CharSequence mName, final int mIcon, final Bundle mExtras) {
        super();
        this.mAction = mAction;
        this.mName = mName;
        this.mIcon = mIcon;
        this.mExtras = mExtras;
    }
    
    CustomAction(final String s, final CharSequence charSequence, final int n, final Bundle bundle, final PlaybackStateCompat$1 parcelable$Creator) {
        this(s, charSequence, n, bundle);
    }
    
    public static CustomAction fromCustomAction(final Object mCustomActionObj) {
        if (mCustomActionObj == null || Build$VERSION.SDK_INT < 21) {
            return null;
        }
        final CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(mCustomActionObj), PlaybackStateCompatApi21.CustomAction.getName(mCustomActionObj), PlaybackStateCompatApi21.CustomAction.getIcon(mCustomActionObj), PlaybackStateCompatApi21.CustomAction.getExtras(mCustomActionObj));
        customAction.mCustomActionObj = mCustomActionObj;
        return customAction;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getAction() {
        return mAction;
    }
    
    public Object getCustomAction() {
        if (mCustomActionObj != null || Build$VERSION.SDK_INT < 21) {
            return mCustomActionObj;
        }
        return mCustomActionObj = PlaybackStateCompatApi21.CustomAction.newInstance(mAction, mName, mIcon, mExtras);
    }
    
    public Bundle getExtras() {
        return mExtras;
    }
    
    public int getIcon() {
        return mIcon;
    }
    
    public CharSequence getName() {
        return mName;
    }
    
    @Override
    public String toString() {
        return "Action:mName='" + (Object)mName + ", mIcon=" + mIcon + ", mExtras=" + mExtras;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(mAction);
        TextUtils.writeToParcel(mName, parcel, n);
        parcel.writeInt(mIcon);
        parcel.writeBundle(mExtras);
    }
}
