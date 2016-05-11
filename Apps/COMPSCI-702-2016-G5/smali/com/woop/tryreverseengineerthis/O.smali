.class public Lcom/woop/tryreverseengineerthis/O;
.super Landroid/support/v7/app/AppCompatActivity;
.source "O.java"

# interfaces
.implements Landroid/support/design/widget/NavigationView$OnNavigationItemSelectedListener;
.implements Lcom/woop/tryreverseengineerthis/A$B;


# instance fields
.field l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/lang/String;

.field private l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Lcom/woop/tryreverseengineerthis/M;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 39
    const-string v0, "-794361856"

    iput-object v0, p0, Lcom/woop/tryreverseengineerthis/O;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 3

    .prologue
    const v2, 0x800003

    .line 141
    const v1, 0x7f0d0090

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/DrawerLayout;

    .line 142
    .local v0, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/v4/widget/DrawerLayout;
    invoke-virtual {v0, v2}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 143
    invoke-virtual {v0, v2}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 147
    :goto_0
    return-void

    .line 145
    :cond_0
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 14
    .param p1, "o1o1o1o1o1"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    invoke-virtual {p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sput-object v1, Lcom/woop/tryreverseengineerthis/J;->L1L1L1L1L1L1L1L1:Landroid/content/Context;

    .line 48
    const v1, 0x7f040019

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->setContentView(I)V

    .line 49
    const v1, 0x7f0d0092

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/support/v7/widget/Toolbar;

    .line 50
    .local v3, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/support/v7/widget/Toolbar;
    invoke-virtual {p0, v3}, Lcom/woop/tryreverseengineerthis/O;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 53
    :try_start_0
    invoke-virtual {p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Landroid/content/Context;)V
    :try_end_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_1

    .line 60
    :goto_0
    const v1, 0x7f0d0093

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/support/design/widget/FloatingActionButton;

    .line 61
    .local v8, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/design/widget/FloatingActionButton;
    new-instance v1, Lcom/woop/tryreverseengineerthis/O$1;

    invoke-direct {v1, p0}, Lcom/woop/tryreverseengineerthis/O$1;-><init>(Lcom/woop/tryreverseengineerthis/O;)V

    invoke-virtual {v8, v1}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    new-instance v9, Landroid/content/Intent;

    const-class v1, Lcom/woop/tryreverseengineerthis/N;

    invoke-direct {v9, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 70
    .local v9, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/content/Intent;
    invoke-virtual {p0, v9}, Lcom/woop/tryreverseengineerthis/O;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 72
    const v1, 0x7f0d0090

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/support/v4/widget/DrawerLayout;

    .line 73
    .local v2, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/v4/widget/DrawerLayout;
    new-instance v0, Landroid/support/v7/app/ActionBarDrawerToggle;

    const v4, 0x7f07004f

    const v5, 0x7f07004e

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/app/ActionBarDrawerToggle;-><init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;Landroid/support/v7/widget/Toolbar;II)V

    .line 75
    .local v0, "toggle":Landroid/support/v7/app/ActionBarDrawerToggle;
    invoke-virtual {v2, v0}, Landroid/support/v4/widget/DrawerLayout;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    .line 76
    invoke-virtual {v0}, Landroid/support/v7/app/ActionBarDrawerToggle;->syncState()V

    .line 78
    const v1, 0x7f0d0091

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/support/design/widget/NavigationView;

    .line 79
    .local v10, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/support/design/widget/NavigationView;
    invoke-virtual {v10, p0}, Landroid/support/design/widget/NavigationView;->setNavigationItemSelectedListener(Landroid/support/design/widget/NavigationView$OnNavigationItemSelectedListener;)V

    .line 81
    const-string v1, "location"

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/location/LocationManager;

    .line 84
    .local v13, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/location/LocationManager;
    const/4 v11, 0x0

    .line 85
    .local v11, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Z
    const/4 v12, 0x0

    .line 88
    .local v12, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Z
    if-nez v13, :cond_0

    .line 89
    const-string v1, "location"

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v13

    .end local v13    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/location/LocationManager;
    check-cast v13, Landroid/location/LocationManager;

    .line 91
    .restart local v13    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/location/LocationManager;
    :cond_0
    :try_start_1
    const-string v1, "gps"

    invoke-virtual {v13, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    move-result v11

    .line 94
    :goto_1
    :try_start_2
    const-string v1, "network"

    invoke-virtual {v13, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    move-result v12

    .line 97
    :goto_2
    if-nez v11, :cond_1

    if-nez v12, :cond_1

    .line 98
    new-instance v6, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v6, p0}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 99
    .local v6, "O":Landroid/support/v7/app/AlertDialog$Builder;
    const-string v1, "Please turn on Location Service for the full experience"

    invoke-virtual {v6, v1}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 100
    const-string v1, "Setting"

    new-instance v4, Lcom/woop/tryreverseengineerthis/O$2;

    invoke-direct {v4, p0}, Lcom/woop/tryreverseengineerthis/O$2;-><init>(Lcom/woop/tryreverseengineerthis/O;)V

    invoke-virtual {v6, v1, v4}, Landroid/support/v7/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 106
    const-string v1, "Cancel"

    new-instance v4, Lcom/woop/tryreverseengineerthis/O$3;

    invoke-direct {v4, p0}, Lcom/woop/tryreverseengineerthis/O$3;-><init>(Lcom/woop/tryreverseengineerthis/O;)V

    invoke-virtual {v6, v1, v4}, Landroid/support/v7/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 112
    invoke-virtual {v6}, Landroid/support/v7/app/AlertDialog$Builder;->show()Landroid/support/v7/app/AlertDialog;

    .line 117
    .end local v6    # "O":Landroid/support/v7/app/AlertDialog$Builder;
    :goto_3
    const-string v1, "NothingToSeeHere"

    const-string v4, "Downloading ram..."

    invoke-static {v1, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    return-void

    .line 54
    .end local v0    # "toggle":Landroid/support/v7/app/ActionBarDrawerToggle;
    .end local v2    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/v4/widget/DrawerLayout;
    .end local v8    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/design/widget/FloatingActionButton;
    .end local v9    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/content/Intent;
    .end local v10    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/support/design/widget/NavigationView;
    .end local v11    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Z
    .end local v12    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Z
    .end local v13    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/location/LocationManager;
    :catch_0
    move-exception v7

    .line 58
    .local v7, "e":Ljavax/crypto/NoSuchPaddingException;
    goto/16 :goto_0

    .line 56
    .end local v7    # "e":Ljavax/crypto/NoSuchPaddingException;
    :catch_1
    move-exception v7

    .line 57
    .local v7, "e":Ljava/security/NoSuchAlgorithmException;
    goto/16 :goto_0

    .line 114
    .end local v7    # "e":Ljava/security/NoSuchAlgorithmException;
    .restart local v0    # "toggle":Landroid/support/v7/app/ActionBarDrawerToggle;
    .restart local v2    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/v4/widget/DrawerLayout;
    .restart local v8    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/design/widget/FloatingActionButton;
    .restart local v9    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/content/Intent;
    .restart local v10    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Landroid/support/design/widget/NavigationView;
    .restart local v11    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Z
    .restart local v12    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1":Z
    .restart local v13    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/location/LocationManager;
    :cond_1
    const-string v1, "NothingToSeeHere"

    const-string v4, "Downloading ram..."

    invoke-static {v1, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 95
    :catch_2
    move-exception v1

    goto :goto_2

    .line 92
    :catch_3
    move-exception v1

    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "o1o1o1o1o1o1o1o1"    # Landroid/view/Menu;

    .prologue
    .line 152
    invoke-virtual {p0}, Lcom/woop/tryreverseengineerthis/O;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f0e0001

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 153
    const/4 v0, 0x1

    return v0
.end method

.method public onListFragmentInteraction(Lcom/woop/tryreverseengineerthis/F$G;)V
    .locals 36
    .param p1, "o1o1o1o1o1o1o1o1o"    # Lcom/woop/tryreverseengineerthis/F$G;

    .prologue
    .line 203
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 204
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1:Ljava/lang/String;

    .line 206
    .local v2, "O1O1O1O1O1O1O1O":Ljava/lang/String;
    const-string v3, "apsojdojaspdjaspo"

    .line 207
    .local v3, "O1O1O1O1O1O1O1O1":Ljava/lang/String;
    const-string v4, "dj20jd02j0d2j0d2jd0"

    .line 208
    .local v4, "O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    const-string v5, "apsodjpo2jdopj1oassd"

    .line 209
    .local v5, "O1O1O1O1O1O1O1O1O1":Ljava/lang/String;
    const-string v6, "dasodj02jd02jd02d2"

    .line 210
    .local v6, "O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    const-string v7, "aspodjaopdjasodjasso"

    .line 211
    .local v7, "O1O1O1O1O1O1O1O1O1O1":Ljava/lang/String;
    const-string v8, "sojodsojdsjodsojsdjo11"

    .line 213
    .local v8, "O1O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    :try_start_0
    invoke-static {v3}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 214
    invoke-static {v4}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 215
    invoke-static {v5}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 216
    invoke-static {v6}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 217
    invoke-static {v7}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 218
    invoke-static {v8}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 224
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/woop/tryreverseengineerthis/F$G;->L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L:Ljava/lang/String;

    move-object/from16 v33, v0

    const-string v34, "1"

    invoke-virtual/range {v33 .. v34}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v33

    if-nez v33, :cond_0

    .line 225
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    const/16 v34, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v34

    invoke-static {v0, v8, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    .line 298
    :goto_0
    return-void

    .line 219
    :catch_0
    move-exception v32

    .line 220
    .local v32, "e":Ljava/lang/Exception;
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 229
    .end local v32    # "e":Ljava/lang/Exception;
    :cond_0
    invoke-static {}, Lcom/woop/tryreverseengineerthis/H;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l()Landroid/location/Location;

    move-result-object v9

    .line 230
    .local v9, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1":Landroid/location/Location;
    if-nez v9, :cond_1

    .line 231
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    const/16 v34, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v34

    invoke-static {v0, v4, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 237
    :cond_1
    invoke-virtual {v9}, Landroid/location/Location;->getLongitude()D

    move-result-wide v10

    .line 238
    .local v10, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":D
    invoke-virtual {v9}, Landroid/location/Location;->getLatitude()D

    move-result-wide v12

    .line 239
    .local v12, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":D
    const-string v14, "d2jasaSD2dasd=="

    .line 240
    .local v14, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    const-string v15, "sdD22d3daSd2=="

    .line 241
    .local v15, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":Ljava/lang/String;
    const-string v16, "asd202d0asD2=="

    .line 242
    .local v16, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    const-string v17, "asdk22d2djiasd0"

    .line 243
    .local v17, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":Ljava/lang/String;
    const-string v18, "a2d0jdASd22ASd22j0"

    .line 244
    .local v18, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    const-wide/16 v20, 0x0

    .line 245
    .local v20, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":D
    const-wide/16 v22, 0x0

    .line 246
    .local v22, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":D
    const-wide/16 v24, 0x0

    .line 247
    .local v24, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":D
    const-wide/16 v26, 0x0

    .line 249
    .local v26, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":D
    :try_start_1
    invoke-static {v14}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v33

    invoke-static/range {v33 .. v33}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v20

    .line 250
    invoke-static {v15}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v33

    invoke-static/range {v33 .. v33}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v22

    .line 251
    invoke-static/range {v16 .. v16}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v33

    invoke-static/range {v33 .. v33}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v24

    .line 252
    invoke-static/range {v17 .. v17}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v33

    invoke-static/range {v33 .. v33}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v26

    .line 253
    invoke-static/range {v18 .. v18}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v18

    .line 258
    cmpg-double v33, v12, v20

    if-ltz v33, :cond_2

    cmpl-double v33, v12, v22

    if-lez v33, :cond_3

    .line 260
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    const/16 v34, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v34

    invoke-static {v0, v5, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    .line 262
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 254
    :catch_1
    move-exception v32

    .line 255
    .restart local v32    # "e":Ljava/lang/Exception;
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 266
    .end local v32    # "e":Ljava/lang/Exception;
    :cond_3
    cmpg-double v33, v10, v24

    if-ltz v33, :cond_4

    cmpl-double v33, v10, v26

    if-lez v33, :cond_5

    .line 267
    :cond_4
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    const/16 v34, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v34

    invoke-static {v0, v5, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    .line 269
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 272
    :cond_5
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v19

    .line 273
    .local v19, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/util/Calendar;
    new-instance v28, Ljava/text/SimpleDateFormat;

    const-string v33, "HH"

    move-object/from16 v0, v28

    move-object/from16 v1, v33

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 274
    .local v28, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":Ljava/text/SimpleDateFormat;
    invoke-virtual/range {v19 .. v19}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v33

    move-object/from16 v0, v28

    move-object/from16 v1, v33

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v29

    .line 275
    .local v29, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    const/16 v33, 0x7

    move-object/from16 v0, v19

    move/from16 v1, v33

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v30

    .line 276
    .local v30, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1":I
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 277
    const-string v33, "NothingToSeeHere"

    const-string v34, "Downloading ram..."

    invoke-static/range {v33 .. v34}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v33

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, ""

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    move-object/from16 v0, v18

    move-object/from16 v1, v33

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v33

    if-nez v33, :cond_6

    .line 279
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    new-instance v34, Ljava/lang/StringBuilder;

    invoke-direct/range {v34 .. v34}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v34

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v34

    const/16 v35, 0x0

    invoke-static/range {v33 .. v35}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 283
    :cond_6
    const-string v31, "ajd202ASsd20L02"

    .line 285
    .local v31, "O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O":Ljava/lang/String;
    :try_start_2
    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v33

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    move-object/from16 v0, v33

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-static/range {v33 .. v33}, Lcom/woop/tryreverseengineerthis/I;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v31

    .line 291
    move-object/from16 v0, v31

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v33

    if-nez v33, :cond_7

    .line 292
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    const/16 v34, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v34

    invoke-static {v0, v6, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 286
    :catch_2
    move-exception v32

    .line 287
    .restart local v32    # "e":Ljava/lang/Exception;
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    new-instance v34, Ljava/lang/StringBuilder;

    invoke-direct/range {v34 .. v34}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v34

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v34

    const/16 v35, 0x0

    invoke-static/range {v33 .. v35}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 296
    .end local v32    # "e":Ljava/lang/Exception;
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lcom/woop/tryreverseengineerthis/O;->getApplicationContext()Landroid/content/Context;

    move-result-object v33

    const/16 v34, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v34

    invoke-static {v0, v7, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0
.end method

.method public onNavigationItemSelected(Landroid/view/MenuItem;)Z
    .locals 6
    .param p1, "o1o1o1o1o1o1o1o1o"    # Landroid/view/MenuItem;

    .prologue
    .line 175
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 176
    .local v0, "O1O1":I
    invoke-virtual {p0}, Lcom/woop/tryreverseengineerthis/O;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 177
    .local v1, "O1O1O1":Landroid/support/v4/app/FragmentManager;
    const/4 v2, 0x0

    .line 178
    .local v2, "O1O1O1O":Landroid/support/v4/app/Fragment;
    const v4, 0x7f0d00c6

    if-ne v0, v4, :cond_1

    .line 179
    new-instance v2, Landroid/support/v4/app/Fragment;

    .end local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    invoke-direct {v2}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 192
    .restart local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    :cond_0
    :goto_0
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    const v5, 0x7f0d0094

    invoke-virtual {v4, v5, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 196
    const v4, 0x7f0d0090

    invoke-virtual {p0, v4}, Lcom/woop/tryreverseengineerthis/O;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/support/v4/widget/DrawerLayout;

    .line 197
    .local v3, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/v4/widget/DrawerLayout;
    const v4, 0x800003

    invoke-virtual {v3, v4}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 198
    const/4 v4, 0x1

    return v4

    .line 180
    .end local v3    # "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/support/v4/widget/DrawerLayout;
    :cond_1
    const v4, 0x7f0d00c8

    if-ne v0, v4, :cond_2

    .line 181
    new-instance v2, Landroid/support/v4/app/Fragment;

    .end local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    invoke-direct {v2}, Landroid/support/v4/app/Fragment;-><init>()V

    .restart local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 182
    :cond_2
    const v4, 0x7f0d00c9

    if-ne v0, v4, :cond_3

    .line 183
    new-instance v2, Lcom/woop/tryreverseengineerthis/A;

    .end local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    invoke-direct {v2}, Lcom/woop/tryreverseengineerthis/A;-><init>()V

    .restart local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 184
    :cond_3
    const v4, 0x7f0d00c7

    if-ne v0, v4, :cond_4

    .line 185
    new-instance v2, Landroid/support/v4/app/Fragment;

    .end local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    invoke-direct {v2}, Landroid/support/v4/app/Fragment;-><init>()V

    .restart local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 186
    :cond_4
    const v4, 0x7f0d00ca

    if-ne v0, v4, :cond_5

    .line 187
    new-instance v2, Landroid/support/v4/app/Fragment;

    .end local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    invoke-direct {v2}, Landroid/support/v4/app/Fragment;-><init>()V

    .restart local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 188
    :cond_5
    const v4, 0x7f0d00cb

    if-ne v0, v4, :cond_0

    .line 189
    new-instance v2, Landroid/support/v4/app/Fragment;

    .end local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    invoke-direct {v2}, Landroid/support/v4/app/Fragment;-><init>()V

    .restart local v2    # "O1O1O1O":Landroid/support/v4/app/Fragment;
    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "o1o1o1o1o1o1o1o1o"    # Landroid/view/MenuItem;

    .prologue
    .line 161
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 164
    .local v0, "O1O1":I
    const v1, 0x7f0d00cc

    if-ne v0, v1, :cond_0

    .line 165
    const/4 v1, 0x1

    .line 168
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0
.end method

.method public onResume()V
    .locals 7

    .prologue
    .line 122
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 124
    const-string v1, "location"

    invoke-virtual {p0, v1}, Lcom/woop/tryreverseengineerthis/O;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 126
    .local v0, "l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l":Landroid/location/LocationManager;
    new-instance v1, Lcom/woop/tryreverseengineerthis/M;

    invoke-direct {v1}, Lcom/woop/tryreverseengineerthis/M;-><init>()V

    iput-object v1, p0, Lcom/woop/tryreverseengineerthis/O;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Lcom/woop/tryreverseengineerthis/M;

    .line 128
    :try_start_0
    const-string v1, "network"

    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/woop/tryreverseengineerthis/O;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Lcom/woop/tryreverseengineerthis/M;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 130
    const-string v1, "gps"

    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/woop/tryreverseengineerthis/O;->l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l:Lcom/woop/tryreverseengineerthis/M;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 132
    const-string v1, "NothingToSeeHere"

    const-string v2, "Downloading ram..."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 137
    :goto_0
    return-void

    .line 133
    :catch_0
    move-exception v6

    .line 135
    .local v6, "e":Ljava/lang/SecurityException;
    const-string v1, "NothingToSeeHere"

    const-string v2, "Downloading ram..."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
