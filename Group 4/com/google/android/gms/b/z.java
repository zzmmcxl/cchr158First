/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.km;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@fi
public class z {
    public static int a(String string) {
        byte[] arrby;
        try {
            byte[] arrby2;
            arrby = arrby2 = string.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException var1_3) {
            arrby = string.getBytes();
            return km.a(arrby, 0, arrby.length, 0);
        }
        return km.a(arrby, 0, arrby.length, 0);
    }

    static boolean a(int n2) {
        if (!Character.isLetter(n2)) return false;
        if (z.a(Character.UnicodeBlock.of(n2))) return true;
        if (!z.b(n2)) return false;
        return true;
    }

    private static boolean a(Character.UnicodeBlock unicodeBlock) {
        if (unicodeBlock == Character.UnicodeBlock.BOPOMOFO) return true;
        if (unicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) return true;
        if (unicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS) return true;
        if (unicodeBlock == Character.UnicodeBlock.HANGUL_JAMO) return true;
        if (unicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) return true;
        if (unicodeBlock == Character.UnicodeBlock.HIRAGANA) return true;
        if (unicodeBlock == Character.UnicodeBlock.KATAKANA) return true;
        if (unicodeBlock != Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) return false;
        return true;
    }

    private static boolean b(int n2) {
        if (n2 >= 65382) {
            if (n2 <= 65437) return true;
        }
        if (n2 < 65441) return false;
        if (n2 > 65500) return false;
        return true;
    }

    public static String[] b(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        char[] arrc = string.toCharArray();
        int n2 = string.length();
        boolean bl2 = false;
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            int n5;
            boolean bl3;
            int n6 = Character.codePointAt(arrc, n4);
            int n7 = Character.charCount(n6);
            if (z.a(n6)) {
                if (bl2) {
                    arrayList.add(new String(arrc, n3, n4 - n3));
                }
                arrayList.add(new String(arrc, n4, n7));
                n5 = n3;
                bl3 = false;
            } else if (Character.isLetterOrDigit(n6) || Character.getType(n6) == 6 || Character.getType(n6) == 8) {
                if (!bl2) {
                    n3 = n4;
                }
                n5 = n3;
                bl3 = true;
            } else if (bl2) {
                arrayList.add(new String(arrc, n3, n4 - n3));
                n5 = n3;
                bl3 = false;
            } else {
                boolean bl4 = bl2;
                n5 = n3;
                bl3 = bl4;
            }
            n4 += n7;
            boolean bl5 = bl3;
            n3 = n5;
            bl2 = bl5;
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }
}

