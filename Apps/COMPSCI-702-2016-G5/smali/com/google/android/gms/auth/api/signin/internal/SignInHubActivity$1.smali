.class Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzlf$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;->zzbO(Ljava/lang/String;)Lcom/google/android/gms/internal/zzlf$zza;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzXY:Ljava/lang/String;

.field final synthetic zzXZ:Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;


# direct methods
.method constructor <init>(Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;->zzXZ:Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;

    iput-object p2, p0, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;->zzXY:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzk(Landroid/content/Intent;)V
    .locals 2

    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;->zzXY:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "scopes"

    iget-object v1, p0, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;->zzXY:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;->zzXZ:Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;

    invoke-static {v0, p1}, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;->zza(Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;Landroid/content/Intent;)V

    :goto_0
    return-void

    :cond_1
    const-string v0, "AuthSignInClient"

    const-string v1, "Idp signin failed!"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity$1;->zzXZ:Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;

    const/4 v1, 0x4

    invoke-static {v0, v1}, Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;->zza(Lcom/google/android/gms/auth/api/signin/internal/SignInHubActivity;I)V

    goto :goto_0
.end method
