package android.support.v4.os;

import android.os.RemoteException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Handler;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ResultReceiver implements Parcelable
{
    public static final Parcelable$Creator<ResultReceiver> CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ResultReceiver>() {
            ResultReceiver$1() {
                super();
            }
            
            public ResultReceiver createFromParcel(final Parcel parcel) {
                return new ResultReceiver(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public ResultReceiver[] newArray(final int n) {
                return new ResultReceiver[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public ResultReceiver(final Handler mHandler) {
        super();
        mLocal = true;
        mHandler = mHandler;
    }
    
    ResultReceiver(final Parcel parcel) {
        super();
        mLocal = false;
        mHandler = null;
        mReceiver = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
    
    public int describeContents() {
        return 0;
    }
    
    protected void onReceiveResult(final int n, final Bundle bundle) {
    }
    
    public void send(final int n, final Bundle bundle) {
        if (mLocal) {
            if (mHandler == null) {
                this.onReceiveResult(n, bundle);
                return;
            }
            mHandler.post((Runnable)new MyRunnable(n, bundle));
        }
        else if (mReceiver != null) {
            try {
                mReceiver.send(n, bundle);
            }
            catch (RemoteException ex) {}
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        synchronized (this) {
            if (mReceiver == null) {
                mReceiver = new MyResultReceiver();
            }
            parcel.writeStrongBinder(mReceiver.asBinder());
        }
    }
}
