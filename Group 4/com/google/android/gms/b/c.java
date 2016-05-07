/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fk;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.jk;
import com.google.android.gms.b.jl;
import com.google.android.gms.b.jm;
import com.google.android.gms.b.my;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class c
extends hy {
    private final jm a;

    public c(int n2, String string, jm jm2, jl jl2) {
        super(n2, string, jl2);
        this.a = jm2;
    }

    public c(String string, jm jm2, jl jl2) {
        this(0, string, jm2, jl2);
    }

    @Override
    protected jk a(fk fk2) {
        String string;
        try {
            string = new String(fk2.b, my.a(fk2.c));
        }
        catch (UnsupportedEncodingException var3_3) {
            string = new String(fk2.b);
            return jk.a(string, my.a(fk2));
        }
        return jk.a(string, my.a(fk2));
    }

    @Override
    protected /* synthetic */ void a(Object object) {
        this.a((String)object);
    }

    protected void a(String string) {
        this.a.a(string);
    }
}

