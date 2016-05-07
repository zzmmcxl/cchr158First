/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class mx
extends HttpEntityEnclosingRequestBase {
    public mx() {
    }

    public mx(String string) {
        this.setURI(URI.create(string));
    }

    public String getMethod() {
        return "PATCH";
    }
}

