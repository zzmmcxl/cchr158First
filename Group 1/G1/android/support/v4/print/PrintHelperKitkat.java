package android.support.v4.print;

import android.os.CancellationSignal$OnCancelListener;
import android.os.AsyncTask;
import android.print.PrintAttributes$Builder;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo$Builder;
import android.os.Bundle;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintManager;
import java.io.InputStream;
import java.io.IOException;
import android.util.Log;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import java.io.FileNotFoundException;
import android.net.Uri;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.content.Context;

class PrintHelperKitkat
{
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelperKitkat";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory$Options mDecodeOptions;
    private final Object mLock;
    int mOrientation;
    int mScaleMode;
    
    PrintHelperKitkat(final Context mContext) {
        super();
        mDecodeOptions = null;
        mLock = new Object();
        mScaleMode = 2;
        mColorMode = 2;
        mOrientation = 1;
        mContext = mContext;
    }
    
    static /* synthetic */ Bitmap access$000(final PrintHelperKitkat printHelperKitkat, final Bitmap bitmap, final int n) {
        return printHelperKitkat.convertBitmapForColorMode(bitmap, n);
    }
    
    static /* synthetic */ Matrix access$100(final PrintHelperKitkat printHelperKitkat, final int n, final int n2, final RectF rectF, final int n3) {
        return printHelperKitkat.getMatrix(n, n2, rectF, n3);
    }
    
    static /* synthetic */ Bitmap access$300(final PrintHelperKitkat printHelperKitkat, final Uri uri, final int n) throws FileNotFoundException {
        return printHelperKitkat.loadConstrainedBitmap(uri, n);
    }
    
    static /* synthetic */ Object access$400(final PrintHelperKitkat printHelperKitkat) {
        return printHelperKitkat.mLock;
    }
    
