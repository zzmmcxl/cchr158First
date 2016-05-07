/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.appinvite;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.google.android.gms.appinvite.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PreviewActivity
extends Activity {
    private View a(Context context, ViewGroup viewGroup, Bundle bundle) {
        int n2 = bundle.getInt("com.google.android.gms.appinvite.LAYOUT_RES_ID");
        View view = LayoutInflater.from((Context)context).inflate(n2, viewGroup, false);
        ArrayList arrayList = bundle.getParcelableArrayList("com.google.android.gms.appinvite.VIEWS");
        if (arrayList == null) return view;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            this.a(view, (Bundle)iterator.next());
        }
        return view;
    }

    /*
     * Unable to fully structure code
     */
    private void a(View var1_1, Bundle var2_2) {
        var3_3 = var1_1.findViewById(var2_2.getInt("View_id"));
        var4_4 = var2_2.keySet().iterator();
        block24 : while (var4_4.hasNext() != false) {
            var5_5 = (String)var4_4.next();
            switch (var5_5.hashCode()) {
                case 966644059: {
                    if (!var5_5.equals("View_backgroundColor")) ** GOTO lbl30
                    var6_6 = 0;
                    ** GOTO lbl37
                }
                case -1829808865: {
                    if (!var5_5.equals("View_minHeight")) ** GOTO lbl30
                    var6_6 = 1;
                    ** GOTO lbl37
                }
                case 1920443715: {
                    if (!var5_5.equals("View_onClickListener")) ** GOTO lbl30
                    var6_6 = 2;
                    ** GOTO lbl37
                }
                case -499175494: {
                    if (!var5_5.equals("TextView_text")) ** GOTO lbl30
                    var6_6 = 3;
                    ** GOTO lbl37
                }
                case 573559753: {
                    if (!var5_5.equals("TextView_textColor")) ** GOTO lbl30
                    var6_6 = 4;
                    ** GOTO lbl37
                }
                case 1729346977: {
                    if (!var5_5.equals("TextView_isTitle")) ** GOTO lbl30
                    var6_6 = 5;
                    ** GOTO lbl37
                }
lbl30: // 7 sources:
                default: {
                    ** GOTO lbl-1000
                }
                case -111184848: 
            }
            if (var5_5.equals("WebView_data")) {
                var6_6 = 6;
            } else lbl-1000: // 2 sources:
            {
                var6_6 = -1;
            }
lbl37: // 8 sources:
            switch (var6_6) {
                default: {
                    continue block24;
                }
                case 0: {
                    var3_3.setBackgroundColor(var2_2.getInt(var5_5));
                    continue block24;
                }
                case 1: {
                    var3_3.setMinimumHeight(var2_2.getInt(var5_5));
                    continue block24;
                }
                case 2: {
                    var8_8 = var2_2.getString(var5_5);
                    switch (var8_8.hashCode()) {
                        default: {
                            break;
                        }
                        case 94756344: {
                            if (!var8_8.equals("close")) break;
                            var9_9 = 0;
                            ** GOTO lbl56
                        }
                    }
                    var9_9 = -1;
lbl56: // 2 sources:
                    switch (var9_9) {
                        default: {
                            continue block24;
                        }
                        case 0: 
                    }
                    var3_3.setOnClickListener((View.OnClickListener)new a(this));
                    continue block24;
                }
                case 3: {
                    if (!(var3_3 instanceof TextView)) continue block24;
                    ((TextView)var3_3).setText(var2_2.getCharSequence(var5_5));
                    continue block24;
                }
                case 4: {
                    if (!(var3_3 instanceof TextView)) continue block24;
                    ((TextView)var3_3).setTextColor(var2_2.getInt(var5_5));
                    continue block24;
                }
                case 5: {
                    if (!(var3_3 instanceof TextView) || !var2_2.getBoolean(var5_5)) continue block24;
                    this.setTitle(((TextView)var3_3).getText());
                    continue block24;
                }
                case 6: 
            }
            if (!(var3_3 instanceof ViewGroup)) continue;
            var7_7 = new WebView((Context)this);
            var7_7.loadData(var2_2.getString(var5_5), "text/html; charset=utf-8", "UTF-8");
            ((ViewGroup)var3_3).addView((View)var7_7, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    protected void onCreate(Bundle bundle) {
        Context context;
        super.onCreate(bundle);
        if (this.getCallingActivity() == null || !"com.google.android.gms".equals(this.getCallingActivity().getPackageName())) {
            this.finish();
            return;
        }
        try {
            context = this.createPackageContext("com.google.android.gms", 0);
        }
        catch (PackageManager.NameNotFoundException var2_5) {
            this.finish();
            return;
        }
        Bundle bundle2 = this.getIntent().getExtras();
        View view = this.a(context, null, bundle2);
        if (view == null) {
            this.finish();
            return;
        }
        TabHost tabHost = (TabHost)view.findViewById(16908306);
        TabWidget tabWidget = (TabWidget)view.findViewById(16908307);
        ArrayList arrayList = bundle2.getParcelableArrayList("com.google.android.gms.appinvite.TABS");
        if (tabHost != null && tabWidget != null && arrayList != null) {
            tabHost.setup();
            for (Bundle bundle3 : arrayList) {
                TabHost.TabSpec tabSpec = tabHost.newTabSpec(bundle3.getString("tabTag"));
                tabSpec.setContent(bundle3.getInt("tabContentId"));
                tabSpec.setIndicator(this.a(context, (ViewGroup)tabWidget, bundle3));
                tabHost.addTab(tabSpec);
            }
        }
        this.setContentView(view);
    }
}

