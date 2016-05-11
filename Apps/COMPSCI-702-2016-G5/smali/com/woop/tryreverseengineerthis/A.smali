.class public Lcom/woop/tryreverseengineerthis/A;
.super Landroid/support/v4/app/Fragment;
.source "A.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/woop/tryreverseengineerthis/A$B;
    }
.end annotation


# static fields
.field private static final L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/lang/String; = "column-count"


# instance fields
.field L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

.field private L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:I

.field private L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Lcom/woop/tryreverseengineerthis/A$B;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 19
    const-string v0, "1117813965"

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    .line 22
    const/4 v0, 0x1

    iput v0, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:I

    .line 26
    return-void
.end method

.method private static L1L1L1L1L1L1L1(I)Z
    .locals 4
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    .line 29
    int-to-double v0, p0

    div-double/2addr v0, v2

    rem-double/2addr v0, v2

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 30
    const/4 v0, 0x1

    .line 32
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1(I)Lcom/woop/tryreverseengineerthis/A;
    .locals 3
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # I

    .prologue
    .line 36
    new-instance v0, Lcom/woop/tryreverseengineerthis/A;

    invoke-direct {v0}, Lcom/woop/tryreverseengineerthis/A;-><init>()V

    .line 37
    .local v0, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Lcom/woop/tryreverseengineerthis/A;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 38
    .local v1, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Landroid/os/Bundle;
    const-string v2, "column-count"

    invoke-virtual {v1, v2, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 39
    invoke-virtual {v0, v1}, Lcom/woop/tryreverseengineerthis/A;->setArguments(Landroid/os/Bundle;)V

    .line 40
    return-object v0
.end method


# virtual methods
.method public onAttach(Landroid/content/Context;)V
    .locals 2
    .param p1, "L1L1L1L1L1L1L1L1"    # Landroid/content/Context;

    .prologue
    .line 83
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onAttach(Landroid/content/Context;)V

    .line 84
    const/16 v0, 0x43e

    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 85
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v0

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 92
    .end local p1    # "L1L1L1L1L1L1L1L1":Landroid/content/Context;
    :goto_0
    return-void

    .line 87
    .restart local p1    # "L1L1L1L1L1L1L1L1":Landroid/content/Context;
    :cond_0
    instance-of v0, p1, Lcom/woop/tryreverseengineerthis/A$B;

    if-eqz v0, :cond_1

    .line 88
    check-cast p1, Lcom/woop/tryreverseengineerthis/A$B;

    .end local p1    # "L1L1L1L1L1L1L1L1":Landroid/content/Context;
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Lcom/woop/tryreverseengineerthis/A$B;

    goto :goto_0

    .line 90
    .restart local p1    # "L1L1L1L1L1L1L1L1":Landroid/content/Context;
    :cond_1
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 47
    const/16 v0, 0x32e

    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v0

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 50
    :cond_1
    invoke-virtual {p0}, Lcom/woop/tryreverseengineerthis/A;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 51
    invoke-virtual {p0}, Lcom/woop/tryreverseengineerthis/A;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "column-count"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:I

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Landroid/view/LayoutInflater;
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Landroid/view/ViewGroup;
    .param p3, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Landroid/os/Bundle;

    .prologue
    .line 58
    const v3, 0x7f040029

    const/4 v4, 0x0

    invoke-virtual {p1, v3, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 61
    .local v1, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1":Landroid/view/View;
    const/16 v3, 0x4ca

    invoke-static {v3}, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 62
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v3

    invoke-virtual {v3}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 77
    :cond_0
    :goto_0
    return-object v1

    .line 64
    :cond_1
    instance-of v3, v1, Landroid/support/v7/widget/RecyclerView;

    if-eqz v3, :cond_0

    .line 65
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .local v0, "L1L1L1L1L1L1L1L1":Landroid/content/Context;
    move-object v2, v1

    .line 66
    check-cast v2, Landroid/support/v7/widget/RecyclerView;

    .line 67
    .local v2, "L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L":Landroid/support/v7/widget/RecyclerView;
    const/16 v3, 0x21a

    invoke-static {v3}, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1(I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 68
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v3

    invoke-virtual {v3}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 75
    :goto_1
    new-instance v3, Lcom/woop/tryreverseengineerthis/C;

    sget-object v4, Lcom/woop/tryreverseengineerthis/F;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/util/List;

    iget-object v5, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Lcom/woop/tryreverseengineerthis/A$B;

    invoke-direct {v3, v4, v5}, Lcom/woop/tryreverseengineerthis/C;-><init>(Ljava/util/List;Lcom/woop/tryreverseengineerthis/A$B;)V

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    goto :goto_0

    .line 70
    :cond_2
    iget v3, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:I

    const/4 v4, 0x1

    if-gt v3, v4, :cond_3

    .line 71
    new-instance v3, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-direct {v3, v0}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    goto :goto_1

    .line 73
    :cond_3
    new-instance v3, Landroid/support/v7/widget/GridLayoutManager;

    iget v4, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:I

    invoke-direct {v3, v0, v4}, Landroid/support/v7/widget/GridLayoutManager;-><init>(Landroid/content/Context;I)V

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    goto :goto_1
.end method

.method public onDetach()V
    .locals 1

    .prologue
    .line 96
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDetach()V

    .line 97
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/A;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Lcom/woop/tryreverseengineerthis/A$B;

    .line 98
    return-void
.end method
