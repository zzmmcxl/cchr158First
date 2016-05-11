.class public Lcom/woop/tryreverseengineerthis/I;
.super Ljava/lang/Object;
.source "I.java"


# static fields
.field private static l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const-string v0, "-80120591"

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/lang/String;

    return-void
.end method

.method private static L1L1L1L1L1L1L1(I)Z
    .locals 4
    .param p0, "o1o"    # I

    .prologue
    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    .line 128
    int-to-double v0, p0

    div-double/2addr v0, v2

    rem-double/2addr v0, v2

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 129
    const/4 v0, 0x1

    .line 131
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static L1L1L1L1L1L1L1(Ljava/lang/String;)Z
    .locals 2
    .param p0, "o1o"    # Ljava/lang/String;

    .prologue
    .line 122
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x10

    if-ne v0, v1, :cond_0

    .line 123
    const/4 v0, 0x1

    .line 125
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Landroid/content/Context;)V
    .locals 11
    .param p0, "o1"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/crypto/NoSuchPaddingException;,
            Ljava/security/NoSuchAlgorithmException;
        }
    .end annotation

    .prologue
    .line 28
    const-string v0, "991922159"

    .line 29
    .local v0, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    sput-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    .line 30
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    sput-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    .line 32
    sget-object v1, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    .line 33
    .local v1, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 34
    .local v2, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    sget-object v3, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 35
    .local v3, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    sget-object v4, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    .line 36
    .local v4, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    sget-object v5, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    .line 37
    .local v5, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    const-string v6, "phone"

    .line 38
    .local v6, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    invoke-virtual {p0, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/telephony/TelephonyManager;

    invoke-virtual {v8}, Landroid/telephony/TelephonyManager;->getNetworkOperator()Ljava/lang/String;

    move-result-object v7

    .line 41
    .local v7, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    const-string v9, "ONE1111111111"

    invoke-virtual {v8, v9, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    const-string v9, "TWO2222222222"

    invoke-virtual {v8, v9, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    const-string v9, "THREE33333333"

    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    const-string v9, "FOUR444444444"

    invoke-virtual {v8, v9, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    const-string v9, "FIVE555555555"

    invoke-virtual {v8, v9, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    const-string v9, "ELVEN11111111"

    invoke-virtual {v8, v9, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "OnceUponATime"

    const-string v10, "Z2VuZXJpYw=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "LivedABunnyCalled"

    const-string v10, "dW5rbm93bg=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "Judy.SheWasGoingTo"

    const-string v10, "Z29vZ2xlX3Nkaw=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "OoposN10earlyforGot"

    const-string v10, "ZW11bGF0b3I="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "beTheBestCopIn"

    const-string v10, "YW5kcm9pZF9zZGtfODY="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "Zo0o0o0o0Topia"

    const-string v10, "Z2VueW1vdGlvbg=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "SheDidNotRealise"

    const-string v10, "c2Rr"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "however,ThatShe"

    const-string v10, "c2RrXzg2"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "wasJustGoingtobe"

    const-string v10, "dmJveA=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "amereparkingWarden"

    const-string v10, "Z29sZGZpc2g="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "sadfacebunny"

    const-string v10, "YW5kcm9pZA=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "d102jd012jasd"

    const-string v10, "aHR0cDovL3d3dy50aGlzaXNhZmFrZXVybGZvcmNvbXBzY2k3MDIuY29tLw=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "uas0j1d12dasDas"

    const-string v10, "UE9TVA=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "aspdk2DasdmaSDa=="

    const-string v10, "Q29udGVudC1UeXBl"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "as=sdnasd2d22d2"

    const-string v10, "YXBwbGljYXRpb24veC13d3ctZm9ybS11cmxlbmNvZGVk"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "ask20asdj20jd9"

    const-string v10, "Y2hhcnNldA=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "asdSDs22d@d222=="

    const-string v10, "dXRmLTg="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "20k20dk20ASD2d=="

    const-string v10, "Q29udGVudC1MZW5ndGg="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "d2jasaSD2dasd=="

    const-string v10, "LTM2Ljg2"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "sdD22d3daSd2=="

    const-string v10, "LTM2Ljg0"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "asd202d0asD2=="

    const-string v10, "MTc0Ljc2"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "asdk22d2djiasd0"

    const-string v10, "MTc1Ljc4"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "a2d0jdASd22ASd22j0"

    const-string v10, "MjU2"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "ajd202ASsd20L022"

    const-string v10, "MTc="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "ajd202ASsd20L025"

    const-string v10, "MTc="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "ajd202ASsd20L026"

    const-string v10, "MTY="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 107
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "apsojdojaspdjaspo"

    const-string v10, "Tm8gY2xhc3NlcyB0b2RheSBmb3Ig"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "dj20jd02j0d2j0d2jd0"

    const-string v10, "Q2Fubm90IGRldGVjdCBsb2NhdGlvbg=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "apsodjpo2jdopj1oassd"

    const-string v10, "WW91IGFyZSBub3QgaW4gdGhlIHJpZ2h0IGxvY2F0aW9u"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 113
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "dasodj02jd02jd02d2"

    const-string v10, "Q2xhc3MgaXMgbm90IG5vdw=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "aspodjaopdjasodjasso"

    const-string v10, "Q2hlY2tlZCBpbg=="

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    sget-object v8, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    const-string v9, "sojodsojdsjodsojsdjo11"

    const-string v10, "T25seSA3MDIgaXMgc3VwcG9ydGVk"

    invoke-virtual {v8, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    return-void
.end method

.method public static l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "o1o1o"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidKeyException;,
            Ljavax/crypto/BadPaddingException;,
            Ljavax/crypto/IllegalBlockSizeException;
        }
    .end annotation

    .prologue
    .line 134
    new-instance v0, Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {p0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([B)V

    .line 135
    .local v0, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    sget-object v1, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    return-object v1
.end method

.method public static l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidKeyException;,
            Ljavax/crypto/BadPaddingException;,
            Ljavax/crypto/IllegalBlockSizeException;
        }
    .end annotation

    .prologue
    .line 139
    sget-object v1, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/HashMap;

    invoke-virtual {v1, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 140
    .local v0, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    new-instance v1, Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([B)V

    return-object v1
.end method
