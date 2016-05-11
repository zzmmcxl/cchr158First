package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.vision.barcode.Barcode;

public class PlaceReport implements SafeParcelable {
    public static final Creator<PlaceReport> CREATOR;
    private final String mTag;
    final int mVersionCode;
    private final String zzaPH;
    private final String zzaPI;

    static {
        CREATOR = new zzj();
    }

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.mVersionCode = versionCode;
        this.zzaPH = placeId;
        this.mTag = tag;
        this.zzaPI = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzk(placeId, tag, FitnessActivities.UNKNOWN);
    }

    private static boolean zzel(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals(FitnessActivities.UNKNOWN)) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case Barcode.ALL_FORMATS /*0*/:
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
            case Barcode.PHONE /*4*/:
            case Barcode.PRODUCT /*5*/:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzx.zzz(str);
        zzx.zzcM(str2);
        zzx.zzcM(str3);
        zzx.zzb(zzel(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzw.equal(this.zzaPH, placeReport.zzaPH) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaPI, placeReport.zzaPI);
    }

    public String getPlaceId() {
        return this.zzaPH;
    }

    public String getSource() {
        return this.zzaPI;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPH, this.mTag, this.zzaPI);
    }

    public String toString() {
        zza zzy = zzw.zzy(this);
        zzy.zzg("placeId", this.zzaPH);
        zzy.zzg("tag", this.mTag);
        if (!FitnessActivities.UNKNOWN.equals(this.zzaPI)) {
            zzy.zzg("source", this.zzaPI);
        }
        return zzy.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
