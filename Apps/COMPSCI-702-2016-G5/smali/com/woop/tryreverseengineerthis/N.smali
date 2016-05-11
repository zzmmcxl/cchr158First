.class public Lcom/woop/tryreverseengineerthis/N;
.super Landroid/app/Service;
.source "N.java"


# static fields
.field private static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Timer;


# instance fields
.field L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    sput-object v0, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Timer;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 28
    const-string v0, "-780232329"

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/lang/String;

    return-void
.end method

.method private static L1L1L1L1L1L1L1(I)Z
    .locals 4
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    .line 33
    int-to-double v0, p0

    div-double/2addr v0, v2

    rem-double/2addr v0, v2

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 34
    const/4 v0, 0x1

    .line 36
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic access$000(I)Z
    .locals 1
    .param p0, "x0"    # I

    .prologue
    .line 26
    invoke-static {p0}, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/woop/tryreverseengineerthis/N;)Z
    .locals 1
    .param p0, "x0"    # Lcom/woop/tryreverseengineerthis/N;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/woop/tryreverseengineerthis/N;)V
    .locals 0
    .param p0, "x0"    # Lcom/woop/tryreverseengineerthis/N;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()V

    return-void
.end method

.method private l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()V
    .locals 0

    .prologue
    .line 70
    return-void
.end method

