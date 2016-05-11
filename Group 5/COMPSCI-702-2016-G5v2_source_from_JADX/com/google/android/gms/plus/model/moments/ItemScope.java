package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String mName;
        private String zzF;
        private String zzJN;
        private double zzaNF;
        private double zzaNG;
        private String zzaxl;
        private final Set<Integer> zzbeN;
        private ItemScopeEntity zzbeO;
        private List<String> zzbeP;
        private ItemScopeEntity zzbeQ;
        private String zzbeR;
        private String zzbeS;
        private String zzbeT;
        private List<ItemScopeEntity> zzbeU;
        private int zzbeV;
        private List<ItemScopeEntity> zzbeW;
        private ItemScopeEntity zzbeX;
        private List<ItemScopeEntity> zzbeY;
        private String zzbeZ;
        private String zzbfA;
        private String zzbfB;
        private String zzbfC;
        private ItemScopeEntity zzbfD;
        private String zzbfE;
        private String zzbfF;
        private String zzbfG;
        private String zzbfH;
        private String zzbfa;
        private ItemScopeEntity zzbfb;
        private String zzbfc;
        private String zzbfd;
        private List<ItemScopeEntity> zzbfe;
        private String zzbff;
        private String zzbfg;
        private String zzbfh;
        private String zzbfi;
        private String zzbfj;
        private String zzbfk;
        private String zzbfl;
        private String zzbfm;
        private ItemScopeEntity zzbfn;
        private String zzbfo;
        private String zzbfp;
        private String zzbfq;
        private ItemScopeEntity zzbfr;
        private ItemScopeEntity zzbfs;
        private ItemScopeEntity zzbft;
        private List<ItemScopeEntity> zzbfu;
        private String zzbfv;
        private String zzbfw;
        private String zzbfx;
        private String zzbfy;
        private ItemScopeEntity zzbfz;
        private String zztZ;
        private String zzyv;

        public Builder() {
            this.zzbeN = new HashSet();
        }

        public ItemScope build() {
            return new ItemScopeEntity(this.zzbeN, this.zzbeO, this.zzbeP, this.zzbeQ, this.zzbeR, this.zzbeS, this.zzbeT, this.zzbeU, this.zzbeV, this.zzbeW, this.zzbeX, this.zzbeY, this.zzbeZ, this.zzbfa, this.zzbfb, this.zzbfc, this.zzbfd, this.zztZ, this.zzbfe, this.zzbff, this.zzbfg, this.zzbfh, this.zzaxl, this.zzbfi, this.zzbfj, this.zzbfk, this.zzbfl, this.zzbfm, this.zzbfn, this.zzbfo, this.zzbfp, this.zzyv, this.zzbfq, this.zzbfr, this.zzaNF, this.zzbfs, this.zzaNG, this.mName, this.zzbft, this.zzbfu, this.zzbfv, this.zzbfw, this.zzbfx, this.zzbfy, this.zzbfz, this.zzbfA, this.zzbfB, this.zzbfC, this.zzbfD, this.zzbfE, this.zzbfF, this.zzJN, this.zzF, this.zzbfG, this.zzbfH);
        }

        public Builder setAbout(ItemScope about) {
            this.zzbeO = (ItemScopeEntity) about;
            this.zzbeN.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.zzbeP = additionalName;
            this.zzbeN.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.zzbeQ = (ItemScopeEntity) address;
            this.zzbeN.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.zzbeR = addressCountry;
            this.zzbeN.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.zzbeS = addressLocality;
            this.zzbeN.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.zzbeT = addressRegion;
            this.zzbeN.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.zzbeU = associated_media;
            this.zzbeN.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.zzbeV = attendeeCount;
            this.zzbeN.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.zzbeW = attendees;
            this.zzbeN.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.zzbeX = (ItemScopeEntity) audio;
            this.zzbeN.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.zzbeY = author;
            this.zzbeN.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.zzbeZ = bestRating;
            this.zzbeN.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.zzbfa = birthDate;
            this.zzbeN.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.zzbfb = (ItemScopeEntity) byArtist;
            this.zzbeN.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.zzbfc = caption;
            this.zzbeN.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.zzbfd = contentSize;
            this.zzbeN.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.zztZ = contentUrl;
            this.zzbeN.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.zzbfe = contributor;
            this.zzbeN.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.zzbff = dateCreated;
            this.zzbeN.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.zzbfg = dateModified;
            this.zzbeN.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.zzbfh = datePublished;
            this.zzbeN.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaxl = description;
            this.zzbeN.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.zzbfi = duration;
            this.zzbeN.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.zzbfj = embedUrl;
            this.zzbeN.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.zzbfk = endDate;
            this.zzbeN.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.zzbfl = familyName;
            this.zzbeN.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.zzbfm = gender;
            this.zzbeN.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.zzbfn = (ItemScopeEntity) geo;
            this.zzbeN.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.zzbfo = givenName;
            this.zzbeN.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.zzbfp = height;
            this.zzbeN.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.zzyv = id;
            this.zzbeN.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.zzbfq = image;
            this.zzbeN.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.zzbfr = (ItemScopeEntity) inAlbum;
            this.zzbeN.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.zzaNF = latitude;
            this.zzbeN.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.zzbfs = (ItemScopeEntity) location;
            this.zzbeN.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.zzaNG = longitude;
            this.zzbeN.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.zzbeN.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.zzbft = (ItemScopeEntity) partOfTVSeries;
            this.zzbeN.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.zzbfu = performers;
            this.zzbeN.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.zzbfv = playerType;
            this.zzbeN.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.zzbfw = postOfficeBoxNumber;
            this.zzbeN.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.zzbfx = postalCode;
            this.zzbeN.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.zzbfy = ratingValue;
            this.zzbeN.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.zzbfz = (ItemScopeEntity) reviewRating;
            this.zzbeN.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzbfA = startDate;
            this.zzbeN.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.zzbfB = streetAddress;
            this.zzbeN.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.zzbfC = text;
            this.zzbeN.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.zzbfD = (ItemScopeEntity) thumbnail;
            this.zzbeN.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.zzbfE = thumbnailUrl;
            this.zzbeN.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.zzbfF = tickerSymbol;
            this.zzbeN.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.zzJN = type;
            this.zzbeN.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.zzF = url;
            this.zzbeN.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.zzbfG = width;
            this.zzbeN.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.zzbfH = worstRating;
            this.zzbeN.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
