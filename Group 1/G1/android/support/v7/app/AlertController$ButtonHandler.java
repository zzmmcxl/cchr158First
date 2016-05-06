package android.support.v7.app;

import android.content.DialogInterface$OnClickListener;
import android.os.Message;
import android.content.DialogInterface;
import java.lang.ref.WeakReference;
import android.os.Handler;

private static final class ButtonHandler extends Handler
{
    private static final int MSG_DISMISS_DIALOG = 1;
    private WeakReference<DialogInterface> mDialog;
    
    public ButtonHandler(final DialogInterface dialogInterface) {
        super();
        this.mDialog = new WeakReference<DialogInterface>(dialogInterface);
    }
    
    public void handleMessage(final Message message) {
        switch (message.what) {
            default:
            case -3:
            case -2:
            case -1:
                ((DialogInterface$OnClickListener)message.obj).onClick((DialogInterface)mDialog.get(), message.what);
            case 1:
                ((DialogInterface)message.obj).dismiss();
        }
    }
}
