package android.support.v4.content;

import java.util.Set;
import android.net.Uri;
import android.util.Log;
import android.content.Intent;
import android.os.Message;
import android.os.Looper;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Handler;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager
{
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers;
    
    static {
        mLock = new Object();
    }
    
    private LocalBroadcastManager(final Context mAppContext) {
        super();
        mReceivers = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
        mActions = new HashMap<String, ArrayList<ReceiverRecord>>();
        mPendingBroadcasts = new ArrayList<BroadcastRecord>();
        mAppContext = mAppContext;
        mHandler = new Handler(mAppContext.getMainLooper()) {
            final /* synthetic */ LocalBroadcastManager this$0;
            
            LocalBroadcastManager$1(final Looper looper) {
                this$0 = this$0;
                super(looper);
            }
            
            public void handleMessage(final Message message) {
                switch (message.what) {
                    default:
                        super.handleMessage(message);
                    case 1:
                        this$0.executePendingBroadcasts();
                }
            }
        };
    }
    
    static /* synthetic */ void access$000(final LocalBroadcastManager localBroadcastManager) {
        localBroadcastManager.executePendingBroadcasts();
    }
    
    private void executePendingBroadcasts() {
    Label_0050_Outer:
        while (true) {
            while (true) {
                int n;
                synchronized (mReceivers) {
                    final int size = mPendingBroadcasts.size();
                    if (size <= 0) {
                        return;
                    }
                    final BroadcastRecord[] array = new BroadcastRecord[size];
                    mPendingBroadcasts.<BroadcastRecord>toArray(array);
                    mPendingBroadcasts.clear();
                    // monitorexit(this.mReceivers)
                    n = 0;
                    if (n >= array.length) {
                        continue Label_0050_Outer;
                    }
                    final BroadcastRecord broadcastRecord = array[n];
                    for (int i = 0; i < broadcastRecord.receivers.size(); ++i) {
                        ((ReceiverRecord)broadcastRecord.receivers.get(i)).receiver.onReceive(mAppContext, broadcastRecord.intent);
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    public static LocalBroadcastManager getInstance(final Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            return mInstance;
        }
    }
    
    public void registerReceiver(final BroadcastReceiver broadcastReceiver, final IntentFilter intentFilter) {
        synchronized (mReceivers) {
            final ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> list = (ArrayList<IntentFilter>)mReceivers.get(broadcastReceiver);
            if (list == null) {
                list = new ArrayList<IntentFilter>(1);
                mReceivers.put(broadcastReceiver, list);
            }
            list.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); ++i) {
                final String action = intentFilter.getAction(i);
                ArrayList<ReceiverRecord> list2 = (ArrayList<ReceiverRecord>)mActions.get(action);
                if (list2 == null) {
                    list2 = new ArrayList<ReceiverRecord>(1);
                    mActions.put(action, list2);
                }
                list2.add(receiverRecord);
            }
        }
    }
    
    public boolean sendBroadcast(final Intent intent) {
        // monitorexit(hashMap)
        while (true) {
            while (true) {
            Block_4_Outer:
                while (true) {
                    String action;
                    String resolveTypeIfNeeded;
                    Uri data;
                    String scheme;
                    Set categories;
                    int n;
                    ArrayList<ReceiverRecord> list;
                    ArrayList<ReceiverRecord> list2 = null;
                    ReceiverRecord receiverRecord;
                    int match;
                    int n2 = 0;
                    String s;
                    Block_17_Outer:Block_15_Outer:Label_0162_Outer:
                    while (true) {
                        Label_0500: {
                            while (true) {
                                Label_0494: {
                                    Label_0485: {
                                        synchronized (mReceivers) {
                                            action = intent.getAction();
                                            resolveTypeIfNeeded = intent.resolveTypeIfNeeded(mAppContext.getContentResolver());
                                            data = intent.getData();
                                            scheme = intent.getScheme();
                                            categories = intent.getCategories();
                                            if ((0x8 & intent.getFlags()) == 0x0) {
                                                break Label_0500;
                                            }
                                            n = 1;
                                            if (n != 0) {
                                                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                                            }
                                            list = mActions.get(intent.getAction());
                                            if (list == null) {
                                                break;
                                            }
                                            if (n != 0) {
                                                Log.v("LocalBroadcastManager", "Action list: " + list);
                                            }
                                            break Label_0485;
                                            // iftrue(Label_0494:, n == 0)
                                            // iftrue(Label_0303:, n == 0)
                                            // iftrue(Label_0534:, n2 >= list.size())
                                            // iftrue(Label_0242:, !receiverRecord.broadcasting)
                                            // iftrue(Label_0218:, n == 0)
                                            // iftrue(Label_0317:, list2 != null)
                                            while (true) {
                                            Block_12_Outer:
                                                while (true) {
                                                Label_0303:
                                                    while (true) {
                                                        Block_11: {
                                                        Label_0317:
                                                            while (true) {
                                                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                                                                break Label_0494;
                                                                list2 = new ArrayList<ReceiverRecord>();
                                                                break Label_0317;
                                                                Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.filter);
                                                                Label_0218: {
                                                                    break Label_0218;
                                                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                                                    break Label_0303;
                                                                    break Block_11;
                                                                }
                                                                continue Block_17_Outer;
                                                            }
                                                            list2.add(receiverRecord);
                                                            receiverRecord.broadcasting = true;
                                                            break Label_0494;
                                                        }
                                                        receiverRecord = list.get(n2);
                                                        continue Block_15_Outer;
                                                    }
                                                    continue Block_12_Outer;
                                                }
                                                Label_0242: {
                                                    match = receiverRecord.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                                }
                                                continue Label_0162_Outer;
                                            }
                                        }
                                        // iftrue(Label_0339:, match < 0)
                                        Label_0339: {
                                            if (n != 0) {
                                                switch (match) {
                                                    default:
                                                        s = "unknown reason";
                                                        break;
                                                    case -3:
                                                        s = "action";
                                                        break;
                                                    case -4:
                                                        s = "category";
                                                        break;
                                                    case -2:
                                                        s = "data";
                                                        break;
                                                    case -1:
                                                        s = "type";
                                                        break;
                                                }
                                                Log.v("LocalBroadcastManager", "  Filter did not match: " + s);
                                            }
                                        }
                                        break Label_0494;
                                    }
                                    n2 = 0;
                                    list2 = null;
                                    continue Block_4_Outer;
                                }
                                ++n2;
                                continue Block_4_Outer;
                            }
                        }
                        n = 0;
                        continue Block_4_Outer;
                    }
                    int i = 0;
                    while (i < list2.size()) {
                        ((ReceiverRecord)list2.get(i)).broadcasting = false;
                        ++i;
                    }
                    // monitorexit(hashMap)
                    while (true) {
                        Label_0439: {
                            break Label_0439;
                            while (true) {
                                return true;
                                mHandler.sendEmptyMessage(1);
                                continue Block_4_Outer;
                            }
                        }
                        mPendingBroadcasts.add(new BroadcastRecord(intent, list2));
                        continue;
                    }
                }
                // iftrue(Label_0477:, this.mHandler.hasMessages(1))
                return false;
                Label_0534: {
                    final ArrayList<ReceiverRecord> list2;
                    if (list2 != null) {
                        final int i = 0;
                        continue;
                    }
                }
                break;
            }
            continue;
        }
    }
    
    public void sendBroadcastSync(final Intent intent) {
        if (this.sendBroadcast(intent)) {
            this.executePendingBroadcasts();
        }
    }
    
    public void unregisterReceiver(final BroadcastReceiver broadcastReceiver) {
        ArrayList<IntentFilter> list;
        int n = 0;
        ArrayList<ReceiverRecord> list2;
        int n2 = 0;
        IntentFilter intentFilter;
        int n3 = 0;
        String action;
        Label_0053_Outer:Label_0028_Outer:
        while (true) {
        Label_0028:
            while (true) {
            Label_0053:
                while (true) {
                    Block_8_Outer:Block_4_Outer:
                    while (true) {
                        Label_0170: {
                            Label_0164: {
                                synchronized (mReceivers) {
                                    list = mReceivers.remove(broadcastReceiver);
                                    if (list == null) {
                                        return;
                                    }
                                    break Label_0164;
                                    // iftrue(Label_0135:, n >= list2.size())
                                    // iftrue(Label_0176:, list2.size() > 0)
                                    // iftrue(Label_0176:, list2 == null)
                                    // iftrue(Label_0182:, n3 >= intentFilter.countActions())
                                    // iftrue(Label_0170:, (ReceiverRecord)list2.get(n).receiver != broadcastReceiver)
                                    while (true) {
                                        Block_9: {
                                            while (true) {
                                                Block_7: {
                                                    break Block_7;
                                                    list2.remove(n);
                                                    --n;
                                                    break Label_0170;
                                                    while (true) {
                                                        while (true) {
                                                            n = 0;
                                                            continue Block_8_Outer;
                                                            Label_0135: {
                                                                break Block_9;
                                                            }
                                                            intentFilter = list.get(n2);
                                                            n3 = 0;
                                                            break Label_0053;
                                                            action = intentFilter.getAction(n3);
                                                            list2 = mActions.get(action);
                                                            continue Block_4_Outer;
                                                        }
                                                        continue Label_0028_Outer;
                                                    }
                                                }
                                                continue Block_4_Outer;
                                            }
                                            Label_0156: {
                                                return;
                                            }
                                        }
                                        mActions.remove(action);
                                        break Block_8_Outer;
                                        continue Label_0053_Outer;
                                    }
                                }
                                // iftrue(Label_0156:, n2 >= list.size())
                            }
                            n2 = 0;
                            continue Label_0028;
                        }
                        ++n;
                        continue Label_0053_Outer;
                    }
                    ++n3;
                    continue Label_0053;
                }
                Label_0182: {
                    ++n2;
                }
                continue Label_0028;
            }
        }
    }
}
