/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import com.google.android.gms.b.fz;
import com.google.android.gms.b.ga;

@TargetApi(value=9)
public class gb
extends fz {
    public gb() {
        super(null);
    }

    @Override
    public int a() {
        return 6;
    }

    @Override
    public boolean a(DownloadManager.Request request) {
        request.setShowRunningNotification(true);
        return true;
    }

    @Override
    public int b() {
        return 7;
    }
}

