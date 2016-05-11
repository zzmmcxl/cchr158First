package com.woop.tryreverseengineerthis;

import android.location.Location;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.woop.tryreverseengineerthis.H */
public class C0595H {
    private static List<Location> f14x5844ab43;
    private static Location f15xb050bd89;
    private static Object f16x59c6f3c8;
    String f17xe1d0aaae;

    public C0595H() {
        this.f17xe1d0aaae = "13849383";
    }

    static {
        f14x5844ab43 = new ArrayList();
        f15xb050bd89 = new Location(BuildConfig.FLAVOR);
        f16x59c6f3c8 = new Object();
    }

    public static Location m16x774cb2ff() {
        return f15xb050bd89;
    }

    public static List<Location> m17x7249ad12() {
        List<Location> l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l;
        synchronized (f16x59c6f3c8) {
            Log.d("NothingToSeeHere", "Downloading ram...");
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = f14x5844ab43;
            f14x5844ab43.clear();
        }
        return l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l;
    }

    public static void m18xd6ebf59a(Location o1o1o1o) {
        synchronized (f16x59c6f3c8) {
            Log.d("NothingToSeeHere", "Downloading ram...");
            Log.d("NothingToSeeHere", "Downloading ram...");
            f14x5844ab43.add(o1o1o1o);
            f15xb050bd89 = o1o1o1o;
        }
    }

    public static void m19x692bdd7() {
    }

    private static boolean L1L1L1L1L1L1L1(String o1o1o1o1) {
        if (o1o1o1o1.length() == 16) {
            return true;
        }
        return false;
    }

    private static boolean L1L1L1L1L1L1L1(int o1o1o1o1) {
        if ((((double) o1o1o1o1) / 2.0d) % 2.0d != 1.0d) {
            return true;
        }
        return false;
    }

    public static void m20xcbc4fd75() {
    }
}
