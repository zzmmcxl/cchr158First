.class public Lcom/woop/tryreverseengineerthis/J;
.super Ljava/lang/Object;
.source "J.java"


# static fields
.field public static L1L1L1L1L1L1L1L1:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static L1L1L1L1L1L1L1(I)Z
    .locals 4
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    .line 24
    int-to-double v0, p0

    div-double/2addr v0, v2

    rem-double/2addr v0, v2

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 25
    const/4 v0, 0x1

    .line 27
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Ljava/lang/String;
    .locals 11
    .param p0, "number"    # I

    .prologue
    .line 13
    const-class v7, Lcom/woop/tryreverseengineerthis/J;

    monitor-enter v7

    :try_start_0
    sget-object v6, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "o"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "drawable"

    sget-object v10, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v8, v9, v10}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 14
    .local v0, "L1L1L1L1L1L1L1L1L":I
    sget-object v6, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "pe"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "drawable"

    sget-object v10, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v8, v9, v10}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 15
    .local v1, "L1L1L1L1L1L1L1L1L1":I
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 16
    .local v2, "L1L1L1L1L1L1L1L1L1L":Landroid/graphics/BitmapFactory$Options;
    const/4 v6, 0x0

    iput-boolean v6, v2, Landroid/graphics/BitmapFactory$Options;->inScaled:Z

    .line 17
    new-instance v3, Lcom/woop/tryreverseengineerthis/K;

    sget-object v6, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {v6, v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v6

    invoke-direct {v3, v6}, Lcom/woop/tryreverseengineerthis/K;-><init>(Landroid/graphics/Bitmap;)V

    .line 18
    .local v3, "L1L1L1L1L1L1L1L1L1L1":Lcom/woop/tryreverseengineerthis/K;
    new-instance v4, Lcom/woop/tryreverseengineerthis/K;

    sget-object v6, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {v6, v0, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v6

    invoke-direct {v4, v6}, Lcom/woop/tryreverseengineerthis/K;-><init>(Landroid/graphics/Bitmap;)V

    .line 19
    .local v4, "L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/K;
    invoke-static {v3, v4}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v5

    .line 20
    .local v5, "L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    monitor-exit v7

    return-object v5

    .line 13
    .end local v0    # "L1L1L1L1L1L1L1L1L":I
    .end local v1    # "L1L1L1L1L1L1L1L1L1":I
    .end local v2    # "L1L1L1L1L1L1L1L1L1L":Landroid/graphics/BitmapFactory$Options;
    .end local v3    # "L1L1L1L1L1L1L1L1L1L1":Lcom/woop/tryreverseengineerthis/K;
    .end local v4    # "L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/K;
    .end local v5    # "L1L1L1L1L1L1L1L1L1L1L1":Ljava/lang/String;
    :catchall_0
    move-exception v6

    monitor-exit v7

    throw v6
.end method

.method private static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;)Ljava/lang/String;
    .locals 7
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Lcom/woop/tryreverseengineerthis/K;
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Lcom/woop/tryreverseengineerthis/K;

    .prologue
    const/4 v6, 0x1

    .line 30
    invoke-static {p0, p1, v6, v6}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)I

    move-result v0

    .line 31
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L":I
    const/4 v1, 0x0

    .line 32
    .local v1, "L1L1L1L1L1L1L1L1L1L1L1L1":I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 33
    .local v2, "L1L1L1L1L1L1L1L1L1L1L1L1L":Ljava/lang/StringBuilder;
    const/16 v5, 0x54a

    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1(I)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 34
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v5

    invoke-virtual {v5}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 37
    :cond_0
    const/4 v3, 0x0

    .local v3, "L1L1L1L1L1L1L1L1L1L1L1L1L1":I
    :goto_0
    invoke-virtual {p1}, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()I

    move-result v5

    if-ge v3, v5, :cond_7

    .line 38
    const/16 v5, 0xe6

    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1(I)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 39
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v5

    invoke-virtual {v5}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 42
    :cond_1
    const/4 v4, 0x0

    .local v4, "L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    :goto_1
    invoke-virtual {p1}, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1()I

    move-result v5

    if-ge v4, v5, :cond_6

    .line 43
    const/16 v5, 0x152

    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 44
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v5

    invoke-virtual {v5}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 42
    :cond_2
    :goto_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 46
    :cond_3
    if-ne v3, v6, :cond_4

    if-eq v4, v6, :cond_2

    .line 47
    :cond_4
    add-int/lit8 v1, v1, 0x1

    .line 48
    const/16 v5, 0x42e

    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1(I)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 49
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v5

    invoke-virtual {v5}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    goto :goto_2

    .line 51
    :cond_5
    if-ne v1, v0, :cond_2

    .line 52
    invoke-static {p0, p1, v3, v4}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)C

    move-result v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 53
    const/4 v1, 0x0

    goto :goto_2

    .line 37
    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 58
    .end local v4    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    :cond_7
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method

