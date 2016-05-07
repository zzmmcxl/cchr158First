/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.view.TextureView;
import com.google.android.gms.ads.internal.overlay.m;

@TargetApi(value=14)
public abstract class n
extends TextureView {
    public abstract String a();

    public abstract void a(float var1);

    public abstract void a(int var1);

    public abstract void a(m var1);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setMimeType(String var1);

    public abstract void setVideoPath(String var1);
}

