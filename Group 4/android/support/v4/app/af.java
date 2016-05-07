/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.app.ae;
import android.support.v4.app.ag;
import android.support.v4.app.ah;
import android.support.v4.app.aj;
import android.support.v4.app.bb;
import android.support.v4.app.bd;
import android.support.v4.app.x;
import android.support.v4.g.q;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class af {
    private final ag a;

    private af(ag ag2) {
        this.a = ag2;
    }

    public static final af a(ag ag2) {
        return new af(ag2);
    }

    public ah a() {
        return this.a.i();
    }

    x a(String string) {
        return this.a.d.b(string);
    }

    public View a(View view, String string, Context context, AttributeSet attributeSet) {
        return this.a.d.a(view, string, context, attributeSet);
    }

    public List a(List arrayList) {
        if (this.a.d.f == null) {
            return null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList(this.c());
        }
        arrayList.addAll(this.a.d.f);
        return arrayList;
    }

    public void a(Configuration configuration) {
        this.a.d.a(configuration);
    }

    public void a(Parcelable parcelable, List list) {
        this.a.d.a(parcelable, list);
    }

    public void a(x x2) {
        this.a.d.a(this.a, this.a, x2);
    }

    public void a(q q2) {
        this.a.a(q2);
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        this.a.b(string, fileDescriptor, printWriter, arrstring);
    }

    public void a(boolean bl2) {
        this.a.a(bl2);
    }

    public boolean a(Menu menu) {
        return this.a.d.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.d.a(menuItem);
    }

    public bb b() {
        return this.a.j();
    }

    public void b(Menu menu) {
        this.a.d.b(menu);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.d.b(menuItem);
    }

    public int c() {
        ArrayList arrayList = this.a.d.f;
        if (arrayList != null) return arrayList.size();
        return 0;
    }

    public void d() {
        this.a.d.k();
    }

    public Parcelable e() {
        return this.a.d.j();
    }

    public List f() {
        return this.a.d.i();
    }

    public void g() {
        this.a.d.l();
    }

    public void h() {
        this.a.d.m();
    }

    public void i() {
        this.a.d.n();
    }

    public void j() {
        this.a.d.o();
    }

    public void k() {
        this.a.d.p();
    }

    public void l() {
        this.a.d.q();
    }

    public void m() {
        this.a.d.r();
    }

    public void n() {
        this.a.d.t();
    }

    public void o() {
        this.a.d.u();
    }

    public boolean p() {
        return this.a.d.g();
    }

    public void q() {
        this.a.l();
    }

    public void r() {
        this.a.m();
    }

    public void s() {
        this.a.n();
    }

    public q t() {
        return this.a.o();
    }
}

