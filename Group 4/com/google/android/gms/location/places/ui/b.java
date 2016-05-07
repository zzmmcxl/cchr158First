/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.ui.g;
import com.google.android.gms.maps.model.LatLngBounds;

public class b
extends g {
    public b(int n2) {
        super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
        this.a.putExtra("gmscore_client_jar_version", com.google.android.gms.common.b.a);
        this.a.putExtra("mode", n2);
        this.a.putExtra("origin", 2);
    }

    @Override
    public Intent a(Activity activity) {
        return super.a(activity);
    }

    public b a(int n2) {
        this.a.putExtra("origin", n2);
        return this;
    }

    public b a(AutocompleteFilter autocompleteFilter) {
        if (autocompleteFilter != null) {
            this.a.putExtra("filter", (Parcelable)autocompleteFilter);
            return this;
        }
        this.a.removeExtra("filter");
        return this;
    }

    public b a(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.a.putExtra("bounds", (Parcelable)latLngBounds);
            return this;
        }
        this.a.removeExtra("bounds");
        return this;
    }

    public b a(String string) {
        if (string != null) {
            this.a.putExtra("initial_query", string);
            return this;
        }
        this.a.removeExtra("initial_query");
        return this;
    }
}

