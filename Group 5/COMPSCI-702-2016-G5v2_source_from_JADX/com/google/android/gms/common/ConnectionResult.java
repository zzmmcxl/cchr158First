package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.iid.InstanceID;

public final class ConnectionResult implements SafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Creator<ConnectionResult> CREATOR;
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final ConnectionResult zzafB;
    private final PendingIntent mPendingIntent;
    final int mVersionCode;
    private final int zzade;
    private final String zzafC;

    static {
        zzafB = new ConnectionResult(SUCCESS);
        CREATOR = new zzb();
    }

    public ConnectionResult(int statusCode) {
        this(statusCode, null, null);
    }

    ConnectionResult(int versionCode, int statusCode, PendingIntent pendingIntent, String statusMessage) {
        this.mVersionCode = versionCode;
        this.zzade = statusCode;
        this.mPendingIntent = pendingIntent;
        this.zzafC = statusMessage;
    }

    public ConnectionResult(int statusCode, PendingIntent pendingIntent) {
        this(statusCode, pendingIntent, null);
    }

    public ConnectionResult(int statusCode, PendingIntent pendingIntent, String message) {
        this(SERVICE_MISSING, statusCode, pendingIntent, message);
    }

    static String getStatusString(int statusCode) {
        switch (statusCode) {
            case SUCCESS /*0*/:
                return "SUCCESS";
            case SERVICE_MISSING /*1*/:
                return "SERVICE_MISSING";
            case SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case SERVICE_DISABLED /*3*/:
                return "SERVICE_DISABLED";
            case SIGN_IN_REQUIRED /*4*/:
                return "SIGN_IN_REQUIRED";
            case INVALID_ACCOUNT /*5*/:
                return "INVALID_ACCOUNT";
            case RESOLUTION_REQUIRED /*6*/:
                return "RESOLUTION_REQUIRED";
            case NETWORK_ERROR /*7*/:
                return "NETWORK_ERROR";
            case INTERNAL_ERROR /*8*/:
                return "INTERNAL_ERROR";
            case SERVICE_INVALID /*9*/:
                return "SERVICE_INVALID";
            case DEVELOPER_ERROR /*10*/:
                return "DEVELOPER_ERROR";
            case LICENSE_CHECK_FAILED /*11*/:
                return "LICENSE_CHECK_FAILED";
            case CANCELED /*13*/:
                return "CANCELED";
            case TIMEOUT /*14*/:
                return InstanceID.ERROR_TIMEOUT;
            case INTERRUPTED /*15*/:
                return "INTERRUPTED";
            case API_UNAVAILABLE /*16*/:
                return "API_UNAVAILABLE";
            case SIGN_IN_FAILED /*17*/:
                return "SIGN_IN_FAILED";
            case SERVICE_UPDATING /*18*/:
                return "SERVICE_UPDATING";
            case SERVICE_MISSING_PERMISSION /*19*/:
                return "SERVICE_MISSING_PERMISSION";
            case RESTRICTED_PROFILE /*20*/:
                return "RESTRICTED_PROFILE";
            default:
                return "UNKNOWN_ERROR_CODE(" + statusCode + ")";
        }
    }

    public int describeContents() {
        return SUCCESS;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) o;
        return this.zzade == connectionResult.zzade && zzw.equal(this.mPendingIntent, connectionResult.mPendingIntent) && zzw.equal(this.zzafC, connectionResult.zzafC);
    }

    public int getErrorCode() {
        return this.zzade;
    }

    @Nullable
    public String getErrorMessage() {
        return this.zzafC;
    }

    @Nullable
    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public boolean hasResolution() {
        return (this.zzade == 0 || this.mPendingIntent == null) ? false : true;
    }

    public int hashCode() {
        Object[] objArr = new Object[SERVICE_DISABLED];
        objArr[SUCCESS] = Integer.valueOf(this.zzade);
        objArr[SERVICE_MISSING] = this.mPendingIntent;
        objArr[SERVICE_VERSION_UPDATE_REQUIRED] = this.zzafC;
        return zzw.hashCode(objArr);
    }

    public boolean isSuccess() {
        return this.zzade == 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, SUCCESS, SUCCESS, SUCCESS);
        }
    }

    public String toString() {
        return zzw.zzy(this).zzg("statusCode", getStatusString(this.zzade)).zzg("resolution", this.mPendingIntent).zzg("message", this.zzafC).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
