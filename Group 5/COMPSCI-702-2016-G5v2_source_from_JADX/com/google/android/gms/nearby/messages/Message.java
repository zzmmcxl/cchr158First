package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.util.Arrays;

public class Message implements SafeParcelable {
    public static final Creator<Message> CREATOR;
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    private static final NearbyDevice[] zzbbz;
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzamD;
    private final NearbyDevice[] zzbbA;

    static {
        CREATOR = new zza();
        zzbbz = new NearbyDevice[]{NearbyDevice.zzbcd};
    }

    Message(int versionCode, byte[] content, String namespace, String type, NearbyDevice[] devices) {
        this.versionCode = versionCode;
        this.type = (String) zzx.zzz(type);
        if (namespace == null) {
            namespace = BuildConfig.FLAVOR;
        }
        this.zzamD = namespace;
        if (zzR(this.zzamD, this.type)) {
            zzx.zzb(content == null, (Object) "Content must be null for a device presence message.");
        } else {
            zzx.zzz(content);
            zzx.zzb(content.length <= MAX_CONTENT_SIZE_BYTES, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(content.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        }
        this.content = content;
        if (devices == null || devices.length == 0) {
            devices = zzbbz;
        }
        this.zzbbA = devices;
        zzx.zzb(type.length() <= MAX_TYPE_LENGTH, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(type.length()), Integer.valueOf(MAX_TYPE_LENGTH));
    }

    public Message(byte[] content) {
        this(content, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public Message(byte[] content, String type) {
        this(content, BuildConfig.FLAVOR, type);
    }

    public Message(byte[] content, String namespace, String type) {
        this(content, namespace, type, zzbbz);
    }

    public Message(byte[] content, String namespace, String type, NearbyDevice[] devices) {
        this(2, content, namespace, type, devices);
    }

    public static boolean zzR(String str, String str2) {
        return str.equals("__reserved_namespace") && str2.equals("__device_presence");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Message)) {
            return false;
        }
        Message message = (Message) object;
        return TextUtils.equals(this.zzamD, message.zzamD) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content);
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzamD;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzamD, this.type, Integer.valueOf(Arrays.hashCode(this.content)));
    }

    public String toString() {
        return "Message{namespace='" + this.zzamD + "'" + ", type='" + this.type + "'" + ", content=[" + (this.content == null ? 0 : this.content.length) + " bytes]" + ", devices=" + Arrays.toString(zzEn()) + "}";
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public NearbyDevice[] zzEn() {
        return this.zzbbA;
    }
}
