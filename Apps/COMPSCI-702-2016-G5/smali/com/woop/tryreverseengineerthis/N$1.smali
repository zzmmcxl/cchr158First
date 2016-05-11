.class Lcom/woop/tryreverseengineerthis/N$1;
.super Ljava/util/TimerTask;
.source "N.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/woop/tryreverseengineerthis/N;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/woop/tryreverseengineerthis/N;


# direct methods
.method constructor <init>(Lcom/woop/tryreverseengineerthis/N;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/woop/tryreverseengineerthis/N$1;->this$0:Lcom/woop/tryreverseengineerthis/N;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 56
    const/16 v0, 0xea

    # invokes: Lcom/woop/tryreverseengineerthis/N;->L1L1L1L1L1L1L1(I)Z
    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/N;->access$000(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v0

    invoke-virtual {v0}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 65
    :cond_0
    :goto_0
    return-void

    .line 59
    :cond_1
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/N$1;->this$0:Lcom/woop/tryreverseengineerthis/N;

    # invokes: Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1()Z
    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/N;->access$100(Lcom/woop/tryreverseengineerthis/N;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/N$1;->this$0:Lcom/woop/tryreverseengineerthis/N;

    # invokes: Lcom/woop/tryreverseengineerthis/N;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()V
    invoke-static {v0}, Lcom/woop/tryreverseengineerthis/N;->access$200(Lcom/woop/tryreverseengineerthis/N;)V

    goto :goto_0
.end method
