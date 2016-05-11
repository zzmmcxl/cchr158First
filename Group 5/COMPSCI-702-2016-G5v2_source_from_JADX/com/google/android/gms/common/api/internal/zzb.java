package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private final Object zzagI;
    protected final zza<R> zzagJ;
    private final WeakReference<GoogleApiClient> zzagK;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzagL;
    private ResultCallback<? super R> zzagM;
    private volatile boolean zzagN;
    private boolean zzagO;
    private boolean zzagP;
    private zzq zzagQ;
    private Integer zzagR;
    private volatile zzx<R> zzagS;
    private volatile R zzagy;
    private final CountDownLatch zzpJ;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    ((zzb) msg.obj).zzx(Status.zzagF);
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + msg.what, new Exception());
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzb<R> com_google_android_gms_common_api_internal_zzb_R, long j) {
            sendMessageDelayed(obtainMessage(2, com_google_android_gms_common_api_internal_zzb_R), j);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzb.zzc((Result) r);
                throw e;
            }
        }

        public void zzph() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzb(Looper looper) {
        this.zzagI = new Object();
        this.zzpJ = new CountDownLatch(1);
        this.zzagL = new ArrayList();
        this.zzagJ = new zza(looper);
        this.zzagK = new WeakReference(null);
    }

    protected zzb(GoogleApiClient googleApiClient) {
        this.zzagI = new Object();
        this.zzpJ = new CountDownLatch(1);
        this.zzagL = new ArrayList();
        this.zzagJ = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzagK = new WeakReference(googleApiClient);
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.zzagI) {
            if (this.zzagN) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzagy;
            this.zzagy = null;
            this.zzagM = null;
            this.zzagN = true;
        }
        zzpf();
        return r;
    }

    private void zzb(R r) {
        this.zzagy = r;
        this.zzagQ = null;
        this.zzpJ.countDown();
        Status status = this.zzagy.getStatus();
        if (this.zzagM != null) {
            this.zzagJ.zzph();
            if (!this.zzL) {
                this.zzagJ.zza(this.zzagM, get());
            }
        }
        Iterator it = this.zzagL.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzu(status);
        }
        this.zzagL.clear();
    }

    public static void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed");
        if (this.zzagS != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzpJ.await();
        } catch (InterruptedException e) {
            zzx(Status.zzagD);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long time, TimeUnit units) {
        boolean z = true;
        boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzx.zza(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        if (this.zzagS != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzpJ.await(time, units)) {
                zzx(Status.zzagF);
            }
        } catch (InterruptedException e) {
            zzx(Status.zzagD);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public void cancel() {
        synchronized (this.zzagI) {
            if (this.zzL || this.zzagN) {
                return;
            }
            if (this.zzagQ != null) {
                try {
                    this.zzagQ.cancel();
                } catch (RemoteException e) {
                }
            }
            zzc(this.zzagy);
            this.zzagM = null;
            this.zzL = true;
            zzb(zzc(Status.zzagG));
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzagI) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzpJ.getCount() == 0;
    }

    public final void setResultCallback(ResultCallback<? super R> callback) {
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        synchronized (this.zzagI) {
            if (this.zzagS != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
            } else if (!this.zzagP || (((GoogleApiClient) this.zzagK.get()) != null && (callback instanceof zzx))) {
                if (isReady()) {
                    this.zzagJ.zza((ResultCallback) callback, get());
                } else {
                    this.zzagM = callback;
                }
            } else {
                cancel();
            }
        }
    }

    public final void setResultCallback(ResultCallback<? super R> callback, long time, TimeUnit units) {
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        synchronized (this.zzagI) {
            if (this.zzagS != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
            } else if (!this.zzagP || (((GoogleApiClient) this.zzagK.get()) != null && (callback instanceof zzx))) {
                if (isReady()) {
                    this.zzagJ.zza((ResultCallback) callback, get());
                } else {
                    this.zzagM = callback;
                    this.zzagJ.zza(this, units.toMillis(time));
                }
            } else {
                cancel();
            }
        }
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> transform) {
        TransformedResult<S> then;
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        synchronized (this.zzagI) {
            zzx.zza(this.zzagS == null, (Object) "Cannot call then() twice.");
            if (this.zzagM != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.zzagS = new zzx(this.zzagK);
            then = this.zzagS.then(transform);
            if (isReady()) {
                this.zzagJ.zza(this.zzagS, get());
            } else {
                this.zzagM = this.zzagS;
            }
        }
        return then;
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza com_google_android_gms_common_api_PendingResult_zza) {
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        if (com_google_android_gms_common_api_PendingResult_zza == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.zzagI) {
            if (isReady()) {
                com_google_android_gms_common_api_PendingResult_zza.zzu(this.zzagy.getStatus());
            } else {
                this.zzagL.add(com_google_android_gms_common_api_PendingResult_zza);
            }
        }
    }

    public final void zza(R r) {
        boolean z = true;
        synchronized (this.zzagI) {
            if (this.zzagO || this.zzL) {
                zzc((Result) r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzagN) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zzb(r);
        }
    }

    protected final void zza(zzq com_google_android_gms_common_internal_zzq) {
        synchronized (this.zzagI) {
            this.zzagQ = com_google_android_gms_common_internal_zzq;
        }
    }

    protected abstract R zzc(Status status);

    public Integer zzpa() {
        return this.zzagR;
    }

    protected void zzpf() {
    }

    public void zzpg() {
        synchronized (this.zzagI) {
            if (((GoogleApiClient) this.zzagK.get()) == null) {
                cancel();
                return;
            }
            if (this.zzagM == null || (this.zzagM instanceof zzx)) {
                this.zzagP = true;
            } else {
                cancel();
            }
        }
    }

    public final void zzx(Status status) {
        synchronized (this.zzagI) {
            if (!isReady()) {
                zza(zzc(status));
                this.zzagO = true;
            }
        }
    }
}
