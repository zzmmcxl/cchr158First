package android.support.v4.media.session;

import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

static final class ResultReceiverWrapper implements Parcelable
{
    public static final Parcelable$Creator<ResultReceiverWrapper> CREATOR;
    private ResultReceiver mResultReceiver;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ResultReceiverWrapper>() {
            MediaSessionCompat$ResultReceiverWrapper$1() {
                super();
            }
            
            public ResultReceiverWrapper createFromParcel(final Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public ResultReceiverWrapper[] newArray(final int n) {
                return new ResultReceiverWrapper[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    ResultReceiverWrapper(final Parcel parcel) {
        super();
        this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
    }
    
    public ResultReceiverWrapper(final ResultReceiver mResultReceiver) {
        super();
        this.mResultReceiver = mResultReceiver;
    }
    
    static /* synthetic */ ResultReceiver access$800(final ResultReceiverWrapper resultReceiverWrapper) {
        return resultReceiverWrapper.mResultReceiver;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        mResultReceiver.writeToParcel(parcel, n);
    }
}