    private Bitmap convertBitmapForColorMode(final Bitmap bitmap, final int n) {
        if (n != 1) {
            return bitmap;
        }
        final Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap$Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap2);
        final Paint paint = new Paint();
        final ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap)null);
        return bitmap2;
    }
    
    private Matrix getMatrix(final int n, final int n2, final RectF rectF, final int n3) {
        final Matrix matrix = new Matrix();
        final float n4 = rectF.width() / n;
        float n5;
        if (n3 == 2) {
            n5 = Math.max(n4, rectF.height() / (float)n2);
        }
        else {
            n5 = Math.min(n4, rectF.height() / (float)n2);
        }
        matrix.postScale(n5, n5);
        matrix.postTranslate((rectF.width() - n5 * n) / 2.0f, (rectF.height() - n5 * n2) / 2.0f);
        return matrix;
    }
    
    private Bitmap loadBitmap(final Uri uri, final BitmapFactory$Options bitmapFactory$Options) throws FileNotFoundException {
        if (uri == null || mContext == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream openInputStream = null;
        try {
            openInputStream = mContext.getContentResolver().openInputStream(uri);
            final Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, (Rect)null, bitmapFactory$Options);
            if (openInputStream == null) {
                return decodeStream;
            }
            try {
                openInputStream.close();
                return decodeStream;
            }
            catch (IOException ex) {
                Log.w("PrintHelperKitkat", "close fail ", (Throwable)ex);
                return decodeStream;
            }
        }
        finally {
            Label_0079: {
                if (openInputStream == null) {
                    break Label_0079;
                }
                try {
                    openInputStream.close();
                }
                catch (IOException ex2) {
                    Log.w("PrintHelperKitkat", "close fail ", (Throwable)ex2);
                }
            }
        }
    }
    
    private Bitmap loadConstrainedBitmap(final Uri uri, final int n) throws FileNotFoundException {
        if (n <= 0 || uri == null || mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inJustDecodeBounds = true;
        this.loadBitmap(uri, bitmapFactory$Options);
        final int outWidth = bitmapFactory$Options.outWidth;
        final int outHeight = bitmapFactory$Options.outHeight;
        if (outWidth > 0 && outHeight > 0) {
            int i;
            int inSampleSize;
            for (i = Math.max(outWidth, outHeight), inSampleSize = 1; i > n; i >>>= 1, inSampleSize <<= 1) {}
            if (inSampleSize > 0 && Math.min(outWidth, outHeight) / inSampleSize > 0) {
                final Object mLock = this.mLock;
                final BitmapFactory$Options mDecodeOptions;
                synchronized (mLock) {
                    this.mDecodeOptions = new BitmapFactory$Options();
                    this.mDecodeOptions.inMutable = true;
                    this.mDecodeOptions.inSampleSize = inSampleSize;
                    mDecodeOptions = this.mDecodeOptions;
                    // monitorexit(mLock)
                    final PrintHelperKitkat printHelperKitkat = this;
                    final Uri uri2 = uri;
                    final BitmapFactory$Options bitmapFactory$Options2 = mDecodeOptions;
                    final Bitmap bitmap = printHelperKitkat.loadBitmap(uri2, bitmapFactory$Options2);
                    final PrintHelperKitkat printHelperKitkat2 = this;
                    final Object o = printHelperKitkat2.mLock;
                    final Object o3;
                    final Object o2 = o3 = o;
                    synchronized (o3) {
                        final PrintHelperKitkat printHelperKitkat3 = this;
                        final BitmapFactory$Options bitmapFactory$Options3 = null;
                        printHelperKitkat3.mDecodeOptions = bitmapFactory$Options3;
                        return bitmap;
                    }
                }
                try {
                    final PrintHelperKitkat printHelperKitkat = this;
                    final Uri uri2 = uri;
                    final BitmapFactory$Options bitmapFactory$Options2 = mDecodeOptions;
                    final Bitmap bitmap = printHelperKitkat.loadBitmap(uri2, bitmapFactory$Options2);
                    final PrintHelperKitkat printHelperKitkat2 = this;
                    final Object o = printHelperKitkat2.mLock;
                    final Object o3;
                    final Object o2 = o3 = o;
                    // monitorenter(o3)
                    final PrintHelperKitkat printHelperKitkat3 = this;
                    final BitmapFactory$Options bitmapFactory$Options3 = null;
                    printHelperKitkat3.mDecodeOptions = bitmapFactory$Options3;
                    return bitmap;
                }
                finally {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    // monitorexit(this.mLock)
                }
            }
        }
        return null;
    }
    
    public int getColorMode() {
        return mColorMode;
    }
    
    public int getOrientation() {
        return mOrientation;
    }
    
    public int getScaleMode() {
        return mScaleMode;
    }
    
    public void printBitmap(final String s, final Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
        if (bitmap == null) {
            return;
        }
        final int mScaleMode = this.mScaleMode;
        final PrintManager printManager = (PrintManager)mContext.getSystemService("print");
        PrintAttributes$MediaSize mediaSize = PrintAttributes$MediaSize.UNKNOWN_PORTRAIT;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            mediaSize = PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE;
        }
        printManager.print(s, (PrintDocumentAdapter)new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;
            final /* synthetic */ PrintHelperKitkat this$0;
            final /* synthetic */ Bitmap val$bitmap;
            final /* synthetic */ OnPrintFinishCallback val$callback;
            final /* synthetic */ int val$fittingMode;
            final /* synthetic */ String val$jobName;
            
            PrintHelperKitkat$1() {
                this$0 = this$0;
                super();
            }
            
            public void onFinish() {
                if (onPrintFinishCallback != null) {
                    onPrintFinishCallback.onFinish();
                }
            }
            
            public void onLayout(final PrintAttributes printAttributes, final PrintAttributes mAttributes, final CancellationSignal cancellationSignal, final PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback, final Bundle bundle) {
                int n = 1;
                this.mAttributes = mAttributes;
                final PrintDocumentInfo build = new PrintDocumentInfo$Builder(s).setContentType(n).setPageCount(n).build();
                if (mAttributes.equals((Object)printAttributes)) {
                    n = 0;
                }
                printDocumentAdapter$LayoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
            }
            
            public void onWrite(final PageRange[] p0, final ParcelFileDescriptor p1, final CancellationSignal p2, final PrintDocumentAdapter$WriteResultCallback p3) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     0: new             Landroid/print/pdf/PrintedPdfDocument;
                //     3: dup            
                //     4: aload_0        
                //     5: getfield        android/support/v4/print/PrintHelperKitkat$1.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //     8: getfield        android/support/v4/print/PrintHelperKitkat.mContext:Landroid/content/Context;
                //    11: aload_0        
                //    12: getfield        android/support/v4/print/PrintHelperKitkat$1.mAttributes:Landroid/print/PrintAttributes;
                //    15: invokespecial   android/print/pdf/PrintedPdfDocument.<init>:(Landroid/content/Context;Landroid/print/PrintAttributes;)V
                //    18: astore          5
                //    20: aload_0        
                //    21: getfield        android/support/v4/print/PrintHelperKitkat$1.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //    24: aload_0        
                //    25: getfield        android/support/v4/print/PrintHelperKitkat$1.val$bitmap:Landroid/graphics/Bitmap;
                //    28: aload_0        
                //    29: getfield        android/support/v4/print/PrintHelperKitkat$1.mAttributes:Landroid/print/PrintAttributes;
                //    32: invokevirtual   android/print/PrintAttributes.getColorMode:()I
                //    35: invokestatic    android/support/v4/print/PrintHelperKitkat.access$000:(Landroid/support/v4/print/PrintHelperKitkat;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
                //    38: astore          6
                //    40: aload           5
                //    42: iconst_1       
                //    43: invokevirtual   android/print/pdf/PrintedPdfDocument.startPage:(I)Landroid/graphics/pdf/PdfDocument$Page;
                //    46: astore          9
                //    48: new             Landroid/graphics/RectF;
                //    51: dup            
                //    52: aload           9
                //    54: invokevirtual   android/graphics/pdf/PdfDocument$Page.getInfo:()Landroid/graphics/pdf/PdfDocument$PageInfo;
                //    57: invokevirtual   android/graphics/pdf/PdfDocument$PageInfo.getContentRect:()Landroid/graphics/Rect;
                //    60: invokespecial   android/graphics/RectF.<init>:(Landroid/graphics/Rect;)V
                //    63: astore          10
                //    65: aload_0        
                //    66: getfield        android/support/v4/print/PrintHelperKitkat$1.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //    69: aload           6
                //    71: invokevirtual   android/graphics/Bitmap.getWidth:()I
                //    74: aload           6
                //    76: invokevirtual   android/graphics/Bitmap.getHeight:()I
                //    79: aload           10
                //    81: aload_0        
                //    82: getfield        android/support/v4/print/PrintHelperKitkat$1.val$fittingMode:I
                //    85: invokestatic    android/support/v4/print/PrintHelperKitkat.access$100:(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
                //    88: astore          11
                //    90: aload           9
                //    92: invokevirtual   android/graphics/pdf/PdfDocument$Page.getCanvas:()Landroid/graphics/Canvas;
                //    95: aload           6
                //    97: aload           11
                //    99: aconst_null    
                //   100: invokevirtual   android/graphics/Canvas.drawBitmap:(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
                //   103: aload           5
                //   105: aload           9
                //   107: invokevirtual   android/print/pdf/PrintedPdfDocument.finishPage:(Landroid/graphics/pdf/PdfDocument$Page;)V
                //   110: aload           5
                //   112: new             Ljava/io/FileOutputStream;
                //   115: dup            
                //   116: aload_2        
                //   117: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
                //   120: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/FileDescriptor;)V
                //   123: invokevirtual   android/print/pdf/PrintedPdfDocument.writeTo:(Ljava/io/OutputStream;)V
                //   126: iconst_1       
                //   127: anewarray       Landroid/print/PageRange;
                //   130: astore          15
                //   132: aload           15
                //   134: iconst_0       
                //   135: getstatic       android/print/PageRange.ALL_PAGES:Landroid/print/PageRange;
                //   138: aastore        
                //   139: aload           4
                //   141: aload           15
                //   143: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFinished:([Landroid/print/PageRange;)V
                //   146: aload           5
                //   148: ifnull          156
                //   151: aload           5
                //   153: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   156: aload_2        
                //   157: ifnull          164
                //   160: aload_2        
                //   161: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   164: aload           6
                //   166: aload_0        
                //   167: getfield        android/support/v4/print/PrintHelperKitkat$1.val$bitmap:Landroid/graphics/Bitmap;
                //   170: if_acmpeq       178
                //   173: aload           6
                //   175: invokevirtual   android/graphics/Bitmap.recycle:()V
                //   178: return         
                //   179: astore          12
                //   181: ldc             "PrintHelperKitkat"
                //   183: ldc             "Error writing printed content"
                //   185: aload           12
                //   187: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
                //   190: pop            
                //   191: aload           4
                //   193: aconst_null    
                //   194: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFailed:(Ljava/lang/CharSequence;)V
                //   197: goto            146
                //   200: astore          7
                //   202: aload           5
                //   204: ifnull          212
                //   207: aload           5
                //   209: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   212: aload_2        
                //   213: ifnull          220
                //   216: aload_2        
                //   217: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   220: aload           6
                //   222: aload_0        
                //   223: getfield        android/support/v4/print/PrintHelperKitkat$1.val$bitmap:Landroid/graphics/Bitmap;
                //   226: if_acmpeq       234
                //   229: aload           6
                //   231: invokevirtual   android/graphics/Bitmap.recycle:()V
                //   234: aload           7
                //   236: athrow         
                //   237: astore          14
                //   239: goto            164
                //   242: astore          8
                //   244: goto            220
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  40     110    200    237    Any
                //  110    146    179    200    Ljava/io/IOException;
                //  110    146    200    237    Any
                //  160    164    237    242    Ljava/io/IOException;
                //  181    197    200    237    Any
                //  216    220    242    247    Ljava/io/IOException;
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        }, new PrintAttributes$Builder().setMediaSize(mediaSize).setColorMode(mColorMode).build());
    }
    
    public void printBitmap(final String s, final Uri uri, final OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        final PrintDocumentAdapter printDocumentAdapter = new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;
            Bitmap mBitmap = null;
            AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
            final /* synthetic */ PrintHelperKitkat this$0;
            final /* synthetic */ OnPrintFinishCallback val$callback;
            final /* synthetic */ int val$fittingMode = mScaleMode;
            final /* synthetic */ Uri val$imageFile;
            final /* synthetic */ String val$jobName;
            
            PrintHelperKitkat$2() {
                this$0 = this$0;
                super();
            }
            
            static /* synthetic */ void access$200(final PrintHelperKitkat$2 printDocumentAdapter) {
                printDocumentAdapter.cancelLoad();
            }
            
            private void cancelLoad() {
                synchronized (mLock) {
                    if (mDecodeOptions != null) {
                        mDecodeOptions.requestCancelDecode();
                        mDecodeOptions = null;
                    }
                }
            }
            
            public void onFinish() {
                super.onFinish();
                this.cancelLoad();
                if (mLoadBitmap != null) {
                    mLoadBitmap.cancel(true);
                }
                if (onPrintFinishCallback != null) {
                    onPrintFinishCallback.onFinish();
                }
                if (mBitmap != null) {
                    mBitmap.recycle();
                    mBitmap = null;
                }
            }
            
            public void onLayout(final PrintAttributes printAttributes, final PrintAttributes mAttributes, final CancellationSignal cancellationSignal, final PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback, final Bundle bundle) {
                int n = 1;
                this.mAttributes = mAttributes;
                if (cancellationSignal.isCanceled()) {
                    printDocumentAdapter$LayoutResultCallback.onLayoutCancelled();
                    return;
                }
                if (mBitmap != null) {
                    final PrintDocumentInfo build = new PrintDocumentInfo$Builder(s).setContentType(n).setPageCount(n).build();
                    if (mAttributes.equals((Object)printAttributes)) {
                        n = 0;
                    }
                    printDocumentAdapter$LayoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
                    return;
                }
                mLoadBitmap = (AsyncTask<Uri, Boolean, Bitmap>)new AsyncTask<Uri, Boolean, Bitmap>() {
                    final /* synthetic */ PrintHelperKitkat$2 this$1;
                    final /* synthetic */ CancellationSignal val$cancellationSignal;
                    final /* synthetic */ PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback;
                    final /* synthetic */ PrintAttributes val$newPrintAttributes;
                    final /* synthetic */ PrintAttributes val$oldPrintAttributes;
                    
                    PrintHelperKitkat$2$1() {
                        this$1 = this$1;
                        super();
                    }
                    
                    protected Bitmap doInBackground(final Uri... array) {
                        try {
                            return this$0.loadConstrainedBitmap(uri, 3500);
                        }
                        catch (FileNotFoundException ex) {
                            return null;
                        }
                    }
                    
                    protected /* bridge */ Object doInBackground(final Object[] array) {
                        return this.doInBackground((Uri[])array);
                    }
                    
                    protected void onCancelled(final Bitmap bitmap) {
                        printDocumentAdapter$LayoutResultCallback.onLayoutCancelled();
                        mLoadBitmap = null;
                    }
                    
                    protected /* bridge */ void onCancelled(final Object o) {
                        this.onCancelled((Bitmap)o);
                    }
                    
                    protected void onPostExecute(final Bitmap mBitmap) {
                        int n = 1;
                        super.onPostExecute((Object)mBitmap);
                        this$1.mBitmap = mBitmap;
                        if (mBitmap != null) {
                            final PrintDocumentInfo build = new PrintDocumentInfo$Builder(s).setContentType(n).setPageCount(n).build();
                            if (mAttributes.equals((Object)printAttributes)) {
                                n = 0;
                            }
                            printDocumentAdapter$LayoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
                        }
                        else {
                            printDocumentAdapter$LayoutResultCallback.onLayoutFailed((CharSequence)null);
                        }
                        mLoadBitmap = null;
                    }
                    
                    protected /* bridge */ void onPostExecute(final Object o) {
                        this.onPostExecute((Bitmap)o);
                    }
                    
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)new CancellationSignal$OnCancelListener() {
                            final /* synthetic */ PrintHelperKitkat$2$1 this$2;
                            
                            PrintHelperKitkat$2$1$1() {
                                this$2 = this$2;
                                super();
                            }
                            
                            public void onCancel() {
                                this$1.cancelLoad();
                                this$2.cancel(false);
                            }
                        });
                    }
                }.execute((Object[])new Uri[0]);
            }
            
            public void onWrite(final PageRange[] p0, final ParcelFileDescriptor p1, final CancellationSignal p2, final PrintDocumentAdapter$WriteResultCallback p3) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     0: new             Landroid/print/pdf/PrintedPdfDocument;
                //     3: dup            
                //     4: aload_0        
                //     5: getfield        android/support/v4/print/PrintHelperKitkat$2.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //     8: getfield        android/support/v4/print/PrintHelperKitkat.mContext:Landroid/content/Context;
                //    11: aload_0        
                //    12: getfield        android/support/v4/print/PrintHelperKitkat$2.mAttributes:Landroid/print/PrintAttributes;
                //    15: invokespecial   android/print/pdf/PrintedPdfDocument.<init>:(Landroid/content/Context;Landroid/print/PrintAttributes;)V
                //    18: astore          5
                //    20: aload_0        
                //    21: getfield        android/support/v4/print/PrintHelperKitkat$2.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //    24: aload_0        
                //    25: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //    28: aload_0        
                //    29: getfield        android/support/v4/print/PrintHelperKitkat$2.mAttributes:Landroid/print/PrintAttributes;
                //    32: invokevirtual   android/print/PrintAttributes.getColorMode:()I
                //    35: invokestatic    android/support/v4/print/PrintHelperKitkat.access$000:(Landroid/support/v4/print/PrintHelperKitkat;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
                //    38: astore          6
                //    40: aload           5
                //    42: iconst_1       
                //    43: invokevirtual   android/print/pdf/PrintedPdfDocument.startPage:(I)Landroid/graphics/pdf/PdfDocument$Page;
                //    46: astore          9
                //    48: new             Landroid/graphics/RectF;
                //    51: dup            
                //    52: aload           9
                //    54: invokevirtual   android/graphics/pdf/PdfDocument$Page.getInfo:()Landroid/graphics/pdf/PdfDocument$PageInfo;
                //    57: invokevirtual   android/graphics/pdf/PdfDocument$PageInfo.getContentRect:()Landroid/graphics/Rect;
                //    60: invokespecial   android/graphics/RectF.<init>:(Landroid/graphics/Rect;)V
                //    63: astore          10
                //    65: aload_0        
                //    66: getfield        android/support/v4/print/PrintHelperKitkat$2.this$0:Landroid/support/v4/print/PrintHelperKitkat;
                //    69: aload_0        
                //    70: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //    73: invokevirtual   android/graphics/Bitmap.getWidth:()I
                //    76: aload_0        
                //    77: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //    80: invokevirtual   android/graphics/Bitmap.getHeight:()I
                //    83: aload           10
                //    85: aload_0        
                //    86: getfield        android/support/v4/print/PrintHelperKitkat$2.val$fittingMode:I
                //    89: invokestatic    android/support/v4/print/PrintHelperKitkat.access$100:(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
                //    92: astore          11
                //    94: aload           9
                //    96: invokevirtual   android/graphics/pdf/PdfDocument$Page.getCanvas:()Landroid/graphics/Canvas;
                //    99: aload           6
                //   101: aload           11
                //   103: aconst_null    
                //   104: invokevirtual   android/graphics/Canvas.drawBitmap:(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
                //   107: aload           5
                //   109: aload           9
                //   111: invokevirtual   android/print/pdf/PrintedPdfDocument.finishPage:(Landroid/graphics/pdf/PdfDocument$Page;)V
                //   114: aload           5
                //   116: new             Ljava/io/FileOutputStream;
                //   119: dup            
                //   120: aload_2        
                //   121: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
                //   124: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/FileDescriptor;)V
                //   127: invokevirtual   android/print/pdf/PrintedPdfDocument.writeTo:(Ljava/io/OutputStream;)V
                //   130: iconst_1       
                //   131: anewarray       Landroid/print/PageRange;
                //   134: astore          15
                //   136: aload           15
                //   138: iconst_0       
                //   139: getstatic       android/print/PageRange.ALL_PAGES:Landroid/print/PageRange;
                //   142: aastore        
                //   143: aload           4
                //   145: aload           15
                //   147: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFinished:([Landroid/print/PageRange;)V
                //   150: aload           5
                //   152: ifnull          160
                //   155: aload           5
                //   157: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   160: aload_2        
                //   161: ifnull          168
                //   164: aload_2        
                //   165: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   168: aload           6
                //   170: aload_0        
                //   171: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //   174: if_acmpeq       182
                //   177: aload           6
                //   179: invokevirtual   android/graphics/Bitmap.recycle:()V
                //   182: return         
                //   183: astore          12
                //   185: ldc             "PrintHelperKitkat"
                //   187: ldc             "Error writing printed content"
                //   189: aload           12
                //   191: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
                //   194: pop            
                //   195: aload           4
                //   197: aconst_null    
                //   198: invokevirtual   android/print/PrintDocumentAdapter$WriteResultCallback.onWriteFailed:(Ljava/lang/CharSequence;)V
                //   201: goto            150
                //   204: astore          7
                //   206: aload           5
                //   208: ifnull          216
                //   211: aload           5
                //   213: invokevirtual   android/print/pdf/PrintedPdfDocument.close:()V
                //   216: aload_2        
                //   217: ifnull          224
                //   220: aload_2        
                //   221: invokevirtual   android/os/ParcelFileDescriptor.close:()V
                //   224: aload           6
                //   226: aload_0        
                //   227: getfield        android/support/v4/print/PrintHelperKitkat$2.mBitmap:Landroid/graphics/Bitmap;
                //   230: if_acmpeq       238
                //   233: aload           6
                //   235: invokevirtual   android/graphics/Bitmap.recycle:()V
                //   238: aload           7
                //   240: athrow         
                //   241: astore          14
                //   243: goto            168
                //   246: astore          8
                //   248: goto            224
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  40     114    204    241    Any
                //  114    150    183    204    Ljava/io/IOException;
                //  114    150    204    241    Any
                //  164    168    241    246    Ljava/io/IOException;
                //  185    201    204    241    Any
                //  220    224    246    251    Ljava/io/IOException;
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        };
        final PrintManager printManager = (PrintManager)mContext.getSystemService("print");
        final PrintAttributes$Builder printAttributes$Builder = new PrintAttributes$Builder();
        printAttributes$Builder.setColorMode(mColorMode);
        if (mOrientation == 1) {
            printAttributes$Builder.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE);
        }
        else if (mOrientation == 2) {
            printAttributes$Builder.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(s, (PrintDocumentAdapter)printDocumentAdapter, printAttributes$Builder.build());
    }
    
    public void setColorMode(final int mColorMode) {
        this.mColorMode = mColorMode;
    }
    
    public void setOrientation(final int mOrientation) {
        this.mOrientation = mOrientation;
    }
    
    public void setScaleMode(final int mScaleMode) {
        this.mScaleMode = mScaleMode;
    }
}
