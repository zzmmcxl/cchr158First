package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR;
    private static final HashMap<String, Field<?, ?>> zzbeM;
    String mName;
    final int mVersionCode;
    String zzF;
    String zzJN;
    double zzaNF;
    double zzaNG;
    String zzaxl;
    final Set<Integer> zzbeN;
    ItemScopeEntity zzbeO;
    List<String> zzbeP;
    ItemScopeEntity zzbeQ;
    String zzbeR;
    String zzbeS;
    String zzbeT;
    List<ItemScopeEntity> zzbeU;
    int zzbeV;
    List<ItemScopeEntity> zzbeW;
    ItemScopeEntity zzbeX;
    List<ItemScopeEntity> zzbeY;
    String zzbeZ;
    String zzbfA;
    String zzbfB;
    String zzbfC;
    ItemScopeEntity zzbfD;
    String zzbfE;
    String zzbfF;
    String zzbfG;
    String zzbfH;
    String zzbfa;
    ItemScopeEntity zzbfb;
    String zzbfc;
    String zzbfd;
    List<ItemScopeEntity> zzbfe;
    String zzbff;
    String zzbfg;
    String zzbfh;
    String zzbfi;
    String zzbfj;
    String zzbfk;
    String zzbfl;
    String zzbfm;
    ItemScopeEntity zzbfn;
    String zzbfo;
    String zzbfp;
    String zzbfq;
    ItemScopeEntity zzbfr;
    ItemScopeEntity zzbfs;
    ItemScopeEntity zzbft;
    List<ItemScopeEntity> zzbfu;
    String zzbfv;
    String zzbfw;
    String zzbfx;
    String zzbfy;
    ItemScopeEntity zzbfz;
    String zztZ;
    String zzyv;

    static {
        CREATOR = new zza();
        zzbeM = new HashMap();
        zzbeM.put("about", Field.zza("about", 2, ItemScopeEntity.class));
        zzbeM.put("additionalName", Field.zzm("additionalName", 3));
        zzbeM.put("address", Field.zza("address", 4, ItemScopeEntity.class));
        zzbeM.put("addressCountry", Field.zzl("addressCountry", 5));
        zzbeM.put("addressLocality", Field.zzl("addressLocality", 6));
        zzbeM.put("addressRegion", Field.zzl("addressRegion", 7));
        zzbeM.put("associated_media", Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzbeM.put("attendeeCount", Field.zzi("attendeeCount", 9));
        zzbeM.put("attendees", Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzbeM.put("audio", Field.zza("audio", 11, ItemScopeEntity.class));
        zzbeM.put("author", Field.zzb("author", 12, ItemScopeEntity.class));
        zzbeM.put("bestRating", Field.zzl("bestRating", 13));
        zzbeM.put("birthDate", Field.zzl("birthDate", 14));
        zzbeM.put("byArtist", Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzbeM.put("caption", Field.zzl("caption", 16));
        zzbeM.put("contentSize", Field.zzl("contentSize", 17));
        zzbeM.put("contentUrl", Field.zzl("contentUrl", 18));
        zzbeM.put("contributor", Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzbeM.put("dateCreated", Field.zzl("dateCreated", 20));
        zzbeM.put("dateModified", Field.zzl("dateModified", 21));
        zzbeM.put("datePublished", Field.zzl("datePublished", 22));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzbeM.put("duration", Field.zzl("duration", 24));
        zzbeM.put("embedUrl", Field.zzl("embedUrl", 25));
        zzbeM.put("endDate", Field.zzl("endDate", 26));
        zzbeM.put("familyName", Field.zzl("familyName", 27));
        zzbeM.put("gender", Field.zzl("gender", 28));
        zzbeM.put("geo", Field.zza("geo", 29, ItemScopeEntity.class));
        zzbeM.put("givenName", Field.zzl("givenName", 30));
        zzbeM.put("height", Field.zzl("height", 31));
        zzbeM.put("id", Field.zzl("id", 32));
        zzbeM.put("image", Field.zzl("image", 33));
        zzbeM.put("inAlbum", Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzbeM.put("latitude", Field.zzj("latitude", 36));
        zzbeM.put("location", Field.zza("location", 37, ItemScopeEntity.class));
        zzbeM.put("longitude", Field.zzj("longitude", 38));
        zzbeM.put("name", Field.zzl("name", 39));
        zzbeM.put("partOfTVSeries", Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzbeM.put("performers", Field.zzb("performers", 41, ItemScopeEntity.class));
        zzbeM.put("playerType", Field.zzl("playerType", 42));
        zzbeM.put("postOfficeBoxNumber", Field.zzl("postOfficeBoxNumber", 43));
        zzbeM.put("postalCode", Field.zzl("postalCode", 44));
        zzbeM.put("ratingValue", Field.zzl("ratingValue", 45));
        zzbeM.put("reviewRating", Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzbeM.put("startDate", Field.zzl("startDate", 47));
        zzbeM.put("streetAddress", Field.zzl("streetAddress", 48));
        zzbeM.put("text", Field.zzl("text", 49));
        zzbeM.put("thumbnail", Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzbeM.put("tickerSymbol", Field.zzl("tickerSymbol", 52));
        zzbeM.put("type", Field.zzl("type", 53));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzbeM.put("width", Field.zzl("width", 55));
        zzbeM.put("worstRating", Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    ItemScopeEntity(Set<Integer> indicatorSet, int versionCode, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbeO = about;
        this.zzbeP = additionalName;
        this.zzbeQ = address;
        this.zzbeR = addressCountry;
        this.zzbeS = addressLocality;
        this.zzbeT = addressRegion;
        this.zzbeU = associated_media;
        this.zzbeV = attendeeCount;
        this.zzbeW = attendees;
        this.zzbeX = audio;
        this.zzbeY = author;
        this.zzbeZ = bestRating;
        this.zzbfa = birthDate;
        this.zzbfb = byArtist;
        this.zzbfc = caption;
        this.zzbfd = contentSize;
        this.zztZ = contentUrl;
        this.zzbfe = contributor;
        this.zzbff = dateCreated;
        this.zzbfg = dateModified;
        this.zzbfh = datePublished;
        this.zzaxl = description;
        this.zzbfi = duration;
        this.zzbfj = embedUrl;
        this.zzbfk = endDate;
        this.zzbfl = familyName;
        this.zzbfm = gender;
        this.zzbfn = geo;
        this.zzbfo = givenName;
        this.zzbfp = height;
        this.zzyv = id;
        this.zzbfq = image;
        this.zzbfr = inAlbum;
        this.zzaNF = latitude;
        this.zzbfs = location;
        this.zzaNG = longitude;
        this.mName = name;
        this.zzbft = partOfTVSeries;
        this.zzbfu = performers;
        this.zzbfv = playerType;
        this.zzbfw = postOfficeBoxNumber;
        this.zzbfx = postalCode;
        this.zzbfy = ratingValue;
        this.zzbfz = reviewRating;
        this.zzbfA = startDate;
        this.zzbfB = streetAddress;
        this.zzbfC = text;
        this.zzbfD = thumbnail;
        this.zzbfE = thumbnailUrl;
        this.zzbfF = tickerSymbol;
        this.zzJN = type;
        this.zzF = url;
        this.zzbfG = width;
        this.zzbfH = worstRating;
    }

    public ItemScopeEntity(Set<Integer> indicatorSet, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = 1;
        this.zzbeO = about;
        this.zzbeP = additionalName;
        this.zzbeQ = address;
        this.zzbeR = addressCountry;
        this.zzbeS = addressLocality;
        this.zzbeT = addressRegion;
        this.zzbeU = associated_media;
        this.zzbeV = attendeeCount;
        this.zzbeW = attendees;
        this.zzbeX = audio;
        this.zzbeY = author;
        this.zzbeZ = bestRating;
        this.zzbfa = birthDate;
        this.zzbfb = byArtist;
        this.zzbfc = caption;
        this.zzbfd = contentSize;
        this.zztZ = contentUrl;
        this.zzbfe = contributor;
        this.zzbff = dateCreated;
        this.zzbfg = dateModified;
        this.zzbfh = datePublished;
        this.zzaxl = description;
        this.zzbfi = duration;
        this.zzbfj = embedUrl;
        this.zzbfk = endDate;
        this.zzbfl = familyName;
        this.zzbfm = gender;
        this.zzbfn = geo;
        this.zzbfo = givenName;
        this.zzbfp = height;
        this.zzyv = id;
        this.zzbfq = image;
        this.zzbfr = inAlbum;
        this.zzaNF = latitude;
        this.zzbfs = location;
        this.zzaNG = longitude;
        this.mName = name;
        this.zzbft = partOfTVSeries;
        this.zzbfu = performers;
        this.zzbfv = playerType;
        this.zzbfw = postOfficeBoxNumber;
        this.zzbfx = postalCode;
        this.zzbfy = ratingValue;
        this.zzbfz = reviewRating;
        this.zzbfA = startDate;
        this.zzbfB = streetAddress;
        this.zzbfC = text;
        this.zzbfD = thumbnail;
        this.zzbfE = thumbnailUrl;
        this.zzbfF = tickerSymbol;
        this.zzJN = type;
        this.zzF = url;
        this.zzbfG = width;
        this.zzbfH = worstRating;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (Field field : zzbeM.values()) {
            if (zza(field)) {
                if (!itemScopeEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(itemScopeEntity.zzb(field))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzFm();
    }

    public ItemScope getAbout() {
        return this.zzbeO;
    }

    public List<String> getAdditionalName() {
        return this.zzbeP;
    }

    public ItemScope getAddress() {
        return this.zzbeQ;
    }

    public String getAddressCountry() {
        return this.zzbeR;
    }

    public String getAddressLocality() {
        return this.zzbeS;
    }

    public String getAddressRegion() {
        return this.zzbeT;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzbeU;
    }

    public int getAttendeeCount() {
        return this.zzbeV;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzbeW;
    }

    public ItemScope getAudio() {
        return this.zzbeX;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzbeY;
    }

    public String getBestRating() {
        return this.zzbeZ;
    }

    public String getBirthDate() {
        return this.zzbfa;
    }

    public ItemScope getByArtist() {
        return this.zzbfb;
    }

    public String getCaption() {
        return this.zzbfc;
    }

    public String getContentSize() {
        return this.zzbfd;
    }

    public String getContentUrl() {
        return this.zztZ;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzbfe;
    }

    public String getDateCreated() {
        return this.zzbff;
    }

    public String getDateModified() {
        return this.zzbfg;
    }

    public String getDatePublished() {
        return this.zzbfh;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public String getDuration() {
        return this.zzbfi;
    }

    public String getEmbedUrl() {
        return this.zzbfj;
    }

    public String getEndDate() {
        return this.zzbfk;
    }

    public String getFamilyName() {
        return this.zzbfl;
    }

    public String getGender() {
        return this.zzbfm;
    }

    public ItemScope getGeo() {
        return this.zzbfn;
    }

    public String getGivenName() {
        return this.zzbfo;
    }

    public String getHeight() {
        return this.zzbfp;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getImage() {
        return this.zzbfq;
    }

    public ItemScope getInAlbum() {
        return this.zzbfr;
    }

    public double getLatitude() {
        return this.zzaNF;
    }

    public ItemScope getLocation() {
        return this.zzbfs;
    }

    public double getLongitude() {
        return this.zzaNG;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzbft;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzbfu;
    }

    public String getPlayerType() {
        return this.zzbfv;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzbfw;
    }

    public String getPostalCode() {
        return this.zzbfx;
    }

    public String getRatingValue() {
        return this.zzbfy;
    }

    public ItemScope getReviewRating() {
        return this.zzbfz;
    }

    public String getStartDate() {
        return this.zzbfA;
    }

    public String getStreetAddress() {
        return this.zzbfB;
    }

    public String getText() {
        return this.zzbfC;
    }

    public ItemScope getThumbnail() {
        return this.zzbfD;
    }

    public String getThumbnailUrl() {
        return this.zzbfE;
    }

    public String getTickerSymbol() {
        return this.zzbfF;
    }

    public String getType() {
        return this.zzJN;
    }

    public String getUrl() {
        return this.zzF;
    }

    public String getWidth() {
        return this.zzbfG;
    }

    public String getWorstRating() {
        return this.zzbfH;
    }

    public boolean hasAbout() {
        return this.zzbeN.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.zzbeN.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.zzbeN.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.zzbeN.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.zzbeN.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.zzbeN.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.zzbeN.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.zzbeN.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.zzbeN.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.zzbeN.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.zzbeN.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.zzbeN.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.zzbeN.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.zzbeN.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.zzbeN.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.zzbeN.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.zzbeN.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.zzbeN.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.zzbeN.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.zzbeN.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.zzbeN.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.zzbeN.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.zzbeN.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.zzbeN.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.zzbeN.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.zzbeN.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.zzbeN.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.zzbeN.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.zzbeN.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.zzbeN.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.zzbeN.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.zzbeN.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.zzbeN.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.zzbeN.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.zzbeN.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.zzbeN.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.zzbeN.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.zzbeN.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.zzbeN.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.zzbeN.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzbeN.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.zzbeN.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.zzbeN.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.zzbeN.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.zzbeN.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.zzbeN.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.zzbeN.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.zzbeN.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.zzbeN.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.zzbeN.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.zzbeN.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.zzbeN.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.zzbeN.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.zzbeN.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzbeM.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzrs());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzFl() {
        return zzbeM;
    }

    public ItemScopeEntity zzFm() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrs()) {
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return this.zzbeO;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return this.zzbeP;
            case Barcode.PHONE /*4*/:
                return this.zzbeQ;
            case Barcode.PRODUCT /*5*/:
                return this.zzbeR;
            case Barcode.SMS /*6*/:
                return this.zzbeS;
            case Barcode.TEXT /*7*/:
                return this.zzbeT;
            case Barcode.URL /*8*/:
                return this.zzbeU;
            case Barcode.WIFI /*9*/:
                return Integer.valueOf(this.zzbeV);
            case Barcode.GEO /*10*/:
                return this.zzbeW;
            case Barcode.CALENDAR_EVENT /*11*/:
                return this.zzbeX;
            case Barcode.DRIVER_LICENSE /*12*/:
                return this.zzbeY;
            case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                return this.zzbeZ;
            case Place.TYPE_BUS_STATION /*14*/:
                return this.zzbfa;
            case Place.TYPE_CAFE /*15*/:
                return this.zzbfb;
            case Barcode.DATA_MATRIX /*16*/:
                return this.zzbfc;
            case Place.TYPE_CAR_DEALER /*17*/:
                return this.zzbfd;
            case Place.TYPE_CAR_RENTAL /*18*/:
                return this.zztZ;
            case Place.TYPE_CAR_REPAIR /*19*/:
                return this.zzbfe;
            case Place.TYPE_CAR_WASH /*20*/:
                return this.zzbff;
            case Place.TYPE_CASINO /*21*/:
                return this.zzbfg;
            case Place.TYPE_CEMETERY /*22*/:
                return this.zzbfh;
            case Place.TYPE_CHURCH /*23*/:
                return this.zzaxl;
            case Place.TYPE_CITY_HALL /*24*/:
                return this.zzbfi;
            case Place.TYPE_CLOTHING_STORE /*25*/:
                return this.zzbfj;
            case Place.TYPE_CONVENIENCE_STORE /*26*/:
                return this.zzbfk;
            case Place.TYPE_COURTHOUSE /*27*/:
                return this.zzbfl;
            case Place.TYPE_DENTIST /*28*/:
                return this.zzbfm;
            case Place.TYPE_DEPARTMENT_STORE /*29*/:
                return this.zzbfn;
            case Place.TYPE_DOCTOR /*30*/:
                return this.zzbfo;
            case Place.TYPE_ELECTRICIAN /*31*/:
                return this.zzbfp;
            case Barcode.EAN_13 /*32*/:
                return this.zzyv;
            case Place.TYPE_EMBASSY /*33*/:
                return this.zzbfq;
            case Place.TYPE_ESTABLISHMENT /*34*/:
                return this.zzbfr;
            case Place.TYPE_FIRE_STATION /*36*/:
                return Double.valueOf(this.zzaNF);
            case Place.TYPE_FLORIST /*37*/:
                return this.zzbfs;
            case Place.TYPE_FOOD /*38*/:
                return Double.valueOf(this.zzaNG);
            case Place.TYPE_FUNERAL_HOME /*39*/:
                return this.mName;
            case Place.TYPE_FURNITURE_STORE /*40*/:
                return this.zzbft;
            case Place.TYPE_GAS_STATION /*41*/:
                return this.zzbfu;
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return this.zzbfv;
            case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                return this.zzbfw;
            case Place.TYPE_GYM /*44*/:
                return this.zzbfx;
            case Place.TYPE_HAIR_CARE /*45*/:
                return this.zzbfy;
            case Place.TYPE_HARDWARE_STORE /*46*/:
                return this.zzbfz;
            case Place.TYPE_HEALTH /*47*/:
                return this.zzbfA;
            case Place.TYPE_HINDU_TEMPLE /*48*/:
                return this.zzbfB;
            case Place.TYPE_HOME_GOODS_STORE /*49*/:
                return this.zzbfC;
            case Place.TYPE_HOSPITAL /*50*/:
                return this.zzbfD;
            case Place.TYPE_INSURANCE_AGENCY /*51*/:
                return this.zzbfE;
            case Place.TYPE_JEWELRY_STORE /*52*/:
                return this.zzbfF;
            case Place.TYPE_LAUNDRY /*53*/:
                return this.zzJN;
            case Place.TYPE_LAWYER /*54*/:
                return this.zzF;
            case Place.TYPE_LIBRARY /*55*/:
                return this.zzbfG;
            case Place.TYPE_LIQUOR_STORE /*56*/:
                return this.zzbfH;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }

    public /* synthetic */ Map zzrl() {
        return zzFl();
    }
}
