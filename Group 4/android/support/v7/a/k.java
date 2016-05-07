/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v7.a.e;
import android.support.v7.a.l;
import android.support.v7.a.m;
import android.support.v7.a.n;
import android.support.v7.a.o;
import android.support.v7.a.p;
import android.support.v7.a.r;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class k {
    public int A;
    public boolean B = false;
    public boolean[] C;
    public boolean D;
    public boolean E;
    public int F = -1;
    public DialogInterface.OnMultiChoiceClickListener G;
    public Cursor H;
    public String I;
    public String J;
    public AdapterView.OnItemSelectedListener K;
    public p L;
    public boolean M = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public DialogInterface.OnClickListener j;
    public CharSequence k;
    public DialogInterface.OnClickListener l;
    public CharSequence m;
    public DialogInterface.OnClickListener n;
    public boolean o;
    public DialogInterface.OnCancelListener p;
    public DialogInterface.OnDismissListener q;
    public DialogInterface.OnKeyListener r;
    public CharSequence[] s;
    public ListAdapter t;
    public DialogInterface.OnClickListener u;
    public int v;
    public View w;
    public int x;
    public int y;
    public int z;

    public k(Context context) {
        this.a = context;
        this.o = true;
        this.b = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    private void b(e e2) {
        Object object;
        ListView listView = (ListView)this.b.inflate(e.k(e2), null);
        if (this.D) {
            object = this.H == null ? new l(this, this.a, e.l(e2), 16908308, this.s, listView) : new Object(this, this.a, this.H, false, listView, e2);
        } else {
            int n2 = this.E ? e.m(e2) : e.n(e2);
            if (this.H != null) {
                Context context = this.a;
                Cursor cursor = this.H;
                String[] arrstring = new String[]{this.I};
                object = new SimpleCursorAdapter(context, n2, cursor, arrstring, new int[]{16908308});
            } else {
                object = this.t != null ? this.t : new r(this.a, n2, 16908308, this.s);
            }
        }
        if (this.L != null) {
            this.L.a(listView);
        }
        e.a(e2, (ListAdapter)object);
        e.a(e2, this.F);
        if (this.u != null) {
            listView.setOnItemClickListener((AdapterView.OnItemClickListener)new n(this, e2));
        } else if (this.G != null) {
            listView.setOnItemClickListener((AdapterView.OnItemClickListener)new o(this, listView, e2));
        }
        if (this.K != null) {
            listView.setOnItemSelectedListener(this.K);
        }
        if (this.E) {
            listView.setChoiceMode(1);
        } else if (this.D) {
            listView.setChoiceMode(2);
        }
        e.a(e2, listView);
    }

    public void a(e e2) {
        if (this.g != null) {
            e2.b(this.g);
        } else {
            if (this.f != null) {
                e2.a(this.f);
            }
            if (this.d != null) {
                e2.a(this.d);
            }
            if (this.c != 0) {
                e2.b(this.c);
            }
            if (this.e != 0) {
                e2.b(e2.c(this.e));
            }
        }
        if (this.h != null) {
            e2.b(this.h);
        }
        if (this.i != null) {
            e2.a(-1, this.i, this.j, null);
        }
        if (this.k != null) {
            e2.a(-2, this.k, this.l, null);
        }
        if (this.m != null) {
            e2.a(-3, this.m, this.n, null);
        }
        if (this.s != null || this.H != null || this.t != null) {
            this.b(e2);
        }
        if (this.w == null) {
            if (this.v == 0) return;
            e2.a(this.v);
            return;
        }
        if (this.B) {
            e2.a(this.w, this.x, this.y, this.z, this.A);
            return;
        }
        e2.c(this.w);
    }
}

