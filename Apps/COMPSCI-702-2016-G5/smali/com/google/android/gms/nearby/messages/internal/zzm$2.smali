.class Lcom/google/android/gms/nearby/messages/internal/zzm$2;
.super Lcom/google/android/gms/nearby/messages/internal/zzm$zzg;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/nearby/messages/internal/zzm;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/nearby/messages/internal/zzm$zzg",
        "<",
        "Lcom/google/android/gms/nearby/messages/MessageListener;",
        "Lcom/google/android/gms/nearby/messages/internal/zzm$zzc;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zzbcz:Lcom/google/android/gms/nearby/messages/internal/zzm;


# direct methods
.method constructor <init>(Lcom/google/android/gms/nearby/messages/internal/zzm;)V
    .locals 1

    iput-object p1, p0, Lcom/google/android/gms/nearby/messages/internal/zzm$2;->zzbcz:Lcom/google/android/gms/nearby/messages/internal/zzm;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/nearby/messages/internal/zzm$zzg;-><init>(Lcom/google/android/gms/nearby/messages/internal/zzm$1;)V

    return-void
.end method


# virtual methods
.method protected synthetic zzf(Lcom/google/android/gms/common/api/internal/zzq;)Lcom/google/android/gms/nearby/messages/internal/zzm$zza;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/nearby/messages/internal/zzm$2;->zzg(Lcom/google/android/gms/common/api/internal/zzq;)Lcom/google/android/gms/nearby/messages/internal/zzm$zzc;

    move-result-object v0

    return-object v0
.end method

.method protected zzg(Lcom/google/android/gms/common/api/internal/zzq;)Lcom/google/android/gms/nearby/messages/internal/zzm$zzc;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/internal/zzq",
            "<",
            "Lcom/google/android/gms/nearby/messages/MessageListener;",
            ">;)",
            "Lcom/google/android/gms/nearby/messages/internal/zzm$zzc;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/nearby/messages/internal/zzm$zzc;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/google/android/gms/nearby/messages/internal/zzm$zzc;-><init>(Lcom/google/android/gms/common/api/internal/zzq;Lcom/google/android/gms/nearby/messages/internal/zzm$1;)V

    return-object v0
.end method
