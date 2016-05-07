/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.io.IOException;

public class ml
extends IOException {
    public ml(String string) {
        super(string);
    }

    static ml a() {
        return new ml("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ml b() {
        return new ml("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ml c() {
        return new ml("CodedInputStream encountered a malformed varint.");
    }

    static ml d() {
        return new ml("Protocol message contained an invalid tag (zero).");
    }

    static ml e() {
        return new ml("Protocol message end-group tag did not match expected tag.");
    }

    static ml f() {
        return new ml("Protocol message tag had invalid wire type.");
    }

    static ml g() {
        return new ml("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}

