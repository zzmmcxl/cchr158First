package android.support.v4.app;

import android.support.v4.content.ContextCompat;
import java.util.Iterator;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.app.Activity;
import android.content.ComponentName;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.ArrayList;
import android.content.Intent;

public final class TaskStackBuilder implements Iterable<Intent>
{
    private static final TaskStackBuilderImpl IMPL;
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (TaskStackBuilderImpl)new TaskStackBuilderImplHoneycomb();
            return;
        }
        IMPL = (TaskStackBuilderImpl)new TaskStackBuilderImplBase();
    }
    
    private TaskStackBuilder(final Context mSourceContext) {
        super();
        mIntents = new ArrayList<Intent>();
        mSourceContext = mSourceContext;
    }
    
    public static TaskStackBuilder create(final Context context) {
        return new TaskStackBuilder(context);
    }
    
    public static TaskStackBuilder from(final Context context) {
        return create(context);
    }
    
    public TaskStackBuilder addNextIntent(final Intent intent) {
        mIntents.add(intent);
        return this;
    }
    
    public TaskStackBuilder addNextIntentWithParentStack(final Intent intent) {
        ComponentName componentName = intent.getComponent();
        if (componentName == null) {
            componentName = intent.resolveActivity(mSourceContext.getPackageManager());
        }
        if (componentName != null) {
            this.addParentStack(componentName);
        }
        this.addNextIntent(intent);
        return this;
    }
    
    public TaskStackBuilder addParentStack(final Activity activity) {
        final boolean b = activity instanceof SupportParentable;
        Intent intent = null;
        if (b) {
            intent = ((SupportParentable)activity).getSupportParentActivityIntent();
        }
        if (intent == null) {
            intent = NavUtils.getParentActivityIntent(activity);
        }
        if (intent != null) {
            ComponentName componentName = intent.getComponent();
            if (componentName == null) {
                componentName = intent.resolveActivity(mSourceContext.getPackageManager());
            }
            this.addParentStack(componentName);
            this.addNextIntent(intent);
        }
        return this;
    }
    
    public TaskStackBuilder addParentStack(final ComponentName componentName) {
        final int size = mIntents.size();
        try {
            for (Intent intent = NavUtils.getParentActivityIntent(mSourceContext, componentName); intent != null; intent = NavUtils.getParentActivityIntent(mSourceContext, intent.getComponent())) {
                mIntents.add(size, intent);
            }
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException((Throwable)ex);
        }
        return this;
    }
    
    public TaskStackBuilder addParentStack(final Class<?> clazz) {
        return this.addParentStack(new ComponentName(mSourceContext, (Class)clazz));
    }
    
    public Intent editIntentAt(final int n) {
        return mIntents.get(n);
    }
    
    public Intent getIntent(final int n) {
        return this.editIntentAt(n);
    }
    
    public int getIntentCount() {
        return mIntents.size();
    }
    
    public Intent[] getIntents() {
        final Intent[] array = new Intent[mIntents.size()];
        if (array.length != 0) {
            array[0] = new Intent((Intent)mIntents.get(0)).addFlags(268484608);
            for (int i = 1; i < array.length; ++i) {
                array[i] = new Intent((Intent)mIntents.get(i));
            }
        }
        return array;
    }
    
    public PendingIntent getPendingIntent(final int n, final int n2) {
        return this.getPendingIntent(n, n2, null);
    }
    
    public PendingIntent getPendingIntent(final int n, final int n2, final Bundle bundle) {
        if (mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        final Intent[] array = (Intent[])mIntents.<Intent>toArray(new Intent[mIntents.size()]);
        array[0] = new Intent(array[0]).addFlags(268484608);
        return IMPL.getPendingIntent(mSourceContext, array, n, n2, bundle);
    }
    
    @Override
    public Iterator<Intent> iterator() {
        return mIntents.iterator();
    }
    
    public void startActivities() {
        this.startActivities(null);
    }
    
    public void startActivities(final Bundle bundle) {
        if (mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        final Intent[] array = (Intent[])mIntents.<Intent>toArray(new Intent[mIntents.size()]);
        array[0] = new Intent(array[0]).addFlags(268484608);
        if (!ContextCompat.startActivities(mSourceContext, array, bundle)) {
            final Intent intent = new Intent(array[-1 + array.length]);
            intent.addFlags(268435456);
            mSourceContext.startActivity(intent);
        }
    }
}
