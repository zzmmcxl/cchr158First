/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import xyz.b;

public class c {
    private static String a = b.a + b.l + b.g + b.o;

    public static String a(String string) {
        try {
            Key key = c.b(a);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            return new String(cipher.doFinal(Base64.decode((String)string, (int)0)));
        }
        catch (Exception var1_4) {
            return null;
        }
    }

    private static Key b(String string) {
        try {
            byte[] arrby = string.getBytes("UTF-8");
            return new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(arrby), 16), "AES");
        }
        catch (Exception var1_3) {
            var1_3.printStackTrace();
            return null;
        }
    }
}

