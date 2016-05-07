/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

class ak {
    int a;
    int b;
    Object c;
    int d;

    ak(int n2, int n3, int n4, Object object) {
        this.a = n2;
        this.b = n3;
        this.d = n4;
        this.c = object;
    }

    String a() {
        switch (this.a) {
            default: {
                return "??";
            }
            case 1: {
                return "add";
            }
            case 2: {
                return "rm";
            }
            case 4: {
                return "up";
            }
            case 8: 
        }
        return "mv";
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ak ak2 = (ak)object;
        if (this.a != ak2.a) {
            return false;
        }
        if (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == ak2.b) {
            if (this.b == ak2.d) return true;
        }
        if (this.d != ak2.d) {
            return false;
        }
        if (this.b != ak2.b) {
            return false;
        }
        if (this.c != null) {
            if (this.c.equals(ak2.c)) return true;
            return false;
        }
        if (ak2.c == null) return true;
        return false;
    }

    public int hashCode() {
        return 31 * (31 * this.a + this.b) + this.d;
    }

    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + "[" + this.a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
    }
}

