package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class JoinOptions implements SafeParcelable {
    public static final Creator<JoinOptions> CREATOR;
    private final int mVersionCode;
    private int zzaaJ;

    static {
        CREATOR = new zzc();
    }

    public JoinOptions() {
        this(1, 0);
    }

    JoinOptions(int versionCode, int connectionType) {
        this.mVersionCode = versionCode;
        this.zzaaJ = connectionType;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JoinOptions)) {
            return false;
        }
        return this.zzaaJ == ((JoinOptions) obj).zzaaJ;
    }

    public int getConnectionType() {
        return this.zzaaJ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaaJ));
    }

    public String toString() {
        String str;
        switch (this.zzaaJ) {
            case Barcode.ALL_FORMATS /*0*/:
                str = "STRONG";
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                str = "INVISIBLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", new Object[]{str});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
