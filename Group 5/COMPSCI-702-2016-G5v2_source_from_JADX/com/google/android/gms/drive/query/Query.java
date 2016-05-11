package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR;
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final boolean zzarL;
    final LogicalFilter zzatV;
    final String zzatW;
    final SortOrder zzatX;
    final List<String> zzatY;
    final boolean zzatZ;

    public static class Builder {
        private Set<DriveSpace> zzapC;
        private boolean zzarL;
        private String zzatW;
        private SortOrder zzatX;
        private List<String> zzatY;
        private boolean zzatZ;
        private final List<Filter> zzaua;

        public Builder() {
            this.zzaua = new ArrayList();
        }

        public Builder(Query query) {
            this.zzaua = new ArrayList();
            this.zzaua.add(query.getFilter());
            this.zzatW = query.getPageToken();
            this.zzatX = query.getSortOrder();
            this.zzatY = query.zztJ();
            this.zzatZ = query.zztK();
            this.zzapC = query.zztL();
            this.zzarL = query.zztM();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzaua.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(this.zzatW, this.zzatX, this.zzatY, this.zzatZ, this.zzapC, this.zzarL, null);
        }

        @Deprecated
        public Builder setPageToken(String token) {
            this.zzatW = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzatX = sortOrder;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    private Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, List<DriveSpace> spacesList, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this.mVersionCode = versionCode;
        this.zzatV = clause;
        this.zzatW = pageToken;
        this.zzatX = sortOrder;
        this.zzatY = requestedMetadataFields;
        this.zzatZ = includeParents;
        this.zzapB = spacesList;
        this.zzapC = spaces;
        this.zzarL = includeUnsubscribed;
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, List<DriveSpace> spacesList, boolean includeUnsubscribed) {
        this(versionCode, clause, pageToken, sortOrder, requestedMetadataFields, includeParents, spacesList, spacesList == null ? null : new HashSet(spacesList), includeUnsubscribed);
    }

    private Query(LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this(1, clause, pageToken, sortOrder, requestedMetadataFields, includeParents, spaces == null ? null : new ArrayList(spaces), spaces, includeUnsubscribed);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzatV;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzatW;
    }

    public SortOrder getSortOrder() {
        return this.zzatX;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzatV, this.zzatX, this.zzatW, this.zzapB});
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public List<String> zztJ() {
        return this.zzatY;
    }

    public boolean zztK() {
        return this.zzatZ;
    }

    public Set<DriveSpace> zztL() {
        return this.zzapC;
    }

    public boolean zztM() {
        return this.zzarL;
    }
}
