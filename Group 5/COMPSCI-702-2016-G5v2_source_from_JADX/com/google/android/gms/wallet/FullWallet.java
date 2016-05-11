package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR;
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    ProxyCard zzboq;
    String zzbor;
    Address zzbos;
    Address zzbot;
    String[] zzbou;
    UserAddress zzbov;
    UserAddress zzbow;
    InstrumentInfo[] zzbox;
    PaymentMethodToken zzboy;

    static {
        CREATOR = new zze();
    }

    private FullWallet() {
        this.mVersionCode = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos, PaymentMethodToken paymentMethodToken) {
        this.mVersionCode = versionCode;
        this.zzboo = googleTransactionId;
        this.zzbop = merchantTransactionId;
        this.zzboq = proxyCard;
        this.zzbor = email;
        this.zzbos = billingAddress;
        this.zzbot = shippingAddress;
        this.zzbou = paymentDescriptions;
        this.zzbov = buyerBillingAddress;
        this.zzbow = buyerShippingAddress;
        this.zzbox = instrumentInfos;
        this.zzboy = paymentMethodToken;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzbos;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzbov;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzbow;
    }

    public String getEmail() {
        return this.zzbor;
    }

    public String getGoogleTransactionId() {
        return this.zzboo;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzbox;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public String[] getPaymentDescriptions() {
        return this.zzbou;
    }

    public PaymentMethodToken getPaymentMethodToken() {
        return this.zzboy;
    }

    public ProxyCard getProxyCard() {
        return this.zzboq;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzbot;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
