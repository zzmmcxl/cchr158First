.class Lcom/woop/tryreverseengineerthis/K;
.super Ljava/lang/Object;
.source "J.java"


# instance fields
.field private L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Landroid/graphics/Bitmap;


# direct methods
.method constructor <init>(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 91
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Landroid/graphics/Bitmap;

    .line 92
    return-void
.end method


# virtual methods
.method public L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1()I
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    return v0
.end method

.method public L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L()I
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    return v0
.end method

.method public L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(II)I
    .locals 1
    .param p1, "L1L1L1L1L1L1L1L1L1L1L1L1L1"    # I
    .param p2, "L1L1L1L1L1L1L1L1L1L1L1L1L1L"    # I

    .prologue
    .line 103
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/K;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Landroid/graphics/Bitmap;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Bitmap;->getPixel(II)I

    move-result v0

    return v0
.end method
