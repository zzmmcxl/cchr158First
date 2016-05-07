/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.x;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.b;
import com.google.android.gms.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.ui.a;
import com.google.android.gms.location.places.ui.d;
import com.google.android.gms.location.places.ui.e;
import com.google.android.gms.maps.model.LatLngBounds;

public class SupportPlaceAutocompleteFragment
extends x {
    private View a;
    private View b;
    private EditText c;
    private LatLngBounds d;
    private AutocompleteFilter e;
    private com.google.android.gms.location.places.ui.c f;

    private void K() {
        int n2;
        try {
            this.a(new com.google.android.gms.location.places.ui.b(2).a(this.d).a(this.e).a(this.c.getText().toString()).a(1).a(this.g()), 1);
            return;
        }
        catch (com.google.android.gms.common.d var6_2) {
            int n3 = var6_2.a();
            Log.e((String)"Places", (String)"Could not open autocomplete activity", (Throwable)var6_2);
            n2 = n3;
        }
        catch (com.google.android.gms.common.c var1_4) {
            int n4 = var1_4.a;
            Log.e((String)"Places", (String)"Could not open autocomplete activity", (Throwable)var1_4);
            n2 = n4;
        }
        if (n2 == -1) return;
        com.google.android.gms.common.b.a().a(this.g(), n2, 2);
    }

    private void a() {
        boolean bl2 = !this.c.getText().toString().isEmpty();
        View view = this.b;
        int n2 = 0;
        if (!bl2) {
            n2 = 8;
        }
        view.setVisibility(n2);
    }

    static /* synthetic */ void a(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        supportPlaceAutocompleteFragment.K();
    }

    @Override
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(c.place_autocomplete_fragment, viewGroup, false);
        this.a = view.findViewById(b.place_autocomplete_search_button);
        this.b = view.findViewById(b.place_autocomplete_clear_button);
        this.c = (EditText)view.findViewById(b.place_autocomplete_search_input);
        d d2 = new d(this);
        this.a.setOnClickListener((View.OnClickListener)d2);
        this.c.setOnClickListener((View.OnClickListener)d2);
        this.b.setOnClickListener((View.OnClickListener)new e(this));
        this.a();
        return view;
    }

    @Override
    public void a(int n2, int n3, Intent intent) {
        if (n2 == 1) {
            if (n3 == -1) {
                com.google.android.gms.location.places.a a2 = a.a((Context)this.g(), intent);
                if (this.f != null) {
                    this.f.a(a2);
                }
                this.a(a2.b().toString());
            } else if (n3 == 2) {
                Status status = a.b((Context)this.g(), intent);
                if (this.f != null) {
                    this.f.a(status);
                }
            }
        }
        super.a(n2, n3, intent);
    }

    public void a(com.google.android.gms.location.places.ui.c c2) {
        this.f = c2;
    }

    public void a(CharSequence charSequence) {
        this.c.setText(charSequence);
        this.a();
    }

    @Override
    public void e() {
        this.a = null;
        this.b = null;
        this.c = null;
        super.e();
    }
}

