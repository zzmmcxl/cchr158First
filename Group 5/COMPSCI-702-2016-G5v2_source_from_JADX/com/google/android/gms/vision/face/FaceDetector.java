package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    private final zza zzbnG;
    private final zzg zzbnH;
    private boolean zzbnI;
    private final Object zzpV;

    public static class Builder {
        private final Context mContext;
        private int zzaoy;
        private int zzbnJ;
        private boolean zzbnK;
        private int zzbnL;
        private boolean zzbnM;
        private float zzbnN;

        public Builder(Context context) {
            this.zzbnJ = 0;
            this.zzbnK = false;
            this.zzbnL = 0;
            this.zzbnM = true;
            this.zzaoy = 0;
            this.zzbnN = GroundOverlayOptions.NO_DIMENSION;
            this.mContext = context;
        }

        public FaceDetector build() {
            FaceSettingsParcel faceSettingsParcel = new FaceSettingsParcel();
            faceSettingsParcel.mode = this.zzaoy;
            faceSettingsParcel.zzbnV = this.zzbnJ;
            faceSettingsParcel.zzbnW = this.zzbnL;
            faceSettingsParcel.zzbnX = this.zzbnK;
            faceSettingsParcel.zzbnY = this.zzbnM;
            faceSettingsParcel.zzbnZ = this.zzbnN;
            return new FaceDetector(null);
        }

        public Builder setClassificationType(int classificationType) {
            if (classificationType == 0 || classificationType == FaceDetector.ALL_LANDMARKS) {
                this.zzbnL = classificationType;
                return this;
            }
            throw new IllegalArgumentException("Invalid classification type: " + classificationType);
        }

        public Builder setLandmarkType(int landmarkType) {
            if (landmarkType == 0 || landmarkType == FaceDetector.ALL_LANDMARKS) {
                this.zzbnJ = landmarkType;
                return this;
            }
            throw new IllegalArgumentException("Invalid landmark type: " + landmarkType);
        }

        public Builder setMinFaceSize(float proportionalMinFaceSize) {
            if (proportionalMinFaceSize < 0.0f || proportionalMinFaceSize > TextTrackStyle.DEFAULT_FONT_SCALE) {
                throw new IllegalArgumentException("Invalid proportional face size: " + proportionalMinFaceSize);
            }
            this.zzbnN = proportionalMinFaceSize;
            return this;
        }

        public Builder setMode(int mode) {
            switch (mode) {
                case Barcode.ALL_FORMATS /*0*/:
                case FaceDetector.ALL_LANDMARKS /*1*/:
                    this.zzaoy = mode;
                    return this;
                default:
                    throw new IllegalArgumentException("Invalid mode: " + mode);
            }
        }

        public Builder setProminentFaceOnly(boolean prominentFaceOnly) {
            this.zzbnK = prominentFaceOnly;
            return this;
        }

        public Builder setTrackingEnabled(boolean trackingEnabled) {
            this.zzbnM = trackingEnabled;
            return this;
        }
    }

    private FaceDetector() {
        this.zzbnG = new zza();
        this.zzpV = new Object();
        this.zzbnI = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zzg handle) {
        this.zzbnG = new zza();
        this.zzpV = new Object();
        this.zzbnI = true;
        this.zzbnH = handle;
    }

    public SparseArray<Face> detect(Frame frame) {
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        Face[] zzb;
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        synchronized (this.zzpV) {
            if (this.zzbnI) {
                zzb = this.zzbnH.zzb(grayscaleImageData, FrameMetadataParcel.zzc(frame));
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        Set hashSet = new HashSet();
        SparseArray<Face> sparseArray = new SparseArray(zzb.length);
        int length = zzb.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += ALL_LANDMARKS) {
            Face face = zzb[i2];
            int id = face.getId();
            i = Math.max(i, id);
            if (hashSet.contains(Integer.valueOf(id))) {
                id = i + ALL_LANDMARKS;
                i = id;
            }
            hashSet.add(Integer.valueOf(id));
            sparseArray.append(this.zzbnG.zzkr(id), face);
        }
        return sparseArray;
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this.zzpV) {
                if (this.zzbnI) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isOperational() {
        return this.zzbnH.isOperational();
    }

    public void release() {
        synchronized (this.zzpV) {
            if (this.zzbnI) {
                this.zzbnH.zzIh();
                this.zzbnI = false;
                return;
            }
        }
    }

    public boolean setFocus(int id) {
        boolean zzkJ;
        int zzks = this.zzbnG.zzks(id);
        synchronized (this.zzpV) {
            if (this.zzbnI) {
                zzkJ = this.zzbnH.zzkJ(zzks);
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        return zzkJ;
    }
}
