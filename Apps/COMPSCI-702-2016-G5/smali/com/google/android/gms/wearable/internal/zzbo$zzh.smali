.class final Lcom/google/android/gms/wearable/internal/zzbo$zzh;
.super Lcom/google/android/gms/wearable/internal/zzbo$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/wearable/internal/zzbo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "zzh"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/wearable/internal/zzbo$zzb",
        "<",
        "Lcom/google/android/gms/wearable/Channel$GetInputStreamResult;",
        ">;"
    }
.end annotation


# instance fields
.field private final zzbtd:Lcom/google/android/gms/wearable/internal/zzt;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/api/internal/zza$zzb;Lcom/google/android/gms/wearable/internal/zzt;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/internal/zza$zzb",
            "<",
            "Lcom/google/android/gms/wearable/Channel$GetInputStreamResult;",
            ">;",
            "Lcom/google/android/gms/wearable/internal/zzt;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/google/android/gms/wearable/internal/zzbo$zzb;-><init>(Lcom/google/android/gms/common/api/internal/zza$zzb;)V

    invoke-static {p2}, Lcom/google/android/gms/common/internal/zzx;->zzz(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/zzt;

    iput-object v0, p0, Lcom/google/android/gms/wearable/internal/zzbo$zzh;->zzbtd:Lcom/google/android/gms/wearable/internal/zzt;

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/wearable/internal/GetChannelInputStreamResponse;)V
    .locals 4

    const/4 v0, 0x0

    iget-object v1, p1, Lcom/google/android/gms/wearable/internal/GetChannelInputStreamResponse;->zzbsC:Landroid/os/ParcelFileDescriptor;

    if-eqz v1, :cond_0

    new-instance v0, Lcom/google/android/gms/wearable/internal/zzp;

    new-instance v1, Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;

    iget-object v2, p1, Lcom/google/android/gms/wearable/internal/GetChannelInputStreamResponse;->zzbsC:Landroid/os/ParcelFileDescriptor;

    invoke-direct {v1, v2}, Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;-><init>(Landroid/os/ParcelFileDescriptor;)V

    invoke-direct {v0, v1}, Lcom/google/android/gms/wearable/internal/zzp;-><init>(Ljava/io/InputStream;)V

    iget-object v1, p0, Lcom/google/android/gms/wearable/internal/zzbo$zzh;->zzbtd:Lcom/google/android/gms/wearable/internal/zzt;

    invoke-virtual {v0}, Lcom/google/android/gms/wearable/internal/zzp;->zzIJ()Lcom/google/android/gms/wearable/internal/zzu;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/wearable/internal/zzt;->zza(Lcom/google/android/gms/wearable/internal/zzu;)V

    :cond_0
    new-instance v1, Lcom/google/android/gms/wearable/internal/ChannelImpl$zza;

    new-instance v2, Lcom/google/android/gms/common/api/Status;

    iget v3, p1, Lcom/google/android/gms/wearable/internal/GetChannelInputStreamResponse;->statusCode:I

    invoke-direct {v2, v3}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-direct {v1, v2, v0}, Lcom/google/android/gms/wearable/internal/ChannelImpl$zza;-><init>(Lcom/google/android/gms/common/api/Status;Ljava/io/InputStream;)V

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/internal/zzbo$zzh;->zzX(Ljava/lang/Object;)V

    return-void
.end method
