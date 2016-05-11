package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Creator<ListSubscriptionsResult> CREATOR;
    private final int mVersionCode;
    private final Status zzUX;
    private final List<Subscription> zzaBM;

    static {
        CREATOR = new zzh();
    }

    ListSubscriptionsResult(int versionCode, List<Subscription> subscriptions, Status status) {
        this.mVersionCode = versionCode;
        this.zzaBM = subscriptions;
        this.zzUX = status;
    }

    public ListSubscriptionsResult(List<Subscription> subscriptions, Status status) {
        this.mVersionCode = 3;
        this.zzaBM = Collections.unmodifiableList(subscriptions);
        this.zzUX = (Status) zzx.zzb((Object) status, Games.EXTRA_STATUS);
    }

    public static ListSubscriptionsResult zzT(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listSubscriptionsResult) {
        return this.zzUX.equals(listSubscriptionsResult.zzUX) && zzw.equal(this.zzaBM, listSubscriptionsResult.zzaBM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult) that));
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public List<Subscription> getSubscriptions() {
        return this.zzaBM;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        List arrayList = new ArrayList();
        for (Subscription subscription : this.zzaBM) {
            if (dataType.equals(subscription.zzuy())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaBM);
    }

    public String toString() {
        return zzw.zzy(this).zzg(Games.EXTRA_STATUS, this.zzUX).zzg("subscriptions", this.zzaBM).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
