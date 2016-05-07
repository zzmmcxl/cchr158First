/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class c {
    public static int a(Parcel parcel) {
        return c.b(parcel, 20293);
    }

    public static void a(Parcel parcel, int n2) {
        c.c(parcel, n2);
    }

    public static void a(Parcel parcel, int n2, double d2) {
        c.b(parcel, n2, 8);
        parcel.writeDouble(d2);
    }

    public static void a(Parcel parcel, int n2, float f2) {
        c.b(parcel, n2, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int n2, int n3) {
        c.b(parcel, n2, 4);
        parcel.writeInt(n3);
    }

    public static void a(Parcel parcel, int n2, long l2) {
        c.b(parcel, n2, 8);
        parcel.writeLong(l2);
    }

    public static void a(Parcel parcel, int n2, Bundle bundle, boolean bl2) {
        if (bundle == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        parcel.writeBundle(bundle);
        c.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, IBinder iBinder, boolean bl2) {
        if (iBinder == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        parcel.writeStrongBinder(iBinder);
        c.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, Parcelable parcelable, int n3, boolean bl2) {
        if (parcelable == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n4 = c.b(parcel, n2);
        parcelable.writeToParcel(parcel, n3);
        c.c(parcel, n4);
    }

    public static void a(Parcel parcel, int n2, Float f2, boolean bl2) {
        if (f2 == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        c.b(parcel, n2, 4);
        parcel.writeFloat(f2.floatValue());
    }

    public static void a(Parcel parcel, int n2, Integer n3, boolean bl2) {
        if (n3 == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        c.b(parcel, n2, 4);
        parcel.writeInt(n3.intValue());
    }

    public static void a(Parcel parcel, int n2, Long l2, boolean bl2) {
        if (l2 == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        c.b(parcel, n2, 8);
        parcel.writeLong(l2.longValue());
    }

    public static void a(Parcel parcel, int n2, String string, boolean bl2) {
        if (string == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        parcel.writeString(string);
        c.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, List list, boolean bl2) {
        if (list == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        int n4 = list.size();
        parcel.writeInt(n4);
        int n5 = 0;
        do {
            if (n5 >= n4) {
                c.c(parcel, n3);
                return;
            }
            parcel.writeInt(((Integer)list.get(n5)).intValue());
            ++n5;
        } while (true);
    }

    public static void a(Parcel parcel, int n2, short s2) {
        c.b(parcel, n2, 4);
        parcel.writeInt((int)s2);
    }

    public static void a(Parcel parcel, int n2, boolean bl2) {
        c.b(parcel, n2, 4);
        int n3 = bl2 ? 1 : 0;
        parcel.writeInt(n3);
    }

    public static void a(Parcel parcel, int n2, byte[] arrby, boolean bl2) {
        if (arrby == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        parcel.writeByteArray(arrby);
        c.c(parcel, n3);
    }

    public static void a(Parcel parcel, int n2, Parcelable[] arrparcelable, int n3, boolean bl2) {
        if (arrparcelable == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n4 = c.b(parcel, n2);
        int n5 = arrparcelable.length;
        parcel.writeInt(n5);
        int n6 = 0;
        do {
            if (n6 >= n5) {
                c.c(parcel, n4);
                return;
            }
            Parcelable parcelable = arrparcelable[n6];
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                c.a(parcel, parcelable, n3);
            }
            ++n6;
        } while (true);
    }

    public static void a(Parcel parcel, int n2, String[] arrstring, boolean bl2) {
        if (arrstring == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        parcel.writeStringArray(arrstring);
        c.c(parcel, n3);
    }

    private static void a(Parcel parcel, Parcelable parcelable, int n2) {
        int n3 = parcel.dataPosition();
        parcel.writeInt(1);
        int n4 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, n2);
        int n5 = parcel.dataPosition();
        parcel.setDataPosition(n3);
        parcel.writeInt(n5 - n4);
        parcel.setDataPosition(n5);
    }

    private static int b(Parcel parcel, int n2) {
        parcel.writeInt(-65536 | n2);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int n2, int n3) {
        if (n3 >= 65535) {
            parcel.writeInt(-65536 | n2);
            parcel.writeInt(n3);
            return;
        }
        parcel.writeInt(n2 | n3 << 16);
    }

    public static void b(Parcel parcel, int n2, List list, boolean bl2) {
        if (list == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        parcel.writeStringList(list);
        c.c(parcel, n3);
    }

    private static void c(Parcel parcel, int n2) {
        int n3 = parcel.dataPosition();
        int n4 = n3 - n2;
        parcel.setDataPosition(n2 - 4);
        parcel.writeInt(n4);
        parcel.setDataPosition(n3);
    }

    public static void c(Parcel parcel, int n2, List list, boolean bl2) {
        if (list == null) {
            if (!bl2) return;
            c.b(parcel, n2, 0);
            return;
        }
        int n3 = c.b(parcel, n2);
        int n4 = list.size();
        parcel.writeInt(n4);
        int n5 = 0;
        do {
            if (n5 >= n4) {
                c.c(parcel, n3);
                return;
            }
            Parcelable parcelable = (Parcelable)list.get(n5);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                c.a(parcel, parcelable, 0);
            }
            ++n5;
        } while (true);
    }
}

