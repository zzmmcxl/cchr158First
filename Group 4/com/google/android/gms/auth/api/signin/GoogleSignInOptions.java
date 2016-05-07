/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.c;
import com.google.android.gms.auth.api.signin.d;
import com.google.android.gms.auth.api.signin.g;
import com.google.android.gms.auth.api.signin.internal.j;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
implements f,
SafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final Scope a;
    public static final Scope b;
    public static final Scope c;
    public static final GoogleSignInOptions d;
    private static Comparator m;
    final int e;
    private final ArrayList f;
    private Account g;
    private boolean h;
    private final boolean i;
    private final boolean j;
    private String k;
    private String l;

    static {
        a = new Scope("profile");
        b = new Scope("email");
        c = new Scope("openid");
        d = new d().a().b().c();
        CREATOR = new g();
        m = new c();
    }

    GoogleSignInOptions(int n2, ArrayList arrayList, Account account, boolean bl2, boolean bl3, boolean bl4, String string, String string2) {
        this.e = n2;
        this.f = arrayList;
        this.g = account;
        this.h = bl2;
        this.i = bl3;
        this.j = bl4;
        this.k = string;
        this.l = string2;
    }

    private GoogleSignInOptions(Set set, Account account, boolean bl2, boolean bl3, boolean bl4, String string, String string2) {
        this(2, new ArrayList(set), account, bl2, bl3, bl4, string, string2);
    }

    /* synthetic */ GoogleSignInOptions(Set set, Account account, boolean bl2, boolean bl3, boolean bl4, String string, String string2, c c2) {
        this(set, account, bl2, bl3, bl4, string, string2);
    }

    public static GoogleSignInOptions a(String string) {
        Account account;
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(string);
        HashSet<Scope> hashSet = new HashSet<Scope>();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int n2 = jSONArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String string2 = jSONObject.optString("accountName", null);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            account = new Account(string2, "com.google");
            return new GoogleSignInOptions(hashSet, account, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
        }
        account = null;
        return new GoogleSignInOptions(hashSet, account, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    static /* synthetic */ ArrayList a(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.f;
    }

    static /* synthetic */ boolean b(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.i;
    }

    static /* synthetic */ boolean c(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.j;
    }

    static /* synthetic */ boolean d(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.h;
    }

    static /* synthetic */ String e(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.k;
    }

    static /* synthetic */ Account f(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.g;
    }

    static /* synthetic */ String g(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.l;
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f, m);
            Iterator iterator = this.f.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((Scope)iterator.next()).a());
            }
            jSONObject.put("scopes", (Object)jSONArray);
            if (this.g != null) {
                jSONObject.put("accountName", (Object)this.g.name);
            }
            jSONObject.put("idTokenRequested", this.h);
            jSONObject.put("forceCodeForRefreshToken", this.j);
            jSONObject.put("serverAuthRequested", this.i);
            if (!TextUtils.isEmpty((CharSequence)this.k)) {
                jSONObject.put("serverClientId", (Object)this.k);
            }
            if (TextUtils.isEmpty((CharSequence)this.l)) return jSONObject;
            jSONObject.put("hostedDomain", (Object)this.l);
            return jSONObject;
        }
        catch (JSONException var3_4) {
            throw new RuntimeException((Throwable)var3_4);
        }
    }

    public ArrayList a() {
        return new ArrayList(this.f);
    }

    public Account b() {
        return this.g;
    }

    public boolean c() {
        return this.h;
    }

    public boolean d() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.j;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions)object;
            if (this.f.size() != googleSignInOptions.a().size()) return false;
            if (!this.f.containsAll(googleSignInOptions.a())) return false;
            if (this.g == null) {
                if (googleSignInOptions.b() != null) return false;
            } else if (!this.g.equals((Object)googleSignInOptions.b())) return false;
            if (TextUtils.isEmpty((CharSequence)this.k)) {
                if (!TextUtils.isEmpty((CharSequence)googleSignInOptions.f())) return false;
            } else {
                boolean bl2 = this.k.equals(googleSignInOptions.f());
                if (!bl2) return false;
            }
            if (this.j != googleSignInOptions.e()) return false;
            if (this.h != googleSignInOptions.c()) return false;
            if (this.i != googleSignInOptions.d()) return false;
            return true;
        }
        catch (ClassCastException var2_4) {
            return false;
        }
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.l;
    }

    public String h() {
        return this.i().toString();
    }

    public int hashCode() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator iterator = this.f.iterator();
        do {
            if (!iterator.hasNext()) {
                Collections.sort(arrayList);
                return new j().a(arrayList).a((Object)this.g).a(this.k).a(this.j).a(this.h).a(this.i).a();
            }
            arrayList.add(((Scope)iterator.next()).a());
        } while (true);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        g.a(this, parcel, n2);
    }
}

