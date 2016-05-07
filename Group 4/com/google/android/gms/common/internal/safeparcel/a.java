/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class a {
    public static int a(int n2) {
        return 65535 & n2;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int n2) {
        if ((n2 & -65536) == -65536) return parcel.readInt();
        return 65535 & n2 >> 16;
    }

    public static Parcelable a(Parcel parcel, int n2, Parcelable.Creator creator) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable)creator.createFromParcel(parcel);
        parcel.setDataPosition(n3 + n4);
        return parcelable;
    }

    private static void a(Parcel parcel, int n2, int n3) {
        int n4 = a.a(parcel, n2);
        if (n4 == n3) return;
        throw new b("Expected size " + n3 + " got " + n4 + " (0x" + Integer.toHexString(n4) + ")", parcel);
    }

    private static void a(Parcel parcel, int n2, int n3, int n4) {
        if (n3 == n4) return;
        throw new b("Expected size " + n4 + " got " + n3 + " (0x" + Integer.toHexString(n3) + ")", parcel);
    }

    public static int b(Parcel parcel) {
        int n2 = a.a(parcel);
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (a.a(n2) != 20293) {
            throw new b("Expected object header. Got 0x" + Integer.toHexString(n2), parcel);
        }
        int n5 = n4 + n3;
        if (n5 < n4) throw new b("Size read is invalid start=" + n4 + " end=" + n5, parcel);
        if (n5 <= parcel.dataSize()) return n5;
        throw new b("Size read is invalid start=" + n4 + " end=" + n5, parcel);
    }

    public static void b(Parcel parcel, int n2) {
        parcel.setDataPosition(a.a(parcel, n2) + parcel.dataPosition());
    }

    public static Object[] b(Parcel parcel, int n2, Parcelable.Creator creator) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        Object[] arrobject = parcel.createTypedArray(creator);
        parcel.setDataPosition(n3 + n4);
        return arrobject;
    }

    public static ArrayList c(Parcel parcel, int n2, Parcelable.Creator creator) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        ArrayList arrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(n3 + n4);
        return arrayList;
    }

    public static boolean c(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        if (parcel.readInt() == 0) return false;
        return true;
    }

    public static short d(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return (short)parcel.readInt();
    }

    public static int e(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return parcel.readInt();
    }

    public static Integer f(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        if (n3 == 0) {
            return null;
        }
        a.a(parcel, n2, n3, 4);
        return parcel.readInt();
    }

    public static long g(Parcel parcel, int n2) {
        a.a(parcel, n2, 8);
        return parcel.readLong();
    }

    public static Long h(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        if (n3 == 0) {
            return null;
        }
        a.a(parcel, n2, n3, 8);
        return parcel.readLong();
    }

    public static float i(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return parcel.readFloat();
    }

    public static Float j(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        if (n3 == 0) {
            return null;
        }
        a.a(parcel, n2, n3, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double k(Parcel parcel, int n2) {
        a.a(parcel, n2, 8);
        return parcel.readDouble();
    }

    public static String l(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(n3 + n4);
        return string;
    }

    public static IBinder m(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        IBinder iBinder = parcel.readStrongBinder();
        parcel.setDataPosition(n3 + n4);
        return iBinder;
    }

    public static Bundle n(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(n3 + n4);
        return bundle;
    }

    public static byte[] o(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        byte[] arrby = parcel.createByteArray();
        parcel.setDataPosition(n3 + n4);
        return arrby;
    }

    public static String[] p(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        String[] arrstring = parcel.createStringArray();
        parcel.setDataPosition(n3 + n4);
        return arrstring;
    }

    public static ArrayList q(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n5 = parcel.readInt();
        int n6 = 0;
        do {
            if (n6 >= n5) {
                parcel.setDataPosition(n4 + n3);
                return arrayList;
            }
            arrayList.add(parcel.readInt());
            ++n6;
        } while (true);
    }

    public static ArrayList r(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        ArrayList arrayList = parcel.createStringArrayList();
        parcel.setDataPosition(n3 + n4);
        return arrayList;
    }
}

