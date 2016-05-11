package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
    public static final Creator<GiftCardWalletObject> CREATOR;
    final int mVersionCode;
    String pin;
    CommonWalletObject zzboB;
    String zzboC;
    String zzboD;
    long zzboE;
    String zzboF;
    long zzboG;
    String zzboH;

    static {
        CREATOR = new zzg();
    }

    GiftCardWalletObject() {
        this.zzboB = CommonWalletObject.zzIr().zzIs();
        this.mVersionCode = 1;
    }

    GiftCardWalletObject(int versionCode, CommonWalletObject commonWalletObject, String cardNumber, String pin, String cardIdentifier, long balanceMicros, String balanceCurrencyCode, long balanceUpdateTime, String eventNumber) {
        this.zzboB = CommonWalletObject.zzIr().zzIs();
        this.mVersionCode = versionCode;
        this.zzboB = commonWalletObject;
        this.zzboC = cardNumber;
        this.pin = pin;
        this.zzboE = balanceMicros;
        this.zzboF = balanceCurrencyCode;
        this.zzboG = balanceUpdateTime;
        this.zzboH = eventNumber;
        this.zzboD = cardIdentifier;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzboB.getId();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
