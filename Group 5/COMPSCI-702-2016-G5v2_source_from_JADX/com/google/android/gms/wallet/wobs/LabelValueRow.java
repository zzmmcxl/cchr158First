package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

public final class LabelValueRow implements SafeParcelable {
    public static final Creator<LabelValueRow> CREATOR;
    private final int mVersionCode;
    String zzbqF;
    String zzbqG;
    ArrayList<LabelValue> zzbqH;

    static {
        CREATOR = new zzc();
    }

    LabelValueRow() {
        this.mVersionCode = 1;
        this.zzbqH = zzmn.zzsa();
    }

    LabelValueRow(int versionCode, String hexFontColor, String hexBackgroundColor, ArrayList<LabelValue> columns) {
        this.mVersionCode = versionCode;
        this.zzbqF = hexFontColor;
        this.zzbqG = hexBackgroundColor;
        this.zzbqH = columns;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
