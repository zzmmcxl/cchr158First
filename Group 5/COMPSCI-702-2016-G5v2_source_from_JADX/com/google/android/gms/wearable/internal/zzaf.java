package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.woop.tryreverseengineerthis.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzaf extends zzc implements DataItem {
    private final int zzaDQ;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzIM();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            zzac com_google_android_gms_wearable_internal_zzac = new zzac(this.zzahi, this.zzaje + i);
            if (com_google_android_gms_wearable_internal_zzac.getDataItemKey() != null) {
                hashMap.put(com_google_android_gms_wearable_internal_zzac.getDataItemKey(), com_google_android_gms_wearable_internal_zzac);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        stringBuilder.append(", numAssets=" + assets.size());
        if (verbose && !assets.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = BuildConfig.FLAVOR;
            String str2 = str;
            for (Entry entry : assets.entrySet()) {
                stringBuilder.append(str2 + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str2 = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public DataItem zzIM() {
        return new zzad(this);
    }
}
