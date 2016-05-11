.class Lcom/woop/tryreverseengineerthis/O$2;
.super Ljava/lang/Object;
.source "O.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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
    .line 100
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/O$2;->this$0:Lcom/woop/tryreverseengineerthis/O;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "o1o1o1o1o1o1"    # Landroid/content/DialogInterface;
    .param p2, "o1o1o1o1o1o1o"    # I

    .prologue
    .line 103
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/O$2;->this$0:Lcom/woop/tryreverseengineerthis/O;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/16 v2, 0x64

    invoke-virtual {v0, v1, v2}, Lcom/woop/tryreverseengineerthis/O;->startActivityForResult(Landroid/content/Intent;I)V

    .line 104
    return-void
.end method
