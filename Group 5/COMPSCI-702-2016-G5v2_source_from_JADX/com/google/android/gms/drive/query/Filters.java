package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;

public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.zzauC, filter, additionalFilters);
    }

    public static Filter and(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.zzauC, filters);
    }

    public static Filter contains(SearchableMetadataField<String> field, String value) {
        return new ComparisonFilter(Operator.zzauF, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter eq(CustomPropertyKey key, String value) {
        zzx.zzb(value != null, (Object) "Custom property value may not be null.");
        return new HasFilter(SearchableField.zzauc, new zza().zza(key, value).zztA());
    }

    public static <T> Filter eq(SearchableMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzaux, (SearchableMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzauA, (SearchableMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzauB, (SearchableMetadataField) field, (Object) value);
    }

    public static <T> Filter in(SearchableCollectionMetadataField<T> field, T value) {
        return new InFilter((SearchableCollectionMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzauy, (SearchableMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzauz, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    public static Filter openedByMe() {
        return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
    }

    public static Filter or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.zzauD, filter, additionalFilters);
    }

    public static Filter or(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.zzauD, filters);
    }

    public static Filter ownedByMe() {
        return new OwnedByMeFilter();
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.zzaub);
    }
}
