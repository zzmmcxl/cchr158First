/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.webkit.WebSettings;
import com.google.android.gms.b.gh;

@TargetApi(value=17)
public class gf
extends gh {
    @Override
    public Drawable a(Context context, Bitmap bitmap, boolean bl2, float f2) {
        if (!bl2) return new BitmapDrawable(context.getResources(), bitmap);
        if (f2 <= 0.0f) return new BitmapDrawable(context.getResources(), bitmap);
        if (f2 > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (boolean)false);
            Bitmap bitmap3 = Bitmap.createBitmap((Bitmap)bitmap2);
            RenderScript renderScript = RenderScript.create((Context)context);
            ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)renderScript, (Element)Element.U8_4((RenderScript)renderScript));
            Allocation allocation = Allocation.createFromBitmap((RenderScript)renderScript, (Bitmap)bitmap2);
            Allocation allocation2 = Allocation.createFromBitmap((RenderScript)renderScript, (Bitmap)bitmap3);
            scriptIntrinsicBlur.setRadius(f2);
            scriptIntrinsicBlur.setInput(allocation);
            scriptIntrinsicBlur.forEach(allocation2);
            allocation2.copyTo(bitmap3);
            return new BitmapDrawable(context.getResources(), bitmap3);
        }
        catch (RuntimeException var5_12) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    @Override
    public String a(Context context) {
        return WebSettings.getDefaultUserAgent((Context)context);
    }

    @Override
    public boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }
}

