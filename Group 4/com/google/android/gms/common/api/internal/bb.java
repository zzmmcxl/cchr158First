/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ba;
import com.google.android.gms.common.api.internal.bc;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class bb
implements r {
    public final int a;
    public final n b;
    public final r c;
    final /* synthetic */ ba d;

    public bb(ba ba2, int n2, n n3, r r2) {
        this.d = ba2;
        this.a = n2;
        this.b = n3;
        this.c = r2;
        n3.a(this);
    }

    public void a() {
        this.b.b(this);
        this.b.g();
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        ba.c(this.d).post((Runnable)new bc(this.d, this.a, connectionResult));
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.append(string).append("GoogleApiClient #").print(this.a);
        printWriter.println(":");
        this.b.a(string + "  ", fileDescriptor, printWriter, arrstring);
    }
}

