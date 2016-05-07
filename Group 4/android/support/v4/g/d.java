/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

public class d {
    public static void a(Object object, StringBuilder stringBuilder) {
        int n2;
        if (object == null) {
            stringBuilder.append("null");
            return;
        }
        String string = object.getClass().getSimpleName();
        if ((string == null || string.length() <= 0) && (n2 = (string = object.getClass().getName()).lastIndexOf(46)) > 0) {
            string = string.substring(n2 + 1);
        }
        stringBuilder.append(string);
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(object)));
    }
}

