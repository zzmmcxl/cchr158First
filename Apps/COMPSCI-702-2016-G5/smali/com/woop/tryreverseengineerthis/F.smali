.class public Lcom/woop/tryreverseengineerthis/F;
.super Ljava/lang/Object;
.source "F.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/woop/tryreverseengineerthis/F$G;
    }
.end annotation


# static fields
.field public static final L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/woop/tryreverseengineerthis/F$G;",
            ">;"
        }
    .end annotation
.end field

.field public static final L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/woop/tryreverseengineerthis/F$G;",
            ">;"
        }
    .end annotation
.end field

.field private static final L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:I = 0x4


# instance fields
.field L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Map;

    .line 20
    invoke-static {}, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()V

    .line 21
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const-string v0, "-1834179405"

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    .line 40
    return-void
.end method

.method private static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()V
    .locals 5

    .prologue
    .line 26
    new-instance v0, Lcom/woop/tryreverseengineerthis/F$G;

    const-string v1, "1"

    const-string v2, "COMPSCI 702"

    const-string v3, ""

    const v4, 0x7f02004b

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/woop/tryreverseengineerthis/F$G;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 27
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 28
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Map;

    iget-object v2, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    new-instance v0, Lcom/woop/tryreverseengineerthis/F$G;

    .end local v0    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    const-string v1, "2"

    const-string v2, "SOFTENG 700"

    const-string v3, ""

    const v4, 0x7f0200c7

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/woop/tryreverseengineerthis/F$G;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 30
    .restart local v0    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 31
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Map;

    iget-object v2, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    new-instance v0, Lcom/woop/tryreverseengineerthis/F$G;

    .end local v0    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    const-string v1, "3"

    const-string v2, "SOFTENG 750"

    const-string v3, ""

    const v4, 0x7f0200c9

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/woop/tryreverseengineerthis/F$G;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 33
    .restart local v0    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 34
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Map;

    iget-object v2, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    new-instance v0, Lcom/woop/tryreverseengineerthis/F$G;

    .end local v0    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    const-string v1, "4"

    const-string v2, "SOFTENG 751"

    const-string v3, ""

    const v4, 0x7f02007b

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/woop/tryreverseengineerthis/F$G;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 36
    .restart local v0    # "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/F$G;
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 37
    sget-object v1, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/util/Map;

    iget-object v2, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    return-void
.end method
