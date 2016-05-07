/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ah;
import android.support.v7.a.u;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.location.f;
import com.google.android.gms.location.m;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;
import java.util.ArrayList;
import java.util.List;
import xyz.a;
import xyz.c;
import xyz.g;
import xyz.i;
import xyz.j;
import xyz.lpsdt5r;
import xyz.z1flnjcn;

public class m2m5pcv0
extends u
implements q,
r,
x {
    protected List m;
    private EditText n;
    private Button o;
    private SupportPlaceAutocompleteFragment p;
    private g q;
    private PendingIntent r;
    private n s;
    private String t;
    private String u = c.a("2Rz65JfgxrWkNiyzrLNXXg==");
    private com.google.android.gms.location.places.a v;

    static /* synthetic */ com.google.android.gms.location.places.a a(m2m5pcv0 m2m5pcv02, com.google.android.gms.location.places.a a2) {
        m2m5pcv02.v = a2;
        return a2;
    }

    static /* synthetic */ String a(m2m5pcv0 m2m5pcv02) {
        return m2m5pcv02.t;
    }

    static /* synthetic */ String a(m2m5pcv0 m2m5pcv02, String string) {
        m2m5pcv02.t = string;
        return string;
    }

    private void a(a a2) {
        int n2 = (Integer)a2.a(0);
        double d2 = (Double)a2.a(1);
        double d3 = (Double)a2.a(2);
        this.m.add(new f().a(Integer.toString(n2)).a(d2, d3, 200.0f).a(86400000).a(3).a());
    }

    static /* synthetic */ void a(m2m5pcv0 m2m5pcv02, a a2) {
        m2m5pcv02.a(a2);
    }

    static /* synthetic */ EditText b(m2m5pcv0 m2m5pcv02) {
        return m2m5pcv02.n;
    }

    static /* synthetic */ g c(m2m5pcv0 m2m5pcv02) {
        return m2m5pcv02.q;
    }

    static /* synthetic */ com.google.android.gms.location.places.a d(m2m5pcv0 m2m5pcv02) {
        return m2m5pcv02.v;
    }

    static /* synthetic */ void e(m2m5pcv0 m2m5pcv02) {
        m2m5pcv02.o();
    }

    static /* synthetic */ SupportPlaceAutocompleteFragment f(m2m5pcv0 m2m5pcv02) {
        return m2m5pcv02.p;
    }

    private GeofencingRequest m() {
        try {
            if (this.m == null) return null;
            if (!this.m.isEmpty()) throw new NullPointerException();
            return null;
        }
        catch (NullPointerException var1_1) {
            com.google.android.gms.location.j j2 = new com.google.android.gms.location.j();
            j2.a(1);
            j2.a(this.m);
            return j2.a();
        }
    }

    private PendingIntent n() {
        try {
            if (this.r == null) throw new NullPointerException();
            return this.r;
        }
        catch (NullPointerException var1_1) {
            return PendingIntent.getService((Context)this, (int)0, (Intent)new Intent((Context)this, (Class)z1flnjcn.class), (int)134217728);
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private void o() {
        try {
            if (this.s.i()) throw new NullPointerException();
            this.s.e();
            return;
        }
        catch (NullPointerException var1_1) {
            GeofencingRequest geofencingRequest = this.m();
            this.r = this.n();
            if (geofencingRequest == null) throw new NullPointerException();
            try {
                PendingIntent pendingIntent = this.r;
                if (pendingIntent == null) throw new NullPointerException();
                m.c.a(this.s, geofencingRequest, this.r).a(this);
                (LocationManager)this.getSystemService("location");
                return;
            }
            catch (NullPointerException var3_4) {
                return;
            }
            catch (SecurityException securityException) {
                return;
            }
        }
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void a(Bundle bundle) {
        this.o();
    }

    @Override
    public void a(ConnectionResult connectionResult) {
    }

    public void a(Status status) {
        try {
            if (!status.e()) throw new NullPointerException();
            Intent intent = new Intent((Context)this, (Class)lpsdt5r.class);
            intent.addFlags(67108864);
            intent.putExtra(c.a("A77uC1DdVSiO6G0LdEx5gQ=="), this.n.getText().toString());
            intent.putExtra(c.a("alJgMIWQ79qX0ZaVy8oyiQ=="), this.t);
            this.startActivity(intent);
            return;
        }
        catch (NullPointerException var2_3) {
            return;
        }
    }

    protected void l() {
        // MONITORENTER : this
        this.s = new o((Context)this).a(this).a(this).a(m.a).b();
        // MONITOREXIT : this
        return;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968601);
        this.q = new g((Context)this);
        this.n = (EditText)this.findViewById(2131558544);
        this.o = (Button)this.findViewById(2131558546);
        this.p = (SupportPlaceAutocompleteFragment)this.f().a(2131558545);
        i i2 = new i(this);
        this.o.setOnClickListener((View.OnClickListener)i2);
        this.p.a(new j(this));
        this.l();
        this.m = new ArrayList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.s.e();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.s.g();
    }
}

