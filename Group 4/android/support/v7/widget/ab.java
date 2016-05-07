/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import android.support.v7.widget.z;
import java.math.BigDecimal;

public final class ab
implements Comparable {
    public final ResolveInfo a;
    public float b;
    final /* synthetic */ z c;

    public ab(z z2, ResolveInfo resolveInfo) {
        this.c = z2;
        this.a = resolveInfo;
    }

    public int a(ab ab2) {
        return Float.floatToIntBits(ab2.b) - Float.floatToIntBits(this.b);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((ab)object);
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
        ab ab2 = (ab)object;
        if (Float.floatToIntBits(this.b) == Float.floatToIntBits(ab2.b)) return true;
        return false;
    }

    public int hashCode() {
        return 31 + Float.floatToIntBits(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal(this.b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

