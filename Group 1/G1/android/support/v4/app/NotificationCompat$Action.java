package android.support.v4.app;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.PendingIntent;

public static class Action extends NotificationCompatBase.Action
{
    public static final Factory FACTORY;
    public PendingIntent actionIntent;
    public int icon;
    private final Bundle mExtras;
    private final RemoteInput[] mRemoteInputs;
    public CharSequence title;
    
    static {
        FACTORY = new Factory() {
            NotificationCompat$Action$1() {
                super();
            }
            
            public NotificationCompat.Action build(final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle, final RemoteInputCompatBase.RemoteInput[] array) {
                return new NotificationCompat.Action(n, charSequence, pendingIntent, bundle, (RemoteInput[])array);
            }
            
            @Override
            public /* bridge */ NotificationCompatBase.Action build(final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle, final RemoteInputCompatBase.RemoteInput[] array) {
                return this.build(n, charSequence, pendingIntent, bundle, array);
            }
            
            public NotificationCompat.Action[] newArray(final int n) {
                return new NotificationCompat.Action[n];
            }
            
            @Override
            public /* bridge */ NotificationCompatBase.Action[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public Action(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
        this(n, charSequence, pendingIntent, new Bundle(), null);
    }
    
    private Action(final int icon, final CharSequence charSequence, final PendingIntent actionIntent, Bundle mExtras, final RemoteInput[] mRemoteInputs) {
        super();
        this.icon = icon;
        this.title = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = actionIntent;
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        this.mExtras = mExtras;
        this.mRemoteInputs = mRemoteInputs;
    }
    
    Action(final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle, final RemoteInput[] array, final NotificationCompat$1 object) {
        this(n, charSequence, pendingIntent, bundle, array);
    }
    
    static /* synthetic */ Bundle access$300(final Action action) {
        return action.mExtras;
    }
    
    @Override
    public PendingIntent getActionIntent() {
        return actionIntent;
    }
    
    @Override
    public Bundle getExtras() {
        return mExtras;
    }
    
    @Override
    public int getIcon() {
        return icon;
    }
    
    public RemoteInput[] getRemoteInputs() {
        return mRemoteInputs;
    }
    
    @Override
    public /* bridge */ RemoteInputCompatBase.RemoteInput[] getRemoteInputs() {
        return this.getRemoteInputs();
    }
    
    @Override
    public CharSequence getTitle() {
        return title;
    }
}
