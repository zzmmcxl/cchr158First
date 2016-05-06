package android.support.v4.media.session;

import android.os.ResultReceiver;
import android.os.Bundle;

private static final class Command
{
    public final String command;
    public final Bundle extras;
    public final ResultReceiver stub;
    
    public Command(final String command, final Bundle extras, final ResultReceiver stub) {
        super();
        this.command = command;
        this.extras = extras;
        this.stub = stub;
    }
}
