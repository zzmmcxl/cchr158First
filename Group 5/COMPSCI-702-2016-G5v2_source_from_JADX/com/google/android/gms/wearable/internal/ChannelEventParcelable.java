package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable implements SafeParcelable {
    public static final Creator<ChannelEventParcelable> CREATOR;
    final int mVersionCode;
    final int type;
    final int zzbsa;
    final int zzbsb;
    final ChannelImpl zzbsc;

    static {
        CREATOR = new zzn();
    }

    ChannelEventParcelable(int versionCode, ChannelImpl channel, int type, int closeReason, int appErrorCode) {
        this.mVersionCode = versionCode;
        this.zzbsc = channel;
        this.type = type;
        this.zzbsa = closeReason;
        this.zzbsb = appErrorCode;
    }

    private static String zzlG(int i) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "CHANNEL_OPENED";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "CHANNEL_CLOSED";
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return "INPUT_CLOSED";
            case Barcode.PHONE /*4*/:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzlH(int i) {
        switch (i) {
            case Barcode.ALL_FORMATS /*0*/:
                return "CLOSE_REASON_NORMAL";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "CLOSE_REASON_DISCONNECTED";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzbsc + ", type=" + zzlG(this.type) + ", closeReason=" + zzlH(this.zzbsa) + ", appErrorCode=" + this.zzbsb + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }

    public void zza(ChannelListener channelListener) {
        switch (this.type) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                channelListener.onChannelOpened(this.zzbsc);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                channelListener.onChannelClosed(this.zzbsc, this.zzbsa, this.zzbsb);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                channelListener.onInputClosed(this.zzbsc, this.zzbsa, this.zzbsb);
            case Barcode.PHONE /*4*/:
                channelListener.onOutputClosed(this.zzbsc, this.zzbsa, this.zzbsb);
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
        }
    }
}
