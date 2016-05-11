package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetChannelOutputStreamResponse implements SafeParcelable {
    public static final Creator<GetChannelOutputStreamResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzbsC;

    static {
        CREATOR = new zzak();
    }

    GetChannelOutputStreamResponse(int versionCode, int statusCode, ParcelFileDescriptor fileDescriptor) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsC = fileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzak.zza(this, dest, flags);
    }
}
