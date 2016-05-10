.class public Lcom/example/reforceapk/ProxyApplication;
.super Landroid/app/Application;
.source "ProxyApplication.java"


# static fields
.field private static final appkey:Ljava/lang/String; = "APPLICATION_CLASS_NAME"


# instance fields
.field private JhhYdeaasKk:Ljava/lang/String;

.field private UUybjNNbf:Ljava/lang/String;

.field private jUHJJGTDSpLKD:Ljava/lang/String;

.field protected mAssetManager:Landroid/content/res/AssetManager;

.field protected mResources:Landroid/content/res/Resources;

.field protected mTheme:Landroid/content/res/Resources$Theme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method private jgsyagjwnbas([B)[B
    .locals 3
    .param p1, "kjnxascsdsdc"    # [B

    .prologue
    .line 275
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_0

    .line 276
    aget-byte v1, p1, v0

    .line 277
    .local v1, "sxnkqjwnqjkwn":B
    array-length v2, p1

    sub-int/2addr v2, v0

    add-int/lit8 v2, v2, -0x1

    aget-byte v2, p1, v2

    aput-byte v2, p1, v0

    .line 278
    array-length v2, p1

    sub-int/2addr v2, v0

    add-int/lit8 v2, v2, -0x1

    aput-byte v1, p1, v2

    .line 279
    aget-byte v2, p1, v0

    xor-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, p1, v0

    .line 275
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 281
    .end local v1    # "sxnkqjwnqjkwn":B
    :cond_0
    return-object p1
.end method

.method private readDexFileFromApk()[B
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 237
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 238
    .local v1, "dexByteArrayOutputStream":Ljava/io/ByteArrayOutputStream;
    new-instance v4, Ljava/util/zip/ZipInputStream;

    new-instance v5, Ljava/io/BufferedInputStream;

    new-instance v6, Ljava/io/FileInputStream;

    invoke-virtual {p0}, Lcom/example/reforceapk/ProxyApplication;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v7

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-direct {v6, v7}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v5, v6}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v5}, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V

    .line 242
    .local v4, "localZipInputStream":Ljava/util/zip/ZipInputStream;
    :goto_0
    invoke-virtual {v4}, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;

    move-result-object v3

    .line 243
    .local v3, "localZipEntry":Ljava/util/zip/ZipEntry;
    if-nez v3, :cond_0

    .line 244
    invoke-virtual {v4}, Ljava/util/zip/ZipInputStream;->close()V

    .line 258
    invoke-virtual {v4}, Ljava/util/zip/ZipInputStream;->close()V

    .line 259
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

    return-object v5

    .line 247
    :cond_0
    invoke-virtual {v3}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "classes.dex"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 248
    const/16 v5, 0x400

    new-array v0, v5, [B

    .line 250
    .local v0, "arrayOfByte":[B
    :goto_1
    invoke-virtual {v4, v0}, Ljava/util/zip/ZipInputStream;->read([B)I

    move-result v2

    .line 251
    .local v2, "i":I
    const/4 v5, -0x1

    if-ne v2, v5, :cond_2

    .line 256
    .end local v0    # "arrayOfByte":[B
    .end local v2    # "i":I
    :cond_1
    invoke-virtual {v4}, Ljava/util/zip/ZipInputStream;->closeEntry()V

    goto :goto_0

    .line 253
    .restart local v0    # "arrayOfByte":[B
    .restart local v2    # "i":I
    :cond_2
    const/4 v5, 0x0

    invoke-virtual {v1, v0, v5, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_1
.end method

.method private sdkjfh([BLjava/lang/String;)[B
    .locals 7
    .param p1, "bjhbjhhbj"    # [B
    .param p2, "kjnnknhhgbjh"    # Ljava/lang/String;

    .prologue
    .line 264
    invoke-virtual {p2}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    .line 265
    .local v1, "buhbuhbh":[C
    move-object v0, v1

    .local v0, "arr$":[C
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_1

    aget-char v2, v0, v4

    .line 267
    .local v2, "ck":C
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v6, p1

    if-ge v3, v6, :cond_0

    .line 268
    aget-byte v6, p1, v3

    xor-int/2addr v6, v2

    int-to-byte v6, v6

    aput-byte v6, p1, v3

    .line 267
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 265
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 271
    .end local v2    # "ck":C
    .end local v3    # "i":I
    :cond_1
    return-object p1
.end method

.method private splitPayLoadFromDex([B)V
    .locals 23
    .param p1, "apkdata"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 177
    move-object/from16 v0, p1

    array-length v6, v0

    .line 179
    .local v6, "KJhjnjkxs":I
    const/16 v20, 0x4

    move/from16 v0, v20

    new-array v4, v0, [B

    .line 180
    .local v4, "KJJSKA":[B
    add-int/lit8 v20, v6, -0x4

    const/16 v21, 0x0

    const/16 v22, 0x4

    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v21

    move/from16 v3, v22

    invoke-static {v0, v1, v4, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 181
    new-instance v9, Ljava/io/ByteArrayInputStream;

    invoke-direct {v9, v4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 182
    .local v9, "bais":Ljava/io/ByteArrayInputStream;
    new-instance v13, Ljava/io/DataInputStream;

    invoke-direct {v13, v9}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 183
    .local v13, "in":Ljava/io/DataInputStream;
    invoke-virtual {v13}, Ljava/io/DataInputStream;->readInt()I

    move-result v5

    .line 184
    .local v5, "KJhjks":I
    sget-object v20, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 185
    new-array v7, v5, [B

    .line 187
    .local v7, "KSCJKBSDK":[B
    add-int/lit8 v20, v6, -0x4

    sub-int v20, v20, v5

    const/16 v21, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v7, v2, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 190
    const-string v20, "Ivy"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v7, v1}, Lcom/example/reforceapk/ProxyApplication;->sdkjfh([BLjava/lang/String;)[B

    move-result-object v7

    .line 193
    new-instance v10, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/example/reforceapk/ProxyApplication;->JhhYdeaasKk:Ljava/lang/String;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    invoke-direct {v10, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 195
    .local v10, "file":Ljava/io/File;
    :try_start_0
    new-instance v14, Ljava/io/FileOutputStream;

    invoke-direct {v14, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 196
    .local v14, "localFileOutputStream":Ljava/io/FileOutputStream;
    invoke-virtual {v14, v7}, Ljava/io/FileOutputStream;->write([B)V

    .line 197
    invoke-virtual {v14}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 203
    new-instance v17, Ljava/util/zip/ZipInputStream;

    new-instance v20, Ljava/io/BufferedInputStream;

    new-instance v21, Ljava/io/FileInputStream;

    move-object/from16 v0, v21

    invoke-direct {v0, v10}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct/range {v20 .. v21}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V

    .line 206
    .local v17, "localZipInputStream":Ljava/util/zip/ZipInputStream;
    :goto_0
    invoke-virtual/range {v17 .. v17}, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;

    move-result-object v16

    .line 207
    .local v16, "localZipEntry":Ljava/util/zip/ZipEntry;
    if-nez v16, :cond_0

    .line 208
    invoke-virtual/range {v17 .. v17}, Ljava/util/zip/ZipInputStream;->close()V

    .line 230
    invoke-virtual/range {v17 .. v17}, Ljava/util/zip/ZipInputStream;->close()V

    .line 233
    return-void

    .line 198
    .end local v14    # "localFileOutputStream":Ljava/io/FileOutputStream;
    .end local v16    # "localZipEntry":Ljava/util/zip/ZipEntry;
    .end local v17    # "localZipInputStream":Ljava/util/zip/ZipInputStream;
    :catch_0
    move-exception v15

    .line 199
    .local v15, "localIOException":Ljava/io/IOException;
    new-instance v20, Ljava/lang/RuntimeException;

    move-object/from16 v0, v20

    invoke-direct {v0, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v20

    .line 212
    .end local v15    # "localIOException":Ljava/io/IOException;
    .restart local v14    # "localFileOutputStream":Ljava/io/FileOutputStream;
    .restart local v16    # "localZipEntry":Ljava/util/zip/ZipEntry;
    .restart local v17    # "localZipInputStream":Ljava/util/zip/ZipInputStream;
    :cond_0
    invoke-virtual/range {v16 .. v16}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v18

    .line 213
    .local v18, "name":Ljava/lang/String;
    const-string v20, "lib/"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_1

    const-string v20, ".so"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_1

    .line 214
    new-instance v19, Ljava/io/File;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/example/reforceapk/ProxyApplication;->jUHJJGTDSpLKD:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "/"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const/16 v21, 0x2f

    move-object/from16 v0, v18

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v21

    move-object/from16 v0, v18

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 216
    .local v19, "storeFile":Ljava/io/File;
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->createNewFile()Z

    .line 217
    new-instance v11, Ljava/io/FileOutputStream;

    move-object/from16 v0, v19

    invoke-direct {v11, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 218
    .local v11, "fos":Ljava/io/FileOutputStream;
    const/16 v20, 0x400

    move/from16 v0, v20

    new-array v8, v0, [B

    .line 220
    .local v8, "arrayOfByte":[B
    :goto_1
    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/util/zip/ZipInputStream;->read([B)I

    move-result v12

    .line 221
    .local v12, "i":I
    const/16 v20, -0x1

    move/from16 v0, v20

    if-ne v12, v0, :cond_2

    .line 225
    invoke-virtual {v11}, Ljava/io/FileOutputStream;->flush()V

    .line 226
    invoke-virtual {v11}, Ljava/io/FileOutputStream;->close()V

    .line 228
    .end local v8    # "arrayOfByte":[B
    .end local v11    # "fos":Ljava/io/FileOutputStream;
    .end local v12    # "i":I
    .end local v19    # "storeFile":Ljava/io/File;
    :cond_1
    invoke-virtual/range {v17 .. v17}, Ljava/util/zip/ZipInputStream;->closeEntry()V

    goto/16 :goto_0

    .line 223
    .restart local v8    # "arrayOfByte":[B
    .restart local v11    # "fos":Ljava/io/FileOutputStream;
    .restart local v12    # "i":I
    .restart local v19    # "storeFile":Ljava/io/File;
    :cond_2
    const/16 v20, 0x0

    move/from16 v0, v20

    invoke-virtual {v11, v8, v0, v12}, Ljava/io/FileOutputStream;->write([BII)V

    goto :goto_1
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .locals 17
    .param p1, "base"    # Landroid/content/Context;

    .prologue
    .line 42
    invoke-super/range {p0 .. p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    .line 45
    :try_start_0
    const-string v11, "payload_odex"

    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v11, v12}, Lcom/example/reforceapk/ProxyApplication;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v9

    .line 46
    .local v9, "odex":Ljava/io/File;
    const-string v11, "payload_lib"

    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v11, v12}, Lcom/example/reforceapk/ProxyApplication;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v7

    .line 47
    .local v7, "libs":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p0

    iput-object v11, v0, Lcom/example/reforceapk/ProxyApplication;->UUybjNNbf:Ljava/lang/String;

    .line 48
    invoke-virtual {v7}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p0

    iput-object v11, v0, Lcom/example/reforceapk/ProxyApplication;->jUHJJGTDSpLKD:Ljava/lang/String;

    .line 49
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "/payload.apk"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p0

    iput-object v11, v0, Lcom/example/reforceapk/ProxyApplication;->JhhYdeaasKk:Ljava/lang/String;

    .line 50
    new-instance v6, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/example/reforceapk/ProxyApplication;->JhhYdeaasKk:Ljava/lang/String;

    invoke-direct {v6, v11}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 52
    .local v6, "kkJSHFCuiyrd":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v11

    if-nez v11, :cond_0

    .line 54
    invoke-virtual {v6}, Ljava/io/File;->createNewFile()Z

    .line 56
    invoke-direct/range {p0 .. p0}, Lcom/example/reforceapk/ProxyApplication;->readDexFileFromApk()[B

    move-result-object v3

    .line 59
    .local v3, "dexdata":[B
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/example/reforceapk/ProxyApplication;->splitPayLoadFromDex([B)V

    .line 62
    .end local v3    # "dexdata":[B
    :cond_0
    const-string v11, "android.app.ActivityThread"

    const-string v12, "currentActivityThread"

    const/4 v13, 0x0

    new-array v13, v13, [Ljava/lang/Class;

    const/4 v14, 0x0

    new-array v14, v14, [Ljava/lang/Object;

    invoke-static {v11, v12, v13, v14}, Lcom/example/reforceapk/RefInvoke;->invokeStaticMethod(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 65
    .local v1, "currentActivityThread":Ljava/lang/Object;
    invoke-virtual/range {p0 .. p0}, Lcom/example/reforceapk/ProxyApplication;->getPackageName()Ljava/lang/String;

    move-result-object v5

    .line 67
    .local v5, "kjhhgfTYRE":Ljava/lang/String;
    const-string v11, "android.app.ActivityThread"

    const-string v12, "mPackages"

    invoke-static {v11, v1, v12}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    .line 70
    .local v8, "mPackages":Ljava/util/HashMap;
    invoke-virtual {v8, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/ref/WeakReference;

    .line 72
    .local v10, "wr":Ljava/lang/ref/WeakReference;
    new-instance v2, Ldalvik/system/DexClassLoader;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/example/reforceapk/ProxyApplication;->JhhYdeaasKk:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/example/reforceapk/ProxyApplication;->UUybjNNbf:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/example/reforceapk/ProxyApplication;->jUHJJGTDSpLKD:Ljava/lang/String;

    const-string v11, "android.app.LoadedApk"

    invoke-virtual {v10}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v15

    const-string v16, "mClassLoader"

    move-object/from16 v0, v16

    invoke-static {v11, v15, v0}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/ClassLoader;

    invoke-direct {v2, v12, v13, v14, v11}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    .line 76
    .local v2, "dLoader":Ldalvik/system/DexClassLoader;
    const-string v11, "android.app.LoadedApk"

    const-string v12, "mClassLoader"

    invoke-virtual {v10}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v13

    invoke-static {v11, v12, v13, v2}, Lcom/example/reforceapk/RefInvoke;->setFieldOjbect(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :try_start_1
    const-string v11, "com.bojunjin.whotouchedmyphone.MainActivity"

    invoke-virtual {v2, v11}, Ldalvik/system/DexClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 93
    .end local v1    # "currentActivityThread":Ljava/lang/Object;
    .end local v2    # "dLoader":Ldalvik/system/DexClassLoader;
    .end local v5    # "kjhhgfTYRE":Ljava/lang/String;
    .end local v6    # "kkJSHFCuiyrd":Ljava/io/File;
    .end local v7    # "libs":Ljava/io/File;
    .end local v8    # "mPackages":Ljava/util/HashMap;
    .end local v9    # "odex":Ljava/io/File;
    .end local v10    # "wr":Ljava/lang/ref/WeakReference;
    :goto_0
    return-void

    .line 89
    :catch_0
    move-exception v4

    .line 91
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 84
    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v1    # "currentActivityThread":Ljava/lang/Object;
    .restart local v2    # "dLoader":Ldalvik/system/DexClassLoader;
    .restart local v5    # "kjhhgfTYRE":Ljava/lang/String;
    .restart local v6    # "kkJSHFCuiyrd":Ljava/io/File;
    .restart local v7    # "libs":Ljava/io/File;
    .restart local v8    # "mPackages":Ljava/util/HashMap;
    .restart local v9    # "odex":Ljava/io/File;
    .restart local v10    # "wr":Ljava/lang/ref/WeakReference;
    :catch_1
    move-exception v11

    goto :goto_0
.end method

.method public getAssets()Landroid/content/res/AssetManager;
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/example/reforceapk/ProxyApplication;->mAssetManager:Landroid/content/res/AssetManager;

    if-nez v0, :cond_0

    invoke-super {p0}, Landroid/app/Application;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/example/reforceapk/ProxyApplication;->mAssetManager:Landroid/content/res/AssetManager;

    goto :goto_0
.end method

.method public getResources()Landroid/content/res/Resources;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/example/reforceapk/ProxyApplication;->mResources:Landroid/content/res/Resources;

    if-nez v0, :cond_0

    invoke-super {p0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/example/reforceapk/ProxyApplication;->mResources:Landroid/content/res/Resources;

    goto :goto_0
.end method

.method public getTheme()Landroid/content/res/Resources$Theme;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lcom/example/reforceapk/ProxyApplication;->mTheme:Landroid/content/res/Resources$Theme;

    if-nez v0, :cond_0

    invoke-super {p0}, Landroid/app/Application;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/example/reforceapk/ProxyApplication;->mTheme:Landroid/content/res/Resources$Theme;

    goto :goto_0
.end method

.method protected loadResources(Ljava/lang/String;)V
    .locals 9
    .param p1, "dexPath"    # Ljava/lang/String;

    .prologue
    .line 292
    :try_start_0
    const-class v4, Landroid/content/res/AssetManager;

    invoke-virtual {v4}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/res/AssetManager;

    .line 293
    .local v1, "assetManager":Landroid/content/res/AssetManager;
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const-string v5, "addAssetPath"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Class;

    const/4 v7, 0x0

    const-class v8, Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 294
    .local v0, "addAssetPath":Ljava/lang/reflect/Method;
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-virtual {v0, v1, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 295
    iput-object v1, p0, Lcom/example/reforceapk/ProxyApplication;->mAssetManager:Landroid/content/res/AssetManager;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 300
    .end local v0    # "addAssetPath":Ljava/lang/reflect/Method;
    .end local v1    # "assetManager":Landroid/content/res/AssetManager;
    :goto_0
    invoke-super {p0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 301
    .local v3, "superRes":Landroid/content/res/Resources;
    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    .line 302
    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    .line 303
    new-instance v4, Landroid/content/res/Resources;

    iget-object v5, p0, Lcom/example/reforceapk/ProxyApplication;->mAssetManager:Landroid/content/res/AssetManager;

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v7

    invoke-direct {v4, v5, v6, v7}, Landroid/content/res/Resources;-><init>(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V

    iput-object v4, p0, Lcom/example/reforceapk/ProxyApplication;->mResources:Landroid/content/res/Resources;

    .line 304
    iget-object v4, p0, Lcom/example/reforceapk/ProxyApplication;->mResources:Landroid/content/res/Resources;

    invoke-virtual {v4}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    iput-object v4, p0, Lcom/example/reforceapk/ProxyApplication;->mTheme:Landroid/content/res/Resources$Theme;

    .line 305
    iget-object v4, p0, Lcom/example/reforceapk/ProxyApplication;->mTheme:Landroid/content/res/Resources$Theme;

    invoke-super {p0}, Landroid/app/Application;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 306
    return-void

    .line 296
    .end local v3    # "superRes":Landroid/content/res/Resources;
    :catch_0
    move-exception v2

    .line 298
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onCreate()V
    .locals 26

    .prologue
    .line 99
    invoke-super/range {p0 .. p0}, Landroid/app/Application;->onCreate()V

    .line 102
    const/4 v7, 0x0

    .line 104
    .local v7, "appClassName":Ljava/lang/String;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/example/reforceapk/ProxyApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v20

    invoke-virtual/range {p0 .. p0}, Lcom/example/reforceapk/ProxyApplication;->getPackageName()Ljava/lang/String;

    move-result-object v21

    const/16 v22, 0x80

    invoke-virtual/range {v20 .. v22}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v5

    .line 107
    .local v5, "IvyBang":Landroid/content/pm/ApplicationInfo;
    iget-object v4, v5, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 108
    .local v4, "BnagBnag":Landroid/os/Bundle;
    if-eqz v4, :cond_1

    const-string v20, "APPLICATION_CLASS_NAME"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_1

    .line 109
    const-string v20, "APPLICATION_CLASS_NAME"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 119
    .end local v4    # "BnagBnag":Landroid/os/Bundle;
    .end local v5    # "IvyBang":Landroid/content/pm/ApplicationInfo;
    :goto_0
    const-string v20, "android.app.ActivityThread"

    const-string v21, "currentActivityThread"

    const/16 v22, 0x0

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Class;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-static/range {v20 .. v23}, Lcom/example/reforceapk/RefInvoke;->invokeStaticMethod(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    .line 122
    .local v10, "currentActivityThread":Ljava/lang/Object;
    const-string v20, "android.app.ActivityThread"

    const-string v21, "mBoundApplication"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v10, v1}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v16

    .line 125
    .local v16, "mBoundApplication":Ljava/lang/Object;
    const-string v20, "android.app.ActivityThread$AppBindData"

    const-string v21, "info"

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    move-object/from16 v2, v21

    invoke-static {v0, v1, v2}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v13

    .line 129
    .local v13, "loadedApkInfo":Ljava/lang/Object;
    const-string v20, "android.app.LoadedApk"

    const-string v21, "mApplication"

    const/16 v22, 0x0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-static {v0, v1, v13, v2}, Lcom/example/reforceapk/RefInvoke;->setFieldOjbect(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 131
    const-string v20, "android.app.ActivityThread"

    const-string v21, "mInitialApplication"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v10, v1}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v18

    .line 135
    .local v18, "oldApplication":Ljava/lang/Object;
    const-string v20, "android.app.ActivityThread"

    const-string v21, "mAllApplications"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v10, v1}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/util/ArrayList;

    .line 138
    .local v15, "mAllApplications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/app/Application;>;"
    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 140
    const-string v20, "android.app.LoadedApk"

    const-string v21, "mApplicationInfo"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v13, v1}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    .line 143
    .local v9, "appinfo_In_LoadedApk":Landroid/content/pm/ApplicationInfo;
    const-string v20, "android.app.ActivityThread$AppBindData"

    const-string v21, "appInfo"

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    move-object/from16 v2, v21

    invoke-static {v0, v1, v2}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    .line 146
    .local v8, "appinfo_In_AppBindData":Landroid/content/pm/ApplicationInfo;
    iput-object v7, v9, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    .line 147
    iput-object v7, v8, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    .line 148
    const-string v20, "android.app.LoadedApk"

    const-string v21, "makeApplication"

    const/16 v22, 0x2

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Class;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    sget-object v24, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v24, v22, v23

    const/16 v23, 0x1

    const-class v24, Landroid/app/Instrumentation;

    aput-object v24, v22, v23

    const/16 v23, 0x2

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v25

    aput-object v25, v23, v24

    const/16 v24, 0x1

    const/16 v25, 0x0

    aput-object v25, v23, v24

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move-object/from16 v3, v23

    invoke-static {v0, v1, v13, v2, v3}, Lcom/example/reforceapk/RefInvoke;->invokeMethod(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/app/Application;

    .line 152
    .local v6, "app":Landroid/app/Application;
    const-string v20, "android.app.ActivityThread"

    const-string v21, "mInitialApplication"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v10, v6}, Lcom/example/reforceapk/RefInvoke;->setFieldOjbect(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 156
    const-string v20, "android.app.ActivityThread"

    const-string v21, "mProviderMap"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v10, v1}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/util/HashMap;

    .line 159
    .local v17, "mProviderMap":Ljava/util/HashMap;
    invoke-virtual/range {v17 .. v17}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .line 160
    .local v12, "it":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_0

    .line 161
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    .line 162
    .local v19, "providerClientRecord":Ljava/lang/Object;
    const-string v20, "android.app.ActivityThread$ProviderClientRecord"

    const-string v21, "mLocalProvider"

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    move-object/from16 v2, v21

    invoke-static {v0, v1, v2}, Lcom/example/reforceapk/RefInvoke;->getFieldOjbect(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v14

    .line 165
    .local v14, "localProvider":Ljava/lang/Object;
    const-string v20, "android.content.ContentProvider"

    const-string v21, "mContext"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v14, v6}, Lcom/example/reforceapk/RefInvoke;->setFieldOjbect(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_1

    .line 114
    .end local v6    # "app":Landroid/app/Application;
    .end local v8    # "appinfo_In_AppBindData":Landroid/content/pm/ApplicationInfo;
    .end local v9    # "appinfo_In_LoadedApk":Landroid/content/pm/ApplicationInfo;
    .end local v10    # "currentActivityThread":Ljava/lang/Object;
    .end local v12    # "it":Ljava/util/Iterator;
    .end local v13    # "loadedApkInfo":Ljava/lang/Object;
    .end local v14    # "localProvider":Ljava/lang/Object;
    .end local v15    # "mAllApplications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/app/Application;>;"
    .end local v16    # "mBoundApplication":Ljava/lang/Object;
    .end local v17    # "mProviderMap":Ljava/util/HashMap;
    .end local v18    # "oldApplication":Ljava/lang/Object;
    .end local v19    # "providerClientRecord":Ljava/lang/Object;
    :catch_0
    move-exception v11

    .line 116
    .local v11, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v11}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 171
    .end local v11    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v6    # "app":Landroid/app/Application;
    .restart local v8    # "appinfo_In_AppBindData":Landroid/content/pm/ApplicationInfo;
    .restart local v9    # "appinfo_In_LoadedApk":Landroid/content/pm/ApplicationInfo;
    .restart local v10    # "currentActivityThread":Ljava/lang/Object;
    .restart local v12    # "it":Ljava/util/Iterator;
    .restart local v13    # "loadedApkInfo":Ljava/lang/Object;
    .restart local v15    # "mAllApplications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/app/Application;>;"
    .restart local v16    # "mBoundApplication":Ljava/lang/Object;
    .restart local v17    # "mProviderMap":Ljava/util/HashMap;
    .restart local v18    # "oldApplication":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v6}, Landroid/app/Application;->onCreate()V

    .line 173
    .end local v6    # "app":Landroid/app/Application;
    .end local v8    # "appinfo_In_AppBindData":Landroid/content/pm/ApplicationInfo;
    .end local v9    # "appinfo_In_LoadedApk":Landroid/content/pm/ApplicationInfo;
    .end local v10    # "currentActivityThread":Ljava/lang/Object;
    .end local v12    # "it":Ljava/util/Iterator;
    .end local v13    # "loadedApkInfo":Ljava/lang/Object;
    .end local v15    # "mAllApplications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/app/Application;>;"
    .end local v16    # "mBoundApplication":Ljava/lang/Object;
    .end local v17    # "mProviderMap":Ljava/util/HashMap;
    .end local v18    # "oldApplication":Ljava/lang/Object;
    :cond_1
    return-void
.end method
