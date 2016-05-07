/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.HashMap;
import java.util.Map;

final class by
implements ce {
    by() {
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("urls");
        if (TextUtils.isEmpty((CharSequence)string)) {
            fp.d("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] arrstring = string.split(",");
        HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        PackageManager packageManager = hb2.getContext().getPackageManager();
        int n2 = arrstring.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                hb2.a("openableURLs", hashMap);
                return;
            }
            String string2 = arrstring[n3];
            String[] arrstring2 = string2.split(";", 2);
            String string3 = arrstring2[0].trim();
            String string4 = arrstring2.length > 1 ? arrstring2[1].trim() : "android.intent.action.VIEW";
            boolean bl2 = packageManager.resolveActivity(new Intent(string4, Uri.parse((String)string3)), 65536) != null;
            hashMap.put(string2, bl2);
            ++n3;
        } while (true);
    }
}

