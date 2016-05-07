/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.kt;
import com.google.android.gms.b.lt;

public class bo
implements kt {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public bo() {
        this(2500, 1, 1.0f);
    }

    public bo(int n2, int n3, float f2) {
        this.a = n2;
        this.c = n3;
        this.d = f2;
    }

    @Override
    public int a() {
        return this.a;
    }

    @Override
    public void a(lt lt2) {
        this.b = 1 + this.b;
        this.a = (int)((float)this.a + (float)this.a * this.d);
        if (this.c()) return;
        throw lt2;
    }

    @Override
    public int b() {
        return this.b;
    }

    protected boolean c() {
        if (this.b > this.c) return false;
        return true;
    }
}

