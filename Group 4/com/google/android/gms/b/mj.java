/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.io.IOException;

public class mj
extends IOException {
    mj(int n2, int n3) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + n2 + " limit " + n3 + ").");
    }
}

