.class public Lcom/woop/tryreverseengineerthis/E;
.super Ljava/lang/Object;
.source "E.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static L1L1:Lcom/woop/tryreverseengineerthis/E;


# instance fields
.field private L:Ljava/util/concurrent/atomic/AtomicInteger;

.field private L1:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private L1L:Ljava/lang/Thread;

.field private L1L1L:Z


# direct methods
.method private constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/E;->L:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 12
    iput-boolean v2, p0, Lcom/woop/tryreverseengineerthis/E;->L1L1L:Z

    .line 23
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/E;->L1:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 24
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/E;->L1L:Ljava/lang/Thread;

    .line 25
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/E;->L1L:Ljava/lang/Thread;

    invoke-virtual {v0, v2}, Ljava/lang/Thread;->setDaemon(Z)V

    .line 26
    iget-object v0, p0, Lcom/woop/tryreverseengineerthis/E;->L1L:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 27
    return-void
.end method

.method public static L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/woop/tryreverseengineerthis/E;->L1L1:Lcom/woop/tryreverseengineerthis/E;

    if-nez v0, :cond_0

    .line 16
    new-instance v0, Lcom/woop/tryreverseengineerthis/E;

    invoke-direct {v0}, Lcom/woop/tryreverseengineerthis/E;-><init>()V

    sput-object v0, Lcom/woop/tryreverseengineerthis/E;->L1L1:Lcom/woop/tryreverseengineerthis/E;

    .line 19
    :cond_0
    sget-object v0, Lcom/woop/tryreverseengineerthis/E;->L1L1:Lcom/woop/tryreverseengineerthis/E;

    return-object v0
.end method

.method private static L1L1L1L1L1L1L1(I)Z
    .locals 4
    .param p0, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O"    # I

    .prologue
    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    .line 30
    int-to-double v0, p0

    div-double/2addr v0, v2

    rem-double/2addr v0, v2

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x1

    .line 33
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public L1L1L1L1L1L1L1L()V
    .locals 4

    .prologue
    .line 60
    iget-object v1, p0, Lcom/woop/tryreverseengineerthis/E;->L:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndAdd(I)I

    .line 61
    new-instance v0, Ljava/sql/Timestamp;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Ljava/sql/Timestamp;-><init>(J)V

    .line 62
    .local v0, "L1L1L1L1L1L":Ljava/sql/Timestamp;
    iget-object v1, p0, Lcom/woop/tryreverseengineerthis/E;->L1:Ljava/util/concurrent/ConcurrentLinkedQueue;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/sql/Timestamp;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\t\t"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Class Status Satisfied."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->add(Ljava/lang/Object;)Z

    .line 63
    const/16 v1, 0x4ce

    invoke-static {v1}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 64
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v1

    invoke-virtual {v1}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 70
    :cond_0
    :goto_0
    return-void

    .line 66
    :cond_1
    iget-boolean v1, p0, Lcom/woop/tryreverseengineerthis/E;->L1L1L:Z

    if-eqz v1, :cond_0

    .line 67
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/woop/tryreverseengineerthis/E;->L1L1L:Z

    .line 68
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    goto :goto_0
.end method

.method public run()V
    .locals 3

    .prologue
    .line 38
    :goto_0
    const/16 v2, 0x52e

    invoke-static {v2}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 39
    invoke-static {}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L()Lcom/woop/tryreverseengineerthis/E;

    move-result-object v2

    invoke-virtual {v2}, Lcom/woop/tryreverseengineerthis/E;->L1L1L1L1L1L1L1L()V

    .line 53
    :cond_0
    iget-object v2, p0, Lcom/woop/tryreverseengineerthis/E;->L1:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 54
    .local v0, "L1L1L1L1L1":Ljava/lang/String;
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v2, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_0

    .line 41
    .end local v0    # "L1L1L1L1L1":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/woop/tryreverseengineerthis/E;->L1:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/woop/tryreverseengineerthis/E;->L1:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->peek()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_0

    .line 43
    :cond_2
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V

    .line 44
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/woop/tryreverseengineerthis/E;->L1L1L:Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 45
    :catch_0
    move-exception v1

    .line 50
    .local v1, "e":Ljava/lang/InterruptedException;
    goto :goto_0
.end method
