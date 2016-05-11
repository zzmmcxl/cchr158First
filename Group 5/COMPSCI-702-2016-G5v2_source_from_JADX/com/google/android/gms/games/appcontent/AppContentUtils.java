package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

public final class AppContentUtils {

    private interface AppContentRunner {
        void zzb(ArrayList<DataHolder> arrayList, int i);
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.1 */
    static class C07711 implements AppContentRunner {
        final /* synthetic */ ArrayList zzaDR;

        C07711(ArrayList arrayList) {
            this.zzaDR = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzaDR.add(new AppContentActionRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.2 */
    static class C07722 implements AppContentRunner {
        final /* synthetic */ ArrayList zzaDR;

        C07722(ArrayList arrayList) {
            this.zzaDR = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzaDR.add(new AppContentAnnotationRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.3 */
    static class C07733 implements AppContentRunner {
        final /* synthetic */ ArrayList zzaDR;

        C07733(ArrayList arrayList) {
            this.zzaDR = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzaDR.add(new AppContentConditionRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.4 */
    static class C07744 implements AppContentRunner {
        final /* synthetic */ DataHolder zzaDS;
        final /* synthetic */ Bundle zzaDT;

        C07744(DataHolder dataHolder, Bundle bundle) {
            this.zzaDS = dataHolder;
            this.zzaDT = bundle;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            AppContentTuple appContentTupleRef = new AppContentTupleRef(this.zzaDS, i);
            this.zzaDT.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
        }
    }

    public static ArrayList<AppContentAction> zza(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 1, str2, "action_id", i, new C07711(arrayList2), arrayList);
        return arrayList2;
    }

    private static void zza(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object zzd = dataHolder.zzd(str, i2, dataHolder.zzbH(i2));
        if (!TextUtils.isEmpty(zzd)) {
            int count = dataHolder2.getCount();
            String[] split = zzd.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence zzd2 = dataHolder2.zzd(str2, i3, dataHolder2.zzbH(i3));
                if (!TextUtils.isEmpty(zzd2) && zzmn.zzb(split, zzd2)) {
                    appContentRunner.zzb(arrayList, i3);
                }
            }
        }
    }

    public static ArrayList<AppContentAnnotation> zzb(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 2, str2, "annotation_id", i, new C07722(arrayList2), arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> zzc(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 4, str2, "condition_id", i, new C07733(arrayList2), arrayList);
        return arrayList2;
    }

    public static Bundle zzd(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        Bundle bundle = new Bundle();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 3, str2, "tuple_id", i, new C07744((DataHolder) arrayList.get(3), bundle), arrayList);
        return bundle;
    }
}
