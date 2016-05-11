.class Lcom/woop/tryreverseengineerthis/C$1;
.super Ljava/lang/Object;
.source "C.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/woop/tryreverseengineerthis/C;->onBindViewHolder(Lcom/woop/tryreverseengineerthis/C$D;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/woop/tryreverseengineerthis/C;

.field final synthetic val$O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O:Lcom/woop/tryreverseengineerthis/C$D;


# direct methods
.method constructor <init>(Lcom/woop/tryreverseengineerthis/C;Lcom/woop/tryreverseengineerthis/C$D;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/C$1;->this$0:Lcom/woop/tryreverseengineerthis/C;

    iput-object p2, p0, Lcom/woop/tryreverseengineerthis/C$1;->val$O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O:Lcom/woop/tryreverseengineerthis/C$D;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # Landroid/view/View;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C$1;->this$0:Lcom/woop/tryreverseengineerthis/C;

    # getter for: Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/A$B;
    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/C;->access$000(Lcom/woop/tryreverseengineerthis/C;)Lcom/woop/tryreverseengineerthis/A$B;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/C$1;->this$0:Lcom/woop/tryreverseengineerthis/C;

    # getter for: Lcom/woop/tryreverseengineerthis/C;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/A$B;
    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/C;->access$000(Lcom/woop/tryreverseengineerthis/C;)Lcom/woop/tryreverseengineerthis/A$B;

    move-result-object v0

    iget-object v1, p0, Lcom/woop/tryreverseengineerthis/C$1;->val$O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O:Lcom/woop/tryreverseengineerthis/C$D;

    iget-object v1, v1, Lcom/woop/tryreverseengineerthis/C$D;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Lcom/woop/tryreverseengineerthis/F$G;

    invoke-interface {v0, v1}, Lcom/woop/tryreverseengineerthis/A$B;->onListFragmentInteraction(Lcom/woop/tryreverseengineerthis/F$G;)V

    .line 46
    :cond_0
    return-void
.end method
