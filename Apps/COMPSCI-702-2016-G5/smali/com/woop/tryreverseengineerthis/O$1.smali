.class Lcom/woop/tryreverseengineerthis/O$1;
.super Ljava/lang/Object;
.source "O.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/woop/tryreverseengineerthis/O;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/woop/tryreverseengineerthis/O;


# direct methods
.method constructor <init>(Lcom/woop/tryreverseengineerthis/O;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/O$1;->this$0:Lcom/woop/tryreverseengineerthis/O;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "o1o1o1o1o1o"    # Landroid/view/View;

    .prologue
    .line 64
    const-string v0, "Hello"

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Landroid/support/design/widget/Snackbar;->make(Landroid/view/View;Ljava/lang/CharSequence;I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    const-string v1, "Action"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->setAction(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->show()V

    .line 66
    return-void
.end method
