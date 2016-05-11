package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private Bitmap mBitmap;
    private Metadata zzbni;
    private ByteBuffer zzbnj;

    public static class Builder {
        private Frame zzbnk;

        public Builder() {
            this.zzbnk = new Frame();
        }

        public Frame build() {
            if (this.zzbnk.zzbnj != null || this.zzbnk.mBitmap != null) {
                return this.zzbnk;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap image) {
            int width = image.getWidth();
            int height = image.getHeight();
            this.zzbnk.mBitmap = image;
            Metadata metadata = this.zzbnk.getMetadata();
            metadata.zzoG = width;
            metadata.zzoH = height;
            return this;
        }

        public Builder setId(int id) {
            this.zzbnk.getMetadata().mId = id;
            return this;
        }

        public Builder setImageData(ByteBuffer data, int width, int height, int format) {
            if (data == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (data.capacity() < width * height) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else {
                switch (format) {
                    case Barcode.DATA_MATRIX /*16*/:
                    case Place.TYPE_CAR_DEALER /*17*/:
                    case 842094169:
                        this.zzbnk.zzbnj = data;
                        Metadata metadata = this.zzbnk.getMetadata();
                        metadata.zzoG = width;
                        metadata.zzoH = height;
                        return this;
                    default:
                        throw new IllegalArgumentException("Unsupported image format: " + format);
                }
            }
        }

        public Builder setRotation(int rotation) {
            this.zzbnk.getMetadata().zzDE = rotation;
            return this;
        }

        public Builder setTimestampMillis(long timestampMillis) {
            this.zzbnk.getMetadata().zzaJi = timestampMillis;
            return this;
        }
    }

    public static class Metadata {
        private int mId;
        private int zzDE;
        private long zzaJi;
        private int zzoG;
        private int zzoH;

        public Metadata(Metadata metadata) {
            this.zzoG = metadata.getWidth();
            this.zzoH = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzaJi = metadata.getTimestampMillis();
            this.zzDE = metadata.getRotation();
        }

        public int getHeight() {
            return this.zzoH;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzDE;
        }

        public long getTimestampMillis() {
            return this.zzaJi;
        }

        public int getWidth() {
            return this.zzoG;
        }

        public void zzIf() {
            if (this.zzDE % Frame.ROTATION_180 != 0) {
                int i = this.zzoG;
                this.zzoG = this.zzoH;
                this.zzoH = i;
            }
            this.zzDE = Frame.ROTATION_0;
        }
    }

    private Frame() {
        this.zzbni = new Metadata();
        this.zzbnj = null;
        this.mBitmap = null;
    }

    private ByteBuffer zzIe() {
        int i = ROTATION_0;
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int[] iArr = new int[(width * height)];
        this.mBitmap.getPixels(iArr, ROTATION_0, width, ROTATION_0, ROTATION_0, width, height);
        byte[] bArr = new byte[(width * height)];
        while (i < iArr.length) {
            bArr[i] = (byte) ((int) (((((float) Color.red(iArr[i])) * 0.299f) + (((float) Color.green(iArr[i])) * 0.587f)) + (((float) Color.blue(iArr[i])) * 0.114f)));
            i += ROTATION_90;
        }
        return ByteBuffer.wrap(bArr);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        return this.mBitmap != null ? zzIe() : this.zzbnj;
    }

    public Metadata getMetadata() {
        return this.zzbni;
    }
}
