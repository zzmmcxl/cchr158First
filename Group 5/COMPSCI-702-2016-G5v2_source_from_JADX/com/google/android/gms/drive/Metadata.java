package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznq;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public String getAlternateLink() {
        return (String) zza(zznm.zzasV);
    }

    public int getContentAvailability() {
        Integer num = (Integer) zza(zznq.zzatT);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) zza(zzno.zzatM);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zznm.zzasW);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zztz();
    }

    public String getDescription() {
        return (String) zza(zznm.zzasX);
    }

    public DriveId getDriveId() {
        return (DriveId) zza(zznm.zzasU);
    }

    public String getEmbedLink() {
        return (String) zza(zznm.zzasY);
    }

    public String getFileExtension() {
        return (String) zza(zznm.zzasZ);
    }

    public long getFileSize() {
        return ((Long) zza(zznm.zzata)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) zza(zzno.zzatN);
    }

    public String getMimeType() {
        return (String) zza(zznm.zzatr);
    }

    public Date getModifiedByMeDate() {
        return (Date) zza(zzno.zzatP);
    }

    public Date getModifiedDate() {
        return (Date) zza(zzno.zzatO);
    }

    public String getOriginalFilename() {
        return (String) zza(zznm.zzats);
    }

    public long getQuotaBytesUsed() {
        return ((Long) zza(zznm.zzatx)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) zza(zzno.zzatQ);
    }

    public String getTitle() {
        return (String) zza(zznm.zzatA);
    }

    public String getWebContentLink() {
        return (String) zza(zznm.zzatC);
    }

    public String getWebViewLink() {
        return (String) zza(zznm.zzatD);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zznm.zzatg);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zznm.zzath);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zznm.zzate);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zznq.zzatU);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zznm.zzatj);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zznm.zzatl);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) zza(zznm.zzatm);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zznm.zzaty);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zznm.zzatp);
        return bool == null ? true : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zznm.zzatB);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zznm.zzatq);
        return bool == null ? false : bool.booleanValue();
    }

    public abstract <T> T zza(MetadataField<T> metadataField);
}