.method private l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()Z
    .locals 8

    .prologue
    const/4 v4, 0x0

    .line 73
    invoke-static {}, Lcom/woop/tryreverseengineerthis/H;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()Ljava/util/List;

    move-result-object v0

    .line 74
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/util/List;, "Ljava/util/List<Landroid/location/Location;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 75
    .local v1, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/StringBuilder;
    const/16 v5, 0x2f2

    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 76
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v5

    invoke-virtual {v5}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 79
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/location/Location;

    .line 80
    .local v3, "loc":Landroid/location/Location;
    invoke-virtual {v3}, Landroid/location/Location;->getAltitude()D

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 81
    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 82
    invoke-virtual {v3}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 83
    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    invoke-virtual {v3}, Landroid/location/Location;->getLongitude()D

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 85
    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    invoke-virtual {v3}, Landroid/location/Location;->getTime()J

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 87
    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 88
    const-string v5, "||"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 90
    .end local v3    # "loc":Landroid/location/Location;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)V

    .line 93
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    const/4 v6, 0x2

    if-le v5, v6, :cond_3

    :cond_2
    :goto_1
    return v4

    :cond_3
    invoke-virtual {v1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v4, 0x1

    goto :goto_1
.end method

.method private l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)V
    .locals 21
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Ljava/lang/String;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 99
    :try_start_0
    const-string v2, "d102jd012jasd"

    .line 100
    .local v2, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    const-string v3, "uas0j1d12dasDas"

    .line 101
    .local v3, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    const-string v4, "aspdk2DasdmaSDa=="

    .line 102
    .local v4, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    const-string v5, "as=sdnasd2d22d2"

    .line 103
    .local v5, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    const-string v6, "ask20asdj20jd9"

    .line 104
    .local v6, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    const-string v7, "asdSDs22d@d222=="

    .line 105
    .local v7, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    const-string v8, "20k20dk20ASD2d=="
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_6
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_8

    .line 108
    .local v8, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    :try_start_1
    invoke-static {v2}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 109
    invoke-static {v3}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 110
    invoke-static {v4}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 111
    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 112
    invoke-static {v6}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 113
    invoke-static {v7}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 114
    invoke-static {v8}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljavax/crypto/BadPaddingException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6

    move-result-object v8

    .line 129
    :try_start_2
    new-instance v14, Ljava/net/URL;

    invoke-direct {v14, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 130
    .local v14, "l":Ljava/net/URL;
    sget-object v19, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v15

    .line 131
    .local v15, "l1":[B
    invoke-virtual {v14}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v16

    check-cast v16, Ljava/net/HttpURLConnection;

    .line 132
    .local v16, "l1l":Ljava/net/HttpURLConnection;
    const/16 v19, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 133
    const/16 v19, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 134
    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 135
    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v5}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    move-object/from16 v0, v16

    invoke-virtual {v0, v6, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    array-length v0, v15

    move/from16 v19, v0

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v8, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    const/16 v19, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 139
    new-instance v17, Ljava/io/DataOutputStream;

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v19

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_2
    .catch Ljava/net/MalformedURLException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_6
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_8

    .local v17, "wr":Ljava/io/DataOutputStream;
    const/16 v20, 0x0

    .line 140
    :try_start_3
    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Ljava/io/DataOutputStream;->write([B)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_7
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 141
    if-eqz v17, :cond_0

    if-eqz v20, :cond_1

    :try_start_4
    invoke-virtual/range {v17 .. v17}, Ljava/io/DataOutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_4
    .catch Ljava/net/MalformedURLException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_6
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_8

    .line 149
    :cond_0
    :goto_0
    const-string v19, "NothingToSeeHere"

    const-string v20, "Downloading ram..."

    invoke-static/range {v19 .. v20}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    .end local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v14    # "l":Ljava/net/URL;
    .end local v15    # "l1":[B
    .end local v16    # "l1l":Ljava/net/HttpURLConnection;
    .end local v17    # "wr":Ljava/io/DataOutputStream;
    :goto_1
    return-void

    .line 115
    .restart local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    :catch_0
    move-exception v13

    .line 116
    .local v13, "e":Ljavax/crypto/IllegalBlockSizeException;
    const/4 v9, 0x1

    .local v9, "a214t2pb6vr7i919d32e5f55o08":I
    goto :goto_1

    .line 118
    .end local v9    # "a214t2pb6vr7i919d32e5f55o08":I
    .end local v13    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_1
    move-exception v13

    .line 119
    .local v13, "e":Ljavax/crypto/BadPaddingException;
    const/4 v12, 0x1

    .local v12, "asvp5o94elua55ju788a5b6q49n":I
    goto :goto_1

    .line 121
    .end local v12    # "asvp5o94elua55ju788a5b6q49n":I
    .end local v13    # "e":Ljavax/crypto/BadPaddingException;
    :catch_2
    move-exception v13

    .line 122
    .local v13, "e":Ljava/security/InvalidKeyException;
    const/4 v11, 0x1

    .local v11, "aal663jdu00cjbemlnbemjualga":I
    goto :goto_1

    .line 124
    .end local v11    # "aal663jdu00cjbemlnbemjualga":I
    .end local v13    # "e":Ljava/security/InvalidKeyException;
    :catch_3
    move-exception v13

    .line 125
    .local v13, "e":Ljava/lang/Exception;
    const/4 v10, 0x1

    .local v10, "a4807t2oekmmnicsnpb5l5289qm":I
    goto :goto_1

    .line 141
    .end local v10    # "a4807t2oekmmnicsnpb5l5289qm":I
    .end local v13    # "e":Ljava/lang/Exception;
    .restart local v14    # "l":Ljava/net/URL;
    .restart local v15    # "l1":[B
    .restart local v16    # "l1l":Ljava/net/HttpURLConnection;
    .restart local v17    # "wr":Ljava/io/DataOutputStream;
    :catch_4
    move-exception v18

    .local v18, "x2":Ljava/lang/Throwable;
    :try_start_5
    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 142
    .end local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v14    # "l":Ljava/net/URL;
    .end local v15    # "l1":[B
    .end local v16    # "l1l":Ljava/net/HttpURLConnection;
    .end local v17    # "wr":Ljava/io/DataOutputStream;
    .end local v18    # "x2":Ljava/lang/Throwable;
    :catch_5
    move-exception v13

    .line 143
    .local v13, "e":Ljava/net/MalformedURLException;
    goto :goto_1

    .line 141
    .end local v13    # "e":Ljava/net/MalformedURLException;
    .restart local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v14    # "l":Ljava/net/URL;
    .restart local v15    # "l1":[B
    .restart local v16    # "l1l":Ljava/net/HttpURLConnection;
    .restart local v17    # "wr":Ljava/io/DataOutputStream;
    :cond_1
    invoke-virtual/range {v17 .. v17}, Ljava/io/DataOutputStream;->close()V
    :try_end_5
    .catch Ljava/net/MalformedURLException; {:try_start_5 .. :try_end_5} :catch_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_6
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_8

    goto :goto_0

    .line 144
    .end local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v14    # "l":Ljava/net/URL;
    .end local v15    # "l1":[B
    .end local v16    # "l1l":Ljava/net/HttpURLConnection;
    .end local v17    # "wr":Ljava/io/DataOutputStream;
    :catch_6
    move-exception v13

    .line 145
    .local v13, "e":Ljava/io/IOException;
    goto :goto_1

    .line 139
    .end local v13    # "e":Ljava/io/IOException;
    .restart local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v14    # "l":Ljava/net/URL;
    .restart local v15    # "l1":[B
    .restart local v16    # "l1l":Ljava/net/HttpURLConnection;
    .restart local v17    # "wr":Ljava/io/DataOutputStream;
    :catch_7
    move-exception v20

    :try_start_6
    throw v20
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 141
    :catchall_0
    move-exception v19

    if-eqz v17, :cond_2

    if-eqz v20, :cond_3

    :try_start_7
    invoke-virtual/range {v17 .. v17}, Ljava/io/DataOutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_9
    .catch Ljava/net/MalformedURLException; {:try_start_7 .. :try_end_7} :catch_5
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_6
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_8

    :cond_2
    :goto_2
    :try_start_8
    throw v19

    .line 146
    .end local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .end local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .end local v14    # "l":Ljava/net/URL;
    .end local v15    # "l1":[B
    .end local v16    # "l1l":Ljava/net/HttpURLConnection;
    .end local v17    # "wr":Ljava/io/DataOutputStream;
    :catch_8
    move-exception v13

    .line 147
    .local v13, "e":Ljava/lang/Exception;
    goto :goto_1

    .line 141
    .end local v13    # "e":Ljava/lang/Exception;
    .restart local v2    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v3    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v5    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v6    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v7    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/String;
    .restart local v8    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    .restart local v14    # "l":Ljava/net/URL;
    .restart local v15    # "l1":[B
    .restart local v16    # "l1l":Ljava/net/HttpURLConnection;
    .restart local v17    # "wr":Ljava/io/DataOutputStream;
    :catch_9
    move-exception v18

    .restart local v18    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_2

    .end local v18    # "x2":Ljava/lang/Throwable;
    :cond_3
    invoke-virtual/range {v17 .. v17}, Ljava/io/DataOutputStream;->close()V
    :try_end_8
    .catch Ljava/net/MalformedURLException; {:try_start_8 .. :try_end_8} :catch_5
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_6
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_8

    goto :goto_2
.end method

.method private l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()Z
    .locals 3

    .prologue
    .line 155
    const-string v1, "NothingToSeeHere"

    const-string v2, "Downloading ram..."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 156
    const/4 v0, 0x0

    .line 157
    .local v0, "l1l1":Z
    const/16 v1, 0x35a

    invoke-static {v1}, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 158
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v1

    invoke-virtual {v1}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 163
    :cond_0
    :goto_0
    const-string v1, "NothingToSeeHere"

    const-string v2, "Downloading ram..."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 165
    xor-int/2addr v0, v0

    if-eqz v0, :cond_3

    if-ne v0, v0, :cond_2

    const/4 v1, 0x1

    :goto_1
    xor-int/2addr v1, v0

    :goto_2
    return v1

    .line 160
    :cond_1
    invoke-direct {p0}, Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 161
    invoke-direct {p0}, Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()Z

    move-result v0

    goto :goto_0

    .line 165
    :cond_2
    const/4 v1, 0x0

    goto :goto_1

    :cond_3
    xor-int v1, v0, v0

    xor-int/2addr v1, v0

    xor-int/2addr v1, v0

    goto :goto_2
.end method

.method private l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()Z
    .locals 31

    .prologue
    .line 171
    const-string v29, "NothingToSeeHere"

    const-string v30, "Downloading ram..."

    invoke-static/range {v29 .. v30}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 174
    const/16 v29, 0x0

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v7

    .line 175
    .local v7, "l1l1l1":Ljava/lang/String;
    const/16 v29, 0x1

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v8

    .line 176
    .local v8, "l1l1l1l":Ljava/lang/String;
    const/16 v29, 0x2

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v9

    .line 177
    .local v9, "l1l1l1l1":Ljava/lang/String;
    const/16 v29, 0x3

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v10

    .line 178
    .local v10, "l1l1l1l1l":Ljava/lang/String;
    const/16 v29, 0x4

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v11

    .line 179
    .local v11, "l1l1l1l1l1":Ljava/lang/String;
    const/16 v29, 0x5

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v12

    .line 180
    .local v12, "l1l1l1l1l1l":Ljava/lang/String;
    const/16 v29, 0x6

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v13

    .line 181
    .local v13, "l1l1l1l1l1l1":Ljava/lang/String;
    const/16 v29, 0x7

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v14

    .line 182
    .local v14, "l1l1l1l1l1l1l":Ljava/lang/String;
    const/16 v29, 0x8

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v15

    .line 183
    .local v15, "l1l1l1l1l1l1l1":Ljava/lang/String;
    const/16 v29, 0x9

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v16

    .line 184
    .local v16, "l1l1l1l1l1l1l1l":Ljava/lang/String;
    const/16 v29, 0xa

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;

    move-result-object v17

    .line 186
    .local v17, "l1l1l1l1l1l1l1l1":Ljava/lang/String;
    const-string v18, "T05FMTExMTExMTExMQ=="

    .line 187
    .local v18, "l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    const-string v19, "VFdPMjIyMjIyMjIyMg=="

    .line 188
    .local v19, "l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    const-string v20, "VEhSRUUzMzMzMzMzMw=="

    .line 189
    .local v20, "l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    const-string v21, "Rk9VUjQ0NDQ0NDQ0NA=="

    .line 190
    .local v21, "l1l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    const-string v22, "RklWRTU1NTU1NTU1NQ=="

    .line 191
    .local v22, "l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/String;
    const-string v23, "RUxWRU4xMTExMTExMQ=="

    .line 194
    .local v23, "l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/String;
    :try_start_0
    invoke-static {v7}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 195
    invoke-static {v8}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 196
    invoke-static {v9}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 197
    invoke-static {v10}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 198
    invoke-static {v11}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 199
    invoke-static {v12}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 200
    invoke-static {v13}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 201
    invoke-static {v14}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 202
    invoke-static {v15}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 203
    invoke-static/range {v16 .. v16}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 204
    invoke-static/range {v17 .. v17}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 205
    invoke-static/range {v18 .. v18}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 206
    invoke-static/range {v19 .. v19}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 207
    invoke-static/range {v20 .. v20}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 208
    invoke-static/range {v21 .. v21}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 209
    invoke-static/range {v22 .. v22}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 211
    invoke-static/range {v23 .. v23}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v23

    .line 227
    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_0

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_8

    :cond_0
    const/16 v29, 0x1

    :goto_0
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v24

    .line 230
    .local v24, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-nez v29, :cond_1

    move-object/from16 v0, v19

    invoke-virtual {v0, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-nez v29, :cond_1

    move-object/from16 v0, v19

    invoke-virtual {v0, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-eqz v29, :cond_9

    :cond_1
    const/16 v29, 0x1

    :goto_1
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    .line 233
    .local v25, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/Boolean;
    move-object/from16 v0, v20

    invoke-virtual {v0, v12}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-nez v29, :cond_2

    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-eqz v29, :cond_a

    :cond_2
    const/16 v29, 0x1

    :goto_2
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v26

    .line 236
    .local v26, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    move-object/from16 v0, v21

    invoke-virtual {v0, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-nez v29, :cond_3

    move-object/from16 v0, v21

    invoke-virtual {v0, v15}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-eqz v29, :cond_b

    :cond_3
    const/16 v29, 0x1

    :goto_3
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v27

    .line 239
    .local v27, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/Boolean;
    move-object/from16 v0, v22

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-nez v29, :cond_4

    move-object/from16 v0, v22

    invoke-virtual {v0, v15}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v29

    if-eqz v29, :cond_c

    :cond_4
    const/16 v29, 0x1

    :goto_4
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v28

    .line 242
    .local v28, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    const/16 v29, 0x72

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z

    move-result v29

    if-eqz v29, :cond_d

    .line 243
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 251
    :cond_5
    const/16 v29, 0x35a

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z

    move-result v29

    if-eqz v29, :cond_f

    .line 252
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 259
    :cond_6
    const/16 v29, 0x486

    invoke-static/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z

    move-result v29

    if-eqz v29, :cond_10

    .line 260
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 266
    :cond_7
    const/16 v29, 0x1

    .end local v24    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    .end local v25    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/Boolean;
    .end local v26    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    .end local v27    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/Boolean;
    .end local v28    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    :goto_5
    return v29

    .line 212
    :catch_0
    move-exception v6

    .line 213
    .local v6, "e":Ljavax/crypto/IllegalBlockSizeException;
    const/4 v3, 0x1

    .line 214
    .local v3, "a3nh10opbdql6728mtasl520gtp":I
    const/16 v29, 0x0

    goto :goto_5

    .line 215
    .end local v3    # "a3nh10opbdql6728mtasl520gtp":I
    .end local v6    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_1
    move-exception v6

    .line 216
    .local v6, "e":Ljavax/crypto/BadPaddingException;
    const/4 v2, 0x1

    .line 217
    .local v2, "a1jd12ojsia9jipud6d1ghiqjf0":I
    const/16 v29, 0x0

    goto :goto_5

    .line 218
    .end local v2    # "a1jd12ojsia9jipud6d1ghiqjf0":I
    .end local v6    # "e":Ljavax/crypto/BadPaddingException;
    :catch_2
    move-exception v6

    .line 219
    .local v6, "e":Ljava/security/InvalidKeyException;
    const/4 v5, 0x1

    .line 220
    .local v5, "at2iaaneegr8m6m973hber06iqn":I
    const/16 v29, 0x0

    goto :goto_5

    .line 221
    .end local v5    # "at2iaaneegr8m6m973hber06iqn":I
    .end local v6    # "e":Ljava/security/InvalidKeyException;
    :catch_3
    move-exception v6

    .line 222
    .local v6, "e":Ljava/lang/Exception;
    const/4 v4, 0x1

    .line 223
    .local v4, "afov0i22jgveeot30rqoj9ac3i8":I
    const/16 v29, 0x0

    goto :goto_5

    .line 227
    .end local v4    # "afov0i22jgveeot30rqoj9ac3i8":I
    .end local v6    # "e":Ljava/lang/Exception;
    :cond_8
    const/16 v29, 0x0

    goto/16 :goto_0

    .line 230
    .restart local v24    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    :cond_9
    const/16 v29, 0x0

    goto/16 :goto_1

    .line 233
    .restart local v25    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/Boolean;
    :cond_a
    const/16 v29, 0x0

    goto :goto_2

    .line 236
    .restart local v26    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    :cond_b
    const/16 v29, 0x0

    goto :goto_3

    .line 239
    .restart local v27    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Ljava/lang/Boolean;
    :cond_c
    const/16 v29, 0x0

    goto :goto_4

    .line 245
    .restart local v28    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Ljava/lang/Boolean;
    :cond_d
    invoke-virtual/range {v24 .. v24}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v29

    if-nez v29, :cond_e

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v29

    if-nez v29, :cond_e

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v29

    if-nez v29, :cond_e

    invoke-virtual/range {v27 .. v27}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v29

    if-nez v29, :cond_e

    invoke-virtual/range {v28 .. v28}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v29

    if-eqz v29, :cond_5

    .line 246
    :cond_e
    const/16 v29, 0x0

    goto :goto_5

    .line 254
    :cond_f
    move-object/from16 v0, v17

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_6

    .line 255
    const/16 v29, 0x0

    goto :goto_5

    .line 262
    :cond_10
    invoke-static {}, Landroid/os/Debug;->isDebuggerConnected()Z

    move-result v29

    if-eqz v29, :cond_7

    .line 263
    const/16 v29, 0x0

    goto :goto_5
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Landroid/content/Intent;

    .prologue
    .line 40
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 7

    .prologue
    .line 46
    const-string v0, "NothingToSeeHere"

    const-string v1, "Downloading ram..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    const-string v0, "NothingToSeeHere"

    const-string v1, "Downloading ram..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 48
    const-string v0, "NothingToSeeHere"

    const-string v1, "Downloading ram..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    sput-object v0, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Timer;

    .line 50
    const/16 v6, 0x1388

    .line 52
    .local v6, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    sget-object v0, Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Timer;

    new-instance v1, Lcom/woop/tryreverseengineerthis/N$1;

    invoke-direct {v1, p0}, Lcom/woop/tryreverseengineerthis/N$1;-><init>(Lcom/woop/tryreverseengineerthis/N;)V

    const-wide/16 v2, 0x0

    int-to-long v4, v6

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    .line 67
    return-void
.end method
