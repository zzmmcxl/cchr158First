/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.Comparator;

final class mr
implements Comparator {
    mr() {
    }

    public int a(byte[] arrby, byte[] arrby2) {
        return arrby.length - arrby2.length;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((byte[])object, (byte[])object2);
    }
}

