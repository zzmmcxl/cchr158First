package android.support.v7.widget;

import java.math.BigDecimal;
import android.content.ComponentName;
import java.util.Collections;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import java.util.Collection;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Intent;
import android.content.Context;
import java.util.List;
import java.util.Map;
import android.database.DataSetObservable;

class ActivityChooserModel extends DataSetObservable
{
    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG;
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    private boolean mCanReadHistoricalData;
    private final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    private final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;
    
    static {
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
    }
    
    private ActivityChooserModel(final Context context, final String mHistoryFileName) {
        super();
        mInstanceLock = new Object();
        mActivities = new ArrayList<ActivityResolveInfo>();
        mHistoricalRecords = new ArrayList<HistoricalRecord>();
        mActivitySorter = (ActivitySorter)new DefaultSorter(this);
        mHistoryMaxSize = 50;
        mCanReadHistoricalData = true;
        mReadShareHistoryCalled = false;
        mHistoricalRecordsChanged = true;
        mReloadActivities = false;
        mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty((CharSequence)mHistoryFileName) && !mHistoryFileName.endsWith(".xml")) {
            mHistoryFileName = mHistoryFileName + ".xml";
            return;
        }
        mHistoryFileName = mHistoryFileName;
    }
    
    static /* synthetic */ Context access$200(final ActivityChooserModel activityChooserModel) {
        return activityChooserModel.mContext;
    }
    
    static /* synthetic */ String access$300() {
        return LOG_TAG;
    }
    
    static /* synthetic */ String access$400(final ActivityChooserModel activityChooserModel) {
        return activityChooserModel.mHistoryFileName;
    }
    
    static /* synthetic */ boolean access$502(final ActivityChooserModel activityChooserModel, final boolean mCanReadHistoricalData) {
        return activityChooserModel.mCanReadHistoricalData = mCanReadHistoricalData;
    }
    
    private boolean addHisoricalRecord(final HistoricalRecord historicalRecord) {
        final boolean add = mHistoricalRecords.add(historicalRecord);
        if (add) {
            mHistoricalRecordsChanged = true;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            this.persistHistoricalDataIfNeeded();
            this.sortActivitiesIfNeeded();
            this.notifyChanged();
        }
        return add;
    }
    
    private void ensureConsistentState() {
        final boolean b = this.loadActivitiesIfNeeded() | this.readHistoricalDataIfNeeded();
        this.pruneExcessiveHistoricalRecordsIfNeeded();
        if (b) {
            this.sortActivitiesIfNeeded();
            this.notifyChanged();
        }
    }
    
    public static ActivityChooserModel get(final Context context, final String s) {
        synchronized (sRegistryLock) {
            ActivityChooserModel activityChooserModel = (ActivityChooserModel)sDataModelRegistry.get(s);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, s);
                sDataModelRegistry.put(s, activityChooserModel);
            }
            return activityChooserModel;
        }
    }
    
    private boolean loadActivitiesIfNeeded() {
        final boolean mReloadActivities = this.mReloadActivities;
        boolean b = false;
        if (mReloadActivities) {
            final Intent mIntent = this.mIntent;
            b = false;
            if (mIntent != null) {
                this.mReloadActivities = false;
                mActivities.clear();
                final List queryIntentActivities = mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
                for (int size = queryIntentActivities.size(), i = 0; i < size; ++i) {
                    mActivities.add(new ActivityResolveInfo((ResolveInfo)queryIntentActivities.get(i)));
                }
                b = true;
            }
        }
        return b;
    }
    
    private void persistHistoricalDataIfNeeded() {
        if (!mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (mHistoricalRecordsChanged) {
            mHistoricalRecordsChanged = false;
            if (!TextUtils.isEmpty((CharSequence)mHistoryFileName)) {
                AsyncTaskCompat.<Object, Object, Object>executeParallel((android.os.AsyncTask<Object, Object, Object>)new PersistHistoryAsyncTask(this), new ArrayList(mHistoricalRecords), mHistoryFileName);
            }
        }
    }
    
    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        final int n = mHistoricalRecords.size() - mHistoryMaxSize;
        if (n > 0) {
            mHistoricalRecordsChanged = true;
            for (int i = 0; i < n; ++i) {
                final HistoricalRecord historicalRecord = (HistoricalRecord)mHistoricalRecords.remove(0);
            }
        }
    }
    
    private boolean readHistoricalDataIfNeeded() {
        if (mCanReadHistoricalData && mHistoricalRecordsChanged && !TextUtils.isEmpty((CharSequence)mHistoryFileName)) {
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
            this.readHistoricalDataImpl();
            return true;
        }
        return false;
    }
    
    private void readHistoricalDataImpl() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        android/support/v7/widget/ActivityChooserModel.mContext:Landroid/content/Context;
        //     4: aload_0        
        //     5: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //     8: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
        //    11: astore_2       
        //    12: invokestatic    android/util/Xml.newPullParser:()Lorg/xmlpull/v1/XmlPullParser;
        //    15: astore          11
        //    17: aload           11
        //    19: aload_2        
        //    20: ldc_w           "UTF-8"
        //    23: invokeinterface org/xmlpull/v1/XmlPullParser.setInput:(Ljava/io/InputStream;Ljava/lang/String;)V
        //    28: iconst_0       
        //    29: istore          12
        //    31: iload           12
        //    33: iconst_1       
        //    34: if_icmpeq       55
        //    37: iload           12
        //    39: iconst_2       
        //    40: if_icmpeq       55
        //    43: aload           11
        //    45: invokeinterface org/xmlpull/v1/XmlPullParser.next:()I
        //    50: istore          12
        //    52: goto            31
        //    55: ldc             "historical-records"
        //    57: aload           11
        //    59: invokeinterface org/xmlpull/v1/XmlPullParser.getName:()Ljava/lang/String;
        //    64: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    67: ifne            127
        //    70: new             Lorg/xmlpull/v1/XmlPullParserException;
        //    73: dup            
        //    74: ldc_w           "Share records file does not start with historical-records tag."
        //    77: invokespecial   org/xmlpull/v1/XmlPullParserException.<init>:(Ljava/lang/String;)V
        //    80: athrow         
        //    81: astore          8
        //    83: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //    86: new             Ljava/lang/StringBuilder;
        //    89: dup            
        //    90: invokespecial   java/lang/StringBuilder.<init>:()V
        //    93: ldc_w           "Error reading historical recrod file: "
        //    96: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    99: aload_0        
        //   100: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   103: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   109: aload           8
        //   111: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   114: pop            
        //   115: aload_2        
        //   116: ifnull          322
        //   119: aload_2        
        //   120: invokevirtual   java/io/FileInputStream.close:()V
        //   123: return         
        //   124: astore          10
        //   126: return         
        //   127: aload_0        
        //   128: getfield        android/support/v7/widget/ActivityChooserModel.mHistoricalRecords:Ljava/util/List;
        //   131: astore          13
        //   133: aload           13
        //   135: invokeinterface java/util/List.clear:()V
        //   140: aload           11
        //   142: invokeinterface org/xmlpull/v1/XmlPullParser.next:()I
        //   147: istore          14
        //   149: iload           14
        //   151: iconst_1       
        //   152: if_icmpne       167
        //   155: aload_2        
        //   156: ifnull          322
        //   159: aload_2        
        //   160: invokevirtual   java/io/FileInputStream.close:()V
        //   163: return         
        //   164: astore          16
        //   166: return         
        //   167: iload           14
        //   169: iconst_3       
        //   170: if_icmpeq       140
        //   173: iload           14
        //   175: iconst_4       
        //   176: if_icmpeq       140
        //   179: ldc             "historical-record"
        //   181: aload           11
        //   183: invokeinterface org/xmlpull/v1/XmlPullParser.getName:()Ljava/lang/String;
        //   188: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   191: ifne            251
        //   194: new             Lorg/xmlpull/v1/XmlPullParserException;
        //   197: dup            
        //   198: ldc_w           "Share records file not well-formed."
        //   201: invokespecial   org/xmlpull/v1/XmlPullParserException.<init>:(Ljava/lang/String;)V
        //   204: athrow         
        //   205: astore          5
        //   207: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   210: new             Ljava/lang/StringBuilder;
        //   213: dup            
        //   214: invokespecial   java/lang/StringBuilder.<init>:()V
        //   217: ldc_w           "Error reading historical recrod file: "
        //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: aload_0        
        //   224: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   227: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   230: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   233: aload           5
        //   235: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   238: pop            
        //   239: aload_2        
        //   240: ifnull          322
        //   243: aload_2        
        //   244: invokevirtual   java/io/FileInputStream.close:()V
        //   247: return         
        //   248: astore          7
        //   250: return         
        //   251: aload           13
        //   253: new             Landroid/support/v7/widget/ActivityChooserModel$HistoricalRecord;
        //   256: dup            
        //   257: aload           11
        //   259: aconst_null    
        //   260: ldc             "activity"
        //   262: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   267: aload           11
        //   269: aconst_null    
        //   270: ldc             "time"
        //   272: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   277: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //   280: aload           11
        //   282: aconst_null    
        //   283: ldc             "weight"
        //   285: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   290: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   293: invokespecial   android/support/v7/widget/ActivityChooserModel$HistoricalRecord.<init>:(Ljava/lang/String;JF)V
        //   296: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   301: pop            
        //   302: goto            140
        //   305: astore_3       
        //   306: aload_2        
        //   307: ifnull          314
        //   310: aload_2        
        //   311: invokevirtual   java/io/FileInputStream.close:()V
        //   314: aload_3        
        //   315: athrow         
        //   316: astore          4
        //   318: goto            314
        //   321: astore_1       
        //   322: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                   
        //  -----  -----  -----  -----  ---------------------------------------
        //  0      12     321    322    Ljava/io/FileNotFoundException;
        //  12     28     81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  12     28     205    251    Ljava/io/IOException;
        //  12     28     305    321    Any
        //  43     52     81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  43     52     205    251    Ljava/io/IOException;
        //  43     52     305    321    Any
        //  55     81     81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  55     81     205    251    Ljava/io/IOException;
        //  55     81     305    321    Any
        //  83     115    305    321    Any
        //  119    123    124    127    Ljava/io/IOException;
        //  127    140    81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  127    140    205    251    Ljava/io/IOException;
        //  127    140    305    321    Any
        //  140    149    81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  140    149    205    251    Ljava/io/IOException;
        //  140    149    305    321    Any
        //  159    163    164    167    Ljava/io/IOException;
        //  179    205    81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  179    205    205    251    Ljava/io/IOException;
        //  179    205    305    321    Any
        //  207    239    305    321    Any
        //  243    247    248    251    Ljava/io/IOException;
        //  251    302    81     127    Lorg/xmlpull/v1/XmlPullParserException;
        //  251    302    205    251    Ljava/io/IOException;
        //  251    302    305    321    Any
        //  310    314    316    321    Ljava/io/IOException;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean sortActivitiesIfNeeded() {
        if (mActivitySorter != null && mIntent != null && !mActivities.isEmpty() && !mHistoricalRecords.isEmpty()) {
            mActivitySorter.sort(mIntent, mActivities, Collections.<HistoricalRecord>unmodifiableList((List<? extends HistoricalRecord>)mHistoricalRecords));
            return true;
        }
        return false;
    }
    
    public Intent chooseActivity(final int n) {
        synchronized (mInstanceLock) {
            if (mIntent == null) {
                return null;
            }
            this.ensureConsistentState();
            final ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo)mActivities.get(n);
            final ComponentName component = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            final Intent intent = new Intent(mIntent);
            intent.setComponent(component);
            if (mActivityChoserModelPolicy != null && mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                return null;
            }
            this.addHisoricalRecord(new HistoricalRecord(component, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }
    
    public ResolveInfo getActivity(final int n) {
        synchronized (mInstanceLock) {
            this.ensureConsistentState();
            return ((ActivityResolveInfo)mActivities.get(n)).resolveInfo;
        }
    }
    
    public int getActivityCount() {
        synchronized (mInstanceLock) {
            this.ensureConsistentState();
            return mActivities.size();
        }
    }
    
    public int getActivityIndex(final ResolveInfo resolveInfo) {
        while (true) {
            while (true) {
                int n;
                synchronized (mInstanceLock) {
                    this.ensureConsistentState();
                    final List<ActivityResolveInfo> mActivities = this.mActivities;
                    final int size = mActivities.size();
                    n = 0;
                    if (n >= size) {
                        return -1;
                    }
                    if (((ActivityResolveInfo)mActivities.get(n)).resolveInfo == resolveInfo) {
                        return n;
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    public ResolveInfo getDefaultActivity() {
        synchronized (mInstanceLock) {
            this.ensureConsistentState();
            if (!mActivities.isEmpty()) {
                return ((ActivityResolveInfo)mActivities.get(0)).resolveInfo;
            }
            return null;
        }
    }
    
    public int getHistoryMaxSize() {
        synchronized (mInstanceLock) {
            return mHistoryMaxSize;
        }
    }
    
    public int getHistorySize() {
        synchronized (mInstanceLock) {
            this.ensureConsistentState();
            return mHistoricalRecords.size();
        }
    }
    
    public Intent getIntent() {
        synchronized (mInstanceLock) {
            return mIntent;
        }
    }
    
    public void setActivitySorter(final ActivitySorter mActivitySorter) {
        synchronized (mInstanceLock) {
            if (this.mActivitySorter == mActivitySorter) {
                return;
            }
            this.mActivitySorter = mActivitySorter;
            if (this.sortActivitiesIfNeeded()) {
                this.notifyChanged();
            }
        }
    }
    
    public void setDefaultActivity(final int n) {
        while (true) {
            while (true) {
                synchronized (mInstanceLock) {
                    this.ensureConsistentState();
                    final ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo)mActivities.get(n);
                    final ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo)mActivities.get(0);
                    if (activityResolveInfo2 != null) {
                        final float n2 = 5.0f + (activityResolveInfo2.weight - activityResolveInfo.weight);
                        this.addHisoricalRecord(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), n2));
                        return;
                    }
                }
                final float n2 = 1.0f;
                continue;
            }
        }
    }
    
    public void setHistoryMaxSize(final int mHistoryMaxSize) {
        synchronized (mInstanceLock) {
            if (this.mHistoryMaxSize == mHistoryMaxSize) {
                return;
            }
            this.mHistoryMaxSize = mHistoryMaxSize;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            if (this.sortActivitiesIfNeeded()) {
                this.notifyChanged();
            }
        }
    }
    
    public void setIntent(final Intent mIntent) {
        synchronized (mInstanceLock) {
            if (this.mIntent == mIntent) {
                return;
            }
            this.mIntent = mIntent;
            mReloadActivities = true;
            this.ensureConsistentState();
        }
    }
    
    public void setOnChooseActivityListener(final OnChooseActivityListener mActivityChoserModelPolicy) {
        synchronized (mInstanceLock) {
            this.mActivityChoserModelPolicy = mActivityChoserModelPolicy;
        }
    }
}
