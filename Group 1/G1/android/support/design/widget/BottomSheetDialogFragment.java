package android.support.design.widget;

import android.content.Context;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment
{
    public BottomSheetDialogFragment() {
        super();
    }
    
    @Override
    public Dialog onCreateDialog(final Bundle bundle) {
        return new BottomSheetDialog((Context)this.getActivity(), this.getTheme());
    }
}
