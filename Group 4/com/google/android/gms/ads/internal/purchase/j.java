/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

@fi
public class j {
    public static PublicKey a(String string) {
        try {
            byte[] arrby = Base64.decode((String)string, (int)0);
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrby));
        }
        catch (NoSuchAlgorithmException var2_3) {
            throw new RuntimeException(var2_3);
        }
        catch (InvalidKeySpecException var1_4) {
            fp.b("Invalid key specification.");
            throw new IllegalArgumentException(var1_4);
        }
    }

    public static boolean a(String string, String string2, String string3) {
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string)) {
            if (!TextUtils.isEmpty((CharSequence)string3)) return j.a(j.a(string), string2, string3);
        }
        fp.b("Purchase verification failed: missing data.");
        return false;
    }

    public static boolean a(PublicKey publicKey, String string, String string2) {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(string.getBytes());
            if (signature.verify(Base64.decode((String)string2, (int)0))) return true;
            fp.b("Signature verification failed.");
            return false;
        }
        catch (NoSuchAlgorithmException var5_4) {
            fp.b("NoSuchAlgorithmException.");
            return false;
        }
        catch (InvalidKeyException var4_5) {
            fp.b("Invalid key specification.");
            return false;
        }
        catch (SignatureException var3_6) {
            fp.b("Signature exception.");
            return false;
        }
    }
}

