/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import org.json.JSONException;
import org.json.JSONObject;

@fi
public class g {
    public int a(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object object = intent.getExtras().get("RESPONSE_CODE");
        if (object == null) {
            fp.d("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (object instanceof Integer) {
            return (Integer)object;
        }
        if (object instanceof Long) {
            return (int)((Long)object).longValue();
        }
        fp.d("Unexpected type for intent response code. " + object.getClass().getName());
        return 5;
    }

    public int a(Bundle bundle) {
        Object object = bundle.get("RESPONSE_CODE");
        if (object == null) {
            fp.d("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (object instanceof Integer) {
            return (Integer)object;
        }
        if (object instanceof Long) {
            return (int)((Long)object).longValue();
        }
        fp.d("Unexpected type for intent response code. " + object.getClass().getName());
        return 5;
    }

    public String a(String string) {
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string).getString("developerPayload");
        }
        catch (JSONException var2_3) {
            fp.d("Fail to parse purchase data");
            return null;
        }
    }

    public String b(Intent intent) {
        if (intent != null) return intent.getStringExtra("INAPP_PURCHASE_DATA");
        return null;
    }

    public String c(Intent intent) {
        if (intent != null) return intent.getStringExtra("INAPP_DATA_SIGNATURE");
        return null;
    }
}

