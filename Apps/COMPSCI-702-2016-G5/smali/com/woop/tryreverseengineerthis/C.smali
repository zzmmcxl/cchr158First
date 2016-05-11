.class public Lcom/woop/tryreverseengineerthis/C;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "C.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/woop/tryreverseengineerthis/C$D;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Lcom/woop/tryreverseengineerthis/C$D;",
        ">;"
    }
.end annotation


# instance fields
.field l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/lang/String;

.field private final l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/woop/tryreverseengineerthis/F$G;",
            ">;"
        }
    .end annotation
.end field

.field private final l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/A$B;


# direct methods
.method public constructor <init>(Ljava/util/List;Lcom/woop/tryreverseengineerthis/A$B;)V
    .locals 1
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # Lcom/woop/tryreverseengineerthis/A$B;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/woop/tryreverseengineerthis/F$G;",
            ">;",
            "Lcom/woop/tryreverseengineerthis/A$B;",
            ")V"
        }
    .end annotation

    .prologue
    .line 20
    .local p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/util/List;, "Ljava/util/List<Lcom/woop/tryreverseengineerthis/F$G;>;"
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 15
    const-string v0, "-758418481"

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/lang/String;

    .line 21
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/List;

    .line 22
    iput-object p2, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/A$B;

    .line 23
    return-void
.end method

.method static synthetic access$000(Lcom/woop/tryreverseengineerthis/C;)Lcom/woop/tryreverseengineerthis/A$B;
    .locals 1
    .param p0, "x0"    # Lcom/woop/tryreverseengineerthis/C;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/A$B;

    return-object v0
.end method


# virtual methods
.method public getItemCount()I
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public bridge synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .param p2, "x1"    # I

    .prologue
    .line 13
    check-cast p1, Lcom/woop/tryreverseengineerthis/C$D;

    .end local p1    # "x0":Landroid/support/v7/widget/RecyclerView$ViewHolder;
    invoke-virtual {p0, p1, p2}, Lcom/woop/tryreverseengineerthis/C;->onBindViewHolder(Lcom/woop/tryreverseengineerthis/C$D;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/woop/tryreverseengineerthis/C$D;I)V
    .locals 2
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Lcom/woop/tryreverseengineerthis/C$D;
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    .line 34
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/woop/tryreverseengineerthis/F$G;

    iput-object v0, p1, Lcom/woop/tryreverseengineerthis/C$D;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/F$G;

    .line 35
    iget-object v1, p1, Lcom/woop/tryreverseengineerthis/C$D;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Landroid/widget/ImageView;

    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/woop/tryreverseengineerthis/F$G;

    iget v0, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:I

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 36
    iget-object v1, p1, Lcom/woop/tryreverseengineerthis/C$D;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/woop/tryreverseengineerthis/F$G;

    iget-object v0, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/lang/String;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 38
    iget-object v0, p1, Lcom/woop/tryreverseengineerthis/C$D;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Landroid/view/View;

    new-instance v1, Lcom/woop/tryreverseengineerthis/C$1;

    invoke-direct {v1, p0, p1}, Lcom/woop/tryreverseengineerthis/C$1;-><init>(Lcom/woop/tryreverseengineerthis/C;Lcom/woop/tryreverseengineerthis/C$D;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1
    .param p1, "x0"    # Landroid/view/ViewGroup;
    .param p2, "x1"    # I

    .prologue
    .line 13
    invoke-virtual {p0, p1, p2}, Lcom/woop/tryreverseengineerthis/C;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/woop/tryreverseengineerthis/C$D;

    move-result-object v0

    return-object v0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/woop/tryreverseengineerthis/C$D;
    .locals 4
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Landroid/view/ViewGroup;
    .param p2, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1"    # I

    .prologue
    .line 27
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f040028

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 29
    .local v0, "o":Landroid/view/View;
    new-instance v1, Lcom/woop/tryreverseengineerthis/C$D;

    invoke-direct {v1, p0, v0}, Lcom/woop/tryreverseengineerthis/C$D;-><init>(Lcom/woop/tryreverseengineerthis/C;Landroid/view/View;)V

    return-object v1
.end method
