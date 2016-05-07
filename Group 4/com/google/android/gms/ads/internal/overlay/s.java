/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.overlay.v;
import com.google.android.gms.b.fi;

@fi
public class s
extends FrameLayout
implements View.OnClickListener {
    private final ImageButton a;
    private final v b;

    public s(Context context, int n2, v v2) {
        super(context);
        this.b = v2;
        this.setOnClickListener((View.OnClickListener)this);
        this.a = new ImageButton(context);
        this.a.setImageResource(17301527);
        this.a.setBackgroundColor(0);
        this.a.setOnClickListener((View.OnClickListener)this);
        this.a.setPadding(0, 0, 0, 0);
        this.a.setContentDescription((CharSequence)"Interstitial close button");
        int n3 = n.a().a(context, n2);
        this.addView((View)this.a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(n3, n3, 17));
    }

    public void a(boolean bl2, boolean bl3) {
        if (!bl3) {
            this.a.setVisibility(0);
            return;
        }
        if (bl2) {
            this.a.setVisibility(4);
            return;
        }
        this.a.setVisibility(8);
    }

    public void onClick(View view) {
        if (this.b == null) return;
        this.b.c();
    }
}

