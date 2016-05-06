package android.support.v7.app;

import android.content.DialogInterface$OnKeyListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.database.Cursor;
import android.widget.ListAdapter;
import android.view.ContextThemeWrapper;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.os.Message;
import android.content.DialogInterface$OnClickListener;
import android.view.KeyEvent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialog extends AppCompatDialog implements DialogInterface
{
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    private AlertController mAlert;
    
    protected AlertDialog(final Context context) {
        this(context, resolveDialogTheme(context, 0), true);
    }
    
    protected AlertDialog(final Context context, final int n) {
        this(context, n, true);
    }
    
    AlertDialog(final Context context, final int n, final boolean b) {
        super(context, resolveDialogTheme(context, n));
        mAlert = new AlertController(this.getContext(), this, this.getWindow());
    }
    
    protected AlertDialog(final Context context, final boolean cancelable, final DialogInterface$OnCancelListener onCancelListener) {
        super(context, resolveDialogTheme(context, 0));
        this.setCancelable(cancelable);
        this.setOnCancelListener(onCancelListener);
        mAlert = new AlertController(context, this, this.getWindow());
    }
    
    static /* synthetic */ AlertController access$000(final AlertDialog alertDialog) {
        return alertDialog.mAlert;
    }
    
    static int resolveDialogTheme(final Context context, final int n) {
        if (n >= 16777216) {
            return n;
        }
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }
    
    public Button getButton(final int n) {
        return mAlert.getButton(n);
    }
    
    public ListView getListView() {
        return mAlert.getListView();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        mAlert.installContent();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return mAlert.onKeyDown(n, keyEvent) || super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        return mAlert.onKeyUp(n, keyEvent) || super.onKeyUp(n, keyEvent);
    }
    
    public void setButton(final int n, final CharSequence charSequence, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        mAlert.setButton(n, charSequence, dialogInterface$OnClickListener, null);
    }
    
    public void setButton(final int n, final CharSequence charSequence, final Message message) {
        mAlert.setButton(n, charSequence, null, message);
    }
    
    void setButtonPanelLayoutHint(final int buttonPanelLayoutHint) {
        mAlert.setButtonPanelLayoutHint(buttonPanelLayoutHint);
    }
    
    public void setCustomTitle(final View customTitle) {
        mAlert.setCustomTitle(customTitle);
    }
    
    public void setIcon(final int icon) {
        mAlert.setIcon(icon);
    }
    
    public void setIcon(final Drawable icon) {
        mAlert.setIcon(icon);
    }
    
    public void setIconAttribute(final int n) {
        final TypedValue typedValue = new TypedValue();
        this.getContext().getTheme().resolveAttribute(n, typedValue, true);
        mAlert.setIcon(typedValue.resourceId);
    }
    
    public void setMessage(final CharSequence message) {
        mAlert.setMessage(message);
    }
    
    @Override
    public void setTitle(final CharSequence charSequence) {
        super.setTitle(charSequence);
        mAlert.setTitle(charSequence);
    }
    
    public void setView(final View view) {
        mAlert.setView(view);
    }
    
    public void setView(final View view, final int n, final int n2, final int n3, final int n4) {
        mAlert.setView(view, n, n2, n3, n4);
    }
}
