package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable
{
    public static final Parcelable$Creator<ParcelableVolumeInfo> CREATOR;
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ParcelableVolumeInfo>() {
            ParcelableVolumeInfo$1() {
                super();
            }
            
            public ParcelableVolumeInfo createFromParcel(final Parcel parcel) {
                return new ParcelableVolumeInfo(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public ParcelableVolumeInfo[] newArray(final int n) {
                return new ParcelableVolumeInfo[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public ParcelableVolumeInfo(final int volumeType, final int audioStream, final int controlType, final int maxVolume, final int currentVolume) {
        super();
        volumeType = volumeType;
        audioStream = audioStream;
        controlType = controlType;
        maxVolume = maxVolume;
        currentVolume = currentVolume;
    }
    
    public ParcelableVolumeInfo(final Parcel parcel) {
        super();
        volumeType = parcel.readInt();
        controlType = parcel.readInt();
        maxVolume = parcel.readInt();
        currentVolume = parcel.readInt();
        audioStream = parcel.readInt();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(volumeType);
        parcel.writeInt(controlType);
        parcel.writeInt(maxVolume);
        parcel.writeInt(currentVolume);
        parcel.writeInt(audioStream);
    }
}
