package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzsy.zzb;
import com.google.android.gms.plus.PlusShare;

public class zznt {
    public static final zzb zzaxA;
    public static final zzb zzaxB;
    public static final zzb zzaxC;
    public static final zzb zzaxD;
    public static final zzb zzaxE;
    public static final zzb zzaxF;
    public static final zzb zzaxG;
    public static final zzb zzaxH;
    public static final zzb zzaxI;
    public static final zzb zzaxJ;
    public static final zzb zzaxK;
    public static final zzb zzaxL;
    public static final zzb zzaxM;
    public static final zzb zzaxN;
    public static final zzb zzaxO;
    public static final zzb zzaxP;
    public static final zzb zzaxQ;
    public static final zzb zzaxR;
    public static final zzb zzaxS;
    public static final zzb zzaxT;
    public static final zzb zzaxU;
    public static final zzb zzaxV;
    public static final zzb zzaxW;
    public static final zzb zzaxX;
    public static final zzb zzaxY;
    public static final zzb zzaxZ;
    public static final zzb zzaxw;
    public static final zzb zzaxx;
    public static final zzb zzaxy;
    public static final zzb zzaxz;
    public static final zzb zzaya;
    public static final zzb zzayb;
    public static final zzb zzayc;
    public static final zzb zzayd;
    public static final zzb zzaye;
    public static final zzb zzayf;
    public static final zzb zzayg;
    public static final zzb zzayh;
    public static final zzb zzayi;
    public static final zzb zzayj;
    public static final zzb zzayk;
    public static final zzb zzayl;
    public static final zzb zzaym;
    public static final zzb zzayn;
    public static final zzb zzayo;
    public static final zzb zzayp;
    public static final zzb zzayq;
    public static final zzb zzayr;
    public static final zzb zzays;
    public static final zzb zzayt;
    public static final zzb zzayu;
    public static final zzb zzayv;
    public static final zzb zzayw;
    public static final zzb zzayx;
    public static final zzb zzayy;
    public static final zzb zzayz;

    static {
        zzaxw = zzdt("activity");
        zzaxx = zzdv("confidence");
        zzaxy = zzdz("activity_confidence");
        zzaxz = zzdt("steps");
        zzaxA = zzdt("duration");
        zzaxB = zzdz("activity_duration");
        zzaxC = zzdz("activity_duration.ascending");
        zzaxD = zzdz("activity_duration.descending");
        zzaxE = zzdv("bpm");
        zzaxF = zzdv("latitude");
        zzaxG = zzdv("longitude");
        zzaxH = zzdv("accuracy");
        zzaxI = zzdw("altitude");
        zzaxJ = zzdv("distance");
        zzaxK = zzdC("google.android.fitness.GoalV2");
        zzaxL = zzdv(NotificationCompatApi21.CATEGORY_PROGRESS);
        zzaxM = zzdv("height");
        zzaxN = zzdv("weight");
        zzaxO = zzdv("circumference");
        zzaxP = zzdv("percentage");
        zzaxQ = zzdv("speed");
        zzaxR = zzdv("rpm");
        zzaxS = zzdt("revolutions");
        zzaxT = zzdv(Field.NUTRIENT_CALORIES);
        zzaxU = zzdv("watts");
        zzaxV = zzdt("meal_type");
        zzaxW = zzdx("food_item");
        zzaxX = zzdz("nutrients");
        zzaxY = zzdv("elevation.change");
        zzaxZ = zzdz("elevation.gain");
        zzaya = zzdz("elevation.loss");
        zzayb = zzdv("floors");
        zzayc = zzdz("floor.gain");
        zzayd = zzdz("floor.loss");
        zzaye = zzdx("exercise");
        zzayf = zzdt("repetitions");
        zzayg = zzdv("resistance");
        zzayh = zzdt("resistance_type");
        zzayi = zzdt("num_segments");
        zzayj = zzdv("average");
        zzayk = zzdv("max");
        zzayl = zzdv("min");
        zzaym = zzdv("low_latitude");
        zzayn = zzdv("low_longitude");
        zzayo = zzdv("high_latitude");
        zzayp = zzdv("high_longitude");
        zzayq = zzdv("x");
        zzayr = zzdv("y");
        zzays = zzdv("z");
        zzayt = zzdA("timestamps");
        zzayu = zzdB("sensor_values");
        zzayv = zzdt("sensor_type");
        zzayw = zzdx("identifier");
        zzayx = zzdy("name");
        zzayy = zzdy(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        zzayz = zzdu("active_time");
    }

    private static zzb zzb(String str, int i, Boolean bool) {
        zzb com_google_android_gms_internal_zzsy_zzb = new zzb();
        com_google_android_gms_internal_zzsy_zzb.name = str;
        com_google_android_gms_internal_zzsy_zzb.zzbuG = Integer.valueOf(i);
        if (bool != null) {
            com_google_android_gms_internal_zzsy_zzb.zzbuH = bool;
        }
        return com_google_android_gms_internal_zzsy_zzb;
    }

    private static zzb zzdA(String str) {
        return zzo(str, 5);
    }

    private static zzb zzdB(String str) {
        return zzo(str, 6);
    }

    private static zzb zzdC(String str) {
        return zzo(str, 7);
    }

    private static zzb zzdt(String str) {
        return zzo(str, 1);
    }

    private static zzb zzdu(String str) {
        return zzb(str, 1, Boolean.valueOf(true));
    }

    private static zzb zzdv(String str) {
        return zzo(str, 2);
    }

    private static zzb zzdw(String str) {
        return zzb(str, 2, Boolean.valueOf(true));
    }

    private static zzb zzdx(String str) {
        return zzo(str, 3);
    }

    private static zzb zzdy(String str) {
        return zzb(str, 3, Boolean.valueOf(true));
    }

    private static zzb zzdz(String str) {
        return zzo(str, 4);
    }

    public static zzb zzo(String str, int i) {
        return zzb(str, i, null);
    }
}
