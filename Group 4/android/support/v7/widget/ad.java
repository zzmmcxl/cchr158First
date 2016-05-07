/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ad {
    public final ComponentName a;
    public final long b;
    public final float c;

    public ad(ComponentName componentName, long l2, float f2) {
        this.a = componentName;
        this.b = l2;
        this.c = f2;
    }

    public ad(String string, long l2, float f2) {
        this(ComponentName.unflattenFromString((String)string), l2, f2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ad ad2 = (ad)object;
        if (this.a == null ? ad2.a != null : !this.a.equals((Object)ad2.a)) {
            return false;
        }
        if (this.b != ad2.b) {
            return false;
        }
        if (Float.floatToIntBits(this.c) == Float.floatToIntBits(ad2.c)) return true;
        return false;
    }

    public int hashCode() {
        int n2;
        if (this.a == null) {
            n2 = 0;
            return 31 * (31 * (n2 + 31) + (int)(this.b ^ this.b >>> 32)) + Float.floatToIntBits(this.c);
        }
        n2 = this.a.hashCode();
        return 31 * (31 * (n2 + 31) + (int)(this.b ^ this.b >>> 32)) + Float.floatToIntBits(this.c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append((Object)this.a);
        stringBuilder.append("; time:").append(this.b);
        stringBuilder.append("; weight:").append(new BigDecimal(this.c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

