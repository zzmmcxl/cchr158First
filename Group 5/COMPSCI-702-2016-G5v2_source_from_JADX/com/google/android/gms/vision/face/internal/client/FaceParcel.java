package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceParcel implements SafeParcelable {
    public static final zza CREATOR;
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    public final int versionCode;
    public final float width;
    public final float zzbnP;
    public final float zzbnQ;
    public final LandmarkParcel[] zzbnR;
    public final float zzbnS;
    public final float zzbnT;
    public final float zzbnU;

    static {
        CREATOR = new zza();
    }

    public FaceParcel(int versionCode, int id, float centerX, float centerY, float width, float height, float eulerY, float eulerZ, LandmarkParcel[] landmarkParcels, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.versionCode = versionCode;
        this.id = id;
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.zzbnP = eulerY;
        this.zzbnQ = eulerZ;
        this.zzbnR = landmarkParcels;
        this.zzbnS = isLeftEyeOpenScore;
        this.zzbnT = isRightEyeOpenScore;
        this.zzbnU = isSmilingScore;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
