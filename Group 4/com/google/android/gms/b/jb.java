/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.h;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.b.iz;
import com.google.android.gms.b.ja;
import com.google.android.gms.common.internal.bf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class jb
implements iz {
    protected final Activity a;
    protected final Set b;
    private String c;
    private String d;
    private ja e;

    protected jb(Activity activity, List list, List list2) {
        this.a = (Activity)bf.a((Object)activity);
        HashSet hashSet = new HashSet((Collection)bf.a(list));
        hashSet.addAll((Collection)bf.a(list2));
        this.b = Collections.unmodifiableSet(hashSet);
    }

    protected Intent a(IdpTokenType idpTokenType, String string, String string2) {
        bf.a(idpTokenType);
        bf.a(string);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", (Parcelable)idpTokenType);
        intent.putExtra("idpToken", string);
        intent.putExtra("pendingToken", string2);
        h h2 = this.a();
        if (h2 == null) return intent;
        intent.putExtra("idProvider", h2.a());
        return intent;
    }

    protected void a(String string) {
        this.c = string;
    }

    protected Set b() {
        return this.b;
    }

    protected void b(ja ja2) {
        this.e = (ja)bf.a(ja2);
    }

    protected void b(String string) {
        this.d = string;
    }

    protected void b(String string, String string2, ja ja2) {
        this.a(string);
        this.b(string2);
        this.b(ja2);
    }

    protected ja c() {
        return this.e;
    }

    protected String d() {
        return this.d;
    }
}

