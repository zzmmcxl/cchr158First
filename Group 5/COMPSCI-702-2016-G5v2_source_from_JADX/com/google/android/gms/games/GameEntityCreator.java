package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class GameEntityCreator implements Creator<GameEntity> {
    static void zza(GameEntity gameEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, gameEntity.getApplicationId(), false);
        zzb.zza(parcel, 2, gameEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, gameEntity.getPrimaryCategory(), false);
        zzb.zza(parcel, 4, gameEntity.getSecondaryCategory(), false);
        zzb.zza(parcel, 5, gameEntity.getDescription(), false);
        zzb.zza(parcel, 6, gameEntity.getDeveloperName(), false);
        zzb.zza(parcel, 7, gameEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        zzb.zza(parcel, 10, gameEntity.zzvx());
        zzb.zza(parcel, 11, gameEntity.zzvz());
        zzb.zza(parcel, 12, gameEntity.zzvA(), false);
        zzb.zzc(parcel, 13, gameEntity.zzvB());
        zzb.zzc(parcel, 14, gameEntity.getAchievementTotalCount());
        zzb.zzc(parcel, 15, gameEntity.getLeaderboardCount());
        zzb.zza(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        zzb.zza(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        zzb.zza(parcel, 19, gameEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 18, gameEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 21, gameEntity.isMuted());
        zzb.zza(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        zzb.zza(parcel, 23, gameEntity.areSnapshotsEnabled());
        zzb.zza(parcel, 22, gameEntity.zzvy());
        zzb.zza(parcel, 25, gameEntity.hasGamepadSupport());
        zzb.zza(parcel, 24, gameEntity.getThemeColor(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzea(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgb(i);
    }

    public GameEntity zzea(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        boolean z8 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    uri2 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    uri3 = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case Barcode.GEO /*10*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    z4 = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    str8 = zza.zzp(parcel, zzat);
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    str9 = zza.zzp(parcel, zzat);
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    str10 = zza.zzp(parcel, zzat);
                    break;
                case Place.TYPE_CASINO /*21*/:
                    z5 = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    z6 = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    z7 = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_CITY_HALL /*24*/:
                    str11 = zza.zzp(parcel, zzat);
                    break;
                case Place.TYPE_CLOTHING_STORE /*25*/:
                    z8 = zza.zzc(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11, z8);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GameEntity[] zzgb(int i) {
        return new GameEntity[i];
    }
}
