/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.b.ld;
import com.google.android.gms.common.internal.bf;

class bm {
    final boolean a;
    final int b;
    long c;
    float d;
    long e;
    float f;
    long g;
    float h;
    final boolean i;

    /*
     * Unable to fully structure code
     */
    public bm(ld var1_1) {
        var2_2 = true;
        super();
        bf.a(var1_1);
        if (var1_1.a != null && var1_1.a != 0) ** GOTO lbl7
        var4_3 = false;
        ** GOTO lbl15
lbl7: // 1 sources:
        if (var1_1.a == 4) ** GOTO lbl11
        if (var1_1.c != null) ** GOTO lbl-1000
        var4_3 = false;
        ** GOTO lbl15
lbl11: // 1 sources:
        if (var1_1.d == null || var1_1.e == null) {
            var4_3 = false;
        } else lbl-1000: // 2 sources:
        {
            var4_3 = var2_2;
        }
lbl15: // 4 sources:
        if (var4_3) {
            this.b = var1_1.a;
            if (var1_1.b == null || !var1_1.b.booleanValue()) {
                var2_2 = false;
            }
            this.a = var2_2;
            if (var1_1.a == 4) {
                if (this.a) {
                    this.f = Float.parseFloat(var1_1.d);
                    this.h = Float.parseFloat(var1_1.e);
                } else {
                    this.e = Long.parseLong(var1_1.d);
                    this.g = Long.parseLong(var1_1.e);
                }
            } else if (this.a) {
                this.d = Float.parseFloat(var1_1.c);
            } else {
                this.c = Long.parseLong(var1_1.c);
            }
        } else {
            this.b = 0;
            this.a = false;
        }
        this.i = var4_3;
    }

    public Boolean a(float f2) {
        boolean bl2 = true;
        if (!this.i) {
            return null;
        }
        if (!this.a) {
            return null;
        }
        switch (this.b) {
            default: {
                return null;
            }
            case 1: {
                if (f2 < this.d) {
                    return bl2;
                }
                bl2 = false;
                return bl2;
            }
            case 2: {
                if (f2 > this.d) {
                    return bl2;
                }
                bl2 = false;
                return bl2;
            }
            case 3: {
                boolean bl3;
                if (f2 != this.d) {
                    float f3 = Math.abs(f2 - this.d) FCMPG 2.0f * Math.max(Math.ulp(f2), Math.ulp(this.d));
                    bl3 = false;
                    if (f3 >= 0) return bl3;
                }
                bl3 = bl2;
                return bl3;
            }
            case 4: 
        }
        if (f2 >= this.f && f2 <= this.h) {
            return bl2;
        }
        bl2 = false;
        return bl2;
    }

    public Boolean a(long l2) {
        boolean bl2 = true;
        if (!this.i) {
            return null;
        }
        if (this.a) {
            return null;
        }
        switch (this.b) {
            default: {
                return null;
            }
            case 1: {
                if (l2 < this.c) {
                    return bl2;
                }
                bl2 = false;
                return bl2;
            }
            case 2: {
                if (l2 > this.c) {
                    return bl2;
                }
                bl2 = false;
                return bl2;
            }
            case 3: {
                if (l2 == this.c) {
                    return bl2;
                }
                bl2 = false;
                return bl2;
            }
            case 4: 
        }
        if (l2 >= this.e && l2 <= this.g) {
            return bl2;
        }
        bl2 = false;
        return bl2;
    }
}

