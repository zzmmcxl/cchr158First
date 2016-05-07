/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.maps.model.LatLng;
import xyz.a;
import xyz.c;
import xyz.d;
import xyz.m2m5pcv0;

class i
implements View.OnClickListener {
    final /* synthetic */ m2m5pcv0 a;

    i(m2m5pcv0 m2m5pcv02) {
        this.a = m2m5pcv02;
    }

    public void onClick(View view) {
        try {
            if (m2m5pcv0.a(this.a) != null) throw new NullPointerException();
            Toast.makeText((Context)this.a.getBaseContext(), (CharSequence)c.a("yIP3YSAuCR/5gCitLmWLGriUnO4qtxilVB2ltD0JG+U="), (int)1).show();
            return;
        }
        catch (NullPointerException var2_2) {
            try {
                if (m2m5pcv0.b(this.a).getText() != null) {
                    if (!m2m5pcv0.b(this.a).getText().toString().equals(c.a("UGHOf8CxL3tl/UklIVcwng=="))) throw new NullPointerException();
                }
                Toast.makeText((Context)this.a.getBaseContext(), (CharSequence)c.a("/om8zNSogtzp2JcYi8StQk70xIihJxcJJ7STl1PVo9c="), (int)1).show();
                return;
            }
            catch (NullPointerException var3_3) {
                d d2 = new d(m2m5pcv0.b(this.a).getText().toString(), m2m5pcv0.a(this.a));
                a a2 = new a(d2);
                m2m5pcv0.c(this.a).a(a2);
                try {
                    if (m2m5pcv0.d(this.a) == null) throw new NullPointerException();
                    a a3 = new a(d2.a(), d2.b());
                    a a4 = new a(m2m5pcv0.c(this.a).d(a3), m2m5pcv0.d((m2m5pcv0)this.a).c().a, m2m5pcv0.d((m2m5pcv0)this.a).c().b);
                    m2m5pcv0.a(this.a, a4);
                    m2m5pcv0.e(this.a);
                    return;
                }
                catch (NullPointerException var6_8) {
                    return;
                }
            }
        }
    }
}