.method private static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)C
    .locals 4
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Lcom/woop/tryreverseengineerthis/K;
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Lcom/woop/tryreverseengineerthis/K;
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # I
    .param p3, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    .line 62
    invoke-static {p0, p1, p2, p3}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)Lcom/woop/tryreverseengineerthis/L;

    move-result-object v0

    .line 63
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/L;
    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/L;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()I

    move-result v2

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/L;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/L;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1()I

    move-result v3

    add-int v1, v2, v3

    .line 64
    .local v1, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":I
    int-to-char v2, v1

    return v2
.end method

.method private static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)I
    .locals 3
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Lcom/woop/tryreverseengineerthis/K;
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Lcom/woop/tryreverseengineerthis/K;
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # I
    .param p3, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    .line 68
    invoke-static {p0, p1, p2, p3}, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)Lcom/woop/tryreverseengineerthis/L;

    move-result-object v0

    .line 69
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/L;
    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/L;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()I

    move-result v1

    mul-int/lit8 v1, v1, 0x7f

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/L;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()I

    move-result v2

    mul-int/lit8 v2, v2, 0x7f

    add-int/2addr v1, v2

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/L;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1()I

    move-result v2

    add-int/2addr v1, v2

    return v1
.end method

.method private static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L(Lcom/woop/tryreverseengineerthis/K;Lcom/woop/tryreverseengineerthis/K;II)Lcom/woop/tryreverseengineerthis/L;
    .locals 12
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Lcom/woop/tryreverseengineerthis/K;
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Lcom/woop/tryreverseengineerthis/K;
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # I
    .param p3, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    .line 73
    invoke-virtual {p1, p2, p3}, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(II)I

    move-result v0

    .line 74
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":I
    invoke-static {v0}, Landroid/graphics/Color;->blue(I)I

    move-result v1

    .line 75
    .local v1, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    invoke-static {v0}, Landroid/graphics/Color;->red(I)I

    move-result v2

    .line 76
    .local v2, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":I
    invoke-static {v0}, Landroid/graphics/Color;->green(I)I

    move-result v3

    .line 77
    .local v3, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    invoke-virtual {p0, p2, p3}, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(II)I

    move-result v4

    .line 78
    .local v4, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":I
    invoke-static {v4}, Landroid/graphics/Color;->blue(I)I

    move-result v5

    .line 79
    .local v5, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    invoke-static {v4}, Landroid/graphics/Color;->red(I)I

    move-result v6

    .line 80
    .local v6, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":I
    invoke-static {v4}, Landroid/graphics/Color;->green(I)I

    move-result v7

    .line 81
    .local v7, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":I
    new-instance v8, Lcom/woop/tryreverseengineerthis/L;

    sub-int v9, v2, v6

    invoke-static {v9}, Ljava/lang/Math;->abs(I)I

    move-result v9

    sub-int v10, v3, v7

    invoke-static {v10}, Ljava/lang/Math;->abs(I)I

    move-result v10

    sub-int v11, v1, v5

    invoke-static {v11}, Ljava/lang/Math;->abs(I)I

    move-result v11

    invoke-direct {v8, v9, v10, v11}, Lcom/woop/tryreverseengineerthis/L;-><init>(III)V

    return-object v8
.end method
