package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter implements SafeParcelable {
    public static final Creator<MessageFilter> CREATOR;
    public static final MessageFilter INCLUDE_ALL_MY_TYPES;
    final int mVersionCode;
    private final List<MessageType> zzbbB;
    private final List<NearbyDeviceFilter> zzbbC;
    private final boolean zzbbD;

    public static final class Builder {
        private final List<NearbyDeviceFilter> zzbbC;
        private boolean zzbbD;
        private final List<MessageType> zzbbE;

        public Builder() {
            this.zzbbE = new ArrayList();
            this.zzbbC = new ArrayList();
        }

        private Builder zzS(String str, String str2) {
            this.zzbbE.add(new MessageType(str, str2));
            return this;
        }

        public MessageFilter build() {
            boolean z = this.zzbbD || !this.zzbbE.isEmpty();
            zzx.zza(z, (Object) "At least one of the include methods must be called.");
            return new MessageFilter(this.zzbbC, this.zzbbD, null);
        }

        public Builder includeAllMyTypes() {
            this.zzbbD = true;
            return this;
        }

        public Builder includeFilter(MessageFilter filter) {
            this.zzbbE.addAll(filter.zzEo());
            this.zzbbC.addAll(filter.zzEq());
            this.zzbbD |= filter.zzEp();
            return this;
        }

        public Builder includeNamespacedType(String namespace, String type) {
            boolean z = (namespace == null || namespace.isEmpty() || namespace.contains("*")) ? false : true;
            zzx.zzb(z, "namespace(%s) cannot be null, empty or contain (*).", namespace);
            z = (type == null || type.contains("*")) ? false : true;
            zzx.zzb(z, "type(%s) cannot be null or contain (*).", type);
            return zzS(namespace, type);
        }
    }

    static {
        CREATOR = new zzb();
        INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    }

    MessageFilter(int versionCode, List<MessageType> messageTypes, List<NearbyDeviceFilter> deviceFilters, boolean includeAllMyTypes) {
        this.mVersionCode = versionCode;
        this.zzbbB = Collections.unmodifiableList((List) zzx.zzz(messageTypes));
        this.zzbbD = includeAllMyTypes;
        if (deviceFilters == null) {
            deviceFilters = Collections.emptyList();
        }
        this.zzbbC = Collections.unmodifiableList(deviceFilters);
    }

    private MessageFilter(List<MessageType> messageTypes, List<NearbyDeviceFilter> deviceFilters, boolean includeAllMyTypes) {
        this(1, (List) messageTypes, (List) deviceFilters, includeAllMyTypes);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) o;
        return this.zzbbD == messageFilter.zzbbD && zzw.equal(this.zzbbB, messageFilter.zzbbB) && zzw.equal(this.zzbbC, messageFilter.zzbbC);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbbB, this.zzbbC, Boolean.valueOf(this.zzbbD));
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzbbD + ", messageTypes=" + this.zzbbB + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    List<MessageType> zzEo() {
        return this.zzbbB;
    }

    boolean zzEp() {
        return this.zzbbD;
    }

    List<NearbyDeviceFilter> zzEq() {
        return this.zzbbC;
    }
}
