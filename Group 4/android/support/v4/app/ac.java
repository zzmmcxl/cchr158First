/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.ag;
import android.support.v4.app.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ac
extends ag {
    final /* synthetic */ aa a;

    public ac(aa aa2) {
        this.a = aa2;
        super(aa2);
    }

    @Override
    public View a(int n2) {
        return this.a.findViewById(n2);
    }

    @Override
    public void a(x x2, Intent intent, int n2, Bundle bundle) {
        this.a.a(x2, intent, n2, bundle);
    }

    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        this.a.dump(string, fileDescriptor, printWriter, arrstring);
    }

    @Override
    public boolean a() {
        Window window = this.a.getWindow();
        if (window == null) return false;
        if (window.peekDecorView() == null) return false;
        return true;
    }

    @Override
    public boolean a(x x2) {
        if (this.a.isFinishing()) return false;
        return true;
    }

    @Override
    public LayoutInflater b() {
        return this.a.getLayoutInflater().cloneInContext((Context)this.a);
    }

    @Override
    public void b(x x2) {
        this.a.a(x2);
    }

    @Override
    public void c() {
        this.a.d();
    }

    @Override
    public boolean d() {
        if (this.a.getWindow() == null) return false;
        return true;
    }

    @Override
    public int e() {
        Window window = this.a.getWindow();
        if (window != null) return window.getAttributes().windowAnimations;
        return 0;
    }
}

